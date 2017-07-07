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
public class NomeTest extends TestCase {

	private String str;
	private Nome obj;
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
	 * Constructor for NomeTest.
	 * @param arg0
	 */
	public NomeTest(String arg0) {
		super(arg0);
	}

	public final void testSetNome() {
		
//		Atribuição correta de Nome//
		Nome obj = new Nome();
		str="Calor Frederico";
		assertEquals("Erro de Atribuição de quantidade:", obj.setNome(str), Codigo.OK);
		
		// Comprimento menor que o permitido
		str = "";
		assertEquals("Erro de NÃO detecção do comprimento mínimo:", 
				obj.setNome(str), Codigo.COMPRIMENTO_INVALIDO);
		
		// Comprimento maior que o permitido
		str = "CArlos FRederico Maciel Silveira Silva Silva ";
		assertEquals("Erro de NÃO detecção do comprimento mínimo:", 
				obj.setNome(str), Codigo.COMPRIMENTO_INVALIDO);
		
		// Caracter inválido
		str = "qd345,.";
		assertEquals("Erro de NÃO detecção de caractere inválido:", 
				obj.setNome(str), Codigo.CARACTER_INVALIDO);
		
	}

	public final void testGetNome() {
		
		Nome obj = new Nome();
		str="Calor Frederico";
		obj.setNome(str);
		
//		 Valor lido igual a valor inserido
		assertEquals("Erro, valor lido não corresponde a valor inserido:", obj.getNome(), str);
		
	}

}
