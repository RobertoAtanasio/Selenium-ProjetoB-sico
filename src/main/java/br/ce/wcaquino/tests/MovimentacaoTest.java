package br.ce.wcaquino.tests;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import br.ce.wcaquino.core.BaseTest;
import br.ce.wcaquino.core.Propriedades;
import br.ce.wcaquino.pages.MenuPage;
import br.ce.wcaquino.pages.MovimentacaoPage;
import br.ce.wcaquino.utils.DataUtils;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MovimentacaoTest extends BaseTest {

	private MenuPage menuPage = new MenuPage();
	private MovimentacaoPage movPage = new MovimentacaoPage();
	
	@Test
	public void test1InserirMovimentacao(){
		
		menuPage.acessarTelaInserirMovimentacao();
		movPage.setDataMovimentacao(DataUtils.obterDataFormatada(new Date()));
		movPage.setDataPagamento(DataUtils.obterDataFormatada(new Date()));
		movPage.setDescricao("Movimentação do Teste");
		movPage.setInteressado("Interessado Qualquer");
		movPage.setValor("350");
		movPage.setConta(Propriedades.NOME_CONTA_ALTERADA);
		movPage.setStatusPago();
		movPage.salvar();
		String mensagem = movPage.obterMensagemSucesso();
		Assert.assertEquals("Movimentação adicionada com sucesso!", mensagem);
	}
	
	@Test
	public void test2CamposObrigatorios(){
		menuPage.acessarTelaInserirMovimentacao();
		movPage.salvar();
		List<String> erros = movPage.obterErros();
//		Assert.assertEquals("Data da Movimentação é obrigatório", erros.get(0));
//		Assert.assertTrue(erros.contains("Data da Movimentação é obrigatório"));
		Assert.assertTrue(erros.containsAll(Arrays.asList(
				"Data da Movimentação é obrigatório", 
				"Data do pagamento é obrigatório",
				"Descrição é obrigatório", 
				"Interessado é obrigatório", 
				"Valor é obrigatório", 
				"Valor deve ser um número")));
		Assert.assertEquals(6, erros.size());
	}
	
	@Test
	public void test3InserirMovimentacaoFutura(){
		menuPage.acessarTelaInserirMovimentacao();
		
		Date dataFutura = DataUtils.obterDataComDiferencaDias(5);
		
		movPage.setDataMovimentacao(DataUtils.obterDataFormatada(dataFutura));
		movPage.setDataPagamento(DataUtils.obterDataFormatada(dataFutura));
		movPage.setDescricao("Movimentação do Teste");
		movPage.setInteressado("Interessado Qualquer");
		movPage.setValor("500");
		movPage.setConta(Propriedades.NOME_CONTA_ALTERADA);
		movPage.setStatusPago();
		movPage.salvar();
		
		List<String> erros = movPage.obterErros();
		Assert.assertTrue(
				erros.contains("Data da Movimentação deve ser menor ou igual à data atual"));
		Assert.assertEquals(1, erros.size());
	}
	
//	@Test
//	public void teste() {
//		String[] listas = getLista();
//		for (int i = 0; i < listas.length; i++) {
//			System.out.println(getMensagemLista(i));
//		}
//	}
//	
//	public String[] getLista() {
//		String[] listas = new String[] {
//				"Data da Movimentação é obrigatório",
//				"Data do pagamento é obrigatório",
//				"Descrição é obrigatório",
//				"Interessado é obrigatório",
//				"Valor é obrigatório",
//				"Valor deve ser um número"};
//		return listas;
//	}
//	
//	public String getMensagemLista(int indice) {
//		String[] listas = new String[] {};
//		listas = getLista();
//		return listas[indice];
//	}
}
