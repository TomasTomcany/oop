package controller;

import databases.Inventory;
import databases.Order_db;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import toppings.*;
import crusts.*;
import bases.*;
import order.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

// using Order class as model
public class Order_controller {

    @FXML
    private TextField name_field;

    @FXML
    private RadioButton size_32;

    @FXML
    private ToggleGroup group_size;

    @FXML
    private RadioButton size_40;

    @FXML
    private RadioButton crust_normal;

    @FXML
    private ToggleGroup group_crust;

    @FXML
    private RadioButton crust_cheese;

    @FXML
    private RadioButton crust_garlic;

    @FXML
    private RadioButton base_tomato;

    @FXML
    private ToggleGroup group_base;

    @FXML
    private RadioButton base_cream;

    @FXML
    private RadioButton base_habanero;

    @FXML
    private RadioButton topping_bacon;

    @FXML
    private RadioButton topping_corn;

    @FXML
    private RadioButton topping_ham;

    @FXML
    private RadioButton topping_jalapenos;

    @FXML
    private RadioButton topping_mozzarela;

    @FXML
    private RadioButton topping_mushroom;

    @FXML
    private RadioButton topping_olives;

    @FXML
    private RadioButton topping_onions;

    @FXML
    private RadioButton topping_pepperoni;

    @FXML
    private RadioButton topping_sausage;

 @FXML
    private TextArea text_summary;

    @FXML
    private Button add_pizza;

    @FXML
    private Button finish_order;

    @FXML
    private Button newOrder_btn;

    @FXML
    private Button back_btn;

    @FXML
    private ChoiceBox<String> delivery_cb;
    private final String[] delivery_choice = {"Yes", "No"};
    private final ObservableList<String> delivery_list = FXCollections.observableArrayList(delivery_choice);


    public Order order;                                         // model
    public final ArrayList<Pizza> pizzas = new ArrayList<>();   // ArrayList of pizzas is aggregated to order



    // getters of buttons for PizzaFactory.create_pizza
    public RadioButton getSize_32() {
        return size_32;
    }

    public RadioButton getSize_40() {
        return size_40;
    }

    public RadioButton getCrust_normal() {
        return crust_normal;
    }

    public RadioButton getCrust_cheese() {
        return crust_cheese;
    }

    public RadioButton getCrust_garlic() {
        return crust_garlic;
    }

    public RadioButton getBase_tomato() {
        return base_tomato;
    }

    public RadioButton getBase_cream() {
        return base_cream;
    }

    public RadioButton getBase_habanero() {
        return base_habanero;
    }

    public RadioButton getTopping_bacon() {
        return topping_bacon;
    }

    public RadioButton getTopping_corn() {
        return topping_corn;
    }

    public RadioButton getTopping_ham() {
        return topping_ham;
    }

    public RadioButton getTopping_jalapenos() {
        return topping_jalapenos;
    }

    public RadioButton getTopping_mozzarela() {
        return topping_mozzarela;
    }

    public RadioButton getTopping_mushroom() {
        return topping_mushroom;
    }

    public RadioButton getTopping_olives() {
        return topping_olives;
    }

    public RadioButton getTopping_onions() {
        return topping_onions;
    }

    public RadioButton getTopping_pepperoni() {
        return topping_pepperoni;
    }

    public RadioButton getTopping_sausage() {
        return topping_sausage;
    }

    public TextArea getText_summary() {
        return text_summary;
    }




    public void initialize(){
        delivery_cb.setItems(delivery_list);
        delivery_cb.setValue("Yes");
    }

    // Resets all radio buttons after clicking add pizza button
    void reset_buttons(){
        size_32.setSelected(false);
        size_40.setSelected(false);
        base_tomato.setSelected(false);
        base_cream.setSelected(false);
        base_habanero.setSelected(false);
        crust_garlic.setSelected(false);
        crust_cheese.setSelected(false);
        crust_normal.setSelected(false);
        topping_bacon.setSelected(false);
        topping_corn.setSelected(false);
        topping_ham.setSelected(false);
        topping_jalapenos.setSelected(false);
        topping_mushroom.setSelected(false);
        topping_olives.setSelected(false);
        topping_onions.setSelected(false);
        topping_pepperoni.setSelected(false);
        topping_mozzarela.setSelected(false);
        topping_sausage.setSelected(false);
    }

    // Creating pizza object to append to Arraylist based on what the user has picked
    @FXML
    void order_action(ActionEvent event) {

        // creating pizza object through factory
        Pizza pizza = (new PizzaFactory()).create_pizza(this);

        // if pizza object wa not created end method
        if (pizza == null){
            return;
        }
        pizzas.add(pizza);

        text_summary.appendText(pizza_info(pizza));
        reset_buttons();                                    // resetting buttons
    }

    // finalizing order by constructing Order object based on constructed pizza
    @FXML
    void finish_order(ActionEvent event) throws Exception {

        // getting name of customer
        String name = name_field.getText();
        if (name.isEmpty()){
            text_summary.appendText("Please enter your name!\n");
            return;
        }

        // getting whether user wants food to be delivered
        boolean delivery = delivery_cb.getValue().equals("Yes");

        // checking if any pizza was selected
        if (pizzas.isEmpty()){
            text_summary.appendText("No pizzas were selected!\n");
            return;
        }

        // constructing Order object and start doing the order and calculating time it will take
        if (order != null){
            text_summary.appendText("Order has already been created!\n");
            return;
        }

        // randomly pick traffic situation
        Random rand = new Random();
        int traffic_choice = rand.nextInt(3);
        String[] traffics = {"Jam", "Free", "Normal"};

        order = new Order(name, pizzas, delivery, traffics[traffic_choice]);
        order.do_order(false, false);
        text_summary.appendText(final_time(order));
        text_summary.appendText(final_price(order));

        // saving Inventory database
        Inventory.saveInventory();
    }

    @FXML
    void clear_all(ActionEvent event) {
        reset_buttons();
        delivery_cb.setValue("Yes");
        name_field.setText("");
        text_summary.setText("");

        // resetting order
        pizzas.clear();
        order = null;
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

    // creating string for printing price of the order in text area
    public String final_price(Order order){

        return "Final price of the order: " + order.get_price() + "€\n";
    }

    // creating string for printing time it will take to prepare and maybe deliver order
    public String final_time(Order order){
        if (order.isDelivery()){
            return "Your order will arrive in " + order.getTime() + " minutes.\n";
        }
        return "Your order will be ready in " + order.getTime() + " minutes.\n";

    }

    // prints all info of pizza into text area in GUI
    public String pizza_info(Pizza pizza){
        StringBuilder info;
        info = new StringBuilder("Size: " + pizza.get_size() + "cm\n" +
                "Base: " + pizza.getBase().get_name() + " " + pizza.getBase().get_price() + "€\n" +
                "Crust: " + pizza.getCrust().get_name() + " " + pizza.getCrust().get_price() + "€\n");
        for (Topping item: pizza.getToppings()){
            info.append("Topping: ").append(item.get_name()).append(" ").append(item.get_price()).append("€\n");
        }
        info.append("Price of pizza: ").append(pizza.get_price()).append("€\n\n");
        return info.toString();
    }
}
