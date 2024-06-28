package tppe;

public class ClienteEspecial extends Cliente{

	public ClienteEspecial(String nome, String endereco, boolean interior) {
		super (nome,endereco,interior);
	}
	
	public float calcularDesconto(float valorTotal, boolean usandoCartaoLoja) {
		float desconto = valorTotal * 0.10f;
		if(usandoCartaoLoja == true) {
			desconto += valorTotal *0.10f;
		}
		return valorTotal - desconto;
	}
	
	public float calcularFrete(float valorFreteBase) {
		
		return valorFreteBase * 0.70f;
		
	}
	
}
