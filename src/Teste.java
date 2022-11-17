
public class Teste {

	public static void main(String[] args) {
		ArvoreBinariaOrdenada<Integer> arvore = new ArvoreBinariaOrdenada<Integer>();
		arvore.adicionar(3);
		arvore.adicionar(2);
		arvore.adicionar(1);
		arvore.imprimirEmOrdem(arvore.getRaiz());

	}

}
