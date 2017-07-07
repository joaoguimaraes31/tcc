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
public class Email {

	private String email;
	
	public int setEmail(String email){		
		int comprimento;		
		
		comprimento =email.length();		
		if ((comprimento < 4 )||(comprimento > 40)){
			return Codigo.COMPRIMENTO_INVALIDO;
		}else if(!Character.isLetterOrDigit(email.charAt(0))){
			return Codigo.FORMATO_INVALIDO;
		}else if(!Character.isLetterOrDigit(email.charAt(comprimento-1))){
			return Codigo.FORMATO_INVALIDO;
		}else{
			int contador=0;
			for (int i=1; i<=comprimento - 2; i++){
				if ((!Character.isLetterOrDigit(email.charAt(i)))&&(('_')!=(email.charAt(i)))&&(('.')!=(email.charAt(i)))){
					if (('@')!=(email.charAt(i))){
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
		
		this.email = email;
		return Codigo.OK;		
	}

	public String getEmail(){
		return email;
	}
}
