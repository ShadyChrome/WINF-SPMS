package com.java.components;

public class IntegerTextFieldFX {
  private String text;

  public IntegerTextFieldFX(String text) {
    this.text = text;
  }

  public boolean validate(String text) {
    return text.matches("-?(([1-9][0-9]*)|0)?");
  }

  public int getNumberInt() {
    String text = getText();
    return text.isEmpty() ? 0 : Integer.parseInt(text);
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }
}
