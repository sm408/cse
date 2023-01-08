package GradedLab;

import java.util.Scanner;

/**
 *
 * Name: Shubham Maurya
 * Roll No.: 2010110615
 * Course: CSD213
 */

class DivByZero extends Exception{
    public DivByZero(String s){
        super(s);
    }
}

class SqrtOfNegative extends Exception{
    public SqrtOfNegative(String s){
        super(s);
    }
}

class NegatFact extends Exception{
    public NegatFact(String s){
        super(s);
    }
}


public class Calculator {
    public static void main(String[] args) {
        int ch;
        do{
            System.out.println("""
                               \n\n
                               ************************
                               Choose any option:
                               1) Division
                               2) Square root
                               3) Factorial
                               4) Exit
                               """);
            Scanner input = new Scanner(System.in);
            ch = input.nextInt();
            try{
            switch(ch){
                case 1:{
                    int num,den;
                    System.out.println("\nEnter numerator");
                    num = input.nextInt();
                    System.out.println("\nEnter Denominator:");
                    den = input.nextInt();
                    if(den == 0){
                        throw new DivByZero("Division By Zero not Allowed!!!"); 
                    }
                    else{
                        System.out.println("Result: " + num/den);
                    }
                    break;
                }
                case 2:{
                    int num;
                    System.out.println("\nEnter the number : ");
                    num = input.nextInt();
                    if(num < 0 ){
                        throw new SqrtOfNegative("Square root of negative numbers is not possible!!!");
                    }
                    else{
                        System.out.println("Square root of " + num + " is " + Math.sqrt(num));
                        break;
                    }
                }
                case 3:{
                    int num, fact= 1;
                    System.out.println("\nEnter the number : ");
                    num = input.nextInt();
                    if(num < 0 ){
                        throw new NegatFact("Factorial of negative numbers is not possible!!!");
                    }
                    else{
                        for(int i = 1; i<=num;i++){
                            fact = fact*i;
                        }
                        System.out.println("Factorial of " + num + " is " + fact);
                    } 
                    break;
                }
            }
            }
            catch(DivByZero | SqrtOfNegative | NegatFact e){
                System.out.println(e.getMessage());
                System.out.println(e.getClass());
                System.out.println(e.getCause());
                System.out.println(e.getStackTrace());
            }
        }while(ch != 4);
    }

}
