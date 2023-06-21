package teste;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;


public class Main {
	    private static Composicao composicao1;
	    private static Composicao composicao2;

	    public static void main(String[] args) {
	        composicao1 = criarComposicao(1);
	        composicao2 = criarComposicao(2);

	        Scanner scanner = new Scanner(System.in);

	        while (true) {
	            exibirMenu();
	            int opcao = scanner.nextInt();
	            scanner.nextLine(); // Limpar o buffer

	            switch (opcao) {
	                case 1:
	                    adicionarCarga(scanner);
	                    break;
	                case 2:
	                    desembarcarCarga(scanner);
	                    break;
	                case 3:
	                    visualizarComposicoes();
	                    break;
	                case 4:
	                    System.out.println("Encerrando o programa.");
	                    return;
	                default:
	                    System.out.println("Op��o inv�lida. Tente novamente.");
	                    break;
	            }
	        }
	    }

	    private static Composicao criarComposicao(int numero) {
	        Composicao composicao = new Composicao(numero);

	        // Criar vagoes de A a M
	        for (char c = 'A'; c <= 'M'; c++) {
	            composicao.adicionarVagao(new Vagao(String.valueOf(c)));
	        }

	        return composicao;
	    }

	    private static void exibirMenu() {
	        System.out.println("----- MENU -----");
	        System.out.println("1 - Adicionar carga");
	        System.out.println("2 - Desembarcar carga");
	        System.out.println("3 - Visualizar composi��es");
	        System.out.println("4 - Sair");
	        System.out.println("Digite a op��o desejada: ");
	    }

	    private static void adicionarCarga(Scanner scanner) {
	        System.out.println("Digite o n�mero da composi��o (1 ou 2): ");
	        int numeroComposicao = scanner.nextInt();
	        scanner.nextLine(); // Limpar o buffer

	        Composicao composicao;
	        if (numeroComposicao == 1) {
	            composicao = composicao1;
	        } else if (numeroComposicao == 2) {
	            composicao = composicao2;
	        } else {
	            System.out.println("Composi��o inv�lida.");
	            return;
	        }

	        System.out.println("Digite o identificador do vag�o (A a M): ");
	        String identificador = scanner.nextLine();

	        if (identificador.length() != 1 || identificador.charAt(0) < 'A' || identificador.charAt(0) > 'M') {
	            System.out.println("Identificador inv�lido.");
	            return;
	        }

	        System.out.println("Digite o conte�do da carga: ");
	        String conteudo = scanner.nextLine();

	        System.out.println("Digite a quantidade (em kg) da carga: ");
	        int quantidade = scanner.nextInt();
	        scanner.nextLine(); // Limpar o buffer

	        composicao.adicionarCarga(identificador, conteudo, quantidade);
	    }

	    private static void desembarcarCarga(Scanner scanner) {
	        System.out.println("Digite o n�mero da composi��o (1 ou 2): ");
	        int numeroComposicao = scanner.nextInt();
	        scanner.nextLine(); // Limpar o buffer

	        Composicao composicao;
	        if (numeroComposicao == 1) {
	            composicao = composicao1;
	        } else if (numeroComposicao == 2) {
	            composicao = composicao2;
	        } else {
	            System.out.println("Composi��o inv�lida.");
	            return;
	        }

	        System.out.println("Digite o identificador do vag�o (A a M): ");
	        String identificador = scanner.nextLine();

	        if (identificador.length() != 1 || identificador.charAt(0) < 'A' || identificador.charAt(0) > 'M') {
	            System.out.println("Identificador inv�lido.");
	            return;
	        }

	        composicao.desembarcarCarga(identificador);
	    }

	    private static void visualizarComposicoes() {
	        System.out.println("----- COMPOSI��O 1 -----");
	        exibirComposicao(composicao1);

	        System.out.println("----- COMPOSI��O 2 -----");
	        exibirComposicao(composicao2);
	    }

	    private static void exibirComposicao(Composicao composicao) {
	        Stack<Vagao> vagoes = composicao.getVagoes();

	        for (Vagao vagao : vagoes) {
	            System.out.print(vagao.getNome() + " - ");
	            if (vagao.isVazio()) {
	                System.out.println("Vazio");
	            } else {
	                System.out.println(vagao.getCarga() + " (" + vagao.getQuantidade() + "kg)");
	            }
	        }
	    }
	}
    