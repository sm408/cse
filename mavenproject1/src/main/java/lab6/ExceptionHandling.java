package lab6;

/**
 *
 * Name: Shubham Maurya
 * Roll No.: 2010110615
 * Course: CSD213
 */
import java.util.Scanner;

public class ExceptionHandling {
    public static void main(String[] args) {
        double amount;
        double tenure;
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the amount:");
        amount = input.nextDouble();
        System.out.println("Enter the tenure:");
        tenure = input.nextDouble();
        try {
        if(amount<50000 || tenure<12) {
            throw new ArithmeticException("Input Invalid");
        }
        System.out.println("Maturity amount: " + (amount*Math.pow((1+0.75/12),tenure)));
        }
        catch(ArithmeticException e) {
            System.out.println("Amount Insufficient or Tenure Invalid.");
        }
       
    }
}
