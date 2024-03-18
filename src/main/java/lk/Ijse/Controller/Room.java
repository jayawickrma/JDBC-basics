package lk.Ijse.Controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import lk.Ijse.DTO.RoomDto;
import lk.Ijse.DTO.TM.RoomTable;
import lk.Ijse.Model.RoomModel;

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
setvalues();
    }
    public void LoadValues(){
        ArrayList<RoomDto>allRooms=RoomModel.getAllRoom();
        System.out.println(allRooms.size());
        ObservableList<RoomTable>observableList= FXCollections.observableArrayList();
        for (int i=0 ;i<allRooms.size();i++){
            String RID=String.valueOf(allRooms.get(i).getRoomId());
            RoomTable roomTable=new RoomTable(RID,allRooms.get(i).getRoomType(),allRooms.get(i).getRoomPrice());
            observableList.add(roomTable);
           rtable.setItems(observableList);
        }
    }
    public void setvalues(){
     rid.setCellValueFactory(new PropertyValueFactory<>("roomId"));
     rtype.setCellValueFactory(new PropertyValueFactory<>("roomType"));
     rprice.setCellValueFactory(new PropertyValueFactory<>("roomPrice"));
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
