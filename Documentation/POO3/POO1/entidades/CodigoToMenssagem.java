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
			return ":  COMPRIMENTO INVÁLIDO";
		
		case 0:
			return ":  OK";
		
		case -2:
			return ":  CARACTER INVÁLIDO";
		
		case -3:
			return ":  NÚMERO MENOR QUE ZERO";
	
		case -4:
			return ":  NÚMERO MUITO GRANDE";
		
		case -5:
			return ":  FORMATO INVÁLIDO";
		
		case -6:
			return ":  NOME INVÁLIDO";
		
		case -7:
			return ":  ENDERECO INVÁLIDO";
		
		case -8:
			return ":  CAMPO VAZIO";
		
		case -9:
			return ":  ID INVÁLIDO";
		
		case -10:
			return ":  SENHA INVÁLIDA";
		
		case -11:
			return ":  EMAIL INVÁLIDO";
		
		case -12:
			return ":  DESCRIÇAO TEXTUAL INVÁLIDA";
		
		case -13:
			return ":  TIPO INVÁLIDO";
		
		case -14:
			return ":  PREÇO INVÁLIDO";
		
		case -15:
			return ":  QUANTIDADE INVÁLIDA";
		
		case -16:
			return ":  FALHA NO PROCESSAMENTO DO BANCO";
		
		case -17:
			return ":  FALHA NA CONEXÃO COM O BANCO";
		
		case -18:
			return ":  DADOS DE AUTENTICAÇÃO INVALIDOS";
		
		case -19:
			return ":  ESTOQUE_DO_PRODUTO_ESGOTADO";
		
		default :
			
			return ":  ERRO";
		
		}
		
	}

}
