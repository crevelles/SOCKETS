package servidorVariosHilos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Hilo extends Thread {

	Socket socket;
	String cadena = "";
	int numeroPuerto = 60000;

	public Hilo(Socket socket) {
		this.socket = socket;
	}

	public void run() {

		// Se crea el flujo de salida al cliente
		try {
			PrintWriter flujoSalida = new PrintWriter(socket.getOutputStream(), true);
			//Se crea el flujo de entrada del cliente
			BufferedReader flujoEntrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String cadena = "";
			while((cadena = flujoEntrada.readLine()) != null && !cadena.equals("*")){
				System.out.println("Recibiendo del cliente: " + cadena);
				flujoSalida.println(cadena);
			}
		System.out.println("Servidor finalizando...");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		
	}

}
