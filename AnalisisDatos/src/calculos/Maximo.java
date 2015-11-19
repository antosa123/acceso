package calculos;

public class Maximo extends Thread{
	
	int[] numeros;
	
	public Maximo(int[] numeros){
		this.numeros=numeros;
	}
	
	public void run(){
		calcularMaximo();
	}
	
	public void calcularMaximo(){
		
		int max=0;
		
		
		for (int i = 0; i < numeros.length; i++) {
            
	        if(numeros[i]>max){
	            max=numeros[i];
	        }
		}
		
		System.out.println("Valor Máximo = "+max);
	}
	
}
