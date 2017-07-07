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
public class IDUsuarioTest extends TestCase {

	private String str;
	private IDUsuario obj;
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
	 * Constructor for IDUsuarioTest.
	 * @param arg0
	 */
	public IDUsuarioTest(String arg0) {
		super(arg0);
	}

	public final void testSetIDUsuario() {
		
//		Atribui��o correta de Usuario//
		IDUsuario obj = new IDUsuario();
		str="u123";
		assertEquals("Erro de Atribui��o de quantidade:", obj.setIDUsuario(str), Codigo.OK);
		
		// Comprimento menor que o permitido
		str = "";
		assertEquals("Erro de N�O detec��o do comprimento m�nimo:", 
				obj.setIDUsuario(str), Codigo.COMPRIMENTO_INVALIDO);
		
		// Comprimento maior que o permitido
		str = "u2893737912873817289 ";
		assertEquals("Erro de N�O detec��o do comprimento m�nimo:", 
				obj.setIDUsuario(str), Codigo.COMPRIMENTO_INVALIDO);
		
		// Caracter inv�lido
		str = "ud345,.";
		assertEquals("Erro de N�O detec��o de caractere inv�lido:", 
				obj.setIDUsuario(str), Codigo.CARACTER_INVALIDO);
		
	}

	public final void testGetIDUsuario() {
		IDUsuario obj = new IDUsuario();
		str="u123";
		
		obj.setIDUsuario(str);
		
//		 Valor lido igual a valor inserido
		assertEquals("Erro, valor lido n�o corresponde a valor inserido:", obj.getIDUsuario(), str);
	}

}
