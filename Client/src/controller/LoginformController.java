package controller;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import db.DbConnection;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;
import model.UserName;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class LoginformController {
    public JFXTextField txtuname;

    static String name;
    public  void btnsignin(ActionEvent actionEvent) throws IOException, SQLException {
        name=txtuname.getText();

        if (name.equals("")) {
            new Alert(Alert.AlertType.WARNING, "Please check your Username").showAndWait();
            clearloginOnAction();

        } else {
            Stage stage = (Stage) txtuname.getScene().getWindow();
            stage.close();
            Stage stage1 = new Stage();
            stage1.setScene(new Scene(FXMLLoader.load(getClass().getResource("../View/Client1.fxml"))));
            stage1.setResizable(false);
            stage1.setTitle(name);
            stage1.centerOnScreen();
            stage1.show();
        }
        UserName userName = new UserName(txtuname.getText());
        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO UserName " + "VALUES(?)");
        preparedStatement.setObject(1,  userName.getUSERNAME());
        int save = preparedStatement.executeUpdate();
        if (save > 0) {
            new Alert(Alert.AlertType.CONFIRMATION, "Saved", ButtonType.OK).show();
        } else {
            new Alert(Alert.AlertType.WARNING, "Try again", ButtonType.OK).show();
        }
    }

    public void clearloginOnAction() {
        txtuname.clear();

    }

}





