package interfaceUsiario;

import base.Categoria;
import base.Veiculo;
import listas.LDEveiculos;

public class OperacoesVeiculos {

	private static OperacoesVeiculos operacoes = new OperacoesVeiculos();
	private LDEveiculos veiculos;

	private OperacoesVeiculos() {
		veiculos = new LDEveiculos();
	}

	public static OperacoesVeiculos getOperacoes() {
		return operacoes;
	}

	public void criarVeiculo() {
		String placa = SysIn.pedePlaca();
		String modelo = SysIn.pedeModelo(), marca = SysIn.pedeMarca();
		int ano = SysIn.pedeAnoVeiculo(), potencia = SysIn.pedePotencia(), nlugares = SysIn.pedeNLugares();
		Categoria cat;
		do {
			int id = SysIn.pedeIdCat();
			cat = OperacoesCategorias.getOperacoes().get(id);
			if (cat == null)
				System.out.println("Categoria não encontrada!\n");
		} while (cat == null);
		veiculos.insereFim(new Veiculo(placa, modelo, marca, ano, potencia, nlugares, cat));
	}

	public void removerVeiculo(String placa) {
		if (contem(placa)) {
			if (!OperacoesLocacoes.getOperacoes().estahLocado(placa)) {
				veiculos.remove(veiculos.get(placa));
			} else
				System.out.println("Não é possível excluir um cliente com locação ativa!");
		} else
			System.out.println("Veículo não encontrado!");
	}

	public boolean contem(String placa) {
		return veiculos.contem(placa);
	}

	public Veiculo get(String placa) {
		return veiculos.get(placa);
	}

	public void alterarModelo(String placa) {
		if (contem(placa)) {
			String modelo = SysIn.inString("Qual é o novo modelo do veículo?");
			veiculos.get(placa).setModelo(modelo);
			System.out.println("Alteração concluída!");
		} else
			System.out.println("Veiculo não encontrado!");
	}

	public void alterarMarca(String placa) {
		if (contem(placa)) {
			String marca = SysIn.inString("Qual é o novo modelo do veículo?");
			veiculos.get(placa).setModelo(marca);
			System.out.println("Alteração concluída!");
		} else
			System.out.println("Veiculo não encontrado!");
	}

	public void alterarAno(String placa) {
		if (contem(placa)) {
			int ano = SysIn.inInt("Qual é o novo ano do veículo?");
			veiculos.get(placa).setAno(ano);
			System.out.println("Alteração concluída!");
		} else
			System.out.println("Veiculo não encontrado!");
	}

	public void alterarPotencia(String placa) {
		if (contem(placa)) {
			int potencia = SysIn.inInt("Qual é a nova potencia do veículo?");
			veiculos.get(placa).setPotencia(potencia);
			System.out.println("Alteração concluída!");
		} else
			System.out.println("Veiculo não encontrado!");
	}

	public void alterarNLugares(String placa) {
		if (contem(placa)) {
			int nLugares = SysIn.inInt("Qual é o novo numero de lugares do veículo?");
			veiculos.get(placa).setNlugares(nLugares);
			System.out.println("Alteração concluída!");
		} else
			System.out.println("Veiculo não encontrado!");
	}

	public void alterarCategoria(String placa) {
		if (contem(placa)) {
			Categoria cat;
			do {
				int id = SysIn.pedeIdCat();
				cat = OperacoesCategorias.getOperacoes().get(id);
				if (cat == null)
					System.out.println("Categoria não encontrada!\n");
			} while (cat == null);
			veiculos.get(placa).setCategoria(cat);
			System.out.println("Alteração concluída!");
		} else
			System.out.println("Veiculo não encontrado!");
	}

	public void imprime(String placa) {
		Veiculo vei = veiculos.get(placa);
		if (vei != null) {
			System.out.println(vei.toString());
			System.out.println("Alteração concluída!");
		} else
			System.out.println("veiculo não encontrado!");
	}

	public void imprimeInicioAFim() {
		veiculos.imprimeInicioAFim();
	}

	public void imprimeFimAInicio() {
		veiculos.imprimeFimAInicio();
	}

	public boolean atualizarListaComArquivo(String arquivo) {
		return veiculos.atualizarListaComArquivo(arquivo);
	}
	
	public boolean gravarEmArquivo(String arquivo) {
		return veiculos.gravarEmArquivo(arquivo);
	}
	
	public boolean catEstaVinculada(int id) {
		return veiculos.catEstaVinculada(id);
	}

}
