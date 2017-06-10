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
	private int samples = 0;
        final static int SPACE_ASCII = 32;
        final static int DASH_ASCII = 45;
        final static int NEW_LINE_ASCII = 10;
        final static int START_ACQ  = 43;   //+
        final static int STOP_ACQ = 44;     //,
        final static int MASTER_RESET = 46; //.
        
        
        

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

	public void initListener(int samples) {
		this.samples=samples;
		try {
			serialPort.addEventListener(this);
			serialPort.notifyOnDataAvailable(true);
		} catch (TooManyListenersException e) {

		}
	}
	
	
	public void serialEvent(SerialPortEvent evt) {
		if (evt.getEventType() == SerialPortEvent.DATA_AVAILABLE) {
			if(samples==0){
				try {
					System.out.println("Calling finalized");
                                        serialPort.removeEventListener();
					//disconnect();                                        
					this.finalize();
				} catch (Throwable e) {
					e.printStackTrace();
				}
			} else {
				try {
					byte singleData = (byte) inStream.read();
					if (singleData != 10) {
						System.out.println(new String(new byte[] { singleData }));
						//System.out.println(samples);
					} else {
						System.out.println("EOF");
					}
				} catch (Exception e) {
					e.printStackTrace();
	
				}
			}
		}
		samples--;

	}
        
        public void writeData(int leftThrottle)
       {
           try
           {
               outputStream.write(leftThrottle);
               outputStream.flush();
               //this is a delimiter for the data
               outputStream.write(DASH_ASCII);
               outputStream.flush();
/*
               outputStream.write(rightThrottle);
               outputStream.flush();
               //will be read as a byte so it is a space key
               outputStream.write(SPACE_ASCII);
               outputStream.flush();*/
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
        
        //getters and setters methods
	public int getSamples() {
		return samples;
	}

	public void setSamples(int samples) {
		this.samples = samples;
	}
	
	public boolean getIsConnected() {
		return isConnected;
	}

	public void setIsConnected(boolean IsConnected) {
		this.isConnected = isConnected;
	}

}