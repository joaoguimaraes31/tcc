/*
 * Created on 19/04/2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package telas;
import Controladoras.*;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import entidades.SolicitaAutenticacao;
/**
 * @author yury
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class TelaAutenticar extends Janela {
	
	private ControladoraInteracaoAutenticacao controladoraInteracaoAutenticacao;
	private JPanel Entrada,Botoes;
	private JTextField T1;
	private JPasswordField F1;
	private JButton B1;
	private JLabel L1, L2;
	
	public TelaAutenticar(ControladoraInteracaoAutenticacao controladoraInteracaoAutenticacao) {
		super("TelaAutenticar",new Dimension(270,130));
		this.controladoraInteracaoAutenticacao = controladoraInteracaoAutenticacao;
		Entrada = new JPanel();
		Botoes = new JPanel();
		
		Entrada.setLayout(new GridLayout(2,2,20,8));
		Botoes.setLayout(new GridLayout(1,2,20,8));
		
		T1 = new JTextField(10);
		F1 = new JPasswordField(10);
		B1 = new JButton("Autenticar");
		B1.addActionListener(new TratarB1());
		L1 = new JLabel ("ID");
		L2 = new JLabel ("Senha");
		
		Entrada.add(L1);
		Entrada.add(T1);
		Entrada.add(L2);
		Entrada.add(F1);
		Botoes.add(B1);
		
		getContentPane().add(Entrada,BorderLayout.NORTH);
		getContentPane().add(Botoes,BorderLayout.SOUTH);
		
		show();
	}
	
	private class TratarB1 
	implements ActionListener {
		public void actionPerformed(ActionEvent e){				
			SolicitaAutenticacao SolAut = new SolicitaAutenticacao();				
			SolAut.IDUsuario = T1.getText();
			SolAut.Senha = F1.getText();
			controladoraInteracaoAutenticacao.autenticar(SolAut);				
		}
		 
	}

}
	
