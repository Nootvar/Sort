package model;

public interface IArray {

    void shuffle();
    int get(int i);
    void set(int i, int value);
    int length();
    void swap(int i, int j);
    boolean isSmaller(int i, int j);
    boolean isBigger(int i, int j);
    boolean isEqual(int i, int j);
    boolean isSorted();
    void addListeners(ISortListener listener);
}
