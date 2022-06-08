package com.java.utility;

import com.java.actions.ActionItem;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXToggleNode;
import javafx.embed.swing.SwingFXUtils;
import javafx.geometry.Point2D;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.awt.image.BufferedImage;
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

  public static Label createFormularSubtitle(String text) {
    Label label = new Label(text);
    label.getStyleClass().add("subtitle-formular");
    return label;
  }

  public static Label createFormularLabel(String text) {
    return createFormularLabel(text, false);
  }

  public static Label createFormularLabel(String text, boolean wrapText) {
    Label label = new Label(text);
    label.setWrapText(wrapText);
    label.getStyleClass().add("labelText");
    return label;
  }

  public static Label createFormularHilfeLabel(String text) {
    Label label = new Label(text);
    label.getStyleClass().add("labelTextHilfe");
    return label;
  }

  public static HBox createHBoxContainer(double spacing, Node... nodes) {
    HBox hBox = new HBox(spacing, nodes);
    hBox.setAlignment(Pos.CENTER_LEFT);
    return hBox;
  }

  public static VBox createFormularVBox(double spacing, Node... nodes) {
    return new VBox(spacing, nodes);
  }

  public static JFXTextArea createFormularTextArea(String promptText) {
    JFXTextArea textArea = new JFXTextArea();
    textArea.setPromptText(promptText);
    return textArea;
  }

  public static JFXTextField createFormularTextField() {
    JFXTextField textField = new JFXTextField();
    textField.getStyleClass().add("formular-text-field");
    return textField;
  }

  public static ScrollPane createScrollPane(Node content) {
    ScrollPane scrollPane = new ScrollPane();
    scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
    scrollPane.setFitToWidth(true);
    scrollPane.setContent(content);
    return scrollPane;
  }

  public ImageView createRandomImageView() {
    // Image file dimensions
    int width = 48, height = 48;

    // Create buffered image object
    BufferedImage img = null;
    img = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

    // create random values pixel by pixel
    for (int y = 0; y < height; y++) {
      for (int x = 0; x < width; x++) {
        // generating values less than 256
        int a = (int) (Math.random() * 256);
        int r = (int) (Math.random() * 256);
        int g = (int) (Math.random() * 256);
        int b = (int) (Math.random() * 256);

        //pixel
        int p = (a << 24) | (r << 16) | (g << 8) | b;

        img.setRGB(x, y, p);
      }
    }

    return new ImageView(SwingFXUtils.toFXImage(img, null));
  }
}