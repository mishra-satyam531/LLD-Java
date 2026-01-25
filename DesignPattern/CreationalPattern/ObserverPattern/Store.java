package DesignPattern.CreationalPattern.ObserverPattern;

import DesignPattern.CreationalPattern.ObserverPattern.Observable.IphoneObservableImpl;
import DesignPattern.CreationalPattern.ObserverPattern.Observable.StocksObservable;
import DesignPattern.CreationalPattern.ObserverPattern.Observer.EmailAlertObserverImpl;
import DesignPattern.CreationalPattern.ObserverPattern.Observer.MobileAlertObserverImpl;
import DesignPattern.CreationalPattern.ObserverPattern.Observer.NotificationAlertObserver;

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
