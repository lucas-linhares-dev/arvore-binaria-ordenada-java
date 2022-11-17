
public class ArvoreBinariaOrdenada<TIPO extends Comparable> {
	private Elemento<TIPO> raiz;
	
	
	public ArvoreBinariaOrdenada() {
		this.raiz = null;
	}
	
	
	public Elemento<TIPO> getRaiz() {
		return raiz;
	}

	public void setRaiz(Elemento<TIPO> raiz) {
		this.raiz = raiz;
	}


	public void adicionar(TIPO valor) {
		Elemento<TIPO> novoElemento = new Elemento<TIPO>(valor);
		
		if(this.raiz == null) {
			this.raiz = novoElemento;
		}
		else {
			Elemento<TIPO> atual = this.raiz;
			
			while(true) {
				if(novoElemento.getValor().compareTo(atual.getValor()) == -1) { // Se o novo for menor que a raiz
					if(atual.getEsquerda() != null) {
						atual = atual.getEsquerda();
					}
					else {
						atual.setEsquerda(novoElemento);
						break;
					}
				}
				else {
					if(atual.getDireita() != null) {
						atual = atual.getDireita();
					}
					else {
						atual.setDireita(novoElemento);
						break;
					}
						
				}
			}
		}
	}
	
	public void imprimirEmOrdem(Elemento<TIPO> atual) { // Passar o getRaiz() como parametro
		if(atual != null) {
			imprimirEmOrdem(atual.getEsquerda());
			System.out.println(atual.getValor());
			imprimirEmOrdem(atual.getDireita());
		}
	}
	
	public void imprimirPreOrdem(Elemento<TIPO> atual) { // Passar o getRaiz() como parametro
		if(atual != null) {
			System.out.println(atual.getValor());
			imprimirPreOrdem(atual.getEsquerda());
			imprimirPreOrdem(atual.getDireita());
		}
	}
	
	public void imprimirPosOrdem(Elemento<TIPO> atual) { // Passar o getRaiz() como parametro
		if(atual != null) {
			imprimirPosOrdem(atual.getEsquerda());
			imprimirPosOrdem(atual.getDireita());
			System.out.println(atual.getValor());
		}
	}
	
	
	public boolean remover(TIPO valor) {
		Elemento<TIPO> atual = this.raiz;
		Elemento<TIPO> paiAtual = null;
		
		while(atual != null) {
			if(valor.equals(atual.getValor())) {
				// Remover
				break;
			}
			else if(valor.compareTo(atual.getValor()) == -1) {
				paiAtual = atual;
				atual = atual.getEsquerda();
			}
			else {
				paiAtual = atual;
				atual = atual.getDireita();
			}
		}
		// REMOÇÃO
		if(atual != null) {
			
		}
		return (atual != null);
	}
}
