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

public class IncomeTaxCalculator {
    public static void main(String[] args) {
        double income,tax=0;
        Scanner input = new Scanner(System.in);
        System.out.println("Input the income:\t");
        income = input.nextDouble();
        if(income>150000){
            tax = 19000+((income-150000)*0.3);
            System.out.println("Income Tax is: " + tax);
        }
        else if(income>60000 && income<150000){
            tax = 1000+((income-60000)*0.2);
            System.out.println("Income Tax is: " + tax);
        }
        else if(income>50000 && income<60000){
            tax = (income-50000)*0.1;
            System.out.println("Income Tax is: " + tax);
        }
        else{
            System.out.println("Income Tax is: " + tax);
        }
    }
}
