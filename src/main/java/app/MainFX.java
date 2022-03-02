package app;

import Controller.Bakery;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;


public class MainFX extends Application {
    @Override
    public void start(Stage primaryStage) {
        try {
            FXMLLoader loader=new FXMLLoader(getClass().getResource("/MainView.fxml"));
            Parent root = (Parent) loader.load();
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.show();
            primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {

                @Override
                public void handle(WindowEvent we) {
                    Bakery controller=loader.getController();
                }

            });
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}

