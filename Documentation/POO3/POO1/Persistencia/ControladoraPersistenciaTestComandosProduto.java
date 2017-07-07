/*
 * Created on 24/05/2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package Persistencia;



import java.util.*;

import Comandos.ComandoSQLEditarProduto;
import Comandos.ComandoSQLInserirProduto;
import Comandos.ComandoSQLPesquisarProduto;
import Comandos.ComandoSQLRemoverProduto;
import Comandos.ComandoSQLRemoverProdutoAll;
import Comandos.ComandoSQLPesquisarProduto2;
import entidades.Codigo;
import entidades.SolicitaProduto;
import junit.framework.TestCase;

/**
 * @author yury
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class ControladoraPersistenciaTestComandosProduto extends TestCase {

	protected SolicitaProduto solicitaProduto1, solicitaProduto2;
	protected ComandoSQLEditarProduto comandoSQLEditarProduto;
	protected ComandoSQLInserirProduto comandoSQLInserirProduto;
	protected ComandoSQLRemoverProduto comandoSQLRemoverProduto;
	protected ComandoSQLRemoverProdutoAll comandoSQLRemoverProdutoAll;
	protected ComandoSQLPesquisarProduto comandoSQLPesquisarProduto;
	protected ComandoSQLPesquisarProduto2 comandoSQLPesquisarProduto2;
	protected ControladoraPersistencia controladoraPersistencia;
	protected Vector vectorEntrada, vectorSaida;
	/*
	 * @see TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		controladoraPersistencia= ControladoraPersistencia.instanciar("jdbc:odbc:fredericoteste");
	
		solicitaProduto1 = new SolicitaProduto(); 
		solicitaProduto2 = new SolicitaProduto();
		
		vectorEntrada = new Vector();
		vectorSaida = new Vector();
		
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
	}

	/*
	 * @see TestCase#tearDown()
	 */
	protected void tearDown() throws Exception {
		controladoraPersistencia.shutDown();
		
		solicitaProduto1 = null;
		solicitaProduto2 = null;
		
		comandoSQLEditarProduto = null;
		comandoSQLInserirProduto = null;
		comandoSQLRemoverProduto = null;
		comandoSQLPesquisarProduto = null;
		
		controladoraPersistencia = null;
		
		vectorEntrada = null;
		vectorSaida = null;
	}
	
	public final void testeComandosProduto() {
		String query, iDProduto1, descricaoTextual1, tipo1, preco1, quantidade1;
		String iDProduto2, descricaoTextual2, tipo2, preco2, quantidade2;
		boolean flag;
		int rsInt;
				
		// Faz um DELETE na Tabela Produtos do Bando de dados 
		// fredericoteste para o início dos testes
		comandoSQLRemoverProdutoAll = new ComandoSQLRemoverProdutoAll(); 
		rsInt = controladoraPersistencia.executeUpdate(comandoSQLRemoverProdutoAll);
		
		
		//Insere o primero produto, cujos dados estão contidos em 
		// solicitaProduto1. Em seguida testa o resultado
		comandoSQLInserirProduto = new ComandoSQLInserirProduto(solicitaProduto1);
		rsInt = controladoraPersistencia.executeUpdate(comandoSQLInserirProduto);
		assertEquals("Não conseguiu inserir o produto:",rsInt, Codigo.OK);
		
		
		//Insere o primero produto denovo, cujos dados estão contidos em 
		// solicitaProduto1. Em seguida testa o resultado
		comandoSQLInserirProduto = new ComandoSQLInserirProduto(solicitaProduto1);
		rsInt = controladoraPersistencia.executeUpdate(comandoSQLInserirProduto);
		assertEquals("Não detectou a tentativa de inserção em um registro já existente :",rsInt, Codigo.FALHA_NO_PROCESSAMENTO_DO_BANCO);
		
		
		// Tenta remover produto não existente
		comandoSQLRemoverProduto = new ComandoSQLRemoverProduto("p9999");
		rsInt = controladoraPersistencia.executeUpdate(comandoSQLRemoverProduto);
		assertEquals("Não detectou a tentativa remoção de um registro não existente :",rsInt, Codigo.FALHA_NO_PROCESSAMENTO_DO_BANCO);
		
		//Insere o segundo produto, cujos daddos estão contidos em 
		// solicitaProduto2. Em seguida testa o resultado
		comandoSQLInserirProduto = new ComandoSQLInserirProduto(solicitaProduto2);
		rsInt = controladoraPersistencia.executeUpdate(comandoSQLInserirProduto);
		assertEquals("Não conseguiu inserir o produto:",rsInt, Codigo.OK);
		
		
		// Recupera todos regsitros da Tabela Produtos
		comandoSQLPesquisarProduto2 = new ComandoSQLPesquisarProduto2();
		vectorEntrada = controladoraPersistencia.executeQuery(comandoSQLPesquisarProduto2);
		
		try{
			vectorEntrada.trimToSize();
			Enumeration enumeration = vectorEntrada.elements();
			if (enumeration.hasMoreElements()){
				vectorSaida=(Vector)(enumeration.nextElement());
				vectorSaida.trimToSize();
				Enumeration enumeration2= vectorSaida.elements();
				if (enumeration2.hasMoreElements()){
					iDProduto1 =""+enumeration2.nextElement()+"";
					assertEquals("iDProduto recuperado não corresponde ao inserido:",iDProduto1,"p123");
				}
				if (enumeration2.hasMoreElements()){
					descricaoTextual1 =""+enumeration2.nextElement()+"";
					assertEquals("descriçãoTextual recuperado não corresponde ao inserido:",descricaoTextual1,"Cereal matinal de milho");
					
				}
				if (enumeration2.hasMoreElements()){
					tipo1 =""+enumeration2.nextElement()+"";
					assertEquals("tipo recuperado não corresponde ao inserido:",tipo1,"Sucrilhos");
					
				}
				if (enumeration2.hasMoreElements()){
					preco1 =""+enumeration2.nextElement()+"";
					assertEquals("preço recuperado não corresponde ao inserido:",preco1,"4.5");
					
				}
				if (enumeration2.hasMoreElements()){
					quantidade1 =""+enumeration2.nextElement()+"";
					assertEquals("quantidade recuperado não corresponde ao inserido:",quantidade1,"800");
					assertEquals(" recuperados mais campos que o esperado",enumeration2.hasMoreElements(),false);
					
				}
				if (enumeration.hasMoreElements()){
					vectorSaida=(Vector)(enumeration.nextElement());
					vectorSaida.trimToSize();
					enumeration2= vectorSaida.elements();
					if (enumeration2.hasMoreElements()){
						iDProduto2 =""+enumeration2.nextElement()+"";
						assertEquals("iDProduto recuperado não corresponde ao inserido:",iDProduto2,"p124");
						
					}
					if (enumeration2.hasMoreElements()){
						descricaoTextual2 =""+enumeration2.nextElement()+"";
						assertEquals("descriçãoTextual recuperado não corresponde ao inserido:",descricaoTextual2,"Raquete de tenis");
						
					}
					if (enumeration2.hasMoreElements()){
						tipo2 =""+enumeration2.nextElement()+"";
						assertEquals("tipo recuperado não corresponde ao inserido:",tipo2,"Head Pro 550");
						
					}
					if (enumeration2.hasMoreElements()){
						preco2 =""+enumeration2.nextElement()+"";
						assertEquals("preço recuperado não corresponde ao inserido:",preco2,"500.0");
						
					}
					if (enumeration2.hasMoreElements()){
						quantidade2 =""+enumeration2.nextElement()+"";
						assertEquals("quantidade recuperado não corresponde ao inserido:",quantidade2,"100");
						assertEquals(" recuperados mais campos que o esperado",enumeration2.hasMoreElements(),false);
					}
					
					assertEquals(" recuperados mais registros que o esperado",enumeration.hasMoreElements(),false);
				}
			}
			
		}
		catch(Exception ex){
			
		}
		
		//Pesquisa individual de Produtos 
		comandoSQLPesquisarProduto = new ComandoSQLPesquisarProduto("p123");
		vectorEntrada = controladoraPersistencia.executeQuery(comandoSQLPesquisarProduto);
		try{
			vectorEntrada.trimToSize();
			Enumeration enumeration = vectorEntrada.elements();
			if (enumeration.hasMoreElements()){
				vectorSaida=(Vector)(enumeration.nextElement());
				vectorSaida.trimToSize();
				Enumeration enumeration2= vectorSaida.elements();
				if (enumeration2.hasMoreElements()){
					iDProduto1 =""+enumeration2.nextElement()+"";
					assertEquals("iDProduto recuperado não corresponde ao inserido:",iDProduto1,"p123");
				}
				if (enumeration2.hasMoreElements()){
					descricaoTextual1 =""+enumeration2.nextElement()+"";
					assertEquals("descriçãoTextual recuperado não corresponde ao inserido:",descricaoTextual1,"Cereal matinal de milho");
					
				}
				if (enumeration2.hasMoreElements()){
					tipo1 =""+enumeration2.nextElement()+"";
					assertEquals("tipo recuperado não corresponde ao inserido:",tipo1,"Sucrilhos");
					
				}
				if (enumeration2.hasMoreElements()){
					preco1 =""+enumeration2.nextElement()+"";
					assertEquals("preço recuperado não corresponde ao inserido:",preco1,"4.5");
					
				}
				if (enumeration2.hasMoreElements()){
					quantidade1 =""+enumeration2.nextElement()+"";
					assertEquals("quantidade recuperado não corresponde ao inserido:",quantidade1,"800");
					assertEquals(" recuperados mais campos que o esperado",enumeration2.hasMoreElements(),false);
				}
				
				assertEquals(" recuperados mais registros que o esperado",enumeration.hasMoreElements(),false);
				
			}
		}
		catch(Exception ex){
			
		}
		
	
		//Pesquisa de produto que não existe
		comandoSQLPesquisarProduto = new ComandoSQLPesquisarProduto("p111");
		vectorEntrada = controladoraPersistencia.executeQuery(comandoSQLPesquisarProduto);
		try{	
			assertEquals("Não detectou tentativa de pesquisar produto inexistente:",vectorEntrada,null);
		}
		catch(Exception ex){
			
		}
		
		//Remover produto1
		comandoSQLRemoverProduto = new ComandoSQLRemoverProduto("p123");
		rsInt = controladoraPersistencia.executeUpdate(comandoSQLRemoverProduto);
		assertEquals("Não removeu produto :",rsInt, Codigo.OK);
		
		//Editar produto2 mudando a descrição para "Raquete profissional de tenis" 
		solicitaProduto2.descricaoTextual = "Raquete profissional de tenis";
		comandoSQLEditarProduto = new ComandoSQLEditarProduto(solicitaProduto2);
		rsInt = controladoraPersistencia.executeUpdate(comandoSQLEditarProduto);
		assertEquals("Não conseguiu editar o produto:",rsInt, Codigo.OK);
		
	}

	
}
