package lab6;

/**
 *
 * Name: Shubham Maurya
 * Roll No.: 2010110615
 * Course: CSD213
 */

import java.util.Scanner;

class AgeLimitException extends Exception{
    public AgeLimitException(String s){
        super(s);
    }
}

public class Except {
    public static void main(String[] args) {
        int age;
        Scanner input = new Scanner(System.in);
        
        
        try{
                    age = input.nextInt();
//            if(age<21){
//                throw new AgeLimitException("Under Age");
//            }
        }
        catch(Exception e){
            
            System.out.println(e.getMessage());
            
        }
        
    }

}
