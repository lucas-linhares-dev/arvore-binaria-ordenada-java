import java.util.Iterator;
import java.util.TreeSet;
import java.util.Random;

public class Teste {
	
	public static String imprimeLista(TreeSet arvore){
	    Iterator<Integer> i = arvore.iterator();
	    while (i.hasNext()){
	        System.out.println(i.next() + " ");
	    }
	    return("");
	}
	
	
	public static void main(String[] args) {
		TreeSet<Integer> arvoreJava = new TreeSet<>();
		ArvoreBinariaOrdenada<Integer> minhaArvore = new ArvoreBinariaOrdenada<>();
		Random gerador = new Random();
		
		long tInicialArvoreJava = System.currentTimeMillis();
		
		for(int i = 0 ; i < 1000000 ; i++) {
			arvoreJava.add(gerador.nextInt());
		}
		
		long tFinalArvoreJava = System.currentTimeMillis();
		
		long tInicialMinhaArvore = System.currentTimeMillis();
		
		for(int i = 0 ; i < 1000000 ; i++) {
			minhaArvore.adicionar(gerador.nextInt());
		}
		
		long tFinalMinhaArvore = System.currentTimeMillis();
		
		
		System.out.println("Inser��o de UM MILH�O de elementos.");
		
		System.out.println("Tempo Treeset do java: "+(tFinalArvoreJava - tInicialArvoreJava));
		
		System.out.println("Tempo minha �rvore: "+(tFinalMinhaArvore - tInicialMinhaArvore));
		
		System.out.println();
		
		System.out.println("Minha �rvore sempre ganha :)");
	}

}
