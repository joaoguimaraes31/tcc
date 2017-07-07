/*
 * Created on 22/05/2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package Comandos;

import entidades.SolicitaCliente;

/**
 * @author yury
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class ComandoSQLEditarCliente extends ComandoSQL {

	private String iDUsuario;
	private String nome;
	private String senha;
	private String endereco;
	private String email;
	
	
	public ComandoSQLEditarCliente(SolicitaCliente solicitaCliente){
		
		this.iDUsuario=solicitaCliente.iDUsuario; 
		this.nome=solicitaCliente.nome;
		this.senha=solicitaCliente.senha;
		this.endereco=solicitaCliente.endereco;
		this.email=solicitaCliente.email;
	
	}
	
	
	public String executar(){
		
		String SQL= "UPDATE Clientes SET "+
		"Nome='" + nome +
		"', Senha='" + senha +
		"', Endereco='" + endereco +
		"', Email='" + email +
		"' WHERE IDCliente= '"+ iDUsuario+"'"; 
		
		return SQL;
	}
	
	
}
