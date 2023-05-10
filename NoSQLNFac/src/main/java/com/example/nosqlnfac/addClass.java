package com.example.nosqlnfac;

import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class addClass {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button nextButton;

    @FXML
     TextArea nameText;

    @FXML
    private TextArea surnameText;

    @FXML
    private TextArea dayText;

    @FXML
    private MenuItem janMB;
    @FXML
    private MenuButton monthBut;

    @FXML
    private MenuItem febMB;

    @FXML
    private MenuItem matrMB;

    @FXML
    private MenuItem AprMB;

    @FXML
    private MenuItem mayMB;

    @FXML
    private MenuItem juneMB;

    @FXML
    private MenuItem juleMB;

    @FXML
    private MenuItem augMB;

    @FXML
    private MenuItem sepMB;

    @FXML
    private MenuItem octMB;

    @FXML
    private MenuItem novMB;

    @FXML
    private MenuItem decMB;

    @FXML
    private TextArea yearText;

    @FXML
    private TextArea nationText;

    @FXML
    private TextArea regTatxt;

    @FXML
    private TextArea profText;
    @FXML
    private int count;
    @FXML
    private int countAfter;
    @FXML
    private String s ;
    @FXML
    private String data;


    @FXML
    void initialize() {
        monthBut.setText("MONTH");
        janMB.setOnAction(er -> {
            s = janMB.getText();
            monthBut.setText(s);
            data = s;
        });
        febMB.setOnAction(er -> {
            s = febMB.getText();
            monthBut.setText(s);
            data = s;
        });
        matrMB.setOnAction(er -> {
            s = matrMB.getText();
            monthBut.setText(s);
            data = s;
        });
        AprMB.setOnAction(er -> {
            s = AprMB.getText();
            monthBut.setText(s);
            data = s;
        });
        mayMB.setOnAction(er -> {
            s = mayMB.getText();
            monthBut.setText(s);
            data = s;
        });
        juneMB.setOnAction(er -> {
            s = juneMB.getText();
            monthBut.setText(s);
            data = s;
        });
        juleMB.setOnAction(er -> {
            s = juleMB.getText();
            monthBut.setText(s);
            data = s;
        });
        augMB.setOnAction(er -> {
            s = augMB.getText();
            monthBut.setText(s);
            data = s;
        });
        sepMB.setOnAction(er -> {
            s = sepMB.getText();
            monthBut.setText(s);
            data = s;
        });
        octMB.setOnAction(er -> {
            s = octMB.getText();
            monthBut.setText(s);
            data = s;
        });
        novMB.setOnAction(er -> {
            s = novMB.getText();
            monthBut.setText(s);
            data = s;
        });
        decMB.setOnAction(er -> {
            s = decMB.getText();
            monthBut.setText(s);
            data = s;
        });
      nextButton.setOnAction(e -> {
           nameText.setPromptText("Text here!");
          nameText.setStyle("-fx-border-color : blue;");
          nameText.setPrefWidth(200.0);
          nameText.setPrefHeight(15.0);
          surnameText.setPromptText("Text here!");
          surnameText.setStyle("-fx-border-color : blue;");
          surnameText.setPrefWidth(200.0);
          surnameText.setPrefHeight(38.0);
          dayText.setPromptText("Text here!");
          dayText.setStyle("-fx-border-color : blue;");
          dayText.setPrefWidth(57.0);
          dayText.setPrefHeight(32.0);
          yearText.setPromptText("Text here!");
          yearText.setStyle("-fx-border-color : blue;");
          yearText.setPrefWidth(57.0);
          yearText.setPrefHeight(32.0);
          profText.setPromptText("Text here!");
          profText.setStyle("-fx-border-color : blue;");
          profText.setPrefWidth(200.0);
          profText.setPrefHeight(15.0);
          nationText.setPromptText("Text here!");
          nationText.setStyle("-fx-border-color : blue;");
          nationText.setPrefWidth(200.0);
          nationText.setPrefHeight(15.0);
          regTatxt.setPromptText("Text here!");
          regTatxt.setStyle("-fx-border-color : blue;");
          regTatxt.setPrefWidth(200.0);
          regTatxt.setPrefHeight(15.0);


          count = 0 ;
          if(nameText.getText().isEmpty()){
              nameText.setPromptText("Here is Empty!");
              nameText.setStyle("-fx-border-color : red;");
              count++;
          } else if (surnameText.getText().isEmpty()) {
              surnameText.setPromptText("Here is Empty!");
              surnameText.setStyle("-fx-border-color : red;");
              count++;
          } else if (dayText.getText().isEmpty()) {
              dayText.setPromptText("Here is Empty!");
              dayText.setStyle("-fx-border-color : red;");
              count++;
          } else if (yearText.getText().isEmpty()) {
              yearText.setPromptText("Here is Empty!");
              yearText.setStyle("-fx-border-color : red;");
              count++;
          } else if (nationText.getText().isEmpty()) {
              nationText.setPromptText("Here is Empty!");
              nationText.setStyle("-fx-border-color : red;");
              count++;
          } else if (regTatxt.getText().isEmpty()) {
              regTatxt.setPromptText("Here is Empty!");
              regTatxt.setStyle("-fx-border-color : red;");
              count++;
          }
          else if (profText.getText().isEmpty()){
              profText.setPromptText("Here is Empty!");
              profText.setStyle("-fx-border-color : red;");
              count++;
          } else if (monthBut.getText().equals("MONTH")) {
              Alert alert = new Alert(Alert.AlertType.ERROR);
              alert.setHeaderText("Month Is Not Selected");
              alert.show();
             count++;
          }

          if (count > 0){
              return;
          }
          else {
              countAfter = 0 ;
              if (!nameCheck(nameText.getText())) {
                  Alert alert = new Alert(Alert.AlertType.ERROR);
                  alert.setHeaderText("Name can not be digit!");
                  alert.show();
                  countAfter++;
              }else  if (!nameCheck(surnameText.getText())) {
                  Alert alert = new Alert(Alert.AlertType.ERROR);
                  alert.setHeaderText("Surname can not be digit!");
                  alert.show();
                  countAfter++;
              } else if(!dayCheck(dayText.getText())){
                  Alert alert = new Alert(Alert.AlertType.ERROR);
                  alert.setHeaderText("Day can not be letter!");
                  alert.show();
                  countAfter++;
              } else if (!dayCheck(yearText.getText())) {
                  Alert alert = new Alert(Alert.AlertType.ERROR);
                  alert.setHeaderText("Year can not be letter!");
                  alert.show();
                  countAfter++;
              } else if (!nameCheck(nationText.getText())) {
                  Alert alert = new Alert(Alert.AlertType.ERROR);
                  alert.setHeaderText("Nation can not be digit!");
                  alert.show();
                  countAfter++;
              } else if (!nameCheck(regTatxt.getText())) {
                  Alert alert = new Alert(Alert.AlertType.ERROR);
                  alert.setHeaderText("Region can not be digit!");
                  alert.show();
                  countAfter++;
              } else if (!nameCheck(profText.getText())) {
                  Alert alert = new Alert(Alert.AlertType.ERROR);
                  alert.setHeaderText("Profession can not be digit!");
                  alert.show();
                  countAfter++;
              }
              if(countAfter>0)
                  return;
              else {
                     data = dayText.getText() + " " + data + " " + yearText.getText();
                      File file = new File(nameText.getText() + ".txt");
                      try {
                          if (file.createNewFile())
                              System.out.println("");
                          try {
                              PrintWriter print = new PrintWriter((file));
                              print.println(nameText.getText() );
                              print.println(surnameText.getText() );
                              print.println(data);
                              print.println(nationText.getText() );
                              print.println(regTatxt.getText() );
                              print.println(profText.getText() );
                              print.close();
                              
                          } catch (IOException exc) {
                              throw new RuntimeException(exc);
                          }
                      } catch (IOException exc) {
                          throw new RuntimeException(exc);
                      }

                  FXMLLoader fxml = new FXMLLoader(HelloApplication.class.getResource("next.fxml"));
                  Scene scene ;
                  try {
                      scene = new Scene(fxml.load());
                  } catch (IOException et) {
                      throw new RuntimeException(et);
                  }
                  Stage stage = new Stage();
                  stage.setScene(scene);
                  stage.show();
                  nextButton.getScene().getWindow().hide();
              }
          }
      });

    }
    protected boolean dayCheck(String strEmailTxt){
        for (int i = 0; i < strEmailTxt.length(); i++) {
            char c = strEmailTxt.charAt(i);
            if(Character.isLetter(c))
                return false;
        }
        return true;
    }
    protected boolean nameCheck(String strEmailTxt){
        for (int i = 0; i < strEmailTxt.length(); i++) {
            if(Character.isDigit(strEmailTxt.charAt(i)))
                return false;
        }
        return true;
    }
}
