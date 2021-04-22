package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class Login_controller {

    @FXML
    private ChoiceBox<String> login_cb;
    private final String[] scenes = {"Customer", "Inventory", "ManageOrdersTODO"};
    private final ObservableList<String> scenes_list = FXCollections.observableArrayList(scenes);

    @FXML
    private Button login_btn;


    public void initialize(){
        login_cb.setItems(scenes_list);
        login_cb.setValue("Customer");
    }

    @FXML
    void switch_scene(ActionEvent event) throws IOException {
        // picking scene based of choicebox
        Parent node;
        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();

        if (login_cb.getValue().equals("Customer")){
            node = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("../view/Order_view.fxml")));
        }
        else if (login_cb.getValue().equals("Inventory")){
            node = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("../view/Inventory_view.fxml")));
        }
        else {
            return;
        }


        stage.setScene(new Scene(node));

    }

}
