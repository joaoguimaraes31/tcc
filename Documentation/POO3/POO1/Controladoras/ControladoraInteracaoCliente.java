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
	
	public class ControladoraInteracaoCliente implements InterfaceControladoraInteracaoCliente  {	
		
		private InterfaceControladoraInteracaoNavegacao interfaceControladoraInteracaoNavegacao;
		private TelaClienteInserir telaClienteInserir;
		private TelaClienteEdRem telaClienteEdRem;
		private TelaClientePesquisa telaClientePesquisa;
		private SolicitaCliente solicitaCliente;
		private InterfaceControladoraNegocioCliente interfaceControladoraNegocioCliente;
		
		/**
		 * Passa a refer�ncia 
		 * da controladora de neg�cio.
		 * @param controladoraCliente
		 */
		public void setControladoraNegocio(
				InterfaceControladoraNegocioCliente interfaceControladoraNegocioCliente){
			this.interfaceControladoraNegocioCliente = interfaceControladoraNegocioCliente;
		}
		
		public void setControladoraControladoraInteracaoNavegacao(
				InterfaceControladoraInteracaoNavegacao interfaceControladoraInteracaoNavegacao){
			this.interfaceControladoraInteracaoNavegacao = interfaceControladoraInteracaoNavegacao;
		}
		
		
	
		// m�todos relativos a cria��o de telas
		
		public void criarTelaMenuAdm(){
			if (telaClienteInserir!=null){
				telaClienteInserir.dispose();
			}
			if (telaClientePesquisa!=null){
				telaClientePesquisa.dispose();
			}
			interfaceControladoraInteracaoNavegacao.criarTelaMenuAdm();
		}
		
		public void criarTelaClienteInserir(){
			telaClienteInserir = new TelaClienteInserir(this);			
		}
		
		public void criarTelaClienteEdRem (String IdUsuario){
			
			solicitaCliente =  new SolicitaCliente();
			try {
				solicitaCliente = interfaceControladoraNegocioCliente.pesquisa(IdUsuario);
			
				if(solicitaCliente!= null){
					if (telaClientePesquisa!=null){
						telaClientePesquisa.dispose();
					}	
					telaClienteEdRem = new TelaClienteEdRem(this,solicitaCliente);
				}else {
					JOptionPane.showMessageDialog(null,"Erro na Busca: CLIENTE N�O ECONTRADO","Confirma��o",JOptionPane.ERROR_MESSAGE);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null,"Erro na Busca: Erro na comunica��o com servidor remoto","Confirma��o",JOptionPane.ERROR_MESSAGE);
			}
		}
		
		public void criarTelaClientePesquisa(){
			if (telaClienteEdRem != null){
				telaClienteEdRem.dispose();
			}
			Vector listaDeClientes;
			try {
				listaDeClientes = interfaceControladoraNegocioCliente.pesquisa();
				telaClientePesquisa = new TelaClientePesquisa(this,listaDeClientes);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null,"Erro na comunica��o com servidor remoto","Confirma��o",JOptionPane.ERROR_MESSAGE);
			} 
		}
		
		//m�todos solicitados pelas telas 
		
		public void inserir(SolicitaCliente solicitaCliente){
			
			int resultado1, resultado2;
			Cliente cliente = new Cliente();
			resultado1 = cliente.setCliente(solicitaCliente); 
			if (resultado1 == Codigo.OK){
				try {
					resultado2 = interfaceControladoraNegocioCliente.inserir(solicitaCliente);
					if (resultado2 == Codigo.OK){
						JOptionPane.showMessageDialog(null,"Cadastramento com sucesso","Confirma��o",JOptionPane.INFORMATION_MESSAGE);
						//Se  n�o houver erro  CRIAR TELA MENU ADM();
						criarTelaMenuAdm();
					}else{
						JOptionPane.showMessageDialog(null,"Erro no cadastramento"+" "+CodigoToMenssagem.fromCodigoToMenssagem(resultado2)+"","Confirma��o",JOptionPane.ERROR_MESSAGE);
			
					}
				} catch (Exception e) {
				// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null,"Erro no cadastramento: Erro na comunica��o com servidor remoto","Confirma��o",JOptionPane.ERROR_MESSAGE);
				}
			}else{
				JOptionPane.showMessageDialog(null,"Erro no cadastramento"+" "+CodigoToMenssagem.fromCodigoToMenssagem(resultado1)+"","Confirma��o",JOptionPane.ERROR_MESSAGE);	
			}
		}
			
		public void editar(SolicitaCliente solicitaCliente){
			
			int resultado1, resultado2;
			Cliente cliente =  new Cliente();
			resultado1 = cliente.setCliente(solicitaCliente); 
			if (resultado1 == Codigo.OK){
				try {
					resultado2 = interfaceControladoraNegocioCliente.editar(solicitaCliente);
					if (resultado2 == Codigo.OK){
						JOptionPane.showMessageDialog(null,"Edi��o com sucesso","Confirma��o",JOptionPane.INFORMATION_MESSAGE);
						//Se n�o houver erro CRIAR TELAPESQUISACLIENTE();
						criarTelaClientePesquisa();
					}else{
						JOptionPane.showMessageDialog(null,"Erro na edi��o"+" "+CodigoToMenssagem.fromCodigoToMenssagem(resultado2)+"","Confirma��o",JOptionPane.ERROR_MESSAGE);
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null,"Erro na edi��o: Erro na comunica��o com servidor remoto","Confirma��o",JOptionPane.ERROR_MESSAGE);
				}	
			}else{
				JOptionPane.showMessageDialog(null,"Erro na edi��o "+" "+CodigoToMenssagem.fromCodigoToMenssagem(resultado1)+"","Confirma��o",JOptionPane.ERROR_MESSAGE);
			}
		}
		
		public void remover(String IdUsuario){
			
			int resultado1;
			
			try {
				resultado1 = interfaceControladoraNegocioCliente.remover(IdUsuario);
				if (resultado1 == Codigo.OK){
					JOptionPane.showMessageDialog(null,"remo��o com sucesso","Confirma��o",JOptionPane.INFORMATION_MESSAGE);
					//Se n�o houver erro CRIAR TELAPESQUISACLIENTE();
					criarTelaClientePesquisa();
				}else{
					JOptionPane.showMessageDialog(null,"Erro na remo��o"+" "+CodigoToMenssagem.fromCodigoToMenssagem(resultado1)+"","Confirma��o",JOptionPane.ERROR_MESSAGE);
				}
			}catch (Exception e) {
					// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null,"Erro na remo��o: Erro na comunica��o com servidor remoto","Confirma��o",JOptionPane.ERROR_MESSAGE);
			}		
		}
		
}
