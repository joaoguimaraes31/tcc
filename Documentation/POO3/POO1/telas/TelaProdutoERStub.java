/*
 * Created on 20/04/2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package telas;

import javax.swing.JOptionPane;

import entidades.SolicitaProduto;

/**
 * @author yury
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class TelaProdutoERStub {
	
	
	public void remover(SolicitaProduto SolPro){
		
		JOptionPane.showMessageDialog(null,"Botão Remover foi apertado"+"   "+
				"ID:"+SolPro.iDProduto+"   "+"Descrição Textual:"+SolPro.descricaoTextual+"   "+
				"Senha:"+SolPro.tipo+"   "+"\nEndereço:"+SolPro.preco+"  "+
				"Email:"+SolPro.quantidade);
		
	}
	public void voltar(){
		
		JOptionPane.showMessageDialog(null,"Botão Voltar foi apertado");
		
	}
	public void editar(){
		
		JOptionPane.showMessageDialog(null,"Botão Editar foi apertado");
		
	}

	public static void main(String[] args) {
	//	new TelaProdutoEdRem().show();
	}
}
