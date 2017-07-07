package telas;
import telas.Janela;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import Controladoras.ControladoraInteracaoCliente;

import entidades.SolicitaCliente;
/**
 * @author yury
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class TelaClienteInserir extends Janela {
	
	private ControladoraInteracaoCliente controladoraInteracaoCliente;
	private JPanel Entrada,Botoes;
	private JTextField T1,T2,T3,T4,T5;
	private JButton B1,B2;
	private JLabel L1, L2, L3, L4, L5;
	
	public TelaClienteInserir(ControladoraInteracaoCliente controladoraInteracaoCliente) {
		super("Dados do Cliente",new Dimension(320,220));
		this.controladoraInteracaoCliente = controladoraInteracaoCliente;
		Entrada = new JPanel();
		Botoes = new JPanel();
		Entrada.setLayout(new GridLayout(5,2,20,8));
		Botoes.setLayout(new GridLayout(1,2,20,8));
		
		T1 = new JTextField(10);
		T2 = new JTextField(10);
		T3 = new JTextField(10);
		T4 = new JTextField(10);
		T5 = new JTextField(10);
		B1 = new JButton("Inserir");
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
		Entrada.add(T3);
		Entrada.add(L4);
		Entrada.add(T4);
		Entrada.add(L5);
		Entrada.add(T5);
		
		Botoes.add(B1);
		Botoes.add(B2);
		
		getContentPane().add(Entrada,BorderLayout.NORTH);
		getContentPane().add(Botoes,BorderLayout.SOUTH);
				
		show();
		
		
	}
		
	private class TratarB1 
	implements ActionListener {
		public void actionPerformed(ActionEvent e){				
			SolicitaCliente solicitaCliente = new SolicitaCliente();				
			solicitaCliente.iDUsuario = T1.getText();
			solicitaCliente.nome = T2.getText();
			solicitaCliente.senha = T3.getText();
			solicitaCliente.endereco = T4.getText();
			solicitaCliente.email = T5.getText();
			
			//metodo para inserção de clientes
			controladoraInteracaoCliente.inserir(solicitaCliente);
		}
		 
	}

	private class TratarB2
	implements ActionListener {
		public void actionPerformed(ActionEvent e){	
			
			if (controladoraInteracaoCliente != null){
			
			System.out.println("controladoraInteracaoCliente não é null");
			controladoraInteracaoCliente.criarTelaMenuAdm();
			}
			
						
		}
		 
	}


	
}