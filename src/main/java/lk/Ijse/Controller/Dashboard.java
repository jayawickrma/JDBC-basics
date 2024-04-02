package lk.Ijse.Controller;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;

public class Dashboard implements Initializable {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane ancpane;

    @FXML
    void btnCustomerMange(ActionEvent event) throws IOException {
        Parent parent= FXMLLoader.load(getClass().getResource("/View/1.fxml"));
        ancpane.getChildren().setAll(parent);
    }
    @FXML
    void btnHOMEMange(ActionEvent event) throws IOException {
        Parent parent=FXMLLoader.load(getClass().getResource("/View/mainForm.fxml"));
        ancpane.getChildren().setAll(parent);
    }
    @FXML
    void btnRoommanage(ActionEvent event) throws IOException {
        Parent parent =FXMLLoader.load(getClass().getResource("/View/room.fxml"));
        ancpane.getChildren().setAll(parent);
    }

    @FXML
    void initialize() {
        assert ancpane != null : "fx:id=\"ancpane\" was not injected: check your FXML file 'dashboard.fxml'.";

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Parent root =null;
        try {
            root = FXMLLoader.load(getClass().getResource("/view/mainForm.fxml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        ancpane.getChildren().clear();
        ancpane.getChildren().add(root);
    }
}
