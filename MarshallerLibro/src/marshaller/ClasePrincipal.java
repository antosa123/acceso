package marshaller;

import java.io.File;
import java.util.ArrayList;

import javax.xml.transform.TransformerException;

public class ClasePrincipal {

	public static void main(String[] args) {
		ArrayList<Libro> libros;
		
		String[] nombres = null;

		// cargamos los datos
		libros = new ArrayList<Libro>();
		libros.add(new Libro("Introduction to Linux","Machtelt Garrels",2008,"O'Reilly",256));
		libros.add(new Libro ("El lenguaje de programación C","Kernighan Ritchie",1991,"Prentice Hall",294));
		
		Marshaller marshaller = new Marshaller(libros);
		
		marshaller.crearDocumento();
		marshaller.crearArbolDOM();
		
		//cambiar del formato DOM al XML
		File file = new File("libros.xml");
		
		try {
			marshaller.escribirDocumentAXml(file);
		} catch (TransformerException e) {			
			e.printStackTrace();
		}

	}


}
