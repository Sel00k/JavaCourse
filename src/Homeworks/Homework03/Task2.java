package Homeworks.Homework03;

import java.util.Random;
import java.util.Scanner;

public class Task2 {
    public static void main( String[] args ) {
        Scanner scanner = new Scanner( System.in );
        Random random = new Random();

        String[] choices = { "камень" , "ножницы" , "бумага" };
        int[] stronger = { 2 , 0 , 1 };

        while ( true ) {
            int choiceVasya = random.nextInt(3);
            int choicePetya = random.nextInt(3);

            System.out.println( "Вася выбрал : " + choices[ choiceVasya ] );
            System.out.println( "Петя выбрал : " + choices[ choicePetya ] );

            if ( choiceVasya != choicePetya ) {
                if ( stronger[ choiceVasya ] == choicePetya ) {
                    System.out.println( "Выграл Петя");
                } else {
                    System.out.println( "Выграл Вася");
                }

                break;
            }

            System.out.println( "Переигрываем" );
        }
    }
}
