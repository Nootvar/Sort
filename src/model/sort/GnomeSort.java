package model.sort;

import model.array.IArray;

public class GnomeSort implements ISortingAlgorithm {
    @Override
    public IArray sort(IArray array) {
        int index = 0, n = array.length();

        while (index < n) {
            if (index == 0)
                index++;
            if (array.isBiggerOrEqual(index, index - 1))
                index++;
            else {
                array.swap(index, index - 1);
                index--;
            }
        }
        return array;
    }
}
