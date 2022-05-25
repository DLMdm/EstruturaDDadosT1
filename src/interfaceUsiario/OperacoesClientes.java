package interfaceUsiario;

import base.Cliente;
import listas.LDEclientes;

public class OperacoesClientes {

	private static OperacoesClientes operacoes = new OperacoesClientes();
	private LDEclientes clientes;

	private OperacoesClientes() {
		clientes = new LDEclientes();
	}

	public static OperacoesClientes getOperacoes() {
		return operacoes;
	}

	public void criarCliente() {
		String nome = SysIn.pedeNome();
		long CNH = SysIn.pedeCNH(), telefone = SysIn.pedeTelefone(), CPF = SysIn.pedeCPF();
		clientes.insereFim(new Cliente(nome, CNH, telefone, CPF));
		System.out.println("Cliente registrado!");
	}

	public void removerCliente(long CPF) {
		if (contem(CPF)) {
			if (OperacoesLocacoes.getOperacoes().estahLocado(CPF)) {
				clientes.remove(clientes.get(CPF));
			} else
				System.out.println("N�o � poss�vel excluir um cliente com loca��o ativa!");
		} else
			System.out.println("Cliente n�o encontrado!");
	}

	public boolean contem(long CPF) {
		return clientes.contem(CPF);
	}

	public Cliente get(long CPF) {
		return clientes.get(CPF);
	}

	public void alterarNome(long CPF) {
		if (contem(CPF)) {
			String nome = SysIn.inString("Qual � o novo nome?");
			clientes.get(CPF).setNome(nome);
			System.out.println("Altera��o conclu�da!");
		} else
			System.out.println("Cliente n�o encontrado!");
	}

	public void alterarCNH(long CPF) {
		if (contem(CPF)) {
			long cnh = SysIn.inLong("Digite o novo CPF:");
			clientes.get(CPF).setCNH(cnh);
			System.out.println("Altera��o conclu�da!");
		} else
			System.out.println("Cliente n�o encontrado!");
	}

	public void alterarTelefone(long CPF) {
		if (contem(CPF)) {
			long telefone = SysIn.inLong("Digite o novo Telefone:");
			clientes.get(CPF).setTelefone(telefone);
			System.out.println("Altera��o conclu�da!");
		} else
			System.out.println("Cliente n�o encontrado!");
	}

	public void imprime(long CPF) {
		Cliente cli = clientes.get(CPF);
		if (cli != null) {
			System.out.println(cli.toString());
			System.out.println("Altera��o conclu�da!");
		} else
			System.out.println("Cliente n�o encontrado!");
	}

	public void imprimeInicioAFim() {
		clientes.imprimeInicioAFim();
	}

	public void imprimeFimAInicio() {
		clientes.imprimeFimAInicio();
	}

	public boolean atualizarListaComArquivo(String arquivo) {
		return clientes.atualizarListaComArquivo(arquivo);
	}
	
	public boolean garavarEmArquivo(String arquivo) {
		return clientes.gravarEmArquivo(arquivo);
	}

}
