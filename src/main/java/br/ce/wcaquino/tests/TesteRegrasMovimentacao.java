package br.ce.wcaquino.tests;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import br.ce.wcaquino.core.BaseTest;
import br.ce.wcaquino.pages.MenuPage;
import br.ce.wcaquino.pages.MovimentacaoPage;

@RunWith(Parameterized.class)
public class TesteRegrasMovimentacao extends BaseTest {

	private MenuPage menuPage = new MenuPage();
	private MovimentacaoPage movPage = new MovimentacaoPage();
	
	@Parameter
	public String dataMovimentacao;
	@Parameter(value=1)
	public String dataPagamento;
	@Parameter(value=2)
	public String descricao;
	@Parameter(value=3)
	public String interessado;
	@Parameter(value=4)
	public String valor;
	@Parameter(value=5)
	public String conta;
	@Parameter(value=6)
	public boolean statusPago;
	@Parameter(value=7)
	public String msg;
	
	public static String getMensagemLista(int indice) {
		String[] listas = new String[] {
				"Movimentação adicionada com sucesso!",
				"Data da Movimentação é obrigatório",
				"Data do pagamento é obrigatório",
				"Descrição é obrigatório",
				"Interessado é obrigatório",
				"Valor é obrigatório",
				"Valor deve ser um número"};
		return listas[indice];
	}
	
	@Parameters
	public static Collection<Object[]> getCollection(){
		return Arrays.asList(new Object[][] {
			{"", "02/09/2017", "Movimentação do Teste", "Interessado Qualquer", "500", "Conta do Teste alterada", true, "Data da Movimentação é obrigatório"}
		});
	}

//	{"01/09/2017", "02/09/2017", "Movimentação do Teste", "Interessado Qualquer", "500", "Conta do Teste alterada", true, getMensagemLista(0)}

//	{"01/09/2017", "", "Movimentação do Teste", "Interessado Qualquer", "500", "Conta do Teste alterada", true, getMensagemLista(1)},
//	{"01/09/2017", "02/09/2017", "", "Interessado Qualquer", "500", "Conta do Teste alterada", true, getMensagemLista(2)},
//	{"01/09/2017", "02/09/2017", "Movimentação do Teste", "", "500", "Conta do Teste alterada", true, getMensagemLista(3)},
//	{"01/09/2017", "02/09/2017", "Movimentação do Teste", "Interessado Qualquer", "", "Conta do Teste alterada", true, getMensagemLista(4)},
//	{"01/09/2017", "02/09/2017", "Movimentação do Teste", "Interessado Qualquer", "500", "", true, getMensagemLista(5)}
	
	@Test
	public void deveValidarRegras(){
		menuPage.acessarTelaInserirMovimentacao();
		
		movPage.setDataMovimentacao(dataMovimentacao);
		movPage.setDataPagamento(dataPagamento);
		movPage.setDescricao(descricao);
		movPage.setInteressado(interessado);
		movPage.setValor(valor);
		movPage.setConta(conta);
		if (statusPago) {
			movPage.setStatusPago();
		} else {
			movPage.setStatusPendente();
		}
		movPage.salvar();
		
		System.out.println("Mensagem: " + msg);
		
		Assert.assertEquals(msg, movPage.obterMensagemErro());
	}
}
