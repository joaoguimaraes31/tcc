/*
 * Created on 20/04/2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package telas;
import entidades.*;
import javax.swing.*;


/**
 * @author yury
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class TelaAutenticarStub {
	
	public void autenticar(SolicitaAutenticacao SolAut){
		
		JOptionPane.showMessageDialog(null,"Botão Autenticar foi apertado"+"   "+"ID:"+SolAut.IDUsuario+"   "+"Senha:"+SolAut.Senha);
		
	}
	public void voltar(){
		
		JOptionPane.showMessageDialog(null,"Botão Cancelar foi apertado");
		
	}
	
	public static void main(String[] args) {
	//	 new TelaAutenticar().show();
		
	}
}
