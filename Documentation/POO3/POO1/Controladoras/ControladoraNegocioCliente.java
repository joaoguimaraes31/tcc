/*
 * Created on 24/05/2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package Controladoras;
import interfaces.InterfaceControladoraNegocioCliente;
import interfaces.InterfaceControladoraPersistencia;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Enumeration;
import java.util.Vector;

import Comandos.ComandoSQLEditarCliente;
import Comandos.ComandoSQLInserirCliente;
import Comandos.ComandoSQLPesquisarCliente;
import Comandos.ComandoSQLPesquisarCliente2;
import Comandos.ComandoSQLRemoverCliente;

import entidades.SolicitaCliente;



/**
 * @author yury
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class ControladoraNegocioCliente extends UnicastRemoteObject implements InterfaceControladoraNegocioCliente {

	/**
	 * @throws RemoteException
	 */
	public ControladoraNegocioCliente() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	private InterfaceControladoraPersistencia interfaceControladoraPersistencia;
	
	public void setControladoraPersistencia(InterfaceControladoraPersistencia interfaceControladoraPersistencia){
		this.interfaceControladoraPersistencia = interfaceControladoraPersistencia;
	
	}
	
    //Pesquisa individual de Cliente.Se ocorrer erro na operação retorna "null" 
	public SolicitaCliente pesquisa (String IDUsuario) throws RemoteException{
		
		ComandoSQLPesquisarCliente comandoSQLPesquisarCliente;
		SolicitaCliente solicitaCliente = new SolicitaCliente();
		Vector vectorEntrada = new Vector();
		Vector vectorSaida = new Vector();
		String query;
		comandoSQLPesquisarCliente = new ComandoSQLPesquisarCliente(IDUsuario);
		vectorEntrada = interfaceControladoraPersistencia.executeQuery(comandoSQLPesquisarCliente);
		
		if (vectorEntrada != null){
			vectorEntrada.trimToSize();
			Enumeration enumeration = vectorEntrada.elements();
			if (enumeration.hasMoreElements()){
				vectorSaida=(Vector)(enumeration.nextElement());
				vectorSaida.trimToSize();
				Enumeration enumeration2= vectorSaida.elements();
				if (enumeration2.hasMoreElements()){
					solicitaCliente.iDUsuario =""+enumeration2.nextElement()+"";
				}
				else {
					return null;
				}
				if (enumeration2.hasMoreElements()){
					solicitaCliente.nome =""+enumeration2.nextElement()+"";
				}
				else {
					return null;
				}
				if (enumeration2.hasMoreElements()){
					solicitaCliente.senha =""+enumeration2.nextElement()+"";
				}
				else {
					return null;
				}
				if (enumeration2.hasMoreElements()){
					solicitaCliente.endereco =""+enumeration2.nextElement()+"";
				}
				else {
					return null;
				}
				if (enumeration2.hasMoreElements()){
					solicitaCliente.email =""+enumeration2.nextElement()+"";
				}
				else {
					return null;
				}
				
				return solicitaCliente;
			
			}else {
				return null;
			}
			
		}else{
			return null;
		}
	
	}
	
	//Pesquisa de Clientes.Se ocorrer erro na operação retorna "null" 
	public Vector pesquisa() throws RemoteException{
		
		ComandoSQLPesquisarCliente2 comandoSQLPesquisarCliente2;
		Vector vectorEntrada = new Vector();
		comandoSQLPesquisarCliente2 = new ComandoSQLPesquisarCliente2();
		vectorEntrada = interfaceControladoraPersistencia.executeQuery(comandoSQLPesquisarCliente2);
		
		return vectorEntrada;
	}
	
	public int inserir(SolicitaCliente solicitaCliente)throws RemoteException{
		
		int resultado;
		String query;
		ComandoSQLInserirCliente comandoSQLInserirCliente;
		comandoSQLInserirCliente = new ComandoSQLInserirCliente(solicitaCliente);
		resultado = interfaceControladoraPersistencia.executeUpdate(comandoSQLInserirCliente);
		
		return resultado;
	}
	
	public int editar(SolicitaCliente solicitaCliente)throws RemoteException{
		
		int resultado;
		String query;
		ComandoSQLEditarCliente comandoSQLEditarCliente;
		comandoSQLEditarCliente = new ComandoSQLEditarCliente(solicitaCliente);
		resultado = interfaceControladoraPersistencia.executeUpdate(comandoSQLEditarCliente);
		
		return resultado;
	}
	
	public int remover(String IDCliente) throws RemoteException{
		
		int resultado;
		String query;
		ComandoSQLRemoverCliente comandoSQLRemoverCliente;
		comandoSQLRemoverCliente = new ComandoSQLRemoverCliente(IDCliente);
		resultado = interfaceControladoraPersistencia.executeUpdate(comandoSQLRemoverCliente);
		
		return resultado;
	}
}
