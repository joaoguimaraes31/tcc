/*
 * Created on 23/04/2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package entidades;

/**
 * @author yury
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class Produto {

	/** ID do produto */	
	private IDProduto iDProduto;
		
	/** Descrição Textual do produto */
	private DescricaoTextual descricaoTextual;
	
	/** Tipo do Produto */
	private Tipo tipo;
	
	/** Preço */
	private Preco preco;
	
	/**Quantidade */
	private Quantidade quantidade;	
	
	public Produto(){
		iDProduto = new IDProduto();
		descricaoTextual = new DescricaoTextual();
		tipo = new Tipo();
		preco = new Preco();
		quantidade = new Quantidade();
	}
	
	public int setProduto(SolicitaProduto solicitaProduto){
		
		int retorna;
		
		retorna = this.iDProduto.setIDProduto(solicitaProduto.iDProduto);
		if (!(retorna == Codigo.OK)){
			return Codigo.ID_INVALIDO;			
		}
		
		retorna = this.descricaoTextual.setDescricaoTextual (solicitaProduto.descricaoTextual );
		if (!(retorna == Codigo.OK)){
			return Codigo.DESCRICAO_TEXTUAL_INVALIDA;
		}
		
		retorna = this.tipo.setTipo (solicitaProduto.tipo );
		if (!(retorna == Codigo.OK)){
			return Codigo.TIPO_INVALIDO;
		}
		retorna = this.preco.setPreco(solicitaProduto.preco);
		
		if  (!(retorna == Codigo.OK)){
			return Codigo.PRECO_INVALIDO;
		}
		retorna = this.quantidade.setQuantidade(solicitaProduto.quantidade);
		if (!(retorna == Codigo.OK)){
			return Codigo.QUANTIDADE_INVALIDA;
		}
		
		return Codigo.OK;
	}
	
	public SolicitaProduto getProduto(){
		SolicitaProduto solicitaProduto = new SolicitaProduto(); 
		solicitaProduto.iDProduto = iDProduto.getIDProduto();
		solicitaProduto.descricaoTextual = descricaoTextual.getDescricaoTextual();
		solicitaProduto.tipo = tipo.getTipo();
		solicitaProduto.preco = preco.getPreco();
		solicitaProduto.quantidade = quantidade.getQuantidade();
		return solicitaProduto;
	}	
}
