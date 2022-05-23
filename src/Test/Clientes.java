package Test;

public class Clientes {
	private LDE lista;
	
	

	public Clientes() {
		this.lista = lista;
	}

	public void insereInicio(Cliente info) {
		lista.insereInicio(info);
	}

	public void insereFim(Cliente info) {
		lista.insereFim(info);
	}

	public boolean estahVazia() {
		return lista.estahVazia();
	}

	public boolean remove(Cliente info) {
		return lista.remove(info);
	}

	public int tamanho() {
		return lista.tamanho();
	}

	public void imprimeInicioAFim() {
		lista.imprimeInicioAFim();
	}

	public void imprimeFimAInicio() {
		lista.imprimeInicioAFim();
	}

}
