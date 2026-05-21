package ro.ulbs.proiectaresoftware.Lab9;

import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.Optional;
import java.util.Arrays;

public class AppLab9 {
    public static void main(String[] args) {

        //Problema 9.3.1
        /*
        Random random = new Random();
        List<Integer> numere = IntStream.range(0, 10)
                .map(i -> 5 + random.nextInt(21))
                .boxed()
                .collect(Collectors.toList());
        System.out.println("Lista generata: " + numere);

        //a)
        int suma = numere.stream().reduce(0, Integer::sum);
        System.out.println("a) Suma elementelor: " + suma);

        //b)
        int maxim = numere.stream().max(Comparator.naturalOrder()).get();
        int minim = numere.stream().min(Comparator.naturalOrder()).get();
        System.out.println("b) Valoarea maxima: " + maxim + ", iar minima: " + minim);

        //c)
        List<Integer> numereFiltrate = numere.stream()
                .filter(n -> n >= 10 && n <= 20)
                .collect(Collectors.toList());
        System.out.println("c) Lista cu elemente intre 10 și 20: " + numereFiltrate);

        //d)
        List<Double> numereDouble = numere.stream()
                .map(n -> Double.valueOf(n))
                .collect(Collectors.toList());
        System.out.println("d) Lista transformata în Double: " + numereDouble);

        //e)
        boolean contine12 = numere.stream().anyMatch(n -> n == 12);
        System.out.println("e) Exista valoarea 12 in lista? " + contine12);
        */

        //Problema 9.3.2
        String text = "Acesta este un program scris in java pentru expresii lambda";
        List<String> cuvinte = Arrays.asList(text.split(" "));
        System.out.println("Lista initiala: " + cuvinte);

        //a)
        List<String> cuvinteLungimePeste5 = cuvinte.stream().filter(c -> c.length() >= 5).collect(Collectors.toList());
        long numarCuvinte = cuvinte.stream().filter(c -> c.length() >= 5).count();
        System.out.println("a) Lista filtrata: " + cuvinteLungimePeste5);
        System.out.println("a) Numar cuvinte: " + numarCuvinte);

        //b)
        List<String> cuvinteOrdonate = cuvinteLungimePeste5.stream().sorted().collect(Collectors.toList());
        System.out.println("b) Lista ordonata alfabetic: " + cuvinteOrdonate);

        //c)
        Optional<String> elementCuP = cuvinte.stream().filter(c -> c.startsWith("p")).findFirst();
        if (elementCuP.isPresent()) {
            System.out.println("c) Element care incepe cu litera 'p': " + elementCuP.get());
        }
    }
}
