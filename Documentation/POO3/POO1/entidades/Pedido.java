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
public class Pedido {
	
	/** ID do pedido */	
	private IDPedido iDPedido;

	/** ID do produto */	
	private IDProduto iDProduto;
	
	/** ID do cliente */	
	private IDUsuario iDUsuario;
		
	/** Situação do Pedido */
	private Situacao situacao;
	
	
	public Pedido(){
		
		iDPedido = new IDPedido();
		iDProduto = new IDProduto();
		iDUsuario = new IDUsuario();
		situacao = new Situacao();
	}
	
	public int setPedido(SolicitaPedido solicitaPedido){
		
		int retorna;
		
		retorna = this.iDPedido.setIDPedido(solicitaPedido.IDPedido);
		if (!(retorna == Codigo.OK)){
			return Codigo.ID_INVALIDO;			
		}
		
		retorna = this.iDProduto.setIDProduto(solicitaPedido.IDProduto );
		if (!(retorna == Codigo.OK)){
			return Codigo.ID_INVALIDO;
		}
		
		retorna = this.iDUsuario.setIDUsuario(solicitaPedido.IDUsuario);
		if (!(retorna == Codigo.OK)){
			return Codigo.ID_INVALIDO;			
		}

		retorna = this.situacao.setSituacao();
		if (!(retorna == Codigo.OK)){
		}
		
		return Codigo.OK;
	}
	
	public SolicitaPedido getPedido(){
		SolicitaPedido solicitaPedido = new SolicitaPedido(); 
		solicitaPedido.IDPedido = iDPedido.getIDPedido();
		solicitaPedido.IDProduto = iDProduto.getIDProduto();
		solicitaPedido.IDUsuario = iDUsuario.getIDUsuario();
		solicitaPedido.Situacao = situacao.getSituacao();
		
		return solicitaPedido;
	}
}
