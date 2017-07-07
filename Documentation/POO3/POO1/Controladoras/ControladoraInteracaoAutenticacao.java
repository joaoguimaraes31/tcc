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
	 * Passa a refer�ncia 
	 * da controladora de neg�cio.
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
	
	// m�todos relativos a cria��o de telas
	
	public void criarTelaAutenticacao(){
		telaAutenticar = new TelaAutenticar(this);			
	}
	
	//m�todo solicitado pela tela de autentica��o para 
	// autenticar dados de entrada do usu�rio 
	
	public void autenticar(SolicitaAutenticacao solicitaAutenticacao){
		
		int resultado1, resultado2;
		autenticacao = new Autenticacao();
		resultado1 = autenticacao.setAutenticacao(solicitaAutenticacao);
		
			if (resultado1 == Codigo.OK){
				try {
					resultado2 = interfaceControladoraNegocioAutenticacao.autenticar(solicitaAutenticacao);
					if (resultado2 == Codigo.OK){
					JOptionPane.showMessageDialog(null,"Autentica��o com sucesso","Confirma��o",JOptionPane.INFORMATION_MESSAGE);
					// fecha tela de autentica��o e retorna o regitro 
					// de entrada do usu�rio, com id e senha
					if (telaAutenticar!=null){
						telaAutenticar.dispose();
					}
					// mm�todo que retorna para a controladora de 
					// navega��o o  registro inicial
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
					JOptionPane.showMessageDialog(null,"Erro na Autentica��o"+" "+CodigoToMenssagem.fromCodigoToMenssagem(resultado2)+"","Confirma��o",JOptionPane.ERROR_MESSAGE);
					//continua com a tela de autentica��o aberta
				}
				
				} catch (Exception e) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null,"Erro na Autentica��o: Erro na comunica��o com servidor remoto","Confirma��o",JOptionPane.ERROR_MESSAGE);
				}	
			}else{
				JOptionPane.showMessageDialog(null,"Erro na Autentica��o"+" "+CodigoToMenssagem.fromCodigoToMenssagem(resultado1)+"","Confirma��o",JOptionPane.ERROR_MESSAGE);
				//continua com a tela de autentica��o aberta
			}
			
	}

}
