import Pair.Pair;
import List.List;

public class main {
	public static void main(String [] args){
		Audi c = new Audi();
		System.out.println(c.toString());
		
		Pair<Integer, String> p = new Pair<Integer, String>();
		p.setFirstObject(5);
		p.setSecondObject("Str");
		
		System.out.println(p.getFirstObject());
		System.out.println(p.getSecondObject());
	}
}
