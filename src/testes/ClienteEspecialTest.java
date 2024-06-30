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

@RunWith(Parameterized.class)
public class ClienteEspecialTest {

    @Parameters(name = "{index}: Test with nome={0}, estado={1}, interior={2}, valorTotal={3}, usandoCartaoDaLoja={4}, valorEsperadoDesconto={5}, valorEsperadoFrete={6}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
            // Teste para cadastro de cliente, calcular desconto e calcular frete
            { "Maria", "Sudeste", false, 100.0f, false, 10.0f, 4.9f },
            { "Marcia", "Nordeste", false, 200.0f, true, 40.0f, 10.5f },
            { "Joao", "Norte", true, 150.0f, false, 15.0f, 17.5f }
        });
    }

    private String nome;
    private String estado;
    private boolean interior;
    private float valorTotal;
    private boolean usandoCartaoDaLoja;
    private float valorEsperadoDesconto;
    private float valorEsperadoFrete;

    public ClienteEspecialTest(String nome, String estado, boolean interior, float valorTotal, boolean usandoCartaoDaLoja, float valorEsperadoDesconto,float valorEsperadoFrete) {
        this.nome = nome;
        this.estado = estado;
        this.interior = interior;
        this.valorTotal = valorTotal;
        this.usandoCartaoDaLoja = usandoCartaoDaLoja;
        this.valorEsperadoDesconto = valorEsperadoDesconto;
        this.valorEsperadoFrete = valorEsperadoFrete;
    }

    @Test
    public void cadastrarClienteEspecial() {
        Cliente cliente = new ClienteEspecial(nome, estado, interior);
        assertNotNull(cliente);
    }

    @Test
    public void calculaDescontoEspecial() {
        Cliente cliente = new ClienteEspecial(nome, estado, interior);
        float valorComDesconto = cliente.calcularDesconto(valorTotal, usandoCartaoDaLoja);
        assertEquals(valorEsperadoDesconto, valorComDesconto, 0.01);
    }

    @Test
    public void calculaFreteEspecial() {
        Cliente cliente = new ClienteEspecial(nome, estado, interior);
        float freteComDesconto = cliente.getFrete(cliente.getEstado(),cliente.getInterior());
        assertEquals(valorEsperadoFrete, freteComDesconto, 0.01);
    }
}
