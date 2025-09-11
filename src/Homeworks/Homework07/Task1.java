package Homeworks.Homework07;

/* === Домашнее задание №7 , задание №1 ===
   Реализовать метод, который на вход принимает ArrayList<T>,
   а возвращает набор уникальных элементов этого массива. Решить, используя коллекции  */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Task1 {
    public static void main( String[] args )
    {
        ArrayList<String>  sList = new ArrayList<>();
        ArrayList<Integer> iList = new ArrayList<>();

        sList.add( "яблоко"   );
        sList.add( "банан"    );
        sList.add( "яблоко"   );
        sList.add( "апельсин" );
        sList.add( "банан"    );

        iList.add( 1  );
        iList.add( 2  );
        iList.add( 1  );
        iList.add( 3  );
        iList.add( 8  );
        iList.add( 2  );
        iList.add( 19 );
        iList.add( 4  );

        ArrayList<String>  sUniqueList = UniqueListValue( sList );
        ArrayList<Integer> iUniqueList = UniqueListValue( iList );
        Set<String>  sSet = UniqueSetValue( sList );
        Set<Integer> iSet = UniqueSetValue( iList );

        System.out.println( "" );
        System.out.println( "ArrayList со строками : " + sList );
        System.out.println( "его уникальные элементы (список) : " + sUniqueList );
        System.out.println( "его уникальные элементы (множество) : " + sSet );

        System.out.println( "" );
        System.out.println( "ArrayList с Integer : " + iList );
        System.out.println( "его уникальные элементы (список) : " + iUniqueList );
        System.out.println( "его уникальные элементы (множество) : " + iSet );
    }

    // Используем то что множества автоматически не содержат повторяющиеся элементы
    public static <T> Set<T> UniqueSetValue( ArrayList<T> list )
    {
        Set<T> u = new HashSet<>( list );
        return u;
    }

    // Реализуем в ручную (коллекция может быть ArrayList, Set и даже Map (надо только добавить подсчет встречаемости) )
    public static <T> ArrayList<T> UniqueListValue( ArrayList<T> t )
    {
        ArrayList<T> u = new ArrayList<>();

        for( T a : t ) {
            if( !u.contains( a ) ) {
                u.add( a );
            }
        }

        return u;
    }
}
