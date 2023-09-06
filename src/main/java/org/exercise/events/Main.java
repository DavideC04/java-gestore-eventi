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
            System.out.println("Inserisci la data dell'evento (YYYY-MM-DD): ");
            LocalDate date = LocalDate.parse(input.nextLine());
            System.out.println("Inserisci il numero di posti totati dell'evento: ");
            int totalSeats = Integer.parseInt(input.nextLine());
            // creo il nuovo evento
            Evento evento = new Evento(title, date, totalSeats);
            // inizializzo una variabile per uscire dal ciclo
            boolean exit = false;
            // itero un ciclo while
            while(!exit) {
                // chiedo all'utente quali operazione vuole svolgere
                System.out.println("Quale operazione vuoi svolgere? 1- Prenotare  2- Cancellare una prenotazione  3- Uscire");
                String choice =input.nextLine();
                // uso uno switch
                switch (choice){
                    case "1":
                        // chiedo quante prenotazioni vuole fare l'utente
                        System.out.println("Quante prenotazioni vuoi effettuare? ");
                        int reservation = Integer.parseInt(input.nextLine());
                        try{
                            // chiedo quanti posti vuole prenotare
                            System.out.println("Quanti posti vuoi prenotare? ");
                            int seatsToBook = Integer.parseInt(input.nextLine());
                            // aggiungo la prenotazione
                            evento.prenotaPosto(seatsToBook);
                            System.out.println("Prenotazione effettuata con successo!");
                        }catch (IllegalArgumentException e){
                            // se risulta un dato non valido, stampo un messaggio
                            System.out.println("Errore nella prenotazione: " + e.getMessage());
                        }

                        // mostro a video i posti prenotati
                        System.out.println("Posti prenotati: " + evento.getBookedSeats());
                        // mostro a video i posti disponibili
                        System.out.println("Posti disponibili: " + (evento.getTotalSeats() - evento.getBookedSeats()));
                        break;
                    case "2":
                        // chiedo all'utente quante prenotazioni vuole disdire
                        System.out.println("Quante prenotazioni vuoi disdire? ");
                        int cancel = Integer.parseInt(input.nextLine());
                        try {
                            // chiedo all'utente quanti posti disdire dalla prenotazione
                            System.out.println("Inserisici il numero di posti da disdire: ");
                            int seatsToCancel = Integer.parseInt(input.nextLine());
                            // riduco il numero di posti nella prenotazione
                            evento.disdiciPrenotazione(seatsToCancel);
                            System.out.println("Cancellazione della prenotazione effettuata con successo!");
                        } catch (IllegalArgumentException e){
                            // se il numero di posti da cancellare è maggiore di quelli prenotati, stampo un messaggio
                            System.out.println("Errore nella cancellazione: " + e.getMessage());
                        }
                        // mostro a video i posti prenotati dopo la cancellazione
                        System.out.println("Posti prenotati: " + evento.getBookedSeats());
                        // mostro a video i posti disponibili dopo la cancellazione
                        System.out.println("Posti disponibili: " + (evento.getTotalSeats() - evento.getBookedSeats()));
                        break;
                    case"3":
                        System.out.println("Le auguro una buona giornata!");
                        exit = true;

                }
            }
        } catch (IllegalArgumentException e){
            // se i dati dell'utente non sono validi, stampo un messaggio
            System.out.println("Input non validi: " + e.getMessage());
        }


















        // chiudo lo scanner
        input.close();
    }
}
