package Homeworks.Homework06;

import java.util.Objects;

public class Product {

    private String name;
    private int price;

    // Конструктор по умолчанию
    public Product() {
        this.name = "Noname";
        this.price = 0;
    }

    // Конструктор только с именем
    public Product( String name , int price ) {
        this.name = name;
        this.price = price;
    }

    /* Геттеры и сеттеры для свойств */

    public String getName() {
        return name;
    }

    public void setName( String name ) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice( int price ) {
        this.price = price;
    }

    @Override
    public boolean equals( Object o ) {
        if ( o == null || getClass() != o.getClass() ) return false;
        Product product = (Product) o;
        return price == product.price && Objects.equals( name , product.name );
    }

    @Override
    public int hashCode() {
        return Objects.hash( name , price );
    }

    @Override
    public String toString() {
        return name;
    }
}

