package com.java.data.enums;

public enum PersonaEnum {
  STUDENT("Student*in"),
  DOZENT("Dozent*in");

  private String text;

  PersonaEnum(String text) {
    this.text = text;
  }

  @Override
  public String toString() {
    return text;
  }
}
