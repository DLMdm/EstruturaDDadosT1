package interfaceUsiario;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import base.Locacao;
import listas.LDElocacoes;

public class OperacoesLocacoes {

	private static OperacoesLocacoes operacoes = new OperacoesLocacoes();
	private LDElocacoes locacoes;

	private OperacoesLocacoes() {
		locacoes = new LDElocacoes();
	}

	public static OperacoesLocacoes getOperacoes() {
		return operacoes;
	}

	public boolean iniciarLocacao() {
		String placa = SysIn.pedePlaca();
		long CNH = SysIn.pedeCNH();
		Date datInicio = Calendar.getInstance().getTime();
		Date datFim = null;
		double valor = 0;
		locacoes.insereFim(new Locacao(CNH, placa, datInicio, datFim, valor));
		System.out.println("Ve�culo locado!");
		return true;
	}

	public void encerraLocacao() {
		String placa = SysIn.pedePlaca();
		if(estahLocado(placa)) {
			String dataInicial = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(locacoes.get(placa).getDatInicio());
			double valor = SysIn.inDouble("Qual � o valor da loca��o realizada desde " + dataInicial + "?");
			locacoes.get(placa).setDatFim(Calendar.getInstance().getTime());
			locacoes.get(placa).setValor(valor);
			System.out.println("Loca��o encerrada com sucesso!");
		}else System.out.println("Este veiculo n�o est� locado!");
	}
	
	public Locacao get(String placa) {
		return locacoes.get(placa);
	}
	
	public boolean estahLocado(String placa) {
		return locacoes.estahLocado(placa);
	}
	
	public boolean estahLocado(long CNH) {
		return locacoes.estahLocado(CNH);
	}
	
	public void imprime() {
		String placa = SysIn.pedePlaca();
		Locacao loc = locacoes.get(placa);
		if (loc != null) {
			System.out.println(loc.toString());
			System.out.println("Altera��o conclu�da!");
		} else
			System.out.println("veiculo n�o encontrado!");
	}
	
	public void imprimeInicioAFim() {
		locacoes.imprimeInicioAFim();
	}

	public void imprimeFimAInicio() {
		locacoes.imprimeFimAInicio();
	}
	
}
