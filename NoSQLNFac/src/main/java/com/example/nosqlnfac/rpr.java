package com.example.nosqlnfac;

import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.util.Objects;
import java.util.ResourceBundle;
import java.util.Scanner;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class rpr {

    public TextArea nameArr;
    public Text fixText121;
    public Text fixText1;
    public TextArea gmailAddr;
    public Button chngBut;
    public TextArea dayTXT;
    public MenuButton monthMB;
    public MenuItem dec;
    public MenuItem photoMB1;
    public MenuItem sept;
    public MenuItem june;
    public MenuItem feb;
    public MenuItem Jan;
    public MenuItem matr;
    public MenuItem april;
    public MenuItem may;
    public MenuItem jule;
    public MenuItem aug;
    public MenuItem nov;
    public TextArea yearTXT;
    public MenuItem IMB;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button nextButton;

    @FXML
    private MenuButton monthBut;

    @FXML
    private MenuItem NameMB;

    @FXML
    private MenuItem SurnameMB;

    @FXML
    private MenuItem DateMB;

    @FXML
    private MenuItem NationMB;

    @FXML
    private MenuItem RegMB;

    @FXML
    private MenuItem profMB;

    @FXML
    private MenuItem gmailMB;

    @FXML
    private MenuItem numberMB;

    @FXML
    private MenuItem instaMB;

    @FXML
    private MenuItem photoMB;

    @FXML
    private Text fixText;

    @FXML
    private TextArea fixArea;

    @FXML
    private ImageView image;

    @FXML
    private Button sndBut;
    String old ;
    String s ;
String data;
    @FXML
    void initialize() {
        monthBut.setOnAction(e -> {
            if (nameArr.getText().isEmpty() || gmailAddr.getText().isEmpty()){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText("Name or Gmail is empty!");
                alert.show();
                nameArr.setStyle("-fx-border-color : red;");
                gmailAddr.setStyle("-fx-border-color : red;");
            }
            else
            {
                nameArr.setStyle("-fx-border-color : blue;");
                gmailAddr.setStyle("-fx-border-color : blue;");
            }

        });
        NameMB.setOnAction(ee -> {
            monthBut.setText(NameMB.getText());
            fixText.setText(NameMB.getText());
            fixText.setOpacity(1.0);
            fixArea.setOpacity(1.0);
            chngBut.setOpacity(1.0);
            try {
                Scanner scanner = new Scanner(new File(nameArr.getText() + ".txt"));
                while (scanner.hasNextLine()){
                    old = scanner.nextLine();
                    break;
                }
                scanner.close();
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
            System.out.println(old);
            chngBut.setOnAction(ert -> {
                try {
                    repair((nameArr.getText() + ".txt"), old , fixArea.getText() );

                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }  File file = new File(fixArea.getText() + ".txt");
                File file1 = new File(nameArr.getText() + ".txt");
                try {
                    Scanner scanner = new Scanner(file1);
                    PrintWriter printWriter = new PrintWriter(file);
                    while (scanner.hasNextLine()){
                        String s = scanner.nextLine();
                        printWriter.println(s);
                    }
                    printWriter.close();
                    scanner.close();
                    Files.delete(file1.toPath());
                    if (file1.delete())
                        System.out.println();
                }catch (IOException e) {
                    e.printStackTrace();
                }
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText("Information changed successfully");
                alert.show();



            });

        });
        SurnameMB.setOnAction(e -> {
            monthBut.setText(SurnameMB.getText());
            fixText.setText(SurnameMB.getText());
            fixText.setOpacity(1.0);
            fixArea.setOpacity(1.0);
            chngBut.setOpacity(1.0);
            try {
                Scanner scanner = new Scanner(new File(nameArr.getText() + ".txt"));
                int x = 2;
                while (x -- > 0){
                    old = scanner.nextLine();
                }
                scanner.close();
            } catch (FileNotFoundException ee) {
                throw new RuntimeException(ee);
            }
            System.out.println(old);
            chngBut.setOnAction(ert -> {
                try {
                    repair((nameArr.getText() + ".txt"), old , fixArea.getText() );
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText("Information changed successfully");
                alert.show();
            });
        });

            Jan.setOnAction(erkek -> {
                String s = Jan.getText();
                monthMB.setText(s);
                data = s ;
            });
            feb.setOnAction(erkek -> {
                monthMB.setText(feb.getText());
                data = feb.getText() ;
            });
            matr.setOnAction(erkek -> {
                monthMB.setText(matr.getText());
                data = matr.getText();
            });
            april.setOnAction(erkek -> {
                monthMB.setText(april.getText());
                data = april.getText() ;
            });
            may.setOnAction(erkek -> {
                monthMB.setText(may.getText());
                data = may.getText() ;
            });
            june.setOnAction(erkek -> {
                monthMB.setText(june.getText());
                data =  june.getText();
            });
            jule.setOnAction(erkek -> {
                monthMB.setText(jule.getText());
                data =  jule.getText() ;
            });
            aug.setOnAction(erkek -> {
                monthMB.setText(aug.getText());
                data = aug.getText() ;
            });
            sept.setOnAction(erkek -> {
                monthMB.setText(sept.getText());
                data =  sept.getText() ;
            });
            photoMB1.setOnAction(erkek -> {
                monthMB.setText(photoMB1.getText());
                data = photoMB1.getText() ;
            });
            nov.setOnAction(erkek -> {
                monthMB.setText(nov.getText());
                data = nov.getText() ;
            });
            dec.setOnAction(erkek -> {
                monthMB.setText(dec.getText());
                data = dec.getText() ;
            });

        DateMB.setOnAction(e -> {
            monthBut.setText(DateMB.getText());
            fixText.setText(DateMB.getText());
            fixText.setOpacity(1.0);
            monthMB.setOpacity(1.0);
            chngBut.setOpacity(1.0);
            dayTXT.setOpacity(1.0);
            yearTXT.setOpacity(1.0);
            String a1 = "";
            String a2 = "";
            String a3 = "";

            try {
                Scanner scanner = new Scanner(new File(nameArr.getText() + ".txt"));
                int x = 3;
                while (x-- > 0){
                    a3 = scanner.nextLine();
                }
                scanner.close();
            } catch (FileNotFoundException ee) {
                throw new RuntimeException(ee);
            }

            old = a3;
            System.out.println(old);
            chngBut.setOnAction(ert -> {
                if (dayTXT.getText().isEmpty()){
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setHeaderText("Day is empty!");
                    alert.show();
                } else if (yearTXT.getText().isEmpty()) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setHeaderText("Year is empty!");
                    alert.show();
                }
                else {
                     data = dayTXT.getText() + " " + data + " " + yearTXT.getText();
                    System.out.println(data);
                    try {
                        repair((nameArr.getText() + ".txt"), old, data);
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText("Information changed successfully");
                    alert.show();
                }});
        });
        NationMB.setOnAction(e -> {
            monthBut.setText(NationMB.getText());
            fixText.setText(NationMB.getText());
            fixText.setOpacity(1.0);
            fixArea.setOpacity(1.0);
            chngBut.setOpacity(1.0);
            try {
                Scanner scanner = new Scanner(new File(nameArr.getText() + ".txt"));
                int x = 4;
                while (x -- > 0){
                    old = scanner.nextLine();
                }
                scanner.close();
            } catch (FileNotFoundException ee) {
                throw new RuntimeException(ee);
            }
            System.out.println(old);
            chngBut.setOnAction(ert -> {
                try {
                    repair((nameArr.getText() + ".txt"), old , fixArea.getText() );
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText("Information changed successfully");
                alert.show();
            });
        });
        RegMB.setOnAction(e -> {
            monthBut.setText(RegMB.getText());
            fixText.setText(RegMB.getText());
            fixText.setOpacity(1.0);
            fixArea.setOpacity(1.0);
            chngBut.setOpacity(1.0);
            try {
                Scanner scanner = new Scanner(new File(nameArr.getText() + ".txt"));
                int x = 5;
                while (x -- > 0){
                    old = scanner.nextLine();
                }
                scanner.close();
            } catch (FileNotFoundException ee) {
                throw new RuntimeException(ee);
            }
            System.out.println(old);
            chngBut.setOnAction(ert -> {
                try {
                    repair((nameArr.getText() + ".txt"), old , fixArea.getText() );
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText("Information changed successfully");
                alert.show();
            });
        });
        profMB.setOnAction(e -> {
            monthBut.setText(profMB.getText());
            fixText.setText(profMB.getText());
            fixText.setOpacity(1.0);
            fixArea.setOpacity(1.0);
            chngBut.setOpacity(1.0);
            try {
                Scanner scanner = new Scanner(new File(nameArr.getText() + ".txt"));
                int x = 6;
                while (x -- > 0){
                    old = scanner.nextLine();
                }
                scanner.close();
            } catch (FileNotFoundException ee) {
                throw new RuntimeException(ee);
            }
            System.out.println(old);
            chngBut.setOnAction(ert -> {
                try {
                    repair((nameArr.getText() + ".txt"), old , fixArea.getText() );
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText("Information changed successfully");
                alert.show();
            });
        });
          gmailMB.setOnAction(e -> {
              monthBut.setText(gmailMB.getText());
              fixText.setText(gmailMB.getText());
              fixText.setOpacity(1.0);
              fixArea.setOpacity(1.0);
              chngBut.setOpacity(1.0);
              try {
                  Scanner scanner = new Scanner(new File(gmailAddr.getText() + ".txt"));
                  Scanner scanner2 = new Scanner(new File(gmailAddr.getText() + ".image"));
                  while (scanner.hasNextLine()){
                      old = scanner.nextLine();
                      break;
                  }
                  scanner.close();
              } catch (FileNotFoundException wee) {
                  throw new RuntimeException(wee);
              }
              System.out.println(old);
              chngBut.setOnAction(ert -> {
                  try {
                      repair((gmailAddr.getText() + ".txt"), old , fixArea.getText() );

                  } catch (IOException ex) {
                      throw new RuntimeException(ex);
                  }  File file = new File(fixArea.getText() + ".txt");
                    File file2 = new File(fixArea.getText() + ".image");
                  File file1 = new File(gmailAddr.getText() + ".txt");
                  File file12 = new File(gmailAddr.getText() + ".image");
                  try {
                      Scanner scanner = new Scanner(file1);
                      Scanner scanner2 = new Scanner(file12);
                      PrintWriter printWriter = new PrintWriter(file);
                      PrintWriter printWriter2 = new PrintWriter(file2);
                      while (scanner.hasNextLine()){
                          String s = scanner.nextLine();
                          printWriter.println(s);
                      }
                      printWriter.close();
                      scanner.close();
                      while (scanner2.hasNextLine()){
                          String s = scanner2.nextLine();
                          printWriter2.println(s);
                      }
                      printWriter2.close();
                      scanner2.close();
                      if (file1.delete())
                          System.out.println();
                      if (file12.delete())
                          System.out.println();
                  }catch (IOException we) {
                      we.printStackTrace();
                  }
                  Alert alert = new Alert(Alert.AlertType.INFORMATION);
                  alert.setHeaderText("Information changed successfully");
                  alert.show();

              });
    });
          numberMB.setOnAction(e -> {
              monthBut.setText(numberMB.getText());
              fixText.setText("number");
              fixText.setOpacity(1.0);
              fixArea.setOpacity(1.0);
              chngBut.setOpacity(1.0);
              try {
                  Scanner scanner = new Scanner(new File(gmailAddr.getText() + ".txt"));
                  int x = 3;
                  while (x -- > 0){
                      old = scanner.nextLine();
                  }
                  System.out.println(old);
                  scanner.close();
              } catch (FileNotFoundException ee) {
                  throw new RuntimeException(ee);
              }
              System.out.println(old);
              chngBut.setOnAction(ert -> {
                  try {
                      repair((gmailAddr.getText() + ".txt"), old , fixArea.getText() );
                  } catch (IOException ex) {
                      throw new RuntimeException(ex);
                  }
                  Alert alert = new Alert(Alert.AlertType.INFORMATION);
                  alert.setHeaderText("Information changed successfully");
                  alert.show();
              });
          });
        photoMB.setOnAction(e -> {
            monthBut.setText(photoMB.getText());
            fixText.setText("Photo");
            fixText.setOpacity(1.0);
            image.setOpacity(1.0);
            chngBut.setOpacity(1.0);
            sndBut.setOpacity(1.0);
            sndBut.setOnAction(ert -> {
                FileChooser fileChooser = new FileChooser();
                fileChooser.setTitle("Open Java File!");
                fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif"));
                File f = fileChooser.showOpenDialog(image.getScene().getWindow()).getAbsoluteFile();
                System.out.println(f);
                s = f.toURI().toString();
                image.setImage(new Image(f.toURI().toString()));
                sndBut.setOpacity(0.0);
            });
            try {
                File file = new File(gmailAddr.getText() + ".image");
                if (file.delete())
                    System.out.println("File is deleted!");
            } catch (Exception ee) {
                throw new RuntimeException(ee);
            }
            System.out.println(s);
            chngBut.setOnAction(ert -> {
                try {
                  File file = new File(gmailAddr.getText() + ".image");
                  PrintWriter printWriter = new PrintWriter(file);
                  printWriter.println(s);
                  printWriter.close();
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText("Information changed successfully");
                alert.show();
            });
        });
        nextButton.setOnAction(e -> {
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
            nextButton.getScene().getWindow().hide();
        });

    }
    public static void repair(String path , String fixInfo , String newInfo) throws IOException {
        String filePath = path;
        Scanner sc = new Scanner(new File(filePath));
        StringBuffer buffer = new StringBuffer();
        while (sc.hasNextLine()) {
            buffer.append(sc.nextLine()+System.lineSeparator());
        }
        String fileContents = buffer.toString();
        sc.close();
        String oldLine = fixInfo;
        String newLine = newInfo;
        fileContents = fileContents.replaceAll(oldLine, newLine);
        PrintWriter writer = new PrintWriter(filePath);
        writer.append(fileContents);
        writer.flush();
        writer.close();
    }
    public static String fileToString(String filePath) throws Exception{
        String input = null;
        Scanner sc = new Scanner(new File(filePath));
        StringBuffer sb = new StringBuffer();
        while (sc.hasNextLine()) {
            input = sc.nextLine();
            sb.append(input);
        }
        return sb.toString();
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
    public static boolean isURL(String url)  {
        try {
            (new java.net.URL(url)).openStream().close();
            return true;
        } catch (Exception ex) { }
        return false;
    }

}
