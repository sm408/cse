/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package classQuestions;

/**
 *
 * Name: Shubham Maurya
 * Roll No.: 2010110615
 * Course: CSD213
 */
import java.util.Scanner;

public class angelTriangle {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the coordinates of the three points of the triangle");
        System.out.println("Enter the coordinates of the first point");
        double x1 = input.nextDouble();
        double y1 = input.nextDouble();
        System.out.println("Enter the coordinates of the second point");
        double x2 = input.nextDouble();
        double y2 = input.nextDouble();
        System.out.println("Enter the coordinates of the third point");
        double x3 = input.nextDouble();
        double y3 = input.nextDouble();
        double a = Math.sqrt(Math.pow(x2 - x3, 2) + Math.pow(y2 - y3, 2));
        double b = Math.sqrt(Math.pow(x1 - x3, 2) + Math.pow(y1 - y3, 2));
        double c = Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
        double A = Math.toDegrees(Math.acos((a * a - b * b - c * c) / (-2 * b * c)));
        double B = Math.toDegrees(Math.acos((b * b - a * a - c * c) / (-2 * a * c)));
        double C = Math.toDegrees(Math.acos((c * c - b * b - a * a) / (-2 * a * b)));
        System.out.println("The angles of the triangle are " + A + " " + B + " " + C);
    }
}
