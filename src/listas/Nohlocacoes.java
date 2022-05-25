package listas;

import base.Locacao;

public class Nohlocacoes {
	private Locacao info;
	private Nohlocacoes prox;
	private Nohlocacoes ant;

	public Nohlocacoes(Locacao info2) {
		this.info = info2;
		this.prox = null;
		this.ant = null;
	}

	public Locacao getInfo() {
		return info;
	}

	public Nohlocacoes getProx() { 
		return prox;
	}

	public void setAnt(Nohlocacoes n) {
		this.ant = n;
	}
	
	public Nohlocacoes getAnt() { 
		return ant;
	}

	public void setProx(Nohlocacoes n) {
		this.prox = n;
	}
	
	public String toString() {
		return info.toString();
	}

}
