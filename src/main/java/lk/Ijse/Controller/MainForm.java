package lk.Ijse.Controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;

public class MainForm {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane subPane;

    @FXML
    void initialize() {
        assert subPane != null : "fx:id=\"subPane\" was not injected: check your FXML file 'mainForm.fxml'.";

    }

}
