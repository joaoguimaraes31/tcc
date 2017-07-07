
/*
 * Created on 22/05/2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package Comandos;
import entidades.*;



/**
 * @author yury
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class ComandoSQLAtenticacao extends ComandoSQL {

	
	private String IDUsuario;
	private String Senha;
	
	
	public ComandoSQLAtenticacao(SolicitaAutenticacao solicitaAutenticacao){
		
		this.IDUsuario=solicitaAutenticacao.IDUsuario; 
		this.Senha=solicitaAutenticacao.Senha;

	}
		
	public String executar(){
			
		String SQL= "SELECT * FROM Clientes "+
		"WHERE (IDCliente = '"+IDUsuario+"' AND Senha = '"+Senha+"')";
		
		return SQL;
	}
	
}
