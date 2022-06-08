package com.java.data;

public enum PersonaEnum {
  STUDENT("Stundent*in"),
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
