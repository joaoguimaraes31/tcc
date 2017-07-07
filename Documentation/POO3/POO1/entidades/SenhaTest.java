/*
 * Created on 23/04/2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package entidades;

import junit.framework.TestCase;

/**
 * @author yury
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class SenhaTest extends TestCase {
	
	 private String senha;
	 private Senha objSenha;

	/*
	 * @see TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		super.setUp();
		
	}

	/*
	 * @see TestCase#tearDown()
	 */
	protected void tearDown() throws Exception {
		super.tearDown();
	}

	/**
	 * Constructor for SenhaTest.
	 * @param arg0
	 */
	public SenhaTest(String arg0) {
		super(arg0);
	}

	public final void testSetSenha() {
		
		//Atribui��o correta de senha//
		Senha objSenha = new Senha();
		senha="12abcdef";
		assertEquals("Erro de Atribui��o de senha:", objSenha.setSenha(senha), Codigo.OK);
		
		// Comprimento menor que o permitido
		senha = "qd345";
		assertEquals("Erro de N�O detec��o do comprimento m�nimo:", 
				objSenha.setSenha(senha), Codigo.COMPRIMENTO_INVALIDO);
		
		// Comporimento maior que o permitido
		senha = "qd345ffffffsdfsgertrthrhyhthytjtyjty";
		assertEquals("Erro de N�O detec��o do comprimento m�ximo:", 
				objSenha.setSenha(senha), Codigo.COMPRIMENTO_INVALIDO);
		
		// Caracter inv�lido
		senha = "qd345,.";
		assertEquals("Erro de N�O detec��o de caractere inv�lido:", 
				objSenha.setSenha(senha), Codigo.CARACTER_INVALIDO);
	}
	

	public final void testGetSenha() {
		Senha objSenha = new Senha();
		senha="12abcdef";
		objSenha.setSenha(senha);
		
		// Valor lido igual a valor inserido
		assertEquals("Erro, valor lido n�o corresponde a valor inserido:", objSenha.getSenha(), senha);
		
		
	}

}
