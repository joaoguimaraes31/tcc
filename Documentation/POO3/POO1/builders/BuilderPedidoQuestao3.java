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
		
		// Cria controladora de Persist�ncia
		controladoraPersistencia = ControladoraPersistencia.instanciar(url);
		
		// Cria controladora de neg�cio Pedido
	//	controladoraNegocioPedido = new ControladoraNegocioPedido();
		
		// Seta a controladora de persist�ncia acima criada como 
		// controladora de persist�ncia da controladora de neg�cio Pedido
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
