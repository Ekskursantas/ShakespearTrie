/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Alphabet;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author przyg
 */
public class ShakeCount {

    public static void main(String[] args) throws IOException {
        FileUtility load = new FileUtility();
        Set<String> uploadedWords = new HashSet<String>();
        SimpleTrie tries = new SimpleTrie();
        String[] words = load.toStringArray("C:\\Users\\przyg\\Desktop\\Shake.txt", "[^A-Za-z']+");

        for (String word : words) {

            word = word.toUpperCase();
            if (!uploadedWords.contains(word)) {
                tries.put(word, word);
                uploadedWords.add(word);
            } else {
                tries.put(word, word);
            }
        }
        
        tries.print(System.out);

    }

//    public static int getTotal(Set<String> uploadedWords, SimpleTrie trie) {
//        int countTotal = 0;
//        if (uploadedWords == null) {
//            return 0;
//        }
//        for (String uploadedWord : uploadedWords) {
//            countTotal = countTotal + trie.get(uploadedWord);
//        }
//        return countTotal;
//    }
}
