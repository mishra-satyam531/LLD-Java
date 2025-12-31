package Pattern.ObserverPattern.Observer;

import Pattern.ObserverPattern.Observable.StocksObservable;

public class MobileAlertObserverImpl implements NotificationAlertObserver {
    String username;
    StocksObservable observable;

    public MobileAlertObserverImpl(String username, StocksObservable observable) {
        this.username = username;
        this.observable = observable;
    }

    @Override
    public void update() {
        sendMsgOnMobile(username, "product is in stock hurry up!");
    }

    private void sendMsgOnMobile(String username, String string) {
        System.out.println("Mail sent to: " + username);
    }
}
