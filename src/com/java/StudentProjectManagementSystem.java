package com.java;

import com.java.page.MainPage;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class StudentProjectManagementSystem extends Application {

  @Override
  public void start(Stage primaryStage) throws Exception {

    Scene scene = new Scene(new MainPage().getContent());
    scene.getStylesheets().add(this.getClass().getResource("css/colors.css").toExternalForm());
    scene.getStylesheets().add(this.getClass().getResource("css/main.css").toExternalForm());

    primaryStage.setScene(scene);
    primaryStage.setTitle("SPMS");
    primaryStage.setMinHeight(768);
    primaryStage.setMinWidth(1024);
    primaryStage.setMaximized(true);
    primaryStage.show();
    scene.getRoot().requestFocus();
  }
}
