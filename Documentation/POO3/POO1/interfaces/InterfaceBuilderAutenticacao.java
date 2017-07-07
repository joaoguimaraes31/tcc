/*
 * Created on 26/05/2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package interfaces;

import Controladoras.ControladoraInteracaoAutenticacao;
import Controladoras.ControladoraInteracaoNavegacao;

/**
 * @author yury
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public interface InterfaceBuilderAutenticacao {

//	serviço requisitado pela controladora de interação
	// de navegação para criar o subssistema referente 
	public void criarSubssistemaAutenticacao(ControladoraInteracaoNavegacao controladoraInteracaoNavegacao);

	public ControladoraInteracaoAutenticacao getControladoraInteracaoAutenticacao();
	
}

