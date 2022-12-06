import java.util.Random;

public class Teste {

	public static void main(String[] args) {
		ArvoreBinariaOrdenada<Integer> arvore = new ArvoreBinariaOrdenada<Integer>();
		Random gerador = new Random();
		
		long tempoInicial = System.currentTimeMillis();
		
		for(int i = 0 ; i < 1000000 ; i++) {
			arvore.adicionar(gerador.nextInt());
		}
	    
	    long tempoFinal = System.currentTimeMillis();
	    
	    System.out.println("Tempo de execução: "+(tempoFinal-tempoInicial));
	    

	}

}
