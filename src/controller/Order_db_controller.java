package controller;

import com.sun.org.apache.xpath.internal.operations.Or;
import cooking.Chef;
import databases.Order_db;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import order.Order;

import java.io.IOException;
import java.util.Objects;

public class Order_db_controller {

    @FXML
    private TableView<Order> table;

    @FXML
    private TableColumn<Order, String> name_column;

    @FXML
    private TableColumn<Order, String> price_column;

    @FXML
    private TableColumn<Order, Integer> time_column;

    @FXML
    private TableColumn<Order, Chef> chef_column;

    @FXML
    private TableColumn<Order, Boolean> delivery_column;

    @FXML
    private TableColumn<Order, Boolean> isdone_column;

    @FXML
    private Button generate_btn;

    @FXML
    private Button complete_btn;

    @FXML
    private Button clear_btn;

    @FXML
    private Button back_btn;

    Order_db order_db = Order_db.getInstance();


    public void initialize(){
        // setting up columns
        name_column.setCellValueFactory(new PropertyValueFactory<>("order_name"));
        price_column.setCellValueFactory(new PropertyValueFactory<>("price"));
        time_column.setCellValueFactory(new PropertyValueFactory<>("time"));
        chef_column.setCellValueFactory(new PropertyValueFactory<>("chef_name"));
        delivery_column.setCellValueFactory(new PropertyValueFactory<>("delivery"));
        isdone_column.setCellValueFactory(new PropertyValueFactory<>("is_done"));

        table.setItems(order_db.getOrders());
    }


    @FXML
    void generate_orders(ActionEvent event) {
        // generate orders
        order_db.generate_orders();
    }


    @FXML
    void complete_orders(ActionEvent event) throws Exception {
        for (Order order: order_db.getOrders()){
            if (!order.isIs_done()) {
                order.do_order(true, true);
            }
        }

        table.refresh();

    }

    @FXML
    void clear_orders(ActionEvent event) {
        order_db.getOrders().clear();

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
