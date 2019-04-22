package main;

import controller.IMainController;
import controller.MainController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import view.MainViewController;

public class Program extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader (getClass().getResource("/view/MainView.fxml"));
        IMainController mc = new MainController(1080, 1920);
        loader.setController(new MainViewController(mc));

        Parent root = loader.load();
        Scene scene = new Scene(root);

        scene.setOnKeyPressed(keyEvent -> {
            if (keyEvent.getCode() == KeyCode.S) {
                mc.sort();
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
