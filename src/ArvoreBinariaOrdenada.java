
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
		
		while(atual != null) { // Encontrando atual
			if(valor.equals(atual.getValor())) {
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
			
			if(atual.getDireita() != null) { // Tem dois filhos ou filho a direita
				
				Elemento<TIPO> substituto = atual.getDireita();
                Elemento<TIPO> paiSubstituto = atual;
                while(substituto.getEsquerda() != null){
                    paiSubstituto = substituto;
                    substituto = substituto.getEsquerda();
                }
                
                substituto.setEsquerda(atual.getEsquerda()); // Pulo do gato - Passar arvore a esquerda do atual para o substituto
                
                if (paiAtual != null){
                    if (atual.getValor().compareTo(paiAtual.getValor()) == -1){ //atual < paiAtual
                        paiAtual.setEsquerda(substituto);
                    }
                    else{
                        paiAtual.setDireita(substituto);
                    }
                }
                else{ //se não tem paiAtual, então é a raiz
                    this.raiz = substituto;
                    paiSubstituto.setEsquerda(null);
                    this.raiz.setDireita(paiSubstituto);
                    this.raiz.setEsquerda(atual.getEsquerda());
                }
                
                //remove o elemento da árvore
                if (substituto.getValor().compareTo(paiSubstituto.getValor()) == -1){ //substituto < paiSubstituto
                    paiSubstituto.setEsquerda(null);
                }
                else{
                    paiSubstituto.setDireita(null);
                }
				
			}
			
			else if(atual.getEsquerda() != null) { // Filho só a esquerda
				Elemento<TIPO> substituto = atual.getEsquerda();
				Elemento<TIPO> paiSubstituto = atual;
				
				while(substituto.getDireita() != null) {
					paiSubstituto = substituto;
					substituto = substituto.getDireita();
				}
				
				if (paiAtual != null){
                    if (atual.getValor().compareTo(paiAtual.getValor()) == -1){ //atual < paiAtual
                        paiAtual.setEsquerda(substituto);
                    }
                    else{
                        paiAtual.setDireita(substituto);
                    }
                }
				else{ //se for a raiz
                    this.raiz = substituto;
                }
                
                //removeu o elemento da árvore
                if (substituto.getValor().compareTo(paiSubstituto.getValor()) == -1){ //substituto < paiSubstituto
                    paiSubstituto.setEsquerda(null);
                }
                else{
                    paiSubstituto.setDireita(null);
                }
				
					
			}
			else { 	// Nao tem filho
				if (paiAtual != null){
                    if (atual.getValor().compareTo(paiAtual.getValor()) == -1){ //atual < paiAtual
                        paiAtual.setEsquerda(null);
                    }
                    else{
                        paiAtual.setDireita(null);
                    }
                }
				else{ //é a raiz
                    this.raiz = null;
                }
			}
			
			return true;
		}
		else {
			return false;
		}
	}
	
}