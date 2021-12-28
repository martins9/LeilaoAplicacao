package br.com.alura.leilao.login;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import br.com.alura.leilao.PageObject;
import br.com.alura.leilao.leiloes.LeiloesPage;

public class LoginPage extends PageObject{

	private static final String URL_LOGIN = "http://localhost:9090/login";
	
	public LoginPage() {
		super(null);
		this.browser.navigate().to(URL_LOGIN);
	}

	public LoginPage preencherFormulario(String username, String password) {
		
		browser.findElement(By.xpath("//*[@id=\"login-form\"]/div[1]/input")).sendKeys(username);
		browser.findElement(By.xpath("//*[@id=\"login-form\"]/div[2]/input")).sendKeys(password);
		
		return this;
	}

	public LeiloesPage efetuarLogin() {
		browser.findElement(By.id("login-form")).submit();
		return new LeiloesPage(browser);
	}

	public boolean isPaginaDeLogin(String tipoUrl) {
		
		boolean varBool = false;
		if(tipoUrl.equals("dadosValidos")) {
			varBool = browser.getCurrentUrl().equals("http://localhost:9090/leiloes");
		}
		else if (tipoUrl.equals("dadosInvalidos")) {
			varBool = browser.getCurrentUrl().equals(URL_LOGIN+"?error");
		}
		else if(tipoUrl.equals("semLogin")) {
			varBool = browser.getCurrentUrl().equals(URL_LOGIN);
		}
		return varBool;
	}

	public String getNomeUsuarioLogado() {
		try {
			return browser.findElement(By.xpath("/html/body/div[1]/span/span")).getText();
		} catch (NoSuchElementException e) {
			return null;
		}
	}

	public void navegaParaPaginaDeLances() {
		this.browser.navigate().to("http://localhost:9090/leiloes/2");
	}

	public boolean contemTexto(String texto) {
		return browser.getPageSource().contains(texto);
	}
	
}
