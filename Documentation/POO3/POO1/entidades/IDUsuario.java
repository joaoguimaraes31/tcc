package entidades; 
/*
 * Created on 17/04/2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */

/**
 * @author yury
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class IDUsuario {

	private String IDUsuario = new String();
	
	public int setIDUsuario(String IDUsuario){		
		int comprimento;		
		
		comprimento = IDUsuario.length();		
		if ((comprimento <3 )||(comprimento > 15)){
			return Codigo.COMPRIMENTO_INVALIDO;
		}else if (('c')!=(IDUsuario.charAt(0))){
			if (('a')!=(IDUsuario.charAt(0))){
				return Codigo.CARACTER_INVALIDO;
			}
		}else{
			for (int i=1; i<=comprimento - 1; i++){
				if ((!Character.isLetterOrDigit(IDUsuario.charAt(i)))&&
				(!Character.isWhitespace(IDUsuario.charAt(i)))){
					return Codigo.CARACTER_INVALIDO;
				}			
			}
		}
		this.IDUsuario = IDUsuario;
		return Codigo.OK;		
	}

	public String getIDUsuario(){
		return IDUsuario;
	}
	
}
