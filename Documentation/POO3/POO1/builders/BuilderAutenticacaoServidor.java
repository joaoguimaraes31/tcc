/*
 * Created on 27/06/2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package builders;

import interfaces.InterfaceControladoraNegocioAutenticacao;

import java.rmi.Naming;

import Controladoras.ContorladoraNegocioAutenticacao;
import Persistencia.ControladoraPersistencia;

/**
 * @author yury
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class BuilderAutenticacaoServidor {

	ControladoraPersistencia controladoraPersistencia;
	
	public BuilderAutenticacaoServidor() {
	    try {
	    	InterfaceControladoraNegocioAutenticacao interfaceControladoraNegocioAutenticacao = new ContorladoraNegocioAutenticacao();
	    	
	    	// cria controladora de persistencia e a pega como controladora
	    	// de persistencia para esta controladora de negocio
	    	controladoraPersistencia  = ControladoraPersistencia.instanciar();
	    	((ContorladoraNegocioAutenticacao) interfaceControladoraNegocioAutenticacao).setControladoraPersistencia(controladoraPersistencia);
	    	
	    	//torna disponível para RMI II
	    	Naming.rebind("rmi://localhost:1099/MensageiroService", interfaceControladoraNegocioAutenticacao);
	    	System.out.println( " NO Trouble: " );
	    }
	    catch( Exception e ) {
	      System.out.println( "Trouble: " + e );
	    }
	  }

	
	public static void main(String[] args) {
		
		new BuilderAutenticacaoServidor();
	}
}
