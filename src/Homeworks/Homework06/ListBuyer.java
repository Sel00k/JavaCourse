package Homeworks.Homework06;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class ListBuyer{
    ArrayList<Buyer> list;
    private static LocalDate marketDate = LocalDate.now();;

    // Конструктор по умолчанию
    public ListBuyer() {
        this.list = new ArrayList<>();
    }

    // Конструктор по умолчанию
    public ListBuyer( LocalDate date ) {
        this.list = new ArrayList<>();
        this.marketDate = date;
    }

    public void read() {
        String endCommand = "END";
        int buyerNameLenMin = 3;
        int buyerCount = 0 , sumBuyer;
        boolean state;
        Scanner scanner = new Scanner( System.in );
        String[] strBuyers , x;
        String nameBuyer , textBuyers;

        // Ввод строки со списком покупателей через ;
        System.out.println( "Введите список покупателей (имя и сумма) одной строкой, разделяя имя и сумму = , a покупателей ;" );
        System.out.println( "Например : Павел Андреевич = 10000 ; Анна Петровна = 2000 ; Борис = 10" );
        System.out.println( endCommand + " - срочное завершение приложения" );

        while ( true ) {
            System.out.printf( "[ Покупатели ] >>> " );
            textBuyers = scanner.nextLine();

            if ( textBuyers.equalsIgnoreCase( endCommand ) ) System.exit( 1 );

            strBuyers = textBuyers.split( ";" );
            state = true;

            if ( strBuyers.length > 0 ) {
                for ( String strPerson : strBuyers ) {
                    x = strPerson.split( "=" );

                    if ( x.length == 2 ) {
                        nameBuyer = x[ 0 ].trim();
                        sumBuyer = Integer.parseInt( x[ 1 ].trim() );

                        if( nameBuyer.length() < buyerNameLenMin ) {
                            System.out.println( "Имя не может быть короче " + buyerNameLenMin + " символов" );
                            state = false;
                        }

                        if( sumBuyer < 0 ) {
                            System.out.println( "Сумма не может быть отрицательной" );
                            state = false;
                        }

                        for( Buyer elemBuyer : this.list ) {
                            if( elemBuyer.getName().equalsIgnoreCase( nameBuyer ) ) {
                                System.out.println( "Имя должно быть уникально, в списке \"" + nameBuyer + "\" уже есть" );
                                state = false;
                                break;
                            }
                        }

                        if( state ) {
                            this.list.add( new Buyer( nameBuyer , sumBuyer ) );
                            buyerCount++;
                        }
                    } else {
                        System.out.println( "\"" + strPerson + "\" : не удалось расшифровать" );
                    }
                }
            }

            if ( buyerCount > 0 ) break;

            System.out.println( "Неверный ввод, ещё раз");
        }

        System.out.println( "" );
    }

    public void print() {
        for( Buyer elemBuyer : this.list ) {
            System.out.println( elemBuyer.getName() + " = " + elemBuyer.getWallet() );
        }
        System.out.println( "" );
    }

    public Buyer find( String name ) {
        for( Buyer elemBuyer : this.list ) {
            if( elemBuyer.getName().equalsIgnoreCase( name ) ) {
                return elemBuyer;
            }
        }

        return null;
    }

    public void check() {
        for( Buyer elemBuyer : this.list ) {
            System.out.println( elemBuyer.toString() );
        }
        System.out.println( "" );
    }

    public boolean purchase( String nameBuyer , Product newProduct ) {
        for( Buyer elemBuyer : this.list ) {
            if( elemBuyer.getName().equalsIgnoreCase( nameBuyer ) ) {
                if( elemBuyer.purchase( newProduct , marketDate ) ) {
                    System.out.println( "\"" + nameBuyer + "\" купил(a) \"" + newProduct.getName() + "\"" );
                    return true;
                } else {
                    System.out.println( "\"" + nameBuyer + "\" не может позволить себе \"" + newProduct.getName() + "\"" );
                    return false;
                }
            }
        }

        System.out.println( "Покупателя с именем \"" + nameBuyer + "\" не найдено" );
        return false;
    }

    public boolean purchase( String nameBuyer , DiscountProduct newProduct ) {
        for( Buyer elemBuyer : this.list ) {
            if( elemBuyer.getName().equalsIgnoreCase( nameBuyer ) ) {
                if( elemBuyer.purchase( newProduct , marketDate ) ) {
                    System.out.println( "\"" + nameBuyer + "\" купил(a) \"" + newProduct.getName() + "\"" );
                    return true;
                } else {
                    System.out.println( "\"" + nameBuyer + "\" не может позволить себе \"" + newProduct.getName() + "\"" );
                    return false;
                }
            }
        }

        System.out.println( "Покупателя с именем \"" + nameBuyer + "\" не найдено" );
        return false;
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
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ListBuyer listBuyer = (ListBuyer) o;
        return Objects.equals(list, listBuyer.list);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(list);
    }
}
