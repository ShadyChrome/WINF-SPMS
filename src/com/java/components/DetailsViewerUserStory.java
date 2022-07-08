package com.java.components;

import com.java.data.dto.UserStoryDTO;
import com.java.data.enums.SchweregradEnum;
import com.java.data.enums.UserStoryStatusEnum;
import com.java.model.DataModelUserStory;
import com.java.utility.UIFactory;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.scene.layout.GridPane;

public class DetailsViewerUserStory extends GridPane {
  private JFXTextField nameTf;
  private JFXTextArea beschreibungTf;
  private DoubleTextField priorityTf;
  private JFXComboBox<SchweregradEnum> severityCb;
  private JFXTextField assigneeTf;
  private JFXTextField teamTf;
  private JFXTextField authorTf;
  private JFXTextField plannedInTf;
  private IntegerTextField estimationTf;
  private JFXComboBox<UserStoryStatusEnum> statusCb;

  private DataModelUserStory model;

  private ChangeListener<UserStoryDTO> userStoryChangeListener = new ChangeListener<UserStoryDTO>() {
    @Override
    public void changed(ObservableValue<? extends UserStoryDTO> observable, UserStoryDTO oldUserStory, UserStoryDTO newUserStory) {
      if (oldUserStory != null) {
        nameTf.textProperty().unbindBidirectional(oldUserStory.nameProperty());
        beschreibungTf.textProperty().unbindBidirectional(oldUserStory.beschreibungProperty());
        priorityTf.textProperty().unbindBidirectional(oldUserStory.prioritätProperty());
        severityCb.valueProperty().unbindBidirectional(oldUserStory.severityProperty());
        assigneeTf.textProperty().unbindBidirectional(oldUserStory.assigneeProperty());
        teamTf.textProperty().unbindBidirectional(oldUserStory.teamProperty());
        authorTf.textProperty().unbindBidirectional(oldUserStory.authorProperty());
        plannedInTf.textProperty().unbindBidirectional(oldUserStory.plannedInProperty());
        estimationTf.textProperty().unbindBidirectional(oldUserStory.estimationProperty());
        statusCb.valueProperty().unbindBidirectional(oldUserStory.statusProperty());
      }

      if (newUserStory == null) {
        nameTf.clear();
        beschreibungTf.clear();
        priorityTf.clear();
        severityCb.getSelectionModel().clearSelection();
        assigneeTf.clear();
        teamTf.clear();
        authorTf.clear();
        plannedInTf.clear();
        estimationTf.clear();
        statusCb.getSelectionModel().clearSelection();

      } else {
        nameTf.textProperty().bindBidirectional(newUserStory.nameProperty());
        beschreibungTf.textProperty().bindBidirectional(newUserStory.beschreibungProperty());
        priorityTf.textProperty().bindBidirectional(newUserStory.prioritätProperty());
        severityCb.valueProperty().bindBidirectional(newUserStory.severityProperty());
        assigneeTf.textProperty().bindBidirectional(newUserStory.assigneeProperty());
        teamTf.textProperty().bindBidirectional(newUserStory.teamProperty());
        authorTf.textProperty().bindBidirectional(newUserStory.authorProperty());
        plannedInTf.textProperty().bindBidirectional(newUserStory.plannedInProperty());
        estimationTf.textProperty().bindBidirectional(newUserStory.estimationProperty());
        statusCb.valueProperty().bindBidirectional(newUserStory.statusProperty());
      }
    }
  };

  public DetailsViewerUserStory() {
    super();

    setHgap(12);
    setVgap(12);

    nameTf = new JFXTextField();
    beschreibungTf = new JFXTextArea();
    priorityTf = new DoubleTextField();
    severityCb = new JFXComboBox<>(FXCollections.observableArrayList(SchweregradEnum.values()));
    assigneeTf = new JFXTextField();
    teamTf = new JFXTextField();
    authorTf = new JFXTextField();
    plannedInTf = new JFXTextField();
    estimationTf = new IntegerTextField();
    statusCb = new JFXComboBox<>(FXCollections.observableArrayList(UserStoryStatusEnum.values()));

    add(UIFactory.createCenteredHBoxContainer(UIFactory.createFormularLabel("Titel: "), nameTf), 0, 0);
    add(UIFactory.createCenteredHBoxContainer(UIFactory.createFormularLabel("Author: "), authorTf), 1, 0);
    add(UIFactory.createCenteredHBoxContainer(UIFactory.createFormularLabel("Abschätzung: "),estimationTf), 2, 0);

    add(UIFactory.createCenteredHBoxContainer(UIFactory.createFormularLabel("Status: "),statusCb), 0, 1);
    add(UIFactory.createCenteredHBoxContainer(UIFactory.createFormularLabel("Verantwortlicher: "),assigneeTf), 1, 1);

    add(UIFactory.createCenteredHBoxContainer(UIFactory.createFormularLabel("Schweregrad: "),severityCb), 0, 2);
    add(UIFactory.createCenteredHBoxContainer(UIFactory.createFormularLabel("Team: "),teamTf), 1, 2);

    add(UIFactory.createCenteredHBoxContainer(UIFactory.createFormularLabel("Priorität: "),priorityTf), 0, 3);
    add(UIFactory.createCenteredHBoxContainer(UIFactory.createFormularLabel("Geplant in: "),plannedInTf), 1, 3);

    add(UIFactory.createFormularLabel("Beschreibung"), 0, 4, 3, 1);
    add(beschreibungTf, 0, 5, 3, 2);
  }

  public void setDataModel(DataModelUserStory dataModel) {
    if (this.model != null) {
      this.model.currentUserStoryProperty().removeListener(userStoryChangeListener);
    }
    this.model = dataModel;
    this.model.currentUserStoryProperty().addListener(userStoryChangeListener);
  }
}

