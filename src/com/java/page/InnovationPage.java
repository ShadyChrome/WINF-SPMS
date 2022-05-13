package com.java.page;

import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class InnovationPage implements TabPages {

  public Node getLeftNode() {
    VBox vBox = new VBox(new Label("1"), new Label("2"), new Label("3"), new Label("4"));
    vBox.setAlignment(Pos.CENTER);
    return vBox;
  }

  public Node getCenterNode() {
    VBox vBox = new VBox(new Label("A"), new Label("B"), new Label("C"), new Label("D"));
    vBox.setAlignment(Pos.CENTER);
    return vBox;
  }
}