package Attestation.Attestation01;

/* Необходимо реализовать приложение,
   принимающее список пользователей, список продуктов
   и обрабатывающее покупку пользователя */

import java.util.Scanner;

public class App {
    public static void main( String[] args ) {

        String marketName = "НАш МАркет за угЛОМ";
        ListPerson persons = new ListPerson();
        ListProduct products = new ListProduct();

        System.out.printf( "### %s ###\n\n" , marketName );

        persons.read();                      // Вносим покупателей с клавиатуры
        persons.print();                     // Сколько есть денег у покупателей
        products.read();                     // Вносим продукты с клавиатуры
        products.print();                    // Цены на продукты
        acquisition( persons , products );   // Вносим покупки с клавиатуры
        persons.check();                     // Кто, что купил
        persons.print();                     // Сколько осталось у покупателя
    }

    private static void acquisition( ListPerson persons , ListProduct products ) {
        String endCommand = "END";
        Scanner scanner = new Scanner( System.in );
        Product p;
        String strPurchase , namePerson , nameProduct;
        String[] x;

        // Ввод строки со списком продуктов через ;
        System.out.println( "Введите покупку (имя покупателя и название продукта разделяя '-')" );
        System.out.println( "Например : Павел Андреевич - Хлеб" );
        System.out.println( endCommand + " - завершение ввода покупок" );

        while ( true ) {
            System.out.printf( "[ Покупка ] >>> " );
            strPurchase = scanner.nextLine();

            if ( strPurchase.equalsIgnoreCase( endCommand ) ) return;

            x = strPurchase.split( "-" );

            if ( x.length == 2 ) {
                namePerson = x[0].trim();
                nameProduct = x[1].trim();
                p = products.find( nameProduct );

                if( p != null ) {
                    persons.purchase( namePerson , p );
                } else {
                    System.out.println("Продукт с именем \"" + nameProduct + "\" не найден" );
                }
            } else {
                System.out.println( "\"" + strPurchase + "\" : не удалось расшифровать" );
            }
        }
    }
}
