package org.exercise.events;

import java.time.LocalDate;
import java.util.Locale;
import java.util.Scanner;

/*
1. Creare una classe Main di test, in cui si chiede all’utente di inserire un nuovo evento con tutti i parametri.
2. Dopo che l’evento è stato istanziato, chiedere all’utente se e quante prenotazioni vuole fare e provare ad effettuarle, implementando opportuni controlli e gestendo eventuali eccezioni.
3. Stampare a video il numero di posti prenotati e quelli disponibili
4. Chiedere all’utente se e quanti posti vuole disdire
5. Provare ad effettuare le disdette, implementando opportuni controlli e gestendo eventuali eccezioni
6. Stampare a video il numero di posti prenotati e quelli disponibili
 */
public class Main {
    public static void main(String[] args) {
        // inizializzo lo scanner
        Scanner input = new Scanner(System.in);
        // chiedo all'utente le informazioni dell'evento
        // metto le informazioni in un try
        try {
            System.out.println("Inserisci il titolo dell'evento: ");
            String title = input.nextLine();
            System.out.println("Inserisci la data dell'evento: ");
            LocalDate date = LocalDate.parse(input.nextLine());
            System.out.println("Inserisci il numero di posti totati dell'evento: ");
            int totalSeats = Integer.parseInt(input.nextLine());
            // creo il nuovo evento
            Evento evento = new Evento(title, date, totalSeats);
        } catch (IllegalArgumentException e){
            // se i dati dell'utente non sono validi, stampo un messaggio
            System.out.println("Input non validi: " + e.getMessage());
        }















        // chiudo lo scanner
        input.close();
    }
}
