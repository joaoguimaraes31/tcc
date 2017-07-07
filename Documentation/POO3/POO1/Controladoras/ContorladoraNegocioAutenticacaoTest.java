/*
 * Created on 08/06/2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package Controladoras;

import java.rmi.RemoteException;

import builders.BuilderAutenticacaoQuestao3;
import Comandos.ComandoSQLInserirCliente;
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
public class ContorladoraNegocioAutenticacaoTest extends TestCase {

	protected SolicitaCliente solicitaCliente1;
	protected SolicitaAutenticacao solicitaAutenticacao, solicitaAutenticacao2;
	protected BuilderAutenticacaoQuestao3 builderAutenticacaoQuestao3;
	protected ComandoSQLRemoverClienteAll comandoSQLRemoverClienteAll;
	protected ContorladoraNegocioAutenticacao controladoraNegocioAutenticacao;
	protected ControladoraPersistencia controladoraPersistencia;
	protected ComandoSQLInserirCliente comandoSQLInserirCliente;
	/*
	 * @see TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		
		builderAutenticacaoQuestao3 = new BuilderAutenticacaoQuestao3();
		builderAutenticacaoQuestao3.criarSubssistemaAutenticacaoQuestao3("jdbc:odbc:fredericoteste");
		
		this.controladoraNegocioAutenticacao =  builderAutenticacaoQuestao3.getControladoraNegocioAutenticacao();
		this.controladoraPersistencia = builderAutenticacaoQuestao3.getControladoraPersistencia();
		
		solicitaAutenticacao = new SolicitaAutenticacao(); 
		solicitaAutenticacao.IDUsuario = "c003";
		solicitaAutenticacao.Senha = "villeneuve";
		
		solicitaAutenticacao2 = new SolicitaAutenticacao(); 
		solicitaAutenticacao2.IDUsuario = "c005";
		solicitaAutenticacao2.Senha = "Jvilleneuve";
		
		solicitaCliente1 = new SolicitaCliente();
		solicitaCliente1.iDUsuario = "c003" ; 
		solicitaCliente1.nome = "Jacques Villeneuve";
		solicitaCliente1.senha = "villeneuve";
		solicitaCliente1.endereco = "Algum lugar em Quebéc";
		solicitaCliente1.email = "villeneuve@abc.com.ca";
		
	}

	/*
	 * @see TestCase#tearDown()
	 */
	protected void tearDown() throws Exception {
		controladoraPersistencia.shutDown();
		solicitaCliente1 = null;
		

		controladoraPersistencia = null;
		controladoraNegocioAutenticacao = null;
		
	}

	public final void testeComandosAutenticacao() {
		String query,IDCliente1, Nome1, Senha1,Endereco1,Email1;
		String IDCliente2, Nome2, Senha2,Endereco2,Email2;
		
		boolean flag;
		int rsInt;
		
		
		// Comando auxiliar faz um DELETE na Tabela Clientes do Banco de dados 
		// fredericoteste Apenas para auxiliar no início dos testes
		comandoSQLRemoverClienteAll = new  ComandoSQLRemoverClienteAll();
		rsInt = controladoraPersistencia.executeUpdate(comandoSQLRemoverClienteAll);
		
		// Comando auxiliar insere um Cliente na tabela de Clientes
		comandoSQLInserirCliente = new ComandoSQLInserirCliente(solicitaCliente1);
		rsInt = controladoraPersistencia.executeUpdate(comandoSQLInserirCliente);
		
		
		// Agora já se tem uma massa de testes para podermos trabalhar
		// os comandos da controladora de negócios Autenticacao
		
		try {
			// Simula a autenticação do cliente já inserido 
			rsInt = controladoraNegocioAutenticacao.autenticar(solicitaAutenticacao);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals("Não conseguiu autenticar o cliente:",rsInt, Codigo.OK);
		
		try {
			//		 Simula a autenticação do cliente não existente 
			rsInt = controladoraNegocioAutenticacao.autenticar(solicitaAutenticacao2);
		} catch (RemoteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		assertEquals("Não conseguiu detectar autenticação errônea do cliente:",rsInt, Codigo.DADOS_DE_AUTENTICACAO_INVALIDOS);
		
	
	}
}	
		
		


