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
		
		JOptionPane.showMessageDialog(null,"Bot�o Inserir foi apertado"+"   "+
				"ID:"+SolPro.iDProduto+"   "+"Descri��o Textual:"+SolPro.descricaoTextual+"   "+
				"Tipo:"+SolPro.tipo+"   "+"\nPre�o:"+SolPro.preco+"  "+
				"Quantidade:"+SolPro.quantidade);
		
	}
	public void voltar(){
		
		JOptionPane.showMessageDialog(null,"Bot�o Voltar foi apertado");
		
	}

	public static void main(String[] args) {
	//	new TelaProdutoInserir().show();
	}
}
