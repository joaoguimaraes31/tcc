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
public class ProdutoTest extends TestCase {

	private SolicitaProduto str;
	private Produto obj;
	private SolicitaProduto retorno;
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
	 * Constructor for ProdutoTest.
	 * @param arg0
	 */
	public ProdutoTest(String arg0) {
		super(arg0);
	}

	public final void testSetProduto() {
		
		obj = new Produto();
		str = new SolicitaProduto();
		str.iDProduto = "p123";
		str.descricaoTextual = "caneta";
		str.tipo = "esferográfica";
		str.preco = "2.3";
		str.quantidade = "20"; 

		assertEquals("Erro de Atribuição de pedido:", obj.setProduto(str), Codigo.OK);
		
	}

	public final void testGetProduto() {
		
		obj = new Produto();
		str = new SolicitaProduto();
		str.iDProduto = "p123";
		str.descricaoTextual = "caneta";
		str.tipo = "esferográfica";
		str.preco = "2.3";
		str.quantidade = "20"; 
		
		obj.setProduto(str);
		
		retorno = obj.getProduto();
		assertEquals("Erro no produto de retorno de ID:", 
			retorno.iDProduto, str.iDProduto);

		assertEquals("Erro no produto de retorno de descrição:", 
			retorno.descricaoTextual, str.descricaoTextual);

		assertEquals("Erro no produto de retorno de tipo:", 
			retorno.tipo, str.tipo);

		assertEquals("Erro no produto de retorno de preço:", 
			retorno.preco, str.preco);
		
		assertEquals("Erro no valor de quantidade :", retorno.quantidade, str.quantidade);
		
	}

}
