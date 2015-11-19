package threadpool;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class ThreadPool {
	
	public static void main(String[] args) {
		
		//creado array de strigs con 25 palabras
		String[] palabras = new String[]{"amor y roma","hola","soy","palindromo","agua","soleado","dos","teta",
		"adrian cari","seres","java"+"ana"+"mesa","cola","jamon y monja","peces","eme","cocacola","mensaje","adios"};
		
		//creo el threadpoolexecutor para gestionar el array palabras
							              //numero de threads que voy a gestionar--|
		ThreadPoolExecutor tpe = (ThreadPoolExecutor) Executors.newFixedThreadPool(3);
		
		//ejercutar el threadpool palabra por palabra
		for (int i=0;i<palabras.length;i++){
			Palindromo palindromo = new Palindromo(palabras[i]);
			tpe.execute(palindromo);
		}
		
		//cerrar el threadpool
		tpe.shutdown();

		
	}

}
