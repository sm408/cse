/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classQuestions;

/**
 *
 * @author shubh
 */

import java.util.Scanner;

public class AreaCalculatorCircle {
    public static void main(String[] args) {
        System.out.println("Enter Radius:");
        Scanner input = new Scanner(System.in);
        double radius = input.nextDouble();
        double area = radius*radius*3.141625;
        System.out.println("Area of circle: " + area);
        
    }
}
