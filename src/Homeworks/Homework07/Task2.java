package Homeworks.Homework07;

/* === Домашнее задание №7 , задание №2 ===
   С консоли на вход подается две строки s и t.
   Необходимо вывести true, если одна строка является валидной анаграммой другой строки,
   и false – если это не так
*/

/* Для проверки:
   ● Бейсбол – бобслей
   ● Героин – регион
   ● Клоака – околка
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Task2 {
    public static void main( String[] args )
    {
        Scanner scanner = new Scanner( System.in );

        System.out.printf( "Введите первую строку > " );
        String s = scanner.nextLine();
        System.out.printf( "Введите вторую строку > " );
        String t = scanner.nextLine();

        System.out.println( stringAnagramm( s , t ) );
    }

    public static boolean stringAnagramm( String s ,  String t )
    {
        if ( s.length() != t.length() ) {
            return false;
        }

        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();
        Arrays.sort( sArray );
        Arrays.sort( tArray );
        return Arrays.equals( sArray , tArray );
    }
}
