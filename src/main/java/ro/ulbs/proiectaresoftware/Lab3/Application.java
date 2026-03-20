package ro.ulbs.proiectaresoftware.Lab3;
import java.util.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Application {
    public static void main( String array[]){
        Path input = Paths.get("src/main/java/ro/ulbs/proiectaresoftware/Lab3/in.txt");
        Path output = Paths.get("src/main/java/ro/ulbs/proiectaresoftware/Lab3/out.txt");
        try {
            List<String> linii = Files.readAllLines(input);
            List<String> liniiModificate = new ArrayList<>();

            for (String linie : linii) {
                //a)
                String newline = linie + "\n";
                System.out.println(newline);

                //b)
                String[] propozitii = newline.split("\\.");
                String newline1 = "";
                for (String prop : propozitii) {
                    newline1 = newline1 + prop + ".\n";
                }
                System.out.println(newline1);
                liniiModificate.add(newline1);
            }
            //c)
            Files.write(output, liniiModificate);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

