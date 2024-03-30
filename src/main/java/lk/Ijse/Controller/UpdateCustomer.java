package lk.Ijse.Controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class UpdateCustomer {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField addresss;

    @FXML
    private TextField id;

    @FXML
    private TextField mobile;

    @FXML
    private TextField name;

    public static int Id;
    public static String Name;
    public static String Address;
    public static String Mobile;

    @FXML
    void btnAddOnActon(ActionEvent event) {

    }

    @FXML
    void btnCancelOnAction(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert addresss != null : "fx:id=\"addresss\" was not injected: check your FXML file 'updateCustomer.fxml'.";
        assert id != null : "fx:id=\"id\" was not injected: check your FXML file 'updateCustomer.fxml'.";
        assert mobile != null : "fx:id=\"mobile\" was not injected: check your FXML file 'updateCustomer.fxml'.";
        assert name != null : "fx:id=\"name\" was not injected: check your FXML file 'updateCustomer.fxml'.";

    }

}
