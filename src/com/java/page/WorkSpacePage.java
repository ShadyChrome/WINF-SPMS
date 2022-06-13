package com.java.page;

import com.java.utility.PropertyFactory;
import javafx.scene.Node;
import javafx.scene.layout.BorderPane;

import java.util.LinkedHashMap;
import java.util.Map;

import static com.java.page.TabPages.AS_IS_PAGE_PROPERTY;
import static com.java.page.TabPages.FAQ_PAGE_PROPERTY;
import static com.java.page.TabPages.FRAGEN_PAGE_PROPERTY;
import static com.java.page.TabPages.INBOX_PAGE_PROPERTY;
import static com.java.page.TabPages.INNOVATION_PAGE_PROPERTY;
import static com.java.page.TabPages.SWOT_ANALYSE_PAGE_PROPERTY;
import static com.java.page.TabPages.SWOT_PAGE_PROPERTY;
import static com.java.page.TabPages.TEAM_MITGLIED_PAGE_PROPERTY;
import static com.java.page.TabPages.TEAM_PAGE_PROPERTY;
import static com.java.page.TabPages.TO_BE_PAGE_PROPERTY;
import static com.java.page.TabPages.TRENDS_PAGE_PROPERTY;

public class WorkSpacePage {

  private Map<String, TabPages> pageMap = new LinkedHashMap<>();
  private BorderPane root;
  private TabPages currentActivePage;

  public WorkSpacePage() {
    pageMap.put(INNOVATION_PAGE_PROPERTY, new InnovationPage());
    pageMap.put(AS_IS_PAGE_PROPERTY, new AsIsPage());
    pageMap.put(TO_BE_PAGE_PROPERTY, new ToBePage());
    pageMap.put(TRENDS_PAGE_PROPERTY, new TrendsPage());
    pageMap.put(TEAM_MITGLIED_PAGE_PROPERTY, new TeamMitgliedPage());
    pageMap.put(TEAM_PAGE_PROPERTY, new TeamPage());
    pageMap.put(FAQ_PAGE_PROPERTY, new FaqPage());
    pageMap.put(FRAGEN_PAGE_PROPERTY, new FragenPage());
    pageMap.put(INBOX_PAGE_PROPERTY, new InboxPage());
    pageMap.put(SWOT_PAGE_PROPERTY, new SwotPage());
    pageMap.put(SWOT_ANALYSE_PAGE_PROPERTY, new SwotAnalysePage());

    this.root = new BorderPane();

    PropertyFactory.addPropertyChangeListener(evt -> {
      TabPages workSpacePage = pageMap.get(evt.getPropertyName());
      if (workSpacePage != null) {
        currentActivePage = workSpacePage;
        root.setLeft(workSpacePage.getLeftNode());
        Node centerNode = workSpacePage.getCenterNode();
        root.setCenter(centerNode);
        centerNode.impl_reapplyCSS();
        centerNode.applyCss();
      }
    });
  }

  public Node getContent() {
    return root;
  }

  public TabPages getCurrentActivePage() {
    return currentActivePage;
  }
}
