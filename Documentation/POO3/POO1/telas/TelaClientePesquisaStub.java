/*
 * Created on 20/04/2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package telas;

import javax.swing.JOptionPane;


/**
 * @author yury
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class TelaClientePesquisaStub {
	
	public void pesquisa2(String IDCliente){
		
		JOptionPane.showMessageDialog(null,"Botão Pesquisar foi apertado"+"   "+
				"ID:"+IDCliente);
		
	}
	
	public void pesquisa(String IDCliente){
		
		JOptionPane.showMessageDialog(null,"Linha clicada na tabela"+"   "+
				"ID:"+IDCliente);
		
	}
	public void voltar(){
		
		JOptionPane.showMessageDialog(null,"Botão Voltar foi apertado");
		
	}


	public static void main(String[] args) {
	//	new TelaClientePesquisa().show();
	}
}
