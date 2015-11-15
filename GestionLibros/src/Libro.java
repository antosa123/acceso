import java.io.Serializable;
import java.sql.Date;


public class Libro implements Serializable{
	private String titulo=null;
	private String autor=null;
	private int a�o=0;
	private String editor=null;
	private int paginas=0;
	
	public Libro(){
		
	}
	
	public Libro(String t,String au,int a,String e,int p){
		titulo = t;
		autor=au;
		a�o=a;
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

	public int getA�o() {
		return a�o;
	}

	public void setA�o(int a�o) {
		this.a�o = a�o;
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
		System.out.println("T�tulo: "+titulo+", Autor: "+autor+", A�o: "+a�o+", Editor: "+editor+", P�ginas: "+paginas);
	}
}
