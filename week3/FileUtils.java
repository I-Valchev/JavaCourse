import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;


public class FileUtils {
    
    public static String readFile(File file) {
        String result = "";
        
        try(BufferedReader br = new BufferedReader(new FileReader(file))) {
            int c;
            
            while ((c = br.read()) != -1) {
                result += (char) c;
            }
        } catch(IOException e) {
        	e.printStackTrace();
        }
        
        return result;
    }
    
    public static void main(String[] args){
    	for(String arg : args){
    		Path file = Paths.get(arg);
    		String result = FileUtils.readFile(file.toFile());
    		System.out.println(result);
    	}
    }
}