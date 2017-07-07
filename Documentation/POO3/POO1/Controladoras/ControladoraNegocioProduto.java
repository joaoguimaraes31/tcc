/*
 * Created on 24/05/2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package Controladoras;
import interfaces.InterfaceControladoraNegocioProduto;
import interfaces.InterfaceControladoraPersistencia;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Enumeration;
import java.util.Vector;

import Comandos.ComandoSQLEditarProduto;
import Comandos.ComandoSQLInserirProduto;
import Comandos.ComandoSQLPesquisarProduto;
import Comandos.ComandoSQLPesquisarProduto2;
import Comandos.ComandoSQLRemoverProduto;

import entidades.Codigo;
import entidades.SolicitaProduto;



/**
 * @author yury
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class ControladoraNegocioProduto extends UnicastRemoteObject implements InterfaceControladoraNegocioProduto {

	/**
	 * @throws RemoteException
	 */
	public ControladoraNegocioProduto() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	private InterfaceControladoraPersistencia interfaceControladoraPersistencia;
	
	public void setControladoraPersistencia(InterfaceControladoraPersistencia interfaceControladoraPersistencia){
		this.interfaceControladoraPersistencia = interfaceControladoraPersistencia;
	
	}
	
    //Pesquisa individual de Produto.Se ocorrer erro na operação retorna "null" 
	public SolicitaProduto pesquisa (String IDProduto) throws RemoteException{
		
		SolicitaProduto solicitaProduto = new SolicitaProduto();
		ComandoSQLPesquisarProduto comandoSQLPesquisarProduto;
		Vector vectorEntrada = new Vector();
		Vector vectorSaida = new Vector();
		comandoSQLPesquisarProduto = new ComandoSQLPesquisarProduto(IDProduto);
		vectorEntrada = interfaceControladoraPersistencia.executeQuery(comandoSQLPesquisarProduto);
		
		if (vectorEntrada != null){
			vectorEntrada.trimToSize();
			Enumeration enumeration = vectorEntrada.elements();
			if (enumeration.hasMoreElements()){
				vectorSaida=(Vector)(enumeration.nextElement());
				vectorSaida.trimToSize();
				Enumeration enumeration2= vectorSaida.elements();
				if (enumeration2.hasMoreElements()){
					solicitaProduto.iDProduto =""+enumeration2.nextElement()+"";
				}
				else {
					return null;
				}
				if (enumeration2.hasMoreElements()){
					solicitaProduto.descricaoTextual =""+enumeration2.nextElement()+"";
				}
				else {
					return null;
				}
				if (enumeration2.hasMoreElements()){
					solicitaProduto.tipo =""+enumeration2.nextElement()+"";
				}
				else {
					return null;
				}
				if (enumeration2.hasMoreElements()){
					solicitaProduto.preco =""+enumeration2.nextElement()+"";
				}
				else {
					return null;
				}
				if (enumeration2.hasMoreElements()){
					solicitaProduto.quantidade =""+enumeration2.nextElement()+"";
				}
				else {
					return null;
				}
				
				return solicitaProduto;
			
			}else {
				return null;
			}
		}else{
			return null;
		}	
					
	}
	
	//Pesquisa de Produtos. Se ocorrer erro na operação retorna "null" 
	public Vector pesquisa() throws RemoteException{
		
		ComandoSQLPesquisarProduto2 comandoSQLPesquisarProduto2;
		Vector vectorEntrada = new Vector();
		comandoSQLPesquisarProduto2 = new ComandoSQLPesquisarProduto2();
		vectorEntrada = interfaceControladoraPersistencia.executeQuery(comandoSQLPesquisarProduto2);
		
		return vectorEntrada;
	}
	
	public int inserir(SolicitaProduto solicitaProduto) throws RemoteException{
		
		int resultado;
		ComandoSQLInserirProduto comandoSQLInserirProduto;
		comandoSQLInserirProduto = new ComandoSQLInserirProduto(solicitaProduto);
		resultado = interfaceControladoraPersistencia.executeUpdate(comandoSQLInserirProduto);
		
		return resultado;
	}
	
	public int editar(SolicitaProduto solicitaProduto)throws RemoteException{
		
		int resultado;
		String query;
		ComandoSQLEditarProduto comandoSQLEditarProduto;
		comandoSQLEditarProduto = new ComandoSQLEditarProduto(solicitaProduto);
		resultado = interfaceControladoraPersistencia.executeUpdate(comandoSQLEditarProduto);
		
		return resultado;
	}
	
	public int remover(String IDProduto)throws RemoteException{
		
		int resultado;
		String query;
		ComandoSQLRemoverProduto comandoSQLRemoverProduto;
		comandoSQLRemoverProduto = new ComandoSQLRemoverProduto(IDProduto);
		resultado = interfaceControladoraPersistencia.executeUpdate(comandoSQLRemoverProduto);
		
		return resultado;
	}
	
	public int subtrair (String IDProduto)throws RemoteException{
		
		SolicitaProduto solicitaProduto;
		String quantidade;
		int quantidadeInt;
		
		solicitaProduto = pesquisa(IDProduto);
		
		if (solicitaProduto != null ){
			
			
			quantidade = solicitaProduto.quantidade; 
			quantidadeInt = Integer.parseInt(quantidade);
			
			if (quantidadeInt!=0){
			
				quantidadeInt = quantidadeInt-1;
				quantidade = quantidadeInt+"";
				solicitaProduto.quantidade = quantidade;
		
				return editar(solicitaProduto);
			}else{
				
				return Codigo.ESTOQUE_DO_PRODUTO_ESGOTADO;	
				
			}
			
		}else{
			
			return Codigo.FALHA_NO_PROCESSAMENTO_DO_BANCO;
		}
	}
	
	public int somar(String IDProduto) throws RemoteException{
		
		SolicitaProduto solicitaProduto;
		String quantidade;
		int quantidadeInt;
		
		solicitaProduto = pesquisa(IDProduto);
		
		if (solicitaProduto != null ){
			
			
			quantidade = solicitaProduto.quantidade; 
			quantidadeInt = Integer.parseInt(quantidade);
			
			quantidadeInt = quantidadeInt+1;
			quantidade = quantidadeInt+"";
			solicitaProduto.quantidade = quantidade;
		
			return editar(solicitaProduto);
		
		}else{
			
			return Codigo.FALHA_NO_PROCESSAMENTO_DO_BANCO;
		}
		
		
		
	}
}
