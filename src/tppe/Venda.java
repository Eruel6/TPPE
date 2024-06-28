package tppe;

public class Venda {
	
	public float realizarVenda(Cliente cliente, Produto produto, int quantidade, float valorFreteBase) {
        float valorTotalProdutos = produto.getValor() * quantidade;
        float desconto = 0.0f;
        float frete = 0.0f;
        
        //venda para diferentes tipos de clientes
        if (cliente instanceof ClientePrime) {
        	desconto = cliente.calcularDesconto(valorTotalProdutos,true);
        	frete = cliente.calcularFrete(valorFreteBase);
        	((ClientePrime) cliente).acumularCashback(valorTotalProdutos, true);
        	((ClientePrime) cliente).usarCashback(valorTotalProdutos);
        	
        }else if(cliente instanceof ClienteEspecial) {
        	desconto = cliente.calcularDesconto(valorTotalProdutos, true);
        	frete = cliente.calcularFrete(valorFreteBase);
        	
        }else {
        	desconto = cliente.calcularDesconto(valorTotalProdutos, false);
        	frete = cliente.calcularFrete(valorFreteBase);
        }
        
        float valorTotal = valorTotalProdutos - desconto + frete;
        return valorTotal;
    }

    public static void main(String[] args) {
     
    	Cliente clienteP = new ClientePadrao("Joao","BA",false);
    	Cliente clienteE = new ClienteEspecial("Carlos","GO",false);
    	Cliente clientePr = new ClientePrime("Epamenondas","PB",false);
    	
        Produto produto = new Produto(123, "Produto A", 10.0f, "unidade");

        Venda venda = new Venda();
        int quantidade = 5;
        float valorVenda = venda.realizarVenda(clienteP, produto, quantidade, 50.0f);

        System.out.println("Valor da venda: " + valorVenda);
    }
}
