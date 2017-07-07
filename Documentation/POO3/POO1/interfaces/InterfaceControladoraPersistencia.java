/*
 * Created on 25/05/2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package interfaces;
import java.util.Vector;
import Comandos.*;
/**
 * @author yury
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public interface InterfaceControladoraPersistencia {

	public int executeUpdate(ComandoSQL comandoSQL);
	
	public Vector executeQuery(ComandoSQL comandoSQL);
		
	public void shutDown();
}
