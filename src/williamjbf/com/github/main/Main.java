package williamjbf.com.github.main;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception {
		ArrayList<String> historico = new ArrayList<String>();
		Scanner scanner = new Scanner(System.in);

		int numero1 = 0,numero2 = 0;
		char operacao;
		int acao = 1; // 0 = sair; 1 = operação_matemática; 2 = histórico
		while (acao > 0) {
			if (acao == 1) {
				System.out.println("=== Operação matemática ===");
				System.out.print("Digite o primeiro número: ");

				try {
					numero1 = scanner.nextInt();
				} catch (InputMismatchException e) {
					System.out.println(String.format(
							"Ocorreu um erro de formato: %s. O primeiro número assumirá o valor 1.", e.getMessage()));
					scanner.nextLine(); // "limpar" o buffer do teclado
					numero1 = 1;
				} catch (Exception e) {
					System.out.println("Erro desconhecido.");
				}
				
				System.out.print("Digite a operação: ");
				try {
					operacao = scanner.next().charAt(0);
					if(operacao != '+' && operacao !='-' && operacao !='*' && operacao !='/') {
						throw new Exception("Dado informado não é uma operação");
					}
				} catch (Exception e) {
					System.out.println("Operação digitada não é um operador aritmético. A operação sera uma soma.");
					scanner.nextLine(); // "limpar" o buffer do teclado
					operacao = '+';
				}
				
				System.out.print("Digite o segundo número: ");
				try {
					numero2 = scanner.nextInt();
				} catch (InputMismatchException e) {
					System.out.println(String.format(
							"Ocorreu um erro de formato: %s. O segundo número assumirá o valor 1.", e.getMessage()));
					scanner.nextLine(); // "limpar" o buffer do teclado
					numero2 = 1;
				} catch (Exception e) {
					System.out.println("Erro desconhecido.");
				}

				System.out.println(String.format("Você quer fazer a opereação %d %c %d", numero1, operacao, numero2));
				int resultado = 0;

				switch (operacao) {
				case '+':
					resultado = numero1 + numero2;
					break;
				case '-':
					resultado = numero1 - numero2;
					break;
				case '*':
					resultado = numero1 * numero2;
					break;
				case '/':
					resultado = numero1 / numero2;
					break;
				default:
					System.out.println("Operação inválida");
				}

				String entradaHistorico = String.format("%d %c %d = %d", numero1, operacao, numero2, resultado);
				historico.add(entradaHistorico);
				System.out.println(entradaHistorico);
			} else if (acao == 2) {
				System.out.println("=== Histórico ===");
				System.out.println(String.format("- Você já fez %d operações", historico.size()));
				historico.forEach(itemHistorio -> System.out.println(itemHistorio));
//				for (int i = 0; i< historico.size();i++) {
//					System.out.println(historico.get(i));
//				}
			}
			System.out.println("=== O que você quer fazer? ===");
			System.out.println("1. Realizar opreação matemática");
			System.out.println("2. Vizualizar o histórico");
			System.out.println("0. Sair");
			System.out.print("Sua ação: ");
			acao = scanner.nextInt();
		}
		scanner.close();
	}

}
