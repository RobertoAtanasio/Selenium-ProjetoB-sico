package br.ce.wcaquino.pages;

import org.openqa.selenium.By;

import br.ce.wcaquino.core.BasePage;

public class ContasPage extends BasePage {

	public void setNome(String nome) {
		escrever("nome", nome);
	}
	
	public void salvar(){
		clicarBotao(By.xpath("//button[.='Salvar']"));
	}
	
	public String obterMensagemSucesso(){
		return obterTexto(By.xpath("//div[@class='alert alert-success']"));
//		return obterTexto(By.xpath("//div[@role='alert'][text()='Conta adicionada com sucesso!']"));
	}
	
	public String obterMensagemErro(){
		return obterTexto(By.xpath("//div[@class='alert alert-danger']"));
	}
	
	public void clicarAlterarConta(String valorBusca) {
		obterCelula("Conta", valorBusca, "Acoes", "tabelaContas")
			.findElement(By.xpath(".//span[@class='glyphicon glyphicon-edit']")).click();
	}
	
	public void clicarExcluirConta(String string) {
		obterCelula("Conta", string, "Acoes", "tabelaContas")
			.findElement(By.xpath(".//span[@class='glyphicon glyphicon-remove-circle']")).click();
	}
}
