/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package selfPractice;

/**
 *
 * Name: Shubham Maurya
 * Roll No.: 2010110615
 * Course: CSD213
 */

import java.util.Scanner;

public class DigitClassifier {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int initialNumber, lastNumber;
        System.out.println("Input the initial number");
        initialNumber = input.nextInt();
        System.out.println("Input the last number");
        lastNumber = input.nextInt();
        for(int i = initialNumber; i<=lastNumber; i++){
            int sumOfDig = 0, num = i;
            int flag = 1;
            int lastDig = 9, secondLDig;
            if(num%9==0){
                for(;num!=0;){
                    sumOfDig = sumOfDig+(num%10);
                    num = num/10;
                }
                if(sumOfDig != 9){
                    continue;
                }
                num = i;
                while(num!=0){
                    secondLDig = num%10;
                    num=num/10;
                    if(secondLDig>lastDig){
                        flag = 0;
                        break;
                    }
                    lastDig = secondLDig;
                }
                if(flag==1){
                System.out.println(i);
                }
            }
        }
    }
}
