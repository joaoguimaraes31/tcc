/*
 * Created on 29/05/2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package Controladoras;

import interfaces.Interface2ControladoraInteracaoProduto;
import interfaces.InterfaceControladoraInteracaoNavegacao;
import interfaces.InterfaceControladoraInteracaoProduto;
import interfaces.InterfaceControladoraNegocioProduto;
import interfaces.Interface2ControladoraInteracaoPedido;

import java.util.Vector;

import javax.swing.JOptionPane;

import telas.TelaProdutoEdRem;
import telas.TelaProdutoInserir;
import telas.TelaProdutoPedir;
import telas.TelaProdutoPesquisa;
import entidades.CodigoToMenssagem;
import entidades.Produto;
import entidades.Codigo;
import entidades.SolicitaProduto;
import entidades.SolicitaAutenticacao;
import entidades.SolicitaPedido;


/**
 * @author yury
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class ControladoraInteracaoProduto implements InterfaceControladoraInteracaoProduto, Interface2ControladoraInteracaoProduto {

	private InterfaceControladoraInteracaoNavegacao interfaceControladoraInteracaoNavegacao;
	private TelaProdutoInserir telaProdutoInserir;
	private TelaProdutoPedir telaProdutoPedir;
	private TelaProdutoEdRem telaProdutoEdRem;
	private TelaProdutoPesquisa telaProdutoPesquisa;
	private SolicitaProduto solicitaProduto;
	private InterfaceControladoraNegocioProduto interfaceControladoraNegocioProduto;
	private Interface2ControladoraInteracaoPedido interface2ControladoraInteracaoPedido;
	
	public void setControladoraNegocio(
			InterfaceControladoraNegocioProduto interfaceControladoraNegocioProduto){
		this.interfaceControladoraNegocioProduto = interfaceControladoraNegocioProduto;
	}
	
	public void setControladoraControladoraInteracaoNavegacao(
			InterfaceControladoraInteracaoNavegacao interfaceControladoraInteracaoNavegacao){
		this.interfaceControladoraInteracaoNavegacao = interfaceControladoraInteracaoNavegacao;
	}
	
	public void setControladoraInteracaoPedido(
			Interface2ControladoraInteracaoPedido interface2ControladoraInteracaoPedido){
		this.interface2ControladoraInteracaoPedido = interface2ControladoraInteracaoPedido;
	}
	
	
	

	// métodos relativos a criação de telas
	
	public void criarTelaMenuAdmOUTelaMenuClientes(){
		
		SolicitaAutenticacao solicitaAutenticacao;
		String IDUsuario;
		
		solicitaAutenticacao = interfaceControladoraInteracaoNavegacao.getRegistro();
		IDUsuario = solicitaAutenticacao.IDUsuario;
		
		if((IDUsuario.charAt(0))=='c'){
			criarTelaMenuClientes();
		}
		else{
			criarTelaMenuAdm();
		}
		
	}
	
	public void criarTelaMenuClientes(){
		
		if (telaProdutoPesquisa!=null){
			telaProdutoPesquisa.dispose();
		}
		interfaceControladoraInteracaoNavegacao.criarTelaMenuClientes();
	}
	
	
	public void criarTelaMenuAdm(){
		if (telaProdutoInserir!=null){
			telaProdutoInserir.dispose();
		}
		if (telaProdutoPesquisa!=null){
			telaProdutoPesquisa.dispose();
		}
		interfaceControladoraInteracaoNavegacao.criarTelaMenuAdm();
	}
	
	public void criarTelaProdutoInserir(){
		telaProdutoInserir = new TelaProdutoInserir(this);			
	}
	
	public void criarTelaProdutoEdRemOUTelaProdutoPedir (String IDProduto){
		
		// Bloco de código para checar se quem chamou o método foi um
		// usuário ou um cliente. Se for um cliente abrirá a tela
		// de pedir produtos. Se for um Administrador abrirá a tela
		// de edição e remoção de produtos
		
		SolicitaAutenticacao solicitaAutenticacao;
		String IDUsuario;
			
		solicitaAutenticacao = interfaceControladoraInteracaoNavegacao.getRegistro();
		IDUsuario = solicitaAutenticacao.IDUsuario;
		
		if((IDUsuario.charAt(0))=='c'){
					
			criarTelaProdutoPedir(IDProduto,IDUsuario);
		}
		else{
			criarTelaProdutoEdRem(IDProduto);
		}
			
	}
	
	public void criarTelaProdutoEdRem (String IDProduto){
	
		solicitaProduto =  new SolicitaProduto();
		try{
		solicitaProduto = interfaceControladoraNegocioProduto.pesquisa(IDProduto); 
		
			if(solicitaProduto!= null){
				if (telaProdutoPesquisa!=null){
					telaProdutoPesquisa.dispose();
				}	
		
				telaProdutoEdRem = new TelaProdutoEdRem(this,solicitaProduto);		
			}else {
				JOptionPane.showMessageDialog(null,"Erro na Busca: PRODUTO NÃO ECONTRADO","Confirmação",JOptionPane.ERROR_MESSAGE);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null,"Erro na Busca: Erro na comunicação com servidor remoto","Confirmação",JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void criarTelaProdutoPedir (String IDProduto, String IDUsuario){
		
			solicitaProduto =  new SolicitaProduto();
			try{
			solicitaProduto = interfaceControladoraNegocioProduto.pesquisa(IDProduto); 
			
				if(solicitaProduto!=null){
					if (telaProdutoPesquisa!=null){
						telaProdutoPesquisa.dispose();
					}
				
					telaProdutoPedir = new TelaProdutoPedir(this,solicitaProduto, IDUsuario);		
				
				}else{
					JOptionPane.showMessageDialog(null,"Erro na Busca: PRODUTO NÃO ECONTRADO","Confirmação",JOptionPane.ERROR_MESSAGE);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null,"Erro na Busca: Erro na comunicação com servidor remoto","Confirmação",JOptionPane.ERROR_MESSAGE);
			}
	}
	
	public void inserirPedido (SolicitaPedido solicitaPedido){
		
		interface2ControladoraInteracaoPedido.inserir(solicitaPedido);
	}
	
	public void criarTelaProdutoPesquisa(){
		if (telaProdutoEdRem != null){
			telaProdutoEdRem.dispose();
		}
		if (telaProdutoPedir != null){
			telaProdutoPedir.dispose();
		}
		Vector listaDeProdutos;
		try{
			listaDeProdutos = interfaceControladoraNegocioProduto.pesquisa(); 
			telaProdutoPesquisa = new TelaProdutoPesquisa(this,listaDeProdutos);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null,"Erro na comunicação com servidor remoto","Confirmação",JOptionPane.ERROR_MESSAGE);
		}
	}
	
	//métodos solicitados pelas telas 
	
	public void inserir(SolicitaProduto solicitaProduto){
		
		int resultado1, resultado2;
		Produto produto = new Produto();
		resultado1 = produto.setProduto(solicitaProduto); 
		if (resultado1 == Codigo.OK){
			try{
				resultado2 = interfaceControladoraNegocioProduto.inserir(solicitaProduto);
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
	
	public void editar(SolicitaProduto solicitaProduto){
		
		int resultado1, resultado2;
		Produto produto =  new Produto();
		resultado1 = produto.setProduto(solicitaProduto); 
		if (resultado1 == Codigo.OK){
			try{
				resultado2 = interfaceControladoraNegocioProduto.editar(solicitaProduto);
				if (resultado2 == Codigo.OK){
					JOptionPane.showMessageDialog(null,"Edição com sucesso","Confirmação",JOptionPane.INFORMATION_MESSAGE);
//					Se não houver erro CRIAR TELAPESQUISACLIENTE();
					criarTelaProdutoPesquisa();
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
	
	public void remover(String IDProduto){
		
		int resultado1;
		try{
			resultado1 = interfaceControladoraNegocioProduto.remover(IDProduto);
			if (resultado1 == Codigo.OK){
				JOptionPane.showMessageDialog(null,"remoção com sucesso","Confirmação",JOptionPane.INFORMATION_MESSAGE);
				//Se não houver erro CRIAR TELAPESQUISAProduto();
				criarTelaProdutoPesquisa();
			}else{
				JOptionPane.showMessageDialog(null,"Erro na remoção"+" "+CodigoToMenssagem.fromCodigoToMenssagem(resultado1)+"","Confirmação",JOptionPane.ERROR_MESSAGE);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null,"Erro na remoção: Erro na comunicação com servidor remoto","Confirmação",JOptionPane.ERROR_MESSAGE);
		}	
	}
	
	public void subtrair(SolicitaPedido solicitaPedido){
		
		int resultado1;
		try{
			resultado1 = interfaceControladoraNegocioProduto.subtrair(solicitaPedido.IDProduto);
			if (resultado1 == Codigo.OK){
			
				inserirPedido(solicitaPedido);
				if (telaProdutoPedir!=telaProdutoPedir){
				telaProdutoPedir.dispose();
				}
				criarTelaProdutoPesquisa();
			
			
			}else{
				JOptionPane.showMessageDialog(null,"Erro na remoção"+" "+CodigoToMenssagem.fromCodigoToMenssagem(resultado1)+"","Confirmação",JOptionPane.ERROR_MESSAGE);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null,"Erro na remoção: Erro na comunicação com servidor remoto","Confirmação",JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void somar(String IDProduto){
	
		int resultado1;
		try{
			resultado1 = interfaceControladoraNegocioProduto.somar(IDProduto);
			if (resultado1 == Codigo.OK){
					
			}else{
				JOptionPane.showMessageDialog(null,"Erro na remoção"+" "+CodigoToMenssagem.fromCodigoToMenssagem(resultado1)+"","Confirmação",JOptionPane.ERROR_MESSAGE);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null,"Erro na remoção: Erro na comunicação com servidor remoto","Confirmação",JOptionPane.ERROR_MESSAGE);
		}
		
	}
	
	public String geraID(){
		
		String ID;
		int aux1, aux2, aux3, aux4, aux5;
		
		aux1=(int)(Math.random()*9);
		aux2=(int)(Math.random()*9);
		aux3=(int)(Math.random()*9);
		aux4=(int)(Math.random()*9);
		aux5=(int)(Math.random()*9);
		
		ID ="d"+aux1+aux2+aux3+aux4+aux5; 
		
		return ID;
	}
		
}
	
	

