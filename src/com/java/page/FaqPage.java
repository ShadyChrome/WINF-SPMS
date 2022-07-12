package com.java.page;

import com.java.components.Card;
import com.java.utility.UIFactory;
import javafx.scene.Node;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FaqPage implements TabPages {

  private ScrollPane scrollPane;
  private List<Pair<String, String>> faqList = new ArrayList<>(Arrays.asList(
      new Pair<>("Wo finde ich die Teamübersicht?", "Im Untermenüpunkt PROJEKT > Team"),
      new Pair<>("Wo finde ich das Teamformular?", "Im Untermenüpunkt INPUT PM > Neues Teammitglied"),
      new Pair<>("Wo kann ich ein neues Dashboard anlegen?", "Im Untermenüpunkt INPUT PM > Neues Dashboard"),
      new Pair<>("Wo kann ich das Dashboard einsehen?", "Im Untermenüpunkt PROJEKT > Dashboard"),
      new Pair<>("Wo kann ich ein neue SWOT Analyse beginnen?", "Im Untermenüpunkt INPUT PM > Neue SWOT Analyse"),
      new Pair<>("Wo ist die SWOT Analyse zu sehen?", "Im Untermenüpunkt PROJEKT > SWOT"),
      new Pair<>("Wo ist die Risikoanalyse?", "Im Untermenüpunkt PROJEKT > Risikoanalyse"),
      new Pair<>("Wo kann ich User Stories erstellen und bearbeiten?", "Im Untermenüpunkt INPUT PM > User Stories"),
      new Pair<>("Wo kann ich die User Stories pro Iteration einsehen?", "Im Untermenüpunkt PROJEKT > Planboard")
      ));

  public FaqPage() {
    VBox vBox = UIFactory.createFormularVBox(12);

    int i = 1;
    for (Pair<String, String> frageAntwort : faqList) {
      vBox.getChildren().add(new Card(i + ". " + frageAntwort.getKey(), frageAntwort.getValue()));
      i++;
    }

    scrollPane = UIFactory.createScrollPane(vBox);
  }

  @Override
  public Node getLeftNode() {
    return null;
  }

  @Override
  public Node getCenterNode() {
    return scrollPane;
  }
}
