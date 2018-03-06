package UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class Servidor {

	public static void main(String[] args) {
		
		
		//Declaraci�n un array de bytes para recibir el datagrama
		
		byte [] bufer = new byte [1024];
		
		/* Creamos un objeto de la clase DatagramSocket para poder definir el socket UDP que va a recibir informaci�n
		   asociandolo a un determinado puerto. Es a este puerto al que tendr�n que hacer refrencia los datagramas
		   que env�e el cliente. */
		
		try {
			DatagramSocket socket = new DatagramSocket(12345);
			System.out.println("Esperando el datagrama....");

			//Creamos un objeto para recibir el datagrama
			DatagramPacket recibo = new DatagramPacket(bufer, bufer.length);
			
			//Se recibe el datagrama
			socket.receive(recibo);
			
			//Se convierten los bytes recibidos al formato original de los datos
			String paquete = new String(recibo.getData());
			int bytesRecibidos = recibo.getLength();
			
			System.out.println("N�mero de bytes recibidos: " + bytesRecibidos);
			System.out.println("Mensaje recibido: " + paquete);
			
			
			//Podemos extraer el puerto y la direcci�n IP del datagrama recibido
			System.out.println("Puerto origen  del mensaje: " + recibo.getPort());
			System.out.println("Puerto destino del mensaje:" + socket.getLocalPort());
			System.out.println("Direcci�n IP cliente: " + recibo.getAddress());
			
			
			//cerramos el socket
			socket.close();
			
			
			
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
