/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab1;

/**
 *
 * @author Shubham Maurya
 * @RollNo 2010110615
 * @Course CSD213
 */

import java.util.Scanner;

public class factorial {
    public static void main(String[] args) {
        int num, fact=1;
        Scanner input = new Scanner(System.in);
        System.out.println("Plz input the number: ");
        num = input.nextInt();
        if(num<1){
            System.out.println("Negative numbers not allowed.");
        }
        else{
            for(int i=num; i>0; i--){
                fact = fact*i;
            }
            System.out.println("Factorial is: "+fact);
        }
    }
}
