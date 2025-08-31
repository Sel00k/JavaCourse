package Attestation.Attestation01;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class ListPerson {
    ArrayList<Person> list;
    private static LocalDate marketDate = LocalDate.now();;

    // Конструктор по умолчанию
    public ListPerson() {
        this.list = new ArrayList<>();
    }

    // Конструктор по умолчанию
    public ListPerson( LocalDate date ) {
        this.list = new ArrayList<>();
        this.marketDate = date;
    }

    public void read() {
        String endCommand = "END";
        int personNameLenMin = 3;
        int personCount = 0 , sumPerson;
        boolean state;
        Scanner scanner = new Scanner( System.in );
        String[] strPersons , x;
        String namePerson , textPersons;

        // Ввод строки со списком покупателей через ;
        System.out.println( "Введите список покупателей (имя и сумма) одной строкой, разделяя имя и сумму = , a покупателей ;" );
        System.out.println( "Например : Павел Андреевич = 10000 ; Анна Петровна = 2000 ; Борис = 10" );
        System.out.println( endCommand + " - срочное завершение приложения" );
        while ( true ) {
            System.out.printf( "[ Покупатели ] >>> " );
            textPersons = scanner.nextLine();

            if ( textPersons.equalsIgnoreCase( endCommand ) ) System.exit( 1 );

            strPersons = textPersons.split( ";" );
            state = true;

            if ( strPersons.length > 0 ) {
                for ( String strPerson : strPersons ) {
                    x = strPerson.split( "=" );

                    if ( x.length == 2 ) {
                        namePerson = x[ 0 ].trim();
                        sumPerson = Integer.parseInt( x[ 1 ].trim() );

                        if( namePerson.length() < personNameLenMin ) {
                            System.out.println( "Имя не может быть короче " + personNameLenMin + " символов" );
                            state = false;
                        }

                        if( sumPerson < 0 ) {
                            System.out.println( "Сумма не может быть отрицательной" );
                            state = false;
                        }

                        for( Person elemPerson : this.list ) {
                            if( elemPerson.getName().equalsIgnoreCase( namePerson ) ) {
                                System.out.println( "Имя должно быть уникально, в списке \"" + namePerson + "\" уже есть" );
                                state = false;
                                break;
                            }
                        }

                        if( state ) {
                            this.list.add( new Person( namePerson , sumPerson ) );
                            personCount++;
                        }
                    } else {
                        System.out.println( "\"" + strPerson + "\" : не удалось расшифровать" );
                    }
                }
            }

            if ( personCount > 0 ) break;

            System.out.println( "Неверный ввод, ещё раз");
        }

        System.out.println( "" );
    }

    public void print() {
        for( Person elemPerson : this.list ) {
            System.out.println( elemPerson.getName() + " = " + elemPerson.getWallet() );
        }
        System.out.println( "" );
    }

    public Person find( String name ) {
        for( Person elemPerson : this.list ) {
            if( elemPerson.getName().equalsIgnoreCase( name ) ) {
                return elemPerson;
            }
        }

        return null;
    }

    public void check() {
        for( Person elemPerson : this.list ) {
            System.out.println( elemPerson.toString() );
        }
        System.out.println( "" );
    }

    public boolean purchase( String namePerson , Product newProduct ) {
        for( Person elemPerson : this.list ) {
            if( elemPerson.getName().equalsIgnoreCase( namePerson ) ) {
                if( elemPerson.purchase( newProduct , marketDate ) ) {
                    System.out.println( "\"" + namePerson + "\" купил(a) \"" + newProduct.getName() + "\"" );
                    return true;
                } else {
                    System.out.println( "\"" + namePerson + "\" не может позволить себе \"" + newProduct.getName() + "\"" );
                    return false;
                }
            }
        }

        System.out.println( "Покупателя с именем \"" + namePerson + "\" не найдено" );
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
        if ( o == null || getClass() != o.getClass() ) return false;
        ListPerson that = ( ListPerson ) o;
        return Objects.equals( list , that.list );
    }

    @Override
    public int hashCode() {
        return Objects.hashCode( list );
    }
}
