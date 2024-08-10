package testes;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import tppe.Cliente;
import tppe.ClienteEspecial;
import tppe.ClientePadrao;
import tppe.ClientePrime;
import tppe.CodigoItem;
import tppe.DescricaoItem;
import tppe.Produto;
import tppe.Venda;
import tppe.*;

@RunWith(Parameterized.class)
public class VendaTest {

    @Parameters(name = "{index}: Test with cliente={0}, produto={1}, quantidade={2}, data={3}, valorTotalEsperado={4}")
    public static Collection<Object[]> data() {
        Produto produto1 = new Produto(new CodigoItem(01),new DescricaoItem("Produto 01"),new PrecoItem(100.0f), UnidadeMedida.QUILOGRAMA);
        Produto produto2 = new Produto(new CodigoItem(02),new DescricaoItem("Produto 02"),new PrecoItem(200.0f),UnidadeMedida.METRO);

        return Arrays.asList(new Object[][] {
            { new ClientePrime("Pedro", "Distrito Federal", true), produto1, 2, "2023-06-28", 196.0f },
            { new ClienteEspecial("Maria", "Sudeste", false), produto2, 1, "2023-06-28", 196.9f },
            { new ClientePadrao("Joao", "Norte", true), produto1, 3, "2023-06-28", 373.0f },
            { new ClientePrime("Ana", "Nordeste", true), produto2, 2, "2023-06-28", 384.0f },
            { new ClienteEspecial("Carlos", "Distrito Federal", false), produto1, 1, "2023-06-28", 101.5f },
            { new ClientePadrao("Lucas", "Sul", false), produto2, 3, "2023-06-28", 706.0f }
        });
    }

    private Cliente cliente;
    private Produto produto;
    private int quantidade;
    private String data;
    private float valorTotalEsperado;

    public VendaTest(Cliente cliente, Produto produto, int quantidade, String data, float valorTotalEsperado) {
        this.cliente = cliente;
        this.produto = produto;
        this.quantidade = quantidade;
        this.data = data;
        this.valorTotalEsperado = valorTotalEsperado;
    }

    @Test
    public void testarVenda() {
        Venda venda = new Venda(cliente, produto, quantidade, data);
        venda.realizarVenda();

        float valorTotalProdutos = produto.getPreco().getValor() * quantidade;
        float desconto = cliente.calcularDesconto(valorTotalProdutos, cliente instanceof ClientePrime || cliente instanceof ClienteEspecial);
        float frete = cliente.getFrete(cliente.getEstado(),cliente.getInterior());
        float ICMS = cliente.getEstado().equals("Distrito Federal") ? 0.18f : 0.12f;
        float impostoMunicipal = cliente.getEstado().equals("Distrito Federal") ? 0.0f : 0.04f;
        float valorUnitario = produto.getPreco().getValor() * (1 + ICMS + impostoMunicipal);
        float valorTotalProdutosIP = valorUnitario * quantidade;
        float valorTotal = valorTotalProdutosIP - desconto + frete;

        assertEquals(valorTotalEsperado, valorTotal, 0.01);
    }
}

