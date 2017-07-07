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
public class ComandoSQLRemoverProduto extends ComandoSQL {

	private String iDProduto;

	public ComandoSQLRemoverProduto(String iDProduto){
	
		this.iDProduto=iDProduto;
	
	}
	
	public String executar(){
		
		String SQL= "DELETE FROM Produtos "+
		"WHERE IDProduto = '"+iDProduto+"'";
		
		return SQL;
	}
	
}
	
