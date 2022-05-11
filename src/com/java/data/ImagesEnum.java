package com.java.data;

public enum ImagesEnum {
  LOGO("/com/java/resources/images/logo.png"),
  TEAM("/com/java/resources/images/account-group.png"),
  FILTER("/com/java/resources/images/filter.png"),
  REPORT("/com/java/resources/images/alert.png"),
  HELP("/com/java/resources/images/help.png"),
  PROPOSAL("/com/java/resources/images/lightbulb.png"),
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
