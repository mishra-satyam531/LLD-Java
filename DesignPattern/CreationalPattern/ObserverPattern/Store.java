package DesignPattern.creationalPattern.ObserverPattern;

import DesignPattern.creationalPattern.ObserverPattern.Observable.IphoneObservableImpl;
import DesignPattern.creationalPattern.ObserverPattern.Observable.StocksObservable;
import DesignPattern.creationalPattern.ObserverPattern.Observer.EmailAlertObserverImpl;
import DesignPattern.creationalPattern.ObserverPattern.Observer.MobileAlertObserverImpl;
import DesignPattern.creationalPattern.ObserverPattern.Observer.NotificationAlertObserver;

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
