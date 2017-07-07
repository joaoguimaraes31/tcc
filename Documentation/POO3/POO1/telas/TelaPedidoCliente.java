/*
 * Created on 19/04/2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package telas;

import java.awt.*;

import telas.Janela;

import javax.swing.*;

import java.awt.event.*;
import java.util.Vector;
import Controladoras.ControladoraInteracaoPedido;

public class TelaPedidoCliente extends Janela  {

	private ControladoraInteracaoPedido controladoraInteracaoPedido;
	private JPanel Entrada;
	private Vector titulos;
	private JButton B2;
	private JTable Tabela;  
	
	
	
	public TelaPedidoCliente(ControladoraInteracaoPedido controladoraInteracaoPedido, Vector listaDePedidos) {
		super("Tela de Pedidos do Cliente",new Dimension(600,400));
		this.controladoraInteracaoPedido = controladoraInteracaoPedido;
		
		Entrada = new JPanel();
		titulos = new Vector();
		titulos.addElement("ID do Pedido");
		titulos.addElement("ID do Produto");
		titulos.addElement("ID do Cliente");
		titulos.addElement("Situação");
	
		Tabela = new JTable(listaDePedidos,titulos);
		Tabela.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		Tabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		Tabela.setFocusable(false);
		Tabela.setToolTipText("Clique para cancelar pedidos");
		Tabela.addMouseListener(new TratarMouse());
		
		Entrada.setLayout(new GridLayout(1,4,10,10));
		
		B2 = new JButton("Voltar");
		Entrada.add(B2);
		B2.addActionListener(new TrataB2());

		getContentPane().add(Entrada,BorderLayout.SOUTH);
		getContentPane().add(new JScrollPane(Tabela),BorderLayout.CENTER);
		show();
	}
	
	class TratarMouse implements MouseListener {

		public void mouseClicked(MouseEvent arg0) {}
		public void mouseEntered(MouseEvent arg0) {}
		public void mouseExited(MouseEvent arg0) {}
		public void mousePressed(MouseEvent arg0) {}
		public void mouseReleased(MouseEvent e) {
			
			if (e.getButton()!=MouseEvent.BUTTON1) return;
			if (!(e.getSource() instanceof JTable)) return;
			
			JTable tb = (JTable)e.getSource();
			if (tb.getSelectionModel().isSelectionEmpty()) return;
			
			int it = tb.getSelectionModel().getMinSelectionIndex();
		 	String IDPedido = "" + tb.getModel().getValueAt(it,0);
		 	
//		 	método que cria a tela processamento de pedidos
		 	controladoraInteracaoPedido.criarTelaPedidoCancelar(IDPedido);
		}
		
	}
	
	private class TrataB2
	implements ActionListener {
			public void actionPerformed(ActionEvent e){

				controladoraInteracaoPedido.criarTelaMenuClientes();						
			}
			 
	}

}

