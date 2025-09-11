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

        ArrayList<String>  sUniqueList = UniqueValue1( sList );
        ArrayList<Integer> iUniqueList = UniqueValue1( iList );
        Set<String>  sSet = UniqueValue( sList );
        Set<Integer> iSet = UniqueValue( iList );

        System.out.println( "" );
        System.out.println( "ArrayList со строками : " + sList );
        System.out.println( "его уникальные элементы : " + sUniqueList );
        System.out.println( "его уникальные элементы : " + sSet );

        System.out.println( "" );
        System.out.println( "ArrayList с Integer : " + iList );
        System.out.println( "его уникальные элементы : " + iUniqueList );
        System.out.println( "его уникальные элементы : " + iSet );
    }

    public static <T> ArrayList<T> UniqueValue1( ArrayList<T> t )
    {
        ArrayList<T> u = new ArrayList<>();
//        Object a;
//        T a;

        for( T a : t ) {
            if( !u.contains( a ) ) {
                u.add( a );
            }
        }

        return u;
    }

    public static <T> Set<T> UniqueValue( ArrayList<T> list )
    {
        Set<T> u = new HashSet<>( list );
        return u;
    }
}
