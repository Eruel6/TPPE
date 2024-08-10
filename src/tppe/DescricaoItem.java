package tppe;

public class DescricaoItem {
    private final String descricao;

    public DescricaoItem(String descricao) {
        if (descricao == null || descricao.trim().isEmpty()) {
            throw new IllegalArgumentException("A descrição não pode ser nula ou vazia.");
        }
        if (descricao.length() > 255) { // Limite arbitrário para a descrição
            throw new IllegalArgumentException("A descrição não pode ter mais que 255 caracteres.");
        }
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