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
public class Situacao {

	private boolean Situacao;
	
	public int setSituacao(){
		
			this.Situacao = true;
			return Codigo.OK;
	}	
		
	public String getSituacao(){
			
			if (Situacao){
				return (new String("Processado"));
			}else{
				return (new String("Pendente"));
			}	
		}
	
	}
