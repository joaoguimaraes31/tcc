/*
 * Created on 24/05/2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package Controladoras;
import interfaces.InterfaceControladoraNegocioPedido;
import interfaces.InterfaceControladoraPersistencia;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Enumeration;
import java.util.Vector;

import Comandos.ComandoSQLInserirPedidos;
import Comandos.ComandoSQLPesquisarClientePedidos;
import Comandos.ComandoSQLPesquisarPedidos;
import Comandos.ComandoSQLPesquisarPedidos2;
import Comandos.ComandoSQLProcessarPedidos;
import Comandos.ComandoSQLRemoverPedidos;

import entidades.SolicitaPedido;



/**
 * @author yury
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class ControladoraNegocioPedido extends UnicastRemoteObject implements InterfaceControladoraNegocioPedido {

	/**
	 * @throws RemoteException
	 */
	public ControladoraNegocioPedido() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	private InterfaceControladoraPersistencia interfaceControladoraPersistencia;
	
	public void setControladoraPersistencia(InterfaceControladoraPersistencia interfaceControladoraPersistencia){
		this.interfaceControladoraPersistencia = interfaceControladoraPersistencia;
	
	}
	
    //Pesquisa individual de Pedido.Se ocorrer erro na operação retorna "null" 
	public SolicitaPedido pesquisa (String IDPedido)throws RemoteException{
		
		ComandoSQLPesquisarPedidos comandoSQLPesquisarPedidos;
		SolicitaPedido solicitaPedido = new SolicitaPedido();
		Vector vectorEntrada = new Vector();
		Vector vectorSaida = new Vector();
		String query;
		comandoSQLPesquisarPedidos = new ComandoSQLPesquisarPedidos(IDPedido);
		vectorEntrada = interfaceControladoraPersistencia.executeQuery(comandoSQLPesquisarPedidos);
		
		if (vectorEntrada!=null){
			vectorEntrada.trimToSize();
			Enumeration enumeration = vectorEntrada.elements();
			if (enumeration.hasMoreElements()){
				vectorSaida=(Vector)(enumeration.nextElement());
				vectorSaida.trimToSize();
				Enumeration enumeration2= vectorSaida.elements();
				if (enumeration2.hasMoreElements()){
					solicitaPedido.IDPedido =""+enumeration2.nextElement()+"";
				}
				else {
					return null;
				}
				if (enumeration2.hasMoreElements()){
					solicitaPedido.IDProduto =""+enumeration2.nextElement()+"";
				}
				else {
					return null;
				}
				if (enumeration2.hasMoreElements()){
					solicitaPedido.IDUsuario =""+enumeration2.nextElement()+"";
				}
				else {
					return null;
				}
				if (enumeration2.hasMoreElements()){
					solicitaPedido.Situacao =""+enumeration2.nextElement()+"";
				}
				else {
					return null;
				}
				
				return solicitaPedido;
			
			}else {
				return null;
			}
		}else {
			return null;
		}
				
	}
	
	//Pesquisa de Pedidos .Se ocorrer erro na operação retorna "null" 
	public Vector pesquisa()throws RemoteException{
		
		ComandoSQLPesquisarPedidos2 comandoSQLPesquisarPedidos2;
		Vector vectorEntrada = new Vector();
		comandoSQLPesquisarPedidos2 = new ComandoSQLPesquisarPedidos2();
		vectorEntrada = interfaceControladoraPersistencia.executeQuery(comandoSQLPesquisarPedidos2);
		
		return vectorEntrada;
	}
	
//	Pesquisa de Pedidos de um Cliente .Se ocorrer erro na operação retorna "null" 
	
	public Vector pesquisaCliente(String IDCliente)throws RemoteException{
		
		ComandoSQLPesquisarClientePedidos comandoSQLPesquisarClientePedidos;
		Vector vectorEntrada = new Vector();
		comandoSQLPesquisarClientePedidos = new ComandoSQLPesquisarClientePedidos(IDCliente);
		vectorEntrada = interfaceControladoraPersistencia.executeQuery(comandoSQLPesquisarClientePedidos);
		
		return vectorEntrada;
	}
	
	
	public int inserir(SolicitaPedido solicitaPedido)throws RemoteException{
		
		int resultado;
		String query;
		ComandoSQLInserirPedidos comandoSQLInserirPedidos;
		comandoSQLInserirPedidos = new ComandoSQLInserirPedidos(solicitaPedido);
		resultado = interfaceControladoraPersistencia.executeUpdate(comandoSQLInserirPedidos);
		
		return resultado;
	}
	
	public int processar(String  IDPedido)throws RemoteException{
		
		int resultado;
		String query;
		ComandoSQLProcessarPedidos comandoSQLProcessarPedidos;
		comandoSQLProcessarPedidos = new ComandoSQLProcessarPedidos(IDPedido);
		resultado = interfaceControladoraPersistencia.executeUpdate(comandoSQLProcessarPedidos);
		
		return resultado;
	}
	
	public int remover(String IDPedido)throws RemoteException{
		
		int resultado;
		String query;
		ComandoSQLRemoverPedidos comandoSQLRemoverPedidos;
		comandoSQLRemoverPedidos = new ComandoSQLRemoverPedidos(IDPedido);
		resultado = interfaceControladoraPersistencia.executeUpdate(comandoSQLRemoverPedidos);
		
		return resultado;
	}
}
