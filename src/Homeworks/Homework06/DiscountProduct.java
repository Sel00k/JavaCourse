package Homeworks.Homework06;

import java.time.LocalDate;
import java.util.Date;

public class DiscountProduct extends Product {
    /* Продукт поддерживающий скидки */

    private int discountPercentage;    // процент скидки, целое, 0 - нет скидки
    private LocalDate discountStartDate;      // дата начала скидки ДД.ММ.ГГГГ
    private LocalDate discountEndDate;        // дата конца скидки ДД.ММ.ГГГГ включительно
//    private int validityDays;    // срок действия в днях

    // Конструктор по умолчанию
    public DiscountProduct() {
        super();
        this.discountPercentage = 0;
    }

    public DiscountProduct( String name , int price ) {
        super( name , price );
        this.discountPercentage = 0;
    }

    public DiscountProduct( String name , int price , int discountPercentage , LocalDate discountStartDate , LocalDate discountEndDate ) {
        super( name , price );
        this.discountPercentage = discountPercentage;
        this.discountStartDate = discountStartDate;
        this.discountEndDate = discountEndDate;
    }

    /* Геттеры и сеттеры для свойств */

    public String getName() {
        return super.getName();
    }

    public void setName( String name ) {
        super.setName( name );
    }

    public int getPrice() {
        return super.getPrice();
    }

    public void setPrice( int price ) {
        super.setPrice( price );
    }

    public int getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage( int discountPercentage ) {
        this.discountPercentage = discountPercentage;
    }

    public LocalDate getDiscountStartDate() {
        return discountStartDate;
    }

    public void setDiscountStartDate( LocalDate discountStartDate ) {
        this.discountStartDate = discountStartDate;
    }

    public LocalDate getDiscountEndDate() {
        return discountEndDate;
    }

    public void setDiscountEndDate( LocalDate discountEndDate ) {
        this.discountEndDate = discountEndDate;
    }
}
