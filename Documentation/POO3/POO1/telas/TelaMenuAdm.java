package telas;
import telas.Janela;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import Controladoras.*;


/**
 * @author yury
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class TelaMenuAdm extends Janela {
	
	private ControladoraInteracaoNavegacao controladoraInteracaoNavegacao;
	private JPanel Entrada,Botoes;
	private JButton B1,B2, B3, B4, B5, B6;
	
	public TelaMenuAdm(ControladoraInteracaoNavegacao controladoraInteracaoNavegacao) {
		super("Menu do Administrador do Sistema",new Dimension(320,220));
		this.controladoraInteracaoNavegacao = controladoraInteracaoNavegacao;
		Botoes = new JPanel();
		Botoes.setLayout(new GridLayout(6,1,20,8));
		
		B1 = new JButton("Lista de Clientes");
		B1.addActionListener(new TrataB1() );
		B2 = new JButton("Inserir Novo Cliente");
		B2.addActionListener(new TrataB2() );
		B3 = new JButton("Lista de Produtos");
		B3.addActionListener(new TrataB3() );
		B4 = new JButton("Inserir Novo Produto ");
		B4.addActionListener(new TrataB4() );
		B5 = new JButton("Processar Pedido");
		B5.addActionListener(new TrataB5() );
		B6 = new JButton("Voltar");
		B6.addActionListener(new TrataB6() );
		

		Botoes.add(B1);
		Botoes.add(B2);
		Botoes.add(B3);
		Botoes.add(B4);
		Botoes.add(B5);
		Botoes.add(B6);
		
		getContentPane().add(Botoes,BorderLayout.CENTER);
		show();	
	}
	
	private class TrataB1 
	implements ActionListener {
		public void actionPerformed(ActionEvent e){				
			
			controladoraInteracaoNavegacao.criarTelaClientePesquisa();		
		}
		 
	}

	private class TrataB2
	implements ActionListener {
		public void actionPerformed(ActionEvent e){				
			controladoraInteracaoNavegacao.criarTelaClienteInserir();				
		}
		 
	}
	
	private class TrataB3
	implements ActionListener {
		public void actionPerformed(ActionEvent e){				
			controladoraInteracaoNavegacao.criarTelaProdutoPesquisa();				
		}
		 
	}
	
	private class TrataB4
	implements ActionListener {
		public void actionPerformed(ActionEvent e){				
			controladoraInteracaoNavegacao.criarTelaProdutoInserir();					
		}
		 
	}
	private class TrataB5
	implements ActionListener {
		public void actionPerformed(ActionEvent e){				
			controladoraInteracaoNavegacao.criarTelaPedidoProcessamento();					
		}
		 
	}
	
	private class TrataB6
	implements ActionListener {
		public void actionPerformed(ActionEvent e){				
			controladoraInteracaoNavegacao.criarTelaAutenticar();				
		}
		 
	}
	
}
