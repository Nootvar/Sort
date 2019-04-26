package main;

import controller.IMainController;
import controller.MainController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import model.sort.*;
import view.MainViewController;

public class Program extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader (getClass().getResource("/view/MainView.fxml"));

        IMainController mc = new MainController(Config.VIEW_WIDTH, Config.VIEW_HEIGHT);
        loader.setController(new MainViewController(mc));

        Parent root = loader.load();
        Scene scene = new Scene(root);

        scene.setOnKeyPressed(keyEvent -> {
            if (keyEvent.getCode() == KeyCode.S) {
                mc.sort(new SelectionSort());
            } else if (keyEvent.getCode() == KeyCode.I) {
                mc.sort(new InsertionSort());
            } else if (keyEvent.getCode() == KeyCode.Q) {
                mc.sort(new QuickSort());
            } else if (keyEvent.getCode() == KeyCode.M) {
                mc.sort(new MergeSort());
            } else if (keyEvent.getCode() == KeyCode.H) {
                mc.sort(new HeapSort());
            } else if (keyEvent.getCode() == KeyCode.G) {
                mc.sort(new GnomeSort());
            } else if (keyEvent.getCode() == KeyCode.R) {
                mc.sort(new RadixSort());
            } else if (keyEvent.getCode() == KeyCode.F) {
                mc.shuffle();
            }
        });

        stage.setScene(scene);
        stage.setTitle("Sort");
        //stage.getIcons().add(new Image(getClass().getResourceAsStream("../view/robot.png")));
        stage.setFullScreen(true);

        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
