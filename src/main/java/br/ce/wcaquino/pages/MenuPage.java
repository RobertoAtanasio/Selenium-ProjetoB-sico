package br.ce.wcaquino.pages;

import org.openqa.selenium.By;

import br.ce.wcaquino.core.BasePage;

public class MenuPage extends BasePage {

	public void acessarTelaInserirConta(){
		clicarLink(By.xpath("//a[text()='Contas ']"));
		clicarLink(By.xpath("//a[text()='Adicionar']"));
	}
	
	public void acessarTelaListarConta(){
		clicarLink(By.xpath("//a[text()='Contas ']"));
		clicarLink(By.xpath("//a[text()='Listar']"));
	}
	
	public void acessarTelaInserirMovimentacao(){
		clicarLink(By.xpath("//a[@href='/movimentacao']"));
//		clicarLink(By.xpath("//a[text()='Criar Movimentação']"));
//		clicarLink("Criar Movimentação");
	}
	
	public void acessarTelaResumo(){
		clicarLink(By.xpath("//a[@href='/extrato']"));
//		clicarLink("Resumo Mensal");
	}
	
	public void acessarTelaPrincipal(){
		clicarLink("Home");
	}
}
