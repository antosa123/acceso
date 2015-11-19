package calculos;

public class Minimo extends Thread {
		int[] numeros;
		
		public Minimo(int[] numeros){
			this.numeros=numeros;
		}
		
		public void run(){
			calcularMinimo();
		}
		
		public void calcularMinimo(){
			int min = 0;
			
			for (int i = 0; i < numeros.length; i++) {
				if(numeros[i]<min){
		        	min=numeros[i];   
		        }
			}
			
			System.out.println("Valor Mínimo = "+min);
		}
}
