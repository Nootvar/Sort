package model;

public class SelectionSort implements ISortingAlgorithm {

    /**
     * Sort the array
     * @param array The array to sort
     */
    @Override
    public IArray sort(IArray array) {
        /* a[0] to a[n-1] is the array to sort */
        int i,j;
        int n = array.length(); // initialise to a's length

        /* advance the position through the entire array */
        /*   (could do j < n-1 because single element is also min element) */
        for (j = 0; j < n-1; j++)
        {
            /* find the min element in the unsorted a[j .. n-1] */

            /* assume the min is the first element */
            int iMin = j;
            /* test against elements after j to find the smallest */
            for (i = j+1; i < n; i++)
            {
                /* if this element is less, then it is the new minimum */
                if (array.isSmaller(i, iMin))
                {
                    /* found new minimum; remember its index */
                    iMin = i;
                }
            }

            if (iMin != j)
            {
                array.swap(j, iMin);
            }
        }
        return array;
    }
}
