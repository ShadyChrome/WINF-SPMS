package com.java.page;

import com.java.components.InboxListCell;
import com.java.controller.DataController;
import com.java.data.dto.NachrichtDTO;
import com.java.utility.UIFactory;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXRadioButton;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;

public class InboxPage implements TabPages {
  @Override
  public Node getLeftNode() {
    return null;
  }

  @Override
  public Node getCenterNode() {
    JFXListView<NachrichtDTO> listView = new JFXListView();
    StackPane root = new StackPane(listView);
    listView.setCellFactory(param -> new InboxListCell());

    listView.getItems().addAll(DataController.getINSTANCE().getNachrichten());

    JFXDialog dialog = new JFXDialog(root, null, JFXDialog.DialogTransition.CENTER);

    listView.addEventFilter(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
      @Override
      public void handle(MouseEvent event) {
        if (event.getClickCount() > 1) {
          dialog.setContent(createNachrichtDialog(listView.getSelectionModel().getSelectedItem(), dialog, listView));
          dialog.show();
        }
      }
    });
    return root;
  }

  private Region createNachrichtDialog(NachrichtDTO dto, JFXDialog dialog, JFXListView<NachrichtDTO> listView) {
    Label absenderLbl = UIFactory.createFormularSubtitle("VON: " + dto.getAbsender());

    Label betreffLbl = UIFactory.createFormularLabel("Betreff: " + dto.getBetreff(), true);

    Label frageLbl = UIFactory.createFormularLabel(dto.getNachricht(), true);

    VBox container = UIFactory.createFormularVBox(6);
    VBox root = UIFactory.createFormularVBox(12, absenderLbl, betreffLbl, frageLbl, container);
    root.setMinHeight(300);
    root.setMinWidth(400);
    root.setPadding(new Insets(12));

    List<CheckBox> checkBoxList = new ArrayList<>();
    List<RadioButton> radioList = new ArrayList<>();

    if (!dto.getOptions().isEmpty()) {
      switch (dto.getStyle()) {
        case CHECK_BOX:
          for (String text : dto.getOptions()) {
            JFXCheckBox option = new JFXCheckBox(text);
            checkBoxList.add(option);
            container.getChildren().add(option);
          }
          break;
        case RADIUS_BUTTON:
          ToggleGroup radioGroup = new ToggleGroup();
          for (String text : dto.getOptions()) {
            JFXRadioButton option = new JFXRadioButton(text);
            option.setToggleGroup(radioGroup);
            radioList.add(option);
            container.getChildren().add(option);
          }
          break;
      }
    } else {
      root.getChildren().add(UIFactory.createFormularTextArea("Hier antworten..."));
    }

    JFXCheckBox faqCb = new JFXCheckBox("Zum FAQ hinzuf??gen?");
    faqCb.setCheckedColor(Color.web("rgb(24, 38, 119)"));

    JFXButton replyBtn = new JFXButton("Antworten");
    replyBtn.getStyleClass().add("form-button");
    JFXButton deleteBtn = new JFXButton("L??schen");
    deleteBtn.getStyleClass().add("form-button");

    replyBtn.setOnAction(event -> dialog.close());
    deleteBtn.setOnAction(event -> {
      dialog.close();
      listView.getItems().remove(dto);
    });

    HBox btnContainer = UIFactory.createHBoxContainer(12, 0, replyBtn, deleteBtn);
    btnContainer.setAlignment(Pos.CENTER);
    if (DataController.getINSTANCE().isDozent()) {
      root.getChildren().add(faqCb);
    }
    root.getChildren().add(btnContainer);

    return root;
  }
}
