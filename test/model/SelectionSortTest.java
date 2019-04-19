package model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SelectionSortTest {

    @Test
    public void test() {
        int[] toSort = {9,1,3,5,7,4,8,6,2,0};
        int[] sort = {0,1,2,3,4,5,6,7,8,9};

        ISortingAlgorithm sorter = new SelectionSort();

        Assertions.assertArrayEquals(sort, sorter.sort(toSort));
    }

}
