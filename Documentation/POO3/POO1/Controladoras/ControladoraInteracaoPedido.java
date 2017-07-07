/*
 * Created on 16/05/2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */


/**
 * @author yury
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */

	package Controladoras;

	import entidades.*;
	import telas.*;
	import java.util.Vector;
	import interfaces.*;

	import javax.swing.JOptionPane;
	
	public class ControladoraInteracaoPedido implements Interface2ControladoraInteracaoPedido, InterfaceControladoraInteracaoPedido  {	
		
		private InterfaceControladoraInteracaoNavegacao interfaceControladoraInteracaoNavegacao;
		private TelaPedidoCancelar telaPedidoCancelar; 
		private TelaPedidoCliente telaPedidoCliente;
		private TelaPedidoProcessamento telaPedidoProcessamento;
		private TelaPedidoProcessamento2 telaPedidoProcessamento2;
		private SolicitaPedido solicitaPedido;
		private InterfaceControladoraNegocioPedido interfaceControladoraNegocioPedido;
		private Interface2ControladoraInteracaoProduto interface2ControladoraInteracaoProduto;
		
		/**
		 * Passa a refer�ncia 
		 * da controladora de neg�cio.
		 * @param controladoraPedido
		 */
		public void setControladoraNegocio(
				InterfaceControladoraNegocioPedido interfaceControladoraNegocioPedido){
			this.interfaceControladoraNegocioPedido = interfaceControladoraNegocioPedido;
		}
		
		public void setControladoraControladoraInteracaoNavegacao(
				InterfaceControladoraInteracaoNavegacao interfaceControladoraInteracaoNavegacao){
			this.interfaceControladoraInteracaoNavegacao = interfaceControladoraInteracaoNavegacao;
		}
		
		public void setControladoraInteracaoProduto(
				Interface2ControladoraInteracaoProduto interface2ControladoraInteracaoProduto){
			this.interface2ControladoraInteracaoProduto = interface2ControladoraInteracaoProduto;
		}
	
		// m�todos relativos a cria��o de telas
		
		public void criarTelaMenuAdm(){
			if (telaPedidoProcessamento!=null){
				telaPedidoProcessamento.dispose();
			}
	
			interfaceControladoraInteracaoNavegacao.criarTelaMenuAdm();
		}
		
		public void criarTelaMenuClientes(){
			if (telaPedidoCliente!=null){
				telaPedidoCliente.dispose();
			}
	
			interfaceControladoraInteracaoNavegacao.criarTelaMenuClientes();
		}
		
		public void criarTelaPedidoCancelar (String IDPedido){
			
			if (telaPedidoCliente!=null){
				telaPedidoCliente.dispose();
			}
			solicitaPedido =  new SolicitaPedido();
			try{
			solicitaPedido = interfaceControladoraNegocioPedido.pesquisa(IDPedido);
			
				if(solicitaPedido!=null){
				
					if (telaPedidoCliente!=null){
						telaPedidoCliente.dispose();
					}
					telaPedidoCancelar = new TelaPedidoCancelar(this,solicitaPedido);		
				}else{
					JOptionPane.showMessageDialog(null,"Erro na Busca: PEDIDO N�O ECONTRADO","Confirma��o",JOptionPane.ERROR_MESSAGE);
				}
			}catch (Exception e) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null,"Erro na Busca: Erro na comunica��o com servidor remoto","Confirma��o",JOptionPane.ERROR_MESSAGE);
			}
		}
		
		public void criarTelaPedidoProcessamento2 (String IDPedido){
			
			solicitaPedido =  new SolicitaPedido();
			try{
			solicitaPedido = interfaceControladoraNegocioPedido.pesquisa(IDPedido);
				if(solicitaPedido!= null){
					if (telaPedidoProcessamento!=null){
						telaPedidoProcessamento.dispose();
					}	
					telaPedidoProcessamento2 = new TelaPedidoProcessamento2(this,solicitaPedido);		
				}else {
					JOptionPane.showMessageDialog(null,"Erro na Busca: PEDIDO N�O ECONTRADO","Confirma��o",JOptionPane.ERROR_MESSAGE);
				}
			} catch (Exception e) {
			// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null,"Erro na Busca: Erro na comunica��o com servidor remoto","Confirma��o",JOptionPane.ERROR_MESSAGE);
			}
		}
		
		public void criarTelaPedidoProcessamento(){
			if (telaPedidoProcessamento2 != null){
				telaPedidoProcessamento2.dispose();
			}
			Vector listaDePedidos;
			try{
			listaDePedidos = interfaceControladoraNegocioPedido.pesquisa(); 
			telaPedidoProcessamento = new TelaPedidoProcessamento(this,listaDePedidos);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null,"Erro na comunica��o com servidor remoto","Confirma��o",JOptionPane.ERROR_MESSAGE);
			}
		}
		
		public void criarTelaPedidoCliente(){
			String IDCliente;
			SolicitaAutenticacao  solicitaAutenticacao; 
			
			if (telaPedidoCancelar != null){
				telaPedidoCancelar.dispose();
			}
			Vector listaDePedidos;
			
			// pega registro inicial com o subssistema de navega��o
			solicitaAutenticacao = interfaceControladoraInteracaoNavegacao.getRegistro();
			
			IDCliente = solicitaAutenticacao.IDUsuario;  
			
			try{
			listaDePedidos = interfaceControladoraNegocioPedido.pesquisaCliente(IDCliente); 
			telaPedidoCliente = new TelaPedidoCliente(this,listaDePedidos);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null,"Erro na comunica��o com servidor remoto","Confirma��o",JOptionPane.ERROR_MESSAGE);
			}
		}
		
		//m�todos solicitados pelas telas ou pela subssitema Produto 
		
		public void inserir(SolicitaPedido solicitaPedido){
			
			int resultado1, resultado2;
			Pedido pedido = new Pedido();
			resultado1 = pedido.setPedido(solicitaPedido); 
			if (resultado1 == Codigo.OK){
				try{
					resultado2 = interfaceControladoraNegocioPedido.inserir(solicitaPedido);
					if (resultado2 == Codigo.OK){
					JOptionPane.showMessageDialog(null,"Cadastramento com sucesso","Confirma��o",JOptionPane.INFORMATION_MESSAGE);
	
					}else{
						JOptionPane.showMessageDialog(null,"Erro no cadastramento"+" "+resultado2+"","Confirma��o",JOptionPane.ERROR_MESSAGE);
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null,"Erro no cadastramento: Erro na comunica��o com servidor remoto","Confirma��o",JOptionPane.ERROR_MESSAGE);
				}
			}else{
				JOptionPane.showMessageDialog(null,"Erro no cadastramento"+" "+resultado1+"","Confirma��o",JOptionPane.ERROR_MESSAGE);
			}
			
		}
		
		public void processar(String IDPedido){
			
			int  resultado2;
				try{
					resultado2 = interfaceControladoraNegocioPedido.processar(IDPedido);
					if (resultado2 == Codigo.OK){
						JOptionPane.showMessageDialog(null,"Processamento com sucesso","Confirma��o",JOptionPane.INFORMATION_MESSAGE);
//						Se n�o houver erro criarTelaPedidoProcessamento();
						criarTelaPedidoProcessamento();
					}else{
						JOptionPane.showMessageDialog(null,"Erro no processamento"+" "+CodigoToMenssagem.fromCodigoToMenssagem(resultado2)+"","Confirma��o",JOptionPane.ERROR_MESSAGE);
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null,"Erro no processamento: Erro na comunica��o com servidor remoto","Confirma��o",JOptionPane.ERROR_MESSAGE);
				}
		}
		
		public void remover(String IDPedido, String IDProduto){
			
			int resultado1;
				try{
					resultado1 = interfaceControladoraNegocioPedido.remover(IDPedido);
					if (resultado1 == Codigo.OK){
						interface2ControladoraInteracaoProduto.somar(IDProduto);
						JOptionPane.showMessageDialog(null,"remo��o com sucesso","Confirma��o",JOptionPane.INFORMATION_MESSAGE);
						//Se n�o houver erro CRIAR TelaPedidoCliente();
						criarTelaPedidoCliente();
					}else{
						JOptionPane.showMessageDialog(null,"Erro na remo��o"+" "+resultado1+"","Confirma��o",JOptionPane.ERROR_MESSAGE);
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null,"Erro na remo��o: Erro na comunica��o com servidor remoto","Confirma��o",JOptionPane.ERROR_MESSAGE);
				}
		}
		
	}

