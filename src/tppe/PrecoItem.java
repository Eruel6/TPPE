package tppe;

public class PrecoItem {
    private final float valor;

    public PrecoItem(float valor) {
        if (valor < 0) {
            throw new IllegalArgumentException("O valor do preço não pode ser negativo.");
        }
        this.valor = valor;
    }

    public float getValor() {
        return valor;
    }

    @Override
    public String toString() {
        return String.format("R$ %.2f", valor);
    }
}
