package com.example.nosqlnfac;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class see {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button addPerosn;

    @FXML
    private Button seePerosn;

    @FXML
    private Button seePerosn1;

    @FXML
    void initialize() throws FileNotFoundException {
       seePerosn1.setOnAction(e -> {
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
           seePerosn1.getScene().getWindow().hide();
       });
       addPerosn.setOnAction(e -> {
           FXMLLoader fxml = new FXMLLoader(HelloApplication.class.getResource("check.fxml"));
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
       seePerosn.setOnAction(e -> {
           FXMLLoader fxml = new FXMLLoader(HelloApplication.class.getResource("seePeop.fxml"));
           Scene scene ;
           try {
               scene = new Scene(fxml.load());
           } catch (IOException et) {
               throw new RuntimeException(et);
           }
           Stage stage = new Stage();
           stage.setScene(scene);
           stage.show();
           seePerosn.getScene().getWindow().hide();
       });

    }
}
