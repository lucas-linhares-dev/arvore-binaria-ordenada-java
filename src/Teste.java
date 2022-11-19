
public class Teste {

	public static void main(String[] args) {
		ArvoreBinariaOrdenada<Integer> arvore = new ArvoreBinariaOrdenada<Integer>();
		arvore.adicionar(10);
	    arvore.adicionar(8);
	    arvore.adicionar(5);
	    arvore.adicionar(9);
	    arvore.adicionar(7);
	    arvore.adicionar(18);
	    arvore.adicionar(13);
	    arvore.adicionar(20);
	    
	    System.out.println("Em ordem: ");
	    arvore.imprimirEmOrdem(arvore.getRaiz());
	    
	    arvore.remover(20);
	    
	    System.out.println("Em ordem: ");
	    arvore.imprimirEmOrdem(arvore.getRaiz());
	    
	    arvore.remover(5);
	    
	    System.out.println("Em ordem: ");
	    arvore.imprimirEmOrdem(arvore.getRaiz());
	    
	    arvore.remover(8);
	    
	    System.out.println("Em ordem: ");
	    arvore.imprimirEmOrdem(arvore.getRaiz());
	    
	    arvore.remover(9);
	    
	    System.out.println("Em ordem: ");
	    arvore.imprimirEmOrdem(arvore.getRaiz());
	    
	    arvore.remover(10);
	    
	    System.out.println("Em ordem: ");
	    arvore.imprimirEmOrdem(arvore.getRaiz());

	}

}
