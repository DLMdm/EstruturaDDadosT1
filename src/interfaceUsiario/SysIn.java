package interfaceUsiario;

import java.util.Scanner;

public class SysIn {
	private static Scanner scan = new Scanner(System.in);

	public static String inString(String texto) {
		String resp = "";
		System.out.println(texto);
		resp = scan.next();
		return resp;
	}

	public static long inLong(String texto, String erro) {
		long resp = 0;
		boolean test = false;
		do {
			System.out.println(texto);
			try {
				resp = scan.nextLong();
				test = false;
			} catch (Exception e) {
				System.out.println(erro);
				test = false;
			}
		} while (!test);
		return resp;
	}
	
	public static long inLong(String texto) {
		return inLong(texto, "Valor inv�lido!");
	}
	
	public static int inInt(String texto, String erro) {
		int resp = 0;
		boolean test = false;
		do {
			System.out.println(texto);
			try {
				resp = scan.nextInt();
				test = false;
			} catch (Exception e) {
				System.out.println(erro);
				test = false;
			}
		} while (!test);
		return resp;
	}
	
	public static int inInt(String texto) {
		return inInt(texto, "Valor inv�lido!");
	}
	
	public static double inDouble(String texto, String erro) {
		double resp = 0;
		boolean test = false;
		do {
			System.out.println(texto);
			try {
				resp = scan.nextInt();
				test = false;
			} catch (Exception e) {
				System.out.println(erro);
				test = false;
			}
		} while (!test);
		return resp;
	}
	
	public static double inDouble(String texto) {
		return inDouble(texto, "Valor inv�lido!\n");
	}

	public static String pedeNome() {
		return inString("Digite o nome:\n");
	}

	public static long pedeCPF() {
		return inLong("Digite o CPF do cliente:\n");
	}
	
	public static long pedeCNH() {
		return inLong("Digite a CNH do cliente:");
	}
	
	public static long pedeTelefone() {
		 return inLong("Digite o contato (telefone) do cliente:");
	}
	
	public static String pedePlaca() {
		return inString("Digite a placa do ve�culo:");
	}
	
	public static String pedeModelo() {
		return inString("Digite o modelo do ve�culo:");
	}
	
	public static String pedeMarca() {
		return inString("Digite a marca do ve�culo:");
	}
	
	public static int pedeAnoVeiculo() {
		return inInt("Digite o ano do ve�culo:");
	}
	
	public static int pedePotencia() {
		return inInt("Digite a pot�ncia do ve�culo:");
	}
	
	public static int pedeNLugares() {
		return inInt("Digite o numero de lugares do ve�culo:");
	}
	
	public static int pedeIdCat() {
		return inInt("Digite o id da categoria:");
	}
	
	public static double pedeValor() {
		return inDouble("Digite o valor:");
	}

}
