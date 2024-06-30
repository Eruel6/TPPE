package tppe;

public class ClientePadrao extends Cliente{
	
	public ClientePadrao(String nome, String estado, boolean interior) {
		super(nome,estado,interior);
	}
	
	public float calcularDesconto(float valorTotal, boolean usandoCartaoDaLoja){
		return 0;
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
			
			return valorFrete;
			}
	
}
