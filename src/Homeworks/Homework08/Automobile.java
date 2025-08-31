package Homeworks.Homework08;

import java.util.Objects;

public class Automobile {
    private String number;
    private String model;
    private String color;
    private long mileage;
    private long price;

    public Automobile( String number ) {
        this.number = number;
    }

    public Automobile( String number , String model , String color , long mileage , long price ) {
        this.number = number;
        this.model = model;
        this.color = color;
        this.mileage = mileage;
        this.price = price;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber( String number ) {
        this.number = number;
    }

    public String getModel() {
        return model;
    }

    public void setModel( String model ) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor( String color ) {
        this.color = color;
    }

    public long getMileage() {
        return mileage;
    }

    public void setMileage( long mileage ) {
        this.mileage = mileage;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice( long price ) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Automobile that = (Automobile) o;
        return mileage == that.mileage && price == that.price && Objects.equals(number, that.number) && Objects.equals(model, that.model) && Objects.equals(color, that.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, model, color, mileage, price);
    }

    @Override
    public String toString() {
        return String.format( "| %-6s | %-8s | %-6s | %6d | %7d |" , number , model , color , mileage , price );
    }
}
