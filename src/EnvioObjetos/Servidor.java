package EnvioObjetos;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

	/**
	 *   El servidor crea un objeto de la clase Persona y se lo envía al cliente. 
	 *   Este realiza cambios en el objeto y es devuelto modificado al servidor.
	 * @throws ClassNotFoundException 
	 */
	
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		
		 int numeroPuerto = 60000;
		 ServerSocket servidor = new ServerSocket(numeroPuerto);
		 System.out.println("Esperando al cliente....");
		 Socket cliente = servidor.accept();
		 
		 
		 //Preparamos el flujo de salida para el objeto
		 ObjectOutputStream objetoSalida = new ObjectOutputStream(cliente.getOutputStream());
		 Persona persona = new Persona("Ana", 25);
		 objetoSalida.writeObject(persona);
		 
		 System.out.println("Envío " + persona.getNombre() + ", edad: " + persona.getEdad());
		 
		 //Preparamos el flujo de entrada para el objeto
		 ObjectInputStream objetoEntrada = new ObjectInputStream(cliente.getInputStream());
		 Persona dato = (Persona) objetoEntrada.readObject();
		 
		 System.out.println("Recibo: " + dato.getNombre() + ", edad: " + dato.getEdad());
		 
		 //Cerramos los flujos y los sockets
		 objetoSalida.close();
		 objetoEntrada.close();
		 cliente.close();
		 servidor.close();
	}

}
