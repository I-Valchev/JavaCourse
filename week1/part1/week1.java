package part1;

public class week1 {
	
	public int getNumberOfDigits(int num){
		return Integer.toString(num).length();
	}
	
	public String joinStrings(String glue, String ... args){
		StringBuilder result = new StringBuilder();
		
		int i = 0;
		for(String word : args){
			result.append(word);
			if(i != args.length-1) result.append(glue);
			++i;
		}
		
		return result.toString();
	}
	
	public String reduceFilePath(String path){
		String result = path;
	
		while(result.contains(("/./"))){ //replace recursively
			result = result.replaceAll("/./", "/");
		}
		result = result.replaceAll("//", "/");
		result = result.replaceAll("/([\\S]*)/../", "/");
		result = result.replaceAll("/../", "/"); //single case for "/../etc..."
		
		if(result.endsWith("/") && result.length() != 1) result = result.substring(0, result.length()-1);
		return result;
	}
}
