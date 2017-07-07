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
import entidades.SolicitaProduto;

/**
 * @author yury
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public interface InterfaceControladoraNegocioProduto extends Remote {

	public SolicitaProduto pesquisa (String IDProduto)throws RemoteException;
	
	public Vector pesquisa()throws RemoteException;
	
	public int inserir(SolicitaProduto solicitaProduto)throws RemoteException;
	
	public int editar(SolicitaProduto solicitaProduto)throws RemoteException;
	
	public int remover(String IDProduto)throws RemoteException;
	
	public int subtrair (String IDProduto)throws RemoteException;
	
	public int somar(String IDProduto)throws RemoteException;
}
