package main;

import databases.Inventory;
import databases.Order_db;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Objects;


public class Main extends Application{

    @Override
    public void start(Stage primaryStage) throws Exception {
        // loading inventory database from text file (for serialization)
        Inventory.loadInventory();


        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("../view/Login_view.fxml")));
        primaryStage.setTitle("Pizza Time");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public static void main(String[] args) {

        launch(args);
    }
}
