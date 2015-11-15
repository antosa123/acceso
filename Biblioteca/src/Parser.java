import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Parser {
	private Document dom = null;
	private ArrayList<Libro> libros = null;

	public Parser() {
		libros = new ArrayList<Libro>();
	}

	public void parseFicheroXml(String fichero) {
		// creamos una factory
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

		try {
			// creamos un documentbuilder
			DocumentBuilder db = dbf.newDocumentBuilder();

			// parseamos el XML y obtenemos una representación DOM
			dom = db.parse(fichero);
		} catch (ParserConfigurationException pce) {
			pce.printStackTrace();
		} catch (SAXException se) {
			se.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}

	}

	public void parseDocument() {
		// obtenemos el elemento raíz
		Element docEle = dom.getDocumentElement();

		// obtenemos el nodelist de elementos
		NodeList nl = docEle.getElementsByTagName("libro");
		if (nl != null && nl.getLength() > 0) {
			for (int i = 0; i < nl.getLength(); i++) {

				// obtenemos un elemento de la lista (libro)
				Element el = (Element) nl.item(i);

				// obtenemos una persona
				Libro l = getLibro(el);

				// lo añadimos al array
				libros.add(l);
			}
		}
	}

	private Libro getLibro(Element LibroEle) {

		// para cada elemento libro, obtenemos su titulo, autor, año, paginas,
		// editorial
		String titulo = getTextValue(LibroEle, "titulo");
		String editor = getTextValue(LibroEle, "editor");
		int paginas = getIntValue(LibroEle, "paginas");

		// Conseguimos el atributo "anyo" de la etiqueta titulo
		// Repasar
		int anio = getAnyo(LibroEle, "titulo");

		// Conseguimos el autor, o los autores si hay varias etiquetas
		String autor = getTextAutor(LibroEle);

		// Creamos una nueva libro con los elementos leídos del nodo
		Libro e = new Libro(titulo, autor, anio, editor, paginas);
		return e;
	}

	private String getTextValue(Element ele, String tagName) {
		String textVal = null;
		// creacion de la lista de nodos
		// el elemento tiene las posiciones de la lista de nodos
		// coge la etiqueta del elemento
		NodeList nl = ele.getElementsByTagName(tagName);

		if (nl != null && nl.getLength() > 0) {
			Element el = (Element) nl.item(0);
			textVal = el.getFirstChild().getNodeValue();

			// comparo si el tagname es titulo y entonces obtengo su atributo
			if (tagName.compareTo("titulo") == 0)
				// System.out.println("año
				// "+el.getAttributeNode("anyo").getValue());
				el.getAttribute("anyo");
		}

		return textVal;
	}

	private int getAnyo(Element ele, String tagName) {
		String textVal = null;
		// creacion de la lista de nodos
		// el elemento tiene las posiciones de la lista de nodos
		// coge la etiqueta del elemento
		NodeList nl = ele.getElementsByTagName(tagName);

		if (nl != null && nl.getLength() > 0) {
			Element el = (Element) nl.item(0);

			// comparo si el tagname es titulo y entonces obtengo su atributo
			if (tagName.compareTo("titulo") == 0)
				textVal = el.getAttributeNode("anyo").getValue();

		}

		return Integer.parseInt(textVal);
	}

	public String[] getNombres(Element element) {
		String[] nombres = null;
		NodeList node = element.getElementsByTagName("nombre");
		for (int i = 0; i < node.getLength(); i++) {
			element = (Element) node.item(i);
			nombres[i] = element.getTextContent();
			// System.out.println(element.getTextContent());
		}

		return nombres;
	}

	public String getTextAutor(Element element) {

		// Conseguimos todos los nodos con la etiqueta autor
		NodeList nodo = element.getElementsByTagName("autor");

		// Aqui guardare el nombre del autor ya completo
		String nombreAutor = "";
		// Defino un elemento
		Element nombre;

		if (nodo != null && nodo.getLength() > 0) {
			for (int i = 0; i < nodo.getLength(); i++) {
				// Consigo el autor
				element = (Element) nodo.item(i);
				// busca lo que hay dentro
				nombreAutor = getNombreAutor(element);
			}

		}
		return nombreAutor;
	}

	public String getNombreAutor(Element element) {

		NodeList nodosNombre = element.getElementsByTagName("nombre");

		String nombreAutor = "";
		for (int j = 0; j < nodosNombre.getLength(); j++) {
			// Consigo el nombre
			element = (Element) nodosNombre.item(j);

			// Voy concatenando todos los nombres que me vaya devolviento el
			// bucle
			nombreAutor = nombreAutor + " " + element.getTextContent();
		}
		// Devuelvo los nombres concatenados
		return nombreAutor;
	}

	private int getIntValue(Element ele, String tagName) {
		return Integer.parseInt(getTextValue(ele, tagName));
	}

	public void print() {

		Iterator it = libros.iterator();
		while (it.hasNext()) {
			Libro l = (Libro) it.next();
			l.print();
		}
	}

}
