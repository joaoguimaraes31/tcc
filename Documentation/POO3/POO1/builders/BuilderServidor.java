/*
 * Created on 27/06/2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package builders;

import interfaces.InterfaceControladoraNegocioAutenticacao;
import interfaces.InterfaceControladoraNegocioCliente;
import interfaces.InterfaceControladoraNegocioPedido;
import interfaces.InterfaceControladoraNegocioProduto;

import java.rmi.Naming;

import javax.swing.JOptionPane;

import Controladoras.ContorladoraNegocioAutenticacao;
import Controladoras.ControladoraNegocioCliente;
import Controladoras.ControladoraNegocioPedido;
import Controladoras.ControladoraNegocioProduto;
import Persistencia.ControladoraPersistencia;

/**
 * @author yury
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class BuilderServidor {

	ControladoraPersistencia controladoraPersistencia;
	
	public BuilderServidor() {
	    try {
	    	//cria subssistema de Autenticação por parte do servidor
	    	InterfaceControladoraNegocioAutenticacao interfaceControladoraNegocioAutenticacao = new ContorladoraNegocioAutenticacao();
	    	
	    	// cria controladora de persistencia e a seta como controladora
	    	// de persistencia para esta controladora de negocio
	    	controladoraPersistencia  = ControladoraPersistencia.instanciar();
	    	((ContorladoraNegocioAutenticacao) interfaceControladoraNegocioAutenticacao).setControladoraPersistencia(controladoraPersistencia);
	    	
	    	//torna disponível para RMI
	    	Naming.rebind("rmi://localhost:1099/AutenticacaoService", interfaceControladoraNegocioAutenticacao);
	    }
	    catch( Exception e ) {
	    	JOptionPane.showMessageDialog(null,"Erro na inicialização do servidor: Serviços de autenticação indisponibilizados \n para aplicação cliente","Atenção",JOptionPane.ERROR_MESSAGE);
	    }try {
			//cria subssistema de Clientes por parte do servidor
			InterfaceControladoraNegocioCliente interfaceControladoraNegocioCliente = new ControladoraNegocioCliente();
    	
			// cria controladora de persistencia e a seta como controladora
			// de persistencia para esta controladora de negocio
			controladoraPersistencia  = ControladoraPersistencia.instanciar();
			((ControladoraNegocioCliente) interfaceControladoraNegocioCliente).setControladoraPersistencia(controladoraPersistencia);
    	
			//torna disponível para RMI
			Naming.rebind("rmi://localhost:1099/ClienteService", interfaceControladoraNegocioCliente);
			}
		catch( Exception e ) {
			JOptionPane.showMessageDialog(null,"Erro na inicialização do servidor: Serviços de cliente indisponibilizados \n para aplicação cliente","Atenção",JOptionPane.ERROR_MESSAGE);
		}try {
			//cria subssistema de Produtos por parte do servidor
			InterfaceControladoraNegocioProduto interfaceControladoraNegocioProduto = new ControladoraNegocioProduto();
    	
			// cria controladora de persistencia e a seta como controladora
			// de persistencia para esta controladora de negocio
			controladoraPersistencia  = ControladoraPersistencia.instanciar();
			((ControladoraNegocioProduto) interfaceControladoraNegocioProduto).setControladoraPersistencia(controladoraPersistencia);
    	
			//torna disponível para RMI
			Naming.rebind("rmi://localhost:1099/ProdutoService", interfaceControladoraNegocioProduto);
			}
		catch( Exception e ) {
			JOptionPane.showMessageDialog(null,"Erro na inicialização do servidor: Serviços de produto indisponibilizados \n para aplicação cliente","Atenção",JOptionPane.ERROR_MESSAGE);
		} try{
			//cria subssistema de Pedidos por parte do servidor
			InterfaceControladoraNegocioPedido interfaceControladoraNegocioPedido = new ControladoraNegocioPedido();
    	
			// cria controladora de persistencia e a seta como controladora
			// de persistencia para esta controladora de negocio
			controladoraPersistencia  = ControladoraPersistencia.instanciar();
			((ControladoraNegocioPedido) interfaceControladoraNegocioPedido).setControladoraPersistencia(controladoraPersistencia);
    	
			//torna disponível para RMI
			Naming.rebind("rmi://localhost:1099/PedidoService", interfaceControladoraNegocioPedido);
			}
		catch( Exception e ) {
			JOptionPane.showMessageDialog(null,"Erro na inicialização do servidor: Serviços de pedido indisponibilizados \n para aplicação cliente","Atenção",JOptionPane.ERROR_MESSAGE);
		}
			
	}
}
	
