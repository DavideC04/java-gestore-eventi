package org.exercise.events;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/*
La consegna è di creare una classe Evento che abbia le seguenti proprietà:
● titolo
● data
● numero di posti in totale
● numero di posti prenotati
Quando si istanzia un nuovo evento questi attributi devono essere tutti valorizzati nel costruttore , tranne posti prenotati che va inizializzato a 0.
Inserire il controllo che la data non sia già passata e che il numero di posti totali sia positivo. In caso contrario sollevare opportune eccezioni.
Aggiungere metodi getter e setter in modo che:
● titolo sia in lettura e in scrittura
● data sia in lettura e scrittura
● numero di posti totale sia solo in lettura
● numero di posti prenotati sia solo in lettura
Vanno inoltre implementati dei metodi public che svolgono le seguenti funzioni:
1. prenota : aggiunge un certo numero di posti prenotati. Se l’evento è già passato o non ha posti disponibili deve sollevare un’eccezione.
2. disdici : riduce di un certo numero i posti prenotati. Se l’evento è già passato o non ci sono prenotazioni deve sollevare un’eccezione.
3. l’override del metodo toString() in modo che venga restituita una stringa contenente: data formattata - titolo
Aggiungete eventuali metodi (public e private) che vi aiutino a svolgere le funzioni richieste.
 */
public class Evento {
    // ATTRIBUTI
    private String title;
    private LocalDate date;
    private int totalSeats;
    private int bookedSeats;


    // COSTRUTTORI

    public Evento(String title, LocalDate date, int totalSeats) throws IllegalArgumentException{
        // se la data è passata, sollevo un'eccezione
        if (date.isBefore(LocalDate.now()) ){
            throw new IllegalArgumentException("Errore: la data non deve essere passata!");
        }
        // se il numero dei posti è negativo, sollevo un'eccezione
        if (totalSeats <= 0){
            throw new IllegalArgumentException("Errore: il numero dei posti deve essere positivo!");
        }

        this.title = title;
        this.date = date;
        this.totalSeats = totalSeats;
        this.bookedSeats = 0;
    }


    // GETTER E SETTER

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) throws IllegalArgumentException {
        // se la data è già passata, sollevo un'eccezione
        if (date.isBefore(LocalDate.now())){
            throw new IllegalArgumentException("Errore: la data è già passata!");
        }
        this.date = date;
    }

    public int getTotalSeats() {
        return totalSeats;
    }

    public int getBookedSeats() {
        return bookedSeats;
    }


    // METODI
    // metodo per prenotare un posto, con eventuali eccezioni
    public void prenotaPosto(int seatsToBook) throws IllegalArgumentException{
        // se la data è passata , sollevo un'eccezione
        if (date.isBefore(LocalDate.now())){
            throw new IllegalArgumentException("Impossibile prenotare per un evento già passato!");
        }
        // se non ci sono posti disponibili, sollevo un' eccezione
        if (bookedSeats + seatsToBook > totalSeats){
            throw  new IllegalArgumentException("Non ci sono posti disponibili.");
        }
        // aggiungo i posti prenotati
        bookedSeats += seatsToBook;
    }

    // metodo per disdire una prenotazione, con eventuali eccezioni
    public void disdiciPrenotazione(int seatsToCancel) throws IllegalArgumentException{
        // se la data è passata, sollevo un'eccezione
        if (date.isBefore(LocalDate.now())){
            throw new IllegalArgumentException("Impossibile disdire una prenotazione per un evento già passato!");
        }
        // se non ci sono prenotazioni da cancellare, sollevo un'eccezione
        if (bookedSeats - seatsToCancel < 0){
            throw new IllegalArgumentException("Non ci sono prenotazioni da cancellare.");
        }
        // riduco i posti prenotati
        bookedSeats -= seatsToCancel;
    }

    // override del metodo toString()
    @Override
    public String toString() {
        return  "date=" + date.format(DateTimeFormatter.ISO_LOCAL_DATE) + ", title='" + title ;
    }
}
