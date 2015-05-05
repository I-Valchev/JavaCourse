import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;


@Retention(RetentionPolicy.RUNTIME)
@interface MyAnno{
	String author();
	String date();
	int currentRevision() default 1;
	boolean checked() default false;
	String lastModified() default "N/A";
	String lastModifiedBy() default "N/A";
	
}

@MyAnno(
		author = "Ivo Valchev",
		date = "05/05/2015"
)

public class myAnno extends Object{

	public static void main(String [] args){
		MyAnno f = new MyAnno();
		Annotation[] annotations = f.getClass().getAnnotations();
		for(Annotation annotation : annotations){
			System.out.println(annotation);
		}
	}
	
	public MyAnno(){
		try {
			Method m = getClass().getMethod("print");
			Annotation[] annotations = m.getAnnotations();
			for(Annotation annotation : annotations){
				System.out.println(annotation);
			}
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Retention(RetentionPolicy.RUNTIME)
	@interface MethodAnno{
		String explanation();
	}
	
	@MethodAnno(explanation = "It prints a message")
	public void print(){
		System.out.println("It prints me lol...");
	}
}
