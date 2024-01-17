package com.example.lv1011;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main extends Application {

    public static void main(String[] args) {
        /*initializeDatabase();*/
        launch(args);
    }
    private static void initializeDatabase() {
        ExecutorService executorService = Executors.newFixedThreadPool(4);

        Future<?> deleteGrad = executorService.submit(() -> GeografijaDAO.getInstance().obrisiSveGradove());
        Future<?> deleteDrzava = executorService.submit(() -> GeografijaDAO.getInstance().obrisiSveDrzave());
        Future<?> preloadGrad = executorService.submit(() -> GeografijaDAO.getInstance().preloadGradove());
        Future<?> preloadDrzava = executorService.submit(() -> GeografijaDAO.getInstance().preloadDrzave());

        try{
            deleteGrad.get();
            deleteDrzava.get();
            preloadGrad.get();
            preloadDrzava.get();
        }catch(Exception e){
            e.printStackTrace();
        }
        try{
            preloadGrad.get();
            preloadDrzava.get();
        }catch(Exception e){
            e.printStackTrace();
        }

        executorService.shutdown();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("glavna.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
        primaryStage.setScene(scene);
        GlavnaController controller = loader.getController();
        primaryStage.setTitle("Gradovi svijeta");
        primaryStage.show();
    }
}
