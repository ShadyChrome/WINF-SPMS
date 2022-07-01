package com.java.data.enums;

public enum UserStoryStatusEnum {
  DRAFT("Draft"),
  ACCEPTED("Akzeptiert"),
  STARTED("Gestartet"),
  IN_PROGRESS("Laufend"),
  READY_FOR_TEST("Testbar"),
  COMPLETED("Abgeschlossen"),
  FAILED("Fehlgeschlagen")
  ;

  private String name;

  UserStoryStatusEnum(String name) {
    this.name = name;
  }


  @Override
  public String toString() {
    return name;
  }
}
