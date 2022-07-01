package com.java.page;

import com.java.controller.DataController;
import com.java.data.dto.TeamMitgliedDTO;
import com.java.utility.PropertyFactory;
import com.java.utility.UIFactory;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.List;

import static com.java.utility.UIFactory.createFormularLabel;
import static com.java.utility.UIFactory.createFormularSubtitle;
import static com.java.utility.UIFactory.createFormularTextArea;
import static com.java.utility.UIFactory.createHBoxContainer;

public class SwotAnalysePage implements TabPages {
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
    Label titleDesc = new Label("Mithilfe der SWOT Analyse könnt ihr eure Stärken und Schwächen, Chancen und Risiken herausarbeiten und daraus Strategien entwickeln. Diese helfen euch im Verlaufe des Projekts Fehler zu vermeiden und euer Potential vollständig ausschöpfen zu können (notiert jeweils Stichpunkte).");
    titleDesc.getStyleClass().add("titledesc");

    JFXTextArea stärkeTa = createFormularTextArea("Hier ausfüllen...");
    JFXTextArea schwächeTa = createFormularTextArea("Hier ausfüllen...");
    JFXTextArea risikoTa = createFormularTextArea("Hier ausfüllen...");
    JFXTextArea chanceTa = createFormularTextArea("Hier ausfüllen...");

    for (TeamMitgliedDTO teamMitgliedDTO : DataController.getINSTANCE().getTeamMitglieder()) {
      for (String stärke : teamMitgliedDTO.getStärke()) {
        stärkeTa.appendText(stärke + "\n");
      }
      for (String schwäche : teamMitgliedDTO.getSchwäche()) {
        schwächeTa.appendText(schwäche + "\n");
      }
    }

    JFXButton button = new JFXButton("Absenden");
    button.getStyleClass().add("form-button");
    button.setOnAction(event -> {
      List<String> risikoList = new ArrayList<>();
      for (String line : risikoTa.getText().split("\\n")) {
        risikoList.add(line);
      }
      DataController.getINSTANCE().addAllRisiken(risikoList);

      List<String> chanceList = new ArrayList<>();
      for (String line : chanceTa.getText().split("\\n")) {
        chanceList.add(line);
      }
      DataController.getINSTANCE().addAllChancen(chanceList);

      PropertyFactory.firePropertyChange(SWOT_PAGE_PROPERTY, null, null);
    });
    HBox absendenContainer = createHBoxContainer(12, 0, button);
    absendenContainer.setAlignment(Pos.CENTER);

    container.getChildren().addAll(title, titleDesc, new Separator(),
        new Label("Ein Blick in eurer Projektteam..."),
        createFormularSubtitle("Stärken"), createFormularLabel("Wo sind eure Stärken als Team? Was sind eure Kernkompetenzen? Was bringt ihr für Erfahrungen mit? Was für Stärken hat jeder Einzelne von euch? Was lief in der Vergangenheit gut?", true),
        new Separator(),
        stärkeTa,
        createFormularSubtitle("Schwächen"), createFormularLabel("Wo sind eure Schwächen? Wo wollt ihr euch noch verbessern? Wobei treten immer wieder Probleme auf?", true),
        new Separator(),
        schwächeTa,
        new Label("Ein Blick nach außen - was könnte euer Projekt positiv oder negativ beeinflussen..."),
        createFormularSubtitle("Chancen"), createFormularLabel("Welche Vorgaben vom Dozenten könnten euren Projekterfolg positiv beeinflussen? Welche (möglichen) Veränderungen unterstützen eure Ideen?", true),
        new Separator(),
        chanceTa,
        createFormularSubtitle("Risiken"), createFormularLabel("Welche Herausforderungen seht ihr für euer Projekt? Seid ihr z.B. zeitlich stark eingespannt oder könnte es vielleicht passieren, dass Projektmitglieder abspringen? Was für Risiken gibt es bezogen auf euer Projektthema? Welche Einschränkungen sind zu erwarten?", true),
        new Separator(),
        risikoTa,
        new Separator(),
        absendenContainer
    );

    return UIFactory.createScrollPane(container);
  }
}
