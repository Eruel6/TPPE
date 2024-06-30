package tppe;

public class ClientePrime extends Cliente{
	
	private float saldoCashback;
	
	public ClientePrime(String nome, String estado, boolean interior) {
		super(nome,estado,interior);
		this.saldoCashback = 0.0f;
	}
	
	public float calcularDesconto(float valorTotal, boolean usandoCartaoDaLoja){
		float desconto = valorTotal * 0.10f;
		if(usandoCartaoDaLoja == true) {
			desconto += valorTotal *0.10f;
		}
		return valorTotal - desconto;
	}
	
	public float calcularFrete (float valorFreteBase) {
		return 0.0f;
	}
	
	public void acumularCashback(float valorGasto, boolean usandoCartaoDaLoja) {
		if (usandoCartaoDaLoja == true) {
			saldoCashback += valorGasto * 0.05f;
		} else {
			saldoCashback += valorGasto * 0.03f;
		}
	}
	
	public float getSaldoCashback() {
		return saldoCashback;
	}
	
	public void usarCashback(float valor) {    
            saldoCashback -= valor;
    }
	
}
