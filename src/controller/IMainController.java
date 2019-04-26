package controller;

import model.sort.ISortingAlgorithm;
import view.MainViewController;

public interface IMainController {
    void sort(ISortingAlgorithm sortingAlgorithm);
    void shuffle();
    void addView(MainViewController view);
}
