package servidorVariosHilos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Cliente {
	
	public static void main(String[] args) throws IOException {
		String host = "localhost";
		int puerto = 60000;
		
		Socket cliente = new Socket(host, puerto);
		
		//Se crea el flujo de salida hacia el servidor
		PrintWriter flujoSalida = new PrintWriter(cliente.getOutputStream(), true);
		
		//Se crea el flujo de entrada hacia el servidor
		BufferedReader flujoEntrada = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("Introduce una cadena: ");
		String cadena = in.readLine();
		String eco;
		while(cadena != null && !cadena.equals("*")){
			flujoSalida.println(cadena);
			eco = flujoEntrada.readLine();
			System.out.println("ECO ==> " + eco);
			System.out.println("Introduce cadena: ");
			cadena = in.readLine();
		}
		
		System.out.println("Finalizando cliente....");

	}

}
