package listas;

import base.Arquivo;
import base.Cliente;

public class LDEclientes {
	private Nohcliente inicio;
	private Nohcliente fim;

	public LDEclientes() {
		this.inicio = null;
		this.fim = null;
	}

	public void insereInicio(Cliente info) {
		Nohcliente novo = new Nohcliente(info);
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

	public void insereFim(Cliente info) {
		Nohcliente novo = new Nohcliente(info);
		if (fim == null) {
			inicio = novo;
			fim = novo;
		} else {
			novo.setAnt(fim);
			fim.setProx(novo);
			fim = novo;
		}
	}

	public boolean remove(Cliente info) {
		Nohcliente p = busca(info);
		if (p == null)
			return false;
		if (p.getAnt() == null) {
			inicio = p.getProx();
			if (inicio != null)
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

	public Nohcliente busca(Cliente info) {
		Nohcliente resultado = null;
		for (Nohcliente i = inicio; i != null ; i = i.getProx()) {
			if (i.getInfo().getCPF().equals(info.getCPF()))
				resultado = i;
		}
		return resultado;
	}

	public Nohcliente busca(Long cpf) {
		Nohcliente resultado = null;
		for (Nohcliente i = inicio; i != null; i = i.getProx()) {
			if (i.getInfo().getCPF().equals(cpf))
				return i;
		}
		return resultado;
	}

	public Cliente get(Long cpf) {
		Nohcliente noh = busca(cpf);
		if (noh != null)
			return noh.getInfo();
		return null;
	}

	public boolean contem(long cpf) {
		if (busca(cpf) != null)
			return true;
		return false;
	}

	public int tamanho() {
		int cont = 0;
		for (Nohcliente i = inicio; i != null; i = i.getProx())
			cont++;
		return cont;
	}

	public void imprimeInicioAFim() {
		for (Nohcliente i = inicio; i != null; i = i.getProx())
			System.out.println(i.toString() + "\n");
	}

	public void imprimeFimAInicio() {
		for (Nohcliente i = fim; i != null; i = i.getAnt())
			System.out.println(i.toString() + "\n");
	}

	public boolean atualizarListaComArquivo(String arquivo) {
		try {
			LDE lista = Arquivo.getLinhas(arquivo);
			Noh noh = lista.getInicio();
			do {
				// os dados devem vir do arquivo no formato: nome;CPF;CNH;Telefone
				String linha = (String) noh.getInfo();
				String dados[] = linha.split(";");
				if (dados.length == 4) {
					insereFim(new Cliente(dados[0], Long.parseLong(dados[2]), Long.parseLong(dados[3]),
							Long.parseLong(dados[1])));
				} else {
					System.out.println("Formato do arquivo de clientes inválido!");
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
		String conteudo = "nome;CPF;CNH;Telefone\n";
		for (Nohcliente i = inicio; i != null; i = i.getProx()) {
			Cliente cli = i.getInfo();
			conteudo += cli.getNome() + ";" + cli.getCPF() + ";" + cli.getCNH() + ";" + cli.getTelefone() + "\n";
		}
		try {
			Arquivo.gravar(conteudo, arquivo);
		} catch (Exception e) {
			System.out.println("Erro ao gravar o arquivo de clientes!");
			return false;
		}
		return true;
	}

}
