/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Alphabet;

import com.sun.org.apache.bcel.internal.generic.AALOAD;
import java.io.PrintStream;
import java.util.Set;

/**
 *
 * @author przyg
 */
public class SimpleTrie {

    public static int SIZE = indexOf('Z') + 9;

    private DataCount data;
    private SimpleTrie[] tries = null;

    private static int indexOf(char letter) {
        int res = -1;
        if (letter == '\'') {
            res = 'Z' + 1 - 'A';
        } else if (Character.digit(letter, 10) >= 0) {
            res = Character.digit(letter, 10) + 'Z' + 1 - 'A';
        } else {
           res = (int) (letter - 'A');
        }
        return res;
    }

    public void put(String word, String data) {        
        if (word.isEmpty()) {
            if(this.data == null) this.data = new DataCount(data);
            else{
                this.data.setCount(this.data.getCount()+1);
            }
        } else {
            char letter = word.charAt(0);

            int index = indexOf(letter);

            if (tries == null) {
                tries = new SimpleTrie[SIZE];
            }
            if (tries[index] == null) {
                tries[index] = new SimpleTrie();
            }

            SimpleTrie trie = tries[index];

            trie.put(word.substring(1), data);
        }
    }

    
    
    public DataCount get(String word) {
        if (word.isEmpty()) {
            return data;
        }

        if (tries == null) {
            return null;
        }
        char letter = word.charAt(0);
        int index = indexOf(letter);
        SimpleTrie trie = tries[index];
        if (trie == null) {
            return null;
        }
        return trie.get(word.substring(1));

    }


    
    public void print(PrintStream out) {
        if (data != null) {
            out.println(data.getData() + " " + data.getCount());
        }
        if (tries != null) {
            for (SimpleTrie trie : tries) {
                if (trie == null) {
                    continue;
                }
                trie.print(out);
            }
        }
    }
}
