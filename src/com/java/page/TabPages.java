package com.java.page;

import javafx.scene.Node;

public interface TabPages {
  String INNOVATION_PAGE_PROPERTY = "innovation_page_property";
  String AS_IS_PAGE_PROPERTY = "as_is__page_property";
  String TO_BE_PAGE_PROPERTY = "to_be_page_property";
  String TRENDS_PAGE_PROPERTY = "trends_page_property";
  String TEAM_MITGLIED_PAGE_PROPERTY = "team_mitglied_page_property";
  String TEAM_PAGE_PROPERTY = "team_page_property";
  String NEW_TEAM_MEMBER_PROPERTY = "new_team_member_property";
  String FAQ_PAGE_PROPERTY = "faq_page_property";
  String FRAGEN_PAGE_PROPERTY = "fragen_page_property";
  String INBOX_PAGE_PROPERTY = "inbox_page_property";
  String SWOT_PAGE_PROPERTY = "swot_page_property";
  String SWOT_ANALYSE_PAGE_PROPERTY = "swot_analyse_page_property";
  String RISOKO_ANALYSE_PAGE_PROPERTY = "risiko_analyse_page_property";

  Node getLeftNode();

  Node getCenterNode();

  default void update() {};
}
