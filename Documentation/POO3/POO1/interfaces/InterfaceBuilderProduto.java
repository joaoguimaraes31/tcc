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

//	serviço requisitado pela controladora de interação
	// de navegação para criar o subssistema referente 

	public void criarSubssistemaProduto(ControladoraInteracaoNavegacao controladoraInteracaoNavegacao);
	
	// serviços que providenciam a comunicação entre as controladoras de interação
	// Pedido e Produto
	public ControladoraInteracaoProduto getControladoraInteracaoProduto();
	public void setControladoraInteracaoPedido(ControladoraInteracaoPedido controladoraInteracaoPedido);
}
