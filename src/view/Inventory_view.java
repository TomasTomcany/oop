package view;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class Inventory_view {

    public AnchorPane pane;
    public HBox hbox_text1;
    public TextArea inventory_summary;
    public HBox hbox_text2;
    public TextArea warning_info_text;

    public TextField order_name_field;
    public TextField quantity_field;

    public Button order_btn;
    public Button back_btn;


    public Scene scene;

    public Inventory_view() {
        pane = new AnchorPane();
        pane.setPrefHeight(400);
        pane.setPrefWidth(600);
        pane.setStyle("-fx-background-color: #e6e6e6; -fx-border-color: #000000; -fx-border-width: 5;");


        hbox_text1 = new HBox();
        hbox_text1.setLayoutX(27);
        hbox_text1.setLayoutY(22);
        hbox_text1.setPrefHeight(356);
        hbox_text1.setPrefWidth(294);
        pane.getChildren().add(hbox_text1);

        inventory_summary = new TextArea();
        inventory_summary.setPrefHeight(356);
        inventory_summary.setPrefWidth(294);
        inventory_summary.setStyle("-fx-border-color: #000000; -fx-border-width: 2;");
        hbox_text1.getChildren().add(inventory_summary);

        hbox_text2 = new HBox();
        hbox_text2.setLayoutX(333);
        hbox_text2.setLayoutY(22);
        hbox_text2.setPrefHeight(136);
        hbox_text2.setPrefWidth(254);
        pane.getChildren().add(hbox_text2);

        warning_info_text = new TextArea();
        warning_info_text.setPrefHeight(136);
        warning_info_text.setPrefWidth(254);
        warning_info_text.setStyle("-fx-border-color: #000000; -fx-border-width: 2;");
        hbox_text2.getChildren().add(warning_info_text);

        VBox vbox1 = new VBox();
        vbox1.setLayoutX(342);
        vbox1.setLayoutY(173);
        vbox1.setPrefHeight(202);
        vbox1.setPrefWidth(235);
        vbox1.setSpacing(30);
        vbox1.setPadding(new Insets(10,15,0,15));
        vbox1.setStyle("-fx-background-color: #f49600; -fx-border-color: #000000; -fx-border-width: 2;");
        pane.getChildren().add(vbox1);


        VBox vbox2 = new VBox();
        vbox2.setPrefHeight(87);
        vbox2.setPrefWidth(145);
        vbox1.getChildren().add(vbox2);

        Label name = new Label();
        name.setText("Name of item");
        vbox2.getChildren().add(name);

        order_name_field = new TextField();
        vbox2.getChildren().add(order_name_field);

        Label quantity = new Label();
        quantity.setText("Quantity");
        vbox2.getChildren().add(quantity);

        quantity_field = new TextField();
        vbox2.getChildren().add(quantity_field);


        HBox hbox = new HBox();
        hbox.setPrefHeight(43);
        hbox.setPrefWidth(188);
        hbox.setSpacing(20);
        hbox.setPadding(new Insets(0,0,0,5));
        vbox1.getChildren().add(hbox);

        order_btn = new Button();
        order_btn.setText("Order");
        order_btn.setPrefHeight(41);
        order_btn.setPrefWidth(85);
        hbox.getChildren().add(order_btn);

        back_btn = new Button();
        back_btn.setText("Back");
        back_btn.setPrefHeight(42);
        back_btn.setPrefWidth(84);
        hbox.getChildren().add(back_btn);


        scene  = new Scene(pane);
    }

    public Scene getScene() {
        return scene;
    }
}

