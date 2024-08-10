package testes;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import tppe.DescricaoItem;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class DescricaoItemTest {

    private final String descricao;
    private final boolean valid;

    public DescricaoItemTest(String descricao, boolean valid) {
        this.descricao = descricao;
        this.valid = valid;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
            {"Produto A", true},
            {"", false},
            {null, false} 
        });
    }

    @Test
    public void testDescricao() {
        if (!valid) {
            try {
                new DescricaoItem(descricao);
                assertEquals("Expected IllegalArgumentException", 1, 0);
            } catch (IllegalArgumentException e) {
            	//Utilizando try/catch para capturar a excessão lançada na classe base
            }
        } else {
            DescricaoItem desc = new DescricaoItem(descricao);
            assertEquals(descricao, desc.getDescricao());
        }
    }
}
