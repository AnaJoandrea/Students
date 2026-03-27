package ro.ulbs.proiectaresoftware.students;

public class Student {
    int numarMatricol;
    String prenume;
    String nume;
    String formatieDeStudiu;

    public Student(int numarMatricol, String prenume, String nume, String formatieDeStudiu) {
        this.numarMatricol = numarMatricol;
        this.prenume = prenume;
        this.nume = nume;
        this.formatieDeStudiu = formatieDeStudiu;
    }

    public int getNumarMatricol() {
        return numarMatricol;
    }

    public String getPrenume() {
        return prenume;
    }

    public String getNume() {
        return nume;
    }

    public String getFormatieDeStudiu() {
        return formatieDeStudiu;
    }
    public void getDate(){
        System.out.println(getNumarMatricol() + " " + getNume() + ' ' + getPrenume() + ' ' + getFormatieDeStudiu());
    }

    @Override
    public boolean equals(Object s) {
        if (s == null || !(s instanceof Student)) {
            return false;
        }
        Student student = (Student) s;
        return this.prenume.equals(student.prenume) && this.nume.equals(student.nume) && this.formatieDeStudiu.equals(student.formatieDeStudiu);
    }

    @Override
    public String toString() {
        return numarMatricol + ", " + prenume + ", " + nume + ", " + formatieDeStudiu;
    }
}
