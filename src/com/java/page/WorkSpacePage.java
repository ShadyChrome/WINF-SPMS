package com.java.page;

import com.java.utility.PropertyFactory;
import javafx.scene.Node;
import javafx.scene.layout.BorderPane;

import java.util.LinkedHashMap;
import java.util.Map;

import static com.java.page.TabPages.AS_IS_PAGE_PROPERTY;
import static com.java.page.TabPages.INNOVATION_PAGE_PROPERTY;
import static com.java.page.TabPages.TEAM_MITGLIED_PAGE_PROPERTY;
import static com.java.page.TabPages.TEAM_PAGE_PROPERTY;
import static com.java.page.TabPages.TO_BE_PAGE_PROPERTY;
import static com.java.page.TabPages.TRENDS_PAGE_PROPERTY;

public class WorkSpacePage {

  private Map<String, TabPages> pageMap = new LinkedHashMap<>();
  private BorderPane root;

  public WorkSpacePage() {
    pageMap.put(INNOVATION_PAGE_PROPERTY, new InnovationPage());
    pageMap.put(AS_IS_PAGE_PROPERTY, new AsIsPage());
    pageMap.put(TO_BE_PAGE_PROPERTY, new ToBePage());
    pageMap.put(TRENDS_PAGE_PROPERTY, new TrendsPage());
    pageMap.put(TEAM_MITGLIED_PAGE_PROPERTY, new TeamMitgliedPage());
    pageMap.put(TEAM_PAGE_PROPERTY, new TeamPage());

    this.root = new BorderPane();

    PropertyFactory.addPropertyChangeListener(evt -> {
      TabPages workSpacePage = pageMap.get(evt.getPropertyName());
      if (workSpacePage != null) {
        root.setLeft(workSpacePage.getLeftNode());
        root.setCenter(workSpacePage.getCenterNode());
      }
    });
  }

  public Node getContent() {
    return root;
  }
}
