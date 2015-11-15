import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JOptionPane;

public class ClasePrincipal {

	public static void main(String[] args) {
		Libro l1= new Libro("El amante Japonés","Isabel Allende",2015,"Plaza & Janes",352);
		Libro l2= new Libro("La chica del tren","Paula Hawkins",2015,"Planeta",496);
		Libro l3= new Libro("Cien años de soledad","Gracía Márquez",1967,"Alfaguara",471);
		Libro l4= new Libro();
		
	  /*l1.print();
		l2.print();
		l3.print();*/
			
		
		Almacen almacen = new Almacen();
		
		/*almacen.Guardar(l1, "ficheroAlmacen.dat");
		almacen.Guardar(l2, "ficheroAlmacen.dat");
		almacen.Guardar(l3, "ficheroAlmacen.dat");
		l4= almacen.recuperar("ficheroAlmacen.dat");
		l4.print();*/
		
		//
		almacen.listaLibros();
		String t = JOptionPane.showInputDialog("Cambia el titulo");
		String a = JOptionPane.showInputDialog("Cambia el autor");
		almacen.modificar(l1,t,a);
		//l1.print();
		
		
		//Crear lista, guardarla y recuperarla
		ArrayList<Libro> libros = new ArrayList<Libro>();
		ArrayList<Libro> listaRecuperada = new ArrayList<Libro>();
		
		libros.add(l1);
		libros.add(l2);
		libros.add(l3);
		
		almacen.GuardarLista(libros, "ficheroNuevo.dat");
		
		listaRecuperada = almacen.recuperarLista("ficheroNuevo.dat");
		
		
		Iterator it = listaRecuperada.iterator();
		
		while (it.hasNext()){
			Libro l=(Libro) it.next();
			l.print();
		}
		
		
		
	}
	

}
