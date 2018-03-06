package EnvioObjetos;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Cliente {

	public static void main(String[] args) throws UnknownHostException, IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		
		String host = "localhost";
		int puerto = 60000;
		
		
		System.out.println("Programa cliente iniciado...");
		Socket cliente = new Socket(host, puerto);
		
		//Preparamos el flujo de entrada para el objeto
		ObjectInputStream ois = new ObjectInputStream(cliente.getInputStream());
		
		//Recibimos el objeto
		Persona persona = (Persona)ois.readObject();
		System.out.println("Objeto recibido: " + persona.getNombre() + ", edad: " + persona.getEdad());
		System.out.println("Modificamos el objeto.....");
		persona.setNombre("Paco");
		persona.setEdad(39);
		
		//Preparamos el flujo de salida para el objeto
		ObjectOutputStream ous = new ObjectOutputStream(cliente.getOutputStream());
		ous.writeObject(persona);
		
		System.out.println("El objeto " + persona.getNombre() + ", edad: " + persona.getEdad());
		
		//cerramos el flujo
		ois.close();
		ous.close();
		
		cliente.close();

	}

}
