package tcc.test;

import java.io.InputStream;

import java.io.OutputStream;
import java.util.TooManyListenersException;

import gnu.io.SerialPort;
import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;


public class MyListener implements SerialPortEventListener {
	private InputStream inputStream;
	
	public MyListener(InputStream inputStream) {
		this.inputStream = inputStream;
	}

	public void initListener(SerialPort serialPort) {
		try {
			serialPort.addEventListener(this);
			serialPort.notifyOnDataAvailable(true);
		} catch (TooManyListenersException e) {
			// logText = "Too many listeners. (" + e.toString() + ")";

		}
	}

	@Override
	public void serialEvent(SerialPortEvent evt) {
		if (evt.getEventType() == SerialPortEvent.DATA_AVAILABLE) {
			try {
				byte singleData = (byte) inputStream.read();
				
				if (singleData != 10) {
					System.out.println(new String(new byte[] { singleData }));
				} else {
					System.out.println("EOF");
				}
			} catch (Exception e) {
				e.printStackTrace();

			}
		}
	}
	
}
