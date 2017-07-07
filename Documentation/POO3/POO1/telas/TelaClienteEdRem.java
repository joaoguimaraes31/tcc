package telas;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import Controladoras.*;

import entidades.SolicitaCliente;
/**
 * @author yury
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class TelaClienteEdRem extends Janela {
	
	private ControladoraInteracaoCliente controladoraInteracaoCliente;
	private JPanel Entrada,Botoes;
	private JTextField T1,T2,T3,T4,T5;
	private JButton B1,B2,B3;
	private JLabel L1, L2, L3, L4, L5;
	private boolean Flag=true;
	
	public TelaClienteEdRem(ControladoraInteracaoCliente controladoraInteracaoCliente, SolicitaCliente solicitaCliente) {
		
		
		super("Dados do Cliente",new Dimension(320,220));
		this.controladoraInteracaoCliente = controladoraInteracaoCliente; 	
		Entrada = new JPanel();
		Botoes = new JPanel();
		Entrada.setLayout(new GridLayout(5,2,20,8));
		Botoes.setLayout(new GridLayout(1,3,20,8));
		
		T1 = new JTextField(solicitaCliente.iDUsuario);
		T1.setEditable(false);
		T2 = new JTextField(solicitaCliente.nome);
		T2.setEditable(false);
		T3 = new JTextField(solicitaCliente.senha);
		T3.setEditable(false);
		T4 = new JTextField(solicitaCliente.endereco);
		T4.setEditable(false);
		T5 = new JTextField(solicitaCliente.email);
		T5.setEditable(false);
		
		B1 = new JButton("Editar");
		B1.addActionListener(new TratarB1());
		B2 = new JButton("Remover");
		B2.addActionListener(new TratarB2());
		B3 = new JButton("Voltar");
		B3.addActionListener(new TratarB3());
		
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
		Entrada.add(T3);
		Entrada.add(L4);
		Entrada.add(T4);
		Entrada.add(L5);
		Entrada.add(T5);
		
		Botoes.add(B1);
		Botoes.add(B2);
		Botoes.add(B3);
		
		getContentPane().add(Entrada,BorderLayout.NORTH);
		getContentPane().add(Botoes,BorderLayout.SOUTH);
		show();
	}
	
	private class TratarB2 
	implements ActionListener {
		public void actionPerformed(ActionEvent e){				
			SolicitaCliente SolCli = new SolicitaCliente();				
			SolCli.iDUsuario = T1.getText();
			SolCli.nome = T2.getText();
			SolCli.senha = T3.getText();
			SolCli.endereco = T4.getText();
			SolCli.email = T5.getText();
	
			//metodo de remoção de clientes
			controladoraInteracaoCliente.remover(SolCli.iDUsuario);
		}
		 
	}

	private class TratarB1
	implements ActionListener {
		public void actionPerformed(ActionEvent e){				
			
			if (Flag){
			Flag=false;	
			T1.setEditable(false);
			T2.setEditable(true);
			T3.setEditable(true);
			T4.setEditable(true);
			T5.setEditable(true);
			B2.setEnabled(false);
			}
			else{
			SolicitaCliente SolCli = new SolicitaCliente();				
			SolCli.iDUsuario = T1.getText();
			SolCli.nome = T2.getText();
			SolCli.senha = T3.getText();
			SolCli.endereco = T4.getText();
			SolCli.email = T5.getText();	
			
			//método de edição de clientes
			controladoraInteracaoCliente.editar(SolCli);
			
			} 
				
		}
		 
	}
	
	private class TratarB3
	implements ActionListener {
		public void actionPerformed(ActionEvent e){	
			
			// método para voltar para a tela de pesquisa de clientes
			controladoraInteracaoCliente.criarTelaClientePesquisa();
		}
		 
	}

}
