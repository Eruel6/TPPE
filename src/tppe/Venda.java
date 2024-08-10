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
	        ProcessaVenda processor = new ProcessaVenda(this);
	        processor.processarVenda();
	        return this;
	    }

}
