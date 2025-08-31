package Homeworks.Homework05;

/* Для введенной с клавиатуры буквы английского алфавита
   нужно вывести слева стоящую букву на стандартной клавиатуре.
   При этом клавиатура замкнута, т.е. справа от буквы «p»
   стоит буква «a», а слева от "а" буква "р", также соседними
   считаются буквы «l» и буква «z», а буква «m» с буквой «q». */

import java.util.Scanner;

public class Task1 {
    public static void main( String[] args ) {
        String keyboard = "qwertyuiopasdfghjklzxcvbnm";
        Scanner scanner = new Scanner( System.in );
        System.out.println( "### Определение кнопки на клавиатуре левее указанной ###" );
        char letter;
        int index;

        while ( true ) {
            System.out.printf( "Введите буковку англицкую : " );
            letter = scanner.next().toLowerCase().charAt( 0 );
            index = keyboard.indexOf( letter );

            if ( index >= 0 ) break;

            System.out.println( "Введенный символ '" + letter + "' не является латиницей!");
        }

        System.out.println( "Введён символ '" + letter + "' , его индекс " + index );

        int leftindex = index;

        if ( index == 0 ) {
            leftindex = keyboard.length();
        }

        leftindex--;

        System.out.println( "Слева от '" + letter + "' стоит '" + keyboard.toCharArray()[ leftindex ] + "' , его индекс " + leftindex );

        scanner.close();
    }
}
