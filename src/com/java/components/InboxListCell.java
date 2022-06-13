package com.java.components;

import com.java.data.NachrichtDTO;
import com.jfoenix.controls.JFXButton;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

public class InboxListCell extends ListCell<NachrichtDTO> {

  private HBox root = new HBox();
  private VBox vBox = new VBox();
  private Label absenderLbl = new Label();
  private Label betreffLbl = new Label();
  private Label nachrichtLbl = new Label();
  private JFXButton deleteBtn = new JFXButton("Löschen");

  public InboxListCell() {
    super();

    vBox.getChildren().addAll(absenderLbl, betreffLbl, nachrichtLbl);
    vBox.setAlignment(Pos.CENTER_LEFT);
    Pane spacer = new Pane();
    root.getChildren().addAll(vBox, spacer, deleteBtn);
    root.setAlignment(Pos.CENTER);
    HBox.setHgrow(spacer, Priority.ALWAYS);
    deleteBtn.setOnAction(event -> getListView().getItems().remove(getItem()));
  }

  @Override
  protected void updateItem(NachrichtDTO item, boolean empty) {
    super.updateItem(item, empty);
    setText(null);
    setGraphic(null);
    if (item != null && !empty) {
      absenderLbl.setText("Von " + item.getAbsender());
      betreffLbl.setText("Betreff: " + item.getBetreff());
      nachrichtLbl.setText(item.getNachricht());
      setGraphic(root);
    }
  }
}
