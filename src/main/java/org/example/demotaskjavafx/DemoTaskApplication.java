/**
 * В данной программе реализовано техническое задание: "Разработка JavaFX-приложения для работы с числами"
 * @version 1.0 05.06.2025
 * @author Taranenko Dmitrii
 */

package org.example.demotaskjavafx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class DemoTaskApplication extends Application {

    // Создание среды приложения
    @Override
    public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("MainView.fxml"));
        Scene scene = new Scene(root, 600, 400);
        stage.setTitle("DemoTaskJavaFX");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    // Запуск приложения
    public static void main(String[] args) {
        launch();
    }
}