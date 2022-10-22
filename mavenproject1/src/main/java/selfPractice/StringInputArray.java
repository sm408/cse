package selfPractice;

/**
 *
 * Name: Shubham Maurya
 * Roll No.: 2010110615
 * Course: CSD213
 */

import java.util.Scanner;
import java.util.Arrays;

public class StringInputArray {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the size of the array:");
        int size = input.nextInt();
        String[] arr = new String[size];
        for(int i = 0; i<size; i++){
            arr[i] = input.next();
        }
        System.out.print("\nStrings in array are:\t");
        for(String arr1 : arr){
            System.out.println(arr1);
        }
        
        System.out.print("\nSorted Strings:\t");
        Arrays.sort(arr);
        for(String arr1 : arr){
            System.out.println(arr1);
        }
        
    }
}
