package listas;

import base.Arquivo;
import base.Categoria;

public class LDEcategorias {
	private Nohcategoria inicio;
	private Nohcategoria fim;

	public LDEcategorias() {
		this.inicio = null;
		this.fim = null;
	}

	public void insereInicio(Categoria info) {
		Nohcategoria novo = new Nohcategoria(info);
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

	public void insereFim(Categoria info) {
		Nohcategoria novo = new Nohcategoria(info);
		if (fim == null) {
			inicio = novo;
			fim = novo;
		} else {
			novo.setAnt(fim);
			fim.setProx(novo);
			fim = novo;
		}
	}

	public boolean remove(Categoria info) {
		Nohcategoria p = busca(info);
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

	public Nohcategoria busca(Categoria info) {
		Nohcategoria resultado = null;
		for (Nohcategoria i = inicio; i != null && i.getInfo() != info; i = i.getProx()) {
			if (i.getInfo() == info)
				resultado = i;
		}
		return resultado;
	}

	public Nohcategoria busca(int id) {
		Nohcategoria resultado = null;
		for (Nohcategoria i = inicio; i != null; i = i.getProx()) {
			if (i.getInfo().getId() == id)
				resultado = i;
		}
		return resultado;
	}

	public Categoria get(int id) {
		Nohcategoria noh = busca(id);
		if (noh != null)
			return noh.getInfo();
		return null;
	}

	public boolean contem(int id) {
		if (busca(id) != null)
			return true;
		return false;
	}

	public int tamanho() {
		int cont = 0;
		for (Nohcategoria i = inicio; i != null; i = i.getProx())
			cont++;
		return cont;
	}

	public void imprimeInicioAFim() {
		for (Nohcategoria i = inicio; i != null; i = i.getProx())
			System.out.println(i.toString() + "\n");
	}

	public void imprimeFimAInicio() {
		for (Nohcategoria i = fim; i != null; i = i.getAnt())
			System.out.println(i.toString() + "\n");
	}
	
	public boolean atualizarListaComArquivo(String arquivo) {
		try {
			LDE lista = Arquivo.getLinhas(arquivo);
			Noh noh = lista.getInicio();
			do {
				//os dados devem vir do arquivo no formato: id;nome
				String linha = (String) noh.getInfo();
				String dados[] = linha.split(";");
				if (dados.length == 2) {
					insereFim(new Categoria(Integer.parseInt(dados[0]), dados[1]));
				} else {
					System.out.println("Formato do arquivo de categorias inválido!");
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
		String conteudo = "id;nome\n";
		for (Nohcategoria i = inicio; i != null; i = i.getProx()) {
			Categoria cat = i.getInfo();
			conteudo += cat.getId() + ";" + cat.getNome();
		}
		try {
			Arquivo.gravar(conteudo, arquivo);
		} catch (Exception e) {
			System.out.println("Erro ao gravar o arquivo das Categorias!");
			return false;
		}
		return true;
	}
}
