/*
 * Created on 22/04/2005
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
public class IDPedido {

	private String IDPedido = new String();
	
	public int setIDPedido(String IDPedido){		
		int comprimento;		
		
		comprimento = IDPedido.length();		
		if ((comprimento <1 )||(comprimento > 15)){
			return Codigo.COMPRIMENTO_INVALIDO;
		}else if (('d')!=(IDPedido.charAt(0))){
				return Codigo.CARACTER_INVALIDO;
		}else{
			for (int i=1; i<=comprimento - 1; i++){
				if ((!Character.isLetterOrDigit(IDPedido.charAt(i)))){
					return Codigo.CARACTER_INVALIDO;
				}			
			}
		} 
		this.IDPedido = IDPedido;
		return Codigo.OK;		
	}

	public String getIDPedido(){
		return IDPedido;
	}
}
