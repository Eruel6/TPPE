package tppe;

public class Produto {

	private int codigoItem;
	private String descricao;
	private float valor;
	private String unidade;
	
	public Produto(int codigoItem, String descricao, float valor, String unidade) {
        this.codigoItem = codigoItem;
        this.descricao = descricao;
        this.valor = valor;
        this.unidade = unidade;
    }
	
	//getters and setter para os campos da classe
	
	public int getCodigoItem() {
		return codigoItem;
	}
	public void setCodigoItem(int codigoItem) {
		this.codigoItem = codigoItem;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public float getValor() {
		return valor;
	}
	public void setValor(float valor) {
		this.valor = valor;
	}
	public String getUnidade() {
		return unidade;
	}
	public void setUnidade(String unidade) {
		this.unidade = unidade;
	}

}
