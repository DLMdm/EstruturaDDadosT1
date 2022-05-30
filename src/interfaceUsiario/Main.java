package interfaceUsiario;

public class Main {
	
	private static String arqCat = ".\\src\\Categorias.csv";
	private static String arqCli = ".\\src\\Clientes.csv";
	private static String arqVei = ".\\src\\Veiculos.csv";

	public static void main(String[] args) {
		OperacoesCategorias.getOperacoes().atualizarListaComArquivo(arqCat);
		OperacoesClientes.getOperacoes().atualizarListaComArquivo(arqCli);
		OperacoesVeiculos.getOperacoes().atualizarListaComArquivo(arqVei);
		
		System.out.println("Bem vindo à PampaLoca & Cia LTDA!\n");
		
		InteracaoUsuario interacao = new InteracaoUsuario();
		interacao.PainelInicial();
		
		OperacoesCategorias.getOperacoes().gravarEmArquivo(arqCat);
		OperacoesClientes.getOperacoes().garavarEmArquivo(arqCli);
		OperacoesVeiculos.getOperacoes().gravarEmArquivo(arqVei);
	}

}
