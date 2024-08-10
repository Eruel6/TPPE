package testes;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import tppe.CodigoItem;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

@RunWith(Parameterized.class)
public class CodigoItemTest {

    private final int codigo;
    private final boolean expectedEquals;

    public CodigoItemTest(int codigo, boolean expectedEquals) {
        this.codigo = codigo;
        this.expectedEquals = expectedEquals;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
            {1, true},
            {2, true},
            {-1, false} 
        });
    }

    @Test
    public void testCodigoItem() {
        if (codigo <= 0) {
            try {
                new CodigoItem(codigo);
                fail("Esperava-se uma IllegalArgumentException para código: " + codigo);
            } catch (IllegalArgumentException e) {
                //Utilizando try/catch para capturar a excessão lançada na classe base
            }
        } else {
            CodigoItem codigoItem = new CodigoItem(codigo);
            assertEquals(codigo, codigoItem.getCodigo());
        }
    }
}