/*
 * Created on 08/06/2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package Controladoras;

import java.util.Enumeration;
import java.util.Vector;

import Comandos.ComandoSQLInserirCliente;
import Comandos.ComandoSQLInserirProduto;

import Comandos.ComandoSQLRemoverClienteAll;
import Comandos.ComandoSQLRemoverPedidosAll;
import Comandos.ComandoSQLRemoverProdutoAll;
import Persistencia.ControladoraPersistencia;
import builders.BuilderPedidoQuestao3;
import entidades.Codigo;
import entidades.SolicitaCliente;
import entidades.SolicitaPedido;
import entidades.SolicitaProduto;
import junit.framework.TestCase;

/**
 * @author yury
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class ControladoraNegocioPedidoTest extends TestCase {

	
	protected SolicitaPedido solicitaPedido, solicitaPedido1, solicitaPedido2;
	protected Vector vectorEntrada, vectorSaida;
	protected SolicitaCliente solicitaCliente1, solicitaCliente2;
	protected BuilderPedidoQuestao3 builderPedidoQuestao3;
	protected SolicitaProduto solicitaProduto1, solicitaProduto2;
	protected ComandoSQLRemoverClienteAll comandoSQLRemoverClienteAll;
	protected ComandoSQLRemoverPedidosAll comandoSQLRemoverPedidosAll;
	protected ComandoSQLRemoverProdutoAll comandoSQLRemoverProdutoAll;
	protected ComandoSQLInserirProduto comandoSQLInserirProduto;
	protected ControladoraNegocioPedido controladoraNegocioPedido;
	protected ComandoSQLInserirCliente comandoSQLInserirCliente;
	protected ControladoraPersistencia controladoraPersistencia;
	/*
	 * @see TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		
		builderPedidoQuestao3 = new BuilderPedidoQuestao3();
		builderPedidoQuestao3.criarSubssistemaClienteQuestao3("jdbc:odbc:fredericoteste");
		
		this.controladoraNegocioPedido =  builderPedidoQuestao3.getControladoraNegocioPedido();
		this.controladoraPersistencia = builderPedidoQuestao3.getControladoraPersistencia();
	
		vectorEntrada = new Vector();
		vectorSaida = new Vector();
		
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
			
	}

	/*
	 * @see TestCase#tearDown()
	 */
	protected void tearDown() throws Exception {
		controladoraPersistencia.shutDown();
		
		solicitaCliente1 = null;
		solicitaCliente2 = null;
		solicitaPedido1 = null;
		solicitaPedido2 = null;
		solicitaProduto1 = null;
		solicitaProduto2 = null;
		comandoSQLInserirProduto = null;
		comandoSQLInserirCliente = null;
		

		controladoraPersistencia = null;
		controladoraNegocioPedido = null;
		
		vectorEntrada = null;
		vectorSaida = null;
	}

	
	public final void testeComandosPedido() {
		
		String query,IDPedido1, IDProduto1, IDCliente1, Situacao1;  
		String IDPedido2, IDProduto2, IDCliente2, Situacao2;
		boolean flag;
		int rsInt;
		
		
		// Comando auxiliar faz um DELETE na Tabela Clientes do Banco de dados 
		// fredericoteste Apenas para auxiliar no início dos testes
		comandoSQLRemoverClienteAll = new  ComandoSQLRemoverClienteAll();
		rsInt = controladoraPersistencia.executeUpdate(comandoSQLRemoverClienteAll);
		
		
		//Comando auxiliar faz um DELETE na Tabela Produtos do Banco de dados 
		// fredericoteste Apenas para auxiliar no início dos testes
		comandoSQLRemoverProdutoAll = new  ComandoSQLRemoverProdutoAll();
		rsInt = controladoraPersistencia.executeUpdate(comandoSQLRemoverProdutoAll);
		
		
		//Comando auxiliar faz um DELETE na Tabela Pedidos do Banco de dados 
		// fredericoteste Apenas para auxiliar no início dos testes
		comandoSQLRemoverPedidosAll = new  ComandoSQLRemoverPedidosAll();
		rsInt = controladoraPersistencia.executeUpdate(comandoSQLRemoverPedidosAll);
		
		//Comando auxiliar que insere um produto, cujos dados estão contidos em 
		// solicitaProduto1. 
		comandoSQLInserirProduto = new ComandoSQLInserirProduto(solicitaProduto1);
		rsInt = controladoraPersistencia.executeUpdate(comandoSQLInserirProduto);
		
		//Comando auxiliar que insere um produto, cujos dados estão contidos em 
		// solicitaProduto2. 
		comandoSQLInserirProduto = new ComandoSQLInserirProduto(solicitaProduto2);
		rsInt = controladoraPersistencia.executeUpdate(comandoSQLInserirProduto);
		
		//Comando auxiliar que insere um cliente, cujos daddos estão contidos em 
		// solicitacliente1. 
		comandoSQLInserirCliente = new ComandoSQLInserirCliente(solicitaCliente1);
		rsInt = controladoraPersistencia.executeUpdate(comandoSQLInserirCliente);
		
		//Comando auxiliar que insere um cliente, cujos daddos estão contidos em 
		// solicitacliente2.
		comandoSQLInserirCliente = new ComandoSQLInserirCliente(solicitaCliente2);
		rsInt = controladoraPersistencia.executeUpdate(comandoSQLInserirCliente);
		
		
		//Agora que já se tem uma massa de teste começam em si os testes
		
		
		//Insere o primero pedido, cujos daddos estão contidos em 
		// solicitapedido1. Em seguida testa o resultado
	//	rsInt = controladoraNegocioPedido.inserir(solicitaPedido1);
		assertEquals("Não conseguiu inserir o Pedido:",rsInt, Codigo.OK);
		
		
		//Insere o primero pedido denovo, cujos dados estão contidos em 
		// solicitapedido1. Em seguida testa o resultado
	//	rsInt = controladoraNegocioPedido.inserir(solicitaPedido1);
		assertEquals("Não detectou a tentativa de inserção em um registro já existente :",rsInt, Codigo.FALHA_NO_PROCESSAMENTO_DO_BANCO);
		
		// Tenta remover pedido que não existente
	//	rsInt = controladoraNegocioPedido.remover("d99999");
		assertEquals("Não detectou a tentativa remoção de um registro não existente :",rsInt, Codigo.FALHA_NO_PROCESSAMENTO_DO_BANCO);
		
		//Insere o segundo pedido, cujos daddos estão contidos em 
		// solicitapedido2. Em seguida testa o resultado
	//	rsInt = controladoraNegocioPedido.inserir(solicitaPedido2);
		assertEquals("Não conseguiu inserir o pedido:",rsInt, Codigo.OK);
		
		//Recupera todos os pedidos do cliente "c004"
		
	//	vectorEntrada = controladoraNegocioPedido.pesquisaCliente("c004");

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
			ex.printStackTrace();
	
		}
		
		// Recupera todos registros da Tabela Pedidos
	//	vectorEntrada = controladoraNegocioPedido.pesquisa();
		
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
	//	solicitaPedido = controladoraNegocioPedido.pesquisa("d123"); 
		
		 String IDPedido = solicitaPedido.IDPedido;
		 String IDProduto = solicitaPedido.IDProduto;
		 String IDUsuario = solicitaPedido.IDUsuario;
		 String Situacao = solicitaPedido.Situacao;
		
		
					assertEquals("IDPedido recuperado não corresponde ao inserido:",IDPedido,"d123");
					
					assertEquals("IDProduto recuperado não corresponde ao inserido:",IDProduto,"p124");
				
					assertEquals("IDUsuario recuperado não corresponde ao inserido:",IDUsuario,"c003");
				
					assertEquals("Situacao recuperado não corresponde ao inserido:",Situacao,"Pendente");
					
		
		//Pesquisa de pedido que não existe
	//				solicitaPedido = controladoraNegocioPedido.pesquisa("d11111");
		
		assertEquals("Não detectou tentativa de pesquisar pedido inexistente:",solicitaPedido,null);
		
		
		//Remover pedido1
	//	rsInt = controladoraNegocioPedido.remover("d124");
		assertEquals("Não removeu pedido :",rsInt, Codigo.OK);

		
		//Processar Pedido2  
		
	//	rsInt = controladoraNegocioPedido.processar("d123");
		assertEquals("Não conseguiu processar o cliente:",rsInt, Codigo.OK);
		
	}
	
	
}


