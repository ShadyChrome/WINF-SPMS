package com.java.components;

import com.java.data.enums.ImagesEnum;
import com.java.utility.IconFactory;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;

public class Card extends BorderPane {

  private BooleanProperty expandedProperty = new SimpleBooleanProperty(false);

  public Card(String frage, String antwort) {
    setTop(getFragenContainer(frage));
    setCenter(getAntwortContainer(antwort));
    getCenter().visibleProperty().bind(expandedProperty);
    getCenter().managedProperty().bind(getCenter().visibleProperty());

    getStyleClass().add("card-viewer-container");
    setPadding(new Insets(6));
    setMinHeight(Region.USE_PREF_SIZE);
    setMaxHeight(Region.USE_PREF_SIZE);
  }

  private Node getAntwortContainer(String antwort) {
    Label content = new Label(antwort);
    content.setAlignment(Pos.CENTER_LEFT);
    content.getStyleClass().add("card-viewer-antwort");
    content.setWrapText(true);

    HBox container = new HBox(content);
    container.setAlignment(Pos.CENTER_LEFT);
    return container;
  }

  private Node getFragenContainer(String frage) {
    Label header = new Label(frage);
    header.getStyleClass().add("card-viewer-question");

    Pane emptySpace = new Pane();
    HBox.setHgrow(emptySpace, Priority.ALWAYS);

    HBox titleContainer = new HBox();
    titleContainer.getStyleClass().add("card-viewer-question-container");
    titleContainer.setFocusTraversable(true);
    titleContainer.setOnMouseClicked(event -> {
      if (event.getButton() == MouseButton.PRIMARY) {
        expand(!getCenter().isVisible());
      }
    });

    titleContainer.addEventHandler(KeyEvent.KEY_PRESSED, event -> {
      if (event.getCode().equals(KeyCode.SPACE) || event.getCode().equals(KeyCode.ENTER)) {
        expand(!getCenter().isVisible());
        event.consume();
      }
    });

    ImageView imageView = new ImageView(IconFactory.getImage(ImagesEnum.ARROW_OPEN));
    expandedProperty.addListener((observable, oldValue, newValue) -> imageView.setRotate(newValue ? 180 : 0));

    titleContainer.getChildren().addAll(header, emptySpace, imageView);
    titleContainer.setAlignment(Pos.CENTER_LEFT);
    return titleContainer;
  }

  private void expand(boolean expand) {
    expandedProperty.setValue(expand);
  }
}
