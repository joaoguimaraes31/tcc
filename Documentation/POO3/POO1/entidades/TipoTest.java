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
//		Atribuição correta de senha//
		Tipo objTipo = new Tipo();
		tipo="Caneta";
		assertEquals("Erro de Atribuição de tipo:", objTipo.setTipo(tipo), Codigo.OK);
		
		// Comporimento maior que o permitido
		tipo = " Caneta esferográfica de bolso com cores azul verde e laranja ";
		assertEquals("Erro de NÃO detecção do comprimento máximo:", 
				objTipo.setTipo(tipo), Codigo.COMPRIMENTO_INVALIDO);
		
		// Caracter inválido
		tipo = "sapa,to";
		assertEquals("Erro de NÃO detecção de caractere inválido:", 
				objTipo.setTipo(tipo), Codigo.CARACTER_INVALIDO);
	}
	
	public final void testGetTipo() {
		Tipo objTipo = new Tipo();
		tipo="Caneta";
		objTipo.setTipo(tipo);
		
		// Valor lido igual a valor inserido
		assertEquals("Erro, valor lido não corresponde a valor inserido:", objTipo.getTipo(), tipo);
	}

}
