package controller;

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
import java.util.Observable;
import java.util.ResourceBundle;

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

        // handling size
        int size;
        if (size_32.isSelected()){size = 32;}
        else if (size_40.isSelected()){size = 40;}
        else {text_summary.appendText("Please select size!\n"); return;}

        // handling base
        Base base;
        if (base_tomato.isSelected()){base = new Tomato(size);}
        else if (base_cream.isSelected()){base = new Cream(size);}
        else if (base_habanero.isSelected()) {base = new Habanero(size);}
        else {text_summary.appendText("Please select base!\n"); return;}

        // handling crust
        Crust crust;
        if (crust_normal.isSelected()){crust = new Crust(size);}
        else if (crust_cheese.isSelected()){crust = new Cheese(size);}
        else if (crust_garlic.isSelected()){crust = new Garlic(size);}
        else {text_summary.appendText("Please select crust!\n"); return;}

        // handling toppings
        ArrayList<Topping> toppings = new ArrayList<>(size);
        if (topping_bacon.isSelected()){toppings.add(new Bacon(size));}
        if (topping_corn.isSelected()){toppings.add(new Corn(size));}
        if (topping_jalapenos.isSelected()){toppings.add(new Jalapenos(size));}
        if (topping_mozzarela.isSelected()){toppings.add(new Mozzarela(size));}
        if (topping_mushroom.isSelected()){toppings.add(new Mushroom(size));}
        if (topping_olives.isSelected()){toppings.add(new Olives(size));}
        if (topping_onions.isSelected()){toppings.add(new Onion(size));}
        if (topping_pepperoni.isSelected()){toppings.add(new Pepperoni(size));}
        if (topping_sausage.isSelected()){toppings.add(new Sausage(size));}
        if (topping_ham.isSelected()){toppings.add(new Ham(size));}
        // setting price of toppings based of size
        for (Topping topping: toppings){
            topping.set_price();
        }

        // constructing pizza and adding it into the order
        base.set_price();
        crust.set_price();
        Pizza pizza = new Pizza(size, base, crust, toppings);
        pizzas.add(pizza);

        text_summary.appendText(pizza.info());
        reset_buttons();                                    // resetting buttons
    }

    // finalizing order by constructing Order object based on constructed pizza
    @FXML
    void finish_order(ActionEvent event) {

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
        order = new Order(name, pizzas, delivery);
        order.do_order();
        text_summary.appendText(final_time(order));
        text_summary.appendText(final_price(order));
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
}
