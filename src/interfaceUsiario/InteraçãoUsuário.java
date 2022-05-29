package interfaceUsiario;

public class InteraçãoUsuário {

	public void PainelInicial() {
		int op;
		do {

			System.out.println("Qual tipo de operação deseja realizar?");
			System.out.println("1- Veículos.\n 2- Clientes.\n 3- Categoria.\n 4- Locaçoes.");
			op = SysIn.inInt("Digite a opcao:");
			switch (op) {
			case 1:
				PainelInicialVeiculos();
				break;
			case 2:
				PainelInicialClientes();
				break;
			case 3:

				break;
			case 4:

				break;
			default:
				System.out.println("Digite uma opçao válida. ");
			}
		} while (op != 0);
	}

	public void PainelInicialVeiculos() {
		System.out.println(
				"Escolha uma das opçoes abaixo:\n 1- Incluir um véiculo.\n 2- Excluir um veículo.\n 3- Editar dados de um veículo.\n 4- Listar todos os veículos.\n 5- Voltar.");

		int op = SysIn.inInt("Digite a opcao:");

		switch (op) {
		case 1:
			OperacoesVeiculos.getOperacoes().criarVeiculo();
			break;
		case 2:
			String placaRemov = SysIn.pedePlaca();
			if (!OperacoesVeiculos.getOperacoes().contem(placaRemov)) {
				System.out.println("Veículo nao encontrado!");
				break;
			}
			OperacoesVeiculos.getOperacoes().removerVeiculo(placaRemov);
		case 3:
			String placaEdit = SysIn.pedePlaca();
			if (!OperacoesVeiculos.getOperacoes().contem(placaEdit)) {
				System.out.println("Veiculo nao encontrado!");
				break;
			}
			PainelEditaVeiculo(placaEdit);
		case 4:
			OperacoesVeiculos.getOperacoes().imprimeInicioAFim();
			break;
		case 5:
			PainelInicial();
		default:
			System.out.println("Digite uma opçao válida. ");
		}
	}

	public void PainelInicialClientes() {
		System.out.println(
				"Escolha uma das opçoes abaixo:\n 1- Incluir um cliente.\n 2- Excluir um cliente.\n 3- Editar dados de um cliente.\n 4- Listar todos os clientes.\n 5- Voltar.");
		int op = SysIn.inInt("Digite a opcao:");
		switch (op) {
		case 1:
			OperacoesClientes.getOperacoes().criarCliente();
			break;
		case 2:
			long cpfRemov = SysIn.pedeCPF();
			if (!OperacoesClientes.getOperacoes().contem(cpfRemov)) {
				System.out.println("Cliente nao encontrado!");
			}
			OperacoesClientes.getOperacoes().removerCliente(cpfRemov);
			break;
		case 3:
			long cpfEdit = SysIn.pedeCPF();
			if (!OperacoesClientes.getOperacoes().contem(cpfEdit)) {
				System.out.println("Cliente nao encontrado!");
			}
			PainelEditaCliente(cpfEdit);
			break;
		case 4:
			OperacoesClientes.getOperacoes().imprimeInicioAFim();
			break;
		case 5:
			PainelInicial();
		default:
			System.out.println("Digite uma opçao válida. ");
		}
	}

	public void PainelInicialCategoria() {
		System.out.println(
				"Escolha uma das opçoes abaixo:\n 1- Incluir uma categoria.\n 2- Excluir uma categoria.\n 3- Editar uma categoria.\n 4- Listar todas categorias.\n 5- Voltar.");
		int op = SysIn.inInt("Digite a opcao:");
		switch (op) {
		case 1:
			OperacoesCategorias.getOperacoes().criaCategoria();
			break;
		case 2:
			int catRemov = SysIn.pedeIdCat();
			if (!OperacoesCategorias.getOperacoes().contem(catRemov)) {
				System.out.println("Categoria nao encontrada.");
			}
			OperacoesCategorias.getOperacoes().excluiCategoria(catRemov);
			break;
		case 3:
			int catEdit = SysIn.inInt("Digite o id da categoria:");
			if (!OperacoesCategorias.getOperacoes().contem(catEdit)) {
				System.out.println("Categoria nao encontrada!");
			}
			OperacoesCategorias.getOperacoes().alterarNome(catEdit);
			break;
		case 4:
			//listar categorias
		case 5:
			PainelInicial();
		default:
			System.out.println("Digite uma opçao válida. ");
		}
	}
	
	public void PainelInicialLocacao() {
		System.out.println(
				"Escolha uma das opçoes abaixo:\n 1- Inciar uma Locacao.\n 2- Encerrar uma locacao.\n 3- Listar todas locacoes.\n 4- Voltar.");
		int op = SysIn.inInt("Digite a opcao:");
		switch (op) {
		case 1:
			OperacoesLocacoes.getOperacoes().iniciarLocacao();
			break;
		case 2:
			OperacoesLocacoes.getOperacoes().encerraLocacao();
			break;
		case 3:
			OperacoesLocacoes.getOperacoes().imprimeInicioAFim();
		case 4:
			PainelInicial();
		default:
			System.out.println("Digite uma opçao válida. ");
		}
	}
	public void PainelEditaVeiculo(String placa) {
		
	}

	public void PainelEditaCliente(long cpf) {

	}

}
