import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class toDoList<T>{
	
	private List tasks;
    private int index; 
    
    public toDoList() { 
        tasks = new ArrayList<T>(); 
        index = 0; 
    } 

    public boolean empty () { 
        return index == 0; 
    } 
    
    public void insert (Comparable item) { 
    	tasks.add(item);
    } 

	
    public static void main(String [] args){
    	
    }
}