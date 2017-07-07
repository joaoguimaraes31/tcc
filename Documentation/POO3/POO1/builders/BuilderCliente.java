/*
 * Created on 26/05/2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package builders;
import interfaces.InterfaceBuilderCliente;
import interfaces.InterfaceControladoraNegocioCliente;

import java.rmi.Naming;


import Controladoras.ControladoraInteracaoCliente;
import Controladoras.ControladoraInteracaoNavegacao;

/**
 * @author yury
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class BuilderCliente  implements InterfaceBuilderCliente{

	ControladoraInteracaoNavegacao controladoraInteracaoNavegacao;
	ControladoraInteracaoCliente controladoraInteracaoCliente;
	InterfaceControladoraNegocioCliente interfaceControladoraNegocioCliente;
	
	 public void criarSubssistemaCliente(ControladoraInteracaoNavegacao controladoraInteracaoNavegacao){
		
		// seta a controladora de interação de navegação como controladora de interação de navegação
		//a qual o sistema faz referência
		this.controladoraInteracaoNavegacao = controladoraInteracaoNavegacao;
		
		// cria a controladora de interação do subssistema cliente
		controladoraInteracaoCliente = new ControladoraInteracaoCliente();
		
		// seta a controladora de interação de navegação como controladora de interação de navegação
		// a qual a controladora de interação cliente faz referência
		controladoraInteracaoCliente.setControladoraControladoraInteracaoNavegacao(controladoraInteracaoNavegacao);
	
	
		//recebe controladora de negocio de clientes via rmi
		 try {
		 	interfaceControladoraNegocioCliente = (InterfaceControladoraNegocioCliente) Naming.lookup( "rmi://localhost/ClienteService" );
		    }
		    catch( Exception e ) {
		  
		    }

		//seta a controladora de negocio de clientes recebida via rmi como controladora de negocio de clientes
		// a qual a controladora de interação cliente faz referência
		controladoraInteracaoCliente.setControladoraNegocio(interfaceControladoraNegocioCliente);
				
	}
	 
	 public ControladoraInteracaoCliente getControladoraInteracaoCliente(){
	 	return controladoraInteracaoCliente;
	 }
	
	
}
