package testes;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import tppe.Produto;

@RunWith(Parameterized.class)
public class TesteProduto {

    @Parameters(name = "{index}: Test with codigoItem={0}, descricao={1}, valor={2}, unidade={3}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
            { 1, "Camiseta", 50.0f, "unidade" },
            { 2, "Calça", 100.0f, "unidade" },
            { 3, "Sapato", 150.0f, "par" },
            { 4, "Chapéu", 75.0f, "unidade" },
            { 5, "Meias", 20.0f, "par" }
        });
    }

    private int codigoItem;
    private String descricao;
    private float valor;
    private String unidade;

    public TesteProduto(int codigoItem, String descricao, float valor, String unidade) {
        this.codigoItem = codigoItem;
        this.descricao = descricao;
        this.valor = valor;
        this.unidade = unidade;
    }

    @Test
    public void deveCadastrarProduto() {
        Produto produto = new Produto(codigoItem, descricao, valor, unidade);
        assertNotNull(produto);
        assertEquals(codigoItem, produto.getCodigoItem());
        assertEquals(descricao, produto.getDescricao());
        assertEquals(valor, produto.getValor(), 0.01);
        assertEquals(unidade, produto.getUnidade());
    }
}


