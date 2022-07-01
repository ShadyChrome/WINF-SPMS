package com.java.components;

import com.java.data.enums.ImagesEnum;
import com.java.data.dto.NachrichtDTO;
import com.java.utility.IconFactory;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTooltip;
import javafx.geometry.Pos;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.image.ImageView;
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
  private JFXButton deleteBtn = new JFXButton();

  public InboxListCell() {
    super();

    vBox.getChildren().addAll(absenderLbl, betreffLbl, nachrichtLbl);
    vBox.setAlignment(Pos.CENTER_LEFT);
    Pane spacer = new Pane();
    root.getChildren().addAll(vBox, spacer, deleteBtn);
    root.setAlignment(Pos.CENTER);
    HBox.setHgrow(spacer, Priority.ALWAYS);
    deleteBtn.setOnAction(event -> getListView().getItems().remove(getItem()));
    deleteBtn.setGraphic(new ImageView(IconFactory.getImage(ImagesEnum.DELETE)));
    deleteBtn.setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
    deleteBtn.setTooltip(new JFXTooltip("Nachricht löschen"));
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
