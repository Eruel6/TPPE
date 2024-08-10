package tppe;

public class CodigoItem {
    private final int codigo;

    public CodigoItem(int codigo) {
        if (codigo <= 0) {
            throw new IllegalArgumentException("Código do item deve ser um número positivo.");
        }
        this.codigo = codigo;
    }

    public int getCodigo() {
        return codigo;
    }

    @Override
    public String toString() {
        return String.valueOf(codigo);
    }
}
