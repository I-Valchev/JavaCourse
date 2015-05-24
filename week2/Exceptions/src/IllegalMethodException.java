
public class IllegalMethodException extends Exception{
	public IllegalMethodException() { super("Function not permitted for an immutable class");}
}
