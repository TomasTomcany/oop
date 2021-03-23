package Main;


import Toppings.*;
import crusts.*;
import bases.*;
import pizza.*;

import java.util.*;



public class Order {


    public static void main(String[] args){
        // list of pizza objects for the order
        ArrayList<Pizza> pizzas= new ArrayList<>();
        // for reading input
        String choice;
        Scanner input = new Scanner (System.in);

        // new pizza order
        while(true) {
            System.out.print("Add pizza to order, type YES or NO: ");

            choice = input.nextLine();
            if (choice.equalsIgnoreCase("NO")) {
                break;
            }

            int size = 32;       // size of pizza, needed for construction of objects
            // setting size, price based on size will be set with every ingredient added
            System.out.println("Choose pizza size!");
            System.out.print("Pick NORMAL(32cm) or BIG(40cm) (enter NORMAL or BIG only): ");
            choice = input.nextLine();
            switch (choice.toUpperCase(Locale.ROOT)) {
                case "NORMAL":  size = 32; break;
                case "BIG":     size = 40; break;
                default:        System.out.println("Wrong input, setting size to Normal."); break;
            }

            //constructing pizza object
            Pizza pizza = new Pizza(size);

            // base
            System.out.println("Let's pick the base!");
            System.out.println("Tomato(4€), Cream(4.25€), Habanero(4.5€).");
            System.out.print("Enter TOMATO, CREAM or HABANERO: ");
            choice = input.nextLine();

            switch (choice.toUpperCase(Locale.ROOT)) {
                case "CREAM":       pizza.base = new Cream(size); break;
                case "HABANERO":    pizza.base = new Habanero(size); break;
                default:            pizza.base = new Tomato(size); break;
            }
            pizza.base.set_price();                       // setting the final price based on size
            pizza.add_price(pizza.base.get_price());      // adding to pizza price based on the type of base

            // crust
            System.out.println("Crust: Normal, Garlic(0.6€), Cheese(1€)");
            System.out.println("Pick NORMAL, GARLIC or CHEESE");
            choice = input.nextLine();
            switch (choice.toUpperCase(Locale.ROOT)) {
                case "GARLIC": pizza.crust = new Cheese(size); break;
                case "CHEESE": pizza.crust = new Garlic(size); break;
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
                    case "BACON":       pizza.toppings.add(new Bacon(size)); break;
                    case "CORN":        pizza.toppings.add(new Corn(size)); break;
                    case "JALAPENOS":   pizza.toppings.add(new Jalapenos(size)); break;
                    case "MOZZARELA":   pizza.toppings.add(new Mozzarela(size)); break;
                    case "MUSHROOM":    pizza.toppings.add(new Mushroom(size)); break;
                    case "OLIVES":      pizza.toppings.add(new Olives(size)); break;
                    case "ONION":       pizza.toppings.add(new Onion(size)); break;
                    case "PEPPERONI":   pizza.toppings.add(new Pepperoni(size)); break;
                    case "SAUSAGE":     pizza.toppings.add(new Sausage(size)); break;
                    case "HAM":         pizza.toppings.add(new Ham(size)); break;
                    default:            System.out.println("Invalid input");brake = true; break;
                }
                choice = input.nextLine();
                if (brake){continue;}
                pizza.toppings.get(i).set_price();
                pizza.add_price(pizza.toppings.get(i).get_price());
                i++;
            }
            pizzas.add(pizza);
        }

        double sum = 0;
        int i = 1;
        for (Pizza item: pizzas){
            System.out.println("Pizza "+ i);
            item.print_pizza();
            sum += item.get_price();
            i++;
            System.out.println();
        }
        System.out.println();
        System.out.println("Price order: " + sum);
    }
}
