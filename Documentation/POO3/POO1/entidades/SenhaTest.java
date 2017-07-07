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
		
		//Atribuição correta de senha//
		Senha objSenha = new Senha();
		senha="12abcdef";
		assertEquals("Erro de Atribuição de senha:", objSenha.setSenha(senha), Codigo.OK);
		
		// Comprimento menor que o permitido
		senha = "qd345";
		assertEquals("Erro de NÃO detecção do comprimento mínimo:", 
				objSenha.setSenha(senha), Codigo.COMPRIMENTO_INVALIDO);
		
		// Comporimento maior que o permitido
		senha = "qd345ffffffsdfsgertrthrhyhthytjtyjty";
		assertEquals("Erro de NÃO detecção do comprimento máximo:", 
				objSenha.setSenha(senha), Codigo.COMPRIMENTO_INVALIDO);
		
		// Caracter inválido
		senha = "qd345,.";
		assertEquals("Erro de NÃO detecção de caractere inválido:", 
				objSenha.setSenha(senha), Codigo.CARACTER_INVALIDO);
	}
	

	public final void testGetSenha() {
		Senha objSenha = new Senha();
		senha="12abcdef";
		objSenha.setSenha(senha);
		
		// Valor lido igual a valor inserido
		assertEquals("Erro, valor lido não corresponde a valor inserido:", objSenha.getSenha(), senha);
		
		
	}

}
