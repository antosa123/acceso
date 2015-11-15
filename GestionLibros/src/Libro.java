import java.io.Serializable;
import java.sql.Date;


public class Libro implements Serializable{
	private String titulo=null;
	private String autor=null;
	private int año=0;
	private String editor=null;
	private int paginas=0;
	
	public Libro(){
		
	}
	
	public Libro(String t,String au,int a,String e,int p){
		titulo = t;
		autor=au;
		año=a;
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

	public int getAño() {
		return año;
	}

	public void setAño(int año) {
		this.año = año;
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
		System.out.println("Título: "+titulo+", Autor: "+autor+", Año: "+año+", Editor: "+editor+", Páginas: "+paginas);
	}
}
