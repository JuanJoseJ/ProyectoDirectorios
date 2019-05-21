import java.util.ArrayList;
import java.util.LinkedList;

public class ArbolBinario<E extends Comparable<E>> {
	protected NodoBinario<E> raiz;

	public NodoBinario<E> getRaiz() {
		return raiz;
	}

	public void setRaiz(NodoBinario<E> raiz) {
		this.raiz = raiz;
	}

	public ArbolBinario(NodoBinario<E> raiz) {
		this.raiz = raiz;
	}
	
	private void PreOrden(NodoBinario<E> raiz) {
		if(raiz!=null) {
			System.out.print(raiz.info+"\t");
			PreOrden(raiz.hijoIzq);
			PreOrden(raiz.hijoDer);
		}		
	}
	
	public void PreOrden() {
		PreOrden(this.raiz);
		System.out.println();
	}
	
	private void PostOrden(NodoBinario<E> raiz) {
		if(raiz!=null) {
			PostOrden(raiz.getHijoIzq());
			PostOrden(raiz.getHijoDer());
			System.out.print(raiz.getInfo()+" \t");
		}
	}
	
	public void PostOrden() {
		PostOrden(this.raiz);
		System.out.println();
	}
	
	private void InOrden(NodoBinario<E> raiz) {
		if(raiz!=null) {
			InOrden(raiz.getHijoIzq());
			System.out.print(raiz.getInfo()+"\t");
			InOrden(raiz.getHijoDer());
		}
	}
	
	public void InOrden() {
		InOrden(this.raiz);
		System.out.println();
	}
	
	private ArrayList<E> PreOrden(NodoBinario<E> raiz, ArrayList<E> list) {
		if(raiz!=null) {
			list.add(raiz.info);
			PreOrden(raiz.hijoIzq,list);
			PreOrden(raiz.hijoDer,list);
		}
		return list;
	}
	
	public ArrayList<E> PreOrdenArrayList() {
		ArrayList<E> list=new ArrayList<E>();
		PreOrden(this.raiz,list);
		return list;
	}
	
	private ArrayList<E> PostOrden(NodoBinario<E> raiz, ArrayList<E> list) {
		if(raiz!=null) {
			PostOrden(raiz.hijoIzq,list);
			PostOrden(raiz.hijoDer,list);
			list.add(raiz.info);
		}
		return list;
	}
	
	public ArrayList<E> PostOrdenArrayList() {
		ArrayList<E> list=new ArrayList<E>();
		PostOrden(this.raiz,list);
		return list;
	}
	
	private ArrayList<E> InOrden(NodoBinario<E> raiz, ArrayList<E> list) {
		if(raiz!=null) {
			InOrden(raiz.hijoIzq,list);
			list.add(raiz.info);
			InOrden(raiz.hijoDer,list);
		}
		return list;
	}
	
	public ArrayList<E> InOrdenArrayList() {
		ArrayList<E> list=new ArrayList<E>();
		InOrden(this.raiz,list);
		return list;
	}
	
	private void imprimirNivel(LinkedList<NodoBinario<E>> cola,LinkedList<NodoBinario<E>> colaAux, int nivel, int index) {
		if(index<nivel) {
			NodoBinario<E> aux;
			while(!colaAux.isEmpty())
				cola.add(colaAux.poll());
			while(!cola.isEmpty()) {
				aux=cola.poll();
				if(aux.hijoIzq!=null)colaAux.add(aux.hijoIzq);
				if(aux.hijoIzq!=null)colaAux.add(aux.hijoDer);
			}
			imprimirNivel(cola,colaAux,nivel,++index);				
		}
	}
	
	public ArrayList<E> imprimirNivel(int nivel){
		LinkedList<NodoBinario<E>> cola=new LinkedList<NodoBinario<E>>();
		LinkedList<NodoBinario<E>> colaAux=new LinkedList<NodoBinario<E>>();
		ArrayList<E> res=new ArrayList<E>();
		colaAux.add(this.raiz);
		imprimirNivel(cola,colaAux,nivel,0);
		while(!colaAux.isEmpty())
			res.add(colaAux.poll().getInfo());
		return (!res.isEmpty())?res:null;
	}
	
	public int cantidadHojas() {
		return cantidadHojas(this.raiz,0);
	}
	
	private int cantidadHojas(NodoBinario<E> raiz, int index) {
		if(raiz!=null) {
			if(raiz.getHijoDer()==null&&raiz.getHijoIzq()==null) index++;
			index=cantidadHojas(raiz.hijoIzq,index);
			index=cantidadHojas(raiz.hijoDer,index);
		}
		return index;
	}
}
