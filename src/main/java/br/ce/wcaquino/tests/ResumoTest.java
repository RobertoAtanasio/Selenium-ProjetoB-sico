package br.ce.wcaquino.tests;

import java.util.List;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import br.ce.wcaquino.core.BaseTest;
import br.ce.wcaquino.core.DriverFactory;
import br.ce.wcaquino.pages.MenuPage;
import br.ce.wcaquino.pages.ResumoPage;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ResumoTest extends BaseTest {

	private MenuPage menuPage = new MenuPage();
	private ResumoPage resumoPage = new ResumoPage();

	@Test
	public void test1ExcluirMovimentacao(){
		menuPage.acessarTelaResumo();
		
//		resumoPage.selecionarCombo("mes", "Setembro");
//		resumoPage.selecionarCombo("ano", "2017");
//		resumoPage.pesquisarResumo();
		
		resumoPage.excluirMovimentacao();
		
		Assert.assertEquals("Movimentação removida com sucesso!",
				resumoPage.obterMensagemSucesso());
	}
	
//	@Test(expected=NoSuchElementException.class)	// este tipo é muito genérico e não é legal, pois não só o findElement
													// irá gerar a exceção. Outra causa poderá também gerar a exceção
	@Test
	public void test2ResumoMensal(){
		menuPage.acessarTelaResumo();
		Assert.assertEquals("Seu Barriga - Extrato", DriverFactory.getDriver().getTitle());
		
//		DriverFactory.getDriver().findElement(By.xpath("//*[@id='tabelaExtrato']/tbody/tr"));
		
//		try{
//			DriverFactory.getDriver().findElement(By.xpath("//*[@id='tabelaExtrato']/tbody/tr"));
//			Assert.fail();		// forçar a falha caso não seja lançado nenhuma exceção
//		} catch (NoSuchElementException e) {
//			
//		}
		
		List<WebElement> elementosEncontrados = DriverFactory.getDriver()
				.findElements(By.xpath("//*[@id='tabelaExtrato']/tbody/tr"));
		Assert.assertEquals(0, elementosEncontrados.size());
	}
}
