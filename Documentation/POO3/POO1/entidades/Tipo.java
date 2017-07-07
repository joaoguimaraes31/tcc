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
public class Tipo {

	private String tipo = new String();
	
	public int setTipo(String tipo){		
		int comprimento;		
		
		comprimento = tipo.length();
		if (comprimento > 20 ){
			return Codigo.COMPRIMENTO_INVALIDO;
		}
		
		for (int i=0; i<=comprimento - 1; i++){
			if (!Character.isLetterOrDigit(tipo.charAt(i))&&
					(!Character.isWhitespace(tipo.charAt(i)))){
					return Codigo.CARACTER_INVALIDO;
				}			
			}
		
		this.tipo = tipo;
		return Codigo.OK;		
	}

	public String getTipo(){
		return tipo;
	}
	
}
