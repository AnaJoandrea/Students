package ro.ulbs.proiectaresoftware.Lab1;

public class Application {
    public static void main(String[] args) {

        //b)
        String alfabet = "";
        for (char c = 'a'; c <= 'z'; c++) {
            alfabet = alfabet + c;
        }

        System.out.println("Litere mici: " + alfabet.toLowerCase());
        System.out.println("Majuscule: " + alfabet.toUpperCase());

        //c)
        String[] array = new String[5];
        int indexArray = 0;
        array[0] = "";

        for (int i = 0; i < alfabet.length(); i++) {
            char c = alfabet.charAt(i);
            boolean esteVocala = (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u');

            if (esteVocala && i != 0) {
                indexArray++;
                array[indexArray] = "";
            }
            array[indexArray] = array[indexArray] + c;
        }

        for (int i = 0; i < array.length; i++) {
            System.out.println("array[" + i + "] = \"" + array[i] + "\"");
        }
    }
}
