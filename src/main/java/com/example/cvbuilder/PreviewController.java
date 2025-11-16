package com.example.cvbuilder;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class PreviewController {

    @FXML
    private VBox container;

    public void setData(CVModel cv) {
        container.getChildren().clear();

        container.getChildren().addAll(
                new Label("FULL NAME: " + cv.getName()),
                new Label("Email: " + cv.getEmail()),
                new Label("Phone: " + cv.getPhone()),
                new Label("Address: " + cv.getAddress()),
                new Label("Education:\n" + cv.getEducation()),
                new Label("Skills:\n" + cv.getSkills()),
                new Label("Work Experience:\n" + cv.getWork()),
                new Label("Projects:\n" + cv.getProjects())
        );
    }
}
