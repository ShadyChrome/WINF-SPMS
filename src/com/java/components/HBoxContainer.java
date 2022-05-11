package com.java.components;

import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.layout.HBox;

public class HBoxContainer extends HBox {

  public HBoxContainer(Node... nodes) {
    super();

    setAlignment(Pos.CENTER_LEFT);
    setSpacing(12);
    getChildren().addAll(nodes);
  }
}
