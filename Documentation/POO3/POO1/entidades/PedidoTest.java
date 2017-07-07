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
public class PedidoTest extends TestCase {

	private SolicitaPedido str;
	private Pedido obj;
	private SolicitaPedido retorno;
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
	 * Constructor for PedidoTest.
	 * @param arg0
	 */
	public PedidoTest(String arg0) {
		super(arg0);
	}

	public final void testSetPedido() {
	
		obj = new Pedido();
		str = new SolicitaPedido();
		str.IDPedido = "dCarlos";
		str.IDProduto = "p123";
		str.IDUsuario = "uHushaa";
		str.Situacao = ""; 

		assertEquals("Erro de Atribuição de pedido:", obj.setPedido(str), Codigo.OK);
		
	}

	public final void testGetPedido() {
		
		obj = new Pedido();
		str = new SolicitaPedido();
		str.IDPedido = "dCarlos";
		str.IDProduto = "p123";
		str.IDUsuario = "uHushaa";
		str.Situacao = ""; 
		
		obj.setPedido(str);
		
		retorno = obj.getPedido();
		assertEquals("Erro no cliente de retorno de ID:", 
			retorno.IDPedido, str.IDPedido);

		assertEquals("Erro no cliente de retorno de ID:", 
			retorno.IDProduto, str.IDProduto);

		assertEquals("Erro no cliente de retorno de ID:", 
			retorno.IDUsuario, str.IDUsuario);
		
		String processado = new String("Processado");
		
		assertEquals("Erro no valor de situação:", retorno.Situacao,processado );
		
	}

}
