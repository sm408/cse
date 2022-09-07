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
import java.util.Scanner;

public class bubbleSearch {

    static void sort(int arr[], int size) {
        for (int i = 1; i < size; i++) {
            int key = i;
            for (int j = key - 1; j >= 0; j--) {
                if (arr[key] < arr[j]) {
                    int temp = arr[j];
                    arr[j] = arr[key];
                    arr[key] = temp;
                    key = key - 1;
                } else {
                    break;
                }
            }

        }
    }
    
    static int bubbleSearch(int arr[], int size, double n){
        int max = size -1, min = 0;
        int mid = (max+min)/2;
        while(arr[mid] != n){
            if(arr[mid]>n){
                min = mid;
                mid = (min+max)/2;
            }
            else{
                max = mid;
                mid = (min+max)/2;
            }
        }
        return mid+1;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Input the size of Array: ");
        int size = input.nextInt();
        int arr[] = new int[size];
        System.out.println("Input the numbers in array:");
        for (int i = 0; i < size; i++) {
            arr[i] = input.nextInt();
        }
        sort(arr, size);
        
        System.out.println("ENter the number to be searched: ");
        double search = input.nextDouble();
        
        int index = bubbleSearch(arr, size, search);
        
        System.out.print("The number found at index : " + index);
    }

}
