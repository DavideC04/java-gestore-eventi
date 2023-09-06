package org.exercise.events;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

/*
Creare una classe Concerto che estende Evento, che ha anche gli attributi :
● ora: LocalTime
● prezzo: BigDecimal
Aggiungere questi attributi nel costruttore e implementarne getter e setter
Aggiungere i metodi per restituire data e ora formattata e prezzo formattato (##,##€)
Fare l’ override del metodo toString() in modo che venga restituita una stringa del tipo:
data e ora formattata - titolo - prezzo formattato
 */
public class Concerto extends Evento{
    // ATTRIBUTI
    private LocalTime time;
    private BigDecimal price;

    // COSTRUTTORI


    public Concerto(String title, LocalDate date, int totalSeats, LocalTime time, BigDecimal price) throws IllegalArgumentException {
        super(title, date, totalSeats);
        this.time = time;
        this.price = price;
    }

    // GETTER E SETTER

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    // METODI
    // metodo per restituire data e ora formattata
    public String formatDateTime(){
        // uso DateTimeFormatter per formattare data e ora
        DateTimeFormatter date = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        DateTimeFormatter time = DateTimeFormatter.ofPattern("HH/mm");
        return getDate().format(date) + " - " + getTime().format(time);
    }

    // metodo per restituire il prezzo formattato
    public String formatPrice(){
        // uso NumberFormat per formattare il prezzo (in €)
        NumberFormat currencyprice = NumberFormat.getCurrencyInstance(Locale.ITALY);
        return currencyprice.format(price);
    }

    // override


    @Override
    public String toString() {
        return formatDateTime() + " - "  + getTitle() + " - " + formatPrice();
    }
}
