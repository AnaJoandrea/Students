package ro.ulbs.proiectaresoftware.students;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class AplicatieCuDecorator {
    public static void main(String[] args) {
        List<Student> studenti = Arrays.asList(
                new Student(1025, "Andrei", "Popa", "ISM141/2", 8.70f),
                new Student(1024, "Ioan", "Mihalcea", "ISM141/1", 10.0f),
                new Student(1026, "Anamaria", "Prodan", "TI131/1", 8.90f)
        );

        IStudentiExport strategyConsole = new StudentiInConsola();
        IStudentiExport strategyFisierText = new StudentiInFisierText("src/main/java/ro/ulbs/proiectaresoftware/students/StudentiInFiser.txt");
        IStudentiExport strategyFisierExcel = new StudentiInFisierXlsx("src/main/java/ro/ulbs/proiectaresoftware/students/StudentiInFisier.xlsx");

        List<IStudentiExport> strategiiDeExport = new ArrayList<>();
        strategiiDeExport.add(strategyConsole);
        strategiiDeExport.add(strategyFisierText);
        strategiiDeExport.add(strategyFisierExcel);

        for (IStudentiExport strategy : strategiiDeExport) {

            IStudentiExport decorator = new TimeExecutionDecorator(strategy);
            decorator.doExport(studenti);
        }
    }
}
