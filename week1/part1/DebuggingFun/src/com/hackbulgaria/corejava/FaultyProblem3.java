package com.hackbulgaria.corejava;

public class FaultyProblem3 {
    
    public String reverseEveryWordInString(String sentence){
        String[] words = sentence.split(" ");
        StringBuilder result = new StringBuilder();
        int i = 1;
        for (String word: words){
            //sentence = sentence.replaceFirst(word, (String) reverse(word));
            result.append(reverse(word));
            
            if (i < words.length) result.append(" ");
            i++;
        }
        return result.toString();
    }

    private CharSequence reverse(String word) {
        return Utils.reverseMe(word);
    }
}
