package Homeworks.Homework06;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class ListDiscountProduct {
    private ArrayList<DiscountProduct> list;
    private static LocalDate marketDate = LocalDate.now();;

    // Конструктор по умолчанию
    public ListDiscountProduct() {
        this.list = new ArrayList<>();
    }

    public ListDiscountProduct( LocalDate date ) {
        this.list = new ArrayList<>();
        this.marketDate = date;
    }

    public ListDiscountProduct( ArrayList<DiscountProduct> list ) {
        this.list = list;
    }

    public ListDiscountProduct( ArrayList<DiscountProduct> list , LocalDate date ) {
        this.list = list;
        this.marketDate = date;
    }

    public void read() {
        String endCommand = "END";
        int productCount = 0 , priceProduct;
        int productNameLenMin = 3;
        Scanner scanner = new Scanner( System.in );
        String[] strProducts , x;
        String nameProduct , textProducts;
        boolean state;
        int discountPercentage;    // процент скидки, целое, 0 - нет скидки
        int validityDays;          // срок действия в днях
        LocalDate startDate , endDate;

        // Ввод строки со списком продуктов через ;
        System.out.println( "Введите список продуктов (название, цена [, скидка, скидка действует дней]) одной строкой." );
        System.out.println( "Разделяя название, цену, скиду и дней : . А продукты разделяя ; ." );
        System.out.println( "Если указывается скидка, то надо указать и количество дней её действия. Дата начала скидки отсчитывается от текущего дня." );
        System.out.println( "Например : Хлеб = 40 ; Молоко = 60 : 10 : 7 ; Торт = 1000 ; Кофе растворимый = 879 ; Масло = 150" );
        System.out.println( endCommand + " - срочное завершение приложения" );

        while ( true ) {
            System.out.printf( "[ Продукты ] >>> " );
            textProducts = scanner.nextLine();

            if ( textProducts.equalsIgnoreCase( endCommand ) ) System.exit( 1 );

            strProducts = textProducts.split( ";" );
            state = true;

            if ( strProducts.length > 0 ) {

                for ( String product : strProducts ) {
                    x = product.split( ":" );

                    if ( ( x.length == 2 ) || ( x.length == 4 ) ) {
                        nameProduct = x[ 0 ].trim();
                        priceProduct = Integer.parseInt( x[ 1 ].trim() );

                        if ( nameProduct.matches("[0-9]+"))
                        {
                            System.out.println( "Имя должно содержать не только цифры" );
                            state = false;
                        };

                        if( nameProduct.length() < productNameLenMin ) {
                            System.out.println( "Имя не может быть короче " + productNameLenMin + " символов" );
                            state = false;
                        }

                        if( priceProduct < 1 ) {
                            System.out.println( "Цена должна быть больше нуля" );
                            state = false;
                        }

                        for( DiscountProduct elemProduct : this.list ) {
                            if( elemProduct.getName().equalsIgnoreCase( nameProduct ) ) {
                                System.out.println( "Имя должно быть уникально, в списке \"" + nameProduct + "\" уже есть" );
                                state = false;
                            }
                        }

                        if ( x.length == 2 ) {
                            if( state ) {
                                this.list.add( new DiscountProduct( nameProduct , priceProduct ) );
                                System.out.println( "### " + nameProduct + " , " + priceProduct );
                                productCount++;
                            }
                        } else {
                            discountPercentage = Integer.parseInt( x[ 2 ].trim() );
                            validityDays       = Integer.parseInt( x[ 3 ].trim() );

                            if( discountPercentage < 1 ) {
                                System.out.println( "Скидка должна быть больше нуля" );
                                state = false;
                            }

                            if( discountPercentage > 99 ) {
                                System.out.println( "Скидка должна быть меньше 100%" );
                                state = false;
                            }

                            if( discountPercentage < 1 ) {
                                System.out.println( "Кол-во дней действия скидки должна быть больше нуля" );
                                state = false;
                            }

                            if( state ) {
                                startDate = marketDate;
                                endDate = startDate.plusDays( validityDays - 1 );;
                                this.list.add( new DiscountProduct( nameProduct , priceProduct , discountPercentage , startDate , endDate ) );
                                productCount++;
                            }

                        }
                    } else {
                        System.out.println( "\"" + product + "\" : не удалось расшифровать" );
                    }
                }
            }

            if ( productCount > 0 ) break;

            System.out.println( "Неверный ввод, ещё раз");
        }

        System.out.println( "" );
    }

    public void print() {
        int discountPercentage , price , discount;
        double Percentage;
        LocalDate startDate , endDate;
        String textStr , pattern = "dd.MM.yyyy" , strStartDate , strEndDate;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern( pattern );

        for( DiscountProduct elemProduct : this.list ) {
            price = elemProduct.getPrice();
            textStr = elemProduct.getName() + " : " + String.valueOf( price );
            discountPercentage = elemProduct.getDiscountPercentage();

            if( discountPercentage > 0 ) {
                startDate = elemProduct.getDiscountStartDate();
                endDate   = elemProduct.getDiscountEndDate();

                strStartDate = startDate.format( formatter );
                strEndDate = endDate.format( formatter );
                Percentage = ( double ) price / 100;
                discount = ( int ) ( Percentage * discountPercentage );

                textStr += " , скидка " + String.valueOf( discountPercentage ) + "% с " + strStartDate + " по " + strEndDate;

                if( marketDate.isBefore( startDate ) || marketDate.isAfter( endDate ) ) {
                    textStr += " , уже не действует";
                } else {
                    textStr += " , цена со скидкой " + String.valueOf( price - discount );
                }
            }

            System.out.println( textStr );
        }

        System.out.println( "" );
    }

    public DiscountProduct find( String name) {
        for( DiscountProduct elemProduct : this.list ) {
            if( elemProduct.getName().equalsIgnoreCase( name ) ) {
                return elemProduct;
            }
        }

        return null;
    }

    // Кол-во элементов
    public int size() {
        return this.list.size();
    }

    public LocalDate getMarketDate() {
        return marketDate;
    }

    public void setMarketDate( LocalDate date ) {
        this.marketDate = date;
    }

    @Override
    public String toString() {
        return "{" + list + '}';
    }

    @Override
    public boolean equals( Object o ) {
        if ( o == null || getClass() != o.getClass() ) return false;
        ListDiscountProduct that = ( ListDiscountProduct ) o;
        return Objects.equals( list , that.list );
    }

    @Override
    public int hashCode() {
        return Objects.hashCode( list );
    }
}


