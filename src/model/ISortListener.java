package model;

public interface ISortListener {
    void onValueAccessed(int value);
    void onValueDisplaced(int value);
    void onValuesDisplaced(int fromValue, int toValue);
    void onValuesCompared(int fromValue, int tValue);
}
