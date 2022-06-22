package com.java.page;

import com.java.components.Card;
import com.java.components.TableViewRisiko;
import com.java.data.DataController;
import com.java.data.RisikoDTO;
import com.java.utility.UIFactory;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;

public class RisikoAnalysePage implements TabPages {
  private ScrollPane scrollPane;

  @Override
  public Node getLeftNode() {
    return null;
  }

  @Override
  public Node getCenterNode() {
    if (scrollPane == null) {
      VBox container = new VBox();
      scrollPane = UIFactory.createScrollPane(container);
      container.setSpacing(24);
      container.setPadding(new Insets(12));

      Label title = new Label("SWOT-Analyse");
      title.getStyleClass().add("title-formular");
      Label titleDesc = new Label("Nachdem ihr in der SWOT-Analyse bereits erste Risiken eingetragen habt, geht es nun darum alle möglichen Projektrisiken zu betrachten und Maßnahmen zu entwickeln, um diese vermeiden oder vermindern zu können.");
      titleDesc.getStyleClass().add("titledesc");
      titleDesc.setWrapText(true);

      Card infoBox = new Card("Info", "Anleitung: \n1. Risikobeschreibung: Identifiziert Risiken bzw. Szenarien, die möglicherweise euren Projekterfolg negativ beeinflussen könnten.\n" +
          "2. Eintrittswahrscheinlichkeit und Auswirkung:\u000BBewertet eure Risiken. Wie wahrscheinlich ist es, dass dieses Risiko eintritt (gering, mittel oder hoch)? Was für Auswirkungen hat es auf euer Projekt, wenn dieses Risiko eintritt? Ist ggf. sogar das gesamte Projekt gefährdet?\n" +
          "3. Maßnahmen:\u000BEntwickelt möglichen Gegenmaßnahmen. Was könnt ihr aktiv tun, um das Risiko zu vermeiden? Falls es nicht zu vermeiden ist und die Eintrittswahrscheinlichkeit hoch ist, überlegt euch wie ihr die Auswirkungen minimieren könnt. \n");

      TableViewRisiko tableViewRisiko = new TableViewRisiko(DataController.getINSTANCE().getRisikoList());

      final JFXTextField addName = new JFXTextField();
      addName.setPrefWidth(200);
      final JFXButton addButton = new JFXButton("Hinzufügen");
      addButton.getStyleClass().add("form-button");

      addName.setPromptText("Risiko...");
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
            DataController.getINSTANCE().addRisiko(text);
            addName.clear();
          }
        }
      });

      final JFXButton deleteButton = new JFXButton("Löschen");
      deleteButton.getStyleClass().add("form-button");
      deleteButton.setOnAction(new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent e) {
          Object selectedItem = tableViewRisiko.getSelectionModel().getSelectedItem();
          tableViewRisiko.getItems().remove(selectedItem);
        }
      });

      container.getChildren().addAll(title, titleDesc, infoBox, tableViewRisiko);//, UIFactory.createHBoxContainer(12, 0, addName, addButton, deleteButton));
    }

    return scrollPane;
  }
}
