/*
 * Created on 22/05/2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package Persistencia;

import java.sql.*;
import entidades.*;
import java.util.*;
import interfaces.*;
import Comandos.*;
/**
 * @author yury
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class ControladoraPersistencia implements InterfaceControladoraPersistencia {
	
	private Conexao conexao;
	private Connection conn;
	private static ControladoraPersistencia controladoraPersistenciaRef;
	
	
	// modo de construtor não url
	private ControladoraPersistencia (){
	conexao= new Conexao();
	conn = conexao.getConnection(); 
	
	}
	
	//modo de construtor indicando url
	private ControladoraPersistencia (String url){
		conexao= new Conexao(url);
		conn = conexao.getConnection(); 
		}
	
	public int executeUpdate(ComandoSQL comandoSQL){
		
		String query;
		
		query = comandoSQL.executar();
		
		try{
			Statement statement = conn.createStatement();
			int result = statement.executeUpdate(query);
			statement.close();
			if (result==1){
		
				return Codigo.OK;
			}
			else{
			
				return Codigo.FALHA_NO_PROCESSAMENTO_DO_BANCO; 
			} 
		}
		catch (Exception ex){
		
				return Codigo.FALHA_NO_PROCESSAMENTO_DO_BANCO; 
		}
		
	}
	
	public Vector executeQuery(ComandoSQL comandoSQL){
		Vector retorno = new Vector();
		boolean flag;
		String query;
		
		query = comandoSQL.executar();
		
		try{
			Statement statement = conn.createStatement();
			// testa para ver se o resultado da pesquisa é vazio
			ResultSet result = statement.executeQuery(query);
			if (!result.next()){
				statement.close();
				return null;
			}
			//busca os resultados da pesquisa 
			ResultSetMetaData resultSetMetaData = result.getMetaData();
			
			do{
				retorno.addElement(getProximoRegistro(result,resultSetMetaData));
			}while (result.next());
			statement.close();
			return retorno;
			

		}
		catch (Exception ex){
				
				return null;
		}
		
	}
	
	//modo de instanciamento não indicando url
	public static ControladoraPersistencia instanciar(){
		
		if (controladoraPersistenciaRef == null){
			controladoraPersistenciaRef = new ControladoraPersistencia(); 
		}
		return controladoraPersistenciaRef;
	}
	
//	 modo de instanciamento indicando url
	public static ControladoraPersistencia instanciar(String url){
		
		if (controladoraPersistenciaRef == null){
			controladoraPersistenciaRef = new ControladoraPersistencia(url); 
		}
		return controladoraPersistenciaRef;
	}
	
	public void shutDown(){
		conexao.ShutDown();	
	}
	
	private Vector getProximoRegistro(ResultSet result, ResultSetMetaData resultSetMetaData )
		
		throws SQLException 
		{
		
		Vector registroAtual = new Vector();
		
		for (int i =1; i<=resultSetMetaData.getColumnCount(); ++i){
			registroAtual.addElement(result.getString(i));
		}
		
		return registroAtual;
		
	}
}
