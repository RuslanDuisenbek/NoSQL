package com.example.nosqlnfac;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class seePeop {

    public Text instaaa;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button menuBut;

    @FXML
    private ImageView image;

    @FXML
    private TextArea nameArr;

    @FXML
    private Text fixText1;

    @FXML
    private Text fixText121;

    @FXML
    private TextArea gmailAddr;

    @FXML
    private Button seeBut;

    @FXML
    private Text nameTxt;

    @FXML
    private Text date;

    @FXML
    private Text nat;

    @FXML
    private Text reg;

    @FXML
    private Text proff;

    @FXML
    private Text gmail;

    @FXML
    private Text phone;

    @FXML
    private Text photo;

    @FXML
    private Text surname;
    String name , surnam , data , nation , rege , prof;
    String gma , ins , num;
    String ima;

    @FXML
    void initialize() {
      seeBut.setOnAction(e -> {
          if (nameArr.getText().isEmpty() || gmailAddr.getText().isEmpty()){
              Alert alert = new Alert(Alert.AlertType.ERROR);
              alert.setHeaderText("Name or Gmail is empty!");
              alert.show();
          }
          else {
              File f1 = new File(nameArr.getText() + ".txt");
              File f2 = new File(gmailAddr.getText() + ".txt");
              File f3 = new File(gmailAddr.getText() + ".image");
              File f4 = new File(gmailAddr.getText() + ".insta");
              try {
                  Scanner scanner1 = new Scanner(f1);
                  Scanner scanner2 = new Scanner(f2);
                  Scanner scanner3 = new Scanner(f3);
                  while (scanner1.hasNextLine()){
                      name = scanner1.nextLine();
                      surnam = scanner1.nextLine();
                      data = scanner1.nextLine();
                      nation = scanner1.nextLine();
                      rege = scanner1.nextLine();
                      prof = scanner1.nextLine();
                  }
                  scanner1.close();
                  while (scanner2.hasNextLine()){
                      gma = scanner2.nextLine();
                      ins = scanner2.nextLine();
                      num = scanner2.nextLine();
                  }
                  scanner2.close();
                  while (scanner3.hasNextLine()) {
                      ima = scanner3.nextLine();
                  }
                  scanner3.close();
              }catch (Exception exception){
                  Alert alert = new Alert(Alert.AlertType.ERROR);
                  alert.setHeaderText("Name or Gmail is wrong!");
                  alert.show();
              }
              System.out.println(name);
              System.out.println(surnam);
              System.out.println(nameArr.getText() + ".txt");
              System.out.println(gmailAddr.getText() + ".image");
              nameTxt.setOpacity(1.0);
              nameTxt.setText("Name:" + name);
              surname.setOpacity(1.0);
              surname.setText("Surname:" + surnam );
              date.setOpacity(1.0);
              date.setText("Date of Birth:" + data);
              nat.setOpacity(1.0);
              nat.setText("Nation:" + nation);
              reg.setOpacity(1.0);
              reg.setText("Region:" + rege);
              proff.setOpacity(1.0);
              proff.setText("Profession:" + prof);
              gmail.setOpacity(1.0);
              gmail.setText("Gmail:" + gma);
              phone.setOpacity(1.0);
              phone.setText("Number:" + num);
              photo.setOpacity(1.0);
              image.setOpacity(1.0);
              image.setImage(new Image(ima));


          }
      });
      menuBut.setOnAction(e -> {
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
          menuBut.getScene().getWindow().hide();
      });

    }
}
