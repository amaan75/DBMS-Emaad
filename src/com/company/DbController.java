package com.company;

import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.IOException;
import java.sql.SQLException;

public class DbController {
    public Label textAreaHeadingLabel;
    public Button executeSQLButton;
    public TextArea sqlQueryTextArea;
    public ToggleGroup dbms;
    public ToggleGroup queryType;
    private boolean methodType;
    private int ch;

    @FXML
    public void initialize() {
        executeSQLButton.setOnAction((event) -> {
            try {
                RadioButton chosenDbms = (RadioButton) dbms.getSelectedToggle();// Cast object to radio button
                RadioButton typeQuery = (RadioButton) queryType.getSelectedToggle();
                System.out.println(chosenDbms.getText());
                if (chosenDbms.getText().equals("PostGre"))
                    ch = 2;
                else
                    ch = 1;
                methodType = typeQuery.getText().equals("ResultSet");
                Controller.execute(sqlQueryTextArea.getText(), ch, methodType);
            } catch (SQLException | IOException e) {
                e.printStackTrace();
            }
        });
    }
}
