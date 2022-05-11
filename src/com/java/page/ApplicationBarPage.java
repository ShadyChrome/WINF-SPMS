package com.java.page;

import com.java.data.ImagesEnum;
import com.java.utility.IconFactory;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;

public class ApplicationBarPage {

  private HBox content;

  public ApplicationBarPage() {
    this.content = new HBox();
    content.getStyleClass().add("app-bar-container");

    Pane spacer = new Pane();
    HBox.setHgrow(spacer, Priority.ALWAYS);

    ImageView logo = new ImageView(IconFactory.getImage(ImagesEnum.LOGO));
    logo.getStyleClass().add("logo");

    Label title = new Label("Project");
    title.getStyleClass().add("title");

    content.getChildren().addAll(logo, title, spacer);
    content.setAlignment(Pos.CENTER);
    HBox.setMargin(logo, new Insets(0, 12, 0, 0));
  }

  public Node getContent() {
    return content;
  }
}
