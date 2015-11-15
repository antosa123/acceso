import java.io.Closeable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JOptionPane;

public class Almacen {
		
	public Almacen(){
		
	}
	
	//libro y nombre del fichero donde va a ser guardado
	public void Guardar(Libro l, String f){
		
		ObjectOutputStream out=null;
		
		try {
			out = new ObjectOutputStream(new FileOutputStream(f));
			out.writeObject(l);
		} catch (IOException e) {			
			e.printStackTrace();
		}finally{
			intentarCerrar(out);
		}
	}
	
	public Libro recuperar(String f) {
		Libro p = null;
        ObjectInputStream in=null;
        try {
            in = new ObjectInputStream(new FileInputStream(f));
            p = (Libro) in.readObject();            
        } catch (ClassNotFoundException ex) {
            System.err.println("Error de fichero");
        } catch (IOException ex) {
        	System.err.println("Error IO");
        }finally{
            intentarCerrar(in);
        }
        return p;
	}
	
	public void listaLibros(){
		ArrayList<Libro> libros;
		
		libros = new ArrayList<Libro>();
		
		Iterator it = libros.iterator();
		
		while(it.hasNext()){
			Libro l = (Libro) it.next();
			l.print();
		}
		
	}
	
	public void GuardarLista(ArrayList<Libro> libros,String s){
		
		ObjectOutputStream out=null;
		
		try {
			out = new ObjectOutputStream(new FileOutputStream(s));
			out.writeObject(libros);
		} catch (IOException e) {			
			e.printStackTrace();
		}finally{
			intentarCerrar(out);
		}
	}
	
	public ArrayList<Libro> recuperarLista(String d){
		ArrayList<Libro> libros = null;
        ObjectInputStream in=null;
        try {
            in = new ObjectInputStream(new FileInputStream(d));
            libros = (ArrayList<Libro>) in.readObject();            
        } catch (ClassNotFoundException ex) {
            System.err.println("Error de fichero");
        } catch (IOException ex) {
        	System.err.println("Error IO");
        }finally{
            intentarCerrar(in);
        }
        return libros;
		
	}
	
	/**
	 * 
	 * @param l
	 * @param titulo
	 * @param autor
	 * Este metodo sirve par amodificar el objeto l con el string titulo y autor
	 */
	public void modificar(Libro l,String titulo,String autor){
	
		l.setTitulo(titulo);
		l.setAutor(autor);
	}
	
	public void intentarCerrar(Closeable aCerrar) {
		try {
			if (aCerrar != null) {
				aCerrar.close();
			}
		} catch (IOException ex) {
			ex.printStackTrace(System.err);
		}
	}
	
}
