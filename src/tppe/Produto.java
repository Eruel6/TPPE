package tppe;

public class Produto {

	private CodigoItem codigoItem;
	private DescricaoItem descricao;
	private PrecoItem valor;
	private UnidadeMedida unidade;
	
	public Produto(CodigoItem codigoItem, DescricaoItem descricao, PrecoItem valor, UnidadeMedida unidade) {
        this.codigoItem = codigoItem;
        this.descricao = descricao;
        this.valor = valor;
        this.unidade = unidade;
    }
	
	//getters and setter para os campos da classe
	
	public CodigoItem getCodigoItem() {
		return codigoItem;
	}
	public void setCodigoItem(CodigoItem codigoItem) {
		this.codigoItem = codigoItem;
	}
	public DescricaoItem getDescricao() {
		return descricao;
	}
	public void setDescricao(DescricaoItem descricao) {
		this.descricao = descricao;
	}
	public PrecoItem getPreco() {
		return valor;
	}
	public void setPreco(PrecoItem valor) {
		this.valor = valor;
	}
	public UnidadeMedida getUnidade() {
		return unidade;
	}
	public void setUnidade(UnidadeMedida unidade) {
		this.unidade = unidade;
	}

}
