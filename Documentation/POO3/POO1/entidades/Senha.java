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
public class Senha {

	private String senha = new String();
	
	public int setSenha(String senha){		
		int comprimento;		
		
		comprimento = senha.length();		
		if ((comprimento <4 )||(comprimento > 15)){
			return Codigo.COMPRIMENTO_INVALIDO;
		}else{
			for (int i=0; i<=comprimento - 1; i++){
				if (!Character.isLetterOrDigit(senha.charAt(i))){
					return Codigo.CARACTER_INVALIDO;
				}			
			}
		}
		this.senha = senha;
		return Codigo.OK;		
	}

	public String getSenha(){
		return senha;
	}
	
}
