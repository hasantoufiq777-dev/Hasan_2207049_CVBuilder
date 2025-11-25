package com.example.cvbuilder;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class RecordsController {

    @FXML private TableView<CVModel> table;
    @FXML private TableColumn<CVModel, String> nameCol;
    @FXML private TableColumn<CVModel, String> emailCol;
    @FXML private TableColumn<CVModel, Void> editCol;
    @FXML private TableColumn<CVModel, Void> deleteCol;

    private ObservableList<CVModel> data = FXCollections.observableArrayList();


    @FXML
    public void initialize() {

        nameCol.setCellValueFactory(c -> new javafx.beans.property.SimpleStringProperty(c.getValue().getName()));
        emailCol.setCellValueFactory(c -> new javafx.beans.property.SimpleStringProperty(c.getValue().getEmail()));

        addEditButton();
        addDeleteButton();

        loadRecords();
    }


    private void loadRecords() {
        data.clear();
        data.addAll(DatabaseHelper.getAllCVs());
        table.setItems(data);
    }


    private void addEditButton() {
        editCol.setCellFactory(col -> new TableCell<>() {
            private final Button btn = new Button("Edit");

            {
                btn.setOnAction(e -> {
                    CVModel cv = getTableView().getItems().get(getIndex());

                    TextInputDialog nameDialog = new TextInputDialog(cv.getName());
                    nameDialog.setHeaderText("Edit Name");
                    String newName = nameDialog.showAndWait().orElse(cv.getName());

                    TextInputDialog emailDialog = new TextInputDialog(cv.getEmail());
                    emailDialog.setHeaderText("Edit Email");
                    String newEmail = emailDialog.showAndWait().orElse(cv.getEmail());

                    DatabaseHelper.updateCV(cv.getId(), newName, newEmail);
                    loadRecords();
                });
            }

            @Override
            protected void updateItem(Void item, boolean empty) {
                super.updateItem(item, empty);
                setGraphic(empty ? null : btn);
            }
        });
    }


    private void addDeleteButton() {
        deleteCol.setCellFactory(col -> new TableCell<>() {
            private final Button btn = new Button("Delete");

            {
                btn.setOnAction(e -> {
                    CVModel cv = getTableView().getItems().get(getIndex());
                    DatabaseHelper.deleteCV(cv.getId());
                    loadRecords();
                });
            }

            @Override
            protected void updateItem(Void item, boolean empty) {
                super.updateItem(item, empty);
                setGraphic(empty ? null : btn);
            }
        });
    }


    @FXML
    public void goHome() throws Exception {
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("home.fxml"));
        Stage stage = (Stage) table.getScene().getWindow();
        stage.setScene(new Scene(loader.load()));
    }
}
