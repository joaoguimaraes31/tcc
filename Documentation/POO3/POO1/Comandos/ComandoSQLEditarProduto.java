/*
 * Created on 22/05/2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package Comandos;

import entidades.SolicitaProduto;

/**
 * @author yury
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class ComandoSQLEditarProduto extends ComandoSQL{

	private String iDProduto;
	private String descricaoTextual;
	private String tipo;
	private String preco;
	private String quantidade;
	
	public  ComandoSQLEditarProduto(SolicitaProduto solicitaProduto){
		
		this.iDProduto=solicitaProduto.iDProduto; 
		this.descricaoTextual=solicitaProduto.descricaoTextual;
		this.tipo=solicitaProduto.tipo;
		this.preco=solicitaProduto.preco;
		this.quantidade=solicitaProduto.quantidade;
	
	}
	
	
	public String  executar(){

		String SQL= "UPDATE Produtos SET "+
		"DescricaoTextual='" + descricaoTextual +
		"', Tipo='" + tipo +
		"', Preco='" + preco +
		"', Quantidade='" + quantidade +
		"' WHERE IDProduto='" +iDProduto+ "'"; 
		
		return SQL;
	}
	
	
}
