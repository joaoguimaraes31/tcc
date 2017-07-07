package telas;
import telas.Janela;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Controladoras.ControladoraInteracaoPedido;
import entidades.SolicitaPedido;
import javax.swing.*;
/**
 * @author yury
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class TelaPedidoCancelar extends Janela {
	
	private ControladoraInteracaoPedido controladoraInteracaoPedido;
	private JPanel Entrada,Botoes;
	private JTextField T1,T2,T3,T5;
	private JButton B1,B2;
	private JLabel L1, L2, L3, L5;
	
	public TelaPedidoCancelar(ControladoraInteracaoPedido controladoraInteracaoPedido, SolicitaPedido solicitaPedido) {
		super("Dados do Pedido",new Dimension(320,220));
		this.controladoraInteracaoPedido = controladoraInteracaoPedido;
		
		Entrada = new JPanel();
		Botoes = new JPanel();
		
		Entrada.setLayout(new GridLayout(5,2,20,15));
		Botoes.setLayout(new GridLayout(1,2,20,8));
		
		T1 = new JTextField(solicitaPedido.IDPedido);
		T1.setEditable(false);
		T2 = new JTextField(solicitaPedido.IDProduto);
		T2.setEditable(false);
		T3 = new JTextField(solicitaPedido.IDUsuario);
		T3.setEditable(false);
		T5 = new JTextField(solicitaPedido.Situacao);
		T5.setEditable(false);
		
		B1 = new JButton("Cancelar");
		B1.addActionListener(new TrataB1());
		B2 = new JButton("Voltar");
		B2.addActionListener(new TrataB2());
		L1 = new JLabel ("ID do Pedido:");
		L2 = new JLabel ("ID do Produto:");
		L3 = new JLabel ("ID do Cliente:");
		L5 = new JLabel ("Situação:");
	
		Entrada.add(L1);
		Entrada.add(T1);
		Entrada.add(L2);
		Entrada.add(T2);
		Entrada.add(L3);
		Entrada.add(T3);
		Entrada.add(L5);
		Entrada.add(T5);
		
		Botoes.add(B1);
		Botoes.add(B2);
		
		getContentPane().add(Entrada,BorderLayout.NORTH);
		getContentPane().add(Botoes,BorderLayout.SOUTH);
		show();
	}
	
	private class TrataB1 
	implements ActionListener {
		public void actionPerformed(ActionEvent e){				
			String IDPedido;
			String IDProduto;
			IDPedido = T1.getText();
			IDProduto = T2.getText();
//			metodo de remoção de pedidos
			controladoraInteracaoPedido.remover(IDPedido, IDProduto);	
		}
		 
	}

	private class TrataB2
	implements ActionListener {
		public void actionPerformed(ActionEvent e){				
			controladoraInteracaoPedido.criarTelaPedidoCliente();		
		}
		 
	}
	
}
