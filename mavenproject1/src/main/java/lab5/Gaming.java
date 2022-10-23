package lab5;

/**
 *
 * Name: Shubham Maurya Roll No.: 2010110615 Course: CSD213
 */

import java.util.Scanner;

class RandomWalk {

    int row = 10;
    int col = 10;
    int keystrokes;
    int totalMoves = 0;
    
    
    public RandomWalk(int keys){
        this.keystrokes = keys;
    }

    public void move(char S) {
        switch (S) {
            case 'L':
                col = col- 1;
                totalMoves = totalMoves + 1;
                break;
            case 'R':
                col = col + 1;
                totalMoves = totalMoves + 1;   
                break;
            case 'U':
                row = row + 1;
                totalMoves = totalMoves + 1;
                break;
            case 'D':
                row = row - 1;
                totalMoves = totalMoves + 1;
                break;
            default:
                System.out.println("Wrong Input!!!!");
        }
    }
    
    public void IsOver(){
        if(col<0){
            col = 0;
        }
        if ( row >= 19 || col >= 19){
            System.out.println("Lost");
        }
        if(row == 0){
            System.out.println("You won!!! Yayayaayayayaaaaa....");
        }
        if(totalMoves >= keystrokes){
            System.out.println("Game Over");
        }
        
    }
}

class FlightSimple {
        private int altitude=0;
        private int speed=0;
        private int keystrokes;
        private int status = 1;
        public void Game(int keystrokes) {
            this.keystrokes = keystrokes;
        }
        public void Play(char key) {
            if(keystrokes == 0) {
                System.out.println("No more moves left");
            }
            else {
                switch (key) {
                    case 'R':
                        speed = speed + 1;
                        break;
                    case 'L':
                        if(speed == 0) {
                            System.out.println("Speed cannot be reduced further. You lost a move.");
                        }
                        else {
                            speed = speed -1;
                        }   break;
                    case 'U':
                        if(altitude ==0 && speed>2) {
                            altitude = altitude + 1;
                        }
                        else if(altitude ==0 && speed<=2) {
                            System.out.println("Cannot take off. You lost a move.");
                        }
                        else {
                            altitude = altitude + 1;
                        }   break;
                    default:
                        if(altitude == 0) {
                            status = 0;
                            System.out.println("You crashed. Play the rest of the moves to end the game.");
                        }
                        else {
                            altitude = altitude -1;
                        }   break;
                }
                keystrokes = keystrokes - 1;
            }
        }
            public void Results() {
                if (status ==0) {
                    System.out.println("Plane is crashed. You lost!");
                }
                else {
                    if(speed ==0 && altitude ==0) {
                        System.out.println("Flight landed safely. You won!");
                    }
                    else {
                        System.out.println("Plane is crashed. You lost!");
                    }
                }
            }
    }


public class Gaming{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter The Number of Moves you Have:");
        int keystrokes = input.nextInt();
        RandomWalk r1 = new RandomWalk(keystrokes);
        
        System.out.println("\n Now Enter your move: ");
        for(int i = 0; i<keystrokes; i++){
            char ch = input.next().charAt(0);
            System.out.println("Moves left: " + (keystrokes - i -1));
            r1.move(ch);
        }
        
        r1.IsOver();
        
        
    }

}
