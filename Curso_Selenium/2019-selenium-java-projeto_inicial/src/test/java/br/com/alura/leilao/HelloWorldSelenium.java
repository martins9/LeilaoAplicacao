package br.com.alura.leilao;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HelloWorldSelenium {
	
	@Test
	public void hello() {
		
		System.setProperty("webdriver.chrome.driver", "D:\\CursoAluras\\Curso_Selenium\\2019-selenium-java-projeto_inicial\\drivers\\chromedriver.exe");
		WebDriver browser = new ChromeDriver();
		browser.navigate().to("http://localhost:9090/leiloes");
		browser.quit();
		
	}

}
