/*
 * Created on 19/04/2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package telas;
import java.awt.*;
import javax.swing.*;

/**
 * @author yury
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class Janela extends JFrame {
	
	public Janela(String titulo, Dimension tamanho){
	
	setTitle(titulo);
	setSize(tamanho);
	centralize();
	
	}
	
	public void centralize(){
		
		Dimension T = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension J = getSize();
		if (J.height>T.height) setSize(J.width,T.height);
		if (J.width>T.width) setSize(T.width,J.height);
		setLocation((T.width-J.width)/2,(T.height-J.height)/2);
	}
	
}

