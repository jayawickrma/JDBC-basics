package lk.Ijse.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class MainForm  {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    @FXML
    private AnchorPane localDate;

    @FXML
    private Text time;
    @FXML
    private AnchorPane localTime;
    @FXML
    private AnchorPane customerCount;
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
            time.getText();
    }


}
