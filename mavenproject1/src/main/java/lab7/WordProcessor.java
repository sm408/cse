package lab7;


import java.util.Scanner;




public class WordProcessor {
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a paragraph: ");
        String paragraph = input.nextLine();

        System.out.println("\n\nThe paragraph is: " + paragraph);
        
//1. The unique words in the input:
//a. In the order they appeared in the input string
//b. In alphabetical order (normal lexicographic order)
//c. In order of increasing word size. That is all 1 letter words first, then 2 letter words, then
//3 letter words etc. If there are multiple words with the same length, then these should
//be listed in lexicographic order.
//d. In order of increasing frequency of occurrence. If two words have the same frequency
//count, then they appear in the same order as the initial input
//2. The count of the words in the input text that start with each letter of the alphabet
//3. The usage of the reserved words in the input
//a. in the order they appeared in the input
//b. In order of decreasing frequency of occurrence in the input

        System.out.println("\n\nThe unique words in the paragraph are: ");
        String[] words = paragraph.split(" ");
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (words[i].equals(words[j])) {
                    words[j] = "0";
                }
            }
            if (words[i] != "0") {
                System.out.println(words[i]);
            }
        }



        System.out.println("\n\nThe unique words in the paragraph in alphabetical order are: ");
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (words[i].compareTo(words[j]) > 0) {
                    String temp = words[i];
                    words[i] = words[j];
                    words[j] = temp;
                }
            }
        }
        for (int i = 0; i < words.length; i++) {
            if (words[i] != "0") {
                System.out.println(words[i]);
            }
        }



        System.out.println("\n\nThe unique words in the paragraph in order of increasing length are: ");
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (words[i].length() > words[j].length()) {
                    String temp = words[i];
                    words[i] = words[j];
                    words[j] = temp;
                }
            }
        }
        for (int i = 0; i < words.length; i++) {
            if (words[i] != "0") {
                System.out.println(words[i]);
            }
        }
        

        System.out.println("\n\nThe count of word starting with each letter are: ");
        int[] count1 = new int[26];
        for (int i = 0; i < words.length; i++) {
            boolean unique = true;
            for (int j = 0; j < i; j++) {
                if (words[i].equals(words[j])) {
                    unique = false;
                    break;
                }
            }
            if (unique) {
                for (int k = 0; k < words.length; k++) {
                    if (words[i].equals(words[k])) {
                        count1[words[i].charAt(0) - 'a']++;
                    }
                }
            }
        }
        for (int i = 0; i < 26; i++) {
            if (count1[i] != 0) {
                System.out.println((char) (i + 'a') + " " + count1[i]);
            }
        }


        System.out.println("\n\nThe unique words in the paragraph in order of frequency of occurrence are: ");
        int[] count = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words.length; j++) {
                if (words[i].equals(words[j])) {
                    count[i]++;
                }
            }
        }
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words.length; j++) {
                if (count[i] > count[j]) {
                    int temp = count[i];
                    count[i] = count[j];
                    count[j] = temp;
                    String temp1 = words[i];
                    words[i] = words[j];
                    words[j] = temp1;
                }
            }
        }
        for (int i = 0; i < words.length; i++) {
            boolean unique = true;
            for (int j = 0; j < i; j++) {
                if (words[i].equals(words[j])) {
                    unique = false;
                    break;
                }
            }
            if (unique) {
                System.out.println(words[i] + " " + count[i]);
            }
        }

    

        System.out.println("\n\nThe count of word starting with each letter are: ");
        int[] count1 = new int[26];
        for (int i = 0; i < words.length; i++) {
            boolean unique = true;
            for (int j = 0; j < i; j++) {
                if (words[i].equals(words[j])) {
                    unique = false;
                    break;
                }
            }
            if (unique) {
                for (int k = 0; k < words.length; k++) {
                    if (words[i].equals(words[k])) {
                        count1[words[i].charAt(0) - 'a']++;
                    }
                }
            }
        }
        for (int i = 0; i < 26; i++) {
            if (count1[i] != 0) {
                System.out.println((char) (i + 'a') + " " + count1[i]);
            }
        }

        



    }
}
