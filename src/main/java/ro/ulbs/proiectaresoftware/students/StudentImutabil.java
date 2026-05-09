package ro.ulbs.proiectaresoftware.students;

public class StudentImutabil {
    private final int numarMatricol;
    private final String prenume;
    private final String nume;
    private final String formatieDeStudiu;
    private final float nota;

    public StudentImutabil(int numarMatricol, String prenume, String nume, String formatieDeStudiu, float nota) {
        this.numarMatricol = numarMatricol;
        this.prenume = prenume;
        this.nume = nume;
        this.formatieDeStudiu = formatieDeStudiu;
        this.nota = nota;
    }

    public int getNumarMatricol() { return numarMatricol; }
    public String getPrenume() { return prenume; }
    public String getNume() { return nume; }
    public String getFormatieDeStudiu() { return formatieDeStudiu; }
    public float getNota() { return nota; }

    public void getDate() {
        System.out.println(getNumarMatricol() + " " + getNume() + " " + getPrenume() + " " + getFormatieDeStudiu());
    }

    @Override
    public boolean equals(Object s) {
        if (s == null || !(s instanceof StudentImutabil)) {
            return false;
        }
        StudentImutabil student = (StudentImutabil) s;
        return this.numarMatricol == student.numarMatricol;
    }

    @Override
    public String toString() {
        return numarMatricol + ", " + prenume + ", " + nume + ", " + formatieDeStudiu + ", nota: " + nota;
    }
}
