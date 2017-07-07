/*
 * Created on 23/04/2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package entidades;

/**
 * @author yury
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class Cliente {

	/** ID do cliente */	
	private IDUsuario iDUsuario;
		
	/** Nome do cliente */
	private Nome nome;
	
	/** Senha do Cliente */
	private Senha senha;
	
	/** Endereço do cliente */
	private Endereco endereco;
	
	/** Email do cliente */
	private Email email;	
	
	/** Cria um novo cliente. */
	public Cliente(){
		iDUsuario = new IDUsuario();
		nome = new Nome();
		senha = new Senha();
		endereco = new Endereco();
		email = new Email();
	}
	
	public int setCliente(SolicitaCliente solicitaCliente){
		
		int retorna;
		
		retorna = this.iDUsuario.setIDUsuario(solicitaCliente.iDUsuario);
		if (!(retorna == Codigo.OK)){
			return Codigo.ID_INVALIDO;			
		}
		
		retorna = this.nome.setNome(solicitaCliente.nome);
		if (!(retorna == Codigo.OK)){
			return Codigo.NOME_INVALIDO;
		}
		
		retorna = this.senha.setSenha(solicitaCliente.senha);
		if (!(retorna == Codigo.OK)){
			return Codigo.SENHA_INVALIDA;
		}
		retorna = this.endereco.setEndereco(solicitaCliente.endereco);
		
		if  (!(retorna == Codigo.OK)){
			return Codigo.ENDERECO_INVALIDO;
		}
		retorna = this.email.setEmail(solicitaCliente.email);
		if (!(retorna == Codigo.OK)){
			return Codigo.EMAIL_INVALIDO;
		}
		
		return Codigo.OK;
	}
	
	public SolicitaCliente getCliente(){
		SolicitaCliente solicitaCliente = new SolicitaCliente(); 
		solicitaCliente.iDUsuario = iDUsuario.getIDUsuario();
		solicitaCliente.nome = nome.getNome();
		solicitaCliente.senha = senha.getSenha();
		solicitaCliente.endereco = endereco.getEndereco();
		solicitaCliente.email = email.getEmail();
		return solicitaCliente;
	}	
}
