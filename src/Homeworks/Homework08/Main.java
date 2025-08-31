package Homeworks.Homework08;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/* === Домашнее задание №8 по теме «Java Collections. Stream API», основное задание ===
   1. Реализовать класс Автомобиль. У класса есть поля "Номер автомобиля"; Модель; Цвет; Пробег; Стоимость,
      свойства и методы.
   2. Проверить работу в классе Main, методе main.
   3. Создать объект Java Collections со списком автомобилей.
   4. Используя Java Stream API, вывести:
      1)  Номера всех автомобилей, имеющих заданный в переменной цвет colorToFind или нулевой пробег mileageToFind.
      2а) Количество уникальных автомобилей в ценовом диапазоне от n до m
      2б) Количество уникальных моделей в ценовом диапазоне от n до m.
      3)  Вывести цвет автомобиля с минимальной стоимостью.
      4а) Среднюю стоимость искомой модели modelToFind
      4б) Среднюю стоимость искомой модели modelToFind1
      4в) Среднюю стоимость искомой модели modelToFind2
 */

public class Main {

    static Automobile car1  = new Automobile( "a123me" , "Mercedes" , "White"  ,      0 , 8300000 );
    static Automobile car2  = new Automobile( "b873of" , "Volga"    , "Black"  ,      0 , 673000  );
    static Automobile car3  = new Automobile( "w487mn" , "Lexus"    , "Grey"   ,  76000 , 900000  );
    static Automobile car4  = new Automobile( "p987hj" , "Volga"    , "Red"    ,    610 , 704340  );
    static Automobile car5  = new Automobile( "c987ss" , "Toyota"   , "White"  , 254000 , 761000  );
    static Automobile car6  = new Automobile( "o983op" , "Toyota"   , "Black"  , 698000 , 740000  );
    static Automobile car7  = new Automobile( "p146op" , "BMW"      , "White"  , 271000 , 850000  );
    static Automobile car8  = new Automobile( "u893ii" , "Toyota"   , "Purple" , 210900 , 440000  );
    static Automobile car9  = new Automobile( "l097df" , "Toyota"   , "Black"  , 108000 , 780000  );
    static Automobile car10 = new Automobile( "y876wd" , "Toyota"   , "Black"  , 160000 , 1000000 );

    public static void main( String[] args )
    {
        List<Automobile> cars = new ArrayList<>();

        String colorToFind = "Black";
        long mileageToFind = 0L;
        long n = 700000L, m = 800000L;
        String modelToFind = "Toyota";
        String modelToFind1 = "Volvo";
        String modelToFind2 = "Volga";
        String r3 = "Null";
        String t1 = "+--------+----------+--------+--------+---------+";
        String t2 = "| Номер  |  Модель  |  Цвет  | Пробег |  Цена   |";

        cars.add( car1 );
        cars.add( car2 );
        cars.add( car3 );
        cars.add( car4 );
        cars.add( car5 );
        cars.add( car6 );
        cars.add( car7 );
        cars.add( car8 );
        cars.add( car9 );
        cars.add( car10 );

        // Номера всех автомобилей, имеющих заданный в переменной цвет colorToFind или нулевой пробег mileageToFind
        List<String> r1 = cars.stream()
                .filter(  car -> car.getMileage() == mileageToFind || car.getColor().equalsIgnoreCase( colorToFind ) )
                .map( Automobile::getNumber )
                .collect( Collectors.toList() );

        // Количество уникальных автомобилей в ценовом диапазоне от n до m
        long r2a = cars.stream()
                .filter(  car -> car.getPrice() >= n )
                .filter(  car -> car.getPrice() <= m )
                .map( Automobile::getNumber )
                .distinct()
                .count();

        // Количество уникальных моделей в ценовом диапазоне от n до m
        long r2b = cars.stream()
                .filter(  car -> car.getPrice() >= n )
                .filter(  car -> car.getPrice() <= m )
                .map( Automobile::getModel )
                .distinct()
                .count();

        // цвет автомобиля с минимальной стоимостью
        Optional<Automobile> r3optional = cars.stream()
                .min( Comparator.comparingLong( Automobile::getPrice ) );
        if( r3optional.isPresent() ) {
            r3 = r3optional.get().getColor();
        }

        // Среднюю стоимость искомой модели modelToFind
        double r4a = cars.stream()
                .filter(  car -> car.getModel().equalsIgnoreCase( modelToFind ) )
                .mapToLong( Automobile::getPrice )
                .average()
                .orElse( 0.0 );

        // Среднюю стоимость искомой модели modelToFind1
        double r4b = cars.stream()
                .filter(  car -> car.getModel().equalsIgnoreCase( modelToFind1 ) )
                .mapToLong( Automobile::getPrice )
                .average()
                .orElse( 0.0 );

        // Среднюю стоимость искомой модели modelToFind2
        double r4c = cars.stream()
                .filter(  car -> car.getModel().equalsIgnoreCase( modelToFind2 ) )
                .mapToLong( Automobile::getPrice )
                .average()
                .orElse( 0.0 );

        System.out.println( "Автомобили в базе :" );
        System.out.println( t1 );
        System.out.println( t2 );
        System.out.println( t1 );
        cars.forEach( System.out::println );
        System.out.println( t1 );
        System.out.println( "" );

        System.out.println( "Номера всех автомобилей, имеющих цвет \"" + colorToFind + "\" или нулевой пробег : " + r1 );
        System.out.println( "Количество уникальных автомобилей в ценовом диапазоне от " + n + " до " + m + " : " + r2a );
        System.out.println( "Количество уникальных моделей в ценовом диапазоне от " + n + " до " + m + " : " + r2b );
        System.out.println( "Цвет автомобиля с минимальной стоимостью : " + r3 );
        System.out.println( "Среднюю стоимость модели \"" + modelToFind  + "\" : " + r4a );
        System.out.println( "Среднюю стоимость модели \"" + modelToFind1 + "\" : " + r4b );
        System.out.println( "Среднюю стоимость модели \"" + modelToFind2 + "\" : " + r4c );
    }
}
