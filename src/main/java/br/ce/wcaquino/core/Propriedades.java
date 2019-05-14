package br.ce.wcaquino.core;

public class Propriedades {
	
	public static boolean FECHAR_BROWSER = true;
	
	public static Browsers BROWSER = Browsers.FIREFOX;
	
	public static TipoExecucao TIPO_EXECUCAO = TipoExecucao.GRID;
	
//	public static String NOME_CONTA_ALTERADA = "Conta Alterada " + System.nanoTime();  
	
	public enum Browsers {
		CHROME,
		FIREFOX
	}

	public enum TipoExecucao {
		LOCAL,
		GRID
	}
}
