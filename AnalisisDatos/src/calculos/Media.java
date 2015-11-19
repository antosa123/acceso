package calculos;

public class Media extends Thread{
	
	static int[] numeros;
	
	public Media(int[] numeros){
		this.numeros=numeros;
		
	}
	
	//IMPORTANTE
	public void run(){
		mediaNumeros();
	}
	
	/**
	 * Calcular la media de los 100 primeros numeros reales
	 */
	public static void mediaNumeros(){
		int suma=0;
		int media=0;
		
		for (int i=0; i<numeros.length;i++){
			suma= suma+numeros[i];
			
		}
		
		media = suma/numeros.length;
		System.out.println("La media de los numeros es: "+media);
	}
}
