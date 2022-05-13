package com.java.utility;

import com.java.actions.ActionItem;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXToggleNode;
import javafx.geometry.Point2D;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.KeyEvent;

import java.util.List;

public class UIFactory {

  public static JFXButton createMenuButton(String name, List<ActionItem> list) {
    JFXButton menuButton = new JFXButton(name);
    menuButton.getStyleClass().add("title");
    menuButton.setMaxHeight(Double.MAX_VALUE);

    ContextMenu contextMenu = new ContextMenu();
    contextMenu.addEventHandler(KeyEvent.KEY_PRESSED, event -> event.consume());
    contextMenu.setAutoHide(true);
    contextMenu.setHideOnEscape(true);

    for (ActionItem actionItem : list) {
      MenuItem menuItem = new MenuItem(actionItem.getName());
      menuItem.setOnAction(event -> actionItem.getRunnable().run());
      contextMenu.getItems().add(menuItem);
    }

    contextMenu.getItems().add(new MenuItem("Test"));

    menuButton.setOnAction(event -> {
      if (contextMenu.isShowing()) {
        contextMenu.hide();
      } else {
        final Point2D point2D = menuButton.localToScreen(0.0, 0.0);
        contextMenu.show(menuButton, point2D.getX() + 0, point2D.getY() + menuButton.prefHeight(-1));
      }
    });

    return menuButton;
  }

  public static JFXToggleNode createToggleButton(ToggleGroup toggleGroup, String name, String property) {
    JFXToggleNode toggleNode = new JFXToggleNode(name);
    toggleNode.setMaxHeight(Double.MAX_VALUE);
    toggleNode.setToggleGroup(toggleGroup);
    toggleNode.setOnAction(event -> PropertyFactory.firePropertyChange(property, null, null));
    return toggleNode;
  }
}