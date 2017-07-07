/*
 * Created on 26/05/2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package interfaces;

import Controladoras.ControladoraInteracaoPedido;
import Controladoras.ControladoraInteracaoNavegacao;
import Controladoras.ControladoraInteracaoProduto;

/**
 * @author yury
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public interface InterfaceBuilderPedido {

	//serviço requisitado pela controladora de interação
	// de navegação para criar o subssistema referente 
	public void criarSubssistemaPedido(ControladoraInteracaoNavegacao controladoraInteracaoNavegacao);
	
	//serviços que providenciam a comunicação entre as controladoras de interação
	// Pedido e Produto
	public ControladoraInteracaoPedido getControladoraInteracaoPedido();
	public void setControladoraInteracaoProduto(ControladoraInteracaoProduto controladoraInteracaoProduto);
}

