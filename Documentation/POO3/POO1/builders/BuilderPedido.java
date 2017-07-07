
/* Created on 26/05/2005
*
* TODO To change the template for this generated file go to
* Window - Preferences - Java - Code Style - Code Templates
*/
package builders;
import interfaces.InterfaceBuilderPedido;
import interfaces.InterfaceControladoraNegocioPedido;

import java.rmi.Naming;


import Controladoras.ControladoraInteracaoNavegacao;
import Controladoras.ControladoraInteracaoPedido;
import Controladoras.ControladoraInteracaoProduto;



/**
* @author yury
*
* TODO To change the template for this generated type comment go to
* Window - Preferences - Java - Code Style - Code Templates
*/
public class BuilderPedido  implements InterfaceBuilderPedido{

	ControladoraInteracaoNavegacao controladoraInteracaoNavegacao;
	ControladoraInteracaoPedido controladoraInteracaoPedido;
	InterfaceControladoraNegocioPedido interfaceControladoraNegocioPedido;
	
	 public void criarSubssistemaPedido(ControladoraInteracaoNavegacao controladoraInteracaoNavegacao){
		
		// seta a controladora de interação de navegação como controladora de interação de navegação
		//a qual o sistema faz referência
		this.controladoraInteracaoNavegacao = controladoraInteracaoNavegacao;
		
		// cria a controladora de interação do subssistema Pedido
		controladoraInteracaoPedido = new ControladoraInteracaoPedido();
		
		// seta a controladora de interação de navegação como controladora de interação de navegação
		// a qual a controladora de interação Pedido faz referência
		controladoraInteracaoPedido.setControladoraControladoraInteracaoNavegacao(controladoraInteracaoNavegacao);
	
		//recebe controladora de negocio de pedidos via rmi
		 try {
		 	interfaceControladoraNegocioPedido = (InterfaceControladoraNegocioPedido) Naming.lookup( "rmi://localhost/PedidoService" );
		    }
		    catch( Exception e ) {
		      
		    }

		
		//seta a controladora de negocio de pedidos recebida via rmi como controladora de negocio de pedido
		// a qual a controladora de interação de pedido faz referência
		controladoraInteracaoPedido.setControladoraNegocio(interfaceControladoraNegocioPedido);
		
	}
	
	 public ControladoraInteracaoPedido getControladoraInteracaoPedido(){
	 	
	 	 return this.controladoraInteracaoPedido;
	 	
	 }
	 
	 public void setControladoraInteracaoProduto(ControladoraInteracaoProduto controladoraInteracaoProduto){
	 	
	 	controladoraInteracaoPedido.setControladoraInteracaoProduto(controladoraInteracaoProduto); 
	 }
	
}

