/*
 * Created on 08/06/2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package builders;

import Controladoras.ControladoraNegocioPedido;
import Persistencia.ControladoraPersistencia;

/**
 * @author yury
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class BuilderPedidoQuestao3 {

	private ControladoraNegocioPedido controladoraNegocioPedido;
	private ControladoraPersistencia controladoraPersistencia;
	
	/**
	 * 
	 */
	public void criarSubssistemaClienteQuestao3(String url) {
		
		// Cria controladora de Persistência
		controladoraPersistencia = ControladoraPersistencia.instanciar(url);
		
		// Cria controladora de negócio Pedido
	//	controladoraNegocioPedido = new ControladoraNegocioPedido();
		
		// Seta a controladora de persistância acima criada como 
		// controladora de persistência da controladora de negócio Pedido
		controladoraNegocioPedido.setControladoraPersistencia(controladoraPersistencia);
		
		
	}
	
	// retorna a ControladoraNegocioPedido
	public ControladoraNegocioPedido  getControladoraNegocioPedido(){
		
		return this.controladoraNegocioPedido; 
	}
	
	//retorna a ControladoraNegocioPedido
	public ControladoraPersistencia  getControladoraPersistencia(){
		
		return this.controladoraPersistencia; 
	}
	
	

	
	
	
}
