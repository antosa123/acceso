package calculos;

import java.util.Random;

public class Main {
	static int[] numeros;
	static Random random;
	
	public static void main(String[] args) {
		numeros = new int[100];
		generarNumeros();
		
		//creo un objeto de cada clase
		Media media = new Media(getNumeros());
		Maximo max = new Maximo(getNumeros());
		Minimo min = new Minimo(getNumeros());
		
		
		
		try {
			//para que empiece el thread
			media.start();
			//para que se lancen de manera ordenada, para que espere al anterior para lanzarse
			media.join();
			
			max.start();
			max.join();
			
			min.start();
			min.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	

	}
	
	public static int[] getNumeros() {
		return numeros;
	}

	/**
	 * 
	 * @return array 
	 * Generados numero aleatorios entre 0 y 100
	 */
	public static void generarNumeros() {
		random = new Random();

		int n = 0;

		for (int i = 0; i < numeros.length; i++) // generamos 100 números
		{
			numeros[i] = (int) (random.nextDouble() * 100.0); // generamos numeros aleatorios entre 0 y 100
			System.out.println(numeros[i]);
		}
	}

}
