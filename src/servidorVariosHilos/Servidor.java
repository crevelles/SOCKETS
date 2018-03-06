package servidorVariosHilos;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		
		int numeroPuerto = 60000;
		ServerSocket servidor = new ServerSocket(numeroPuerto);
		
		
		while(true) {
			System.out.println("Esperando conexión del cliente..........");
			Socket cliente = servidor.accept();
			Hilo hilo = new Hilo(cliente);
			hilo.start();
		}
		
	}
	
	

}
