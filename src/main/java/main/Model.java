package main;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.util.ArrayList;

/**
 * This is the model of the MVC model. It holds data and
 * listeners so that the data can be viewed in many ways.
 * @param <T> The type of data that will be stored
 * @author Jonathan Stewart Thomas
 * @version 1.0.1.230413
 */
public class Model <T> {
    private final ArrayList<T> dataList;
    private final ArrayList<ChangeListener> listeners;

    /**
     * Creates a model object holding an array list of data
     * and change listeners
     */
    public Model() {
        dataList = new ArrayList<>();
        listeners = new ArrayList<>();
    }

    /**
     * Adds data to the array list
     * @param data  the data being added
     */
    public void add(T data) {
        dataList.add(data);
    }

    /**
     * attaches a change listener to this model
     * @param listener  the change listener being attached
     */
    public void attach(ChangeListener listener) {
        listeners.add(listener);
    }

    /**
     * Updates data at a specific position in the array list
     * @param position  the position of the data being updated
     * @param updated   the updated data
     */
    public void update(int position, T updated) {
        dataList.set(position, updated);
        for (ChangeListener listener : listeners) {
            listener.stateChanged(new ChangeEvent(this));
        }
    }

    /**
     * Gets the data at a specific index
     * @param index the index the data is at
     * @return      the data
     */
    public T get(int index) {return dataList.get(index);}
}
