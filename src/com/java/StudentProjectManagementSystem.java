package com.java;

import com.java.controller.DataController;
import com.java.data.enums.ImagesEnum;
import com.java.page.MainPage;
import com.java.utility.IconFactory;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class StudentProjectManagementSystem extends Application {

  @Override
  public void start(Stage primaryStage) throws Exception {
    DataController.getINSTANCE().setPrimaryStage(primaryStage);

    Scene scene = new Scene(new MainPage().getContent());
    scene.getStylesheets().add(this.getClass().getResource("css/colors.css").toExternalForm());
    scene.getStylesheets().add(this.getClass().getResource("css/main.css").toExternalForm());

    primaryStage.setScene(scene);
    primaryStage.setTitle("SPMS");
    primaryStage.setHeight(600);
    primaryStage.setMinWidth(1280);
    primaryStage.setWidth(1280);
    primaryStage.show();
    primaryStage.getIcons().add(IconFactory.getImage(ImagesEnum.LOGO));
    scene.getRoot().requestFocus();
  }
}
