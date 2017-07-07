/*
 * Created on 24/05/2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package Persistencia;


import java.util.Enumeration;
import java.util.Vector;

import junit.framework.TestCase;
import Comandos.ComandoSQLInserirCliente;
import Comandos.ComandoSQLInserirPedidos;
import Comandos.ComandoSQLInserirProduto;
import Comandos.ComandoSQLPesquisarClientePedidos;
import Comandos.ComandoSQLPesquisarPedidos;
import Comandos.ComandoSQLProcessarPedidos;
import Comandos.ComandoSQLRemoverPedidosAll;
import Comandos.ComandoSQLRemoverPedidos;
import Comandos.ComandoSQLPesquisarPedidos2;
import Comandos.ComandoSQLRemoverClienteAll;
import Comandos.ComandoSQLRemoverProdutoAll;
import entidades.Codigo;
import entidades.SolicitaCliente;
import entidades.SolicitaPedido;
import entidades.SolicitaProduto;

/**
 * @author yury
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class ControladoraPersistenciaTestComandosPedido extends TestCase {

	protected SolicitaCliente solicitaCliente1, solicitaCliente2;
	protected ComandoSQLInserirCliente comandoSQLInserirCliente;

	protected Vector vectorEntrada, vectorSaida;
	
	protected SolicitaProduto solicitaProduto1, solicitaProduto2;
	protected ComandoSQLInserirProduto comandoSQLInserirProduto;
	
	protected SolicitaPedido solicitaPedido1, solicitaPedido2;
	protected ComandoSQLProcessarPedidos comandoSQLProcessarPedidos;
	protected ComandoSQLInserirPedidos comandoSQLInserirPedidos;
	protected ComandoSQLPesquisarPedidos2 comandoSQLPesquisarPedidos2;
	protected ComandoSQLRemoverPedidos comandoSQLRemoverPedidos;
	protected ComandoSQLRemoverPedidosAll comandoSQLRemoverPedidosAll;
	protected ComandoSQLRemoverClienteAll comandoSQLRemoverClienteAll;
	protected ComandoSQLPesquisarPedidos comandoSQLPesquisarPedidos;
	protected ComandoSQLPesquisarClientePedidos comandoSQLPesquisarClientePedidos;
	protected ComandoSQLRemoverProdutoAll comandoSQLRemoverProdutoAll;
	protected ControladoraPersistencia controladoraPersistencia;
	/*
	 * @see TestCase#setUp()
	 */
	protected void setUp() throws Exception {
	
		controladoraPersistencia= ControladoraPersistencia.instanciar("jdbc:odbc:fredericoteste");
		
		solicitaCliente1 = new SolicitaCliente();
		solicitaCliente2 = new SolicitaCliente();
		solicitaCliente1.iDUsuario = "c003" ; 
		solicitaCliente1.nome = "Jacques Villeneuve";
		solicitaCliente1.senha = "villeneuve";
		solicitaCliente1.endereco = "Algum lugar em Quebéc";
		solicitaCliente1.email = "villeneuve@abc.com.ca";
		
		solicitaCliente2.iDUsuario = "c004" ; 
		solicitaCliente2.nome = "Lyse Marie Gagnon";
		solicitaCliente2.senha = "lysemg";
		solicitaCliente2.endereco = "Algum lugar em Quebéc";
		solicitaCliente2.email = "lysemg@abc.com.ca";
		
		solicitaProduto1 = new SolicitaProduto(); 
		solicitaProduto2 = new SolicitaProduto();
		
		solicitaProduto1.iDProduto = "p123";
		solicitaProduto1.descricaoTextual = "Cereal matinal de milho";
		solicitaProduto1.tipo = "Sucrilhos";
		solicitaProduto1.preco = "4.5";
		solicitaProduto1.quantidade = "800";
		
		solicitaProduto2.iDProduto = "p124";
		solicitaProduto2.descricaoTextual ="Raquete de tenis";
		solicitaProduto2.tipo ="Head Pro 550";
		solicitaProduto2.preco ="500.0";
		solicitaProduto2.quantidade ="100";
		
		solicitaPedido1 = new SolicitaPedido(); 
		solicitaPedido2 = new SolicitaPedido();
		
		solicitaPedido1.IDPedido = "d123";
		solicitaPedido1.IDProduto = "p124";
		solicitaPedido1.IDUsuario = "c003";
		solicitaPedido1.Situacao = "Pendente";
		
		solicitaPedido2.IDPedido = "d124";
		solicitaPedido2.IDProduto = "p123";
		solicitaPedido2.IDUsuario = "c004";
		solicitaPedido2.Situacao = "Pendente";
		
		vectorEntrada = new Vector();
		vectorSaida = new Vector();
			
	}

	/*
	 * @see TestCase#tearDown()
	 */
	protected void tearDown() throws Exception {
		controladoraPersistencia.shutDown();
		solicitaCliente1 = null;
		solicitaCliente2 = null;
		
		solicitaProduto1 = null;
		solicitaProduto2 = null;
		
		vectorEntrada = null;
		vectorSaida = null;
		
		controladoraPersistencia = null;
		comandoSQLProcessarPedidos = null;
		comandoSQLInserirPedidos = null; 
		comandoSQLRemoverPedidos = null; 
		comandoSQLPesquisarPedidos = null; 
		comandoSQLInserirCliente = null;
		comandoSQLInserirProduto = null;
		
		controladoraPersistencia = null;
	}

	
	public final void testeComandosPedido() {
		String query,IDPedido1, IDProduto1, IDCliente1, Situacao1;  
		String IDPedido2, IDProduto2, IDCliente2, Situacao2;
		boolean flag;
		int rsInt;
				
		// Faz um DELETE na Tabela Produtos do Banco de dados 
		// fredericoteste para o início dos testes
		comandoSQLRemoverProdutoAll = new ComandoSQLRemoverProdutoAll(); 
		rsInt = controladoraPersistencia.executeUpdate(comandoSQLRemoverProdutoAll);
		
		//Faz um DELETE na Tabela Produtos do Banco de dados 
		// fredericoteste para o início dos testes
		comandoSQLRemoverClienteAll = new ComandoSQLRemoverClienteAll(); 
		rsInt = controladoraPersistencia.executeUpdate(comandoSQLRemoverClienteAll);
		
		//Insere o primero produto, cujos dados estão contidos em 
		// solicitaProduto1. Em seguida testa o resultado
		comandoSQLInserirProduto = new ComandoSQLInserirProduto(solicitaProduto1);
		rsInt = controladoraPersistencia.executeUpdate(comandoSQLInserirProduto);
		assertEquals("Não conseguiu inserir o produto:",rsInt, Codigo.OK);
		
		//Insere o segundo produto, cujos dados estão contidos em 
		// solicitaProduto2. Em seguida testa o resultado
		comandoSQLInserirProduto = new ComandoSQLInserirProduto(solicitaProduto2);
		rsInt = controladoraPersistencia.executeUpdate(comandoSQLInserirProduto);
		assertEquals("Não conseguiu inserir o produto:",rsInt, Codigo.OK);
		
		//Insere o primero cliente, cujos daddos estão contidos em 
		// solicitacliente1. Em seguida testa o resultado
		comandoSQLInserirCliente = new ComandoSQLInserirCliente(solicitaCliente1);
		rsInt = controladoraPersistencia.executeUpdate(comandoSQLInserirCliente);
		assertEquals("Não conseguiu inserir o cliente:",rsInt, Codigo.OK);
		
		//Insere o segundo cliente, cujos daddos estão contidos em 
		// solicitacliente2. Em seguida testa o resultado
		comandoSQLInserirCliente = new ComandoSQLInserirCliente(solicitaCliente2);
		rsInt = controladoraPersistencia.executeUpdate(comandoSQLInserirCliente);
		assertEquals("Não conseguiu inserir o cliente:",rsInt, Codigo.OK);
		
		//Insere o primero pedido, cujos dados estão contidos em 
		// solicitaPedido1. Em seguida testa o resultado
		comandoSQLInserirPedidos = new ComandoSQLInserirPedidos(solicitaPedido1);
		rsInt = controladoraPersistencia.executeUpdate(comandoSQLInserirPedidos);
		assertEquals("Não conseguiu inserir o pedido:",rsInt, Codigo.OK);
		
		//Insere o primero pedido denovo, cujos dados estão contidos em 
		// solicitaPedido1. Em seguida testa o resultado
		comandoSQLInserirPedidos = new ComandoSQLInserirPedidos(solicitaPedido1);
		rsInt = controladoraPersistencia.executeUpdate(comandoSQLInserirPedidos);
		assertEquals("Não detectou a tentativa de inserção em um registro já existente :",rsInt, Codigo.FALHA_NO_PROCESSAMENTO_DO_BANCO);
		
		// Tenta remover pedido não existente
		comandoSQLRemoverPedidos = new ComandoSQLRemoverPedidos("d9999");
		rsInt = controladoraPersistencia.executeUpdate(comandoSQLRemoverPedidos);
		assertEquals("Não detectou a tentativa remoção de um registro não existente :",rsInt, Codigo.FALHA_NO_PROCESSAMENTO_DO_BANCO);
		
		//Insere o segundo pedido, cujos dados estão contidos em 
		// solicitaPedido2. Em seguida testa o resultado
		comandoSQLInserirPedidos = new ComandoSQLInserirPedidos(solicitaPedido2);
		rsInt = controladoraPersistencia.executeUpdate(comandoSQLInserirPedidos);
		assertEquals("Não conseguiu inserir o produto:",rsInt, Codigo.OK);
		
		//Recupera todos os pedidos do cliente "c004"
		
		comandoSQLPesquisarClientePedidos = new ComandoSQLPesquisarClientePedidos("c004");
		vectorEntrada = controladoraPersistencia.executeQuery(comandoSQLPesquisarClientePedidos);
		try{
			vectorEntrada.trimToSize();
			Enumeration enumeration = vectorEntrada.elements();
			if (enumeration.hasMoreElements()){
				vectorSaida=(Vector)(enumeration.nextElement());
				vectorSaida.trimToSize();
				Enumeration enumeration2= vectorSaida.elements();
				if (enumeration2.hasMoreElements()){
					IDPedido1 =""+enumeration2.nextElement()+"";
					assertEquals("IDPedido recuperado não corresponde ao inserido:",IDPedido1,"d124");
				}
				if (enumeration2.hasMoreElements()){
					IDProduto1 =""+enumeration2.nextElement()+"";
					assertEquals("IDProduto recuperado não corresponde ao inserido:",IDProduto1,"p123");
					
				}
				if (enumeration2.hasMoreElements()){
					IDCliente1 =""+enumeration2.nextElement()+"";
					assertEquals("IDCliente recuperado não corresponde ao inserido:",IDCliente1,"c004");
					
				}
				if (enumeration2.hasMoreElements()){
					Situacao1 =""+enumeration2.nextElement()+"";
					assertEquals("Situacao recuperado não corresponde ao inserido:",Situacao1,"Pendente");
					assertEquals("O registro contém mais campos que o esperado",enumeration2.hasMoreElements(),false);
				}
				assertEquals("Recuperados mais registos que o esperado",enumeration.hasMoreElements(),false);
			}		
		}
		catch(Exception ex){
	
		}
		
		// Recupera todos pedidos da Tabela Pedidos
		comandoSQLPesquisarPedidos2 = new ComandoSQLPesquisarPedidos2();
		vectorEntrada = controladoraPersistencia.executeQuery(comandoSQLPesquisarPedidos2);
		try{
			vectorEntrada.trimToSize();
			Enumeration enumeration = vectorEntrada.elements();
			if (enumeration.hasMoreElements()){
				vectorSaida=(Vector)(enumeration.nextElement());
				vectorSaida.trimToSize();
				Enumeration enumeration2= vectorSaida.elements();
				if (enumeration2.hasMoreElements()){
					IDPedido1 =""+enumeration2.nextElement()+"";
					assertEquals("IDPedido recuperado não corresponde ao inserido:",IDPedido1,"d123");
				}
				if (enumeration2.hasMoreElements()){
					IDProduto1 =""+enumeration2.nextElement()+"";
					assertEquals("IDProduto recuperado não corresponde ao inserido:",IDProduto1,"p124");
					
				}
				if (enumeration2.hasMoreElements()){
					IDCliente1 =""+enumeration2.nextElement()+"";
					assertEquals("IDCliente recuperado não corresponde ao inserido:",IDCliente1,"c003");
					
				}
				if (enumeration2.hasMoreElements()){
					Situacao1 =""+enumeration2.nextElement()+"";
					assertEquals("Situacao recuperado não corresponde ao inserido:",Situacao1,"Pendente");
					assertEquals("O registro contém mais campos que o esperado",enumeration2.hasMoreElements(),false);
				}

				if (enumeration.hasMoreElements()){
					vectorSaida=(Vector)(enumeration.nextElement());
					vectorSaida.trimToSize();
					enumeration2= vectorSaida.elements();
					if (enumeration2.hasMoreElements()){
						IDPedido2 =""+enumeration2.nextElement()+"";
						assertEquals("IDPedido recuperado não corresponde ao inserido:",IDPedido2,"d124");
						
					}
					if (enumeration2.hasMoreElements()){
						IDProduto2 =""+enumeration2.nextElement()+"";
						assertEquals("IDProduto recuperado não corresponde ao inserido:",IDProduto2,"p123");
						
					}
					if (enumeration2.hasMoreElements()){
						IDCliente2 =""+enumeration2.nextElement()+"";
						assertEquals("IDCliente recuperado não corresponde ao inserido:",IDCliente2,"c004");
						
					}
					if (enumeration2.hasMoreElements()){
						Situacao2 =""+enumeration2.nextElement()+"";
						assertEquals("Situacao recuperado não corresponde ao inserido:",Situacao2,"Pendente");
						assertEquals("O registro contém mais campos que o esperado",enumeration2.hasMoreElements(),false);
					}	
					assertEquals("Recuperados mais registos que o esperado",enumeration.hasMoreElements(),false);
				}
			
			}
		}	
		catch(Exception ex){
			ex.printStackTrace();
			
		}
		
		//Pesquisa individual de Pedidos 
		comandoSQLPesquisarPedidos = new ComandoSQLPesquisarPedidos("d123");
		vectorEntrada = controladoraPersistencia.executeQuery(comandoSQLPesquisarPedidos);
		try{
			
			vectorEntrada.trimToSize();
			Enumeration enumeration = vectorEntrada.elements();
			if (enumeration.hasMoreElements()){
				vectorSaida=(Vector)(enumeration.nextElement());
				vectorSaida.trimToSize();
				Enumeration enumeration2= vectorSaida.elements();
				if (enumeration2.hasMoreElements()){
					IDPedido1 =""+enumeration2.nextElement()+"";
					assertEquals("IDPedido recuperado não corresponde ao inserido:",IDPedido1,"d123");
				}
				if (enumeration2.hasMoreElements()){
					IDProduto1 =""+enumeration2.nextElement()+"";
					assertEquals("IDProduto recuperado não corresponde ao inserido:",IDProduto1,"p124");
					
				}
				if (enumeration2.hasMoreElements()){
					IDCliente1 =""+enumeration2.nextElement()+"";
					assertEquals("IDCliente recuperado não corresponde ao inserido:",IDCliente1,"c003");
					
				}
				if (enumeration2.hasMoreElements()){
					Situacao1 =""+enumeration2.nextElement()+"";
					assertEquals("Situacao recuperado não corresponde ao inserido:",Situacao1,"Pendente");
					assertEquals("Recuperados mais campos que o esperado",enumeration2.hasMoreElements(),false);
				}
				
				assertEquals("Recuperados mais registos que o esperado",enumeration.hasMoreElements(),false);
			}		
		}
		catch(Exception ex){
	
		}
		
		//Pesquisa de pedido que não existe
		comandoSQLPesquisarPedidos = new ComandoSQLPesquisarPedidos("d111");
		vectorEntrada = controladoraPersistencia.executeQuery(comandoSQLPesquisarPedidos);
		try{
			
			assertEquals("Não detectou tentativa de pesquisar pedido inexistente:",vectorEntrada,null);
		}
		catch(Exception ex){
			
		}
		
		//Remover pedido1
		comandoSQLRemoverPedidos = new ComandoSQLRemoverPedidos("d123");
		rsInt = controladoraPersistencia.executeUpdate(comandoSQLRemoverPedidos);
		assertEquals("Não removeu pedido :",rsInt, Codigo.OK);
		
		//Processar pedido2 
		comandoSQLProcessarPedidos = new ComandoSQLProcessarPedidos("d124");
		rsInt = controladoraPersistencia.executeUpdate(comandoSQLProcessarPedidos);
		assertEquals("Não conseguiu processar o pedido:",rsInt, Codigo.OK);
		
	}
	

	
}
