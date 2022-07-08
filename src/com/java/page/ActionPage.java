package com.java.page;

import com.java.actions.ActionItem;
import com.java.controller.DataController;
import com.java.data.dto.TeamDTO;
import com.java.data.enums.ImagesEnum;
import com.java.data.enums.PersonaEnum;
import com.java.utility.IconFactory;
import com.java.utility.PropertyFactory;
import com.java.utility.UIFactory;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Separator;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

import static com.java.utility.UIFactory.createHBoxContainer;

public class ActionPage {

  private VBox content;

  public ActionPage() {
    this.content = new VBox();
    this.content.getStyleClass().add("action-page-container");
    this.content.setPrefWidth(200);
    init();
  }

  private void init() {
    Pane spacer = new Pane();
    VBox.setVgrow(spacer, Priority.ALWAYS);
    ChangeListener<PersonaEnum> personaChangeListener = new ChangeListener<PersonaEnum>() {
      @Override
      public void changed(ObservableValue<? extends PersonaEnum> observable, PersonaEnum oldValue, PersonaEnum newValue) {
        if (newValue != oldValue) {
          DataController.getINSTANCE().setActivePersona(newValue);
          PropertyFactory.firePropertyChange(TabPages.PERSONA_CHANGE_PROPERTY, oldValue, newValue);
        }
      }
    };

    ChangeListener<TeamDTO> teamChangeListener = new ChangeListener<TeamDTO>() {
      @Override
      public void changed(ObservableValue<? extends TeamDTO> observable, TeamDTO oldValue, TeamDTO newValue) {
        if (newValue != oldValue) {
          DataController.getINSTANCE().setActiveTeam(newValue);
          PropertyFactory.firePropertyChange(TabPages.TEAM_CHANGE_PROPERTY, oldValue, newValue);
        }
      }
    };
    JFXComboBox<PersonaEnum> personaComboBox = createComboBox(FXCollections.observableArrayList(PersonaEnum.values()), personaChangeListener);

    JFXButton userBtn = createButton(new ActionItem("Admin", null), new ImageView(IconFactory.getImage(ImagesEnum.ACCOUNT)));
    userBtn.setOnAction(event -> {
      String newUserName = UIFactory.showInputDialog("Edit User Name", "User Name:", userBtn.getText());
      if (newUserName != null && !newUserName.isEmpty()) {
        userBtn.setText(newUserName);
        DataController.getINSTANCE().setActiveUser(newUserName);
      }
    });
    DataController.getINSTANCE().setActiveUser(userBtn.getText());

    this.content.getChildren().addAll(createHBoxContainer(0, 12, new ImageView(IconFactory.getImage(ImagesEnum.TEAM)), createComboBox(DataController.getINSTANCE().getTeamList(), teamChangeListener)),
        new Separator(),
        createHBoxContainer(0, 12, new ImageView(IconFactory.getImage(ImagesEnum.FILTER)), createComboBox(FXCollections.observableArrayList("Alle"), null)),
        new Separator(),
        createButton(new ActionItem("Fehler melden", null), new ImageView(IconFactory.getImage(ImagesEnum.REPORT))),
        createButton(new ActionItem("Frage stellen", () -> PropertyFactory.firePropertyChange(TabPages.FRAGEN_PAGE_PROPERTY, null, null)), new ImageView(IconFactory.getImage(ImagesEnum.HELP))),
        createButton(new ActionItem("Vorschlag machen", null), new ImageView(IconFactory.getImage(ImagesEnum.PROPOSAL))),
        new Separator(),
        createButton(new ActionItem("Inbox", () -> PropertyFactory.firePropertyChange(TabPages.INBOX_PAGE_PROPERTY, null, null)), new ImageView(IconFactory.getImage(ImagesEnum.INBOX))),
        createButton(new ActionItem("FAQ", () -> PropertyFactory.firePropertyChange(TabPages.FAQ_PAGE_PROPERTY, null, null)), new ImageView(IconFactory.getImage(ImagesEnum.FAQ))),
        new Separator(),
        spacer,
        new Separator(),
        userBtn,
        createHBoxContainer(0, 12, new ImageView(IconFactory.getImage(ImagesEnum.SCHOOL)), personaComboBox)
    );
    this.content.setSpacing(6);
  }

  private JFXComboBox createComboBox(ObservableList list, ChangeListener changeListener) {
    JFXComboBox<Object> comboBox = new JFXComboBox<>();
    comboBox.setItems(list);
    if (changeListener != null) {
      comboBox.getSelectionModel().selectedItemProperty().addListener(changeListener);
    }
    comboBox.getSelectionModel().selectFirst();
    comboBox.setMaxWidth(Double.MAX_VALUE);
    HBox.setHgrow(comboBox, Priority.ALWAYS);

    return comboBox;
  }

  private JFXButton createButton(ActionItem actionItem, Node graphic) {
    JFXButton button = new JFXButton(actionItem.getName(), graphic);
    button.setGraphicTextGap(12);
    button.setOnAction(event -> {
      if (actionItem.getRunnable() != null) actionItem.getRunnable().run();
    });
    button.setMaxWidth(Double.MAX_VALUE);
    button.setAlignment(Pos.CENTER_LEFT);

    return button;
  }

  public Node getContent() {
    return content;
  }
}
