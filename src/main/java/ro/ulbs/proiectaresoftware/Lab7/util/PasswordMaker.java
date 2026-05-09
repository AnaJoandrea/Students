package ro.ulbs.proiectaresoftware.Lab7.util;

public class PasswordMaker {
    private static final int magic_number = 3;
    private static final String magic_string;
    private String name;
    private static PasswordMaker instance;
    private static int callingCount = 0;

    static {
        StringRandomizer srand = new StringRandomizer();
        magic_string  = srand.randomString(20);
        instance = new PasswordMaker("SuperSecretGenerator");
    }

    private PasswordMaker(String name) {
        this.name = name;
    }

    public static PasswordMaker getInstance() {
        callingCount++;
        return instance;
    }

    public static int getCallingCounts() {
        return callingCount;
    }

    public String getPassword() {
        java.util.Random r = new java.util.Random();
        String ln = ""+name.length();
        ln += r.nextInt(101);
        StringRandomizer srand = new StringRandomizer();
        return srand.randomString(magic_number) + srand.randomString(10, magic_string) + ln;
    }
}