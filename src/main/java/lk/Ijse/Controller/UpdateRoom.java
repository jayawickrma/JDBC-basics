package lk.Ijse.Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import lk.Ijse.DTO.RoomDto;
import lk.Ijse.Model.RoomModel;

public class UpdateRoom {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField id;

    @FXML
    private TextField price;

    @FXML
    private TextField type;

    @FXML
    void adddOnAction(ActionEvent event) {
        int  idt =Integer.valueOf(id.getText());
        String typet=type.getText();
        String pricet=price.getText();

        RoomDto roomDto=new RoomDto(idt,typet,pricet);
       boolean b= RoomModel.updateRoom(roomDto);
        System.out.println(b);
        if (b){
           new Alert(Alert.AlertType.CONFIRMATION,"Room Updated Successfully").show();
        }
        Parent parent=null;
        try {
            parent= FXMLLoader.load(getClass().getResource("/View/room.fxml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }



    @FXML
    void cancelOnActin(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert id != null : "fx:id=\"id\" was not injected: check your FXML file 'updateRoom.fxml'.";
        assert price != null : "fx:id=\"price\" was not injected: check your FXML file 'updateRoom.fxml'.";
        assert type != null : "fx:id=\"type\" was not injected: check your FXML file 'updateRoom.fxml'.";

    }

}
