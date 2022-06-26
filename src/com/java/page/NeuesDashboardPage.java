package com.java.page;

import com.java.components.TableViewMeilensteine;
import com.java.data.DataController;
import com.java.data.MeilensteinDTO;
import com.java.data.TeamDTO;
import com.java.utility.UIFactory;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;

import static com.java.utility.UIFactory.createHBoxContainer;

public class NeuesDashboardPage implements TabPages {

  @Override
  public Node getLeftNode() {
    return null;
  }

  @Override
  public Node getCenterNode() {
    JFXTextField projektZielTf = UIFactory.createFormularTextField();
    HBox projektZielContainer = UIFactory.createHBoxContainer(12, 0, UIFactory.createFormularSubtitle("1. Projektziel festlegen"), projektZielTf);
    Label meilensteineLabel = UIFactory.createFormularSubtitle("2. Meilensteine definieren");

    TableViewMeilensteine tableViewMeilensteine = new TableViewMeilensteine(DataController.getINSTANCE().getMeilensteinList());
    final JFXTextField addName = new JFXTextField();
    addName.setPrefWidth(200);
    final JFXButton addButton = new JFXButton("Hinzufügen");
    addButton.getStyleClass().add("form-button");

    addName.setPromptText("Meilenstein...");
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
          DataController.getINSTANCE().addMeilenstein(text);
          addName.clear();
        }
      }
    });

    final JFXButton deleteButton = new JFXButton("Löschen");
    deleteButton.getStyleClass().add("form-button");
    deleteButton.setOnAction(new EventHandler<ActionEvent>() {
      @Override
      public void handle(ActionEvent e) {
        Object selectedItem = tableViewMeilensteine.getSelectionModel().getSelectedItem();
        tableViewMeilensteine.getItems().remove(selectedItem);
      }
    });

    HBox addDeleteContainer = createHBoxContainer(12, 0, addName, addButton, deleteButton);

    JFXComboBox<TeamDTO> teamCb = new JFXComboBox(DataController.getINSTANCE().getTeamList());
    teamCb.getStyleClass().add("table-combo-box");
    HBox assignTeamContainer = UIFactory.createHBoxContainer(12, 0, UIFactory.createFormularSubtitle("3. Auf Gruppe anwenden"), teamCb);

    JFXButton button = new JFXButton("Absenden");
    button.getStyleClass().add("form-button");
    HBox absendenContainer = createHBoxContainer(12, 0, button);
    absendenContainer.setAlignment(Pos.CENTER);

    button.setOnAction(event -> {
      for (MeilensteinDTO meilensteinDTO : DataController.getINSTANCE().getMeilensteinList()) {
        meilensteinDTO.setProjekt(projektZielTf.getText());
        teamCb.getSelectionModel().getSelectedItem().addMeilenstein(meilensteinDTO);
      }
    });

    return UIFactory.createScrollPane(UIFactory.createFormularVBox(12,
        projektZielContainer,
        meilensteineLabel,
        tableViewMeilensteine,
        addDeleteContainer,
        assignTeamContainer,
        absendenContainer
        ));
  }
}
