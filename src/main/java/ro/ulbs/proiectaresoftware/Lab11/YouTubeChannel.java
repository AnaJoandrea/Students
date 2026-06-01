package ro.ulbs.proiectaresoftware.Lab11;

import java.util.ArrayList;
import java.util.List;

public class YouTubeChannel implements Subject {
    private String channelName;
    private List<Observer> observers = new ArrayList<>();

    public YouTubeChannel(String channelName) {
        this.channelName = channelName;
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(String message) {
        for (Observer obs : observers) {
            obs.update(message);
        }
    }

    public void uploadVideo(String title) {
        System.out.println("{"+ channelName + "} uploaded a new video: " + title);
        notifyObservers(title);
    }
}
