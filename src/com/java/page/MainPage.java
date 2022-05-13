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
    ApplicationBarPage applicationBarPage = new ApplicationBarPage();
    BorderPane container = new BorderPane();
    container.setTop(applicationBarPage.getContent());
    container.setCenter(new WorkSpacePage().getContent());
    content.setCenter(container);
    content.setRight(new ActionPage().getContent());
    applicationBarPage.init();
  }

  public Pane getContent() {
    return content;
  }
}
