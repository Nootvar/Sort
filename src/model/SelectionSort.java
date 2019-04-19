package model;

public class SelectionSort implements ISortingAlgorithm {

    /**
     * procédure tri_selection(tableau t, entier n)
     *       pour i de 0 à n - 2
     *           min ← i
     *           pour j de i + 1 à n - 1
     *               si t[j] < t[min], alors min ← j
     *           fin pour
     *           si min ≠ i, alors échanger t[i] et t[min]
     *       fin pour
     *   fin procédure
     * @param values The values to sort
     */
    @Override
    public int[] sort(int[] values) {
        int min, temp;
        for (int i = 0; i < values.length; i++) {
            min = i;
            for (int j = i + 1; i < values.length - 1; j++) {
                if (values[j] < values[min]) {
                    min = j;
                }
            }
            if (min != i) {
                temp = values[i];
                values[i] = values[min];
                values[min] = temp;
            }
        }
        return values;
    }
}
