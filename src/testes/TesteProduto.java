package testes;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import tppe.CodigoItem;
import tppe.DescricaoItem;
import tppe.PrecoItem;
import tppe.Produto;
import tppe.UnidadeMedida;


@RunWith(Parameterized.class)
public class TesteProduto {

    @Parameters(name = "{index}: Test with codigoItem={0}, descricao={1}, valor={2}, unidade={3}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
            { new CodigoItem(1), new DescricaoItem("Camiseta"), new PrecoItem(50.0f), UnidadeMedida.UNIDADE },
            { new CodigoItem(2), new DescricaoItem("Calça"), new PrecoItem(100.0f), UnidadeMedida.UNIDADE },
            { new CodigoItem(3), new DescricaoItem("Sapato"), new PrecoItem(150.0f), UnidadeMedida.UNIDADE },
            { new CodigoItem(4), new DescricaoItem("Chapéu"), new PrecoItem(75.0f), UnidadeMedida.UNIDADE },
            { new CodigoItem(5), new DescricaoItem("Meias"), new PrecoItem(20.0f), UnidadeMedida.UNIDADE }
        });
    }

    private CodigoItem codigoItem;
    private DescricaoItem descricao;
    private PrecoItem valor;
    private UnidadeMedida unidade;

    public TesteProduto(CodigoItem codigoItem, DescricaoItem descricao, PrecoItem valor, UnidadeMedida unidade) {
        this.codigoItem = codigoItem;
        this.descricao = descricao;
        this.valor = valor;
        this.unidade = unidade;
    }

    @Test
    public void deveCadastrarProduto() {
        Produto produto = new Produto(codigoItem, descricao, valor, UnidadeMedida.UNIDADE);
        assertNotNull(produto);
        assertEquals(codigoItem, produto.getCodigoItem());
        assertEquals(descricao, produto.getDescricao());
        assertEquals(valor, produto.getPreco());
        assertEquals(unidade, produto.getUnidade());
    }
}


