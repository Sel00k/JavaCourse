package Homeworks.Homework03;

import java.util.Scanner;

public class Task1 {
    //
    public static void main( String[] args ) {
        Scanner scanner = new Scanner( System.in );
        System.out.printf( "Ваше имя : " );
        String name = scanner.nextLine();
        System.out.printf("Привет, %s!\n" , name );
    }
}
