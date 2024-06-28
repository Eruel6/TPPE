package tppe;

public abstract class Cliente {

	private String nome;
	private String estado;
	private boolean interior = false;
	
	public Cliente(String nome, String estado, boolean interior) {
		this.nome = nome;
		this.estado = estado;
		this.interior = interior;
	}
	
	public abstract float calcularDesconto(float valorTotal, boolean usandoCartaoDaLoja);

    public abstract float calcularFrete(float valorFreteBase);
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public boolean getInterior() {
		return interior;
	}
	public void setInterior(boolean interior) {
		this.interior = interior;
	}
	
}	
