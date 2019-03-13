package ru.example;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.*;
import java.math.*;
public class main {

    public static int count (String path){
        int count = 0;

        String line = new String();
        try(FileReader fr = new FileReader(path)) {
            //File words = new File("C:\\Users/Fortapianka/Desktop/words.txt");
            BufferedReader reader = new BufferedReader(fr);
            line = reader.readLine();

            while(line!= null){
                line = reader.readLine();
                count++;
            }
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
        return count;
    }
    public static String word (int count){
        double random = 0;
        String line = new String();
        random = (Math.random()+ 1)*10;
        while (random>count) random = random - count;
        count = 0;
        try(FileReader fr = new FileReader("/Users/Fortapianka/Desktop/words.txt")) {
            //File words = new File("C:\\Users/Fortapianka/Desktop/words.txt");
            BufferedReader reader = new BufferedReader(fr);
            line = reader.readLine();
            random--;
            while(random>0){
                line = reader.readLine();
                random--;
            }
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
        return line;
    }
    public static int game ()
    {
        Scanner in = new Scanner(System.in);
        int bulls = 0, cows = 0, round = 10, end = 0;
        String otvet = new String();
        //String slovo = new String("java");
        String slovo = new String(word(count("/Users/Fortapianka/Desktop/words.txt")));
        System.out.println("Hello World! Its game bulls and cows!");
        System.out.print("I offered word this letter = ");
        System.out.println(slovo.length());
        do {
            bulls = 0; cows = 0; round--;
            System.out.print("Input word ");
            System.out.print(slovo.length());
            System.out.println(" letters --->");

            otvet = in.nextLine();
            for (int i = 0; i < slovo.length(); i++) {
                if (slovo.charAt(i) == otvet.charAt(i))
                    bulls++;
                else
                    for (int j = 0; j < slovo.length(); j++)
                        if (slovo.charAt(i) == otvet.charAt(j))
                            cows++;
                continue;
            }
            System.out.print("Bulls = ");
            System.out.println(bulls);
            System.out.print("Cows = ");
            System.out.println(cows);
            if (round == 0) break;
        } while(bulls < slovo.length());

        if (round == 0) System.out.print("Game over!");
        else
            System.out.println("You win!");
        System.out.print("It is - ");
        System.out.println(slovo);

        System.out.println("Play again? yes = 1 / no = 0");
        end = in.nextInt();
        return end;
    }
    public static void main(String[] args) {
        int a = 1;
        do {
            a = game();
        }
        while (a == 1);
        System.out.println("Goodbye!");
        
    }
}

