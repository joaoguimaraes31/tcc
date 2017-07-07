/*
 * Created on 08/06/2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package Controladoras;

import java.util.Enumeration;
import java.util.Vector;

import builders.BuilderClienteQuestao3;

import Comandos.ComandoSQLRemoverClienteAll;
import Persistencia.ControladoraPersistencia;
import entidades.Codigo;
import entidades.SolicitaAutenticacao;
import entidades.SolicitaCliente;
import junit.framework.TestCase;

/**
 * @author yury
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class ControladoraNegocioClienteTest extends TestCase {

	protected SolicitaCliente solicitaCliente, solicitaCliente1, solicitaCliente2;
	protected SolicitaAutenticacao solicitaAutenticacao;
	protected Vector vectorEntrada, vectorSaida;
	protected BuilderClienteQuestao3 builderClienteQuestao3;
	protected ComandoSQLRemoverClienteAll comandoSQLRemoverClienteAll;
	protected ControladoraNegocioCliente controladoraNegocioCliente;
	protected ControladoraPersistencia controladoraPersistencia;
	/*
	 * @see TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		
		builderClienteQuestao3 = new BuilderClienteQuestao3();
		builderClienteQuestao3.criarSubssistemaClienteQuestao3("jdbc:odbc:fredericoteste");
		
		this.controladoraNegocioCliente =  builderClienteQuestao3.getControladoraNegocioCliente();
		this.controladoraPersistencia = builderClienteQuestao3.getControladoraPersistencia();
	
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
		solicitaCliente1.endereco = "Algum lugar em Quebéc";
		solicitaCliente1.email = "villeneuve@abc.com.ca";
		
		solicitaCliente2.iDUsuario = "c004" ; 
		solicitaCliente2.nome = "Lyse Marie Gagnon";
		solicitaCliente2.senha = "lysemg";
		solicitaCliente2.endereco = "Algum lugar em Quebéc";
		solicitaCliente2.email = "lysemg@abc.com.ca";
		
	}

	/*
	 * @see TestCase#tearDown()
	 */
	protected void tearDown() throws Exception {
		controladoraPersistencia.shutDown();
		solicitaCliente1 = null;
		solicitaCliente2 = null;
		

		controladoraPersistencia = null;
		controladoraNegocioCliente = null;
		
		vectorEntrada = null;
		vectorSaida = null;
	}

	
	public final void testeComandosCliente() {
		String query,IDCliente1, Nome1, Senha1,Endereco1,Email1;
		String IDCliente2, Nome2, Senha2,Endereco2,Email2;
		
		boolean flag;
		int rsInt;
		
		
		// Comando auxiliar faz um DELETE na Tabela Clientes do Banco de dados 
		// fredericoteste Apenas para auxiliar no início dos testes
		comandoSQLRemoverClienteAll = new  ComandoSQLRemoverClienteAll();
		rsInt = controladoraPersistencia.executeUpdate(comandoSQLRemoverClienteAll);
		
		
		//Insere o primero cliente, cujos daddos estão contidos em 
		// solicitacliente1. Em seguida testa o resultado
	//	rsInt = controladoraNegocioCliente.inserir(solicitaCliente1);
		assertEquals("Não conseguiu inserir o cliente:",rsInt, Codigo.OK);
		
		
		//Insere o primero cliente denovo, cujos dados estão contidos em 
		// solicitacliente1. Em seguida testa o resultado
	//	rsInt = controladoraNegocioCliente.inserir(solicitaCliente1);
		assertEquals("Não detectou a tentativa de inserção em um registro já existente :",rsInt, Codigo.FALHA_NO_PROCESSAMENTO_DO_BANCO);
		
		// Tenta remover cliente não existente
	//	rsInt = controladoraNegocioCliente.remover("c99999");
		assertEquals("Não detectou a tentativa remoção de um registro não existente :",rsInt, Codigo.FALHA_NO_PROCESSAMENTO_DO_BANCO);
		
		//Insere o segundo cliente, cujos daddos estão contidos em 
		// solicitacliente2. Em seguida testa o resultado
//		rsInt = controladoraNegocioCliente.inserir(solicitaCliente2);
		assertEquals("Não conseguiu inserir o cliente:",rsInt, Codigo.OK);
		
		// Recupera todos registros da Tabela Clientes
//		vectorEntrada = controladoraNegocioCliente.pesquisa();
		
		try{
			vectorEntrada.trimToSize();
			Enumeration enumeration = vectorEntrada.elements();
			if (enumeration.hasMoreElements()){
				vectorSaida=(Vector)(enumeration.nextElement());
				vectorSaida.trimToSize();
				Enumeration enumeration2= vectorSaida.elements();
				if (enumeration2.hasMoreElements()){
					IDCliente1 =""+enumeration2.nextElement()+"";
					assertEquals("IDCliente recuperado não corresponde ao inserido:",IDCliente1,"c003");
				}
				if (enumeration2.hasMoreElements()){
					Nome1 =""+enumeration2.nextElement()+"";
					assertEquals("Nome recuperado não corresponde ao inserido:",Nome1,"Jacques Villeneuve");
				}
				if (enumeration2.hasMoreElements()){
					Senha1 =""+enumeration2.nextElement()+"";
					assertEquals("Senha recuperado não corresponde ao inserido:",Senha1,"villeneuve");
				}
				if (enumeration2.hasMoreElements()){
					Endereco1 =""+enumeration2.nextElement()+"";
					assertEquals("Endereco recuperado não corresponde ao inserido:",Endereco1,"Algum lugar em Quebéc");
				}
				if (enumeration2.hasMoreElements()){
					Email1 =""+enumeration2.nextElement()+"";
					assertEquals("Email recuperado não corresponde ao inserido:",Email1,"villeneuve@abc.com.ca");
					assertEquals("O registro contém mais campos que o esperado",enumeration2.hasMoreElements(),false);
				}
				if (enumeration.hasMoreElements()){
					vectorSaida=(Vector)(enumeration.nextElement());
					vectorSaida.trimToSize();
					enumeration2= vectorSaida.elements();
					if (enumeration2.hasMoreElements()){
						IDCliente2 =""+enumeration2.nextElement()+"";
						assertEquals("IDCliente recuperado não corresponde ao inserido:",IDCliente2,"c004");
					}
					if (enumeration2.hasMoreElements()){
						Nome2 =""+enumeration2.nextElement()+"";
						assertEquals("Nome recuperado não corresponde ao inserido:",Nome2,"Lyse Marie Gagnon");
					}
					if (enumeration2.hasMoreElements()){
						Senha2 =""+enumeration2.nextElement()+"";
						assertEquals("Senha recuperado não corresponde ao inserido:",Senha2,"lysemg");
					}
					if (enumeration2.hasMoreElements()){
						Endereco2 =""+enumeration2.nextElement()+"";
						assertEquals("Endereco recuperado não corresponde ao inserido:",Endereco2,"Algum lugar em Quebéc");
					}
					if (enumeration2.hasMoreElements()){
						Email2 =""+enumeration2.nextElement()+"";
						assertEquals("Email recuperado não corresponde ao inserido:",Email2,"lysemg@abc.com.ca");
						assertEquals("O registro contém mais campos que o esperado",enumeration2.hasMoreElements(),false);
					}
				}
				assertEquals("O recuperados mais registros que o esperado",enumeration.hasMoreElements(),false);
			}
			
		}
		catch(Exception ex){
			ex.printStackTrace();
			
		}
		
		//Pesquisa individual de Clientes 
	//	solicitaCliente = controladoraNegocioCliente.pesquisa("c003"); 
		
		IDCliente1 = solicitaCliente.iDUsuario;
		Nome1 = solicitaCliente.nome;
		Senha1 = solicitaCliente.senha;
		Endereco1 = solicitaCliente.endereco;
		Email1 = solicitaCliente.email;
		
					assertEquals("IDCliente recuperado não corresponde ao inserido:",IDCliente1,"c003");
					
					assertEquals("Nome recuperado não corresponde ao inserido:",Nome1,"Jacques Villeneuve");
				
					assertEquals("Senha recuperado não corresponde ao inserido:",Senha1,"villeneuve");
		
					assertEquals("Endereco recuperado não corresponde ao inserido:",Endereco1,"Algum lugar em Quebéc");
				
					assertEquals("Email recuperado não corresponde ao inserido:",Email1,"villeneuve@abc.com.ca");
					
		
		//Pesquisa de cliente que não existe
//		solicitaCliente = controladoraNegocioCliente.pesquisa("c11111");
		
		assertEquals("Não detectou tentativa de pesquisar cliente inexistente:",solicitaCliente,null);
		
		
		//Remover cliente1
//		rsInt = controladoraNegocioCliente.remover("c003");
		assertEquals("Não removeu cliente :",rsInt, Codigo.OK);

		
		//Editar cliente2 mudando a senha para "llmmgg" 
		solicitaCliente2.senha = "llmmgg";
//		rsInt = controladoraNegocioCliente.editar(solicitaCliente2);
		assertEquals("Não conseguiu editar o cliente:",rsInt, Codigo.OK);
		
	}
	
	
}


