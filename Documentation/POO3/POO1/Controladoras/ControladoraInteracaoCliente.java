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
		 * Passa a referência 
		 * da controladora de negócio.
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
		
		
	
		// métodos relativos a criação de telas
		
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
					JOptionPane.showMessageDialog(null,"Erro na Busca: CLIENTE NÃO ECONTRADO","Confirmação",JOptionPane.ERROR_MESSAGE);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null,"Erro na Busca: Erro na comunicação com servidor remoto","Confirmação",JOptionPane.ERROR_MESSAGE);
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
				JOptionPane.showMessageDialog(null,"Erro na comunicação com servidor remoto","Confirmação",JOptionPane.ERROR_MESSAGE);
			} 
		}
		
		//métodos solicitados pelas telas 
		
		public void inserir(SolicitaCliente solicitaCliente){
			
			int resultado1, resultado2;
			Cliente cliente = new Cliente();
			resultado1 = cliente.setCliente(solicitaCliente); 
			if (resultado1 == Codigo.OK){
				try {
					resultado2 = interfaceControladoraNegocioCliente.inserir(solicitaCliente);
					if (resultado2 == Codigo.OK){
						JOptionPane.showMessageDialog(null,"Cadastramento com sucesso","Confirmação",JOptionPane.INFORMATION_MESSAGE);
						//Se  não houver erro  CRIAR TELA MENU ADM();
						criarTelaMenuAdm();
					}else{
						JOptionPane.showMessageDialog(null,"Erro no cadastramento"+" "+CodigoToMenssagem.fromCodigoToMenssagem(resultado2)+"","Confirmação",JOptionPane.ERROR_MESSAGE);
			
					}
				} catch (Exception e) {
				// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null,"Erro no cadastramento: Erro na comunicação com servidor remoto","Confirmação",JOptionPane.ERROR_MESSAGE);
				}
			}else{
				JOptionPane.showMessageDialog(null,"Erro no cadastramento"+" "+CodigoToMenssagem.fromCodigoToMenssagem(resultado1)+"","Confirmação",JOptionPane.ERROR_MESSAGE);	
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
						JOptionPane.showMessageDialog(null,"Edição com sucesso","Confirmação",JOptionPane.INFORMATION_MESSAGE);
						//Se não houver erro CRIAR TELAPESQUISACLIENTE();
						criarTelaClientePesquisa();
					}else{
						JOptionPane.showMessageDialog(null,"Erro na edição"+" "+CodigoToMenssagem.fromCodigoToMenssagem(resultado2)+"","Confirmação",JOptionPane.ERROR_MESSAGE);
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null,"Erro na edição: Erro na comunicação com servidor remoto","Confirmação",JOptionPane.ERROR_MESSAGE);
				}	
			}else{
				JOptionPane.showMessageDialog(null,"Erro na edição "+" "+CodigoToMenssagem.fromCodigoToMenssagem(resultado1)+"","Confirmação",JOptionPane.ERROR_MESSAGE);
			}
		}
		
		public void remover(String IdUsuario){
			
			int resultado1;
			
			try {
				resultado1 = interfaceControladoraNegocioCliente.remover(IdUsuario);
				if (resultado1 == Codigo.OK){
					JOptionPane.showMessageDialog(null,"remoção com sucesso","Confirmação",JOptionPane.INFORMATION_MESSAGE);
					//Se não houver erro CRIAR TELAPESQUISACLIENTE();
					criarTelaClientePesquisa();
				}else{
					JOptionPane.showMessageDialog(null,"Erro na remoção"+" "+CodigoToMenssagem.fromCodigoToMenssagem(resultado1)+"","Confirmação",JOptionPane.ERROR_MESSAGE);
				}
			}catch (Exception e) {
					// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null,"Erro na remoção: Erro na comunicação com servidor remoto","Confirmação",JOptionPane.ERROR_MESSAGE);
			}		
		}
		
}
