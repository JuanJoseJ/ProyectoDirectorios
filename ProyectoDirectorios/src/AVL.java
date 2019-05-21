public class AVL<E extends Comparable<E>> extends ArbolBinarioBusqueda<E> {

	public AVL(NodoBinario<E> raiz) {
		super(raiz);
	}

	@Override
	public void insertar(NodoBinario<E> nodo) throws ExceptionNodo {
		balancear(nodo.getPadre());
		super.insertar(nodo);
		balancear(nodo);
	}
	
	@Override
	public void eliminar(E info) throws ExceptionNodo {
		NodoBinario<E> n=buscar(info);
		NodoBinario<E> padre;
		if(n.getHijoDer()!=null&&n.getHijoIzq()!=null)
			padre=buscarAntecesor(n).getPadre();
		else
			padre=n.getPadre();
		super.eliminar(info);
		if(padre==null)
			balancear(raiz);
		else
			while(padre!=null) {
				balancear(padre);
				padre=padre.getPadre();
			}
	}

	private void balancear(NodoBinario<E> nodo) {
		NodoBinario<E> desb=desbalance(nodo);
		if(desb!=null) {
			NodoBinario<E> p=desb.getPadre();
			if(desb.FactorEquilibrio()>0) {
				if(desb.getHijoDer().FactorEquilibrio()>=0)
					desb=balanceSimpleIzq(desb);
				else
					desb=balanceDobleIzq(desb);
			} else
				if(desb.FactorEquilibrio()<0) {
					if(desb.getHijoIzq().FactorEquilibrio()<=0)
						desb=balanceSimpleDer(desb);
					else
						desb=balanceDobleDer(desb);
				}
			if(p==null)
				raiz=desb;
			else
				if(desb.getInfo().compareTo(p.getInfo())>0)
					p.setHijoDer(desb);
				else
					p.setHijoIzq(desb);
		}
	}
	
	private NodoBinario<E> balanceSimpleIzq(NodoBinario<E> nodo){
		NodoBinario<E> der=nodo.getHijoDer();
		der.setPadre(nodo.getPadre());
		nodo.setHijoDer(der.getHijoIzq());
		der.setHijoIzq(nodo);
		return der;
	}
	
	private NodoBinario<E> balanceSimpleDer(NodoBinario<E> nodo){
		NodoBinario<E> izq=nodo.getHijoIzq();
		izq.setPadre(nodo.getPadre());
		nodo.setHijoIzq(izq.getHijoDer());
		izq.setHijoDer(nodo);
		return izq;
	}
	
	private NodoBinario<E> balanceDobleDer(NodoBinario<E> nodo){
		nodo.setHijoIzq(balanceSimpleIzq(nodo.getHijoIzq()));
		return balanceSimpleDer(nodo);
	}
	
	private NodoBinario<E> balanceDobleIzq(NodoBinario<E> nodo){
		nodo.setHijoDer(balanceSimpleDer(nodo.getHijoDer()));
		return balanceSimpleIzq(nodo);
	}
	
	private NodoBinario<E> desbalance(NodoBinario<E> nodo){
		NodoBinario<E> nodoAux=nodo;
		while(nodoAux!=null&&Math.abs(nodoAux.FactorEquilibrio())<=1)
			nodoAux=nodoAux.getPadre();
		return nodoAux;
	}
}
