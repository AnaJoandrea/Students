package ro.ulbs.proiectaresoftware.Test;

public class AppMain {

    public static void main(String[] args) {
        Server server = new Server();
        AppDesktop desktopApp = new AppDesktop();
        AppMobile mobileApp = new AppMobile();

        server.addObserver(desktopApp);
        server.addObserver(mobileApp);
        server.start();
    }
}
