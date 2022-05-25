package listas;

import base.Cliente;

public class Nohcliente {
	private Cliente info;
	private Nohcliente prox;
	private Nohcliente ant;

	public Nohcliente(Cliente info2) {
		this.info = info2;
		this.prox = null;
		this.ant = null;
	}

	public Cliente getInfo() {
		return info;
	}

	public Nohcliente getProx() { 
		return prox;
	}

	public void setAnt(Nohcliente n) {
		this.ant = n;
	}
	
	public Nohcliente getAnt() { 
		return ant;
	}

	public void setProx(Nohcliente n) {
		this.prox = n;
	}
	
	public String toString() {
		return info.toString();
	}

}
