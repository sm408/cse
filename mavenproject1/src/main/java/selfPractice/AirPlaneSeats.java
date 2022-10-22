package selfPractice;

/**
 *
 * Name: Shubham Maurya
 * Roll No.: 2010110615
 * Course: CSD213
 */

import java.util.Scanner;

public class AirPlaneSeats {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean seats[] = new boolean[10];
        int eco = 0, pre = 0;
        char ch;
        do{
            System.out.println("""
                               1) Book economy class seats.
                               2) Book business class seat.
                               3) Exit
                               """);
            
        }while(ch != 3);


        bookeconomy(seats);
        bookpremium(seats);

    }
    
    public void bookeconomy(boolean arr){
        
    }

}
