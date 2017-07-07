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
import Controladoras.*;
import java.util.Vector;

public class TelaClientePesquisa extends Janela  {
	
	private ControladoraInteracaoCliente controladoraInteracaoCliente;
	private JPanel Entrada;
	private Vector titulos;
	private JTextField T1;
	private JButton B1,B2;
	private JLabel L1;
	private JTable Tabela;  
	
	public TelaClientePesquisa(ControladoraInteracaoCliente controladoraInteracaoCliente, Vector listaDeClientes) {
		
		super("Tela de Pequisa de Clientes",new Dimension(600,400));
		this.controladoraInteracaoCliente = controladoraInteracaoCliente;
		Entrada = new JPanel();	
		titulos = new Vector();
		titulos.addElement("ID do Cliente");
		titulos.addElement("Nome");
		titulos.addElement("Senha");
		titulos.addElement("Endereço");
		titulos.addElement("Email");
		Tabela = new JTable(listaDeClientes,titulos);
		Tabela.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		Tabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		Tabela.setFocusable(false);
		Tabela.setToolTipText("Clique para remover ou editar o cliente");
		Tabela.addMouseListener(new TratarMouse());
		
		Entrada.setLayout(new GridLayout(1,4,10,10));
		
		T1 = new JTextField(10);
		B1 = new JButton("Pesquisar");
		B1.addActionListener(new TrataB1());
		B2 = new JButton("Voltar");
		B2.addActionListener(new TrataB2());
		L1 = new JLabel ("Busca por ID:");
		
		Entrada.add(L1);
		Entrada.add(T1);
		Entrada.add(B1);
		Entrada.add(B2);

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
		 	String IDCliente = "" + tb.getModel().getValueAt(it,0);
		 	
		 	//método que cria a tela de Edição e Remoção de Clientes
		 	controladoraInteracaoCliente.criarTelaClienteEdRem(IDCliente);
		}
		
	}
		
	private class TrataB1
	implements ActionListener {
			public void actionPerformed(ActionEvent e){
				String IDCliente = T1.getText();
//				método que cria a tela de Edição e Remoção de Clientes
				controladoraInteracaoCliente.criarTelaClienteEdRem(IDCliente);
				
				
			}
			 
	}
	
	private class TrataB2
	implements ActionListener {
			public void actionPerformed(ActionEvent e){
				
				controladoraInteracaoCliente.criarTelaMenuAdm();		
			}
			 
	}
		
}
