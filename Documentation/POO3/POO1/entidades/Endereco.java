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
public class Endereco {

	private String Endereco = new String();
	
	public int setEndereco(String Endereco){		
		int comprimento;		
		
		comprimento = Endereco.length();		
		if ((comprimento <3 )||(comprimento > 50)){
			return Codigo.COMPRIMENTO_INVALIDO;
		}
		this.Endereco = Endereco;
		return Codigo.OK;		
	}

	public String getEndereco(){
		return Endereco;
	}
}
