package Homeworks.Homework06;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;

class Buyer {
    private String name;
    private int wallet;
    private ArrayList<DiscountProduct> listProducts;

    // Конструктор по умолчанию
    public Buyer() {
        this.name = "Noname";
        this.wallet = 0;
        this.listProducts = new ArrayList<>();
    }

    // Конструктор только с именем
    public Buyer( String name , int wallet ) {
        this.name = name;
        this.wallet = wallet;
        this.listProducts = new ArrayList<>();
    }

    public boolean purchase( DiscountProduct newProduct , LocalDate marketDate ) {
        int price = newProduct.getPrice();
        int discountPercentage = newProduct.getDiscountPercentage();
        int discount;
        double Percentage;
        LocalDate startDate , endDate;

        if( discountPercentage > 0 ) {
            startDate = newProduct.getDiscountStartDate();
            endDate   = newProduct.getDiscountEndDate();

            if( !marketDate.isBefore( startDate ) && !marketDate.isAfter( endDate ) ) {
                Percentage = ( double ) price / 100;
                discount = ( int ) ( Percentage * discountPercentage );
                price -= discount;
            }
        }

        if( this.wallet >= price ) {
            this.listProducts.add( newProduct );
            this.wallet -= price;
            return true;
        } else {
            return false;
        }
    }

    /* Геттеры и сеттеры для свойств */

    public String getName() {
        return name;
    }

    public void setName( String name ) {
        this.name = name;
    }

    public int getWallet() {
        return wallet;
    }

    public void setWallet( int wallet ) {
        this.wallet = wallet;
    }

    @Override
    public int hashCode() {
        return Objects.hash( name , wallet , listProducts );
    }

    @Override
    public String toString() {
        ArrayList<String> ProductNames = new ArrayList<>();
        String str = name + " - ";

        if( listProducts.size() == 0 ) {
            str += "Ничего не куплено";
        } else {
            for( DiscountProduct elemProduct : listProducts ) {
                ProductNames.add( elemProduct.toString() );
            }

            str += String.join( " , " , ProductNames );
        }

        return str;
    }
}

{
}
