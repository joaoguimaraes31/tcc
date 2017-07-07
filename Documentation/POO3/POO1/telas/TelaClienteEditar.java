package telas;
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

import entidades.SolicitaCliente;

/**
 * @author yury
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class TelaClienteEditar extends Janela {
	private TelaClienteEditarStub TelCliEdStub;
	private JPanel Entrada,Botoes;
	private JTextField T1,T2,T4,T5;
	private JPasswordField P3;
	private JButton B1,B2;
	private JLabel L1, L2, L3, L4, L5;
	
	public TelaClienteEditar() {
		super("Dados do Cliente",new Dimension(320,220));
		Entrada = new JPanel();
		Botoes = new JPanel();
		TelCliEdStub = new TelaClienteEditarStub();
		Entrada.setLayout(new GridLayout(5,2,20,8));
		Botoes.setLayout(new GridLayout(1,2,20,8));
		
		T1 = new JTextField(10);
		T2 = new JTextField(10);
		P3 = new JPasswordField(10);
		T4 = new JTextField(10);
		T5 = new JTextField(10);
		B1 = new JButton("Editar");
		B1.addActionListener(new TratarB1());
		B2 = new JButton("Voltar");
		B2.addActionListener(new TratarB2());
		L1 = new JLabel ("ID:");
		L2 = new JLabel ("Nome:");
		L3 = new JLabel ("Senha:");
		L4 = new JLabel ("Endereço:");
		L5 = new JLabel ("Email:");
	
		
		Entrada.add(L1);
		Entrada.add(T1);
		Entrada.add(L2);
		Entrada.add(T2);
		Entrada.add(L3);
		Entrada.add(P3);
		Entrada.add(L4);
		Entrada.add(T4);
		Entrada.add(L5);
		Entrada.add(T5);
		
		Botoes.add(B1);
		Botoes.add(B2);
		
		getContentPane().add(Entrada,BorderLayout.NORTH);
		getContentPane().add(Botoes,BorderLayout.SOUTH);
				
	}
	private class TratarB1 
	implements ActionListener {
		public void actionPerformed(ActionEvent e){				
			SolicitaCliente SolCli = new SolicitaCliente();				
			SolCli.iDUsuario = T1.getText();
			SolCli.nome = T2.getText();
			SolCli.senha = P3.getText();
			SolCli.endereco = T4.getText();
			SolCli.email = T5.getText();
			
			TelCliEdStub.Editar(SolCli);				
		}
		 
	}

	private class TratarB2
	implements ActionListener {
		public void actionPerformed(ActionEvent e){				
			TelCliEdStub.voltar();				
		}
		 
	}

}
