package com.java.page;

import com.java.data.FragenStyleEnum;
import com.java.utility.UIFactory;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXChipView;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
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
    JFXTextField adressatTf = UIFactory.createFormularTextField();
    HBox adressatContainer = UIFactory.createHBoxContainer(12, 0, new Label("AN:"), adressatTf);
    HBox.setHgrow(adressatTf, Priority.ALWAYS);

    JFXTextField betreffTf = UIFactory.createFormularTextField();
    HBox betreffContainer = UIFactory.createHBoxContainer(12, 0, new Label("Betreff:"), betreffTf);
    HBox.setHgrow(betreffTf, Priority.ALWAYS);

    JFXComboBox<FragenStyleEnum> styleCb = new JFXComboBox(FXCollections.observableArrayList(FragenStyleEnum.values()));
    styleCb.getSelectionModel().selectFirst();
    HBox styleContainer = UIFactory.createHBoxContainer(12, 0, new Label("Style:"), styleCb);

    JFXTextField freiTextTf = UIFactory.createFormularTextField();
    freiTextTf.setPromptText("Deine Frage...");
    freiTextTf.managedProperty().bind(freiTextTf.visibleProperty());

    JFXChipView jfxChipView = new JFXChipView();
    jfxChipView.setPromptText("Deine Auswahlmöglichkeiten (mit Enter bestätigen)...");
    jfxChipView.managedProperty().bind(jfxChipView.visibleProperty());
    jfxChipView.setVisible(false);

    JFXButton button = new JFXButton("Absenden");
    HBox absendenContainer = createHBoxContainer(12, 0, button);
    absendenContainer.setAlignment(Pos.CENTER);

    VBox root = UIFactory.createFormularVBox(12, adressatContainer, betreffContainer, styleContainer, freiTextTf, jfxChipView, absendenContainer);

    styleCb.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
      jfxChipView.setVisible(newValue == FragenStyleEnum.CHECK_BOX || newValue == FragenStyleEnum.RADIUS_BUTTON);
      jfxChipView.getChips().clear();
    });

    return UIFactory.createScrollPane(root);
  }
}
