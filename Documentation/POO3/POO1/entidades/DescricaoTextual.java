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
public class DescricaoTextual {

	private String descricaoTextual = new String();
	
	public int setDescricaoTextual(String descricaoTextual){		
		int comprimento;		
		
		comprimento = descricaoTextual.length();		
		if ((comprimento <3 )||(comprimento > 50)){
			return Codigo.COMPRIMENTO_INVALIDO;
		}
		this.descricaoTextual = descricaoTextual;
		return Codigo.OK;		
	}

	public String getDescricaoTextual(){
		return descricaoTextual;
	}
}

