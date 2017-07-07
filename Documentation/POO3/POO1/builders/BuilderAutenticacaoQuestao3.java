/*
 * Created on 08/06/2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package builders;

import Controladoras.ContorladoraNegocioAutenticacao;
import Persistencia.ControladoraPersistencia;

/**
 * @author yury
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class BuilderAutenticacaoQuestao3 {


		private ContorladoraNegocioAutenticacao controladoraNegocioAutenticacao;
		private ControladoraPersistencia controladoraPersistencia;
		
		/**
		 * 
		 */
		public void criarSubssistemaAutenticacaoQuestao3(String url) {
			
			// Cria controladora de Persistência
			controladoraPersistencia = ControladoraPersistencia.instanciar(url);
			
			// Cria controladora de negócio Autenticacao
	//		controladoraNegocioAutenticacao = new ContorladoraNegocioAutenticacao();
			
			// Seta a controladora de persistância acima criada como 
			// controladora de persistência da controladora de negócio Autenticacao
	//		controladoraNegocioAutenticacao.setControladoraPersistencia(controladoraPersistencia);
			
			
		}
		
		// retorna a ControladoraNegocioAutenticacao
		public ContorladoraNegocioAutenticacao  getControladoraNegocioAutenticacao(){
			
			return this.controladoraNegocioAutenticacao; 
		}
		
		//retorna a ControladoraNegocioAutenticacao
		public ControladoraPersistencia  getControladoraPersistencia(){
			
			return this.controladoraPersistencia; 
		}
		
		
	}

