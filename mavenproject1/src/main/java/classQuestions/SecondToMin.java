/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classQuestions;

/**
 *
 * @author shubh
 */

import  java.util.Scanner;

public class SecondToMin {
    public static void main(String[] args) {
        System.out.println("Enter time in Seconds:");
        Scanner input = new Scanner(System.in);
        int seconds,minutes,remSeconds;
        seconds = input.nextInt();
        minutes = seconds/60;
        remSeconds = seconds%60;
        System.out.println("Time-> "+minutes+" min :"+remSeconds +" seconds");
    }
}
