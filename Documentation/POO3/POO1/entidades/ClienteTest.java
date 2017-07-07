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
public class ClienteTest extends TestCase {

	private SolicitaCliente str;
	private Cliente obj;
	private SolicitaCliente retorno;
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
	 * Constructor for ClienteTest.
	 * @param arg0
	 */
	public ClienteTest(String arg0) {
		super(arg0);
	}

	public final void testSetCliente() {
		obj = new Cliente();
		str = new SolicitaCliente();
		str.iDUsuario = "uCarlos";
		str.nome = "Carlos";
		str.senha = "Hushaa";
		str.endereco = "SQN 320 BL X";
		str.email = "fredericofurlan@yahoo.com.br";
		
		assertEquals("Erro de Atribuição de cliente:", obj.setCliente(str), Codigo.OK);
		
	}

	public final void testGetCliente() {
		
		obj = new Cliente();
		str = new SolicitaCliente();
		str.iDUsuario = "uCarlos";
		str.nome = "Carlos";
		str.senha = "Hushaa";
		str.endereco = "SQN 320 BL X";
		str.email = "fredericofurlan@yahoo.com.br";
		obj.setCliente(str);
		
		retorno = obj.getCliente();
		assertEquals("Erro no cliente de retorno de ID:", 
			retorno.iDUsuario, str.iDUsuario);

		assertEquals("Erro no cliente de retorno de nome:", 
			retorno.nome, str.nome);

		assertEquals("Erro no cliente de retorno de senha:", 
			retorno.senha, str.senha);

		assertEquals("Erro no cliente de retorno de endereco:", 
			retorno.endereco, str.endereco);
		
		assertEquals("Erro no valor de email:", retorno.email, str.email);
	}

}
