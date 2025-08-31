package Homeworks.Homework06;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class App {
    public static void main( String[] args ) throws ParseException {
        market();
    }

    public static void market() {
        LocalDate date;
        String marketName = "НАш МАркет за угЛОМ";
        ListBuyer buyers = new ListBuyer();                        // Покупатели
        ListDiscountProduct products = new ListDiscountProduct();     // Продукты в магазине

        System.out.printf( "### %s ###\n\n" , marketName );

        buyers.read();                       // Вносим покупателей с клавиатуры
        buyers.print();                      // Сколько есть денег у покупателей
        products.read();                     // Вносим продукты с клавиатуры

        date = MarketDateRead();             // Вносим операционную дату
        buyers.setMarketDate( date );        // сообщаем покупателям
        products.setMarketDate( date );      // сообщаем, как бы, кассирам

        products.print();                    // Цены на продукты и скидки
        acquisition( buyers , products );    // Вносим покупки с клавиатуры
        buyers.check();                      // Кто, что купил
        buyers.print();                      // Сколько осталось у покупателя
    }

    private static void acquisition( ListBuyer bayers , ListDiscountProduct products ) {
        String endCommand = "END";
        Scanner scanner = new Scanner( System.in );
        DiscountProduct p;
        String strPurchase , nameBayer , nameProduct;
        String[] x;

        // Ввод строки со списком продуктов через ;
        System.out.println( "Введите покупку (имя покупателя и название продукта разделяя '-')" );
        System.out.println( "Например : Павел Андреевич - Хлеб" );
        System.out.println( endCommand + " - завершение ввода покупок" );

        while ( true ) {
            System.out.printf( "[ Покупка ] >>> " );
            strPurchase = scanner.nextLine();

            if ( strPurchase.equalsIgnoreCase( endCommand ) ) {
                System.out.println( "" );
                return;
            }

            x = strPurchase.split( "-" );

            if ( x.length == 2 ) {
                nameBayer = x[0].trim();
                nameProduct = x[1].trim();
                p = products.find( nameProduct );

                if( p != null ) {
                    bayers.purchase( nameBayer , p );
                } else {
                    System.out.println("Продукт с именем \"" + nameProduct + "\" не найден" );
                }
            } else {
                System.out.println( "\"" + strPurchase + "\" : не удалось расшифровать" );
            }
        }
    }

    private static LocalDate MarketDateRead() {
        Scanner scanner = new Scanner( System.in );
        LocalDate currentDate = LocalDate.now() , date = LocalDate.now();
        String str , strDate , pattern = "dd.MM.yyyy" , endCommand = "END";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern( pattern );
        boolean correctDate = false;
        System.out.println( "Введите операционную дату (тот день в который будут производиться покупки) в формате ДД,ММ,ГГГГ." );
        System.out.println( "Сегодня " + currentDate.format( formatter ) + ". Пустая строка будет означать сегодняшнею дату." );

        while ( true ) {
            System.out.printf("[ Операционная дата ] >>> ");
            str = scanner.nextLine();
            strDate = str.trim();

            if ( strDate.equalsIgnoreCase( endCommand ) ) System.exit( 1 );

            if ( strDate.length() == 0 ) {
                date = currentDate;
                break;
            }

            try {
                date = LocalDate.parse( strDate , formatter );
                correctDate = true;
            } catch ( DateTimeParseException e ) {
                System.out.println( "Неправильная дата, попробуйте ещё раз" );
            }

            if( correctDate ) {
                break;
            }

        }

        System.out.println( "Операционная дата : " + date.format( formatter ) );
        System.out.println( "" );

        return date;
    }
}
