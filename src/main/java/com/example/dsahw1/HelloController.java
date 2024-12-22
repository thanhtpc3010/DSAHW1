package com.example.dsahw1;

import Entity.SInhVien;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class HelloController {

    @FXML
    private TextField nameField;

    @FXML
    private TextField ageField;

    @FXML
    private TextField salaryField;

    @FXML
    private TableView<SInhVien> sinhvienTable;

    @FXML
    private TableColumn<SInhVien, String> nameColumn;

    @FXML
    private TableColumn<SInhVien, Integer> ageColumn;

    @FXML
    private TableColumn<SInhVien, Double> salaryColumn;

    private ObservableList<SInhVien> sInhVienList;

    @FXML
    public void initialize() {

        sInhVienList = FXCollections.observableArrayList();
        sinhvienTable.setItems(sInhVienList);

        nameColumn.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getName()));
        ageColumn.setCellValueFactory(data -> new javafx.beans.property.SimpleObjectProperty<>(data.getValue().getAge()));
        salaryColumn.setCellValueFactory(data -> new javafx.beans.property.SimpleObjectProperty<>(data.getValue().getSalary()));
    }

    @FXML
    public void onAddButtonClick() {
        try {
            String name = nameField.getText();
            int age = Integer.parseInt(ageField.getText());
            double salary = Double.parseDouble(salaryField.getText());

            sInhVienList.add(new SInhVien(name, age, salary));


            nameField.clear();
            ageField.clear();
            salaryField.clear();
        } catch (NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Vui lòng nhập đúng định dạng!");
            alert.showAndWait();
        }
    }

    @FXML
    public void onSortButtonClick() {
        bubbleSort(sInhVienList);
        sinhvienTable.refresh();
    }

    private void bubbleSort(ObservableList<SInhVien> list) {
        int n = list.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (list.get(j).getSalary() > list.get(j + 1).getSalary()) {
                    SInhVien temp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, temp);
                }
            }
        }
    }
}
