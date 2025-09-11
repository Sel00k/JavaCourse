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

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task3 {
    public static void main( String[] args )
    {
        System.out.println( "Вариант с Integer" );
        System.out.println( "" );
        powerfulSetInteger();
        System.out.println( "---------------------------" );
        System.out.println( "" );

        System.out.println( "Вариант с строками" );
        System.out.println( "" );
        powerfulSetString();
        System.out.println( "---------------------------" );
        System.out.println( "" );

        System.out.println( "Вариант со списком строк" );
        System.out.println( "" );
        powerfulSetArrayList();
        System.out.println( "---------------------------" );
        System.out.println( "" );
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

        Set<Integer> setExC = powerfulSet.intersectionEx( setA , setB );
        Set<Integer> setExD = powerfulSet.unionEx( setA , setB );
        Set<Integer> setExE = powerfulSet.relativeComplementEx( setA , setB );

        System.out.println( "Set A : " + setA );
        System.out.println( "Set B : " + setB );
        System.out.println( "" );
        System.out.println( "Set   A intersection B : " + setC );
        System.out.println( "SetEx A intersection B : " + setExC );
        System.out.println( "" );
        System.out.println( "Set   A union B : " + setD );
        System.out.println( "SetEx A union B : " + setExD );
        System.out.println( "" );
        System.out.println( "Set   A relative complement B : " + setE );
        System.out.println( "SetEx A relative complement B : " + setExE );
        System.out.println( "" );
    }

    public static void powerfulSetString() {
        PowerfulSet powerfulSet = new PowerfulSet();

        Set<String> setA = new HashSet<>();
        Set<String> setB = new HashSet<>();

        setA.add( "Яблоко" );
        setA.add( "Банан" );
        setA.add( "Апельсин" );

        setB.add( "Банан" );
        setB.add( "Виноград" );
        setB.add( "Яблоко" );

        Set<String> setC = powerfulSet.intersection( setA , setB );
        Set<String> setD = powerfulSet.union( setA , setB );
        Set<String> setE = powerfulSet.relativeComplement( setA , setB );

        Set<String> setExC = powerfulSet.intersectionEx( setA , setB );
        Set<String> setExD = powerfulSet.unionEx( setA , setB );
        Set<String> setExE = powerfulSet.relativeComplementEx( setA , setB );

        System.out.println( "Set A : " + setA );
        System.out.println( "Set B : " + setB );
        System.out.println( "" );
        System.out.println( "Set   A intersection B : " + setC );
        System.out.println( "SetEx A intersection B : " + setExC );
        System.out.println( "" );
        System.out.println( "Set   A union B : " + setD );
        System.out.println( "SetEx A union B : " + setExD );
        System.out.println( "" );
        System.out.println( "Set   A relative complement B : " + setE );
        System.out.println( "SetEx A relative complement B : " + setExE );
        System.out.println( "" );
    }

    public static void powerfulSetArrayList() {
        PowerfulSet powerfulSet = new PowerfulSet();

        Set<ArrayList<String>> setA = new HashSet<>();
        Set<ArrayList<String>> setB = new HashSet<>();

        ArrayList<String> al1 = Stream.of( "Яблоко" , "Банан" , "Вишня" )
            .collect( Collectors.toCollection( ArrayList::new ) );

        ArrayList<String> al2 = Stream.of( "Яблоко" , "Банан" , "Мандарин" )
            .collect( Collectors.toCollection( ArrayList::new ) );

        // а можно и так
        ArrayList<String> al3 = new ArrayList<>( List.of( "Кокос" , "Манго" ) );

        ArrayList<String> al4 = Stream.of( "Виноград" , "Манго" , "Персик" )
            .collect( Collectors.toCollection( ArrayList::new ) );

        ArrayList<String> al5 = Stream.of( "Яблоко" , "Груша" )
            .collect( Collectors.toCollection( ArrayList::new ) );

        setA.add( al1 );
        setA.add( al3 );
        setA.add( al4 );

        setB.add( al1 );
        setB.add( al2 );
        setB.add( al3 );
        setB.add( al5 );

        Set<ArrayList<String>> setC = powerfulSet.intersection( setA , setB );
        Set<ArrayList<String>> setD = powerfulSet.union( setA , setB );
        Set<ArrayList<String>> setE = powerfulSet.relativeComplement( setA , setB );

        Set<ArrayList<String>> setExC = powerfulSet.intersectionEx( setA , setB );
        Set<ArrayList<String>> setExD = powerfulSet.unionEx( setA , setB );
        Set<ArrayList<String>> setExE = powerfulSet.relativeComplementEx( setA , setB );

        System.out.println( "Set A : " + setA );
        System.out.println( "Set B : " + setB );
        System.out.println( "" );
        System.out.println( "Set   A intersection B : " + setC );
        System.out.println( "SetEx A intersection B : " + setExC );
        System.out.println( "" );
        System.out.println( "Set   A union B : " + setD );
        System.out.println( "SetEx A union B : " + setExD );
        System.out.println( "" );
        System.out.println( "Set   A relative complement B : " + setE );
        System.out.println( "SetEx A relative complement B : " + setExE );
        System.out.println( "" );
    }
}
