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
public class SituacaoTest extends TestCase {

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
	 * Constructor for Situa��oTest.
	 * @param arg0
	 */
	public SituacaoTest(String arg0) {
		super(arg0);
	}

	public final void testSetSituacao() {
		
		// N�o h� teste de setSitua��o() , pois esta n�o 
		//tem par�metros de entrada. Se resumindo a "setar" O
		//atributo situa��o como "true" 
	}

	public final void testGetSituacao() {
	
		Situacao obj = new Situacao();
		obj.setSituacao();
		String processado = new String("Processado");
		
		// Valor lido igual a "Processsado". Uma vez que a chamada ao m�todo setSitua��o() processa o pedido
		assertEquals("Erro, valor lido n�o corresponde a valor inserido:", obj.getSituacao(), processado);
		
	}

}
