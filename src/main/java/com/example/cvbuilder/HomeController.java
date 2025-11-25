package com.example.cvbuilder;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class HomeController {

    // Go to CV creation page
    public void goToCreate(ActionEvent e) throws Exception {
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("create.fxml"));
        Scene scene = new Scene(loader.load());

        Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    // NEW → Go to Saved Records Table (records.fxml)
    public void goToRecords(ActionEvent e) throws Exception {
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("records.fxml"));
        Scene scene = new Scene(loader.load());

        Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
}
