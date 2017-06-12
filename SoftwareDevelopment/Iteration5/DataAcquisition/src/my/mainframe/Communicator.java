package my.mainframe;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.TooManyListenersException;

import gnu.io.*;
import java.awt.Color;
import java.io.IOException;

import gnu.io.CommPortIdentifier;
import gnu.io.PortInUseException;
import gnu.io.SerialPort;
import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;
import java.awt.Component;
import javax.swing.JOptionPane;



public class Communicator implements SerialPortEventListener {

	//for containing the ports that will be found
        private Enumeration ports = null;
        //map the port names to CommPortIdentifiers
        private HashMap portMap = new HashMap();

        //this is the object that contains the opened port
        private CommPortIdentifier portId = null;
        private SerialPort serialPort = null;
        
        //Flag for connection status
        boolean isConnected = false;
        boolean connectionError = false;
        
        
	private OutputStream outputStream;
	private InputStream inStream;
        

	final int TIMEOUT = 2000;
        
        //hardware flags
        final int MASTER_RESET = 43;

	// metodo que retorna as portas seriais connectadas ao computador
	public void searchForPorts()
        {   
            ports = CommPortIdentifier.getPortIdentifiers();
            portMap.clear();
            
            
            while (ports.hasMoreElements())
            {
                CommPortIdentifier curPort = (CommPortIdentifier)ports.nextElement();
                
                
                //get only serial ports
                if (curPort.getPortType() == CommPortIdentifier.PORT_SERIAL)
                {
                    portMap.put(curPort.getName(), curPort);
                }
            }
        }
        
        public String[] getPortMapValues(){
            searchForPorts();
            String [] portNames = new String[portMap.size()];
            
            int i = 0;
            for(Object port : portMap.values().toArray()) {
                portNames[i] = ((CommPortIdentifier)port).getName();
            }
            
            return portNames;
        }
        

	public void connect(String selectedPort) {

		try {
			// Obtaining port identifier using data from GUI
			searchForPorts();
                        portId = (CommPortIdentifier)portMap.get(selectedPort);
                        
			//Opening port
                        if (portId!=null){
                            serialPort = (SerialPort) portId.open("Demo application", TIMEOUT);
                        
                            //Msg to user
                            Component frame = null;
                            JOptionPane.showMessageDialog(frame,"Connection Sucessful!");
                            //System.out.println("Serial Port: " + serialPort.getName() + " opened sucessfully");
                            //System.out.println("Connected");

                            //Setting connection FLAG
                            isConnected = true;

                            // Configuring port parameters
                            serialPort.setSerialPortParams(9600, SerialPort.DATABITS_8, SerialPort.STOPBITS_1, SerialPort.PARITY_NONE);

                            outputStream = serialPort.getOutputStream();
                            inStream = serialPort.getInputStream();
                        }else{
                            Component frame = null;
                            JOptionPane.showMessageDialog(frame,"Could not connect to desired serial port!"+ System.lineSeparator() +"Please check connections.","Connection ERROR",JOptionPane.ERROR_MESSAGE);
			
                        }
		} catch (PortInUseException e) {
                        Component frame = null;			
                        JOptionPane.showMessageDialog(frame,"Could not connect to desired serial port!"+ System.lineSeparator() +"Port already being used.","Connection ERROR",JOptionPane.ERROR_MESSAGE);
                        //System.out.println("Serial port already in use" + e.toString() + ")");
                } catch (Exception e) {
                        Component frame = null;
                        JOptionPane.showMessageDialog(frame,"Could not connect to desired serial port!"+ System.lineSeparator() +"Please check connections.","Connection ERROR",JOptionPane.ERROR_MESSAGE);
			//System.out.println("Could not connect to desired serial port!" + e.toString() + ")");
		}
	}

	public void disconnect() {
		try {
                        System.out.println();
                        if (!connectionError){
                            writeData(MASTER_RESET);
                        }
                        connectionError=false;
			serialPort.removeEventListener();
			serialPort.close();
                        Component frame = null;
                        JOptionPane.showMessageDialog(frame,"Port disconnection sucessfull!");
			//System.out.println("Serial Port: " + serialPort.getName() + " closed sucessfully");
                        isConnected = false;

			//System.out.println("Disconnected");
		} catch (Exception e) {
                        Component frame = null;
                        JOptionPane.showMessageDialog(frame,"Could not disconnect to serial port!","Connection ERROR",JOptionPane.ERROR_MESSAGE);
			//System.out.println("Fail to close serial port");
		} 
	}

	public void initListener() {
		try {
			serialPort.addEventListener(this);
			serialPort.notifyOnDataAvailable(true);
		} catch (TooManyListenersException e) {

		}
	}
	
	
	public void serialEvent(SerialPortEvent evt) {
		if (evt.getEventType() == SerialPortEvent.DATA_AVAILABLE) {
                    try {
                        byte singleData = (byte) inStream.read();                                    
                        if (singleData!=46){
                            System.out.print(new String(new byte[] { singleData }));
                        }else{
                            System.out.println(" ");
                        }
                    } catch (Exception e) {
			e.printStackTrace();
			}
		}

	}
        
        public void writeData(int leftThrottle)
       {
           try
           {
               outputStream.write(leftThrottle);
               outputStream.flush();
           }
           catch (Exception e)
           {
                Component frame = null;
                JOptionPane.showMessageDialog(frame,"Could not write to the serial port!","Connection ERROR",JOptionPane.ERROR_MESSAGE);
                JOptionPane.showMessageDialog(frame,"Disconnection Eminent!","Connection Status",JOptionPane.WARNING_MESSAGE);
                connectionError=true;
                disconnect();
                
            }
        }
        
	
	public boolean getIsConnected() {
		return isConnected;
	}

	public void setIsConnected(boolean IsConnected) {
		this.isConnected = isConnected;
	}

}