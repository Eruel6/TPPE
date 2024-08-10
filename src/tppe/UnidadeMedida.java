package tppe;

public enum UnidadeMedida {
    UNIDADE("Unidade"),
    LITRO("Litro"),
    QUILOGRAMA("Kg"),
	METRO("Metro");

    private final String descricao;

    UnidadeMedida(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    @Override
    public String toString() {
        return descricao;
    }
}
