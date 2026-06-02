package ro.ulbs.proiectaresoftware.Test;

import java.util.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;


public class Server {

    private List<Observer> obervers = new ArrayList<>();

    public void addObserver(Observer obs){
        obervers.add(obs);
    }

    public void start(){
        Path input = Paths.get("src/main/java/ro/ulbs/proiectaresoftware/Test/input_a.txt");
        try{
            List<String> linii = Files.readAllLines(input);
            for(String linie : linii){
                String[] date = linie.split(",");
                if(date.length>=5){
                    int id = Integer.parseInt(date[0].trim());
                    String data = date[1].trim();
                    String grup = date[2].trim();
                    String eveniment = date[3].trim();
                    String detalii = date[4].trim();

                    Message msg = new Message(id, data, grup, eveniment, detalii);
                    for(Observer obs : obervers) {
                        obs.notification(msg);
                    }
                }
            }
        }catch(IOException e){
            System.out.println("Eroare la citire: " + e.getMessage());
        }

    }
}
