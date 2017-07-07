/*
 * Created on 08/06/2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package builders;

import Controladoras.ControladoraNegocioCliente;
import Persistencia.ControladoraPersistencia;

/**
 * @author yury
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class BuilderClienteQuestao3 {

	private ControladoraNegocioCliente controladoraNegocioCliente;
	private ControladoraPersistencia controladoraPersistencia;
	
	/**
	 * 
	 */
	public void criarSubssistemaClienteQuestao3(String url) {
		
		// Cria controladora de Persist�ncia
		controladoraPersistencia = ControladoraPersistencia.instanciar(url);
		
		// Cria controladora de neg�cio cliente
	//	controladoraNegocioCliente = new ControladoraNegocioCliente();
		
		// Seta a controladora de persist�ncia acima criada como 
		// controladora de persist�ncia da controladora de neg�cio cliente
		controladoraNegocioCliente.setControladoraPersistencia(controladoraPersistencia);
		
		
	}
	
	// retorna a ControladoraNegocioCliente
	public ControladoraNegocioCliente  getControladoraNegocioCliente(){
		
		return this.controladoraNegocioCliente; 
	}
	
	//retorna a ControladoraNegocioCliente
	public ControladoraPersistencia  getControladoraPersistencia(){
		
		return this.controladoraPersistencia; 
	}
	
	

}
