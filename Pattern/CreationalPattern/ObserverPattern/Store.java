package Pattern.CreationalPattern.ObserverPattern;

import Pattern.CreationalPattern.ObserverPattern.Observable.IphoneObservableImpl;
import Pattern.CreationalPattern.ObserverPattern.Observable.StocksObservable;
import Pattern.CreationalPattern.ObserverPattern.Observer.EmailAlertObserverImpl;
import Pattern.CreationalPattern.ObserverPattern.Observer.MobileAlertObserverImpl;
import Pattern.CreationalPattern.ObserverPattern.Observer.NotificationAlertObserver;

public class Store {
    public static void main(String[] args) {
        StocksObservable iphoneStocksObservable = new IphoneObservableImpl();

        NotificationAlertObserver observer1 = new EmailAlertObserverImpl("xyz@gmail.com", iphoneStocksObservable);
        NotificationAlertObserver observer2 = new EmailAlertObserverImpl("xyz2@gmail.com", iphoneStocksObservable);
        NotificationAlertObserver observer3 = new MobileAlertObserverImpl("xyz_username", iphoneStocksObservable);

        iphoneStocksObservable.add(observer1);
        iphoneStocksObservable.add(observer2);
        iphoneStocksObservable.add(observer3);

        iphoneStocksObservable.setStockCount(10);
        iphoneStocksObservable.setStockCount(100);
    }
}
