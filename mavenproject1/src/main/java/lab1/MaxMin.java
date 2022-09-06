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

public class MaxMin {
    public static void main(String[] args) {
        int n,num,max=0;
        Scanner input = new Scanner(System.in);
        System.out.println("Input the number of inputs to be taken:\t");
        n = input.nextInt();
        System.out.println("Plz input the numbers:");
        for(int i=0;i<n;i++){
            num = input.nextInt();
            if(num>max){
                max=num;
            }
        }
        System.out.println("The largest number was "+ max);
    }
}
