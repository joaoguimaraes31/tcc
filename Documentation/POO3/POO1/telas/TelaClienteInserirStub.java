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
public class TelaClienteInserirStub {
	
	public void editar(SolicitaCliente SolCli){
		
		JOptionPane.showMessageDialog(null,"Botão Inserir foi apertado"+"   "+
				"ID:"+SolCli.iDUsuario+"   "+"Nome:"+SolCli.nome+"   "+
				"Senha:"+SolCli.senha+"   "+"\nEndereço:"+SolCli.endereco+"  "+
				"Email:"+SolCli.email);
		
	}
	public void voltar(){
		
		JOptionPane.showMessageDialog(null,"Botão Voltar foi apertado");
		
	}


	public static void main(String[] args) {
	//	new TelaClienteInserir().show();
	}
}
