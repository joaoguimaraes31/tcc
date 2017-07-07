package telas;
import telas.Janela;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import Controladoras.*;
import entidades.*;
/**
 * @author yury
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class TelaMenuClientes extends Janela {
	
	private ControladoraInteracaoNavegacao controladoraInteracaoNavegacao;
	private JPanel Botoes;
	private JButton B1,B2,B3;
	private JLabel L1,L2;
	
	public TelaMenuClientes(ControladoraInteracaoNavegacao controladoraInteracaoNavegacao, SolicitaAutenticacao solicitaAutenticacao){
		super("Menu do Cliente",new Dimension(320,220));
		this.controladoraInteracaoNavegacao = controladoraInteracaoNavegacao;
		Botoes = new JPanel();
		Botoes.setLayout(new GridLayout(5,1,20,8));
		
		L1 = new JLabel("ID :  "+solicitaAutenticacao.IDUsuario+"");
		//L2 = new JLabel("Nome:Nome do Cliente");
		B1 = new JButton("Lista de Pedidos");
		B1.addActionListener(new TrataB1() );
		B2 = new JButton("Inserir Novo Pedido");
		B2.addActionListener(new TrataB2() );
		B3 = new JButton("Voltar");
		B3.addActionListener(new TrataB3() );

		Botoes.add(L1);
	//	Botoes.add(L2);
		Botoes.add(B1);
		Botoes.add(B2);
		Botoes.add(B3);
		
		getContentPane().add(Botoes,BorderLayout.CENTER);
		show();
	}
	
	private class TrataB1 
	implements ActionListener {
		public void actionPerformed(ActionEvent e){				
			
			controladoraInteracaoNavegacao.criarTelaPedidoCliente(); 				
		}
		 
	}

	private class TrataB2
	implements ActionListener {
		public void actionPerformed(ActionEvent e){				
			controladoraInteracaoNavegacao.criarTelaProdutoPesquisa();				
		}
		 
	}
	
	private class TrataB3
	implements ActionListener {
		public void actionPerformed(ActionEvent e){				
			controladoraInteracaoNavegacao.criarTelaAutenticar();								
		}
		 
	}
	
}

