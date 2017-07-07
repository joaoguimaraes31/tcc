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
public class Nome {


	private String nome = new String();
	
	public int setNome(String nome){		
		int comprimento;		
		
		comprimento = nome.length();		
		if ((comprimento <3 )||(comprimento > 30)){
			return Codigo.COMPRIMENTO_INVALIDO;
		}else{
			for (int i=0; i<=comprimento - 1; i++){
				if ((!Character.isLetter(nome.charAt(i)))&&
				(!Character.isWhitespace(nome.charAt(i)))){
					return Codigo.CARACTER_INVALIDO;
				}			
			}
		}
		this.nome = nome;
		return Codigo.OK;		
	}

	public String getNome(){
		return nome;
	}
}

