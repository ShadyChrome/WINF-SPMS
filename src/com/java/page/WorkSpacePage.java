package com.java.page;

import javafx.scene.Node;
import javafx.scene.layout.BorderPane;

public class WorkSpacePage {

  private BorderPane root;

  public WorkSpacePage() {
    this.root = new BorderPane();
    this.root.setRight(new ActionPage().getContent());
  }

  public Node getContent() {
    return root;
  }
}
