package net.iescierva.jgg.musica.Listeners.OnMenuItem;

import java.util.ArrayList;
import java.util.List;


public class ItemMenuObserver {
    private List<OnItemMenuChanged> observers = new ArrayList<>();
    private int menuIconResId;
    private int menuItem;

    public void registerObserver(OnItemMenuChanged observer) {
        observers.add(observer);
    }

    public void unregisterObserver(OnItemMenuChanged observer) {
        observers.remove(observer);
    }

    public void setMenuIconResId(int resId, int item) {
        menuIconResId = resId;
        menuItem = item;
        notifyObservers();
    }

    public int getMenuIconResId() {
        return menuIconResId;
    }

    private void notifyObservers() {
        for (OnItemMenuChanged observer : observers) {
            observer.onMenuIconChanged();
        }
    }

    public int getMenuItem() {
        return menuItem;
    }
}
