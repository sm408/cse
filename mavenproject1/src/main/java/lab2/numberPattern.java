/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package lab2;

/**
 *
 * Name: Shubham Maurya
 * Roll No.: 2010110615
 * Course: CSD213
 */

import  java.util.Scanner;

public class numberPattern {
    public static void main(String[] args) {
        int n;
        Scanner input = new Scanner(System.in);
        System.out.println("Input any number: ");
        n = input.nextInt();
        for(int i = 1; i<=n; i++){
            for(int j = 0; j<i; j++){
                System.out.print(i);
            }
            System.out.print("\n");
        }
    }

}

