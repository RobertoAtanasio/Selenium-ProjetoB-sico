package br.ce.wcaquino.pages;

import org.openqa.selenium.By;

import br.ce.wcaquino.core.BasePage;

public class ResumoPage extends BasePage {

	public void excluirMovimentacao(){
		clicarBotao(By.xpath("//span[@class='glyphicon glyphicon-remove-circle']"));
	}
	
	public String obterMensagemSucesso(){
		return obterTexto(By.xpath("//div[@class='alert alert-success']"));
	}
	
	public void pesquisarResumo() {
//		clicarBotao(By.xpath("//input[@value='Buscar']"));
		clicarBotao(By.xpath("//input[@type='submit'][@value='Buscar']"));
	}
	
	public void selecionarAno(String ano) {
		selecionarCombo("ano", ano);
	}
	
	public void selecionarMes(String mes) {
		selecionarCombo("mes", mes);
	}
}
