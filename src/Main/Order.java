package Main;

import Toppings.*;
import crusts.*;
import bases.*;
import pizza.*;

import java.util.*;


public class Order {
    // list of pizza objects for the order
    ArrayList<Pizza> pizzas= new ArrayList<Pizza>();

    public static void main(String [] args){

        // for reading input
        String choice = "YES";
        String add_pizza = "YES";
        Scanner input = new Scanner (System.in);

        // new pizza order
        while(true) {
            System.out.print("Add pizza to order, type YES or NO: ");

            choice = input.nextLine();
            if (choice.equalsIgnoreCase("NO")) {
                break;
            }

            Pizza pizza = new Pizza();

            // setting size, price based on size will be set with every ingredient added
            System.out.println("Choose pizza size!");
            System.out.print("Pick NORMAL(32cm) or BIG(40cm) (enter NORMAL or BIG only): ");
            choice = input.nextLine();
            switch (choice.toUpperCase(Locale.ROOT)) {
                case "NORMAL":  pizza.set_size(32); break;
                case "BIG":     pizza.set_size(40); break;
                default:        System.out.println("Wrong input, setting size to Normal."); break;
            }

            // base
            System.out.println("Let's pick the base!");
            System.out.println("Tomato(4€), Cream(4.25€), Habanero(4.5€).");
            System.out.print("Enter TOMATO, CREAM or HABANERO: ");
            choice = input.nextLine();

            switch (choice.toUpperCase(Locale.ROOT)) {
                case "TOMATO":      pizza.base = new Tomato(); break;
                case "CREAM":       pizza.base = new Cream(); break;
                case "HABANERO":    pizza.base = new Habanero(); break;
                default:            pizza.base = new Tomato(); break;
            }
            pizza.base.set_price();                       // setting the final price based on size
            pizza.add_price(pizza.base.get_price());      // adding to pizza price based on the type of base

            // crust
            System.out.println("Crust: Normal, Garlic(0.6€), Cheese(1€)");
            System.out.println("Pick NORMAL, GARLIC or CHEESE");
            choice = input.nextLine();
            switch (choice.toUpperCase(Locale.ROOT)) {
                case "NORMAL": break;
                case "GARLIC": pizza.crust = new Cheese(); break;
                case "CHEESE": pizza.crust = new Garlic(); break;
                default: break;
            }
            pizza.crust.set_price();                     // setting the final price based on size
            pizza.add_price(pizza.crust.get_price());    // adding to pizza price based on the type of base

            // toppings
            System.out.println("Toppings:");
            System.out.println("Bacon, Corn, Ham, Jalapenos, Mozzarela, Mushroom, Olives, Onion, Pepperoni," +
                               "Sausage or Stop:");
            choice = input.nextLine();
            int i = 0;
            boolean brake = false;
            while(!choice.equalsIgnoreCase("STOP")){

                switch (choice.toUpperCase(Locale.ROOT)) {
                    case "BACON":       pizza.toppings.add(new Bacon()); break;
                    case "CORN":        pizza.toppings.add(new Corn()); break;
                    case "JALAPENOS":   pizza.toppings.add(new Jalapenos()); break;
                    case "MOZZARELA":   pizza.toppings.add(new Mozzarela()); break;
                    case "MUSHROOM":    pizza.toppings.add(new Mushroom()); break;
                    case "OLIVES":      pizza.toppings.add(new Olives()); break;
                    case "ONION":       pizza.toppings.add(new Onion()); break;
                    case "PEPPERONI":   pizza.toppings.add(new Pepperoni()); break;
                    case "SAUSAGE":     pizza.toppings.add(new Sausage()); break;
                    case "HAM":         pizza.toppings.add(new Ham()); break;
                    default:            System.out.println("Invalid input");brake = true; break;
                }
                choice = input.nextLine();
                if (brake){continue;};
                pizza.toppings.get(i).set_price();
                pizza.add_price(pizza.toppings.get(i).get_price());
                i++;
            }


            System.out.println("Velkost: " + pizza.get_size());
            System.out.println("Zaklad: " + pizza.base.get_name() +" " + pizza.base.get_price());
            System.out.println("Okraj: " + pizza.crust.get_name() +" " + pizza.crust.get_price());
            for (Topping item: pizza.toppings){
                String string = item.get_name();
                System.out.println("Topping: " + item.get_name() +" " + item.get_price());
            }
            System.out.println("Celkova cena: " + pizza.get_price());

        }
    }
}
