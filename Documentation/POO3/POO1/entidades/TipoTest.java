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
public class TipoTest extends TestCase {
	
	private Tipo objTipo;
	private String tipo;

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
	 * Constructor for TipoTest.
	 * @param arg0
	 */
	public TipoTest(String arg0) {
		super(arg0);
	}

	public final void testSetTipo() {
//		Atribui��o correta de senha//
		Tipo objTipo = new Tipo();
		tipo="Caneta";
		assertEquals("Erro de Atribui��o de tipo:", objTipo.setTipo(tipo), Codigo.OK);
		
		// Comporimento maior que o permitido
		tipo = " Caneta esferogr�fica de bolso com cores azul verde e laranja ";
		assertEquals("Erro de N�O detec��o do comprimento m�ximo:", 
				objTipo.setTipo(tipo), Codigo.COMPRIMENTO_INVALIDO);
		
		// Caracter inv�lido
		tipo = "sapa,to";
		assertEquals("Erro de N�O detec��o de caractere inv�lido:", 
				objTipo.setTipo(tipo), Codigo.CARACTER_INVALIDO);
	}
	
	public final void testGetTipo() {
		Tipo objTipo = new Tipo();
		tipo="Caneta";
		objTipo.setTipo(tipo);
		
		// Valor lido igual a valor inserido
		assertEquals("Erro, valor lido n�o corresponde a valor inserido:", objTipo.getTipo(), tipo);
	}

}
