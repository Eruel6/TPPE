package testes;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import tppe.PrecoItem;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class PrecoItemTest {

    private final float valor;
    private final String expectedString;

    public PrecoItemTest(float valor, String expectedString) {
        this.valor = valor;
        this.expectedString = expectedString;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
            {10.0f, "R$ 10,00"},
            {0.0f, "R$ 0,00"},
            {99.99f, "R$ 99,99"},
            {-5.0f, "Exception"}
        });
    }

    @Test
    public void testPreco() {
        if ("Exception".equals(expectedString)) {
            try {
                new PrecoItem(valor);
                assertEquals("Expected IllegalArgumentException", 1, 0);
            } catch (IllegalArgumentException e) {
            }
        } else {
            PrecoItem preco = new PrecoItem(valor);
            assertEquals(expectedString, preco.toString());
        }
    }
}