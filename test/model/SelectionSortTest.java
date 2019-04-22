package model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SelectionSortTest {

    @Test
    public void test() {
        Array toSort = new Array(new int[] {9, 1, 3, 5, 7, 4, 8, 6, 2, 0});

        ISortingAlgorithm sorter = new SelectionSort();

        Assertions.assertTrue(sorter.sort(toSort).isSorted());
    }

}
