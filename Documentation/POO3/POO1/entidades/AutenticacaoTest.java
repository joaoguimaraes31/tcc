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
public class AutenticacaoTest extends TestCase {

	private SolicitaAutenticacao str;
	private Autenticacao obj;
	private SolicitaAutenticacao retorno;
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
	 * Constructor for AutenticaçãoTest.
	 * @param arg0
	 */
	public AutenticacaoTest(String arg0) {
		super(arg0);
	}

	public final void testSetAutenticacao() {
		
		obj = new Autenticacao();
		str = new SolicitaAutenticacao();
		str.IDUsuario = "uCarlos";
		str.Senha = "Hushaa";
		
		assertEquals("Erro de Atribuição de autenticação:", obj.setAutenticacao(str), Codigo.OK);
		
	}

	public final void testGetSolicitaAutenticacao() {
		
		obj = new Autenticacao();
		str = new SolicitaAutenticacao();
		str.IDUsuario = "uCarlos";
		str.Senha = "Hushaa";
		
		obj.setAutenticacao(str);
		
		retorno = obj.getAutenticacao();
		assertEquals("Erro na autenticação no retorno de ID:", 
			retorno.IDUsuario, str.IDUsuario);

		assertEquals("Erro no autenticação no retorno de senha:", 
			retorno.Senha, str.Senha);
	}

}

