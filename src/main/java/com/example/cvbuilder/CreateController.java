package com.example.cvbuilder;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class CreateController {

    public TextField nameField, emailField, phoneField, addressField;


    @FXML private TextField skillInput;
    @FXML private TextField projectInput;
    @FXML private TextField educationInput;
    @FXML private TextField workInput;


    @FXML private VBox skillsBox;
    @FXML private VBox projectsBox;
    @FXML private VBox educationBox;
    @FXML private VBox workBox;


    private final List<String> skills = new ArrayList<>();
    private final List<String> projects = new ArrayList<>();
    private final List<String> education = new ArrayList<>();
    private final List<String> work = new ArrayList<>();


    @FXML
    public void addEducation(ActionEvent e) {
        String ed = educationInput.getText().trim();
        if (ed.isEmpty()) return;

        education.add(ed);
        educationBox.getChildren().add(new Label("• " + ed));
        educationInput.clear();
    }

    @FXML
    public void addSkill(ActionEvent e) {
        String skill = skillInput.getText().trim();
        if (skill.isEmpty()) return;

        skills.add(skill);
        skillsBox.getChildren().add(new Label("• " + skill));
        skillInput.clear();
    }


    @FXML
    public void addProject(ActionEvent e) {
        String project = projectInput.getText().trim();
        if (project.isEmpty()) return;

        projects.add(project);
        projectsBox.getChildren().add(new Label("• " + project));
        projectInput.clear();
    }


    @FXML
    public void addWork(ActionEvent e) {
        String w = workInput.getText().trim();
        if (w.isEmpty()) return;

        work.add(w);
        workBox.getChildren().add(new Label("• " + w));
        workInput.clear();
    }


    @FXML
    public void generateCV(ActionEvent e) throws Exception {

        CVModel data = new CVModel(
                nameField.getText(),
                emailField.getText(),
                phoneField.getText(),
                addressField.getText(),

                String.join("\n", education),
                String.join("\n", skills),
                String.join("\n", work),
                String.join("\n", projects)
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
