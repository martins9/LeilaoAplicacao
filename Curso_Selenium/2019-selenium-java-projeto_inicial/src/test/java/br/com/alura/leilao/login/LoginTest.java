package br.com.alura.leilao.login;


import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LoginTest {
	
	private LoginPage paginaDeLogin;
	
	@BeforeEach
	public void BeforeEach() {
		this.paginaDeLogin = new LoginPage();
	}
	
	@AfterEach 
	public void afterEach() {
		this.paginaDeLogin.fecharBrowser();
	}
	
	
	@Test
	public void deveriaEfetuarLoginComDadosValidos() {
		
		paginaDeLogin.preencherFormulario("fulano", "pass");
		paginaDeLogin.efetuarLogin();
			
		Assert.assertTrue(paginaDeLogin.isPaginaDeLogin("dadosValidos"));
		Assert.assertEquals("fulano",paginaDeLogin.getNomeUsuarioLogado());
	}
	
	@Test
	public void naoDeveriaLogarComDadosInValidos() {
		
		paginaDeLogin.preencherFormulario("invalido", "123131");
		paginaDeLogin.efetuarLogin();
		
		Assert.assertTrue(paginaDeLogin.isPaginaDeLogin("dadosInvalidos"));
		Assert.assertNull(paginaDeLogin.getNomeUsuarioLogado());
		Assert.assertTrue(paginaDeLogin.contemTexto("Usuário e senha inválidos."));
	}
	
	@Test
	public void naoDeveriaAcessarPaginaRestritaSemEstarLogado() {
		
		paginaDeLogin.navegaParaPaginaDeLances();
		
		Assert.assertTrue(paginaDeLogin.isPaginaDeLogin("semLogin"));
		Assert.assertFalse(paginaDeLogin.contemTexto("Dados do Leilão"));
	}
}
