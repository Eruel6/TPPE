package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import tppe.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Cliente> clientes = new ArrayList<>();
        List<Produto> produtos = new ArrayList<>();
        List<Venda> vendas = new ArrayList<>();

        while (true) {
            System.out.println("=========   Bem vindo à Vendinha  =========");
            System.out.println("--------- Selecione uma das opções --------");
            System.out.println("--------- 1 - Cadastro de cliente  --------");
            System.out.println("--------- 2 - Cadastro de produto  --------");
            System.out.println("--------- 3 - Realizar uma venda   --------");
            System.out.println("--------- 0 - Sair                  --------");
            System.out.println("===========================================");
            
            System.out.print("Digite sua opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();
            
            switch (opcao) {
                case 1:
                    System.out.println("Indique o tipo de cliente a ser cadastrado");
                    System.out.println("1 -> Padrão");
                    System.out.println("2 -> Especial");
                    System.out.println("3 -> Prime");
                    int tipoCliente = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("Digite o nome do Cliente");
                    String nomeCliente = scanner.nextLine();
                    System.out.println("Digite a região do cliente");
                    String regiaoCliente = scanner.nextLine();
                    System.out.println("O cliente é do interior? (Y/N)");
                    String isInterior = scanner.nextLine();
                    boolean interior = isInterior.equalsIgnoreCase("Y");

                    Cliente cliente;
                    if (tipoCliente == 1) {
                        cliente = new ClientePadrao(nomeCliente, regiaoCliente, interior);
                    } else if (tipoCliente == 2) {
                        cliente = new ClienteEspecial(nomeCliente, regiaoCliente, interior);
                    } else if (tipoCliente == 3) {
                        cliente = new ClientePrime(nomeCliente, regiaoCliente, interior);
                    } else {
                        System.out.println("Por favor insira uma das opções fornecidas (1, 2 ou 3)");
                        continue;
                    }
                    clientes.add(cliente);
                    System.out.println("Cliente cadastrado com sucesso!");
                    break;

                case 2:
                    System.out.println("Digite o Código do Produto (Deve ser um número)");
                    int codigoProduto = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("Digite a descrição do produto");
                    String descricaoProduto = scanner.nextLine();
                    System.out.println("Digite o valor do produto");
                    while (!scanner.hasNextFloat()) {
                        System.out.println("Valor inválido! Digite o valor do produto:");
                        scanner.next();
                    }
                    float valor = scanner.nextFloat();
                    scanner.nextLine();

                    System.out.println("Digite a unidade do produto");
                    String unidade = scanner.nextLine();
                    Produto produto = new Produto(codigoProduto, descricaoProduto, valor, unidade);
                    produtos.add(produto);
                    System.out.println("Produto cadastrado com sucesso!");
                    break;

                case 3:                 
                    int i = 0, j = 0;
                   
                    if (clientes.isEmpty()|| produtos.isEmpty()) {
                    	System.out.println("Por favor cadastre pelo menos um cliente E produto para poder realizar uma venda.");
                    	System.out.println("É nescessário recadastrar caso algo já estivesse cadastrado.");
                    	main(args);
                    	break;
                    }
                    
                    for (Cliente clienteList : clientes) {
                        System.out.println(i + " - Nome: " + clienteList.getNome());
                        i++;
                    }
                    
                    System.out.println("Digite o numero do cliente que deseja realizar a venda");
                    int opcaoCliente = scanner.nextInt();                 
                    
                    System.out.println("=========================================");
                    for (Produto produtoList : produtos) {
                        System.out.println(j + " - Codigo: " + produtoList.getCodigoItem());
                        j++;
                    }
                    
                    System.out.println("Digite o numero do Produto que deseja vender");
                    int opcaoProduto = scanner.nextInt();                   
                    
                    System.out.println("Digite a quantidade que será vendida");
                    int quantidade = scanner.nextInt();
                    scanner.next();
                    
                    System.out.println("Digite a data da venda");
                    String data = scanner.nextLine();
                  
                    Venda venda = new Venda(clientes.get(opcaoCliente),produtos.get(opcaoProduto), quantidade, data);
                    vendas.add(venda);
                    venda.realizarVenda();
                    System.out.println("Venda cadastrada com sucesso!");
                    break;

                case 0:
                    System.out.println("Saindo...");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Opção inválida! Por favor, selecione uma opção válida.");
                    break;
            }
        }
    }
}
