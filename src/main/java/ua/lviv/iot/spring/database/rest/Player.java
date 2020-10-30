package ua.lviv.iot.spring.database.rest;

import ua.lviv.iot.spring.database.rest.model.Good;

import javax.persistence.*;

@Entity

public class Player extends Good {
    private double amount;



    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id

    private Integer id;

    public Player(Player player) {
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Player() {
    }

    public Player(final String name, final double price_in_uah, final double amo) {
        super(name, price_in_uah);
        this.amount = amo;

    }

    public final double getAmount() {
        return amount;
    }

    public final void setAmount(final double amo) {
        this.amount = amo;
    }





    @Override
    public final String toString() {
        return super.toString() + " "
                + "Amount=" + amount + " ";
    }

}
