package tppe;

public class ProcessaVenda {
    
    private Venda venda;
    
    public ProcessaVenda(Venda venda) {
        this.venda = venda;
    }
    
    public void processarVenda() {
        float valorTotalProdutos = venda.getProduto().getPreco().getValor() * venda.getQuantidade();
        float desconto = calcularDesconto(valorTotalProdutos);
        float frete = calcularFrete();
        float valorTotalProdutosIP = calcularValorTotalProdutosComImpostos();
        float valorTotal = calcularValorTotalVenda(valorTotalProdutosIP, desconto, frete);
        
        imprimirNotaFiscal(valorTotalProdutos, valorTotalProdutosIP, desconto, frete, valorTotal);
    }
    
    private float calcularDesconto(float valorTotalProdutos) {
        Cliente cliente = venda.getCliente();
        if (cliente instanceof ClientePrime) {
            ((ClientePrime) cliente).acumularCashback(valorTotalProdutos, true);
            ((ClientePrime) cliente).usarCashback(valorTotalProdutos);
            return cliente.calcularDesconto(valorTotalProdutos, true);
        } else if (cliente instanceof ClienteEspecial) {
            return cliente.calcularDesconto(valorTotalProdutos, true);
        } else {
            return cliente.calcularDesconto(valorTotalProdutos, false);
        }
    }
    
    private float calcularFrete() {
        Cliente cliente = venda.getCliente();
        return cliente.getFrete(cliente.getEstado(), cliente.getInterior());
    }
    
    private float calcularValorTotalProdutosComImpostos() {
        Cliente cliente = venda.getCliente();
        Produto produto = venda.getProduto();
        float ICMS = cliente.getEstado().equals("Distrito Federal") ? 0.18f : 0.12f;
        float impostoMunicipal = cliente.getEstado().equals("Distrito Federal") ? 0.0f : 0.04f;
        float valorProdutoComImpostos = produto.getPreco().getValor() + (produto.getPreco().getValor() * ICMS) + (produto.getPreco().getValor() * impostoMunicipal);
        return valorProdutoComImpostos * venda.getQuantidade();
    }
    
    private float calcularValorTotalVenda(float valorTotalProdutosIP, float desconto, float frete) {
        return valorTotalProdutosIP - desconto + frete;
    }
    
    private void imprimirNotaFiscal(float valorTotalProdutos, float valorTotalProdutosIP, float desconto, float frete, float valorTotal) {
        Cliente cliente = venda.getCliente();
        Produto produto = venda.getProduto();
        float ICMS = cliente.getEstado().equals("Distrito Federal") ? 0.18f : 0.12f;
        float impostoMunicipal = cliente.getEstado().equals("Distrito Federal") ? 0.0f : 0.04f;
        
        System.out.println("------- Nota Fiscal ----------");
        System.out.println("------- Valor Total dos Produtos sem imposto ----------");
        System.out.println(produto.getCodigoItem() + " x " + venda.getQuantidade() + " --> " + valorTotalProdutos);
        System.out.println("------- Valor Total dos Produtos com Imposto ----------");
        System.out.println(produto.getCodigoItem() + " x " + venda.getQuantidade() + " --> " + valorTotalProdutosIP);
        System.out.println("------- Impostos Aplicados -----------");
        System.out.println("ICMS total : " + ICMS * produto.getPreco().getValor() * venda.getQuantidade());
        System.out.println("Imposto Municipal total : " + impostoMunicipal * produto.getPreco().getValor() * venda.getQuantidade());
        System.out.println("------- Descontos Aplicados ---------------");
        System.out.println("Desconto: " + desconto);
        System.out.println("------- Valor Frete -----------------");
        System.out.println("Frete: " + frete);
        System.out.println("------- Valor Total da Venda ----------");
        System.out.println("Valor Total: " + valorTotal);
    }
}