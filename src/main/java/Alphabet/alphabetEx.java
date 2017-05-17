/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Alphabet;

/**
 *
 * @author przyg
 */
public class alphabetEx {
    public static void main(String[] args) {
        
        System.out.println(indexOf('D'));
        
        System.out.println(indexOf(9));
        
        System.out.println(indexOf("red"));
    }
    
    public static int indexOf(int digit){
        return digit;
    }
    
    public static int indexOf(char letter){
        return (int)(letter - 'A');
    }
    
    public static int indexOf(String colour){
        switch (colour) {
            case "red" : return 0;
            case "yellow" : return 1;
            case "green" : return 2;
        }
        throw new IllegalArgumentException(colour+" is not a colour");
    }
}
