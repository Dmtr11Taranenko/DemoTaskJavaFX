package org.example.demotaskjavafx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class HelloApplication extends Application {
//    @Override
//    public void start(Stage stage) throws IOException {
//        URL fxmlUrl = HelloApplication.class.getResource("/org/example/demotaskjavafx/hello-view.fxml");
//        FXMLLoader fxmlLoader = new FXMLLoader(fxmlUrl);
//        Scene scene = new Scene(fxmlLoader.load(), 700, 700);
//        stage.setTitle("DemoTaskJavaFX");
//        stage.setScene(scene);
//        stage.show();
//    }

    @Override
    public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("MainView.fxml"));
        Scene scene = new Scene(root, 600, 400);
        stage.setTitle("DemoTaskJavaFX");

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}