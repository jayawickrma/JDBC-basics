package lk.Ijse.Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Loging {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField password;

    @FXML
    private TextField username;
    @FXML
    void RegOnAction(ActionEvent event) throws IOException {
        Parent parent =FXMLLoader.load(getClass().getResource("/View/Registrtion Page.fxml"));
        Scene scene=new Scene(parent);
        Stage stage=new Stage();
        stage.setScene(scene);
        stage.setTitle("New User Register Page");
        stage.show();
        Stage stage1=(Stage)username.getScene().getWindow();
        stage1.close();
    }
    @FXML
    void btnLogInAction(ActionEvent event) throws IOException {
    String uname="admin";
    String pword="1234";
    if (username.getText().equals(uname)&& password.getText().equals(pword)){
        Parent parent= FXMLLoader.load(getClass().getResource("/View/dashboard.fxml"));
        Scene scene=new Scene(parent);
        Stage stage=new Stage();
        stage.setScene(scene);
        stage.setTitle("DashBoard");
        stage.show();
        Stage stage1=(Stage) username.getScene().getWindow();
        stage1.close();

    }
    }

    @FXML
    void initialize() {
        assert password != null : "fx:id=\"password\" was not injected: check your FXML file 'loging.fxml'.";
        assert username != null : "fx:id=\"username\" was not injected: check your FXML file 'loging.fxml'.";

    }

}
