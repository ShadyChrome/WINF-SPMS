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
      new Pair<>("Wann ist das Programm endlich fertig?", "Never :)")));

  public FaqPage() {
    VBox vBox = UIFactory.createFormularVBox();
    vBox.setSpacing(12);

    int i = 1;
    for (Pair<String, String> frageAntwort : faqList) {
      vBox.getChildren().add(new Card(i + ". " + frageAntwort.getKey(), frageAntwort.getValue()));
      i++;
    }

    scrollPane = new ScrollPane(vBox);
    this.scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
    this.scrollPane.setFitToWidth(true);
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
