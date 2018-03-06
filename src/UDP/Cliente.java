package UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class Cliente {
	
	
	public static void main(String[] args) {
		
			// El cliente enviará un DATAGRAMA
		try {
			InetAddress direccionIp = InetAddress.getLocalHost();
			int puerto = 12345;
			
			// Los datos a enviar tendrán que transformarse en bytes
			byte[] mensaje = new byte[1024];
			
			String saludo = "Enviando un saludo";
			mensaje = saludo.getBytes();
			
			//construimos un objeto de la clase DatagramPacket para enviar el datagrama
			DatagramPacket envio = new DatagramPacket(mensaje, mensaje.length, direccionIp, puerto);
			
			//construimos un objeto de la clase DatagramSocket para hacer el envío
			DatagramSocket socket = new DatagramSocket(60000);
			
			System.out.println("Longitud del datagrama: " + mensaje.length);
			System.out.println("Host destino: " + direccionIp.getHostAddress());
			System.out.println("Nombre HOST: " + direccionIp.getHostName());
			System.out.println("Puerto local: " + socket.getLocalPort());
			System.out.println("Puerto destino: " + envio.getPort());
			
			socket.send(envio);
			
			//cerramos el socket
			socket.close();
			
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
	

}
