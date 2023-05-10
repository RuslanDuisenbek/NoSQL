package com.example.nosqlnfac;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class added {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button addPerosn;

    @FXML
    void initialize() {
      addPerosn.setOnAction(e -> {
          FXMLLoader fxml = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
          Scene scene ;
          try {
              scene = new Scene(fxml.load());
          } catch (IOException et) {
              throw new RuntimeException(et);
          }
          Stage stage = new Stage();
          stage.setScene(scene);
          stage.show();
          addPerosn.getScene().getWindow().hide();
      });
    }
}
