/*
 * Created on 08/06/2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package Controladoras;

import java.util.Enumeration;
import java.util.Vector;
import Comandos.ComandoSQLRemoverProdutoAll;
import Persistencia.ControladoraPersistencia;
import builders.BuilderProdutoQuestao3;
import entidades.Codigo;
import entidades.SolicitaAutenticacao;
import entidades.SolicitaProduto;
import junit.framework.TestCase;

/**
 * @author yury
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class ControladoraNegocioProdutoTest extends TestCase {

	protected SolicitaProduto solicitaProduto, solicitaProduto1, solicitaProduto2;
	protected SolicitaAutenticacao solicitaAutenticacao;
	protected Vector vectorEntrada, vectorSaida;
	protected BuilderProdutoQuestao3 builderProdutoQuestao3;
	protected ComandoSQLRemoverProdutoAll comandoSQLRemoverProdutoAll;
	protected ControladoraNegocioProduto controladoraNegocioProduto;
	protected ControladoraPersistencia controladoraPersistencia;
	/*
	 * @see TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		
		builderProdutoQuestao3 = new BuilderProdutoQuestao3();
		builderProdutoQuestao3.criarSubssistemaClienteQuestao3("jdbc:odbc:fredericoteste");
		
		this.controladoraNegocioProduto =  builderProdutoQuestao3.getControladoraNegocioProduto();
		this.controladoraPersistencia = builderProdutoQuestao3.getControladoraPersistencia();
	
		vectorEntrada = new Vector();
		vectorSaida = new Vector();
		
		solicitaAutenticacao = new SolicitaAutenticacao(); 
		solicitaAutenticacao.IDUsuario = "c003";
		solicitaAutenticacao.Senha = "villeneuve";
		
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
		
	}

	/*
	 * @see TestCase#tearDown()
	 */
	protected void tearDown() throws Exception {
		controladoraPersistencia.shutDown();
		solicitaProduto1 = null;
		solicitaProduto2 = null;
		

		controladoraPersistencia = null;
		controladoraNegocioProduto = null;
		
		vectorEntrada = null;
		vectorSaida = null;
	}

	
	public final void testeComandosPedido() {
		String query, iDProduto1, descricaoTextual1, tipo1, preco1, quantidade1;
		String iDProduto2, descricaoTextual2, tipo2, preco2, quantidade2;
		boolean flag;
		int rsInt;
		
		
		// Comando auxiliar faz um DELETE na Tabela Produtos do Banco de dados 
		// fredericoteste Apenas para auxiliar no in�cio dos testes
		comandoSQLRemoverProdutoAll = new  ComandoSQLRemoverProdutoAll();
		rsInt = controladoraPersistencia.executeUpdate(comandoSQLRemoverProdutoAll);
		
		
		//Insere o primero produto, cujos daddos est�o contidos em 
		// solicitaproduto1. Em seguida testa o resultado
	//	rsInt = controladoraNegocioProduto.inserir(solicitaProduto1);
		assertEquals("N�o conseguiu inserir o produto:",rsInt, Codigo.OK);
		
		
		//Insere o primero produto de novo, cujos dados est�o contidos em 
		// solicitaproduto1. Em seguida testa o resultado
	//	rsInt = controladoraNegocioProduto.inserir(solicitaProduto1);
		assertEquals("N�o detectou a tentativa de inser��o em um registro j� existente :",rsInt, Codigo.FALHA_NO_PROCESSAMENTO_DO_BANCO);
		
		// Tenta remover produto n�o existente
	//	rsInt = controladoraNegocioProduto.remover("p99999");
		assertEquals("N�o detectou a tentativa remo��o de um registro n�o existente :",rsInt, Codigo.FALHA_NO_PROCESSAMENTO_DO_BANCO);
		
		//Insere o segundo produto, cujos dados est�o contidos em 
		// solicitaProduto2. Em seguida testa o resultado
	//	rsInt = controladoraNegocioProduto.inserir(solicitaProduto2);
		assertEquals("N�o conseguiu inserir o produto:",rsInt, Codigo.OK);
		
		// Recupera todos registros da Tabela Produtos
	//	vectorEntrada = controladoraNegocioProduto.pesquisa();
		
		try{
			vectorEntrada.trimToSize();
			Enumeration enumeration = vectorEntrada.elements();
			if (enumeration.hasMoreElements()){
				vectorSaida=(Vector)(enumeration.nextElement());
				vectorSaida.trimToSize();
				Enumeration enumeration2= vectorSaida.elements();
				if (enumeration2.hasMoreElements()){
					iDProduto1 =""+enumeration2.nextElement()+"";
					assertEquals("iDProduto recuperado n�o corresponde ao inserido:",iDProduto1,"p123");
				}
				if (enumeration2.hasMoreElements()){
					descricaoTextual1 =""+enumeration2.nextElement()+"";
					assertEquals("descri��oTextual recuperado n�o corresponde ao inserido:",descricaoTextual1,"Cereal matinal de milho");
					
				}
				if (enumeration2.hasMoreElements()){
					tipo1 =""+enumeration2.nextElement()+"";
					assertEquals("tipo recuperado n�o corresponde ao inserido:",tipo1,"Sucrilhos");
					
				}
				if (enumeration2.hasMoreElements()){
					preco1 =""+enumeration2.nextElement()+"";
					assertEquals("pre�o recuperado n�o corresponde ao inserido:",preco1,"4.5");
					
				}
				if (enumeration2.hasMoreElements()){
					quantidade1 =""+enumeration2.nextElement()+"";
					assertEquals("quantidade recuperado n�o corresponde ao inserido:",quantidade1,"800");
					assertEquals(" recuperados mais campos que o esperado",enumeration2.hasMoreElements(),false);
					
				}
				if (enumeration.hasMoreElements()){
					vectorSaida=(Vector)(enumeration.nextElement());
					vectorSaida.trimToSize();
					enumeration2= vectorSaida.elements();
					if (enumeration2.hasMoreElements()){
						iDProduto2 =""+enumeration2.nextElement()+"";
						assertEquals("iDProduto recuperado n�o corresponde ao inserido:",iDProduto2,"p124");
						
					}
					if (enumeration2.hasMoreElements()){
						descricaoTextual2 =""+enumeration2.nextElement()+"";
						assertEquals("descri��oTextual recuperado n�o corresponde ao inserido:",descricaoTextual2,"Raquete de tenis");
						
					}
					if (enumeration2.hasMoreElements()){
						tipo2 =""+enumeration2.nextElement()+"";
						assertEquals("tipo recuperado n�o corresponde ao inserido:",tipo2,"Head Pro 550");
						
					}
					if (enumeration2.hasMoreElements()){
						preco2 =""+enumeration2.nextElement()+"";
						assertEquals("pre�o recuperado n�o corresponde ao inserido:",preco2,"500.0");
						
					}
					if (enumeration2.hasMoreElements()){
						quantidade2 =""+enumeration2.nextElement()+"";
						assertEquals("quantidade recuperado n�o corresponde ao inserido:",quantidade2,"100");
						assertEquals(" recuperados mais campos que o esperado",enumeration2.hasMoreElements(),false);
					}
					
					assertEquals(" recuperados mais registros que o esperado",enumeration.hasMoreElements(),false);
				}
			}
			
		}
		catch(Exception ex){
			ex.printStackTrace();
			
		}
		
		//Pesquisa individual de Produtos 
//		solicitaProduto = controladoraNegocioProduto.pesquisa("p123"); 
		
		iDProduto1 = solicitaProduto.iDProduto;
		descricaoTextual1 = solicitaProduto.descricaoTextual;
		tipo1 = solicitaProduto.tipo;
		preco1 = solicitaProduto.preco;
		quantidade1 = solicitaProduto.quantidade;
		
		assertEquals("iDProduto recuperado n�o corresponde ao inserido:",iDProduto1,"p123");
		assertEquals("descri��oTextual recuperado n�o corresponde ao inserido:",descricaoTextual1,"Cereal matinal de milho");
		assertEquals("tipo recuperado n�o corresponde ao inserido:",tipo1,"Sucrilhos");
		assertEquals("pre�o recuperado n�o corresponde ao inserido:",preco1,"4.5");
		assertEquals("quantidade recuperado n�o corresponde ao inserido:",quantidade1,"800");
		
		//Pesquisa de produto que n�o existe
	//	solicitaProduto = controladoraNegocioProduto.pesquisa("p11111");
		
		assertEquals("N�o detectou tentativa de pesquisar produto inexistente:",solicitaProduto,null);
		
		
		//Remover Produto1
	//	rsInt = controladoraNegocioProduto.remover("p123");
		assertEquals("N�o removeu produto :",rsInt, Codigo.OK);

		
		//Editar produto2 mudando a quantidade para "1" 
		solicitaProduto2.quantidade = "1";
	//	rsInt = controladoraNegocioProduto.editar(solicitaProduto2);
		assertEquals("N�o conseguiu editar o produto:",rsInt, Codigo.OK);
		
		// Subtrair quantidade do produto2
//		rsInt = controladoraNegocioProduto.subtrair("p124");
		assertEquals("N�o conseguiu subtrair quantidade do produto:",rsInt, Codigo.OK);
		
		//Subtrair quantidade do produto2. Detalhe, a quantidade j� � zero. Ent�o
		// n�o pode haver subtra��o
//		rsInt = controladoraNegocioProduto.subtrair("p124");
		assertEquals("N�o conseguiu detectar falta do produto:",rsInt, Codigo.ESTOQUE_DO_PRODUTO_ESGOTADO);
	
		// Somar quantidade ao produto2
	//	rsInt = controladoraNegocioProduto.somar("p124");
		assertEquals("N�o conseguiu somar quantidade ao produto:",rsInt, Codigo.OK);
		

	}
	
}
