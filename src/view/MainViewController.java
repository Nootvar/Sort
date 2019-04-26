package view;

import controller.IMainController;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;

import java.net.URL;
import java.util.ResourceBundle;

public class MainViewController implements Initializable {

    private IMainController mc;

    @FXML
    public AnchorPane root;

    public MainViewController(IMainController mc) {
        this.mc = mc;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        mc.addView(this);
    }

    public void setRectangles(Rectangle[] rectangles) {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                root.getChildren().addAll(rectangles);
            }
        });
    }

    public void setRectangle(Rectangle rectangle) {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {

                root.getChildren().add(rectangle);
            }
        });
    }

    public void removeRectangle(Rectangle rectangle) {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                root.getChildren().remove(rectangle);
            }
        });

    }
}
