package net.iescierva.jgg.musica.Listeners.OnAdapterData;

import android.annotation.SuppressLint;

import net.iescierva.jgg.musica.Modelo.CancionAdapter;

import java.util.ArrayList;
import java.util.List;

public class AdapterDataObserver {
    private List<OnAdapterDataChanged> observers = new ArrayList<>();

    public void registerObserver(OnAdapterDataChanged observer) {
        observers.add(observer);
    }

    public void unregisterObserver(OnAdapterDataChanged observer) {
        observers.remove(observer);
    }

    @SuppressLint("NotifyDataSetChanged")
    public void notificarAdapter(CancionAdapter adapter) {
        adapter.notifyDataSetChanged();
        notifyObservers();
    }

    public void notifyObservers() {
        for (OnAdapterDataChanged observer : observers) {
            observer.onAdapterDataChanged();
        }
    }
}
