package ro.ulbs.proiectaresoftware.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class AppDesktop implements Observer {
    private Map<Integer, Message> map = new TreeMap<>();
    private int nrMsg = 0;

    @Override
    public int notification(Message msg) {
        if (msg.getGrup().equals("Backend")) {
            map.put(msg.getId(), msg);
        }
        nrMsg++;

        if (nrMsg % 5 == 0) {
            return saveData();
        }
        return 0;
    }

    private int saveData() {
        List<String> linii = new ArrayList<>();
        Path output = Paths.get("src/main/java/ro/ulbs/proiectaresoftware/Test/desktopOut.txt");
        for (Message m : map.values()) {
            String linie = m.getId() + ", " + m.getEveniment() + ", " + m.getDetalii();
            linii.add(linie);
        }

        try {
            Files.write(output, linii);
            return 0;
        } catch (IOException e) {
            return 1;
        }
    }
}
