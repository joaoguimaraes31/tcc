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
public class Preco {

	private double preco;
	
	public int setPreco(String preco){		
		int comprimento;		
		
		comprimento = preco.length();		
		if ((comprimento ==0 )||(comprimento > 10)){
			return Codigo.COMPRIMENTO_INVALIDO;
		}else if(!Character.isDigit(preco.charAt(0))){
			return Codigo.FORMATO_INVALIDO;
		}else if(!Character.isDigit(preco.charAt(comprimento-1))){
			return Codigo.FORMATO_INVALIDO;
		}else{
			int contador=0;
			for (int i=1; i<=comprimento - 2; i++){
				if (!Character.isDigit(preco.charAt(i))){
					if (('.')!=(preco.charAt(i))){
					return Codigo.CARACTER_INVALIDO;
					}else{
						contador++;
						if (contador > 1){
							return Codigo.FORMATO_INVALIDO;
						}
					}			
					
				}
					
			}
		}
		
		this.preco = Double.parseDouble(preco);
		return Codigo.OK;		
	}

	public String getPreco(){
		String precoString = new String();
		precoString = ""+preco;
		return precoString;
	}
}

