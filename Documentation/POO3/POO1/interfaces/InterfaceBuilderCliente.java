/*
 * Created on 26/05/2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package interfaces;

import Controladoras.ControladoraInteracaoCliente;
import Controladoras.ControladoraInteracaoNavegacao;


/**
 * @author yury
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public interface InterfaceBuilderCliente {

	//servi�o requisitado pela controladora de intera��o
	// de navega��o para criar o subssistema referente 
	public void criarSubssistemaCliente(ControladoraInteracaoNavegacao controladoraInteracaoNavegacao);
		
	public ControladoraInteracaoCliente getControladoraInteracaoCliente();
}
	
