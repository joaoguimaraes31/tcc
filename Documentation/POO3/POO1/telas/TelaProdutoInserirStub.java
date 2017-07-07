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
public class TelaProdutoInserirStub {
	
	
	public void editar(SolicitaProduto SolPro){
		
		JOptionPane.showMessageDialog(null,"Botão Inserir foi apertado"+"   "+
				"ID:"+SolPro.iDProduto+"   "+"Descrição Textual:"+SolPro.descricaoTextual+"   "+
				"Tipo:"+SolPro.tipo+"   "+"\nPreço:"+SolPro.preco+"  "+
				"Quantidade:"+SolPro.quantidade);
		
	}
	public void voltar(){
		
		JOptionPane.showMessageDialog(null,"Botão Voltar foi apertado");
		
	}

	public static void main(String[] args) {
	//	new TelaProdutoInserir().show();
	}
}
