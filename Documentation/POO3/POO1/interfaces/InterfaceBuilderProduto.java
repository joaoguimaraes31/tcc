/*
 * Created on 26/05/2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package interfaces;

import Controladoras.ControladoraInteracaoPedido;
import Controladoras.ControladoraInteracaoProduto;
import Controladoras.ControladoraInteracaoNavegacao;

/**
 * @author yury
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public interface InterfaceBuilderProduto {

//	servi�o requisitado pela controladora de intera��o
	// de navega��o para criar o subssistema referente 

	public void criarSubssistemaProduto(ControladoraInteracaoNavegacao controladoraInteracaoNavegacao);
	
	// servi�os que providenciam a comunica��o entre as controladoras de intera��o
	// Pedido e Produto
	public ControladoraInteracaoProduto getControladoraInteracaoProduto();
	public void setControladoraInteracaoPedido(ControladoraInteracaoPedido controladoraInteracaoPedido);
}
