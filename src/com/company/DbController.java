package com.company;

import javafx.event.ActionEvent;
import javafx.scene.control.*;

import java.io.IOException;

public class DbController {
    public Label textAreaHeadingLabel;
    public Button executeSQLButton;
    public TextArea sqlQueryTextArea;
    public ToggleGroup dbms;
    private int ch;

    public void runQuery(ActionEvent actionEvent) {
        try {
            RadioButton chosenDbms = (RadioButton) dbms.getSelectedToggle(); // Cast object to radio button
            System.out.println(chosenDbms.getText());
            if (chosenDbms.getText().equals("PostGre"))
                ch = 2;
            else
                ch = 1;
            Controller.execute(sqlQueryTextArea.getText(), ch);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //finally{}
    }
}
