package streambytes;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JOptionPane;

public class StreamBytes {

	static FileInputStream f1 = null;
	static FileOutputStream f2 = null;
	static String fichero, ficheroD;

	public static void main(String[] args) {
		//llamada al metodo para abrir el fichero
		abrirFichero();
		try {
			copiaBytes(f1, f2);
		} catch (IOException e) {

			e.printStackTrace();
		}

		try {
			f1.close();
			f2.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	
	/**
	 * 
	 * @param f1
	 * @param f2
	 * @throws IOException
	 * Metodo que copia los bytes de los files de entrada al de salida
	 */
	public static void copiaBytes(FileInputStream f1, FileOutputStream f2) throws IOException {

		try {
			int byte_actual = f1.read();
			while (byte_actual != -1) {
				f2.write(byte_actual);
				byte_actual = f1.read();
			}
			
			File file = new File(fichero);
			System.out.println(fichero+", "+file.length()+" Bytes");
			
			File file2 = new File(ficheroD);
			System.out.println(ficheroD+", "+file.length()+" Bytes");
				
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}
	
	/**
	 * Metodo para controlar que se han abierto los ficheros
	 */
	public static void abrirFichero() {

		boolean correcto = false;

		while(correcto == false) {

			try {
				
				fichero = JOptionPane.showInputDialog("Escribe el nombre del fichero de origen: ");
				File f = new File(fichero);
				
				//ERROR le tengo que pasar la primera vez "lena.jpg"
				//Le paso el fichero
				f1 = new FileInputStream(f);
				
				ficheroD = JOptionPane.showInputDialog("Escribe el nombre del fichero de destino: ");
				File fi = new File(ficheroD);
				
				if(fi.exists()){
					//volver a preguntar
					ficheroD = JOptionPane.showInputDialog("Escribe otro nombre para el fichero de destino: ");
					fi = new File(ficheroD);
				}
									
				
				f2 = new FileOutputStream(fi);
				
				correcto = true;
			} catch (Exception e) {
				JOptionPane.getRootFrame().dispose();
				System.err.println("Ha habido un error");
			}
		}

	}

}
