package ro.ulbs.proiectaresoftware.students;

import java.util.Arrays;
import java.util.List;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

//a)
interface IStudentiExport {
    void doExport(List<Student> studenti);
}

class Exporter {
    void startExport(IStudentiExport strategyInstance, List<Student> students) {
        strategyInstance.doExport(students);
    }
}

class StudentiInConsola implements IStudentiExport {
    @Override
    public void doExport(List<Student> studenti) {
        System.out.println("Se exporta studentii in consola");
        for (Student s : studenti) {
            System.out.println(s);
        }
    }
}

//b)
class StudentiInFisierText implements IStudentiExport {
    private String numeFisier;

    public StudentiInFisierText(String numeFisier) {
        this.numeFisier = numeFisier;
    }

    @Override
    public void doExport(List<Student> studenti) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(numeFisier))) {
            for (Student s : studenti) {
                writer.println(s.getNumarMatricol() + "," + s.getPrenume() + "," + s.getNume() + "," + s.getFormatieDeStudiu() + "," + s.getNota());
            }
            System.out.println("Export realizat cu succes!");
        } catch (IOException e) {
            System.out.println("A aparut o eroare:" + e.getMessage());
        }
    }
}

//c)
class StudentiInFisierXlsx implements IStudentiExport {
    private String numeFisier;

    public StudentiInFisierXlsx(String numeFisier) {
        this.numeFisier = numeFisier;
    }

    @Override
    public void doExport(List<Student> studenti) {
        try {
            PrintWriter writer = new PrintWriter(new FileWriter(numeFisier));

            writer.println("Numar Matricol,Prenume,Nume,Formatie de Studiu,Nota");
            for (Student s : studenti) {
                writer.println(s.getNumarMatricol() + "," + s.getPrenume() + "," + s.getNume() + "," + s.getFormatieDeStudiu() + "," + s.getNota());
            }
            writer.flush();
            writer.close();
            System.out.println("Export realizat cu succes!");

        } catch (IOException e) {
            System.out.println("A aparut o eroare:" + e.getMessage());
        }
    }
}

//d)
interface IStudentiImport {
    List<Student> doImport();
}

class Importer {
    List<Student> startImport(IStudentiImport strategyInstance) {
        return strategyInstance.doImport();
    }
}

class StudentiDinFisierText implements IStudentiImport {
    private String numeFisier;

    public StudentiDinFisierText(String numeFisier) {
        this.numeFisier = numeFisier;
    }

    @Override
    public List<Student> doImport() {
        List<Student> studentiCititi = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(numeFisier))) {
            String linie;

            while ((linie = reader.readLine()) != null) {

                String[] date = linie.split(",");
                int numarMatricol = Integer.parseInt(date[0]);
                String prenume = date[1];
                String nume = date[2];
                String formatie = date[3];
                float nota = Float.parseFloat(date[4]);
                Student s = new Student(numarMatricol, prenume, nume, formatie, nota);
                studentiCititi.add(s);
            }
            System.out.println("Import realizat cu succes!");
        } catch (IOException e) {
            System.out.println("A aparut o eroare:" + e.getMessage());
        }
        return studentiCititi;
    }
}

//e)
class StudentiDinFisierXlsx implements IStudentiImport {
    private String numeFisier;

    public StudentiDinFisierXlsx(String numeFisier) {
        this.numeFisier = numeFisier;
    }

    @Override
    public List<Student> doImport() {
        List<Student> studentiCititi = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(numeFisier))) {
            String primaLinie = reader.readLine();
            String linie;

            while ((linie = reader.readLine()) != null) {
                String[] date = linie.split(",");
                int numarMatricol = Integer.parseInt(date[0]);
                String prenume = date[1];
                String nume = date[2];
                String formatie = date[3];
                float nota = Float.parseFloat(date[4]);
                Student s = new Student(numarMatricol, prenume, nume, formatie, nota);
                studentiCititi.add(s);
            }
            System.out.println("Import realizat cu succes!");
        } catch (IOException e) {
            System.out.println("A aparut o eroare:" + e.getMessage());
        }
        return studentiCititi;
    }
}

public class AplicatieCuStrategy {
    public static void main(String[] args) {

        //a)
        List<Student> studenti = Arrays.asList(
                new Student(1025, "Andrei", "Popa", "ISM141/2", 8.70f),
                new Student(1024, "Ioan", "Mihalcea", "ISM141/1", 10.0f),
                new Student(1026, "Anamaria", "Prodan", "TI131/1", 8.90f),
                new Student(1029, "Bianca", "Popescu", "TI131/1", 10.0f),
                new Student(1029, "Maria", "Pana", "TI131/2", 4.10f),
                new Student(1029, "Gabriela", "Mohanu", "TI131/2", 7.33f),
                new Student(1029, "Marius", "Nasta", "TI131/2", 3.20f),
                new Student(1029, "Marius", "Nasta", "TI131/1", 5.12f),
                new Student(1029, "Andrei", "Dobrescu", "TI131/2", 2.22f)
        );

        IStudentiExport strategyConsole = new StudentiInConsola();
        Exporter exporter = new Exporter();
        exporter.startExport(strategyConsole, studenti);

        //b)
        String fileNameTxt = "src/main/java/ro/ulbs/proiectaresoftware/students/StudentiInFiser.txt";
        IStudentiExport strategyFisierText = new StudentiInFisierText(fileNameTxt);
        exporter.startExport(strategyFisierText, studenti);

        //c)
        String fileNameExcel = "src/main/java/ro/ulbs/proiectaresoftware/students/StudentiInFisier.xlsx";
        IStudentiExport strategyFisierExcel = new StudentiInFisierXlsx(fileNameExcel);
        exporter.startExport(strategyFisierExcel, studenti);

        //d)
        IStudentiImport strategyCitireText = new StudentiDinFisierText("src/main/java/ro/ulbs/proiectaresoftware/students/StudentiInFiser.txt");
        Importer importer = new Importer();
        List<Student> studentiImportatiDinText = importer.startImport(strategyCitireText);
        System.out.println("Lista studenti cititi din fisier: ");
        for (Student s : studentiImportatiDinText) {
            System.out.println(s.toString());
        }

        //e)
        String fileNameExcelCitire = "src/main/java/ro/ulbs/proiectaresoftware/students/StudentiInFisier.xlsx";
        IStudentiImport strategyCitireExcel = new StudentiDinFisierXlsx(fileNameExcelCitire);
        List<Student> studentiDinExcel = importer.startImport(strategyCitireExcel);
        System.out.println("Lista studenti cititi din Excel: ");
        for (Student s : studentiDinExcel) {
            System.out.println(s);
        }
    }
}
