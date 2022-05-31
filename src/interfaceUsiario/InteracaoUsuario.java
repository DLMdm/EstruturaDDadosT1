package interfaceUsiario;

public class InteracaoUsuario {
	
	public InteracaoUsuario() {
		
	}

	public void PainelInicial() {
		int op;
		do {

			System.out.println("Qual tipo de operação deseja realizar?");
			System.out.println(" 1- Veículos.\n 2- Clientes.\n 3- Categoria.\n 4- Locaçoes.\n 0- Sair");
			op = SysIn.inInt("Digite a opcao:");
			switch (op) {
			case 1:
				PainelInicialVeiculos();
				break;
			case 2:
				PainelInicialClientes();
				break;
			case 3:
				PainelInicialCategoria();
				break;
			case 4:
				PainelInicialLocacao();
				break;
			case 0:
				System.out.println("Programa encerrado!");
				break;
			default:
				System.out.println("Digite uma opçao válida. ");
			}
		} while (op != 0);
	}

	public void PainelInicialVeiculos() {
		int op;
		do {
			System.out.println(
					"Escolha uma das opçoes abaixo:\n 1- Incluir um véiculo.\n 2- Excluir um veículo.\n 3- Editar dados de um veículo.\n 4- Listar veículos de frente para trás.\n 5- Listar veículos de trás para frente.\n 0- Voltar.");

			op = SysIn.inInt("Digite a opcao:");

			switch (op) {
			case 1:
				OperacoesVeiculos.getOperacoes().criarVeiculo();
				break;
			case 2:
				String placaRemov = SysIn.pedePlaca();
				if (!OperacoesVeiculos.getOperacoes().contem(placaRemov)) {
					System.out.println("Veículo nao encontrado!");
					break;
				}else
				OperacoesVeiculos.getOperacoes().removerVeiculo(placaRemov);
				break;
			case 3:
				String placaEdit = SysIn.pedePlaca();
				if (!OperacoesVeiculos.getOperacoes().contem(placaEdit)) {
					System.out.println("Veiculo nao encontrado!");
					break;
				}else
				PainelEditaVeiculo(placaEdit);
				break;
			case 4:
				OperacoesVeiculos.getOperacoes().imprimeInicioAFim();
				break;
			case 5:
				OperacoesVeiculos.getOperacoes().imprimeFimAInicio();
				break;
			case 0:
				break;

			default:
				System.out.println("Digite uma opçao válida. ");
			}
		} while (op != 0);
	}

	public void PainelInicialClientes() {
		int op;
		do {
		System.out.println(
				"Escolha uma das opçoes abaixo:\n 1- Incluir um cliente.\n 2- Excluir um cliente.\n 3- Editar dados de um cliente.\n 4- Listar clientes de frente para trás.\n 5- listar Veiculos de trás para frente. \n 0- Voltar.");
		op = SysIn.inInt("Digite a opcao:");
		switch (op) {
		case 1:
			OperacoesClientes.getOperacoes().criarCliente();
			break;
		case 2:
			long cpfRemov = SysIn.pedeCPF();
			if (!OperacoesClientes.getOperacoes().contem(cpfRemov)) {
				System.out.println("Cliente nao encontrado!");
			}else
			OperacoesClientes.getOperacoes().removerCliente(cpfRemov);
			break;
		case 3:
			long cpfEdit = SysIn.pedeCPF();
			if (!OperacoesClientes.getOperacoes().contem(cpfEdit)) {
				System.out.println("Cliente nao encontrado!");
			}else
			PainelEditaCliente(cpfEdit);
			break;
		case 4:
			OperacoesClientes.getOperacoes().imprimeInicioAFim();
			break;
		case 5:
			OperacoesClientes.getOperacoes().imprimeFimAInicio();
			break;
		case 0:
			break;
		default:
			System.out.println("Digite uma opçao válida. ");
		}
		}while(op != 0);
	}

	public void PainelInicialCategoria() {
		int op;
		do {
		System.out.println(
				"Escolha uma das opçoes abaixo:\n 1- Incluir uma categoria.\n 2- Excluir uma categoria.\n 3- Editar o nome de uma categoria.\n 4- Listar categorias de frente para trás. \n 5- Listar categorias de trás para frente.\n 0- Voltar.");
		op = SysIn.inInt("Digite a opcao:");
		switch (op) {
		case 1:
			OperacoesCategorias.getOperacoes().criaCategoria();
			break;
		case 2:
			int catRemov = SysIn.pedeIdCat();
			if (!OperacoesCategorias.getOperacoes().contem(catRemov)) {
				System.out.println("Categoria nao encontrada.");
			}else
			OperacoesCategorias.getOperacoes().excluiCategoria(catRemov);
			break;
		case 3:
			EditaCategoria();
			break;
		case 4:
			OperacoesCategorias.getOperacoes().imprimeInicioAFim();
			break;
		case 5:
			OperacoesCategorias.getOperacoes().imprimeFimAInicio();
			break;
		case 0:
			break;
		default:
			System.out.println("Digite uma opçao válida.");
			break;
		}
		}while(op != 0);
	}

	public void PainelInicialLocacao() {
		System.out.println(
				"Escolha uma das opçoes abaixo:\n 1- Inciar uma Locacao.\n 2- Encerrar uma locacao.\n 3- Listar locações de frente para trás. \n 4- Listar Lcações de trás para frente.\n 0- Voltar.");
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
			break;
		case 4:
			OperacoesLocacoes.getOperacoes().imprimeFimAInicio();
			break;
		case 0:
			break;
		default:
			System.out.println("Digite uma opçao válida. ");
		}
	}

	public void PainelEditaVeiculo(String placa) {
        int op;
        do {
        System.out.println("O que deseja alterar: \n 1- Modelo \n 2- Ano \n 3- Potencia \n 4- Numero de lugares \n 5- categoria \n 0- Voltar \n");
        op = SysIn.inInt("Digite a opção:");
        switch (op) {
        case 0:
            break;
        case 1:
            OperacoesVeiculos.getOperacoes().alterarModelo(placa);
            break;
        case 2: 
            OperacoesVeiculos.getOperacoes().alterarAno(placa);
            break;
        case 3: 
            OperacoesVeiculos.getOperacoes().alterarPotencia(placa);
            break;
        case 4:
            OperacoesVeiculos.getOperacoes().alterarNLugares(placa);
            break;
        case 5: 
            OperacoesVeiculos.getOperacoes().alterarCategoria(placa);
            break;
        default:
            System.out.println("Digite um valor válido");
        }
        } while (op != 0);
    }

    public void PainelEditaCliente(long cpf) {
        int op;
        do {
        System.out.println("O que deseja alterar: \n 1- Nome \n 2- CNH \n 3- Telefone \n 0- Sair \n");
        op = SysIn.inInt("Digite a opção: ");
        switch (op) {
        case 1: 
            OperacoesClientes.getOperacoes().alterarNome(cpf);
            break;
        case 2:
            OperacoesClientes.getOperacoes().alterarCNH(cpf);
            break;
        case 3: 
            OperacoesClientes.getOperacoes().alterarTelefone(cpf);
            break;
        default:
            System.out.println("Por favor digite uma opção Válida.");

        }
        }while (op != 0);
    }

    public void EditaCategoria() {
        System.out.println("Informe o Id da categoria que deseja alterar o nome");
        int id = SysIn.pedeIdCat();
            if (!OperacoesCategorias.getOperacoes().contem(id)) {
                System.out.println("Categoria nao encontrada!");
            }else
                OperacoesCategorias.getOperacoes().alterarNome(id);
    }
}
