package com.example.nosqlnfac;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class next {

    public TextArea codeTEXT;
    public Button checkBut;
    public Button sndCodeButt;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button addPerosn;

    @FXML
    private TextArea gmailText;

    @FXML
    private TextArea instaText;

    @FXML
    private Button back;

    @FXML
    private ImageView getPhotot;

    @FXML
    private Button sendPhoto;

    @FXML
    private TextArea gmailText1;
    @FXML
    private int sum;
    int code = 0  ,  error = 0;
    @FXML
    private boolean b;
    @FXML
    private String s;

    @FXML
    void initialize() {
        addClass addClass = new addClass();
        String name = "Rus";

       addPerosn.setOnAction(e -> {
           sum = 0;
           gmailText.setPromptText("Text here!");
           gmailText.setPrefWidth(200.0);
           gmailText.setPrefHeight(15.0);
           gmailText.setStyle("-fx-border-color : blue;");
           gmailText1.setPromptText("Text here!");
           gmailText1.setPrefWidth(200.0);
           gmailText1.setPrefHeight(15.0);
           gmailText1.setStyle("-fx-border-color : blue;");
           instaText.setPromptText("Text here!");
           instaText.setPrefWidth(200.0);
           instaText.setPrefHeight(15.0);
           instaText.setStyle("-fx-border-color : blue;");
           codeTEXT.setStyle("-fx-border-color : blue;");
           if(gmailText.getText().isEmpty()){
               gmailText.setPromptText("Here is Empty!");
               gmailText.setStyle("-fx-border-color : red;");
               sum++;
           } else if (gmailText1.getText().isEmpty()) {
               gmailText1.setPromptText("Here is Empty!");
               gmailText1.setStyle("-fx-border-color : red;");
               sum++;
           } else if (instaText.getText().isEmpty()) {
               instaText.setPromptText("Here is Empty!");
               instaText.setStyle("-fx-border-color : red;");
               sum++;
           }
           if (sum > 0){
               return;
           }
           else {
               error = 0 ;
               b = true;
                 if (!value(gmailText.getText())){
                     Alert alert = new Alert(Alert.AlertType.ERROR);
                     alert.setHeaderText("Gmail can not be that!");
                     alert.show();
                     error++;
                 }
                 else if(!type(gmailText1.getText()) || gmailText1.getText().length() > 12){
                     Alert alert = new Alert(Alert.AlertType.ERROR);
                     alert.setHeaderText("Phone number can not be that!");
                     alert.show();
                     error++;
                 } else if (!isURL(instaText.getText()) || !inst(instaText.getText())) {
                     Alert alert = new Alert(Alert.AlertType.ERROR);
                     alert.setHeaderText("The link can not be that!");
                     alert.show();
                     error++;
                 }
                  if(error > 0)
                      return;
                  else {
                      if (!b){
                          return;
                      }
                      else {
                          System.out.println("1");
                          File file = new File(gmailText.getText() + ".txt");
                          File fileForPhoto = new File(gmailText.getText() + ".image");
                          try {
                              PrintWriter printWriter = new PrintWriter(file);
                              PrintWriter printWriter2 = new PrintWriter(fileForPhoto);
                              printWriter.println(gmailText.getText());
                              printWriter.println(instaText.getText());
                              printWriter.println(gmailText1.getText());
                              printWriter2.println(s);
                              printWriter.close();
                              printWriter2.close();
                          } catch (FileNotFoundException ex) {
                              throw new RuntimeException(ex);
                          }
                      }
                      FXMLLoader fxml = new FXMLLoader(HelloApplication.class.getResource("addedPerson.fxml"));
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
                  }
           }
           
       });
       sendPhoto.setOnAction(exer -> {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Open Java File!");
            fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif"));
            File f = fileChooser.showOpenDialog(getPhotot.getScene().getWindow()).getAbsoluteFile();
           System.out.println(f);
           s = f.toURI().toString();
            getPhotot.setImage(new Image(f.toURI().toString()));
            sendPhoto.setOpacity(0.0);
        });
       checkBut.setOnAction(e -> {
           if (codeTEXT.getText().equals(String.valueOf(code))){
               codeTEXT.setStyle("-fx-border-color : blue;");
           }
           else {
               Alert alert = new Alert(Alert.AlertType.ERROR);
               alert.setHeaderText("Code is wrong!");
               alert.show();
               codeTEXT.setStyle("-fx-border-color : red;");
               b = false;
           }
       });
       sndCodeButt.setOnAction(e -> {
           gmailsendmessage();
       });
    }

    void gmailsendmessage(){
        final String username = "duisenbekruslan0@gmail.com";
        final String password = "mwgxqfdxnfizuoko";

        Properties prop = new Properties();
        prop.put("mail.smtp.ssl.protocols", "TLSv1.2");
        prop.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true"); //TLS
        Session session = Session.getInstance(prop,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("duisenbekruslan0@gmail.com"));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(gmailText.getText())
            );
            message.setSubject("Here your code!");
            code = (int) (Math.random()*999+100);
            message.setText(String.valueOf(code));
            Transport.send(message);

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("The code sent!");
            alert.show();

            System.out.println("Done");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
    protected boolean value(String strEmailTxt){
        String email = "^[A-Za-z0-9+_.-]+@(.+)$";
        Pattern emailPatt = Pattern.compile(email);
        Matcher matcher = emailPatt.matcher(strEmailTxt);
        return matcher.matches();
    }
    public static boolean type(String s){
        for (int i = 0; i < s.length(); i++) {
            if(Character.isLetter(s.charAt(i)))
                return false;
        }
        return true;
    }
    public static boolean isURL(String url)  {
        try {
            (new java.net.URL(url)).openStream().close();
            return true;
        } catch (Exception ex) { }
        return false;
    }
    public static boolean inst(String s){
        String s1 = "insta";
        for (int i = 0; i < s.length(); i++) {
            int e = i + 5;
            if (e >= s.length() - 1){
                return false;
            }
            else {
                String f = s.substring(i, i + 5);
                if (s1.equalsIgnoreCase(f)) {
                    return true;
                }
            }
        }
        return false;
    }
}
