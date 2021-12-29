package br.com.alura.leilao.leiloes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import br.com.alura.leilao.PageObject;


public class LeiloesPage extends PageObject{

	public LeiloesPage(WebDriver browser) {
		super(browser);
	}

	public CadastroLeilaoPage carregarFormulario() {
		this.browser.findElement(By.id("novo_leilao_link")).click();
		return new CadastroLeilaoPage(browser);
	}

	public boolean isLeilaoCadastrado(String nome, String valor, String hoje) {
		WebElement linhaDaTabela = this.browser.findElement(By.cssSelector("#tabela-leiloes tbody tr:last-child"));
		WebElement colunaNome = linhaDaTabela.findElement(By.cssSelector("td:nth-child(1)"));
		WebElement colunaDataAbertura = linhaDaTabela.findElement(By.cssSelector("td:nth-child(2)"));
		WebElement colunaValorInicial = linhaDaTabela.findElement(By.cssSelector("td:nth-child(3)"));
		
		return colunaNome.getText().equals(nome) &&
				colunaDataAbertura.getText().equals(hoje) &&
				colunaValorInicial.getText().equals(valor);
	}

	
}
