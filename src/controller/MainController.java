package controller;

import main.Config;
import model.*;
import model.array.DrawableArray;
import model.array.IArray;
import model.sort.ISortingAlgorithm;
import view.MainViewController;

public class MainController implements IMainController {

    private int viewWidth,viewHeight;
    private IArray array;

    public MainController(int viewWidth, int viewHeight) {
        this.viewWidth = viewWidth;
        this.viewHeight = viewHeight;
    }

    @Override
    public void sort(ISortingAlgorithm sortingAlgorithm) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                sortingAlgorithm.sort(array);
            }
        }).start();
    }

    @Override
    public void shuffle() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                array.shuffle();
            }
        }).start();
    }

    @Override
    public void addView(MainViewController view) {
        array = new DrawableArray(Config.ARRAY_SIZE, viewHeight, viewWidth, view);
        array.addListeners(new SortListener(array.length()));
    }
}
