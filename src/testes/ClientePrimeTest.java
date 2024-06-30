package testes;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import tppe.Cliente;
import tppe.ClientePrime;

@RunWith(Parameterized.class)
public class ClientePrimeTest {

    @Parameters(name = "{index}: Test with nome={0}, estado={1}, interior={2}, valorTotal={3}, usandoCartaoDaLoja={4}, valorEsperadoDesconto={5}, valorFreteBase={6}, saldoEsperado={7}, cashbackUso={8}, saldoFinalEsperado={9}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
            // Teste para cadastro de cliente, calcular desconto, calcular frete e acumular/usar cashback
            { "Pedro", "Sudeste", true, 100.0f, false, 90.0f, 0.0f, 3.0f, 0.0f, 3.0f },
            { "Ana", "Nordeste", true, 200.0f, true, 160.0f, 0.0f, 10.0f, 7.0f, 3.0f },
            { "Joao", "Norte", false, 150.0f, false, 135.0f, 0.0f, 4.5f, 2.0f, 2.5f }
        });
    }

    private String nome;
    private String estado;
    private boolean interior;
    private float valorTotal;
    private boolean usandoCartaoDaLoja;
    private float valorEsperadoDesconto;
    private float valorFreteBase;
    private float saldoEsperado;
    private float cashbackUso;
    private float saldoFinalEsperado;

    public ClientePrimeTest(String nome, String estado, boolean interior, float valorTotal, boolean usandoCartaoDaLoja, float valorEsperadoDesconto, float valorFreteBase, float saldoEsperado, float cashbackUso, float saldoFinalEsperado) {
        this.nome = nome;
        this.estado = estado;
        this.interior = interior;
        this.valorTotal = valorTotal;
        this.usandoCartaoDaLoja = usandoCartaoDaLoja;
        this.valorEsperadoDesconto = valorEsperadoDesconto;
        this.valorFreteBase = valorFreteBase;
        this.saldoEsperado = saldoEsperado;
        this.cashbackUso = cashbackUso;
        this.saldoFinalEsperado = saldoFinalEsperado;
    }

    @Test
    public void deveCadastrarClientePrime() {
        Cliente cliente = new ClientePrime(nome, estado, interior);
        assertNotNull(cliente);
    }

    @Test
    public void deveCalcularDescontoClientePrime() {
        Cliente cliente = new ClientePrime(nome, estado, interior);
        float valorComDesconto = cliente.calcularDesconto(valorTotal, usandoCartaoDaLoja);
        assertEquals(valorEsperadoDesconto, valorComDesconto, 0.01);
    }

    @Test
    public void deveCalcularFreteClientePrime() {
        Cliente cliente = new ClientePrime(nome, estado, interior);
        float freteComDesconto = cliente.calcularFrete(valorFreteBase);
        assertEquals(0.0f, freteComDesconto, 0.01);
    }

    @Test
    public void clientePrimeDeveAcumularEUsarCashback() {
        ClientePrime cliente = new ClientePrime(nome, estado, interior);
        cliente.acumularCashback(valorTotal, usandoCartaoDaLoja);
        assertEquals(saldoEsperado, cliente.getSaldoCashback(), 0.01);

        cliente.usarCashback(cashbackUso);
        assertEquals(saldoFinalEsperado, cliente.getSaldoCashback(), 0.01);
    }
}
