package interfaceUsiario;

import base.Categoria;
import listas.LDEcategorias;

public class OperacoesCategorias {

	private static OperacoesCategorias operacoes = new OperacoesCategorias();
	private LDEcategorias categorias;

	private OperacoesCategorias() {
		categorias = new LDEcategorias();
	}

	public static OperacoesCategorias getOperacoes() {
		return operacoes;
	}

	public void criaCategoria() {
		int id;
		do {
			id = SysIn.pedeIdCat();
			if (contem(id))
				System.out.println("Id já cadastrado!");
		} while (contem(id));
		String nome = SysIn.pedeNome();
		categorias.insereFim(new Categoria(id, nome));
		System.out.println("Categoria Registrada com sucesso!");
	}

	public Categoria get(int id) {
		return categorias.get(id);
	}

	public void alterarNome(int id) {
		if (contem(id)) {
			String nome = SysIn.inString("Qual é o novo nome da categoria?");
			categorias.get(id).setNome(nome);
			System.out.println("Alteração concluída!");
		} else
			System.out.println("Categoria não encontrado!");
	}

	public void excluiCategoria(int id) {
		if (contem(id)) {
			categorias.remove(categorias.get(id));
			System.out.println("Categoria excluida.");
		} else
			System.out.println("Categoria não encontrada!");
	}

	public boolean contem(int id) {
		return categorias.contem(id);
	}

	public boolean gravarEmArquivo(String arquivo) {
		return categorias.gravarEmArquivo(arquivo);
	}

	public boolean atualizarListaComArquivo(String arquivo) {
		return categorias.atualizarListaComArquivo(arquivo);
	}
	public void listaCategorias() {
		
	}

}
