package com.java.components;

import com.jfoenix.controls.JFXTextField;

public class IntegerTextField extends JFXTextField {

  @Override
  public void replaceText(int start, int end, String text) {
    if (validate(text)) {
      super.replaceText(start, end, text);
    }
  }

  @Override
  public void replaceSelection(String text) {
    if (validate(text)) {
      super.replaceSelection(text);
    }
  }

  public boolean validate(String text) {
    return text.matches("-?(([1-9][0-9]*)|0)?");
  }

  public int getNumberInt() {
    String text = getText();

    return text.isEmpty() ? 0 : Integer.parseInt(text);
  }

  public void setTextAsIntegerNumber(int i) {
    setText(String.valueOf(i));
  }

  public void setTextAsDoubleNumber(double i) {
    setText(String.valueOf(i));
  }
}

