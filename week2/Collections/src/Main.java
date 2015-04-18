import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Stack;



public class Main {
	
	public static <T> void reverse(Collection<T> collection){
		Stack<T> s = new Stack<>();
		
		Iterator<T> it = collection.iterator();
		while(it.hasNext()){
			s.push(it.next());
		}
		
		collection.clear();

		while(!s.isEmpty()){
			collection.add(s.pop());
		}
	}
	
	public static void main(String[] args) {
		ArrayList<String> arr = new ArrayList<String>();
		arr.add("1");
		arr.add("2");
		arr.add("3");
		reverse(arr);
		
		
	}
}
