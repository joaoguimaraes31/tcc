package builders;
import interfaces.InterfaceBuilderAutenticacao;
import interfaces.InterfaceControladoraNegocioAutenticacao;

import java.rmi.Naming;


import Controladoras.ControladoraInteracaoAutenticacao;
import Controladoras.ControladoraInteracaoNavegacao;


/**
 * @author yury
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class BuilderAutenticacao implements InterfaceBuilderAutenticacao {

	ControladoraInteracaoNavegacao controladoraInteracaoNavegacao;
	ControladoraInteracaoAutenticacao controladoraInteracaoAutenticacao;
	InterfaceControladoraNegocioAutenticacao interfaceControladoraNegocioAutenticacao;
	
	 public void criarSubssistemaAutenticacao(ControladoraInteracaoNavegacao controladoraInteracaoNavegacao) {
		
		// seta a controladora de intera��o de navega��o como controladora de intera��o de navega��o
		//a qual o sistema faz refer�ncia
		this.controladoraInteracaoNavegacao = controladoraInteracaoNavegacao;
		
		// cria a controladora de intera��o do subssistema Autenticacao
		controladoraInteracaoAutenticacao = new ControladoraInteracaoAutenticacao();
		
		// seta a controladora de intera��o de navega��o como controladora de intera��o de navega��o
		// a qual a controladora de intera��o Autenticacao faz refer�ncia
		controladoraInteracaoAutenticacao.setControladoraControladoraInteracaoNavegacao(controladoraInteracaoNavegacao);
		
		//recebe controladora de neg�cio de autentica��o via rmi
		 try {
		 	interfaceControladoraNegocioAutenticacao = (InterfaceControladoraNegocioAutenticacao) Naming.lookup( "rmi://localhost/AutenticacaoService" );
		 }catch( Exception e ) {
		     
		 }

	
		//seta a controladora de negocio de autentica��o recebida via rmi como controladora de neg�cio de autentica��o
		// a qual a controladora de intera��o de autenticacao faz refer�ncia
		controladoraInteracaoAutenticacao.setControladoraNegocio(interfaceControladoraNegocioAutenticacao);
		
	}
	
	 public ControladoraInteracaoAutenticacao getControladoraInteracaoAutenticacao(){
	 	return controladoraInteracaoAutenticacao;
	 }
	
}

