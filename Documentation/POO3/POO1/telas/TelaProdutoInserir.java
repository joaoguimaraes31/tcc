
package telas;
import telas.Janela;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import Controladoras.ControladoraInteracaoProduto;

import entidades.SolicitaProduto;
/**
 * @author yury
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class TelaProdutoInserir extends Janela {
	
	private ControladoraInteracaoProduto controladoraInteracaoProduto;
	private JPanel Entrada,Botoes;
	private JTextField T1,T2,T3,T4,T5;
	private JButton B1,B2;
	private JLabel L1, L2, L3, L4, L5;
	
	public TelaProdutoInserir(ControladoraInteracaoProduto controladoraInteracaoProduto) {
		super("Dados do Produto",new Dimension(320,220));
		this.controladoraInteracaoProduto = controladoraInteracaoProduto;
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
		B1.addActionListener(new TrataB1());
		B2 = new JButton("Voltar");
		B2.addActionListener(new TrataB2());
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
		
		getContentPane().add(Entrada,BorderLayout.NORTH);
		getContentPane().add(Botoes,BorderLayout.SOUTH);
				
		show();
		
	}
		
	private class TrataB1 
	implements ActionListener {
		public void actionPerformed(ActionEvent e){
			SolicitaProduto solicitaProduto = new SolicitaProduto();				
			solicitaProduto.iDProduto = T1.getText();
			solicitaProduto.descricaoTextual = T2.getText();
			solicitaProduto.tipo = T3.getText();
			solicitaProduto.preco = T4.getText();
			solicitaProduto.quantidade = T5.getText();
			
			//metodo para inserção de produto
			controladoraInteracaoProduto.inserir(solicitaProduto);
		}
		 
	}

	private class TrataB2
	implements ActionListener {
		public void actionPerformed(ActionEvent e){	
			
			controladoraInteracaoProduto.criarTelaMenuAdm();
						
		}
		 
	}


	
}