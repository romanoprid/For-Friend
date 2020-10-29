package ua.lviv.iot.spring.database.rest.model;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class Good {
    private String name;
    private double price_in_uah;


    public Good() {

    }

    public Good(final String title, final double price) {
        this.name = title;
        this.price_in_uah = price;
    }

    public final String getName() {
        return name;
    }

    public final void setName(final String title) {
        this.name = title;
    }

    public final double getPrice_in_uah() {
        return price_in_uah;
    }

    public final void setPrice_in_uah(final double price) {
        this.price_in_uah = price;
    }




    @Override
    public String toString() {
        return
                "Name=" + name + ' '
                        + "PriceInUAH=" + price_in_uah;
    }
}
