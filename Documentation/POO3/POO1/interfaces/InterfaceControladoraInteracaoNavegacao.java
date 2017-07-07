/*
 * Created on 26/05/2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package interfaces;
import entidades.*;


/**
 * @author yury
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public interface InterfaceControladoraInteracaoNavegacao {
	
	// criar tela de menu do administrador
	//(Adm)
	public void criarTelaMenuAdm();
	
	//criar tela de menu do cliente(Cliente)
	public void criarTelaMenuClientes();

	// setar registro inicial 
	public void setRegistro(SolicitaAutenticacao registro);
	
	// pegar registro inicial
	public SolicitaAutenticacao getRegistro();

}