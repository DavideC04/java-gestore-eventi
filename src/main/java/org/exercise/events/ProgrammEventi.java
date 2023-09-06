package org.exercise.events;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/*
Creare una classe ProgrammEventi con i seguenti attributi
● titolo: String
● eventi: List<Evento>
Nel costruttore valorizzare il titolo, passato come parametro, e inizializzare la lista di eventi come una nuova ArrayList Aggiungere i seguenti metodi :
● un metodo che aggiunge alla lista un Evento, passato come parametro
● un metodo che restituisce una lista con tutti gli eventi presenti in una certa data
● un metodo che restituisce quanti eventi sono presenti nel programma
● un metodo che svuota la lista di eventi
● un metodo che restituisce una stringa che mostra il titolo del programma e tutti gli eventi
 */
public class ProgrammEventi {
    // ATTRIBUTI
    private String title;
    private List<Evento> eventi;

    // COSTRUTTORI
    public ProgrammEventi(String title, List<Evento> eventi) {
        this.title = title;
        this.eventi = new ArrayList<>();
    }


    // GETTER E SETTER


    // METODI
    // metodo per aggiungere alla lista un Evento, passato come parametro
    public void addEvento(Evento evento){
        eventi.add(evento);
    }

    // metodo per restituire una lista con gli eventi in una certa data
    public List<Evento> getEventi(Date date) {
        // uso il metodo stream (sequenza di elementi) e filtro attraverso la data.
        // infine, raggruppo gli elementi filtrati in una nuova lista usanto collect
        return eventi.stream().filter(evento -> evento.getDate().equals(date)).collect(Collectors.toList());
    }

    // metodo per restituire il numero di eventi nel programma
    public void numberEvents(){
        eventi.size();
    }


    // metodo che svuota la lista di eventi
    public void clearEvent(){
        eventi.clear();
    }

    // metodo per restituire una stringa che mostra il titolo e gli eventi
    public String toString(){
        // uso uno StringBuilder per concatenare più stringhe
        StringBuilder stringBuilder = new StringBuilder();
        // aggiungo il titolo
        stringBuilder.append("Title: ").append(title);
        // aggiungo gli eventi
        stringBuilder.append("Events: ");
        // itero un for-each
        for (Evento evento : eventi) {
            // per ogni evento, viene chiamato il toString ed aggiunto allo stringBuilder
            stringBuilder.append(evento.toString());
        }
        // ritorno il toString contenente tutti gli elementi(titolo ed eventi)
        return stringBuilder.toString();
    }


}
