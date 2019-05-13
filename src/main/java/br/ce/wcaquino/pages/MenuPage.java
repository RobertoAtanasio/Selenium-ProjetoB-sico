package br.ce.wcaquino.pages;

import org.openqa.selenium.By;

import br.ce.wcaquino.core.BasePage;

public class MenuPage extends BasePage {

	public void acessarTelaInserirConta(){
//		clicarLink("Contas ");
//		clicarLink("Adicionar");
		clicarLink(By.xpath("//a[@class='dropdown-toggle'][text()='Contas ']"));
		clicarLink(By.xpath("//a[text()='Adicionar']"));
	}
	
	public void acessarTelaListarConta(){
//		clicarLink("Contas ");
//		clicarLink("Listar");
		clicarLink(By.xpath("//a[@class='dropdown-toggle'][text()='Contas ']"));
		clicarLink(By.xpath("//a[text()='Listar']"));
	}
	
	public void acessarTelaInserirMovimentacao(){
		clicarLink("Criar Movimentação");
	}
	
	public void acessarTelaResumo(){
		clicarLink("Resumo Mensal");
	}
	
	public void acessarTelaPrincipal(){
		clicarLink("Home");
	}
	
}
