package com.java.components;

import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class DoubleTextField extends IntegerTextField {

  public DoubleTextField() {
    addEventFilter(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() {
      @Override
      public void handle(KeyEvent event) {
        if (event.getCode() == KeyCode.COMMA || event.getCode() == KeyCode.DECIMAL) {
          appendText(".");
          event.consume();
        }
      }
    });
  }

  public boolean validate(String text) {
    return text.matches("-?(([1-9][0-9]*)|0)?(\\.[0-9]*)?");
  }
}
