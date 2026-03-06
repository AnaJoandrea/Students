package ro.ulbs.proiectaresoftware.students;

public class Application {
    static void main() {
        Student s1 = new Student(112, "Ioan", "Popa", "TI21/1");
        Student s2 = new Student(112, "Maria", "Oprea", "TI21/1");
        Student s3 = new Student(120, "Alis", "Popa", "TI21/2");
        Student s4 = new Student(122, "Mihai", "Vecerdea", "TI22/1");
        Student s5 = new Student(122, "Eugen", "Uritescu", "TI22/2");
        s1.getDate();
        s2.getDate();
        s3.getDate();
        s4.getDate();
    }
}
