/*
 * Created on 24/05/2005
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
public class ComandoSQLPesquisarClientePedidos extends ComandoSQL {

	private String iDCliente;
	
	public ComandoSQLPesquisarClientePedidos(String iDCliente){
		
		this.iDCliente=iDCliente;

	}
	
	public String executar(){
		
		String SQL= "SELECT * FROM Pedidos "+
		"WHERE IDCliente = '"+iDCliente+"'";
		
		return SQL;
	}
	
	
}
