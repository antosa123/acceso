package marshaller;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

public class Marshaller {

	private Document dom = null;// definir el documento
	private ArrayList<Libro> libros = null;

	public Marshaller(ArrayList<Libro> l) {
		libros = l;
	}

	public void crearDocumento() {
		// creamos una factory
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		try {
			// creamos un documentbuilder
			DocumentBuilder db = dbf.newDocumentBuilder();

			// creamos una instancia de DOM
			dom = db.newDocument();
		} catch (ParserConfigurationException pce) {
			pce.printStackTrace();
		}

	}

	public void crearArbolDOM() {

		// creamos el elemento raíz "libros"
		Element docEle = dom.createElement("libros");
		dom.appendChild(docEle);// lo añadimos al document

		// recorremos
		Iterator it = libros.iterator();
		while (it.hasNext()) {
			Libro e = (Libro) it.next();
			// para cada objeto libro creamos el elemento <libro> y lo añadimos
			// a la raíz
			Element libroEle = setLibro(e);
			docEle.appendChild(libroEle);
		}

	}

	private Element setLibro(Libro l) {

		// creamos el elemento libro
		Element libroEle = dom.createElement("libro");

		// creamos el elemento nombre y el nodo de texto y lo añadimos al
		// elemento libro
		Element nombreEle = dom.createElement("titulo");
		Text nombreTexto = dom.createTextNode(l.getTitulo());
		nombreEle.appendChild(nombreTexto);
		libroEle.appendChild(nombreEle);

		// creamos el elemento autor y el nodo de valor de texto y lo añadimos
		// al elemento libro
		String nombresAutor = l.getAutor();
		
		String[] nomsAutor = nombresAutor.split(" ");
		
		Element autorEle = dom.createElement("autor");
		
		//recorro el array y creo un elemento con la etiqueta nombre
		//con su contenido 
		for (int i=0;i<nomsAutor.length;i++){
			Element autorNombre = dom.createElement("nombre");
			Text nombresTexto = dom.createTextNode(nomsAutor[i]);
			autorNombre.appendChild(nombresTexto);
			autorEle.appendChild(autorNombre);
		}
		libroEle.appendChild(autorEle);
		

		// creamos el elemento año y el nodo de valor entero y lo añadimos
		// al elemento libro
		Attr atributo = dom.createAttribute("anyo");
		String anyo = Integer.toString(l.getAnio());
		Text anio = dom.createTextNode(anyo);
		//añado al atributo el texto
		atributo.appendChild(anio);
		//establecer atributos
		libroEle.setAttributeNode(atributo);
		


		// creamos el elemento autor y el nodo de valor de texto y lo añadimos
		// al elemento libro
		Element editorEle = dom.createElement("editor");
		Text editorTexto = dom.createTextNode(l.getEditor());
		editorEle.appendChild(editorTexto);
		libroEle.appendChild(editorEle);

		// creamos el elemento paginas y el nodo de valor entero y lo añadimos
		// al elemento libro
		Element edadEle = dom.createElement("paginas");
		Text paginasTexto = dom.createTextNode(Integer.toString(l.getPaginas()));
		edadEle.appendChild(paginasTexto);
		libroEle.appendChild(edadEle);

		return libroEle;
	}
	

	public void escribirDocumentAXml(File file) throws TransformerException {

		// creamos una instacia para escribir el resultado
		Transformer trans = TransformerFactory.newInstance().newTransformer();
		trans.setOutputProperty(OutputKeys.INDENT, "yes");// se ha añadido una propiedad que contemple los saltos de linea

		// especificamos dónde escribimos y la fuente de datos
		StreamResult result = new StreamResult(file);
		DOMSource source = new DOMSource(dom);
		trans.transform(source, result);
					//fuente, destino del dom

	}
}
