/*
 * Created on 26/05/2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package Controladoras;

import interfaces.InterfaceControladoraInteracaoNavegacao;
import javax.swing.JOptionPane;

import telas.*;
import entidades.*;
import interfaces.*;

/**
 * @author yury
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class ControladoraInteracaoAutenticacao implements InterfaceControladoraInteracaoAutenticacao{

	
	private InterfaceControladoraInteracaoNavegacao interfaceControladoraInteracaoNavegacao;
	private TelaAutenticar telaAutenticar;
	private SolicitaAutenticacao solicitaAutenticacao;
	private Autenticacao autenticacao;
	private InterfaceControladoraNegocioAutenticacao interfaceControladoraNegocioAutenticacao;
	
	/**
	 * Passa a referência 
	 * da controladora de negócio.
	 * @param controladoraCliente
	 */
	public void setControladoraNegocio(
			InterfaceControladoraNegocioAutenticacao interfaceControladoraNegocioAutenticacao){
		this.interfaceControladoraNegocioAutenticacao =interfaceControladoraNegocioAutenticacao ;
	}
	
	public void setControladoraControladoraInteracaoNavegacao(
			InterfaceControladoraInteracaoNavegacao interfaceControladoraInteracaoNavegacao){
		this.interfaceControladoraInteracaoNavegacao = interfaceControladoraInteracaoNavegacao;
	}
	
	// métodos relativos a criação de telas
	
	public void criarTelaAutenticacao(){
		telaAutenticar = new TelaAutenticar(this);			
	}
	
	//método solicitado pela tela de autenticação para 
	// autenticar dados de entrada do usuário 
	
	public void autenticar(SolicitaAutenticacao solicitaAutenticacao){
		
		int resultado1, resultado2;
		autenticacao = new Autenticacao();
		resultado1 = autenticacao.setAutenticacao(solicitaAutenticacao);
		
			if (resultado1 == Codigo.OK){
				try {
					resultado2 = interfaceControladoraNegocioAutenticacao.autenticar(solicitaAutenticacao);
					if (resultado2 == Codigo.OK){
					JOptionPane.showMessageDialog(null,"Autenticação com sucesso","Confirmação",JOptionPane.INFORMATION_MESSAGE);
					// fecha tela de autenticação e retorna o regitro 
					// de entrada do usuário, com id e senha
					if (telaAutenticar!=null){
						telaAutenticar.dispose();
					}
					// mmétodo que retorna para a controladora de 
					// navegação o  registro inicial
					interfaceControladoraInteracaoNavegacao.setRegistro(solicitaAutenticacao);
					
					// decide qual tela chamar se a de clinentes 
					//ou a de administradores
					String cOUa;
					cOUa = solicitaAutenticacao.IDUsuario;
					if((cOUa.charAt(0))=='c'){
						interfaceControladoraInteracaoNavegacao.criarTelaMenuClientes();
					}
					else{
						interfaceControladoraInteracaoNavegacao.criarTelaMenuAdm();
					}
					
					
				}else{
					JOptionPane.showMessageDialog(null,"Erro na Autenticação"+" "+CodigoToMenssagem.fromCodigoToMenssagem(resultado2)+"","Confirmação",JOptionPane.ERROR_MESSAGE);
					//continua com a tela de autenticação aberta
				}
				
				} catch (Exception e) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null,"Erro na Autenticação: Erro na comunicação com servidor remoto","Confirmação",JOptionPane.ERROR_MESSAGE);
				}	
			}else{
				JOptionPane.showMessageDialog(null,"Erro na Autenticação"+" "+CodigoToMenssagem.fromCodigoToMenssagem(resultado1)+"","Confirmação",JOptionPane.ERROR_MESSAGE);
				//continua com a tela de autenticação aberta
			}
			
	}

}
