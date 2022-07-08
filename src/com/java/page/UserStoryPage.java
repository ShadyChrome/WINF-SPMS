package com.java.page;

import com.java.components.DetailsViewerUserStory;
import com.java.components.TableViewUserStory;
import com.java.controller.DataController;
import com.java.model.DataModelUserStory;
import com.java.utility.UIFactory;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

import static com.java.utility.UIFactory.createHBoxContainer;

public class UserStoryPage implements TabPages {
  @Override
  public Node getLeftNode() {
    return null;
  }

  @Override
  public Node getCenterNode() {
    DataModelUserStory dataModel = new DataModelUserStory();
    TableViewUserStory userStoryTable = new TableViewUserStory();
    userStoryTable.setDataModel(dataModel);
    DetailsViewerUserStory details = new DetailsViewerUserStory();
    details.setDataModel(dataModel);

    final JFXTextField addName = new JFXTextField();
    addName.setPrefWidth(200);
    final JFXButton addButton = new JFXButton("Hinzufügen");
    addButton.getStyleClass().add("form-button");

    addName.setPromptText("User Story...");
    addName.addEventFilter(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() {
      @Override
      public void handle(KeyEvent event) {
        if (event.getCode().equals(KeyCode.ENTER)) {
          addButton.fire();
          event.consume();
        }
      }
    });

    addButton.setOnAction(new EventHandler<ActionEvent>() {
      @Override
      public void handle(ActionEvent event) {
        String text = addName.getText();
        if (!text.isEmpty()) {
          DataController.getINSTANCE().addUserStory(text);
          addName.clear();
        }
      }
    });

    final JFXButton deleteButton = new JFXButton("Löschen");
    deleteButton.getStyleClass().add("form-button");
    deleteButton.setOnAction(new EventHandler<ActionEvent>() {
      @Override
      public void handle(ActionEvent e) {
        Object selectedItem = userStoryTable.getSelectionModel().getSelectedItem();
        userStoryTable.getItems().remove(selectedItem);
      }
    });

    Label title = new Label("User Stories von " + DataController.getINSTANCE().getActiveTeam());
    title.getStyleClass().add("title-formular");

    HBox hBoxContainer = createHBoxContainer(12, 0, addName, addButton, deleteButton);
    hBoxContainer.setAlignment(Pos.CENTER);
    VBox vbox = UIFactory.createFormularVBox(12, title, hBoxContainer, userStoryTable, details);
    VBox.setVgrow(userStoryTable, Priority.ALWAYS);
    details.setAlignment(Pos.CENTER);
    return UIFactory.createScrollPane(vbox);
  }
}
