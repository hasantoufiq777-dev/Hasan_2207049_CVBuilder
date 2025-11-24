package com.example.cvbuilder;

import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.util.List;

public class HomeController {

    public void goToCreate(ActionEvent e) throws Exception {
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("create.fxml"));
        Scene scene = new Scene(loader.load());

        Stage stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    // Optional helper to display stored names/emails
    public void showSavedCVs(ActionEvent e) {
        Task<List<CVModel>> task = DatabaseService.loadAllCVsAsync();

        task.setOnSucceeded(ev -> {
            List<CVModel> list = task.getValue();
            if (list.isEmpty()) {
                new Alert(Alert.AlertType.INFORMATION, "No saved CVs found.").show();
                return;
            }

            StringBuilder sb = new StringBuilder();
            for (CVModel c : list) {
                sb.append("Name: ").append(c.getName()).append("\n");
                sb.append("Email: ").append(c.getEmail()).append("\n\n");
            }
            new Alert(Alert.AlertType.INFORMATION, sb.toString()).show();
        });

        task.setOnFailed(ev -> {
            new Alert(Alert.AlertType.ERROR, "Failed to load saved CVs: " + task.getException()).show();
        });

        new Thread(task).start();
    }
}
