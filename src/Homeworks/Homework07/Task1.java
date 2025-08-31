package Homeworks.Homework07;

/* === Домашнее задание №7 , задание №1 ===
   Реализовать метод, который на вход принимает ArrayList<T>,
   а возвращает набор уникальных элементов этого массива. Решить, используя коллекции  */

import java.util.ArrayList;

public class Task1 {
    public static void main( String[] args )
    {
        System.out.println( "Hello, World!" );
    }

    public static ArrayList<T> UniqueValue( ArrayList<T> t )
    {
        ArrayList<T> u = new ArrayList<T>();

        for( ArrayList<T> a : t ) {
            if( !u.contains( a ) ) {
                u.add( a );
            }
        }

        return u;
    }

/*
public static <T> Set<T> getUniqueElements(ArrayList<T> list) {
        // Создаем HashSet из ArrayList
        // HashSet автоматически удаляет дубликаты
        Set<T> uniqueSet = new HashSet<>(list);
        return uniqueSet;
    }

    public static void main(String[] args) {
        // Пример использования
        ArrayList<String> myStrings = new ArrayList<>();
        myStrings.add("яблоко");
        myStrings.add("банан");
        myStrings.add("яблоко");
        myStrings.add("апельсин");
        myStrings.add("банан");

        Set<String> uniqueStrings = getUniqueElements(myStrings);
        System.out.println("Уникальные элементы: " + uniqueStrings);
        // Ожидаемый вывод: Уникальные элементы: [апельсин, яблоко, банан] (порядок может отличаться)
    }
    */
}
