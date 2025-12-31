package Pattern.ObserverPattern.Observable;

import java.util.ArrayList;
import java.util.List;

import Pattern.ObserverPattern.Observer.NotificationAlertObserver;

public class IphoneObservableImpl implements StocksObservable {
    public List<NotificationAlertObserver> observerList = new ArrayList<>();
    public int stockCount = 0;

    @Override
    public void add(NotificationAlertObserver observer) {
        observerList.add(observer);
    }

    @Override
    public void remove(NotificationAlertObserver observer) {
        observerList.remove(observer);
    }
    
    @Override
    public void notifySubscribers() {
        for(NotificationAlertObserver observer : observerList) {
            observer.update();
        }
    }

    @Override
    public void setStockCount(int newStockAdded) {
        stockCount += newStockAdded;
        if(stockCount == 0) {
            notifySubscribers();
        }
    }

    @Override
    public int getStockCount() {
        return stockCount;
    }
    
}
