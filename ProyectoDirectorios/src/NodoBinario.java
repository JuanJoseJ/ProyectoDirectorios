public class NodoBinario<E extends Comparable<E>> {
	protected E info;
	protected NodoBinario<E> hijoIzq;
	protected NodoBinario<E> hijoDer;
	protected NodoBinario<E> padre;
	
	public NodoBinario(E info) {
		this.info = info;
		padre=null;
		hijoIzq=null;
		hijoDer=null;
	}

	public NodoBinario(E info, NodoBinario<E> hijoIzq, NodoBinario<E> hijoDer, NodoBinario<E> padre) {
		this.info = info;
		this.hijoIzq = hijoIzq;
		this.hijoDer = hijoDer;
		this.padre = padre;
	}

	public E getInfo() {
		return info;
	}

	public void setInfo(E info) {
		this.info = info;
	}

	public NodoBinario<E> getHijoIzq() {
		return hijoIzq;
	}

	public void setHijoIzq(NodoBinario<E> hijoIzq) {
		if(hijoIzq!=null)
			hijoIzq.setPadre(this);
		this.hijoIzq = hijoIzq;
	}

	public NodoBinario<E> getHijoDer() {
		return hijoDer;
	}

	public void setHijoDer(NodoBinario<E> hijoDer) {
		if(hijoDer!=null)
			hijoDer.setPadre(this);
		this.hijoDer = hijoDer;
	}

	public NodoBinario<E> getPadre() {
		return padre;
	}

	public void setPadre(NodoBinario<E> padre) {
		this.padre = padre;
	}
	
	public int altura() {
		return altura(this);
	}
	
	private int altura(NodoBinario<E> nodo) {
		if(nodo==null) return -1;
		int indexDer=(nodo.getHijoDer()==null?0:1+altura(nodo.getHijoDer()));
		int indexIzq=(nodo.getHijoIzq()==null)?0:1+altura(nodo.getHijoIzq());
		return Math.max(indexDer,indexIzq);
	}
	
	public int FactorEquilibrio() {
		return altura(this.getHijoDer())-altura(this.getHijoIzq());
	}
}
