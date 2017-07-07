/*
 * Created on 06/06/2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package Comandos;

/**
 * @author yury
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class ComandoSQLPesquisarPedidos2 extends ComandoSQL{

	public ComandoSQLPesquisarPedidos2(){
		
	}
	
//	seleciona todos os pedidos
	public String executar(){
		String SQL= "SELECT * FROM Pedidos ORDER BY IDPedido ASC ";
		
		return SQL;
	}
	
}
