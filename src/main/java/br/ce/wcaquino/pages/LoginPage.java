package br.ce.wcaquino.pages;

import org.openqa.selenium.By;

import br.ce.wcaquino.core.BasePage;
import br.ce.wcaquino.core.DriverFactory;

public class LoginPage extends BasePage {

	public void acessarTelaInicial() {
		DriverFactory.getDriver().get("https://srbarriga.herokuapp.com");
	}
	
	public void setEmail(String email) {
		escrever("email", email);
	}
	
	public void setSenha(String senha) {
		escrever("senha", senha);
	}
	
	public void entrar() {
		clicarBotao(By.xpath("//button[.='Entrar']"));
//		clicarBotao(By.xpath("//button[text()='Entrar'][@type='submit']"));
	}
}