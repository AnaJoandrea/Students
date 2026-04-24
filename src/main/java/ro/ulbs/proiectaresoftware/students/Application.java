package ro.ulbs.proiectaresoftware.students;

import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.Comparator;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Hashtable;
import java.util.EnumMap;
import java.util.IdentityHashMap;
import java.util.LinkedHashMap;
import java.util.Properties;
import java.util.TreeMap;
import java.util.WeakHashMap;

public class Application {
    static void main() {

        //LAB1
        /*Student s1 = new Student(112, "Ioan", "Popa", "TI21/1");
        Student s2 = new Student(112, "Maria", "Oprea", "TI21/1");
        Student s3 = new Student(120, "Alis", "Popa", "TI21/2");
        Student s4 = new Student(122, "Mihai", "Vecerdea", "TI22/1");
        Student s5 = new Student(122, "Eugen", "Uritescu", "TI22/2");
        /*s1.getDate();
        s2.getDate();
        s3.getDate();
        s4.getDate();*/


        //LAB2
        //a)
        List<Student> studenti = new ArrayList<>();
       /* studenti.add(s1);
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
      /*  Path input = Paths.get("src/main/java/ro/ulbs/proiectaresoftware/Lab4/students/studenti_in.txt");
        Path output = Paths.get("src/main/java/ro/ulbs/proiectaresoftware/Lab4/students/studenti_out.txt");
        List<Student> listaStudenti = new ArrayList<>();
        try {
            List<String> linii = Files.readAllLines(input);
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
        } */

        //LAB 4
      /*  HashMap<Integer, Student> mapStudenti = new HashMap<>();
        for (Student s : listaStudenti) {
            mapStudenti.put(s.getNumarMatricol(), s);
        }
        Path pathNote = Paths.get("src/main/java/ro/ulbs/proiectaresoftware/Lab4/students/note_anon.txt");
        try{
        List<String> liniiNote = Files.readAllLines(pathNote);
        for (String linieNota : liniiNote) {
            String[] valori = linieNota.split(",");
            if (valori.length == 2) {
                int matricolCitit = Integer.parseInt(valori[0].trim());
                float notaCitita = Float.parseFloat(valori[1].trim());
                Student studentGasit = mapStudenti.get(matricolCitit);
                if (studentGasit != null) {
                    studentGasit.setNota(notaCitita);
                }
            }
        }
        for (Integer cheieMatricol : mapStudenti.keySet()) {
            Student studentFinal = mapStudenti.get(cheieMatricol);
            System.out.println(studentFinal.toString());
        }
    } catch (IOException e) {
        e.printStackTrace();
    } catch (NumberFormatException e) {
        e.printStackTrace();
        }
        */

        //LAB5
        List<StudentBursier> bursieri = new ArrayList<>();
        bursieri.add(new StudentBursier(1025, "Andrei", "Popa", "ISM141/2", 8.70f, 725.50));
        bursieri.add(new StudentBursier(1024, "Ioan", "Mihalcea", "ISM141/1", 9.80f, 801.10));
        bursieri.add(new StudentBursier(1026, "Anamaria", "Prodan", "TI131/1", 8.90f, 745.50));
        bursieri.add(new StudentBursier(1029, "Bianca", "Popescu", "TI131/1", 9.10f, 780.80));
        String outputPathBursieri = "src/main/java/ro/ulbs/proiectaresoftware/Lab4/students/bursieri_out.txt";
        List<String> liniiDeSalvat = new ArrayList<>();
        for (StudentBursier s : bursieri) {
            liniiDeSalvat.add(s.toString());
        }
        try {
            Path caleFisier = Paths.get(outputPathBursieri);
            if (caleFisier.getParent() != null) {
                Files.createDirectories(caleFisier.getParent());
            }
            Files.write(caleFisier, liniiDeSalvat);
            System.out.println("Fisierul a fost salvat cu succes in: " + outputPathBursieri);
        } catch (IOException e) {
            System.err.println("Eroare la scrierea in fisier: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
