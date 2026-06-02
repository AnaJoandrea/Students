package ro.ulbs.proiectaresoftware.Test;

public class Message {
    private int id;
    private String data;
    private String grup;
    private String eveniment;
    private String detalii;

    public Message(int id, String data, String grup, String eveniment, String detalii) {
        this.id = id;
        this.data = data;
        this.grup = grup;
        this.eveniment = eveniment;
        this.detalii = detalii;
    }

    public String getData() {
        return data;
    }

    public int getId() {
        return id;
    }

    public String getGrup() {
        return grup;
    }

    public String getEveniment() {
        return eveniment;
    }

    public String getDetalii() {
        return detalii;
    }
}
