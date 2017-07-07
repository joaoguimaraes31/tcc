/*
 * Created on 07/06/2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Vector;

import entidades.SolicitaPedido;

/**
 * @author yury
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public interface InterfaceControladoraNegocioPedido extends Remote {

	public SolicitaPedido pesquisa (String IDPedido)throws RemoteException;
	public Vector pesquisa()throws RemoteException;
	public Vector pesquisaCliente(String IDCliente)throws RemoteException;
	public int processar(String  IDPedido)throws RemoteException;
	public int remover(String IDPedido)throws RemoteException;
	public int inserir(SolicitaPedido solicitaPedido)throws RemoteException;
	
}
