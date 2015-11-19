package threadpool;
				//si es threadpool se utiliza Runnable
public class Palindromo implements Runnable {
	String pa;
	
	public Palindromo(String palabras){
		this.pa=palabras;
		
	}
	
	public void ComprobarPalindromo(String palabra){
		//comprabar palabra por palabra
		if(palabra.equals(new StringBuilder(palabra).reverse().toString())){
			System.out.println(palabra+" es palindromo");
		}else{
			
			System.out.println(palabra+" NO ES PALINDROMO");
		}
		
	}
	
	public void run(){
		
		ComprobarPalindromo(pa);
		
	}
	
}
