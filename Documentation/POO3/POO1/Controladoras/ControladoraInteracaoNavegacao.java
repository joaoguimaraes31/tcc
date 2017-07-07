/*
 * Created on 25/05/2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package Controladoras;

import telas.*;
import entidades.*;
import builders.*;
import interfaces.*;

/**
 * @author yury
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class ControladoraInteracaoNavegacao implements InterfaceControladoraInteracaoNavegacao {

	TelaMenuAdm telaMenuAdm;
	TelaMenuClientes telaMenuClientes;
	boolean flag = true;
	
	//retém os dados do usuário que deu login no sistema
	SolicitaAutenticacao registro;
	
	// interfaces necessarias  
	InterfaceControladoraInteracaoCliente interfaceControladoraInteracaoCliente;
	InterfaceControladoraInteracaoAutenticacao interfaceControladoraInteracaoAutenticacao;
	InterfaceControladoraInteracaoProduto interfaceControladoraInteracaoProduto;
	InterfaceControladoraInteracaoPedido interfaceControladoraInteracaoPedido;
	
	// builders que criam cada subssistema
	BuilderCliente builderCliente;
	BuilderAutenticacao builderAutenticacao;
	BuilderProduto builderProduto;
	BuilderPedido builderPedido;
	
	public ControladoraInteracaoNavegacao(){
		
		// cria todos os subssitemas interligados entre si
		builderCliente = new BuilderCliente();
		builderCliente.criarSubssistemaCliente(this);
		interfaceControladoraInteracaoCliente = builderCliente.getControladoraInteracaoCliente();
			
			
		builderAutenticacao =  new BuilderAutenticacao();
		builderAutenticacao.criarSubssistemaAutenticacao(this);
		interfaceControladoraInteracaoAutenticacao = builderAutenticacao.getControladoraInteracaoAutenticacao();
		
		builderPedido = new BuilderPedido();
		builderPedido.criarSubssistemaPedido(this);
		interfaceControladoraInteracaoPedido = builderPedido.getControladoraInteracaoPedido();
		
		
		builderProduto = new BuilderProduto();
		builderProduto.criarSubssistemaProduto(this);
		interfaceControladoraInteracaoProduto = builderProduto.getControladoraInteracaoProduto();
		
		builderPedido.setControladoraInteracaoProduto(builderProduto.getControladoraInteracaoProduto());
		builderProduto.setControladoraInteracaoPedido(builderPedido.getControladoraInteracaoPedido());
		
		// chama a tela de autenticação para que o sistema se inicie
		interfaceControladoraInteracaoAutenticacao.criarTelaAutenticacao();
//		
		
	}
	
//	 setar registro inicial 
	public void setRegistro(SolicitaAutenticacao registro){
		this.registro = registro;
	}
	
	public SolicitaAutenticacao getRegistro (){
		
		return this.registro;
	}

	// criar tela de menu do cliente
	// (Cliente)
	public void criarTelaMenuAdm(){
		telaMenuAdm = new  TelaMenuAdm(this);
		//System.out.println("deu certo!");
	}
	// criar tela de menu do administrador
	//(Adm)
/*	public void criarTelaMenuClientes(){
		telaMenuClientes =  new TelaMenuClientes(this,registro);
		System.out.println("deu certo!!!");
	}*/
	// cria tela de pesquisa de clientes
	//(Adm) 
	public void criarTelaClientePesquisa(){
		if (telaMenuAdm!=null){
			telaMenuAdm.dispose();
		}
		System.out.println("deu certo 2!!!");
		interfaceControladoraInteracaoCliente.criarTelaClientePesquisa();
		
	}
	// cria tela de inserção de clientes
	//(Adm) 
	public void criarTelaClienteInserir(){
		if (telaMenuAdm!=null){
			telaMenuAdm.dispose();
		}
		interfaceControladoraInteracaoCliente.criarTelaClienteInserir();
		
	}
	//cria tela de pesquisa de produtos tanto pode ser para
	//(Adm) (Cliente)
	public void criarTelaProdutoPesquisa(){
	
		if (telaMenuAdm!= null){
		telaMenuAdm.dispose();

		}
		if (telaMenuClientes!=null){
			telaMenuClientes.dispose();
		}
		
		interfaceControladoraInteracaoProduto.criarTelaProdutoPesquisa(); 
		
	}
	// cria tela de inserção de produtos (Adm)
	public void criarTelaProdutoInserir(){
		if (telaMenuAdm!=null){
			telaMenuAdm.dispose();
		}
		interfaceControladoraInteracaoProduto.criarTelaProdutoInserir();
	}
	
	// cria tela de processamento de pedidos
	// (Adm) 
	public void criarTelaPedidoProcessamento(){
		if (telaMenuAdm!=null){
			telaMenuAdm.dispose();
		}
		interfaceControladoraInteracaoPedido.criarTelaPedidoProcessamento();
	}
	
	//cria tela de pedidos do cliente
	// (Cliente)
	public void criarTelaPedidoCliente(){
		if (telaMenuClientes!=null){
			telaMenuClientes.dispose();
		}
		interfaceControladoraInteracaoPedido.criarTelaPedidoCliente();
	}
	//cria tela de autenticação (xxx)
	public void criarTelaAutenticar(){
		if (telaMenuAdm!= null){
			telaMenuAdm.dispose();
		}
		if (telaMenuClientes!=null){
			telaMenuClientes.dispose();
		}
		
		interfaceControladoraInteracaoAutenticacao.criarTelaAutenticacao();
	}
		
	
}
