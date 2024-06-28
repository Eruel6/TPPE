package testes;

import static org.junit.Assert.*;

import org.junit.Test;

import tppe.Cliente;
import tppe.ClientePadrao;

public class ClientePadraoTest {

	@Test
	public void cadastrarClienteEspecial() {
        Cliente cliente = new ClientePadrao("Maria", "BA", false);
        assertNotNull(cliente);
    }


	@Test 
	public void calculaDescontoEspecial() {
		Cliente cliente = new ClientePadrao("Marcia", "GO", false);
		float valorSemDesconto = cliente.calcularDesconto(100.0f, false);
		assertEquals(100.0f, valorSemDesconto, 0.01);
}

	@Test
	public void calculaFreteEspecial() {
		Cliente cliente = new ClientePadrao("Joao", "AM", true); 
		float freteSemDesconto = cliente.calcularFrete(45);
		assertEquals(45.0f,freteSemDesconto,0.01);
		
	}

}
