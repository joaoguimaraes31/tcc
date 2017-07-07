/*
 * Created on 26/05/2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package Controladoras;

import interfaces.InterfaceControladoraNegocioAutenticacao;
import interfaces.InterfaceControladoraPersistencia;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Vector;

import Comandos.ComandoSQLAtenticacao;

import entidades.Codigo;
import entidades.SolicitaAutenticacao;





/**
 * @author yury
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class ContorladoraNegocioAutenticacao extends UnicastRemoteObject  implements InterfaceControladoraNegocioAutenticacao{

	
	/**
	 * @throws RemoteException
	 */
	public ContorladoraNegocioAutenticacao() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	private InterfaceControladoraPersistencia interfaceControladoraPersistencia;
	
	public void setControladoraPersistencia(InterfaceControladoraPersistencia interfaceControladoraPersistencia){
		this.interfaceControladoraPersistencia = interfaceControladoraPersistencia;
	
	}
	
	public int autenticar (SolicitaAutenticacao solicitaAutenticacao)throws RemoteException{
	

	
		ComandoSQLAtenticacao comandoSQLAtenticacao;
		Vector vectorSaida = new Vector();
		comandoSQLAtenticacao = new ComandoSQLAtenticacao(solicitaAutenticacao);
		vectorSaida = interfaceControladoraPersistencia.executeQuery(comandoSQLAtenticacao);

	
		if (vectorSaida !=null ){
			
				return Codigo.OK;
		}else {
			return Codigo.DADOS_DE_AUTENTICACAO_INVALIDOS;
		}
	}
}
