package InformacionContinua;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

	public static void main(String[] args) throws IOException {
		
		/**
		 *  El cliente envía el texto tecleado a el servidor. El servidor lo recibe y lo devuelve
		 *  de nuevo al cliente y es mostrado por pantalla. El cliente finaliza cuando se detiene 
		 *  la entrada de datos mediante las teclas CTRL-Z. El servidor finaliza cuando el cliente
		 *  termine de enviar datos o cuando reciba un *. 
		 */

		int numeroPuerto = 60000;
		ServerSocket servidor = new ServerSocket(numeroPuerto);
		System.out.println("Esperando conexión del cliente..........");
		Socket cliente = servidor.accept();
		System.out.println("Cliente conectado");
		
		//Se crea el flujo de salida al cliente
		PrintWriter flujoSalida = new PrintWriter(cliente.getOutputStream(), true);
		
		//Se crea el flujo de entrada del cliente
		BufferedReader flujoEntrada = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
		
		String cadena = "";
			while((cadena = flujoEntrada.readLine()) != null && !cadena.equals("*")){
				System.out.println("Recibiendo del cliente: " + cadena);
				flujoSalida.println(cadena);
			}
		System.out.println("Servidor finalizando...");
		
		//Cerramos el flujo de datos y los sockets
		flujoEntrada.close();
		flujoSalida.close();
		cliente.close();
		servidor.close();
		
	}

}
