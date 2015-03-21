import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

import javax.imageio.ImageIO;


public class main {
	
	
	/**
	 * 1. Is it an odd number?
	 */
	boolean isOdd(int n){
		return n % 2 != 0;
	}
	
	
	
	/**
	 * 2. Is N prime?
	 */
	boolean isPrime(int n){
		boolean isPrime = true;
		
		for(int i = 2; i < n && isPrime == true; ++i)
			if(n % i == 0) isPrime = false;
		
		return isPrime;
	}
	
	
	
	/**
	 * 3. Find the minimum element of an array
	 */
	int min(int[] array){
		Arrays.sort(array);
		return array[0];
	}
	
	
	
	/**
	 * 4. Find the kth minimal element of an array
	 */
	int kthMin(int k, int[] array){
		Arrays.sort(array);
		return array[k];
	}
	
	

	/**
	 * 5. Find the average(средно аритметично) of the elements of an array
	 */
	int average(int[] array){
		int sum = 0;
		for(int i = 0; i < array.length; ++i){
			sum += array[i];
		}
		
		int average = (int) sum / array.length;
		
		return average;
	}
	
	
	
	//Help function of doubleFac(int)
	long fac(long n){
		long fact = 1;
		for(int i = 1; i <= n; ++i){
			fact *= i;
		}
		
		return fact;
	}
	
	/**
	 * 6. Double factorial
	 */
	long doubleFac(int n){
		long nLong = (long) n;
		return fac(fac(nLong));
	}
	
	
	
	/**
	 * 7. Kth factorial
	 */
	long kthfac(int k, int n){
		int res = 1;
		
		for(int i = 0; i < k; ++i){
			res *= fac(i);
		}
		
		return res;
	}
	
	
	
	//Help function of getSmallestMultiple(int)
	boolean divisible(int n, int upperBound){
		for(long i = 2; i <= upperBound; ++i){
			if(n % i != 0) return false;
		}
		return true;
	}
	
	/**
	 * 8. Smallest multiple
	 */
	int getSmallestMultiple(int upperBound){
		for(int i = upperBound;;++i){
			if(divisible(i, upperBound)) return i;
		}
	}
	
	
	
	
	//Help function of getLargestPalindrome(long)
	boolean isPalindrome(long n){
		long number = n;
		int reverse = 0;
		while(number != 0){
			int remainder = (int) number % 10;
			number /= 10;
			reverse = reverse*10 + remainder;
		}
		
		return reverse==n;
	}
	
	/**
	 * 9. Find the largest integer palindrome number up to N
	 */
	long getLargestPalindrome(long n){
		
		for(long i = n; i > 0; --i){
			if(isPalindrome(i)) return i;
		}
		
		return -1;
	}
	
	
	
	/**
	 * 10. Grayscale image histogram
	 */
	int[] histogram(short[][] image){
		int[] result = new int[256];
		
		for(int i = 0; i < image.length; ++i){
			for(int j = 0; j < image[i].length; ++j){
				int index = image[i][j];
				result[index] += 1;
			}
		}
		
		return result;
	}
	
	
	
	/**
	 * 11. Raise an integer to a power of another
	 */
	long pow(int a, int b){
		long result = 1;
		
		for(int i = 0; i < b; ++i){
			result *= a;
		}
		
		return result;
	}
	
	
	
	/**
	 * 12. Find the only number, that occurs odd times in an array
	 */
	int countOcurrences(String needle, String haystack){
		return (haystack.length() - haystack.replace(needle, "").length()) / needle.length(); //single line :)
	}
	
	

	/**
	 * 13. Maximal scalar product
	 */
	long maximalScalarSum(int[] a, int[] b){
		Arrays.sort(a);
		Arrays.sort(b);

		return a[0]*b[0] + a[1]*b[1] + a[2]*b[2];
	}
	
	

	//Help function of maxSpan(int[])
	int getSpan(int[] numbers, int num){
		int left = numbers.length;
		int right = 0;
		for(int i = 0; i < numbers.length; ++i){
			if(numbers[i] == num && i < left) left = i;
			if(numbers[i] == num && i > right) right = i;
		}
		
		return right-left+1;
	}
	
	/**
	 * 14. Max span
	*/
	int maxSpan(int[] numbers){
		int span = 0;
		
		for(int i = 0; i < numbers.length; ++i){
			if(span < getSpan(numbers, i)) span = getSpan(numbers, i);
		}
		return span;
	}
	
	
	
	//Help function of canBalance(int[])
	int getSplittedSum(int[] numbers, int midElement){
		int leftSum = numbers[0];
		int rightSum = numbers[numbers.length-1];

		for(int i = 0; i < midElement; ++i){
			leftSum += numbers[i];
		}
		
		for(int i = numbers.length-1; i >= midElement; --i){
			rightSum += numbers[i];
		}
		
		return leftSum - rightSum;
	}
	
	/**
	 * 15. Can balance?
	*/
	boolean canBalance(int[] numbers){
		for(int i = 0; i < numbers.length; ++i){
			if(getSplittedSum(numbers, i) == 0) return true;
		}
		
		return false;
	}
	
	
	
	/**
	 *	16. Rescale an image using nearest neighbour interpolation
	*/
	int[][] rescale(int[][]original, int newWidth, int newHeight){
		int[][] newImage = new int[original[0].length][original.length];
		double xScale = original[0].length / newWidth;
		double yScale = original.length / newHeight;
		
		for(int i = 0; i < newHeight; ++i){
			for(int j = 0; j < newWidth; ++j){
				double x = Math.floor(xScale*j);
				double y = Math.floor(yScale*i);
				newImage[i][j] = original[(int) (xScale*original[0].length)][(int) (yScale*original.length)];
			}
		}
		
		return newImage;
	}
	
	
	
	/**
	 *	17. Reverse a String 
	*/
	String reverseMe(String str){
		StringBuilder result = new StringBuilder();
		
		for(int i = str.length()-1; i >= 0; --i){
			result.append(str.charAt(i));
		}
		
		return result.toString();
	}
	
	
	
	/**
	 *	18. Reverse each word in a String
	*/
	String reverseEveryChar(String str){
		StringBuilder result = new StringBuilder();
		int lastWhitespace = 0;
		boolean insideWord = true;
		
		for(int i = 0; i < str.length(); ++i){
			char c = str.charAt(i);
			if(c == ' ' || c == '\t' || c == '\n'){
				result.append(c);
				insideWord = false;

				String word = str.substring(lastWhitespace, i);
				lastWhitespace = i;
				result.append(reverseMe(word));
				
			}else{
				insideWord = true;
			}
		}
		
		if(insideWord){
			String word = str.substring(lastWhitespace, str.length());
			result.append(reverseMe(word));
		}
		
		return result.toString();
	}
	
	
	/**
	 * 18. Copy every character K times
	 */
	String copyEveryChar(String input, int k){
		StringBuilder str = new StringBuilder();
		
		for(int i = 0; i < input.length(); ++i){
			char c = input.charAt(i);
			if(c != ' ' && c != '\t' && c!= '\n'){
				System.out.println("Char is %" + c + "%");
				for(int j = 0; j < k - 1; ++j) str.append(c); //according to the unittest, whitespaces should not be copied
			}
			
			str.append(c);
		}
		
		return str.toString();
	}
	
	/**
	 * 21. Decode an URL
	 */
	String decodeUrl(String input){
		try {
			return java.net.URLDecoder.decode(input, "UTF-8"); //single line :)
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

		return "";
	}
	
	
	
	/**
	 * 22. Sum all the numbers in a String
	 */
	int sumOfNumbers(String input){
		boolean insideNumber = false, lastCharDigit = false;
		int numStart = 0, sum = 0;
		
		for(int i = 0; i < input.length(); ++i){
			char c = input.charAt(i);
			lastCharDigit = insideNumber;
			if(Character.isDigit(c))
				insideNumber = true;
			else
				insideNumber = false;

			if(!lastCharDigit && insideNumber) { // we've entered a new number
				numStart = i; 
			}
			
			if(!insideNumber && lastCharDigit){	//we've got out of a number
				String numString = input.substring(numStart, i);
				sum += Integer.parseInt(numString);
			}	
		}

		if(insideNumber){
			String numString = input.substring(numStart, input.length());
			sum += Integer.parseInt(numString);
		}	
		
		return sum;
	}
	
	
	
	/**
	 * 23. Is String A an anagram of String B?
	 */
	boolean anagram(String A, String B){
		char[] a = A.toLowerCase().toCharArray();
		char[] b = B.toLowerCase().toCharArray();
		Arrays.sort(a);
		Arrays.sort(b);
		return Arrays.equals(a, b);
	}
	
	
	
	boolean hasAnagramOf(String A, String B){
		char[] a = A.toLowerCase().toCharArray();
		char[] b = B.toLowerCase().toCharArray();
		Arrays.sort(a);
		Arrays.sort(b);
		
		return b.toString().contains(a.toString());
	}
	
	/**
	 * 25. Convert To Greyscale
	*/
	void convertToGreyscale(String imgPath){
		File input = new File(imgPath);
		BufferedImage image = null;
		
		try {
			image = ImageIO.read(input);
		} catch (IOException e) {
			
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
        for(int i = 0; i < image.getWidth(); i++){
        
           for(int j = 0; j < image.getHeight(); j++){
           
              Color c = new Color(image.getRGB(i, j));
              int red = (int)(c.getRed());
              int green = (int)(c.getGreen()) ;
              int blue = (int)(c.getBlue());
              int sumColor = (red + green + blue)/3;
              Color newColor = new Color(sumColor, sumColor, sumColor);
              
              image.setRGB(i,j	,newColor.getRGB());
           }
        }
        
        File ouptut = new File("output.jpg");
        try {
			ImageIO.write(image, "jpg", ouptut);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

}
