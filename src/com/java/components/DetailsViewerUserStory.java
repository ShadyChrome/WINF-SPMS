package com.java.components;

import com.java.data.dto.UserStoryDTO;
import com.java.data.enums.IterationEnum;
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
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;

public class DetailsViewerUserStory extends GridPane {
  private JFXTextField nameTf;
  private JFXTextArea beschreibungTf;
  private DoubleTextField priorityTf;
  private JFXComboBox<SchweregradEnum> severityCb;
  private JFXTextField assigneeTf;
  private JFXTextField teamTf;
  private JFXTextField authorTf;
  private JFXComboBox<IterationEnum> plannedInCb;
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
        plannedInCb.valueProperty().unbindBidirectional(oldUserStory.plannedInProperty());
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
        plannedInCb.getSelectionModel().clearSelection();
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
        plannedInCb.valueProperty().bindBidirectional(newUserStory.plannedInProperty());
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
    severityCb.getStyleClass().add("table-combo-box");
    assigneeTf = new JFXTextField();
    teamTf = new JFXTextField();
    authorTf = new JFXTextField();
    plannedInCb = new JFXComboBox<>(FXCollections.observableArrayList(IterationEnum.values()));
    plannedInCb.getStyleClass().add("table-combo-box");
    estimationTf = new IntegerTextField();
    statusCb = new JFXComboBox<>(FXCollections.observableArrayList(UserStoryStatusEnum.values()));
    statusCb.getStyleClass().add("table-combo-box");

    ColumnConstraints col1 = new ColumnConstraints();
    col1.setPercentWidth(35);
    ColumnConstraints col2 = new ColumnConstraints();
    col2.setPercentWidth(35);
    ColumnConstraints col3 = new ColumnConstraints();
    col3.setPercentWidth(30);
    getColumnConstraints().addAll(col1, col2, col3);

    add(UIFactory.createHBoxContainer(12, 0, UIFactory.createFormularLabel("Titel:"), nameTf), 0, 0);
    add(UIFactory.createHBoxContainer(12, 0, UIFactory.createFormularLabel("Autor:"), authorTf), 1, 0);
    add(UIFactory.createHBoxContainer(12, 0, UIFactory.createFormularLabel("Abschätzung:"), estimationTf), 2, 0);

    add(UIFactory.createHBoxContainer(12, 0, UIFactory.createFormularLabel("Status:"), statusCb), 0, 1);
    add(UIFactory.createHBoxContainer(12, 0, UIFactory.createFormularLabel("Verantwortlicher:"), assigneeTf), 1, 1);

    add(UIFactory.createHBoxContainer(12, 0, UIFactory.createFormularLabel("Schweregrad:"), severityCb), 0, 2);
    add(UIFactory.createHBoxContainer(12, 0, UIFactory.createFormularLabel("Team:"), teamTf), 1, 2);

    add(UIFactory.createHBoxContainer(12, 0, UIFactory.createFormularLabel("Priorität:"), priorityTf), 0, 3);
    add(UIFactory.createHBoxContainer(12, 0, UIFactory.createFormularLabel("Geplant:"), plannedInCb), 1, 3);

    add(UIFactory.createFormularLabel("Beschreibung:"), 0, 4);
    add(beschreibungTf, 0, 5, 3, 2);

    HBox.setHgrow(nameTf, Priority.ALWAYS);
    HBox.setHgrow(authorTf, Priority.ALWAYS);
    HBox.setHgrow(estimationTf, Priority.ALWAYS);
    HBox.setHgrow(statusCb, Priority.ALWAYS);
    HBox.setHgrow(assigneeTf, Priority.ALWAYS);
    HBox.setHgrow(severityCb, Priority.ALWAYS);
    HBox.setHgrow(teamTf, Priority.ALWAYS);
    HBox.setHgrow(priorityTf, Priority.ALWAYS);
    HBox.setHgrow(plannedInCb, Priority.ALWAYS);
    statusCb.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
    severityCb.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
    plannedInCb.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);

  }

  public void setDataModel(DataModelUserStory dataModel) {
    if (this.model != null) {
      this.model.currentUserStoryProperty().removeListener(userStoryChangeListener);
    }
    this.model = dataModel;
    this.model.currentUserStoryProperty().addListener(userStoryChangeListener);
  }
}

