package listas;

import base.Arquivo;
import base.Categoria;
import base.Veiculo;
import interfaceUsiario.OperacoesCategorias;

public class LDEveiculos {
	private Nohveiculo inicio;
	private Nohveiculo fim;

	public LDEveiculos() {
		this.inicio = null;
		this.fim = null;
	}

	public void insereInicio(Veiculo info) {
		Nohveiculo novo = new Nohveiculo(info);
		if (inicio == null) {
			inicio = novo;
			fim = novo;
		} else {
			novo.setProx(inicio);
			inicio.setAnt(novo);
			inicio = novo;
		}
	}

	public boolean estahVazia() {
		return inicio == null;
	}

	public void insereFim(Veiculo info) {
		Nohveiculo novo = new Nohveiculo(info);
		if (fim == null) {
			inicio = novo;
			fim = novo;
		} else {
			novo.setAnt(fim);
			fim.setProx(novo);
			fim = novo;
		}
	}

	public boolean remove(Veiculo info) {
		Nohveiculo p = busca(info);
		if (p == null)
			return false;
		if (p.getAnt() == null) {
			inicio = p.getProx();
			inicio.setAnt(null);
		} else if (p.getProx() == null) {
			p.getAnt().setProx(null);
			fim = p.getAnt();
		} else {
			p.getAnt().setProx(p.getProx());
			p.getProx().setAnt(p.getAnt());
		}
		return true;
	}

	public Nohveiculo busca(Veiculo info) {
		Nohveiculo resultado = null;
		for (Nohveiculo i = inicio; i != null && i.getInfo() != info; i = i.getProx()) {
			if (i.getInfo() == info)
				resultado = i;
		}
		return resultado;
	}

	public Nohveiculo busca(String placa) {
		Nohveiculo resultado = null;
		for (Nohveiculo i = inicio; i != null && i.getInfo().getPlaca() != placa; i = i.getProx()) {
			if (i.getInfo().getPlaca() == placa)
				resultado = i;
		}
		return resultado;
	}

	public Veiculo get(String placa) {
		Nohveiculo noh = busca(placa);
		if (noh != null)
			return noh.getInfo();
		return null;
	}

	public boolean contem(String placa) {
		if (busca(placa) != null)
			return true;
		return false;
	}

	public int tamanho() {
		int cont = 0;
		for (Nohveiculo i = inicio; i != null; i = i.getProx())
			cont++;
		return cont;
	}

	public void imprimeInicioAFim() {
		for (Nohveiculo i = inicio; i != null; i = i.getProx())
			System.out.println(i.toString() + "\n");
	}

	public void imprimeFimAInicio() {
		for (Nohveiculo i = fim; i != null; i = i.getAnt())
			System.out.println(i.toString() + "\n");
	}

	public boolean atualizarListaComArquivo(String arquivo) {
		try {
			LDE lista = Arquivo.getLinhas(arquivo);
			Noh noh = lista.getInicio();
			do {
				// os dados devem vir do arquivo no formato:
				// placa;modelo;marca;ano;potencia;lugares;categoria
				String linha = (String) noh.getInfo();
				String dados[] = linha.split(";");
				if (dados.length == 7) {
					Categoria cat = OperacoesCategorias.getOperacoes().get(Integer.parseInt(dados[7]));
					insereFim(new Veiculo(dados[0], dados[1], dados[2], Integer.parseInt(dados[3]),
							Integer.parseInt(dados[4]), Integer.parseInt(dados[5]), cat));
				} else {
					System.out.println("Formato do arquivo de veículos inválido!");
					return false;
				}
				noh = noh.getProx();

			} while (noh != null);

		} catch (Exception e) {
			System.out.println("Erro ao ler Clientes:" + e.getMessage());
		}
		return true;
	}

	public boolean gravarEmArquivo(String arquivo) {
		String conteudo = "placa;modelo;marca;ano;potencia;lugares;categoria\n";
		for (Nohveiculo i = inicio; i != null; i = i.getProx()) {
			Veiculo vei = i.getInfo();
			conteudo += vei.getPlaca() + ";" + vei.getModelo() + ";" + vei.getMarca() + ";" + vei.getAno() + ";"
					+ vei.getPotencia() + ";" + vei.getNlugares() + ";" + vei.getCategoria().getId();
		}
		try {
			Arquivo.gravar(conteudo, arquivo);
		} catch (Exception e) {
			System.out.println("Erro ao gravar o arquivo de Veículos!");
			return false;
		}
		return true;
	}
}
