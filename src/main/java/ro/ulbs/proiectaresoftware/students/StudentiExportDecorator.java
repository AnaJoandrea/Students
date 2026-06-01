package ro.ulbs.proiectaresoftware.students;

import java.util.List;

public abstract class StudentiExportDecorator implements IStudentiExport {

    protected IStudentiExport exporter;

    public StudentiExportDecorator(IStudentiExport exporter) {
        this.exporter = exporter;
    }

    @Override
    public void doExport(List<Student> studenti) {
        exporter.doExport(studenti);
    }
}
