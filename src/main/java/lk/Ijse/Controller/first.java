package lk.Ijse.Controller;

import java.net.URL;
import java.sql.SQLException;
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
import lk.Ijse.DTO.CustomerDto;
import lk.Ijse.DTO.TM.CustomerTable;
import lk.Ijse.Model.CustomerModel;

import static lk.Ijse.Model.CustomerModel.saveCustomer;

public class first {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableColumn<CustomerTable,String> Id;

    @FXML
    private TextField MobileTxt;

    @FXML
    private TableColumn<CustomerTable, String> Name;

    @FXML
    private TableView<CustomerTable> Table;

    @FXML
    private TextField addressTXt;

    @FXML
    private TableColumn<CustomerTable, String> adress;

    @FXML
    private TextField idTxt;

    @FXML
    private TextField nameTXT;

    @FXML
    private TableColumn<CustomerTable, String> tel;

    @FXML
    void btnSaveInACtion(ActionEvent event) {
        int idTXT =Integer.parseInt(idTxt.getText());
        String nameTXt=nameTXT.getText();
        String addressTXT=addressTXt.getText();
        String mobileTXT=MobileTxt.getText();

        CustomerDto customerDto =new CustomerDto(idTXT,nameTXt,addressTXT,mobileTXT);
        boolean b =CustomerModel.saveCustomer(customerDto);
        System.out.println(b);
        if (b){
            new Alert(Alert.AlertType.CONFIRMATION,"Customer saved").show();
        }

        }

    public void loadValues()  {
        ArrayList<CustomerDto>allCustomer=CustomerModel.getAllCustomers();
        System.out.println(allCustomer.size());
        ObservableList<CustomerTable>observableList= FXCollections.observableArrayList();
        for (int i=0 ;i<allCustomer.size();i++){
            String CID =String.valueOf(allCustomer.get(i).getCID());
            CustomerTable customerTable=new CustomerTable(CID,allCustomer.get(i).getCNAme(),allCustomer.get(i).getCAddress(),allCustomer.get(i).getCMobile());
            observableList.add(customerTable);
            Table.setItems(observableList);
        }
    }
    public void setValues(){
        Id.setCellValueFactory(new PropertyValueFactory<>("CID"));
        Name.setCellValueFactory(new PropertyValueFactory<>("CName"));
        adress.setCellValueFactory(new PropertyValueFactory<>("CAddress"));
        tel.setCellValueFactory(new PropertyValueFactory<>("CMobile"));
        loadValues();
    }

    @FXML
    void initialize() {
        assert Id != null : "fx:id=\"Id\" was not injected: check your FXML file '1.fxml'.";
        assert MobileTxt != null : "fx:id=\"MobileTxt\" was not injected: check your FXML file '1.fxml'.";
        assert Name != null : "fx:id=\"Name\" was not injected: check your FXML file '1.fxml'.";
        assert Table != null : "fx:id=\"Table\" was not injected: check your FXML file '1.fxml'.";
        assert addressTXt != null : "fx:id=\"addressTXt\" was not injected: check your FXML file '1.fxml'.";
        assert adress != null : "fx:id=\"adress\" was not injected: check your FXML file '1.fxml'.";
        assert idTxt != null : "fx:id=\"idTxt\" was not injected: check your FXML file '1.fxml'.";
        assert nameTXT != null : "fx:id=\"nameTXT\" was not injected: check your FXML file '1.fxml'.";
        assert tel != null : "fx:id=\"tel\" was not injected: check your FXML file '1.fxml'.";

        setValues();
        loadValues();

    }

}
