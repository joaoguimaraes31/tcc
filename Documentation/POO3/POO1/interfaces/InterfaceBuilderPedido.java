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

	//servi�o requisitado pela controladora de intera��o
	// de navega��o para criar o subssistema referente 
	public void criarSubssistemaPedido(ControladoraInteracaoNavegacao controladoraInteracaoNavegacao);
	
	//servi�os que providenciam a comunica��o entre as controladoras de intera��o
	// Pedido e Produto
	public ControladoraInteracaoPedido getControladoraInteracaoPedido();
	public void setControladoraInteracaoProduto(ControladoraInteracaoProduto controladoraInteracaoProduto);
}

