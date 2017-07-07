/*
 * Created on 08/06/2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package builders;

import Controladoras.ControladoraNegocioProduto;
import Persistencia.ControladoraPersistencia;

/**
 * @author yury
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class BuilderProdutoQuestao3 {

	private ControladoraNegocioProduto controladoraNegocioProduto;
	private ControladoraPersistencia controladoraPersistencia;
	
	/**
	 * 
	 */
	public void criarSubssistemaClienteQuestao3(String url) {
		
		// Cria controladora de Persistência
		controladoraPersistencia = ControladoraPersistencia.instanciar(url);
		
		// Cria controladora de negócio Produto
	//	controladoraNegocioProduto = new ControladoraNegocioProduto();
		
		// Seta a controladora de persistância acima criada como 
		// controladora de persistência da controladora de negócio Produto
		controladoraNegocioProduto.setControladoraPersistencia(controladoraPersistencia);
		
		
	}
	
	// retorna a ControladoraNegocioProduto
	public ControladoraNegocioProduto  getControladoraNegocioProduto(){
		
		return this.controladoraNegocioProduto; 
	}
	
	//retorna a ControladoraNegocioProduto
	public ControladoraPersistencia  getControladoraPersistencia(){
		
		return this.controladoraPersistencia; 
	}
	
	

}
