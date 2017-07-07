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
public class ComandoSQLPesquisarProduto2 extends ComandoSQL {

	public ComandoSQLPesquisarProduto2(){
		
	}
	
	public String executar(){
		String SQL= "SELECT * FROM Produtos ";
		
		return SQL;
	}
	
}
