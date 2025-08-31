package Homeworks.Homework07;

/* === Домашнее задание №7 , задание №3 ===
   Реализовать класс PowerfulSet, в котором должны быть следующие методы:
   ● public <T> Set<T> intersection(Set<T> set1, Set<T> set2) – возвращает пересечение двух наборов.
     Пример: set1 = {1, 2, 3}, set2 = {0, 1, 2, 4}. Вернуть {1, 2}
   ● public <T> Set<T> union(Set<T> set1, Set<T> set2) – возвращает объединение двух наборов
     Пример: set1 = {1, 2, 3}, set2 = {0, 1, 2, 4}. Вернуть {0, 1, 2, 3, 4}
   ● public <T> Set<T> relativeComplement(Set<T> set1, Set<T> set2)
     возвращает элементы первого набора без тех, которые находятся также и во втором наборе.
     Пример: set1 = {1, 2, 3}, set2 = {0, 1, 2, 4}. Вернуть {3}
*/

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Task3 {
    public static void main( String[] args )
    {
        powerfulSetInteger();
        powerfulSetString();
//        System.out.println( stringAnagramm( s , t ) );
    }

    public static void powerfulSetInteger() {
        PowerfulSet powerfulSet = new PowerfulSet();

        Set<Integer> setA = new HashSet<>();
        Set<Integer> setB = new HashSet<>();

        setA.add( 1 );
        setA.add( 2 );
        setA.add( 3 );

        setB.add( 0 );
        setB.add( 1 );
        setB.add( 2 );
        setB.add( 4 );

        Set<Integer> setC = powerfulSet.intersection( setA , setB );
        Set<Integer> setD = powerfulSet.union( setA , setB );
        Set<Integer> setE = powerfulSet.relativeComplement( setA , setB );
//        Scanner scanner = new Scanner( System.in );

        System.out.println( "Set A : " + setA.toString() );
        System.out.println( "Set B : " + setB.toString() );
        System.out.println( "Set A intersection B : " + setC.toString() );
        System.out.println( "Set A union B : " + setD.toString() );
        System.out.println( "Set A relative complement B : " + setE.toString() );
    }

    public static void powerfulSetString() {
        PowerfulSet powerfulSet = new PowerfulSet();

        Set<String> setA = new HashSet<>();
        Set<String> setB = new HashSet<>();

        setA.add("Яблоко");
        setA.add("Банан");
        setA.add("Апельсин");

        setB.add("Банан");
        setB.add("Виноград");
        setB.add("Яблоко");

        Set<String> setC = powerfulSet.intersection( setA , setB );
        Set<String> setD = powerfulSet.union( setA , setB );
        Set<String> setE = powerfulSet.relativeComplement( setA , setB );
//        Scanner scanner = new Scanner( System.in );

        System.out.println( "Set A : " + setA.toString() );
        System.out.println( "Set B : " + setB.toString() );
        System.out.println( "Set A intersection B : " + setC.toString() );
        System.out.println( "Set A union B : " + setD.toString() );
        System.out.println( "Set A relative complement B : " + setE.toString() );
    }
}
