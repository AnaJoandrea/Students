package ro.ulbs.proiectaresoftware.students;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class AplicatieCuBursaTest {

    private AplicatieCuBursa appCuBursa;

    @BeforeEach
    public void setUp() {
        appCuBursa = new AplicatieCuBursa();
    }

    @Test
    public void sortTest1() {
        List<StudentBursier> lista = appCuBursa.genereaza();
        appCuBursa.sorteaza(lista);

        for (int i = 0; i < lista.size() - 1; i++) {
            StudentBursier s1 = lista.get(i);
            StudentBursier s2 = lista.get(i + 1);

            int comparatieFormatie = s1.getFormatieDeStudiu().compareTo(s2.getFormatieDeStudiu());
            Assertions.assertTrue(comparatieFormatie <= 0, "Eroare la sortarea formatiei de studiu!");

            if (comparatieFormatie == 0) {
                int comparatieNume = s1.getNume().compareTo(s2.getNume());
                Assertions.assertTrue(comparatieNume <= 0, "Eroare la sortarea numelui!");
            }
        }
    }
}