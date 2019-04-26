package model.sort;

import model.array.IArray;

public class HeapSort implements ISortingAlgorithm {
    @Override
    public IArray sort(IArray array) {
        int n = array.length();

        // Build heap (rearrange array)
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(array, n, i);

        // One by one extract an element from heap
        for (int i=n-1; i>=0; i--)
        {
            // Move current root to end
            array.swap(0, i);

            // call max heapify on the reduced heap
            heapify(array, i, 0);
        }
        return array;
    }

    // To heapify a subtree rooted with node i which is
    // an index in arr[]. n is size of heap
    void heapify(IArray array, int n, int i)
    {
        int largest = i; // Initialize largest as root
        int l = 2*i + 1; // left = 2*i + 1
        int r = 2*i + 2; // right = 2*i + 2

        // If left child is larger than root
        if (l < n && array.isBigger(l, largest))
            largest = l;

        // If right child is larger than largest so far
        if (r < n && array.isBigger(r, largest))
            largest = r;

        // If largest is not root
        if (largest != i)
        {
            array.swap(i, largest);

            // Recursively heapify the affected sub-tree
            heapify(array, n, largest);
        }
    }
}
