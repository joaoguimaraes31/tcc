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
public class IDProduto {

	private String IDProduto = new String();
	
	public int setIDProduto(String IDProduto){		
		int comprimento;		
		
		comprimento = IDProduto.length();		
		if ((comprimento <3 )||(comprimento > 15)){
			return Codigo.COMPRIMENTO_INVALIDO;
		}else if (('p')!=(IDProduto.charAt(0))){
				return Codigo.CARACTER_INVALIDO;
		}else{
			for (int i=1; i<=comprimento - 1; i++){
				if ((!Character.isLetterOrDigit(IDProduto.charAt(i)))&&
				(!Character.isWhitespace(IDProduto.charAt(i)))){
					return Codigo.CARACTER_INVALIDO;
				}			
			}
		}
		this.IDProduto = IDProduto;
		return Codigo.OK;		
	}

	public String getIDProduto(){
		return IDProduto;
	}
}
