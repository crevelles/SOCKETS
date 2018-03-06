package udp_2;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class Servidor {

	public static void main(String[] args) throws UnknownHostException {

		/*
		 * El programa cliente envía un texto al servidor. Este lee el datagrama y
		 * devuelve al cliente el texto en MAYUSCULAS. El cliente recibe la información
		 * y la muestra en pantalla, IP, puerto del datagrama. El servidor seguirá
		 * ejecutandose esperando la conexión de futuros clientes. Finalizará cuando un
		 * cliente envíe un *.
		 */

		DatagramSocket socket = null;
		byte[] bufer = null;

		DatagramPacket recibo = null;
		InetAddress direccion = null;

		DatagramPacket envio = null;

		String paquete = "";

		do {

			try {
				socket = new DatagramSocket(12345);
				direccion = InetAddress.getLocalHost();
				bufer = new byte[1024];
				recibo = new DatagramPacket(bufer, bufer.length);
				socket.receive(recibo);
				paquete = new String(recibo.getData()).toUpperCase();

				// ==============================================================================
				// Lo enviamos
				bufer = paquete.getBytes();
				envio = new DatagramPacket(bufer, bufer.length, direccion, recibo.getPort());
				socket.send(envio);

			} catch (SocketException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			socket.close();

		} while (!paquete.trim().equals("*"));
	}

}
