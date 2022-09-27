package lab3;

/**
 *
 * Name: Shubham Maurya
 * Roll No.: 2010110615
 * Course: CSD213
 */

import java.util.Scanner;
import java.util.Arrays;

public class CompareStrings {
    
    static void Sort(int[] arr, int size){
        for (int i = 1; i < size; i++) {
            int key = i;
            for (int j = key - 1; j >= 0; j--) {
                if (arr[key] < arr[j]) {
                    int temp = arr[j];
                    arr[j] = arr[key];
                    arr[key] = temp;
                    key = key - 1;
                }
                else{
                    break;
                }
            }

        }
        System.out.println("Sorted Array is: ");
        for(int i=0; i<arr.length; i++){
            System.out.println(arr[i]+"\t");
        }
    };
    
    static void Sort(int[] arr, int size, boolean rev){
        for (int i = 1; i < size; i++) {
            int key = i;
            for (int j = key - 1; j >= 0; j--) {
                if (arr[key] > arr[j]) {
                    int temp = arr[j];
                    arr[j] = arr[key];
                    arr[key] = temp;
                    key = key - 1;
                }
                else{
                    break;
                }
            }

        }
        System.out.println("Sorted Array is: ");
        for(int i=0; i<arr.length; i++){
            System.out.println(arr[i]+"\t");
        }
    };
    
    static void Sort(String arr[], int n){
        Arrays.sort(arr);
        System.out.println("Sorted String is: ");
        for (String arr1 : arr) {
            System.out.println(arr1 + "\t");
        }
    }
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.println("""
                           What to you want to Sort:
                           0: String
                           1: Integer array
                            """);
        int a = input.nextInt();
        if(a==0){
            System.out.println("Enter the Size of the Array: ");
            int size = input.nextInt();
            String array[] = new String[size];
            for(int i=0;i<size;i++) {
                array[i] = input.next();
            }
            Sort(array, size);
        }
        else{
            System.out.println("Input the ize of array: ");
            int size = input.nextInt();
            int arr[] = new int[size];
            System.out.println("Input the numbers in array:");
            for(int i = 0; i<size; i++){
                arr[i] = input.nextInt();
            }
            System.out.println("""
                               How you want the array to be Sorted:
                               0 (false): Ascending
                               1 (true): Descending
                                """);
            boolean rev = input.nextBoolean();
            if(rev==false){
                Sort(arr,size);
            }
            else{
                Sort(arr,size,rev);
            }
        }
    }

}
