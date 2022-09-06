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
//class to convert hexadecimal to decimal

import java.util.Scanner;

public class hexaDecimalToDecimal {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a hexadecimal number");
        String hexaDecimal = input.nextLine();
        int decimal = 0;
        for (int i = 0; i < hexaDecimal.length(); i++) {
            char hexaChar = hexaDecimal.charAt(i);
            decimal = decimal * 16 + hexaCharToDecimal(hexaChar);
        }
        System.out.println("The decimal value for the hexadecimal number " + hexaDecimal + " is " + decimal);
    }

    public static int hexaCharToDecimal(char hexaChar) {
        if (hexaChar >= 'A' && hexaChar <= 'F')
            return 10 + hexaChar - 'A';
        else
            return hexaChar - '0';
    }
}
