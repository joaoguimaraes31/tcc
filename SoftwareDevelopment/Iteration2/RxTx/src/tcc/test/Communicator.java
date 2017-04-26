package tcc.test;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.HashMap;

import gnu.io.CommPortIdentifier;
import gnu.io.PortInUseException;
import gnu.io.SerialPort;

public class Communicator {

	private static HashMap<CommPortIdentifier, String> portMap = new HashMap<CommPortIdentifier, String>();

	private static OutputStream outputStream;
	private static InputStream inStream;
	private static SerialPort serialPort = null;

	final static int TIMEOUT = 2000;

	// metodo que retorna as portas seriais connectadas ao computador
	public static CommPortIdentifier getPorts() {

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

	public static void connect() {

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

	public static void disconnect() {
		try {
			serialPort.removeEventListener();
			serialPort.close();
			System.out.println("Porta Serial: " + serialPort.getName() + " fechada com sucesso");

			System.out.println("Desconectado");
		} catch (Exception e) {
			System.out.println("Falha ao fechar porta: " + serialPort.getName() + "(" + e.toString() + ")");
		}
	}

	
	public static void main(String[] args) {
		connect();

		MyListener myListener = new MyListener(inStream);
		myListener.initListener(serialPort);
		
		while(serialPort.isRTS());
		disconnect();
	}

}