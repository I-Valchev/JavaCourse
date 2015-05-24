package Stack;

import java.util.EmptyStackException;
import java.util.List;

public class Stack <T>{
	private List<T> data;
	private int size;
	
	public Stack(int size){
		resize(size);
	}
	
	public void resize(int newSize){
		if(newSize < 0) throw new IndexOutOfBoundsException();
		this.size = newSize;
	}
	
	public boolean isEmpty(){
		return data.isEmpty();
	}
	
	public boolean isFull(){
		return data.size() == this.size;
	}

	public T pop(){
		if(isEmpty()) throw new EmptyStackException();
		
		int index = data.size() - 1;
		T result = data.get(index);
		data.remove(index);
		
		return result;
	}
	
	public void push(T element){
		if(isFull()) throw new ArrayIndexOutOfBoundsException();
		if(!data.contains(element))	data.add(element);
	}
}
