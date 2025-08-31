package Homeworks.Homework07;

import java.util.HashSet;
import java.util.Set;

public class PowerfulSet {


    // возвращает пересечение двух наборов.
    // Пример: set1 = {1, 2, 3}, set2 = {0, 1, 2, 4}. Вернуть {1, 2}
    public <T> Set<T> intersection( Set<T> set1 , Set<T> set2 ) {
        // Создаем копию set1, чтобы не изменять set2
        Set<T> intersection = new HashSet<>( set1 );

        // Находим пересечение (оставляет общие элементы в intersection)
        intersection.retainAll( set2 );
        return intersection;
    }

    // возвращает объединение двух наборов
    // Пример: set1 = {1, 2, 3}, set2 = {0, 1, 2, 4}. Вернуть {0, 1, 2, 3, 4}
    public <T> Set<T> union( Set<T> set1 , Set<T> set2 ) {
        // Создаем новое множество для объединения
        Set<T> unionSet = new HashSet<>( set1 ); // Добавляем все элементы из setA
        unionSet.addAll( set2 ); // Добавляем все элементы из setB
        return unionSet;
    }

    // возвращает элементы первого набора без тех, которые находятся также и во втором наборе.
    // Пример: set1 = {1, 2, 3}, set2 = {0, 1, 2, 4}. Вернуть {3}
    public <T> Set<T> relativeComplement( Set<T> set1 , Set<T> set2 ) {
        Set<T> differenceSet = new HashSet<>( set1 );
        differenceSet.removeAll( set2 ); // Удалит из differenceSet элементы, общие с setB
        return differenceSet;
    }
}
