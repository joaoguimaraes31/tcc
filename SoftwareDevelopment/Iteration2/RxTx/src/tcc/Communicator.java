package tcc;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.TooManyListenersException;

import gnu.io.CommPortIdentifier;
import gnu.io.PortInUseException;
import gnu.io.SerialPort;
import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;

public class Communicator implements SerialPortEventListener {

	private HashMap<CommPortIdentifier, String> portMap = new HashMap<CommPortIdentifier, String>();

	private OutputStream outputStream;
	private InputStream inStream;
	private SerialPort serialPort = null;
	final int TIMEOUT = 2000;
	private int samples = 0;

	// metodo que retorna as portas seriais connectadas ao computador
	public CommPortIdentifier getPorts() {

		CommPortIdentifier serialPortId = null;
		Enumeration<CommPortIdentifier> ports = CommPortIdentifier.getPortIdentifiers();

		while (ports.hasMoreElements()) {
			serialPortId = (CommPortIdentifier) ports.nextElement();

			// Preenchendo a lista de portas
			if (serialPortId.getPortType() == CommPortIdentifier.PORT_SERIAL) {
				portMap.put(serialPortId, serialPortId.getName());
				System.out.println(serialPortId.getName());
			}
		}

		return serialPortId;

	}

	public void connect() {

		try {

			// Obtendo identificador para porta
			CommPortIdentifier portId = CommPortIdentifier.getPortIdentifier(getPorts().getName());

			// Abrindo porta
			serialPort = (SerialPort) portId.open("Demo application", TIMEOUT);

			System.out.println("Porta Serial: " + portId.getName() + " aberta com sucesso");

			// Configurando parametros da porta
			serialPort.setSerialPortParams(9600, SerialPort.DATABITS_8, SerialPort.STOPBITS_1, SerialPort.PARITY_NONE);

			outputStream = serialPort.getOutputStream();
			inStream = serialPort.getInputStream();

		} catch (PortInUseException e) {
			// System.out.println("Porta Serial" + portId.getName() + " esta em
			// uso (" + e.toString() + ")");
		} catch (Exception e) {
			System.out.println("Falha ao tentar abrir porta Serial (" + e.toString() + ")");
		}
	}

	public void disconnect() {
		try {
			serialPort.removeEventListener();
			serialPort.close();
			System.out.println("Porta Serial: " + serialPort.getName() + " fechada com sucesso");

			System.out.println("Desconectado");
		} catch (Exception e) {
			System.out.println("Falha ao fechar porta: " + serialPort.getName() + "(" + e.toString() + ")");
		}
	}

	public void initListener(int samples) {
		this.samples=samples;
		try {
			serialPort.addEventListener(this);
			serialPort.notifyOnDataAvailable(true);
		} catch (TooManyListenersException e) {
			// logText = "Too many listeners. (" + e.toString() + ")";

		}
	}
	
	
	public void serialEvent(SerialPortEvent evt) {
		if (evt.getEventType() == SerialPortEvent.DATA_AVAILABLE) {
			if(samples==0){
				try {
					System.out.println("Calling finalized");
					disconnect();
					this.finalize();
				} catch (Throwable e) {
					e.printStackTrace();
				}
			} else {
				try {
					byte singleData = (byte) inStream.read();
					if (singleData != 10) {
						System.out.println(new String(new byte[] { singleData }));
						System.out.println(samples);
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

	public int getSamples() {
		return samples;
	}

	public void setSamples(int samples) {
		this.samples = samples;
	}
	
	

}