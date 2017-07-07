package telas;
import telas.Janela;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import entidades.SolicitaProduto;
/**
 * @author yury
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class TelaProdutoEditar extends Janela {
	
	private TelaProdutoEditarStub TelProEdStub;
	private JPanel Entrada,Botoes;
	private JTextField T1,T2,T3,T4,T5;
	private JButton B1,B2;
	private JLabel L1, L2, L3, L4, L5;
	
	public TelaProdutoEditar() {
		super("Dados do Produto",new Dimension(320,220));
		Entrada = new JPanel();
		Botoes = new JPanel();
		TelProEdStub = new TelaProdutoEditarStub();
		Entrada.setLayout(new GridLayout(5,2,20,8));
		Botoes.setLayout(new GridLayout(1,2,20,8));
		
		T1 = new JTextField(10);
		T2 = new JTextField(10);
		T3 = new JTextField(10);
		T4 = new JTextField(10);
		T5 = new JTextField(10);
		B1 = new JButton("Editar");
		B1.addActionListener(new TrataB1());
		B2 = new JButton("Voltar");
		B2.addActionListener(new TrataB2());
		L1 = new JLabel ("ID:");
		L2 = new JLabel ("Descriçaõ textual:");
		L3 = new JLabel ("Tipo:");
		L4 = new JLabel ("Preço:");
		L5 = new JLabel ("Quantidade em estoque:");
	
		
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
				
	}
	
	private class TrataB1 
	implements ActionListener {
		public void actionPerformed(ActionEvent e){				
			SolicitaProduto SolPro = new SolicitaProduto();				
			SolPro.iDProduto = T1.getText();
			SolPro.descricaoTextual = T2.getText();
			SolPro.tipo = T3.getText();
			SolPro.preco = T4.getText();
			SolPro.quantidade = T5.getText();
			
			TelProEdStub.editar(SolPro);				
		}
		 
	}

	private class TrataB2
	implements ActionListener {
		public void actionPerformed(ActionEvent e){				
			TelProEdStub.voltar();				
		}
		 
	}
	
}
