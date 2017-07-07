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
public class Quantidade {

	private int quantidade;	
	
	public int setQuantidade(String quantidade){
		int comprimento, parse ;		
				
		comprimento = quantidade.length();
		if (comprimento == 0) {
			return Codigo.COMPRIMENTO_INVALIDO;
		}
		for (int i=0; i<=comprimento - 1; i++){			
			if (!Character.isDigit(quantidade.charAt(i))){
				return Codigo.CARACTER_INVALIDO;
			}			
		}
		parse = Integer.parseInt(quantidade);	
		if(parse > 999999) {			
			return Codigo.NUMERO_MUITO_GRANDE;
		} else {
			this.quantidade = parse;
			return Codigo.OK;		
		}		
	}
	public String getQuantidade(){
		String QtString = new String();
		QtString = ""+quantidade;
		return QtString;
	}
}
