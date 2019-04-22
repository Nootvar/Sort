package view;

import controller.IMainController;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;

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

    }
}
