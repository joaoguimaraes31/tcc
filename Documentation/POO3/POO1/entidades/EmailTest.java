/*
 * Created on 25/04/2005
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
public class EmailTest extends TestCase {

	private String str;
	private Preco obj;
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
	 * Constructor for EmailTest.
	 * @param arg0
	 */
	public EmailTest(String arg0) {
		super(arg0);
	}

	public final void testSetEmail() {
//		Atribuição correta de email//
		Email obj = new Email();
		str="fredericofurlan@yahoo.com.br";
		assertEquals("Erro de Atribuição de email:", obj.setEmail(str), Codigo.OK);
		
		// Comprimento menor que o permitido
		str = "";
		assertEquals("Erro de NÃO detecção do comprimento mínimo:", 
				obj.setEmail(str), Codigo.COMPRIMENTO_INVALIDO);
		
		//Comprimento maior que o permitido
		str = "frederiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiicofurlan@yahoo.com.br";
		assertEquals("Erro de NÃO detecção do comprimento máximo:", 
				obj.setEmail(str), Codigo.COMPRIMENTO_INVALIDO);
		
		// Caracter inválido
		str = "frederico,furlan@yahoo.com.br";
		assertEquals("Erro de NÃO detecção de caractere inválido:", 
				obj.setEmail(str), Codigo.CARACTER_INVALIDO);
		
		// Formato inválido
		str = "fredericofurlan@yahoo@com.br";
		assertEquals("Erro de NÃO detecção de formato inválido:", 
				obj.setEmail(str), Codigo.FORMATO_INVALIDO); 
	}

	public final void testGetEmail() {
		Email obj = new Email();
		str="fredericofurlan@yahoo.com.br";
		obj.setEmail(str);
		
		// Valor lido igual a valor inserido
		assertEquals("Erro, valor lido não corresponde a valor inserido:", obj.getEmail(), str);
	}

}
