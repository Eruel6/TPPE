package tppe;

public class Venda {
	
	private Cliente cliente;
	private Produto produto;
	private int quantidade;
	private float valorFreteBase;
	private String data;
	
	public Venda(Cliente cliente, Produto produto, int quantidade, float valorFreteBase, String data) {
		this.cliente = cliente;
		this.produto = produto;
		this.quantidade = quantidade;
		this.valorFreteBase = valorFreteBase;
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

	public float getValorFreteBase() {
		return valorFreteBase;
	}

	public void setValorFreteBase(float valorFreteBase) {
		this.valorFreteBase = valorFreteBase;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}
	
	public Venda realizarVenda() {
        float valorTotalProdutosIP = 0;
        float valorTotalProdutos = this.produto.getValor() * this.quantidade;
        float desconto = 0.0f;
        float frete = 0.0f;
        float ICMS = this.cliente.getEstado().equals("Distrito Federal") ? 0.18f : 0.12f;
        float impostoMunicipal = this.cliente.getEstado().equals("Distrito Federal") ? 0.0f : 0.04f;
        float valorTotal = 0;
        
        //venda para diferentes tipos de clientes
        if (this.cliente instanceof ClientePrime) {
        	desconto = this.cliente.calcularDesconto(valorTotalProdutos,true);
        	frete = this.cliente.calcularFrete(this.valorFreteBase);
        	((ClientePrime) this.cliente).acumularCashback(valorTotalProdutos, true);
        	((ClientePrime) this.cliente).usarCashback(valorTotalProdutos);
        	
        }else if(this.cliente instanceof ClienteEspecial) {
        	desconto = this.cliente.calcularDesconto(valorTotalProdutos, true);
        	frete = this.cliente.calcularFrete(this.valorFreteBase);
        	
        }else {
        	desconto = this.cliente.calcularDesconto(valorTotalProdutos, false);
        	frete = this.cliente.calcularFrete(this.valorFreteBase);
        }
        
       
        
        float valorProdutoComImpostos = this.produto.getValor() + (this.produto.getValor() * ICMS )+ (this.produto.getValor() * impostoMunicipal);
        valorTotalProdutosIP = valorProdutoComImpostos * this.quantidade;
        valorTotal = valorTotalProdutosIP - desconto + frete;
        
        System.out.println("------- Nota Fiscal ----------");
        System.out.println("------- Valor Total dos Produtos sem imposto ----------");
        System.out.println(this.produto.getCodigoItem()+" x "+this.quantidade+" --> "+valorTotalProdutos);
        System.out.println("------- Valor Total dos Produtos com Imposto ----------");
        System.out.println(this.produto.getCodigoItem()+" x "+this.quantidade+" --> "+valorTotalProdutosIP);
        System.out.println("------- Impostoso Aplicados -----------");
        System.out.println("ICMS total : "+ICMS*this.produto.getValor()*this.quantidade);
        System.out.println("Imposto Municipal total : "+ impostoMunicipal*this.produto.getValor()*this.quantidade);
        System.out.println("------- Descontos Aplicados ---------------");
        System.out.println("Desconto: "+desconto);
        System.out.println("------- Valor Frete -----------------");
        System.out.println("Frete: "+frete);
        System.out.println("------- Valor Total da Venda ----------");
        System.out.println("Valor Total: "+valorTotal);
        
        return this;
    }

}
