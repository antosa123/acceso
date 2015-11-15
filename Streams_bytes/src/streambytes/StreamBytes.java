package streambytes;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class StreamBytes {

	static FileInputStream f1 = null;
	static FileOutputStream f2 = null;

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

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}
	
	/**
	 * Metodo para controlar que se han abierto los ficheros
	 */
	public static void abrirFichero() {

		boolean correcto = false;

		while (correcto == false) {

			try {

				f1 = new FileInputStream("lena.jpg");
				f2 = new FileOutputStream("fichero.jpg");
				correcto = true;
			} catch (Exception e) {
				System.err.println("Ha habido un error");
			}
		}

	}

}
