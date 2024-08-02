package tppe;

public class Venda {
	
	private Cliente cliente;
	private Produto produto;
	private int quantidade;
	private String data;
	
	public Venda(Cliente cliente, Produto produto, int quantidade, String data) {
		this.cliente = cliente;
		this.produto = produto;
		this.quantidade = quantidade;
		this.data = data;
	}
	
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}
	    
	    public Venda realizarVenda() {
	        float valorTotalProdutos = this.produto.getValor() * this.quantidade;
	        float desconto = calcularDesconto(valorTotalProdutos);
	        float frete = calcularFrete();
	        float valorTotalProdutosIP = calcularValorTotalProdutosComImpostos();
	        float valorTotal = calcularValorTotalVenda(valorTotalProdutosIP, desconto, frete);
	        
	        imprimirNotaFiscal(valorTotalProdutos, valorTotalProdutosIP, desconto, frete, valorTotal);
	        
	        return this;
	    }
	    
	    private float calcularDesconto(float valorTotalProdutos) {
	        if (this.cliente instanceof ClientePrime) {
	            ((ClientePrime) this.cliente).acumularCashback(valorTotalProdutos, true);
	            ((ClientePrime) this.cliente).usarCashback(valorTotalProdutos);
	            return this.cliente.calcularDesconto(valorTotalProdutos, true);
	        } else if (this.cliente instanceof ClienteEspecial) {
	            return this.cliente.calcularDesconto(valorTotalProdutos, true);
	        } else {
	            return this.cliente.calcularDesconto(valorTotalProdutos, false);
	        }
	    }
	    
	    private float calcularFrete() {
	        return this.cliente.getFrete(this.cliente.getEstado(), this.cliente.getInterior());
	    }
	    
	    private float calcularValorTotalProdutosComImpostos() {
	        float ICMS = this.cliente.getEstado().equals("Distrito Federal") ? 0.18f : 0.12f;
	        float impostoMunicipal = this.cliente.getEstado().equals("Distrito Federal") ? 0.0f : 0.04f;
	        float valorProdutoComImpostos = this.produto.getValor() + (this.produto.getValor() * ICMS) + (this.produto.getValor() * impostoMunicipal);
	        return valorProdutoComImpostos * this.quantidade;
	    }
	    
	    private float calcularValorTotalVenda(float valorTotalProdutosIP, float desconto, float frete) {
	        return valorTotalProdutosIP - desconto + frete;
	    }
	    
	    private void imprimirNotaFiscal(float valorTotalProdutos, float valorTotalProdutosIP, float desconto, float frete, float valorTotal) {
	        float ICMS = this.cliente.getEstado().equals("Distrito Federal") ? 0.18f : 0.12f;
	        float impostoMunicipal = this.cliente.getEstado().equals("Distrito Federal") ? 0.0f : 0.04f;
	        
	        System.out.println("------- Nota Fiscal ----------");
	        System.out.println("------- Valor Total dos Produtos sem imposto ----------");
	        System.out.println(this.produto.getCodigoItem() + " x " + this.quantidade + " --> " + valorTotalProdutos);
	        System.out.println("------- Valor Total dos Produtos com Imposto ----------");
	        System.out.println(this.produto.getCodigoItem() + " x " + this.quantidade + " --> " + valorTotalProdutosIP);
	        System.out.println("------- Impostos Aplicados -----------");
	        System.out.println("ICMS total : " + ICMS * this.produto.getValor() * this.quantidade);
	        System.out.println("Imposto Municipal total : " + impostoMunicipal * this.produto.getValor() * this.quantidade);
	        System.out.println("------- Descontos Aplicados ---------------");
	        System.out.println("Desconto: " + desconto);
	        System.out.println("------- Valor Frete -----------------");
	        System.out.println("Frete: " + frete);
	        System.out.println("------- Valor Total da Venda ----------");
	        System.out.println("Valor Total: " + valorTotal);
	    }

}
