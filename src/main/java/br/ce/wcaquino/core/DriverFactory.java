package br.ce.wcaquino.core;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import br.ce.wcaquino.core.Propriedades.TipoExecucao;

public class DriverFactory {

	private static ThreadLocal<WebDriver> threadDriver = new ThreadLocal<WebDriver>(){
		@Override
		protected synchronized WebDriver initialValue(){
			return initDriver();
		}
	};
	
	private DriverFactory() {}

	public static WebDriver getDriver(){
		return threadDriver.get();
	}
	
	public static WebDriver initDriver(){
		System.out.println("==> Inicializando WebDriver");
		System.out.println("==> Propriedades.TIPO_EXECUCAO " + Propriedades.TIPO_EXECUCAO);
		WebDriver driver = null;
		if (Propriedades.TIPO_EXECUCAO == TipoExecucao.LOCAL) {
			switch (Propriedades.BROWSER) {
				case FIREFOX: driver = new FirefoxDriver(); break;
				case CHROME: driver = new ChromeDriver(); break;
				case IE: driver = new InternetExplorerDriver(); break;
			}			
		} 
		if(Propriedades.TIPO_EXECUCAO == TipoExecucao.GRID) {
			DesiredCapabilities cap = null;
			switch (Propriedades.BROWSER) {
				case FIREFOX: cap = DesiredCapabilities.firefox(); break;
				case CHROME: cap = DesiredCapabilities.chrome(); break;
				case IE: driver = new InternetExplorerDriver(); break;
			}
			try {
				//-----------------------------------------------------------------------------------
//				System.out.println("==> cap: " + cap);
//				System.out.println("==> definindo o Driver: " + Propriedades.BROWSER);
//				
//				URL url = new URL("http://192.168.0.12:4444/wd/hub");
//				System.out.println("==> URL: " + url);
//				
//				RemoteWebDriver remote = new RemoteWebDriver(url, cap);				
//				System.out.println("==> RemoteWebDriver: " + remote);
//				
//				driver = remote;
//				System.out.println("==> Driver: " + driver);
				//-----------------------------------------------------------------------------------
				
				driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), cap);
				
			} catch (MalformedURLException e) {
				System.out.println("==> Falha na conexão com o GRID");
//				System.err.println("==> Falha na conexão com o GRID");
				e.printStackTrace();
			}
		}
		if(Propriedades.TIPO_EXECUCAO == TipoExecucao.NUVEM) {
			DesiredCapabilities cap = null;
			switch (Propriedades.BROWSER) {
				case FIREFOX: cap = DesiredCapabilities.firefox(); break;
				case CHROME: cap = DesiredCapabilities.chrome(); break;
				case IE: cap = DesiredCapabilities.internetExplorer();
					cap.setCapability("platform", "Windows 10");
					cap.setCapability("version", "11.0"); 
				break;
			}
			try {			
				System.out.println("==> Inicializando driver");
				driver = new RemoteWebDriver(new URL("http://RobertoAPL:6d11e286-4f27-40ba-85a3-5eb47eb93596@ondemand.saucelabs.com:80/wd/hub"), cap);
				System.out.println("==> Driver criado: " + driver);
				
			} catch (MalformedURLException e) {
				System.err.println("==> Falha na conexão com a Saucelabs");
				e.printStackTrace();
			}
		}
		driver.manage().window().setSize(new Dimension(1200, 765));			
		return driver;
	}
	
	public static void killDriver(){
		WebDriver driver = getDriver();
		if(driver != null) {
			driver.quit();
			driver = null;
		}
		if(threadDriver != null) {
			threadDriver.remove();
		}
	}
}

//public class DriverFactory {
//
//	private DriverFactory() {}
//	
//	private static WebDriver driver;	
//	
//	public static WebDriver getDriver(){
//		if(driver == null) {
//			switch (Propriedades.browser) {
//				case FIREFOX: driver = new FirefoxDriver(); break;
//				case CHROME: driver = new ChromeDriver(); break;
//			}
//			driver.manage().window().setSize(new Dimension(1200, 765));			
//		}
//		return driver;
//	}
//
//	public static void killDriver(){
//		if(driver != null) {
//			driver.quit();
//			driver = null;
//		}
//	}
//	
//}
