package udp_2;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Cliente {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner teclado = new Scanner(System.in);
		
		
		String saludo = "";
			// El cliente enviará un DATAGRAMA
			try {
				InetAddress direccionIp = InetAddress.getLocalHost();
				int puerto = 12345;
	
				// Los datos a enviar tendrán que transformarse en bytes
				byte[] mensaje = new byte[1024];
				saludo = "";
	
				System.out.println("Introduce el mensaje: ");
				saludo = teclado.nextLine();
				mensaje = saludo.getBytes();
				// construimos un objeto de la clase DatagramPacket para enviar el datagrama
				DatagramPacket envio = new DatagramPacket(mensaje, mensaje.length, direccionIp, puerto);
	
				DatagramSocket socket = new DatagramSocket(6000);
	
				socket.send(envio);
				// ===============================================================================================
				DatagramPacket recibo = new DatagramPacket(mensaje, mensaje.length);
				socket.receive(recibo);
	
				// formatemod l paquete
				String paquete = new String(recibo.getData());
				System.out.println("Mensaje recibido " + paquete);
	
				socket.close();
	
				
	
			} catch (UnknownHostException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
	
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	}

}
