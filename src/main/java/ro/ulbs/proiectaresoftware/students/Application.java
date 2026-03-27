package ro.ulbs.proiectaresoftware.students;

import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.Comparator;

public class Application {
    static void main() {

        //LAB1
        /*Student s1 = new Student(112, "Ioan", "Popa", "TI21/1");
        Student s2 = new Student(112, "Maria", "Oprea", "TI21/1");
        Student s3 = new Student(120, "Alis", "Popa", "TI21/2");
        Student s4 = new Student(122, "Mihai", "Vecerdea", "TI22/1");
        Student s5 = new Student(122, "Eugen", "Uritescu", "TI22/2");
        s1.getDate();
        s2.getDate();
        s3.getDate();
        s4.getDate();*/


        //LAB2
        //a)
        /*List<Student> studenti = new ArrayList<>();
        studenti.add(s1);
        studenti.add(s2);
        studenti.add(s3);
        studenti.add(s4);
        studenti.add(s5);
        for(Student s : studenti)
            s.getDate();

        //b)
        Student v1 = new Student(120, "Alis", "Popa", "TI21/2");
        Student v2 = new Student(112, "Maria", "Popa", "TI21/1");
        System.out.println("Este Alis Popa in lista? " + studenti.contains(v1));
        System.out.println("Este Maria Popa (TI21/1) in lista? " + studenti.contains(v2));
         */

        //LAB3
        Path input = Paths.get("studenti_in.txt");
        Path output = Paths.get("studenti_out.txt");

        try {
            List<String> linii = Files.readAllLines(input);
            List<Student> listaStudenti = new ArrayList<>();

            for (String linie : linii) {
                String[] date = linie.split(",");
                if (date.length == 4) {
                    int matricol = Integer.parseInt(date[0].trim());
                    String prenume = date[1].trim();
                    String nume = date[2].trim();
                    String formatie = date[3].trim();
                    Student s = new Student(matricol, prenume, nume, formatie);
                    listaStudenti.add(s);
                }
            }
            for (Student s : listaStudenti) {
                s.getDate();
            }

            //TEMA
            Collections.sort(listaStudenti, Comparator.comparing(Student::getNume));

            List<String> liniiDeSalvat = new ArrayList<>();
            for (Student s : listaStudenti) {
                liniiDeSalvat.add(s.toString());
            }

            Files.write(output, liniiDeSalvat);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }
}
