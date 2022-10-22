package selfPractice;

/**
 *
 * Name: Shubham Maurya
 * Roll No.: 2010110615
 * Course: CSD213
 */

import java.util.Scanner;

public class StringInputLine {

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        
        String str = input.nextLine();
        
        System.out.print("Input string is " + str);
        
        String words[] = str.split("");
        
        System.out.println("Words in string are:");
        for(String str1: words){
            System.out.println(str1);
        }
    }
    
}
