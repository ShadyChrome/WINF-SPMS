package com.java.page;

import com.java.data.ImagesEnum;
import com.java.utility.IconFactory;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Separator;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

import static com.java.utility.UIFactory.createHBoxContainer;

public class ActionPage {

  private VBox content;

  public ActionPage() {
    this.content = new VBox();
    this.content.getStyleClass().add("action-page-container");
    this.content.setPrefWidth(200);
    init();
  }

  private void init() {
    this.content.getChildren().addAll(createHBoxContainer(new ImageView(IconFactory.getImage(ImagesEnum.TEAM)), createComboBox(FXCollections.observableArrayList("Demo Team 1", "Demo Team 2", "Demo Team 3"))),
        new Separator(),
        createHBoxContainer(new ImageView(IconFactory.getImage(ImagesEnum.FILTER)), createComboBox(FXCollections.observableArrayList("Alle"))),
        new Separator(),
        createButton("Fehler melden", new ImageView(IconFactory.getImage(ImagesEnum.REPORT))),
        createButton("Frage stellen", new ImageView(IconFactory.getImage(ImagesEnum.HELP))),
        createButton("Vorschlag machen", new ImageView(IconFactory.getImage(ImagesEnum.PROPOSAL))),
        new Separator());
    this.content.setSpacing(6);
  }

  private JFXComboBox createComboBox(ObservableList list) {
    JFXComboBox<Object> comboBox = new JFXComboBox<>();
    comboBox.setItems(list);
    comboBox.getSelectionModel().selectFirst();
    comboBox.setMaxWidth(Double.MAX_VALUE);
    HBox.setHgrow(comboBox, Priority.ALWAYS);

    return comboBox;
  }

  private JFXButton createButton(String text, Node graphic) {
    JFXButton button = new JFXButton(text, graphic);
    button.setMaxWidth(Double.MAX_VALUE);
    button.setAlignment(Pos.CENTER_LEFT);

    return button;
  }

  public Node getContent() {
    return content;
  }
}
