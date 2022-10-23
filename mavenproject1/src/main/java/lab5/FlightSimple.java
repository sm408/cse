package lab5;

/**
 *
 * Name: Shubham Maurya
 * Roll No.: 2010110615
 * Course: CSD213
 */

import java.util.Scanner;

class Game {
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

public class FlightSimple {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter maximum number of keys:");
        int keystrokes = input.nextInt();
        Game game1 = new Game();
        game1.Game(keystrokes);
        for(int i=0;i<keystrokes;i++) {
            System.out.println("Enter your move" + (i+1));
            char Key = input.next().charAt(0);
            game1.Play(Key);
        }
        game1.Results();
    }
}
