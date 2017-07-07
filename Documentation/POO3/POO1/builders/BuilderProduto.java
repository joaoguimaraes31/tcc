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
			
		// seta a controladora de interação de navegação como controladora de interação de navegação
		//a qual o sistema faz referência
		this.controladoraInteracaoNavegacao = controladoraInteracaoNavegacao;
		
		// cria a controladora de interação do subssistema Produto
		controladoraInteracaoProduto = new ControladoraInteracaoProduto();
		
		// seta a controladora de interação de navegação como controladora de interação de navegação
		// a qual a controladora de interação Produto faz referência
		controladoraInteracaoProduto.setControladoraControladoraInteracaoNavegacao(controladoraInteracaoNavegacao);
	
		//recebe controladora de negocio de produtos via rmi
		 try {
		 	interfaceControladoraNegocioProduto = (InterfaceControladoraNegocioProduto) Naming.lookup( "rmi://localhost/ProdutoService" );
		    }
		    catch( Exception e ) {
		    	
		    }
		
		
		//seta a controladora de negocio de produto recebida via rmi como controladora de negocio de produto
		// a qual a controladora de interação de produto faz referência
		controladoraInteracaoProduto.setControladoraNegocio(interfaceControladoraNegocioProduto);
		
		
	}
	
	public void setControladoraInteracaoPedido(ControladoraInteracaoPedido ControladoraInteracaoPedido){
		
		//seta a controladora de interação de navegação como controladora de interação de navegação
		// a qual a controladora de interação Produto faz referência
		controladoraInteracaoProduto.setControladoraInteracaoPedido(ControladoraInteracaoPedido); 
		
	}
	
	public ControladoraInteracaoProduto getControladoraInteracaoProduto(){
		
		return controladoraInteracaoProduto;
	}
	
	
	
}


