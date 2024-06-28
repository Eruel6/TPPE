package tppe;

import static org.junit.Assert.*;

import org.junit.Test;

public class ClientePadraoTest {

	@Test
	public void cadastrarClienteEspecial() {
        Cliente cliente = new ClientePadrao("Maria", "Sudeste", false);
        assertNotNull(cliente);
    }


	@Test 
	public void calculaDescontoEspecial() {
		Cliente cliente = new ClientePadrao("Marcia", "Sudeste", false);
		float valorSemDesconto = cliente.calcularDesconto(100.0f, false);
		assertEquals(100.0f, valorSemDesconto, 0.01);
}

	@Test
	public void calculaFreteEspecial() {
		Cliente cliente = new ClientePadrao("Joao", "Norte", true); 
		float freteSemDesconto = cliente.calcularFrete(45);
		assertEquals(45.0f,freteSemDesconto,0.01);
		
	}

}
