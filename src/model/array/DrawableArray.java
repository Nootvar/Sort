package model.array;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import main.Config;
import view.MainViewController;

public class DrawableArray extends Array {

    private Rectangle[] rectangles;
    private int viewHeight, viewWidth;
    private int rectWidth, rectHeight;
    private MainViewController view;


    public DrawableArray(int size, int viewHeight, int viewWidth, MainViewController view) {
        super(size);
        rectangles = new Rectangle[size];
        this.viewHeight = viewHeight;
        this.viewWidth = viewWidth;
        rectWidth = viewWidth/size;
        rectHeight = viewHeight/size;
        for (int i = 0; i < size; i++) {
            rectangles[i] = createRectangleAt(i, i);
        }
        this.view = view;
        view.setRectangles(rectangles);
    }

    public int get(int i) {
        //TODO
        return super.get(i);
    }

    public void set(int i, int value) {
        super.set(i, value);
        view.removeRectangle(rectangles[i]);
        Rectangle rectangle = createRectangleAt(value, i);
        rectangles[i] = rectangle;
        view.setRectangle(rectangle);
        try {
            Thread.sleep(Config.TIME_WASTE);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private Rectangle createRectangleAt(int value, int index) {
        Rectangle rectangle = new Rectangle();
        rectangle.setX(rectWidth*index);
        rectangle.setY(viewHeight - rectHeight*value);
        rectangle.setWidth(rectWidth);
        rectangle.setHeight(rectHeight*value);
        rectangle.setFill(getColor(value));
        return rectangle;
    }

    private Color getColor(int value) {
        if (value <= 255)
            return Color.rgb(value%255, 50, 50);
        if (value <= 255*2)
            return Color.rgb(50, value%255, 50);
        if (value <= 255*3)
            return Color.rgb(50, 50, value%255);
        if (value <= 255*4)
            return Color.rgb(value%255, 50, value%255);
        return Color.BLACK;
    }
}
