package ro.ulbs.proiectaresoftware.Test;

public class AppMobile implements Observer {

    @Override
    public int notification(Message msg) {
        if (msg.getGrup().equals("Frontend")) {
            System.out.println(msg.getId() + ", " + msg.getData() + ", " + msg.getEveniment() + ", " + msg.getDetalii());
        }
        return 0;
    }
}
