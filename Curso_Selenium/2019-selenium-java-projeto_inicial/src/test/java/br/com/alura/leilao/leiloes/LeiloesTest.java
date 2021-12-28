package br.com.alura.leilao.leiloes;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.alura.leilao.login.LoginPage;

public class LeiloesTest {
	
	private LeiloesPage paginaDeLeiloes;
	private CadastroLeilaoPage paginaDeCadastro;
	
	@BeforeEach
	public void beforeEach() {
		LoginPage paginaDeLogin = new LoginPage();
		this.paginaDeLeiloes = paginaDeLogin.preencherFormulario("fulano", "pass").efetuarLogin();
		this.paginaDeCadastro = paginaDeLeiloes.carregarFormulario();
	}
	
	@AfterEach 
	public void afterEach() {
		this.paginaDeLeiloes.fecharBrowser();
	}
	
	@Test
	public void deveriaCadastrarLeilao() {
		
		String hoje = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		String nome = "Leilao do dia " + hoje;
		String valor = "500.00";
		
		this.paginaDeLeiloes = paginaDeCadastro.cadastrarLeilao(nome, valor, hoje);
		Assert.assertTrue(paginaDeLeiloes.isLeilaoCadastrado(nome, valor, hoje));
	}
	
	@Test
	public void deveriarValidarCadastroDeLeilao() {
		
		this.paginaDeLeiloes = paginaDeCadastro.cadastrarLeilao("", "", "");
		Assert.assertFalse(this.paginaDeCadastro.isPaginaAtual());
		Assert.assertTrue(this.paginaDeCadastro.isMensagensDeValidacaoVisiveis());
	}
}
