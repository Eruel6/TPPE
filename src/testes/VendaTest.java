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
import tppe.Produto;
import tppe.Venda;

@RunWith(Parameterized.class)
public class VendaTest {

    @Parameters(name = "{index}: Test with cliente={0}, produto={1}, quantidade={2}, valorFreteBase={3}, data={4}, valorTotalEsperado={5}")
    public static Collection<Object[]> data() {
        Produto produto1 = new Produto(01, "Produto 1", 100.0f,"Kg");
        Produto produto2 = new Produto(02, "Produto 2", 200.0f,"Metro");

        return Arrays.asList(new Object[][] {
            { new ClientePrime("Pedro", "Distrito Federal", true), produto1, 2, 10.0f, "2023-06-28", 196.0f },
            { new ClienteEspecial("Maria", "Sudeste", false), produto2, 1, 15.0f, "2023-06-28", 202.5f },
            { new ClientePadrao("Joao", "Norte", true), produto1, 3, 20.0f, "2023-06-28", 368.0f },
            { new ClientePrime("Ana", "Nordeste", true), produto2, 2, 10.0f, "2023-06-28", 384.0f },
            { new ClienteEspecial("Carlos", "Distrito Federal", false), produto1, 1, 5.0f, "2023-06-28", 101.5f },
            { new ClientePadrao("Lucas", "Sul", false), produto2, 3, 25.0f, "2023-06-28", 721.0f }
        });
    }

    private Cliente cliente;
    private Produto produto;
    private int quantidade;
    private float valorFreteBase;
    private String data;
    private float valorTotalEsperado;

    public VendaTest(Cliente cliente, Produto produto, int quantidade, float valorFreteBase, String data, float valorTotalEsperado) {
        this.cliente = cliente;
        this.produto = produto;
        this.quantidade = quantidade;
        this.valorFreteBase = valorFreteBase;
        this.data = data;
        this.valorTotalEsperado = valorTotalEsperado;
    }

    @Test
    public void testarVenda() {
        Venda venda = new Venda(cliente, produto, quantidade, valorFreteBase, data);
        venda.realizarVenda();

        float valorTotalProdutos = produto.getValor() * quantidade;
        float desconto = cliente.calcularDesconto(valorTotalProdutos, cliente instanceof ClientePrime || cliente instanceof ClienteEspecial);
        float frete = cliente.calcularFrete(valorFreteBase);
        float ICMS = cliente.getEstado().equals("Distrito Federal") ? 0.18f : 0.12f;
        float impostoMunicipal = cliente.getEstado().equals("Distrito Federal") ? 0.0f : 0.04f;
        float valorUnitario = produto.getValor() * (1 + ICMS + impostoMunicipal);
        float valorTotalProdutosIP = valorUnitario * quantidade;
        float valorTotal = valorTotalProdutosIP - desconto + frete;

        assertEquals(valorTotalEsperado, valorTotal, 0.01);
    }
}

