package testes;

import static org.junit.Assert.*;

import org.junit.Test;

import tppe.Calculator;

public class calculatoTest {
	    @Test
	    public void testAdd() {
	        Calculator calc = new Calculator();
	        assertEquals(5, calc.add(2, 3));
	    }
	}
