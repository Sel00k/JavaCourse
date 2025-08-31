package Attestation.Attestation01;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

class ListProduct {
    ArrayList<Product> list;

    // Конструктор по умолчанию
    public ListProduct() {
        this.list = new ArrayList<>();
    }

    public void read() {
        String endCommand = "END";
        int productCount = 0 , priceProduct;
        int productNameLenMin = 3;
        Scanner scanner = new Scanner( System.in );
        String[] strProducts , x;
        String nameProduct , textProducts;
        boolean state;

        // Ввод строки со списком продуктов через ;
        System.out.println( "Введите список продуктов (название и цена) одной строкой, разделяя название и цену = , a продукты ;" );
        System.out.println( "Например : Хлеб = 40 ; Молоко = 60 ; Торт = 1000 ; Кофе растворимый = 879 ; Масло = 150" );
        System.out.println( endCommand + " - срочное завершение приложения" );
        while ( true ) {
            System.out.printf( "[ Продукты ] >>> " );
            textProducts = scanner.nextLine();

            if ( textProducts.equalsIgnoreCase( endCommand ) ) System.exit( 1 );

            strProducts = textProducts.split( ";" );
            state = true;

            if ( strProducts.length > 0 ) {

                for ( String product : strProducts ) {
                    x = product.split( "=" );

                    if ( x.length == 2 ) {
                        nameProduct = x[ 0 ].trim();
                        priceProduct = Integer.parseInt( x[ 1 ].trim() );

                        if( nameProduct.length() < productNameLenMin ) {
                            System.out.println( "Имя не может быть короче " + productNameLenMin + " символов" );
                            state = false;
                        }

                        if( priceProduct < 0 ) {
                            System.out.println( "Цена не может быть отрицательной" );
                            state = false;
                        }

                        for( Product elemProduct : this.list ) {
                            if( elemProduct.getName().equalsIgnoreCase( nameProduct ) ) {
                                System.out.println( "Имя должно быть уникально, в списке \"" + nameProduct + "\" уже есть" );
                                state = false;
                                break;
                            }
                        }

                        if( state ) {
                            this.list.add( new Product( nameProduct , priceProduct ) );
                            productCount++;
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
        for( Product elemProduct : this.list ) {
            System.out.println( elemProduct.getName() + " = " + elemProduct.getPrice() );
        }
        System.out.println( "" );
    }

    public Product find( String name) {
        for( Product elemProduct : this.list ) {
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

    @Override
    public String toString() {
        return "{" + list + '}';
    }

    @Override
    public boolean equals( Object o ) {
        if ( o == null || getClass() != o.getClass() ) return false;
        ListProduct that = ( ListProduct ) o;
        return Objects.equals( list , that.list );
    }

    @Override
    public int hashCode() {
        return Objects.hashCode( list );
    }
}


