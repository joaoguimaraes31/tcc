/*
 * Created on 29/05/2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package builders;

import interfaces.InterfaceBuilderProduto;
import interfaces.InterfaceControladoraNegocioProduto;


import java.rmi.Naming;


import Controladoras.ControladoraInteracaoPedido;
import Controladoras.ControladoraInteracaoProduto;
import Controladoras.ControladoraInteracaoNavegacao;



/**
 * @author yury
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class BuilderProduto  implements InterfaceBuilderProduto {
	
	ControladoraInteracaoNavegacao controladoraInteracaoNavegacao;
	ControladoraInteracaoProduto controladoraInteracaoProduto;
	ControladoraInteracaoPedido ControladoraInteracaoPedido;
	InterfaceControladoraNegocioProduto interfaceControladoraNegocioProduto;
	
	 public void criarSubssistemaProduto(ControladoraInteracaoNavegacao controladoraInteracaoNavegacao){
			
		// seta a controladora de intera��o de navega��o como controladora de intera��o de navega��o
		//a qual o sistema faz refer�ncia
		this.controladoraInteracaoNavegacao = controladoraInteracaoNavegacao;
		
		// cria a controladora de intera��o do subssistema Produto
		controladoraInteracaoProduto = new ControladoraInteracaoProduto();
		
		// seta a controladora de intera��o de navega��o como controladora de intera��o de navega��o
		// a qual a controladora de intera��o Produto faz refer�ncia
		controladoraInteracaoProduto.setControladoraControladoraInteracaoNavegacao(controladoraInteracaoNavegacao);
	
		//recebe controladora de negocio de produtos via rmi
		 try {
		 	interfaceControladoraNegocioProduto = (InterfaceControladoraNegocioProduto) Naming.lookup( "rmi://localhost/ProdutoService" );
		    }
		    catch( Exception e ) {
		    	
		    }
		
		
		//seta a controladora de negocio de produto recebida via rmi como controladora de negocio de produto
		// a qual a controladora de intera��o de produto faz refer�ncia
		controladoraInteracaoProduto.setControladoraNegocio(interfaceControladoraNegocioProduto);
		
		
	}
	
	public void setControladoraInteracaoPedido(ControladoraInteracaoPedido ControladoraInteracaoPedido){
		
		//seta a controladora de intera��o de navega��o como controladora de intera��o de navega��o
		// a qual a controladora de intera��o Produto faz refer�ncia
		controladoraInteracaoProduto.setControladoraInteracaoPedido(ControladoraInteracaoPedido); 
		
	}
	
	public ControladoraInteracaoProduto getControladoraInteracaoProduto(){
		
		return controladoraInteracaoProduto;
	}
	
	
	
}


