package base;

public class Cliente {
	private String nome;
	private Long CNH, telefone, CPF;

	public Cliente(String nome, Long cNH, Long telefone, Long cPF) {
		this.nome = nome;
		CNH = cNH;
		this.telefone = telefone;
		CPF = cPF;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Long getCNH() {
		return CNH;
	}

	public void setCNH(Long cNH) {
		CNH = cNH;
	}

	public Long getTelefone() {
		return telefone;
	}

	public void setTelefone(Long telefone) {
		this.telefone = telefone;
	}

	public Long getCPF() {
		return CPF;
	}

	public void setCPF(Long cPF) {
		CPF = cPF;
	}

	@Override
	public String toString() {
		return "Cliente [nome=" + nome + ", CNH=" + CNH + ", telefone=" + telefone + ", CPF=" + CPF + "]";
	}

}
