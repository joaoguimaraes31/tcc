/*
 * Created on 20/04/2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package telas;

import javax.swing.JOptionPane;

import entidades.SolicitaCliente;

/**
 * @author yury
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class TelaClienteERStub {
	
	
	public void remover(SolicitaCliente SolCli){
		
		JOptionPane.showMessageDialog(null,"Bot�o Remover foi apertado"+"   "+
				"ID:"+SolCli.iDUsuario+"   "+"Nome:"+SolCli.nome+"   "+
				"Senha:"+SolCli.senha+"   "+"\nEndere�o:"+SolCli.endereco+"  "+
				"Email:"+SolCli.email);
		
	}
	public void voltar(){
		
		JOptionPane.showMessageDialog(null,"Bot�o Voltar foi apertado");
		
	}
	public void editar(){
		
		JOptionPane.showMessageDialog(null,"Bot�o Editar foi apertado");
		
	}

	public static void main(String[] args) {
	//	new TelaClienteEdRem().show();
	}
}
