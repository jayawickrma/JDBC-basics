package lk.Ijse.Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import lk.Ijse.DTO.UserDto;
import lk.Ijse.Model.UserModel;

public class RegistrtionPage {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField idtxt;

    @FXML
    private TextField nametxt;

    @FXML
    private TextField pwtxt;

    @FXML
    void SaveOnAction(ActionEvent event) throws IOException {
        int id=Integer.parseInt(idtxt.getText());
        String name=nametxt.getText();
        String pw=pwtxt.getText();
        UserDto userDto=new UserDto(id,name,pw);
        boolean b = UserModel.saveUser(userDto);
        if (b){
            new Alert(Alert.AlertType.CONFIRMATION,"Saved successfully").show();
        }else{
            new Alert(Alert.AlertType.ERROR).show();
        }
        Parent parent = FXMLLoader.load(getClass().getResource("/View/loging.fxml"));
        Scene scene=new Scene(parent);
        Stage stage=new Stage();
        stage.setScene(scene);
        stage.setTitle("New User Register Page");
        stage.show();
        Stage stage1=(Stage)idtxt.getScene().getWindow();
        stage1.close();
    }

    @FXML
    void initialize() {
        assert idtxt != null : "fx:id=\"idtxt\" was not injected: check your FXML file 'Registrtion Page.fxml'.";
        assert nametxt != null : "fx:id=\"nametxt\" was not injected: check your FXML file 'Registrtion Page.fxml'.";
        assert pwtxt != null : "fx:id=\"pwtxt\" was not injected: check your FXML file 'Registrtion Page.fxml'.";

    }

}
