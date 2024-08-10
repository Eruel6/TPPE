package testes;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.junit.Assert.assertEquals;

import tppe.*;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class ProcessaVendaTest {

    private Venda venda;
    private float valorTotalEsperado;

    public ProcessaVendaTest(Venda venda, float valorTotalEsperado) {
        this.venda = venda;
        this.valorTotalEsperado = valorTotalEsperado;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
            {
                new Venda(
                    new ClientePadrao("João", "Sul", false),
                    new Produto(new CodigoItem(101), new DescricaoItem("Produto A"), new PrecoItem(200.0f), UnidadeMedida.UNIDADE),
                    3,
                    "2024-08-10"
                ),
                706.0f
            },
            {
                new Venda(
                    new ClientePrime("Maria", "Distrito Federal", false),
                    new Produto(new CodigoItem(102), new DescricaoItem("Produto B"), new PrecoItem(100.0f), UnidadeMedida.UNIDADE),
                    2,
                    "2024-08-10"
                ),
                196.0f 
            },
            {
                new Venda(
                    new ClienteEspecial("Carlos", "Sudeste", false),
                    new Produto(new CodigoItem(103), new DescricaoItem("Produto C"), new PrecoItem(200.0f), UnidadeMedida.UNIDADE),
                    1,
                    "2024-08-10"
                ),
                196.9f 
            },
        });
    }

    @Test
    public void testProcessarVenda() {
        venda.realizarVenda();
        float valorTotal = calcularValorTotal();
        assertEquals(valorTotalEsperado, valorTotal, 0.01f);
    }

    private float calcularValorTotal() {
    	 	Cliente cliente = venda.getCliente();
    	    Produto produto = venda.getProduto();
    	    int quantidade = venda.getQuantidade();

    	    
    	    float valorTotalProdutos = produto.getPreco().getValor() * quantidade;

    	    
    	    boolean usandoCartaoDaLoja = cliente instanceof ClientePrime || cliente instanceof ClienteEspecial;
    	    float desconto = cliente.calcularDesconto(valorTotalProdutos, usandoCartaoDaLoja);

    	    
    	    float frete = cliente.getFrete(cliente.getEstado(), cliente.getInterior());

    	    
    	    float ICMS = cliente.getEstado().equals("Distrito Federal") ? 0.18f : 0.12f;
    	    float impostoMunicipal = cliente.getEstado().equals("Distrito Federal") ? 0.0f : 0.04f;
    	    float valorProdutoComImpostos = produto.getPreco().getValor() + (produto.getPreco().getValor() * ICMS) + (produto.getPreco().getValor() * impostoMunicipal);
    	    float valorTotalProdutosIP = valorProdutoComImpostos * quantidade;
    	    float valorTotal = valorTotalProdutosIP - desconto + frete;
        
    	    return valorTotal;
    }
}
