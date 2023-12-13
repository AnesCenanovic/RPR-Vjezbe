package com.example.lv78;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        UserModel m = new UserModel();
        m.napuni();
        System.out.println(m.size());
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("hello-view.fxml"));
        HelloController controller = new HelloController(m);
        fxmlLoader.setController(controller);
        Scene scene = new Scene(fxmlLoader.load(), 500, 310); //golden ratio
        stage.setTitle("Korisnici");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}