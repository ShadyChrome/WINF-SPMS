package com.java.page;

import com.java.data.enums.FragenStyleEnum;
import com.java.utility.UIFactory;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXChipView;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

import static com.java.utility.UIFactory.createHBoxContainer;

public class FragenPage implements TabPages {

  @Override
  public Node getLeftNode() {
    return null;
  }

  @Override
  public Node getCenterNode() {
    Label title = new Label("Nachricht versenden");
    title.setAlignment(Pos.CENTER);
    title.getStyleClass().add("dashboard-title");
    title.setMinWidth(300);

    JFXTextField adressatTf = new JFXTextField();
    HBox adressatContainer = UIFactory.createHBoxContainer(12, 0, UIFactory.createFormularSubtitle("AN:"), adressatTf);
    HBox.setHgrow(adressatTf, Priority.ALWAYS);

    JFXTextField betreffTf = new JFXTextField();
    HBox betreffContainer = UIFactory.createHBoxContainer(12, 0, UIFactory.createFormularSubtitle("Betreff:"), betreffTf);
    HBox.setHgrow(betreffTf, Priority.ALWAYS);

    JFXComboBox<FragenStyleEnum> styleCb = new JFXComboBox(FXCollections.observableArrayList(FragenStyleEnum.values()));
    styleCb.getSelectionModel().selectFirst();
    styleCb.getStyleClass().add("table-combo-box");
    HBox styleContainer = UIFactory.createHBoxContainer(12, 0, UIFactory.createFormularSubtitle("Style:"), styleCb);
    HBox.setHgrow(styleCb, Priority.ALWAYS);

    JFXTextField freiTextTf = new JFXTextField();
    HBox freiTextContainer = UIFactory.createHBoxContainer(12, 0, UIFactory.createFormularSubtitle("Deine Frage:"), freiTextTf);
    freiTextContainer.managedProperty().bind(freiTextContainer.visibleProperty());
    HBox.setHgrow(freiTextTf, Priority.ALWAYS);

    JFXChipView jfxChipView = new JFXChipView();
    jfxChipView.setPromptText("Deine Auswahlmöglichkeiten (mit Enter bestätigen)...");
    jfxChipView.managedProperty().bind(jfxChipView.visibleProperty());
    HBox chipContainer = UIFactory.createHBoxContainer(12, 0, UIFactory.createFormularSubtitle("Optionen (mit Enter bestätigen):"), jfxChipView);
    chipContainer.managedProperty().bind(jfxChipView.visibleProperty());
    chipContainer.setVisible(false);
    HBox.setHgrow(jfxChipView, Priority.ALWAYS);

    JFXButton button = new JFXButton("Absenden");
    button.getStyleClass().add("form-button");
    HBox absendenContainer = createHBoxContainer(12, 0, button);
    absendenContainer.setAlignment(Pos.CENTER);
    button.setOnAction(event -> {
      adressatTf.setText("");
      betreffTf.setText("");
      freiTextTf.setText("");
      jfxChipView.getChips().clear();
    });

    VBox root = UIFactory.createFormularVBox(12, title, adressatContainer, betreffContainer, styleContainer, freiTextContainer, chipContainer, absendenContainer);
    root.setAlignment(Pos.CENTER);

    styleCb.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
      chipContainer.setVisible(newValue == FragenStyleEnum.CHECK_BOX || newValue == FragenStyleEnum.RADIUS_BUTTON);
      jfxChipView.getChips().clear();
    });

    return UIFactory.createScrollPane(root);
  }
}
