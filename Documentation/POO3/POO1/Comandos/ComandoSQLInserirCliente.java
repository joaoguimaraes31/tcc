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
public class ComandoSQLInserirCliente extends ComandoSQL{
	private String iDUsuario;
	private String nome;
	private String senha;
	private String endereco;
	private String email;
	
	public  ComandoSQLInserirCliente(SolicitaCliente solicitaCliente){
		
		this.iDUsuario=solicitaCliente.iDUsuario; 
		this.nome=solicitaCliente.nome;
		this.senha=solicitaCliente.senha;
		this.endereco=solicitaCliente.endereco;
		this.email=solicitaCliente.email;
	
	}
	
	public String executar(){
	
		String SQL= "INSERT INTO Clientes ("+
		"IDCliente, Nome, Senha, Endereco, Email"+
		")VALUES('"+
		iDUsuario+"', '"+nome+"', '"+senha+"', '"+endereco+"', '"+email+"')";   
		return SQL;
	}
	
	
}
