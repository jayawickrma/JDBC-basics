package lk.Ijse.Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import lk.Ijse.DTO.RoomDto;
import lk.Ijse.DTO.TM.RoomTable;
import lk.Ijse.Model.RoomModel;

import javax.imageio.IIOException;


public class Room {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField IDTXT;

    @FXML
    private TextField PRICETXT;

    @FXML
    private TextField TYPETXT;
    @FXML
    private TableColumn<RoomTable, JFXButton> rDelete;

    @FXML
    private TableColumn<RoomTable, JFXButton> rUpdate;

    @FXML
    private TableColumn<RoomTable, String> rid;

    @FXML
    private TableColumn<RoomTable, String> rprice;

    @FXML
    private TableView<RoomTable> rtable;

    @FXML
    private TableColumn<RoomTable, String> rtype;

    @FXML
    void btnSaveOnAction(ActionEvent event) {

        int idtxt=Integer.parseInt(IDTXT.getText());
        String typetxt=TYPETXT.getText();
        String pricetxt=PRICETXT.getText();

        RoomDto roomDto=new RoomDto(idtxt,typetxt,pricetxt);
        boolean b = RoomModel.saveRoom(roomDto);
        System.out.println(b);
        if (b){
            new Alert(Alert.AlertType.CONFIRMATION,"Room Aded Successfully").show();
        }else {
            new Alert(Alert.AlertType.ERROR,"something went wrong ").show();
        }

LoadValues();

    }
    public void LoadValues() {
        ArrayList<RoomDto> allRooms = RoomModel.getAllRoom();
        System.out.println(allRooms.size());
        ObservableList<RoomTable> observableList = FXCollections.observableArrayList();
        for (int i = 0; i < allRooms.size(); i++) {
            String RID = String.valueOf(allRooms.get(i).getRoomId());
            RoomTable roomTable = new RoomTable(RID, allRooms.get(i).getRoomType(), allRooms.get(i).getRoomPrice(), new JFXButton("Update"), new JFXButton("Delete"));
            observableList.add(roomTable);

        }
        rtable.setItems(observableList);
        for (int i = 0; i < observableList.size(); i++) {
            observableList.get(i).getUpdateRoom().setStyle("-fx-background-color: rgba(96,120,205,0.97)");
            observableList.get(i).getDeleteRoom().setStyle("-fx-background-color: rgba(175,108,108,1)");
            observableList.get(i).getUpdateRoom().setTextFill(Color.WHITE);
            observableList.get(i).getDeleteRoom().setTextFill(Color.WHITE);
        }
        for (int i = 0; i < observableList.size(); i++) {
            String id = observableList.get(i).getRoomId();
            String type = observableList.get(i).getRoomType();
            String price = observableList.get(i).getRoomPrice();
            observableList.get(i).getUpdateRoom().setOnAction(actionEvent -> {
                UpdateRoom.ID=Integer.parseInt(id);
                UpdateRoom.Type=type;
                UpdateRoom.Price=price;
                Parent parent = null;
                try {
                    parent = FXMLLoader.load(getClass().getResource("/View/updateRoom.fxml"));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                } Scene scene = new Scene(parent);
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.setResizable(false);
                stage.show();
                LoadValues();
            });
        }
    }
        public void setvalues() {
            rid.setCellValueFactory(new PropertyValueFactory<>("roomId"));
            rtype.setCellValueFactory(new PropertyValueFactory<>("roomType"));
            rprice.setCellValueFactory(new PropertyValueFactory<>("roomPrice"));
            rUpdate.setCellValueFactory(new PropertyValueFactory<RoomTable,JFXButton>("updateRoom"));
            rDelete.setCellValueFactory(new PropertyValueFactory<RoomTable,JFXButton>("deleteRoom"));
            LoadValues();
        }



    @FXML
    void initialize() {
        assert IDTXT != null : "fx:id=\"IDTXT\" was not injected: check your FXML file 'room.fxml'.";
        assert PRICETXT != null : "fx:id=\"PRICETXT\" was not injected: check your FXML file 'room.fxml'.";
        assert TYPETXT != null : "fx:id=\"TYPETXT\" was not injected: check your FXML file 'room.fxml'.";
        assert rid != null : "fx:id=\"rid\" was not injected: check your FXML file 'room.fxml'.";
        assert rprice != null : "fx:id=\"rprice\" was not injected: check your FXML file 'room.fxml'.";
        assert rtable != null : "fx:id=\"rtable\" was not injected: check your FXML file 'room.fxml'.";
        assert rtype != null : "fx:id=\"rtype\" was not injected: check your FXML file 'room.fxml'.";
LoadValues();
setvalues();
    }

}
