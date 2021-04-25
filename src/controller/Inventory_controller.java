package controller;

import databases.Inventory;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import view.Inventory_view;

import java.io.IOException;
import java.util.Objects;

public class Inventory_controller {
    Inventory_view inventoryview;

    Inventory inventory = Inventory.getInstance();

    public Inventory_controller(Inventory_view inventoryview){
        this.inventoryview = inventoryview;

        // initialize
        inventoryview.inventory_summary.appendText(inventory.get_Inventory_info());
        inventoryview.warning_info_text.appendText(inventory.check_low_Inventory());

        // event handling
        inventoryview.order_btn.setOnAction(event -> {
            try {
                order_inventory();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        inventoryview.back_btn.setOnAction(event -> {
            try {
                switch_scene_back(event);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    void order_inventory() throws Exception {
        // adds amount defined in quantity_field to specific item defined from order_name textfield
        String item_name = inventoryview.order_name_field.getText();
        if (item_name.isEmpty()){
            throw new Exception("No item name has been entered!");
        }

        int quantity = 0;
        try {
            quantity = Integer.parseInt(inventoryview.quantity_field.getText());
        }
        catch (NumberFormatException ex){
            ex.printStackTrace();
        }

        // adds the amount to item in inventory
        inventory.add_amount(item_name, quantity);
        inventoryview.warning_info_text.appendText(quantity + " " + item_name + " has been added to inventory!\n");

        // updating text area with inventory summary
        inventoryview.inventory_summary.setText("");
        inventoryview.inventory_summary.appendText(inventory.get_Inventory_info());

        // clearing text fields
        inventoryview.order_name_field.setText("");
        inventoryview.quantity_field.setText("");

        // saving inventory database
        Inventory.saveInventory();
    }

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
