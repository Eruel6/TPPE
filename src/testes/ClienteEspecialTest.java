package testes;

import static org.junit.Assert.*;

import org.junit.Test;

import tppe.Cliente;
import tppe.ClienteEspecial;

public class ClienteEspecialTest {

	@Test
		public void cadastrarClienteEspecial() {
	        Cliente cliente = new ClienteEspecial("Maria", "BA", false);
	        assertNotNull(cliente);
	    }
	

	@Test 
		public void calculaDescontoEspecial() {
			Cliente cliente = new ClienteEspecial("Marcia", "GO", false);
			float valorComDesconto = cliente.calcularDesconto(100.0f, false);
			assertEquals(90.0f, valorComDesconto, 0.01);
	}
	
	@Test
		public void calculaFreteEspecial() {
			Cliente cliente = new ClienteEspecial("Joao", "AM", true); 
				float freteComDesconto = cliente.calcularFrete(45.0f);
				assertEquals(31.5f,freteComDesconto,0.01);
			
		}
	
}