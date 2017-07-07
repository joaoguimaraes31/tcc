/*
 * Created on 22/05/2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package Comandos;

import entidades.SolicitaPedido;

/**
 * @author yury
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class ComandoSQLInserirPedidos extends ComandoSQL{

	
	private String IDPedido;
	private String IDProduto;
	private String IDUsuario;
	private String Nome;
	private String Situacao;
	
	public ComandoSQLInserirPedidos(SolicitaPedido solicitaPedido){
		
		this.IDPedido=solicitaPedido.IDPedido; 
		this.IDProduto=solicitaPedido.IDProduto;
		this.IDUsuario=solicitaPedido.IDUsuario;
		this.Situacao=solicitaPedido.Situacao;
	
	}
	
	public String executar(){
		
		String SQL= "INSERT INTO Pedidos ("+
		"IDPedido, IDProduto, IDCliente, Situacao"+
		")VALUES('"+
		IDPedido+"', '"+IDProduto+"', '"+IDUsuario+"', '"+Situacao+"')";   
		return SQL;
	}
	
	
}
