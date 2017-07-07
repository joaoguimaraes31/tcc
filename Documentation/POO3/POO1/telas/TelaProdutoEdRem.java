
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

import entidades.SolicitaProduto;
/**
 * @author yury
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */

public class TelaProdutoEdRem extends Janela {

	private ControladoraInteracaoProduto controladoraInteracaoProduto;
	private JPanel Entrada,Botoes;
	private JTextField T1,T2,T3,T4,T5;
	private JButton B1,B2,B3;
	private JLabel L1, L2, L3, L4, L5;
	private boolean Flag=true;
	
	public TelaProdutoEdRem(ControladoraInteracaoProduto controladoraInteracaoProduto, SolicitaProduto solicitaProduto) {
	
	
		super("Dados do Produto",new Dimension(320,220));
		this.controladoraInteracaoProduto = controladoraInteracaoProduto; 	
		Entrada = new JPanel();
		Botoes = new JPanel();
		Entrada.setLayout(new GridLayout(5,2,20,8));
		Botoes.setLayout(new GridLayout(1,3,20,8));
	
		T1 = new JTextField(solicitaProduto.iDProduto);
		T1.setEditable(false);
		T2 = new JTextField(solicitaProduto.descricaoTextual);
		T2.setEditable(false);
		T3 = new JTextField(solicitaProduto.tipo);
		T3.setEditable(false);
		T4 = new JTextField(solicitaProduto.preco);
		T4.setEditable(false);
		T5 = new JTextField(solicitaProduto.quantidade);
		T5.setEditable(false);
	
		B1 = new JButton("Editar");
		B1.addActionListener(new TratarB1());
		B2 = new JButton("Remover");
		B2.addActionListener(new TratarB2());
		B3 = new JButton("Voltar");
		B3.addActionListener(new TratarB3());
	
		L1 = new JLabel ("ID:");
		L2 = new JLabel ("Descrição textual:");
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
		Botoes.add(B3);
	
		getContentPane().add(Entrada,BorderLayout.NORTH);
		getContentPane().add(Botoes,BorderLayout.SOUTH);
		show();
	}

	private class TratarB2 
	implements ActionListener {
		public void actionPerformed(ActionEvent e){				
			SolicitaProduto solicitaProduto = new SolicitaProduto();				
			solicitaProduto.iDProduto = T1.getText();
			solicitaProduto.descricaoTextual = T2.getText();
			solicitaProduto.tipo = T3.getText();
			solicitaProduto.preco = T4.getText();
			solicitaProduto.quantidade = T5.getText();

			//metodo de remoção de Produto
			controladoraInteracaoProduto.remover(solicitaProduto.iDProduto);
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
			}else{
				SolicitaProduto solicitaProduto = new SolicitaProduto();				
				solicitaProduto.iDProduto = T1.getText();
				solicitaProduto.descricaoTextual = T2.getText();
				solicitaProduto.tipo = T3.getText();
				solicitaProduto.preco = T4.getText();
				solicitaProduto.quantidade = T5.getText();

		
			//método de edição de Produto
			controladoraInteracaoProduto.editar(solicitaProduto);
		
			} 
			
		}
	 
	}

	private class TratarB3
	implements ActionListener {
		public void actionPerformed(ActionEvent e){	
		
			// método para voltar para a tela de pesquisa de Produto
			controladoraInteracaoProduto.criarTelaProdutoPesquisa();
		}
	 
	}
}	
