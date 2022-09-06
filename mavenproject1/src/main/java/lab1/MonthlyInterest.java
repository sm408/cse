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
import java.lang.Math;
import java.text.DecimalFormat;


public class MonthlyInterest {
    
    private static final DecimalFormat df = new DecimalFormat("0.00");

    public static void main(String[] args) {
        System.out.println("Enter Interest Rate:");
        Scanner input = new Scanner(System.in);
        double rate = input.nextDouble();
        System.out.println("Enter Number of Years:");
        double years = input.nextDouble();
        System.out.println("Enter Loan Amount:");
        double amount = input.nextDouble();
        double payment = (amount*(rate/1200))/(1-(1/Math.pow(1+(rate/1200),years*12)));
        System.out.println("Monthly Payment is: " + df.format(payment));
    }
}