/*
 * Created on 08/06/2005
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
public class CodigoToMenssagem {

	public static String fromCodigoToMenssagem(int Codigo){
		
		
		switch(Codigo){
		
		case -1:
			return ":  COMPRIMENTO INV�LIDO";
		
		case 0:
			return ":  OK";
		
		case -2:
			return ":  CARACTER INV�LIDO";
		
		case -3:
			return ":  N�MERO MENOR QUE ZERO";
	
		case -4:
			return ":  N�MERO MUITO GRANDE";
		
		case -5:
			return ":  FORMATO INV�LIDO";
		
		case -6:
			return ":  NOME INV�LIDO";
		
		case -7:
			return ":  ENDERECO INV�LIDO";
		
		case -8:
			return ":  CAMPO VAZIO";
		
		case -9:
			return ":  ID INV�LIDO";
		
		case -10:
			return ":  SENHA INV�LIDA";
		
		case -11:
			return ":  EMAIL INV�LIDO";
		
		case -12:
			return ":  DESCRI�AO TEXTUAL INV�LIDA";
		
		case -13:
			return ":  TIPO INV�LIDO";
		
		case -14:
			return ":  PRE�O INV�LIDO";
		
		case -15:
			return ":  QUANTIDADE INV�LIDA";
		
		case -16:
			return ":  FALHA NO PROCESSAMENTO DO BANCO";
		
		case -17:
			return ":  FALHA NA CONEX�O COM O BANCO";
		
		case -18:
			return ":  DADOS DE AUTENTICA��O INVALIDOS";
		
		case -19:
			return ":  ESTOQUE_DO_PRODUTO_ESGOTADO";
		
		default :
			
			return ":  ERRO";
		
		}
		
	}

}
