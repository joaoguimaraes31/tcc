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
		
		// seta a controladora de interação de navegação como controladora de interação de navegação
		//a qual o sistema faz referência
		this.controladoraInteracaoNavegacao = controladoraInteracaoNavegacao;
		
		// cria a controladora de interação do subssistema Autenticacao
		controladoraInteracaoAutenticacao = new ControladoraInteracaoAutenticacao();
		
		// seta a controladora de interação de navegação como controladora de interação de navegação
		// a qual a controladora de interação Autenticacao faz referência
		controladoraInteracaoAutenticacao.setControladoraControladoraInteracaoNavegacao(controladoraInteracaoNavegacao);
		
		//recebe controladora de negócio de autenticação via rmi
		 try {
		 	interfaceControladoraNegocioAutenticacao = (InterfaceControladoraNegocioAutenticacao) Naming.lookup( "rmi://localhost/AutenticacaoService" );
		 }catch( Exception e ) {
		     
		 }

	
		//seta a controladora de negocio de autenticação recebida via rmi como controladora de negócio de autenticação
		// a qual a controladora de interação de autenticacao faz referência
		controladoraInteracaoAutenticacao.setControladoraNegocio(interfaceControladoraNegocioAutenticacao);
		
	}
	
	 public ControladoraInteracaoAutenticacao getControladoraInteracaoAutenticacao(){
	 	return controladoraInteracaoAutenticacao;
	 }
	
}

