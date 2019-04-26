package model.array;

import model.ISortListener;

public interface IArray {

    void shuffle();
    int get(int i);
    void set(int i, int value);
    int length();
    void swap(int i, int j);
    boolean isSmaller(int i, int j);
    boolean isBigger(int i, int j);
    boolean isEqual(int i, int j);
    boolean isSmallerOrEqual(int i, int j);
    boolean isBiggerOrEqual(int i, int j);
    boolean isSorted();
    int getMax();
    void addListeners(ISortListener listener);
}
