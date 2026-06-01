package ro.ulbs.proiectaresoftware.students;

import java.util.List;

public class TimeExecutionDecorator extends StudentiExportDecorator {

    public TimeExecutionDecorator(IStudentiExport exporter) {
        super(exporter);
    }

    @Override
    public void doExport(List<Student> studenti) {
        long startTime = System.currentTimeMillis();
        super.doExport(studenti);
        long endTime = System.currentTimeMillis();
        long timpExecutie = endTime - startTime;
        System.out.println("--> Timp executie pentru " +
                exporter.getClass().getSimpleName() +
                ": " + timpExecutie + " ms");
    }
}
