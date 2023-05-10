package com.example.nosqlnfac;

import java.io.IOException;
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
import javafx.stage.Stage;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class check {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button addPerosn;

    @FXML
    private TextArea gmailText;

    @FXML
    private Button back;

    @FXML
    private TextArea codeTEXT;

    @FXML
    private Button checkBut;

    @FXML
    private Button sndCodeButt;
    int code;
    boolean b = false;

    @FXML
    void initialize() {
        back.setOnAction(e -> {
            FXMLLoader fxml = new FXMLLoader(HelloApplication.class.getResource("seePeople.fxml"));
            Scene scene ;
            try {
                scene = new Scene(fxml.load());
            } catch (IOException et) {
                throw new RuntimeException(et);
            }
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
            back.getScene().getWindow().hide();
        });
        addPerosn.setOnAction(e -> {
            if (gmailText.getText().isEmpty() || !value(gmailText.getText())){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText("Gmail is wrong!");
                alert.show();
            }
            else {
               if (b){
                    FXMLLoader fxml = new FXMLLoader(HelloApplication.class.getResource("repair.fxml"));
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
               else {
                   Alert alert = new Alert(Alert.AlertType.ERROR);
                   alert.setHeaderText("Something is wrong!");
                   alert.show();
               }
            }
        });
        checkBut.setOnAction(ex -> {
            if (codeTEXT.getText().equals(String.valueOf(code))) {
                codeTEXT.setStyle("-fx-border-color : blue;");
                b = true;
            }
            else{
                codeTEXT.setStyle("-fx-border-color : red;");
                b = false;
        }});

        sndCodeButt.setOnAction(eq -> {
            gmailsendmessage();
        });
    }
    protected boolean value(String strEmailTxt){
        String email = "^[A-Za-z0-9+_.-]+@(.+)$";
        Pattern emailPatt = Pattern.compile(email);
        Matcher matcher = emailPatt.matcher(strEmailTxt);
        return matcher.matches();
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
}
