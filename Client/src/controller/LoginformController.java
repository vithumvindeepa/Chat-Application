package controller;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginformController {
    public JFXTextField txtuname;


    static String name;
    public void btnsignin(ActionEvent actionEvent) throws IOException {
        name=txtuname.getText();
        if (name.equals("")) {
            new Alert(Alert.AlertType.WARNING, "Please check your Username").showAndWait();
            clearloginOnAction();

        } else {
            Stage stage=(Stage) txtuname.getScene().getWindow();
            stage.close();
            Stage stage1=new Stage();
            stage1.setScene(new Scene(FXMLLoader.load(getClass().getResource("../View/Client1.fxml"))));
            stage1.setResizable(false);
            stage1.setTitle(name);
            stage1.centerOnScreen();
            stage1.show();
        }

    }


    public void clearloginOnAction() {
        txtuname.clear();

    }

}




