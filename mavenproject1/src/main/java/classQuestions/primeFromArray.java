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

public class primeFromArray {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Input the size of Array: ");
        int size = input.nextInt();
        int arr[] = new int[size];
        System.out.println("Input the numbers in array:");
        for(int i = 0; i<size; i++){
            arr[i] = input.nextInt();
        }
        
        System.out.println("Prime numbers in the array are:");
        
        for(int i = 0 ; i<size; i++){
            int flag =1;
            for(int j=2; j<=(arr[i]/2);j++){
                if(arr[i]%j==0){
                    flag = 0;
                    break;
                }
                
            }
            if(flag == 1){
                System.out.println(arr[i]);
            }
            
        }
        
    }
}
