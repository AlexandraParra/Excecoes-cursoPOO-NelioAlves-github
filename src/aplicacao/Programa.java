package aplicacao;

import java.util.Locale;
import java.util.Scanner;

import modelo.entidades.Conta;
import modelo.excepcoes.DominioExcecao;

public class Programa {

	public static void main(String[] args) {
		
		try {
			Locale.setDefault(Locale.US);
			Scanner sc = new Scanner(System.in);
			System.out.println("Dados da conta:");
			System.out.print("Número: ");
			int numero = sc.nextInt();
			System.out.print("Titular: ");
			sc.nextLine();
			String titular = sc.nextLine();
			System.out.print("Saldo inicial: ");
			double saldo = sc.nextDouble();
			System.out.print("Limite de saque: ");
			double limite = sc.nextDouble();
			Conta conta = new Conta(numero, titular, saldo, limite);
			
			System.out.println();
			System.out.print("Digite o valor do saque: ");
			double saque = sc.nextDouble();
			conta.saque(saque);
			System.out.printf("Novo saldo: %.2f", conta.getSaldo());
			sc.close();
		} 
		catch (DominioExcecao e){
			System.out.println("Erro de saque: " + e.getMessage());
		}
		catch (Exception e) {
			System.out.println("Erro inesperado");
		}
	}

}
