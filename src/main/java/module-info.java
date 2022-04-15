module com.example.mp7_bdevereux {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.mp7_bdevereux to javafx.fxml;
    exports com.example.mp7_bdevereux;
}