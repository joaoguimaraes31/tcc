/*
 * Created on 26/05/2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

import entidades.SolicitaAutenticacao;

/**
 * @author yury
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public interface InterfaceControladoraNegocioAutenticacao extends Remote {

	public int autenticar (SolicitaAutenticacao solicitaAutenticacao)throws RemoteException;

	
	
}
