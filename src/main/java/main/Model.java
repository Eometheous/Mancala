package main;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.util.ArrayList;

/**
 * This is the model of the MVC model. It holds data and
 * listeners so that the data can be viewed in many ways.
 * @author Jonathan Stewart Thomas
 * @param <T> The type of data that will be stored
 * @version 1.0.1.230413
 */
public class Model <T> {
    private final ArrayList<T> dataList;
    private final ArrayList<ChangeListener> listeners;

    /**
     * Creates a model object holding an array list of data
     * and change listeners.
     * @author Jonathan Stewart Thomas
     */
    public Model() {
        dataList = new ArrayList<>();
        listeners = new ArrayList<>();
    }

    /**
     * Adds data to the array list
     * @author Jonathan Stewart Thomas
     * @param data  the data being added
     */
    public void add(T data) {
        dataList.add(data);
    }

    /**
     * attaches a change listener to this model
     * @author Jonathan Stewart Thomas
     * @param listener  the change listener being attached
     */
    public void attach(ChangeListener listener) {
        listeners.add(listener);
    }

    /**
     * Updates data at a specific position in the array list
     * @author Jonathan Stewart THomas
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
     * @author Jonathan Stewart Thomas
     * @param index the index the data is at
     * @return      the data
     */
    public T get(int index) {return dataList.get(index);}
}
