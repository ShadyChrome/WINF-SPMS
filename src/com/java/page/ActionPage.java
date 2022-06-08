package com.java.page;

import com.java.actions.ActionItem;
import com.java.data.ImagesEnum;
import com.java.utility.IconFactory;
import com.java.utility.PropertyFactory;
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
    this.content.getChildren().addAll(createHBoxContainer(12, new ImageView(IconFactory.getImage(ImagesEnum.TEAM)), createComboBox(FXCollections.observableArrayList("Demo Team 1", "Demo Team 2", "Demo Team 3"))),
        new Separator(),
        createHBoxContainer(12, new ImageView(IconFactory.getImage(ImagesEnum.FILTER)), createComboBox(FXCollections.observableArrayList("Alle"))),
        new Separator(),
        createButton(new ActionItem("Fehler melden", null), new ImageView(IconFactory.getImage(ImagesEnum.REPORT))),
        createButton(new ActionItem("Frage stellen", () -> PropertyFactory.firePropertyChange(TabPages.FRAGEN_PAGE_PROPERTY, null, null)), new ImageView(IconFactory.getImage(ImagesEnum.HELP))),
        createButton(new ActionItem("Vorschlag machen", null), new ImageView(IconFactory.getImage(ImagesEnum.PROPOSAL))),
        new Separator(),
        createButton(new ActionItem("Inbox", () -> PropertyFactory.firePropertyChange(TabPages.INBOX_PAGE_PROPERTY, null, null)), new ImageView(IconFactory.getImage(ImagesEnum.FAQ))),
        createButton(new ActionItem("FAQ", () -> PropertyFactory.firePropertyChange(TabPages.FAQ_PAGE_PROPERTY, null, null)), new ImageView(IconFactory.getImage(ImagesEnum.FAQ)))
    );
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

  private JFXButton createButton(ActionItem actionItem, Node graphic) {
    JFXButton button = new JFXButton(actionItem.getName(), graphic);
    button.setOnAction(event -> actionItem.getRunnable().run());
    button.setMaxWidth(Double.MAX_VALUE);
    button.setAlignment(Pos.CENTER_LEFT);

    return button;
  }

  public Node getContent() {
    return content;
  }
}
