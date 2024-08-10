package testes;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import tppe.UnidadeMedida;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class UnidadeMedidaTest {

    private final UnidadeMedida unidadeMedida;
    private final String expectedDescricao;

    public UnidadeMedidaTest(UnidadeMedida unidadeMedida, String expectedDescricao) {
        this.unidadeMedida = unidadeMedida;
        this.expectedDescricao = expectedDescricao;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
            {UnidadeMedida.UNIDADE, "Unidade"},
            {UnidadeMedida.LITRO, "Litro"},
            {UnidadeMedida.QUILOGRAMA, "Kg"},
            {UnidadeMedida.METRO, "Metro"}
        });
    }

    @Test
    public void testGetDescricao() {
        assertEquals(expectedDescricao, unidadeMedida.getDescricao());
    }

    @Test
    public void testToString() {
        assertEquals(expectedDescricao, unidadeMedida.toString());
    }
}