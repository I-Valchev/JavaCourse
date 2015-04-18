import java.util.ArrayList;
import java.util.Collection;


public class Immutable<T> extends ArrayList<T>{
	
	private void throwException(){
		try {
			throw new IllegalMethodException();
		} catch (IllegalMethodException e1) {
			e1.printStackTrace();
		}
	}
	
	@Override
	public boolean add(T e){
		throwException();		
		return false;
	}
	
	@Override
	public void add(int index, T element){
		throwException();
	}
	
	@Override
	public boolean addAll(Collection<? extends T> c){
		throwException();
		return false;	
	}
	
	
	@Override
	public boolean addAll(int index, Collection<? extends T> c){
		throwException();
		return false;
	}
	
	@Override
	public void clear(){
		throwException();
	}
	
	@Override
	public void ensureCapacity(int minCapacity){
		throwException();
	}
	
	@Override
	public T remove(int index){
		throwException();
		T t = null;
		return t;
	}
	
	@Override
	public boolean remove(Object o){
		throwException();
		return false;
	}
	
	@Override
	public boolean removeAll(Collection<?> c){
		throwException();
		return false;
	}
	
	@Override
	protected void removeRange(int fromIndex, int toIndex){
		throwException();
	}
	
	@Override
	public T set(int index, T element){
		return element;
	}
	
	@Override
	public void trimToSize(){
		throwException();
	}
	
}
