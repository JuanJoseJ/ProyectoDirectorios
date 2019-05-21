import java.util.ArrayList;

public class ArbolBinarioBusqueda <E extends Comparable<E>> extends ArbolBinario<E> {
	public ArbolBinarioBusqueda(NodoBinario<E> raiz) {
		super(raiz);
	}

	public NodoBinario<E> buscarAntecesor(NodoBinario<E> nodo) throws ExceptionNodo{
		if(nodo.getHijoIzq()==null)
			throw new ExceptionNodo("Error, el nodo no tiene hijo de la izquierda");
		return buscarMaximo(nodo.getHijoIzq());
	}

	public NodoBinario<E> buscarMaximo(NodoBinario<E> nodo) throws ExceptionNodo{
		if(nodo.getHijoDer()==null)
			return nodo;
		else
			return buscarMaximo(nodo.getHijoDer());
	}

	public NodoBinario<E> buscarPredecesor(NodoBinario<E> nodo) throws ExceptionNodo{
		if(nodo.getHijoDer()==null)
			throw new ExceptionNodo("Error, el nodo no tiene hijo de la derecha");
		return buscarMinimo(nodo.getHijoDer());
	}

	public NodoBinario<E> buscarMinimo(NodoBinario<E> nodo) throws ExceptionNodo{
		if(nodo.getHijoIzq()==null)
			return nodo;
		else
			return buscarMinimo(nodo.getHijoIzq());
	}

	public NodoBinario<E> buscar(E info, NodoBinario<E> nodo) throws ExceptionNodo{
		if(nodo==null)
			throw new ExceptionNodo("El nodo no existe");
		if(info.compareTo(nodo.getInfo())<0)
			return buscar(info,nodo.getHijoIzq());
		if(info.compareTo(nodo.getInfo())>0)
			return buscar(info,nodo.getHijoDer());
		return nodo;
	}

	public NodoBinario<E> buscar(E info) throws ExceptionNodo{
		return buscar(info, this.raiz);
	}

	public void insertar(NodoBinario<E> nodo) throws ExceptionNodo {
		raiz=insertar(nodo,raiz);
	}

	protected NodoBinario<E> insertar(NodoBinario<E> nodo, NodoBinario<E> raiz) throws ExceptionNodo{
		if(raiz==null)
			raiz=nodo;
		else {
			if(nodo.getInfo().compareTo(raiz.getInfo())<0)
				raiz.setHijoIzq(insertar(nodo,raiz.getHijoIzq()));
			if(nodo.getInfo().compareTo(raiz.getInfo())>0)
				raiz.setHijoDer(insertar(nodo,raiz.getHijoDer()));
			if(nodo.getInfo().compareTo(raiz.getInfo())==0)
				throw new ExceptionNodo("El nodo está repetido");
		}
		return raiz;
	}

	public void eliminar(E info) throws ExceptionNodo {
		eliminar(info,raiz);
	}

	protected NodoBinario<E> eliminar(E info,NodoBinario<E> raiz) throws ExceptionNodo {
		if(raiz==null)
			throw new ExceptionNodo("El nodo no existe");
		else {
			if(info.compareTo(raiz.getInfo())<0)
				raiz.setHijoIzq(eliminar(info,raiz.getHijoIzq()));
			else
				if(info.compareTo(raiz.getInfo())>0)
					raiz.setHijoDer(eliminar(info,raiz.getHijoDer()));
				else {
					if(raiz.getHijoDer()!=null&&raiz.getHijoIzq()!=null) {
						NodoBinario<E> antecesor=buscarAntecesor(raiz);
						raiz.setInfo(antecesor.getInfo());
						raiz.setHijoIzq(eliminar(antecesor.getInfo(),raiz.getHijoIzq()));
					}else
						if(raiz.getHijoDer()!=null) {
							raiz=raiz.getHijoDer();
						}else
							raiz=raiz.getHijoIzq();
				}
		}
		return raiz;
	}
	
	

	public ArbolBinarioBusqueda<E> crearArbolPreOrden(ArrayList<E> preOrden) throws ExceptionNodo{
//		int i=0;
//		do {
//			i++;
//		}while(i<preOrden.size()&&preOrden.get(0).compareTo(preOrden.get(i))>0);
		ArbolBinarioBusqueda<E> a=new ArbolBinarioBusqueda<E>(new NodoBinario<E>(preOrden.get(0)));
		crearArbolPreOrden(preOrden,a,1);
		return a;
	}
	
	public void crearArbolPreOrden(ArrayList<E> preOrden, ArbolBinarioBusqueda<E> a, int index) throws ExceptionNodo {
		if(index<preOrden.size()) {
			if(preOrden.get(0).compareTo(preOrden.get(index))>0) {
				a.insertar(new NodoBinario<E>(preOrden.get(index)));
				crearArbolPreOrden(preOrden,a,++index);
			} else {
				a.insertar(new NodoBinario<E>(preOrden.get(index)));
				crearArbolPreOrden(preOrden,a,++index);
			}
		}
	}

	public static void main(String[] args) {
		NodoBinario<Integer> n1=new NodoBinario<Integer>(1);
		NodoBinario<Integer> n2=new NodoBinario<Integer>(2);
		NodoBinario<Integer> n3=new NodoBinario<Integer>(3);
		NodoBinario<Integer> n4=new NodoBinario<Integer>(4);
		NodoBinario<Integer> n5=new NodoBinario<Integer>(5);
		NodoBinario<Integer> n6=new NodoBinario<Integer>(6);
		NodoBinario<Integer> n7=new NodoBinario<Integer>(7);
		NodoBinario<Integer> n8=new NodoBinario<Integer>(8);
		NodoBinario<Integer> n9=new NodoBinario<Integer>(9);
		NodoBinario<Integer> n10=new NodoBinario<Integer>(10);
		ArbolBinarioBusqueda<Integer> a=new ArbolBinarioBusqueda<Integer>(n5);
		try {
			a.insertar(n2);
			a.insertar(n3);
			a.insertar(n4);
			a.insertar(n6);
			a.insertar(n1);
			a.insertar(n7);
			a.insertar(n8);
			a.insertar(n10);
			a.insertar(n9);
			ArrayList<Integer> preOrden =new ArrayList<>();
			preOrden.add(5);
			preOrden.add(2);
			preOrden.add(1);
			preOrden.add(3);
			preOrden.add(4);
			preOrden.add(9);
			preOrden.add(7);
			preOrden.add(6);
			preOrden.add(8);
			preOrden.add(10);
			a=a.crearArbolPreOrden(preOrden);
//			a.insertar(new NodoBinario<Integer>(11));
			a.InOrden();
//			System.out.println(a.buscar(2));
//			a.eliminar(10);
//			a.InOrden();
//			System.out.println();
//			a.eliminar(9);
//			a.InOrden();
//			System.out.println();
//			a.eliminar(a.getRaiz().getInfo());
//			a.InOrden();
			System.out.println("\n\nLa cantidad de hojas es: "+a.cantidadHojas());
			System.out.println("\nLa altura es: "+n7.altura());
			
		} catch (ExceptionNodo e) {
			System.out.println(e.getMessage());
		}
	}
}

@SuppressWarnings("serial")
class ExceptionNodo extends Exception{
	public ExceptionNodo(String s) {
		super(s);
	}
}