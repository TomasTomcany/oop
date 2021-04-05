package gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;
import toppings.*;
import crusts.*;
import bases.*;
import order.*;

import java.util.ArrayList;

public class Order_controller {

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


    public final ArrayList<Pizza> pizzas = new ArrayList<>();
    public Order order;


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
    @FXML
    void finish_order(ActionEvent event) {
        order = new Order("Pizzaaaa", pizzas, true);
        order.do_order();
        text_summary.appendText(order.final_time());
        text_summary.appendText(order.final_price());

//        Node source = (Node) event.getSource();
//        Stage stage = (Stage) source.getScene().getWindow();
//        stage.close();
    }



}
