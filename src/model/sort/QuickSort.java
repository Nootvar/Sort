package model.sort;

import model.array.IArray;

public class QuickSort implements ISortingAlgorithm {
    @Override
    public IArray sort(IArray array) {
        quickSort(array, 0, array.length() - 1);
        return array;
    }

    private static void quickSort (IArray array, int startIndex,   int endIndex)
    {
        if (startIndex < endIndex){
            int pivotIndex = startIndex+((endIndex-startIndex)/2);
            // Initial position of the pivot = center of the array
            int pivot = array.get(pivotIndex);
            int i =  startIndex, j = endIndex;
            do {
                // Find the index of the first element, from startIndex to pivotIndex, either smaller or equals to the pivot
                while(array.get(i) < pivot) ++i;

                // Find the index of the first element, form endIndex to pivotIndex, either bigger or equals to the pivot
                while(array.get(j) > pivot)--j;
                // Permute and update the index
                if (i<j) {
                    array.swap(i, j);
                    if  (i == pivotIndex){ pivotIndex = j; ++i;}
                    else if (j == pivotIndex) { pivotIndex = i; --j;}
                    else { ++i; --j;}
                }
            }while(i!=j);
            //Recursive call on the left part of the array
            if (startIndex < pivotIndex-1) quickSort(array, startIndex, pivotIndex-1);
            //Recursive call on the right part of the array
            if (pivotIndex < endIndex-1) quickSort(array, pivotIndex + 1, endIndex);
        }
    }
}
