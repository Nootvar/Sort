package main;

public class Config {
    public static final int VIEW_HEIGHT = 1080;
    public static final int VIEW_WIDTH = 1920;

    public static final int ARRAY_SIZE = bestSize();i//192*5;
    public static final int TIME_WASTE = 1;

    private static int bestSize() {
        int size = 1;
        for (int i = 1; i < VIEW_WIDTH; i++)
            if (VIEW_WIDTH % i == 0 && VIEW_HEIGHT / i > 0)
                size = i;
        return size;
    }
}
