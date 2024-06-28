package tppe;

import static org.junit.Assert.*;

import org.junit.Test;

public class ClientePrimeTest {

	@Test
    public void deveCadastrarClientePrime() {
        Cliente cliente = new ClientePrime("Pedro", "Sudeste", true);
        assertNotNull(cliente);
    }
	
	@Test
    public void clientePrimeDeveAcumularEUsarCashback() {
        ClientePrime cliente = new ClientePrime("Pedro", "Sudeste", true);
        cliente.acumularCashback(100.0f, false);
        assertEquals(3.0f, cliente.getSaldoCashback(), 0.01);//primeira compra sem cartao

        cliente.acumularCashback(100.0f, true);
        assertEquals(8.0f, cliente.getSaldoCashback(), 0.01);//acumula da primeira mais segunda compra com cartao

        cliente.usarCashback(5.0f);
        assertEquals(3.0f, cliente.getSaldoCashback(), 0.01);
    }

}
