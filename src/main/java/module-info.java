module org.example.demotaskjavafx {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.demotaskjavafx to javafx.fxml;
    exports org.example.demotaskjavafx;
}