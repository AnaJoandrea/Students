package ro.ulbs.proiectaresoftware.Lab4;
import java.util.HashMap;
import java.util.Map;
import java.util.Hashtable;
import java.util.EnumMap;
import java.util.IdentityHashMap;
import java.util.LinkedHashMap;
import java.util.Properties;
import java.util.TreeMap;
import java.util.WeakHashMap;

public class AppLab4 {
    static void main() {
        HashMap<String, Integer> varste = new HashMap<>();
        varste.put("Ioan", 21);
        varste.put("Maria", 22);
        varste.put("Victor", 20);
        varste.put("Simina", 20);
        varste.put("Marius", 21);
        varste.put("Mihai", 21);
        varste.put("Daniela", 23);
        Map<String, String> adrese = Map.of("Ioan", "Sibiu", "Maria", "Bucuresti", "Victor", "Cluj", "Simina", "Alba-Iulia", "Marius", "Medias", "Mihai", "Cisnadie", "Daniela", "Sibiu");

        //a)
        for (String nume : varste.keySet()) {
            Integer valoareVarsta = varste.get(nume);
            System.out.println(nume + " are " + valoareVarsta + " ani.");
        }
        System.out.println();
        varste.put("Vlad", 19);
        varste.put("Iulia", 19);
        for (String nume : varste.keySet()) {
            Integer valoareVarsta = varste.get(nume);
            System.out.println(nume + " are " + valoareVarsta + " ani.");
        }
        System.out.println();
        //c)
        HashMap<String, Tanar> tineri = new HashMap<>();
        for (String nume : varste.keySet()) {
            Integer varsta = varste.get(nume);
            String adresa = adrese.getOrDefault(nume, "Adresa necunoscuta");
            Tanar tanarNou = new Tanar(nume, varsta, adresa);
            tineri.put(nume, tanarNou);
        }
        for (String nume : tineri.keySet()) {
            Tanar tanar = tineri.get(nume);
            System.out.println(nume + " , " + tanar.toString());
        }
    }
}
