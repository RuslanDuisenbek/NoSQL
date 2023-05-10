module com.example.nosqlnfac {
    requires javafx.controls;
    requires javafx.fxml;
//    requires mail
    requires javax.mail;



    opens com.example.nosqlnfac to javafx.fxml;
    exports com.example.nosqlnfac;
}