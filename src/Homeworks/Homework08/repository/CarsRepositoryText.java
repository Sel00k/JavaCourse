package Homeworks.Homework08.repository;

import Homeworks.Homework08.Automobile;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class CarsRepositoryText implements CarsRepository{

    private List<Automobile> cars;
    private String colorToFind;
    private long   mileageToFind;
    private List<String> modelsToFind = new ArrayList<>();
    private String fileNameCars;
    private String fileNameResult;
    private long priceStart;
    private long priceEnd;

    public CarsRepositoryText( String fileNameCars , String fileNameResult ) {
        this.cars = new ArrayList<>();
        this.fileNameCars   = fileNameCars;
        this.fileNameResult = fileNameResult;
        readCars();
    }

    public boolean addCar( Automobile car ) {
        String number = car.getNumber();
        long c = this.cars.stream().filter( a -> a.getNumber().equalsIgnoreCase( number ) ).count();

        if ( c == 0 ) {
            this.cars.add( car );
            return true;
        }

        return false;
    }

    public boolean colorToFind( String colorToFind ) {
        this.colorToFind = colorToFind;
        return true;
    }

    public boolean priceToFind( long priceStart , long priceEnd ) {
        this.priceStart = priceStart;
        this.priceEnd   = priceEnd;
        return true;
    }

    public boolean addModelToFind( String modelToFind ) {
        if ( !this.modelsToFind.contains( modelToFind ) ) {
            this.modelsToFind.add( modelToFind );
            return true;
        }

        return false;
    }

    public boolean mileageToFind( long mileageToFind ) {
        this.mileageToFind = mileageToFind;
        return true;
    }

    public void readCars() {
        File fileCars   = new File( this.fileNameCars );
        File fileResult = new File( this.fileNameResult );
        String[] x , z;
        String var , value;
        Automobile car;
        List<String> ss = new ArrayList<>();

        if ( fileCars.exists() ) {
            try ( BufferedReader reader = new BufferedReader( new FileReader( fileCars ) ) ) {
                String line;

                while ( ( line = reader.readLine() ) != null ) {

                    x = line.trim().split( ":" );

                    if ( x.length == 2 ) {
                         var = x[ 0 ].trim().toLowerCase();
                         value = x[ 1 ].trim();

                         if ( var.equals( "car" ) ) {
                             z = value.split( "[|]" );
                             car = new Automobile( z[ 0 ] , z[ 1 ] , z[ 2 ] , Long.valueOf( z[ 3 ] ) , Long.valueOf( z[ 4 ] ) );

                             if ( !addCar( car ) ) {
                                 ss.add( "Автомобиль с номером \"" + z[ 0 ] + "\" уже есть" );
                             }
                         }

                         if ( var.equals( "colortofind" ) ) {
                             colorToFind( value );
                         }

                         if ( var.equals( "mileagetofind" ) ) {
                             mileageToFind( Long.valueOf( value ) );
                         }

                         if ( var.equals( "pricetofind" ) ) {
                             z = value.split( "-" );
                             priceToFind( Long.valueOf( z[ 0 ] ) , Long.valueOf( z[ 1 ] ) );
                         }

                         if ( var.equals( "modeltofind" ) ) {
                             addModelToFind( value );
                         }
                    }
                }
            } catch ( IOException e ) {
                e.printStackTrace(); // Обработка возможных ошибок ввода-вывода
            }
        }

        if ( fileResult.exists() ) {
            try ( BufferedWriter writer = new BufferedWriter( new FileWriter( fileResult , true ) ) ) {
                for ( String s : ss ) {
                    writer.write( s ); writer.newLine();
                }

                writer.newLine();
            } catch ( IOException e ) {
                e.printStackTrace();
                System.err.println( "Ошибка при записи в файл." );
            }
        }
    }

    public void writeCars() {
        File fileResult = new File( this.fileNameResult );
        String t1 = "+--------+----------+--------+--------+---------+";
        String t2 = "| Номер  |  Модель  |  Цвет  | Пробег |  Цена   |";
        String t3;

        try ( BufferedWriter writer = new BufferedWriter( new FileWriter( fileResult , true ) ) ) {
            writer.write( "Автомобили в базе :" ); writer.newLine();
            writer.write( t1 ); writer.newLine();
            writer.write( t2 ); writer.newLine();
            writer.write( t1 ); writer.newLine();

            for ( Automobile car : cars ) {
                t3 = car.toString();
                writer.write( t3 ); writer.newLine();
            }

            writer.write( t1 ); writer.newLine();
            writer.newLine();
        } catch ( IOException e ) {
            e.printStackTrace();
            System.err.println( "Ошибка при записи в файл." );
        }
    }

    public void writeNumbersFromColorAndMileag() {
        File fileResult = new File( this.fileNameResult );
        List<String> r1 = getNumbersFromColorAndMileage( colorToFind , mileageToFind );
        String s = String.format( "Номера всех автомобилей, имеющих цвет \"%s\" или c %d пробегом : %s" , colorToFind , mileageToFind , r1 );

        try ( BufferedWriter writer = new BufferedWriter( new FileWriter( fileResult , true ) ) ) {
            writer.write( s ); writer.newLine();
        } catch ( IOException e ) {
            e.printStackTrace();
            System.err.println( "Ошибка при записи в файл." );
        }
    }

    public void writeUniqueCars() {
        File fileResult = new File( this.fileNameResult );
        long r2 = countUniqueCars( priceStart , priceEnd );
        String s = String.format( "Количество уникальных автомобилей в ценовом диапазоне от %d до %d : %d" , priceStart , priceEnd , r2 );

        try ( BufferedWriter writer = new BufferedWriter( new FileWriter( fileResult , true ) ) ) {
            writer.write( s ); writer.newLine();
        } catch ( IOException e ) {
            e.printStackTrace();
            System.err.println( "Ошибка при записи в файл." );
        }
    }

    public void writeUniqueModels() {
        File fileResult = new File( this.fileNameResult );
        long r2 = countUniqueModels( priceStart , priceEnd );
        String s = String.format( "Количество уникальных моделей в ценовом диапазоне от %d до %d : %d" , priceStart , priceEnd , r2 );

        try ( BufferedWriter writer = new BufferedWriter( new FileWriter( fileResult , true ) ) ) {
            writer.write( s ); writer.newLine();
        } catch ( IOException e ) {
            e.printStackTrace();
            System.err.println( "Ошибка при записи в файл." );
        }
    }

    public void writeColorMinPrice() {
        File fileResult = new File( this.fileNameResult );
        String r3 = getColorMinPrice();
        String s = String.format( "Цвет автомобиля с минимальной стоимостью : %s" , r3 );

        try ( BufferedWriter writer = new BufferedWriter( new FileWriter( fileResult , true ) ) ) {
            writer.write( s ); writer.newLine();
        } catch ( IOException e ) {
            e.printStackTrace();
            System.err.println( "Ошибка при записи в файл." );
        }
    }

    public void writeAvePriceModel() {
        File fileResult = new File( this.fileNameResult );
        double r4;
        String s;

        try ( BufferedWriter writer = new BufferedWriter( new FileWriter( fileResult , true ) ) ) {
            for ( String modelToFind : modelsToFind ) {
                r4 = getAvePriceModel( modelToFind );
                s = String.format( "Среднюю стоимость модели \"%s\" : %f" , modelToFind , r4 );
                writer.write( s ); writer.newLine();
            }
        } catch ( IOException e ) {
            e.printStackTrace();
            System.err.println( "Ошибка при записи в файл." );
        }
    }

    // Номера всех автомобилей, имеющих заданный в переменной цвет colorToFind или нулевой пробег mileageToFind
    public List<String> getNumbersFromColorAndMileage( String colorFind , long mileageFind ) {
        List<String> r1 = cars.stream()
                .filter(  car -> car.getMileage() == mileageFind || car.getColor().equalsIgnoreCase( colorFind ) )
                .map( Automobile::getNumber )
                .collect( Collectors.toList() );
        return r1;
    }

    // Количество уникальных автомобилей в ценовом диапазоне от n до m
    public long countUniqueCars( long pStart , long pEnd ) {
        long r2a = cars.stream()
                .filter(  car -> car.getPrice() >= pStart )
                .filter(  car -> car.getPrice() <= pEnd )
                .map( Automobile::getNumber )
                .distinct()
                .count();
        return r2a;
    }

    // Количество уникальных моделей в ценовом диапазоне от n до m
    public long countUniqueModels( long pStart , long pEnd ) {
        long r2b = cars.stream()
                .filter(  car -> car.getPrice() >= pStart )
                .filter(  car -> car.getPrice() <= pEnd )
                .map( Automobile::getModel )
                .distinct()
                .count();
        return r2b;
    }

    // цвет автомобиля с минимальной стоимостью
    public String getColorMinPrice() {
        String r3 = "Null";
        Optional<Automobile> r3optional = cars.stream()
                .min( Comparator.comparingLong( Automobile::getPrice ) );
        if( r3optional.isPresent() ) {
            r3 = r3optional.get().getColor();
        }
        return r3;
    }

    // Среднюю стоимость искомой модели modelToFind
    public double getAvePriceModel( String modelFind ) {
        double r4 = cars.stream()
                .filter(  car -> car.getModel().equalsIgnoreCase( modelFind ) )
                .mapToLong( Automobile::getPrice )
                .average()
                .orElse( 0.0 );
        return r4;
    }
}
