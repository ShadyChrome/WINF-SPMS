package com.java.page;

import com.java.components.Card;
import com.java.utility.UIFactory;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class RisikoAnalysePage implements TabPages {
  @Override
  public Node getLeftNode() {
    return null;
  }

  @Override
  public Node getCenterNode() {
    VBox container = new VBox();
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

    container.getChildren().addAll(title, titleDesc, infoBox);
    return UIFactory.createScrollPane(container);
  }
}
