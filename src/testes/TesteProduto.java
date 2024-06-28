package testes;

import static org.junit.Assert.*;
import org.junit.Test;

import tppe.Produto;

public class TesteProduto {
    @Test
    public void deveCadastrarProduto() {
        Produto produto = new Produto(1, "Camiseta", 50.0f, "unidade");
        assertNotNull(produto);
    }
    
}

