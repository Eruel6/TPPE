package tppe;

public class ClienteEspecial extends Cliente{

	public ClienteEspecial(String nome, String endereco, boolean interior) {
		super (nome,endereco,interior);
	}
	
	public float calcularDesconto(float valorTotal, boolean usandoCartaoDaLoja) {
		float desconto = valorTotal * 0.10f;
		if(usandoCartaoDaLoja == true) {
			desconto += valorTotal *0.10f;
		}
		return desconto;
	}
	
	public float getFrete(String estado, boolean interior) {
		
		float valorFrete = 0;
		
		switch (estado) {
	
		
		case "Distrito Federal": {
			valorFrete = 5.00f;
			break;
		}
		case "Centro-Oeste": {
			valorFrete = interior ? 13.00f : 10.00f;
			break;
		}
		case "Nordeste": {
			valorFrete = interior ? 18.00f : 15.00f;
			break;
		}
		case "Norte": {
			valorFrete = interior ? 25.00f : 20.00f;
			break;
		}
		case "Sudeste": {
			valorFrete = interior ? 10.00f : 07.00f;
			break;
		}
		case "Sul": {
			valorFrete = interior ? 13.00f : 10.00f;
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + estado);
		}
		
		return valorFrete * 0.70f;
		}
	
}
