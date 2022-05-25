package listas;

import base.Locacao;

public class LDElocacoes {
	private Nohlocacoes inicio;
	private Nohlocacoes fim;

	public LDElocacoes() {
			this.inicio = null;
			this.fim = null;
		}

	public void insereInicio(Locacao info) { 
		Nohlocacoes novo = new Nohlocacoes(info);
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

	public void insereFim(Locacao info) {
		Nohlocacoes novo = new Nohlocacoes(info);
		if (fim == null) {
			inicio = novo;
			fim = novo;
		} else {
			novo.setAnt(fim);
			fim.setProx(novo);
			fim = novo;
		}
	}

	public boolean remove(Locacao info) {
		Nohlocacoes p = busca(info);
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

	public Nohlocacoes busca(Locacao info) {
		Nohlocacoes resultado = null;
		for (Nohlocacoes i = inicio; i != null && i.getInfo() != info; i = i.getProx()) {
			if (i.getInfo() == info)
				resultado = i;
		}
		return resultado;
	}
	
	public Nohlocacoes busca(String placa) {
		Nohlocacoes resultado = null;
		for (Nohlocacoes i = inicio; i != null && i.getInfo().getPlaca() != placa; i = i.getProx()) {
			if (i.getInfo().getPlaca() == placa)
				resultado = i;
		}
		return resultado;
	}
	
	public Locacao get(String placa) {
		Nohlocacoes nohLoc = busca(placa);
		if(nohLoc != null)
			return nohLoc.getInfo();
		return null;	
	}
	
	public boolean possuiLocacao(String placa) {
		if (busca(placa) != null)
			return true;
		return false;
	}
	
	public boolean possuiLocacao(long CNH){
		for (Nohlocacoes i = inicio; i != null && i.getInfo().getCNH() != CNH; i = i.getProx()) {
			if (i.getInfo().getCNH() == CNH)
				return true;
		}
		return false;
	}
	
	public boolean estahLocado(String placa) {
		for (Nohlocacoes i = inicio; i != null; i = i.getProx())
			if(i.getInfo().getPlaca() == placa) return true;
		return false;
	}
	
	public boolean estahLocado(long CNH) {
		for (Nohlocacoes i = inicio; i != null; i = i.getProx())
			if(i.getInfo().getCNH() == CNH) return true;
		return false;
	}

	public int tamanho() {
		int cont = 0;
		for (Nohlocacoes i = inicio; i != null; i = i.getProx())
			cont++;
		return cont;
	}

	public void imprimeInicioAFim() {
		for (Nohlocacoes i = inicio; i != null; i = i.getProx())
			System.out.println(i.toString() + "\n");
	}

	public void imprimeFimAInicio() {
		for (Nohlocacoes i = fim; i != null; i = i.getAnt())
			System.out.println(i.toString() + "\n");
	}
}
