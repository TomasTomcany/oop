package controller;

import databases.Inventory;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class Inventory_controller {

    @FXML
    private TextArea inventory_summary;

    @FXML
    private TextArea warning_info_text;

    @FXML
    private TextField order_name_field;

    @FXML
    private TextField quantity_field;

    @FXML
    private Button order_btn;

    @FXML
    private Button back_btn;

    Inventory inventory = Inventory.getInstance();


    public void initialize(){
        inventory_summary.appendText(inventory.get_Inventory_info());
        warning_info_text.appendText(inventory.check_low_Inventory());
    }


    @FXML
    void order_inventory(ActionEvent event) throws Exception {
        // adds amount defined in quantity_field to specific item defined from order_name textfield
        String item_name = order_name_field.getText();
        if (item_name.isEmpty()){
            throw new Exception("No item name has been entered!");
        }

        int quantity = 0;
        try {
            quantity = Integer.parseInt(quantity_field.getText());
        }
        catch (NumberFormatException ex){
            ex.printStackTrace();
        }

        // adds the amount to item in inventory
        inventory.add_amount(item_name, quantity);
        warning_info_text.appendText(quantity + " " + item_name + " has been added to inventory!\n");

        // updating text area with inventory summary
        inventory_summary.setText("");
        inventory_summary.appendText(inventory.get_Inventory_info());

        // clearing text fields
        order_name_field.setText("");
        quantity_field.setText("");

        // saving inventory database
        Inventory.saveInventory();
    }

    @FXML
    void switch_scene_back(ActionEvent event) throws IOException {

        Parent node;
        // getting stage
        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();

        // loading login view
        node = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("../view/Login_view.fxml")));

        stage.setScene(new Scene(node));
    }
}
