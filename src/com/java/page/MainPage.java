package com.java.page;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

public class MainPage {

  private BorderPane content;

  public MainPage() {
    this.content = new BorderPane();
    init();
  }

  private void init() {
    content.setTop(new ApplicationBarPage().getContent());
    content.setCenter(new WorkSpacePage().getContent());
  }

  public Pane getContent() {
    return content;
  }
}
