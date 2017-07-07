
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
		
		// seta a controladora de intera��o de navega��o como controladora de intera��o de navega��o
		//a qual o sistema faz refer�ncia
		this.controladoraInteracaoNavegacao = controladoraInteracaoNavegacao;
		
		// cria a controladora de intera��o do subssistema Pedido
		controladoraInteracaoPedido = new ControladoraInteracaoPedido();
		
		// seta a controladora de intera��o de navega��o como controladora de intera��o de navega��o
		// a qual a controladora de intera��o Pedido faz refer�ncia
		controladoraInteracaoPedido.setControladoraControladoraInteracaoNavegacao(controladoraInteracaoNavegacao);
	
		//recebe controladora de negocio de pedidos via rmi
		 try {
		 	interfaceControladoraNegocioPedido = (InterfaceControladoraNegocioPedido) Naming.lookup( "rmi://localhost/PedidoService" );
		    }
		    catch( Exception e ) {
		      
		    }

		
		//seta a controladora de negocio de pedidos recebida via rmi como controladora de negocio de pedido
		// a qual a controladora de intera��o de pedido faz refer�ncia
		controladoraInteracaoPedido.setControladoraNegocio(interfaceControladoraNegocioPedido);
		
	}
	
	 public ControladoraInteracaoPedido getControladoraInteracaoPedido(){
	 	
	 	 return this.controladoraInteracaoPedido;
	 	
	 }
	 
	 public void setControladoraInteracaoProduto(ControladoraInteracaoProduto controladoraInteracaoProduto){
	 	
	 	controladoraInteracaoPedido.setControladoraInteracaoProduto(controladoraInteracaoProduto); 
	 }
	
}

