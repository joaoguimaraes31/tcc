/*
 * Created on 22/05/2005
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
public class ComandoSQLPesquisarPedidos extends ComandoSQL{

	private String iDPedido;
	
	
	public ComandoSQLPesquisarPedidos(String iDPedido){
		
		this.iDPedido=iDPedido;
	
	}
	
	//seleciona um pedido qualquer(iDpedido)
	
	public String executar(){
		
		String SQL= "SELECT * FROM Pedidos "+
		"WHERE IDPedido = '"+iDPedido+"'";
		
		return SQL;
	}
	
	
}
