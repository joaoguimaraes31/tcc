/*
 * Created on 24/05/2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package Persistencia;



import Comandos.*;
import entidades.Codigo;
import entidades.SolicitaCliente;
import entidades.SolicitaAutenticacao;
import junit.framework.TestCase;
import java.util.*;

/**
 * @author yury
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class ControladoraPersistenciaTestComandosCliente extends TestCase {

	protected SolicitaCliente solicitaCliente1, solicitaCliente2;
	protected SolicitaAutenticacao solicitaAutenticacao;
	protected Vector vectorEntrada, vectorSaida;
	protected ComandoSQLEditarCliente comandoSQLEditarCliente;
	protected ComandoSQLInserirCliente comandoSQLInserirCliente;
	protected ComandoSQLRemoverCliente comandoSQLRemoverCliente;
	protected ComandoSQLPesquisarCliente comandoSQLPesquisarCliente;
	protected ComandoSQLPesquisarCliente2 comandoSQLPesquisarCliente2;
	protected ComandoSQLAtenticacao comandoSQLAtenticacao;
	protected ComandoSQLRemoverClienteAll comandoSQLRemoverClienteAll;
	
	protected ControladoraPersistencia controladoraPersistencia;
	/*
	 * @see TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		
		controladoraPersistencia = ControladoraPersistencia.instanciar("jdbc:odbc:fredericoteste");
		
		vectorEntrada = new Vector();
		vectorSaida = new Vector();
		
		solicitaAutenticacao = new SolicitaAutenticacao(); 
		solicitaAutenticacao.IDUsuario = "c003";
		solicitaAutenticacao.Senha = "villeneuve";
		
		solicitaCliente1 = new SolicitaCliente();
		solicitaCliente2 = new SolicitaCliente();
		solicitaCliente1.iDUsuario = "c003" ; 
		solicitaCliente1.nome = "Jacques Villeneuve";
		solicitaCliente1.senha = "villeneuve";
		solicitaCliente1.endereco = "Algum lugar em Queb�c";
		solicitaCliente1.email = "villeneuve@abc.com.ca";
		
		solicitaCliente2.iDUsuario = "c004" ; 
		solicitaCliente2.nome = "Lyse Marie Gagnon";
		solicitaCliente2.senha = "lysemg";
		solicitaCliente2.endereco = "Algum lugar em Queb�c";
		solicitaCliente2.email = "lysemg@abc.com.ca";
		
	}

	/*
	 * @see TestCase#tearDown()
	 */
	protected void tearDown() throws Exception {
		controladoraPersistencia.shutDown();
		solicitaCliente1 = null;
		solicitaCliente2 = null;
		
		comandoSQLEditarCliente = null;
		comandoSQLInserirCliente = null;
		comandoSQLRemoverCliente = null;
		comandoSQLPesquisarCliente = null;
		
		controladoraPersistencia = null;
		
		vectorEntrada = null;
		vectorSaida = null;
	}

	
	public final void testeComandosCliente() {
		String query,IDCliente1, Nome1, Senha1,Endereco1,Email1;
		String IDCliente2, Nome2, Senha2,Endereco2,Email2;
		
		boolean flag;
		int rsInt;
		
		
		// Faz um DELETE na Tabela Clientes do Bando de dados 
		// fredericoteste para o in�cio dos testes
		comandoSQLRemoverClienteAll = new  ComandoSQLRemoverClienteAll();
		
		rsInt = controladoraPersistencia.executeUpdate(comandoSQLRemoverClienteAll);
	
		
		//Insere o primero cliente, cujos daddos est�o contidos em 
		// solicitacliente1. Em seguida testa o resultado
		comandoSQLInserirCliente = new  ComandoSQLInserirCliente(solicitaCliente1);
		rsInt = controladoraPersistencia.executeUpdate(comandoSQLInserirCliente);
		assertEquals("N�o conseguiu inserir o cliente:",rsInt, Codigo.OK);
		
		
		//Insere o primero cliente denovo, cujos dados est�o contidos em 
		// solicitacliente1. Em seguida testa o resultado
		comandoSQLInserirCliente = new ComandoSQLInserirCliente(solicitaCliente1);
		rsInt = controladoraPersistencia.executeUpdate(comandoSQLInserirCliente);
		assertEquals("N�o detectou a tentativa de inser��o em um registro j� existente :",rsInt, Codigo.FALHA_NO_PROCESSAMENTO_DO_BANCO);
		
		// Simula a autentica��o de um cliente
		comandoSQLAtenticacao = new ComandoSQLAtenticacao(solicitaAutenticacao);
		vectorEntrada = controladoraPersistencia.executeQuery(comandoSQLAtenticacao);
		try{
			vectorEntrada.trimToSize();
			Enumeration enumeration = vectorEntrada.elements();
			if (enumeration.hasMoreElements()){
				vectorSaida=(Vector)(enumeration.nextElement());
				vectorSaida.trimToSize();
				Enumeration enumeration2= vectorSaida.elements();
				if (enumeration2.hasMoreElements()){
					IDCliente1 =""+enumeration2.nextElement()+"";
					assertEquals("IDCliente recuperado n�o corresponde ao inserido:",IDCliente1,"c003");
				}
				if (enumeration2.hasMoreElements()){
					Nome1 =""+enumeration2.nextElement()+"";
					assertEquals("Nome recuperado n�o corresponde ao inserido:",Nome1,"Jacques Villeneuve");
				}
				if (enumeration2.hasMoreElements()){
					Senha1 =""+enumeration2.nextElement()+"";
					assertEquals("Senha recuperado n�o corresponde ao inserido:",Senha1,"villeneuve");
				}
				if (enumeration2.hasMoreElements()){
					Endereco1 =""+enumeration2.nextElement()+"";
					assertEquals("Endereco recuperado n�o corresponde ao inserido:",Endereco1,"Algum lugar em Queb�c");
				}
				if (enumeration2.hasMoreElements()){
					Email1 =""+enumeration2.nextElement()+"";
					assertEquals("Email recuperado n�o corresponde ao inserido:",Email1,"villeneuve@abc.com.ca");
					assertEquals("O registro cont�m mais campos que o esperado",enumeration2.hasMoreElements(),false);
				}
				assertEquals("O recuperados mais registros que o esperado",enumeration.hasMoreElements(),false);
			}
		}
		catch(Exception ex){
			ex.printStackTrace();
	
		}
		
		// Tenta remover cliente n�o existente
		comandoSQLRemoverCliente = new  ComandoSQLRemoverCliente("c9999");
		rsInt = controladoraPersistencia.executeUpdate(comandoSQLRemoverCliente);
		assertEquals("N�o detectou a tentativa remo��o de um registro n�o existente :",rsInt, Codigo.FALHA_NO_PROCESSAMENTO_DO_BANCO);
		
		//Insere o segundo cliente, cujos daddos est�o contidos em 
		// solicitacliente2. Em seguida testa o resultado
		comandoSQLInserirCliente = new  ComandoSQLInserirCliente(solicitaCliente2);
		rsInt = controladoraPersistencia.executeUpdate(comandoSQLInserirCliente);
		assertEquals("N�o conseguiu inserir o cliente:",rsInt, Codigo.OK);
		
		
		
		// Recupera todos registros da Tabela Clientes
		comandoSQLPesquisarCliente2 = new ComandoSQLPesquisarCliente2();
		vectorEntrada = controladoraPersistencia.executeQuery(comandoSQLPesquisarCliente2);
		try{
			vectorEntrada.trimToSize();
			Enumeration enumeration = vectorEntrada.elements();
			if (enumeration.hasMoreElements()){
				vectorSaida=(Vector)(enumeration.nextElement());
				vectorSaida.trimToSize();
				Enumeration enumeration2= vectorSaida.elements();
				if (enumeration2.hasMoreElements()){
					IDCliente1 =""+enumeration2.nextElement()+"";
					assertEquals("IDCliente recuperado n�o corresponde ao inserido:",IDCliente1,"c003");
				}
				if (enumeration2.hasMoreElements()){
					Nome1 =""+enumeration2.nextElement()+"";
					assertEquals("Nome recuperado n�o corresponde ao inserido:",Nome1,"Jacques Villeneuve");
				}
				if (enumeration2.hasMoreElements()){
					Senha1 =""+enumeration2.nextElement()+"";
					assertEquals("Senha recuperado n�o corresponde ao inserido:",Senha1,"villeneuve");
				}
				if (enumeration2.hasMoreElements()){
					Endereco1 =""+enumeration2.nextElement()+"";
					assertEquals("Endereco recuperado n�o corresponde ao inserido:",Endereco1,"Algum lugar em Queb�c");
				}
				if (enumeration2.hasMoreElements()){
					Email1 =""+enumeration2.nextElement()+"";
					assertEquals("Email recuperado n�o corresponde ao inserido:",Email1,"villeneuve@abc.com.ca");
					assertEquals("O registro cont�m mais campos que o esperado",enumeration2.hasMoreElements(),false);
				}
				if (enumeration.hasMoreElements()){
					vectorSaida=(Vector)(enumeration.nextElement());
					vectorSaida.trimToSize();
					enumeration2= vectorSaida.elements();
					if (enumeration2.hasMoreElements()){
						IDCliente2 =""+enumeration2.nextElement()+"";
						assertEquals("IDCliente recuperado n�o corresponde ao inserido:",IDCliente2,"c004");
					}
					if (enumeration2.hasMoreElements()){
						Nome2 =""+enumeration2.nextElement()+"";
						assertEquals("Nome recuperado n�o corresponde ao inserido:",Nome2,"Lyse Marie Gagnon");
					}
					if (enumeration2.hasMoreElements()){
						Senha2 =""+enumeration2.nextElement()+"";
						assertEquals("Senha recuperado n�o corresponde ao inserido:",Senha2,"lysemg");
					}
					if (enumeration2.hasMoreElements()){
						Endereco2 =""+enumeration2.nextElement()+"";
						assertEquals("Endereco recuperado n�o corresponde ao inserido:",Endereco2,"Algum lugar em Queb�c");
					}
					if (enumeration2.hasMoreElements()){
						Email2 =""+enumeration2.nextElement()+"";
						assertEquals("Email recuperado n�o corresponde ao inserido:",Email2,"lysemg@abc.com.ca");
						assertEquals("O registro cont�m mais campos que o esperado",enumeration2.hasMoreElements(),false);
					}
				}
				assertEquals("O recuperados mais registros que o esperado",enumeration.hasMoreElements(),false);
			}
			
		}
		catch(Exception ex){
			
		}
		
		//Pesquisa individual de Clientes 
		comandoSQLPesquisarCliente = new ComandoSQLPesquisarCliente("c003");
		vectorEntrada = controladoraPersistencia.executeQuery(comandoSQLPesquisarCliente);
		try{
			vectorEntrada.trimToSize();
			Enumeration enumeration = vectorEntrada.elements();
			if (enumeration.hasMoreElements()){
				vectorSaida=(Vector)(enumeration.nextElement());
				vectorSaida.trimToSize();
				Enumeration enumeration2= vectorSaida.elements();
				if (enumeration2.hasMoreElements()){
					IDCliente1 =""+enumeration2.nextElement()+"";
					assertEquals("IDCliente recuperado n�o corresponde ao inserido:",IDCliente1,"c003");
				}
				if (enumeration2.hasMoreElements()){
					Nome1 =""+enumeration2.nextElement()+"";
					assertEquals("Nome recuperado n�o corresponde ao inserido:",Nome1,"Jacques Villeneuve");
				}
				if (enumeration2.hasMoreElements()){
					Senha1 =""+enumeration2.nextElement()+"";
					assertEquals("Senha recuperado n�o corresponde ao inserido:",Senha1,"villeneuve");
				}
				if (enumeration2.hasMoreElements()){
					Endereco1 =""+enumeration2.nextElement()+"";
					assertEquals("Endereco recuperado n�o corresponde ao inserido:",Endereco1,"Algum lugar em Queb�c");
				}
				if (enumeration2.hasMoreElements()){
					Email1 =""+enumeration2.nextElement()+"";
					assertEquals("Email recuperado n�o corresponde ao inserido:",Email1,"villeneuve@abc.com.ca");
					assertEquals("O registro cont�m mais campos que o esperado",enumeration2.hasMoreElements(),false);
				}
				assertEquals("O recuperados mais registros que o esperado",enumeration.hasMoreElements(),false);
			}
		}
		catch(Exception ex){
			ex.printStackTrace();
	
		}
		
		//Pesquisa de cliente que n�o existe
		comandoSQLPesquisarCliente = new ComandoSQLPesquisarCliente("c111");
		vectorEntrada = controladoraPersistencia.executeQuery(comandoSQLPesquisarCliente);
		try{
			
			assertEquals("N�o detectou tentativa de pesquisar cliente inexistente:",vectorEntrada,null);
		}
		catch(Exception ex){
			ex.printStackTrace();
			
		}
		
		//Remover cliente1
		comandoSQLRemoverCliente = new ComandoSQLRemoverCliente("c003");
		rsInt = controladoraPersistencia.executeUpdate(comandoSQLRemoverCliente);
		assertEquals("N�o removeu cliente :",rsInt, Codigo.OK);
	
		//Editar cliente2 mudando a senha para "llmmgg" 
		solicitaCliente2.senha = "llmmgg";
		comandoSQLEditarCliente = new ComandoSQLEditarCliente(solicitaCliente2);
	
		rsInt = controladoraPersistencia.executeUpdate(comandoSQLEditarCliente);
		assertEquals("N�o conseguiu editar o cliente:",rsInt, Codigo.OK);
		
	}
	
	
}
