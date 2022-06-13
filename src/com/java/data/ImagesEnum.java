package com.java.data;

public enum ImagesEnum {
  LOGO("/com/java/resources/images/logo.png"),
  TEAM("/com/java/resources/images/account-group.png"),
  FILTER("/com/java/resources/images/filter.png"),
  REPORT("/com/java/resources/images/alert.png"),
  HELP("/com/java/resources/images/help.png"),
  PROPOSAL("/com/java/resources/images/lightbulb.png"),
  MIMOSA("/com/java/resources/images/mimosa.png"),
  LINH("/com/java/resources/images/linh.png"),
  LISA("/com/java/resources/images/lisa.png"),
  PLUS("/com/java/resources/images/plus.png"),
  MINUS("/com/java/resources/images/minus.png"),
  PFOTE("/com/java/resources/images/pfote.png"),
  FILM("/com/java/resources/images/film.png"),
  SUPERKRAFT("/com/java/resources/images/superkraft.png"),
  DEFAULT("/com/java/resources/images/default.jpg"),
  ARROW_OPEN("/com/java/resources/images/arrow-open.png"),
  FAQ("/com/java/resources/images/faq.png"),
  INBOX("/com/java/resources/images/inbox.png"),
  ACCOUNT("/com/java/resources/images/account.png"),
  SCHOOL("/com/java/resources/images/school.png"),
  DELETE("/com/java/resources/images/delete.png"),
  ;

  private final String path;

  ImagesEnum(String path) {
    this.path = path;
  }

  public String getPath() {
    return path;
  }

  @Override
  public String toString() {
    String s = super.toString();
    return s.substring(0, 1).toUpperCase() + s.substring(1).toLowerCase();
  }
}
