package iterator;

import java.util.Iterator;

public interface ExtendedIterator<Object> extends Iterator<Object> {
	
	//Devuelve el elemento actual y va haca atras
	public Object previous();
	
	//true	si tiene un elemento anterior
	public boolean hasPrevious();
	
	//Se coloca en el primer elemento
	public void goFirst();
	
	//Se coloca en el último elemento
	public void goLast();
}