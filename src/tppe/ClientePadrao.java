package tppe;

public class ClientePadrao extends Cliente{
	
	public ClientePadrao(String nome, String estado, boolean interior) {
		super(nome,estado,interior);
	}
	
	public float calcularDesconto(float valorTotal, boolean usandoCartaoDaLoja){
		return valorTotal;
	}
	
	public float calcularFrete (float valorFreteBase) {
		return valorFreteBase;
	}
	
}
