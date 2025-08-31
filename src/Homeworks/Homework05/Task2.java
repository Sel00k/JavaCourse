package Homeworks.Homework05;

/* Задана последовательность, состоящая только из символов ‘>’, ‘<’ и ‘-‘.
   Требуется найти количество стрел, которые спрятаны в этой последовательности.
   Стрелы – это подстроки вида ‘>>-->’ и ‘<--<<’. Строка может содержать до 106 символов.
   Выходные данные: в единственную строку выходного потока нужно вывести искомое количество стрелок. */

import java.util.Scanner;

public class Task2 {
    public static void main( String[] args ) {

        /* Так как шаблон стрелок фиксированные и специфические, в этой оптимизированной реализации длины заданы константой */

        int MAX_LEN_LINE = 106;
        String arrowLeft  = "<--<<";  // если шаблон изменится, обратить внимание на строку 39 (метка l1)
        String arrowRight = ">>-->";  // если шаблон изменится, обратить внимание на строку 44 (метка l2)
        Scanner scanner = new Scanner( System.in );

        System.out.printf( "Введите строку с стрелочками : " );
        String text = scanner.nextLine();

        if ( text.length() > MAX_LEN_LINE ) {
            System.out.println( "Введена слишком длинная строка, оставляем первые " + MAX_LEN_LINE + " символов" );
            text = text.substring( 0 , MAX_LEN_LINE );
            System.out.println( "Осталось от строки: " + text );
        }

        String str;
        int lenSeekText = text.length() - 4;
        int countLeft = 0 , countRight = 0;

        /* Считаем стрелки влево  */
        for ( int index = 0 ; index < lenSeekText ; index++ ) {
            str = text.substring( index , index + 5 );

            if ( str.equals( arrowLeft ) ) {
                countLeft++;
                l1:             index += 3; // 3 потому что допускаем нахлёст стрелок, иначе 4; если шаблон стрелки поменяется, то эту строку удалить или число скорректировать
            }

            if ( str.equals( arrowRight ) ) {
                countRight++;
                l2:             index += 3; // 3 потому что допускаем нахлёст стрелок, иначе 4; если шаблон стрелки поменяется, то эту строку удалить или число скорректировать
            }
        }

        System.out.println( arrowLeft + " : " + countLeft + " и " + arrowRight + " : " + countRight);

        scanner.close();
    }
}
