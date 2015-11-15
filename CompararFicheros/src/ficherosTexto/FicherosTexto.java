package ficherosTexto;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JOptionPane;

public class FicherosTexto {

	public static void main(String[] args) {
		// crear ficheros
		File f1 = new File("fichero1.txt");
		File f2 = new File("fichero2.txt");

		// llamada al metodo comparar
		 try {
			System.out.println(compararContenido(f1,f2));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 
		

		/*String palabra = JOptionPane.showInputDialog("Escribe la palabra que buscas");
		File fichero1 = new File("fichero1.txt");
		boolean primera_aparicion = false;

		try {
			System.out.println(buscarPalabra(fichero1, palabra, primera_aparicion));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/

	}

	@SuppressWarnings({})
	public static boolean compararContenido(File fichero1, File fichero2) throws IOException {
		// declaramos variable booleana e inicializamos
		boolean b = true;
		
		FileReader fR1 = new FileReader(fichero1);
		FileReader fR2 = new FileReader(fichero2);

		BufferedReader r1 = new BufferedReader(fR1);
		BufferedReader r2 = new BufferedReader(fR2);

		String str;
		String st;

		// lectura de los archivos y comparacion de los mismos
		
		while (((str = r1.readLine()) != null) && ((st = r2.readLine()) != null)) {
			if (str.equals(st)) {
				//System.out.println("igual");
				b = true;
			} else {
				//System.out.println("diferente");
				b = false;
			}
		}
		// cerrar los buffered
		r1.close();
		r2.close();

		return b;

	}

	public static int buscarPalabra(File fichero, String palabra, boolean primera_aparicion) throws IOException {

		// contador
		int linea = 0;

		boolean p_a = false;

		// leo una linea y miro si en esa linea esta la palabra que he
		// introducido si no paso a la siguiente
		// si esta dos veces compruebo el boolean si es true primera si es false
		// al ultima

		FileReader fR1 = new FileReader(fichero);
		BufferedReader r1 = new BufferedReader(fR1);


		String str;
		int ultimaLinea = -1;
		
		if (primera_aparicion == true) {
			while ((str = r1.readLine()) != null && p_a == false) {

				if (str.equals(palabra)) {
					ultimaLinea = linea;
					p_a = true;

				} else {
					p_a = false;
				}

			}
			r1.close();
			return ultimaLinea;
		} else {
			while ((str = r1.readLine()) != null) {
				linea = linea + 1;

				if (str.equals(palabra)) {
					ultimaLinea = linea;
				}

			}

			r1.close();
			return ultimaLinea;
		}
	}
}