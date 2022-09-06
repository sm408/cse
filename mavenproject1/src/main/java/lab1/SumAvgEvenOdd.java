/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab1;

/**
 *
 * @author shubh
 */

import java.util.Scanner;

public class SumAvgEvenOdd {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n;
        double num,sumEven = 0, sumOdd = 0, countEven = 0, countOdd = 0;
        System.out.println("Input the number of numbers to be input: \t");
        n = input.nextInt();
        for(int i = 0; i<n; i++){
            num = input.nextDouble();
            if(num%2==0){
                sumEven=sumEven+num;
                countEven++;
            }
            else{
                sumOdd=sumOdd+num;
                countOdd++;
            }
            
        }
        System.out.println("Sum of Even numbers: " + sumEven);
        System.out.println("Average of Odd numbers: " + sumEven/countEven);
        System.out.println("Sum of Odd numbers: "+sumOdd);
        System.out.println("Average of Odd numbers: "+ sumOdd/countOdd);
    }
}
