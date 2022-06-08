package com.java.data;

public enum FragenStyleEnum {
  FREI_TEXT("Frei Text"),
  CHECK_BOX("Multiple Choice"),
  RADIUS_BUTTON("Single Choice");

  private String text;

  FragenStyleEnum(String text) {
    this.text = text;
  }

  public String getText() {
    return text;
  }


  @Override
  public String toString() {
    return text;
  }
}
