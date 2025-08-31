package Homeworks.Homework08.test;

/* === Домашнее задание №8 по теме «Java Collections. Stream API», дополнительное задание ===
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
   5. Реализовать ввод и вывод программы в файл *.txt.
   6. Вынести методы работы с автомобилем в папку repository интерфейс
      CarsRepository и его реализацию CarsRepositoryText.
   7. Доработать программу до следующей структуры
      * файл с данными по пути \src\Homeworks\Homework08\data\cars.txt
      * файл с результатами по пути \src\Homeworks\Homework08\data\result.txt
   8. CarsRepositoryText обеспечивает уникальность номера автомобиля в списке
*/


import Homeworks.Homework08.repository.CarsRepositoryText;

public class Main {

    public static void main( String[] args )
    {
        String currentDirectory = System.getProperty( "user.dir" );
        System.out.println( "Текущая рабочая директория: " + currentDirectory );
        String fileNameCars   = currentDirectory + "\\src\\Homeworks\\Homework08\\data\\cars.txt";
        String fileNameResult = currentDirectory + "\\src\\Homeworks\\Homework08\\data\\result.txt";

        CarsRepositoryText carsRepository = new CarsRepositoryText( fileNameCars , fileNameResult );

        carsRepository.writeCars();
        carsRepository.writeNumbersFromColorAndMileag();
        carsRepository.writeUniqueCars();
        carsRepository.writeUniqueModels();
        carsRepository.writeColorMinPrice();
        carsRepository.writeAvePriceModel();
     }
}
