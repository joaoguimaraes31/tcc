 /*
 * Created on 21/05/2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package Persistencia;

import java.sql.*;

import javax.swing.JOptionPane;


/**
 * @author yury
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class Conexao  {
	
	private String url,username,password;
	private Connection conn;
	
	public Conexao(){
		
		url = "jdbc:odbc:frederico";
		username = "user";
		password = "pass";
		conectar();
	}	
	
	public Conexao(String url){
		
		this.url = url;
		username = "user";
		password = "pass";
		
		conectar();
	}
	
	private void conectar() {
		try{
			
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			conn = DriverManager.getConnection(url,username,password);
			JOptionPane.showMessageDialog(null,"Conexão com Banco de Dados com sucesso","Confirmação",JOptionPane.INFORMATION_MESSAGE);
		}
		catch (ClassNotFoundException cnfex){
			JOptionPane.showMessageDialog(null,"Erro: Conexão com Banco de Dados sem sucesso","Confirmação",JOptionPane.ERROR_MESSAGE);
		}
		catch (SQLException sqlex){
			JOptionPane.showMessageDialog(null,"Erro: Conexão com Banco de Dados sem sucesso","Confirmação",JOptionPane.ERROR_MESSAGE);
		}
		catch (Exception ex){
			JOptionPane.showMessageDialog(null,"Erro: Conexão com Banco de Dados sem sucesso","Confirmação",JOptionPane.ERROR_MESSAGE);
		}
		
	}
	
	public Connection getConnection(){
		return this.conn;
	}
	
	public void ShutDown(){
		try {
			conn.close();
		} 
		catch (Exception ex) {
			
		}
	}
}

