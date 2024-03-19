package lk.Ijse.Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;

public class MainForm  {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane food;

    @FXML
    private AnchorPane subPane;

    @FXML
    void btnADDON1(ActionEvent event) {

    }

    @FXML
    void btnaddon2(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert food != null : "fx:id=\"food\" was not injected: check your FXML file 'mainForm.fxml'.";
        assert subPane != null : "fx:id=\"subPane\" was not injected: check your FXML file 'mainForm.fxml'.";

    }


}
