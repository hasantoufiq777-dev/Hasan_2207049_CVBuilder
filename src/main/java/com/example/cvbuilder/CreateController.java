package com.example.cvbuilder;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class CreateController {

    public TextField nameField, emailField, phoneField, addressField;
    public TextArea eduArea, skillsArea, workArea, projectArea;

    public void generateCV(ActionEvent e) throws Exception {
        CVModel data = new CVModel(
                nameField.getText(),
                emailField.getText(),
                phoneField.getText(),
                addressField.getText(),
                eduArea.getText(),
                skillsArea.getText(),
                workArea.getText(),
                projectArea.getText()
        );

        FXMLLoader loader = new FXMLLoader(Main.class.getResource("preview.fxml"));
        Scene scene = new Scene(loader.load());

        PreviewController controller = loader.getController();
        controller.setData(data);

        Stage stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
}
