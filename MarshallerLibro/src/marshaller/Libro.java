package marshaller;

import java.io.Serializable;

public class Libro implements Serializable{
	private String titulo=null;
	private String autor=null;
	private int anio=0;
	private String editor=null;
	private int paginas=0;
	
	public Libro(){
		
	}
	
	public Libro(String t,String au,int a,String e,int p){
		titulo = t;
		autor=au;
		anio=a;
		editor=e;
		paginas=p;
		
	}

	//
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		if (titulo!="" && titulo!=null){
			this.titulo=titulo;
		}
	}

	//
	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		if (autor!="" && autor!=null){
			this.autor=autor;
		}
	}

	public int getAnio() {
		return anio;
	}

	public void setAnio(int año) {
		this.anio = año;
	}

	public String getEditor() {
		return editor;
	}

	public void setEditor(String editor) {
		this.editor = editor;
	}

	public int getPaginas() {
		return paginas;
	}

	public void setPaginas(int paginas) {
		this.paginas = paginas;
	}
	
	public void print(){
		System.out.println("Título: "+titulo+", Autor: "+autor+", Año: "+anio+", Editor: "+editor+", Páginas: "+paginas);
	}
}
