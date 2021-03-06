package model.array;

import model.ISortListener;
import model.array.IArray;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Array implements IArray {

    private int[] array;
    private List<ISortListener> listeners;

    public Array(int size) {
        array = new int[size];
        for (int i = 0; i < size; i++)
            array[i] = i;
        listeners = new ArrayList<>();
    }

    public Array(int[] array) {
        this.array = array;
        listeners = new ArrayList<>();
    }

    public void shuffle() {
        Random random = ThreadLocalRandom.current();
        for (int i = length() - 1; i > 0; i--)
        {
            int index = random.nextInt(i + 1);
            // Simple swap
            swap(index, i);
        }
    }

    public int get(int i) {
        for (ISortListener listener : listeners)
            listener.onValueAccessed(array[i]);
        return array[i];
    }

    public void set(int i, int value) {
        for (ISortListener listener : listeners)
            listener.onValueDisplaced(array[i]);
        array[i] = value;
    }

    public int length() {
        return array.length;
    }

    public void swap(int i, int j) {
        for (ISortListener listener : listeners)
            listener.onValuesDisplaced(array[i], array[j]);
        int a = get(i);
        set(i, get(j));
        set(j, a);
    }

    public boolean isSmaller(int i, int j) {
        for (ISortListener listener : listeners)
            listener.onValuesCompared(array[i], array[j]);
        return get(i) < get(j);
    }

    public boolean isBigger(int i, int j) {
        for (ISortListener listener : listeners)
            listener.onValuesCompared(array[i], array[j]);
        return get(i) > get(j);
    }

    public boolean isEqual(int i, int j) {
        for (ISortListener listener : listeners)
            listener.onValuesCompared(array[i], array[j]);
        return get(i) == get(j);
    }

    public boolean isSmallerOrEqual(int i, int j) {
        for (ISortListener listener : listeners)
            listener.onValuesCompared(array[i], array[j]);
        return get(i) <= get(j);
    }

    @Override
    public boolean isBiggerOrEqual(int i, int j) {
        for (ISortListener listener : listeners)
            listener.onValuesCompared(array[i], array[j]);
        return get(i) >= get(j);
    }

    public boolean isSorted() {
        for (int i = 0; i < length() - 1; i++)
            if (isBigger(i, i + 1))
                return false;
            return true;
    }

    @Override
    public int getMax() {
        int max = array[0];
        for (int value : array)
            if (value > max)
                max = value;
            return max;
    }

    public void addListeners(ISortListener listener) {
        listeners.add(listener);
    }
}
