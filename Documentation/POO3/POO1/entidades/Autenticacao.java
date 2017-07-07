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
public class Autenticacao {

	/** ID do Usuario */	
	private IDUsuario iDUsuario;
		
	/** Senha do Usuario */
	private Senha senha;
		
	public Autenticacao(){
		iDUsuario = new IDUsuario();
		senha = new Senha();
	}
	
	public int setAutenticacao(SolicitaAutenticacao solicitaAutenticacao){
		
		int retorna;
		
		retorna = this.iDUsuario.setIDUsuario(solicitaAutenticacao.IDUsuario);
		if (!(retorna == Codigo.OK)){
			return Codigo.ID_INVALIDO;			
		}
		
		retorna = this.senha.setSenha(solicitaAutenticacao.Senha);
		if (!(retorna == Codigo.OK)){
			return Codigo.SENHA_INVALIDA;
		}
		
		return Codigo.OK;
	}
	
	public SolicitaAutenticacao getAutenticacao(){
		SolicitaAutenticacao solicitaAutenticacao = new SolicitaAutenticacao(); 
		solicitaAutenticacao.IDUsuario = iDUsuario.getIDUsuario();
		solicitaAutenticacao.Senha = senha.getSenha();
		return solicitaAutenticacao;
	}	
}
