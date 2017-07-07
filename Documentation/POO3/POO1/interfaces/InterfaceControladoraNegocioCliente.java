/*
 * Created on 25/05/2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package interfaces;


import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Vector;
import entidades.SolicitaCliente;

/**
 * @author yury
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public interface InterfaceControladoraNegocioCliente extends Remote {

	public SolicitaCliente pesquisa (String IDUsuario) throws RemoteException;
	
	public Vector pesquisa()throws RemoteException;
	
	public int inserir(SolicitaCliente solicitaCliente)throws RemoteException;
	
	public int editar(SolicitaCliente solicitaCliente)throws RemoteException;
	
	public int remover(String IDCliente)throws RemoteException;
}
