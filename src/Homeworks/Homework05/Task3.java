package Homeworks.Homework05;

/* Задана строка, состоящая из букв английского алфавита, разделенных одним пробелом.
   Необходимо каждую последовательность символов упорядочить по возрастанию
   и вывести слова в нижнем регистре. */

import java.util.Arrays;
import java.util.Scanner;

public class Task3 {
    public static void main( String[] args ) {
        Scanner scanner = new Scanner( System.in );
        String[] words;

        System.out.println( "### Сортировка символов в каждом слове строки ###" );

        while ( true ) {
            System.out.printf( "Введите строку (два слова разделённых пробелом) : " );
            String text = scanner.nextLine();
            words = text.toLowerCase().split( "\\s+" );   // Один или несколько (пробел или длинный пробел или табуляция)

            if ( words.length == 2 ) break;

            System.out.println( "Должно быть именно 2 слова!" );
        }

        for ( int i = 0 ; i < words.length ; i++ ) {
            char[] charArray = words[ i ].toCharArray();
            Arrays.sort( charArray );
            words[ i ] = new String( charArray );

            System.out.println( words[ i ] );
        }

        System.out.println( "Получилось : " + String.join( " " , words ) );

        scanner.close();
    }
}
