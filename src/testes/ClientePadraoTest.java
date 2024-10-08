package testes;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import tppe.Cliente;
import tppe.ClientePadrao;

@RunWith(Parameterized.class)
public class ClientePadraoTest {

    @Parameters(name = "{index}: Test with nome={0}, estado={1}, interior={2}, valorTotal={3}, usandoCartaoDaLoja={4}, valorEsperadoDesconto={5}, valorEsperadoFrete={6}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
            // Teste para cadastro de cliente, calcular desconto e calcular frete
            { "Maria", "Sudeste", false, 100.0f, false, 0.0f, 7.0f },
            { "Marcia", "Nordeste", false, 200.0f, true, 0.0f, 15.0f },
            { "Joao", "Norte", true, 150.0f, false, 0.0f, 25.0f }
        });
    }

    private String nome;
    private String estado;
    private boolean interior;
    private float valorTotal;
    private boolean usandoCartaoDaLoja;
    private float valorEsperadoDesconto;
    private float valorEsperadoFrete;

    public ClientePadraoTest(String nome, String estado, boolean interior, float valorTotal, boolean usandoCartaoDaLoja, float valorEsperadoDesconto, float valorEsperadoFrete) {
        this.nome = nome;
        this.estado = estado;
        this.interior = interior;
        this.valorTotal = valorTotal;
        this.usandoCartaoDaLoja = usandoCartaoDaLoja;
        this.valorEsperadoDesconto = valorEsperadoDesconto;
        this.valorEsperadoFrete = valorEsperadoFrete;
    }

    @Test
    public void cadastrarClientePadrao() {
        Cliente cliente = new ClientePadrao(nome, estado, interior);
        assertNotNull(cliente);
    }

    @Test
    public void calculaDescontoPadrao() {
        Cliente cliente = new ClientePadrao(nome, estado, interior);
        float valorSemDesconto = cliente.calcularDesconto(valorTotal, usandoCartaoDaLoja);
        assertEquals(valorEsperadoDesconto, valorSemDesconto, 0.01);
    }

    @Test
    public void calculaFretePadrao() {
        Cliente cliente = new ClientePadrao(nome, estado, interior);
        float freteSemDesconto = cliente.getFrete(cliente.getEstado(),cliente.getInterior());
        assertEquals(valorEsperadoFrete, freteSemDesconto, 0.01);
    }
}
