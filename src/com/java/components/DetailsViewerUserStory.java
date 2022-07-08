package com.java.components;

import com.java.data.dto.UserStoryDTO;
import com.java.data.enums.SchweregradEnum;
import com.java.data.enums.UserStoryStatusEnum;
import com.java.model.DataModelUserStory;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.scene.layout.GridPane;

public class DetailsViewerUserStory extends GridPane {
  private IntegerTextField idTf;
  private JFXTextField nameTf;
  private JFXTextField beschreibungTf;
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
        idTf.textProperty().unbindBidirectional(oldUserStory.idProperty());
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
        idTf.clear();
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
        idTf.textProperty().bindBidirectional(oldUserStory.idProperty());
        nameTf.textProperty().bindBidirectional(oldUserStory.nameProperty());
        beschreibungTf.textProperty().bindBidirectional(oldUserStory.beschreibungProperty());
        priorityTf.textProperty().bindBidirectional(oldUserStory.prioritätProperty());
        severityCb.valueProperty().bindBidirectional(oldUserStory.severityProperty());
        assigneeTf.textProperty().bindBidirectional(oldUserStory.assigneeProperty());
        teamTf.textProperty().bindBidirectional(oldUserStory.teamProperty());
        authorTf.textProperty().bindBidirectional(oldUserStory.authorProperty());
        plannedInTf.textProperty().bindBidirectional(oldUserStory.plannedInProperty());
        estimationTf.textProperty().bindBidirectional(oldUserStory.estimationProperty());
        statusCb.valueProperty().bindBidirectional(oldUserStory.statusProperty());
      }
    }
  };

  public DetailsViewerUserStory() {
    super();

    setHgap(12);
    setVgap(12);

    idTf = new IntegerTextField();
    nameTf = new JFXTextField();
    beschreibungTf = new IntegerTextField();
    priorityTf = new DoubleTextField();
    severityCb = new JFXComboBox<>(FXCollections.observableArrayList(SchweregradEnum.values()));
    assigneeTf = new JFXTextField();
    teamTf = new JFXTextField();
    authorTf = new JFXTextField();
    plannedInTf = new JFXTextField();
    estimationTf = new IntegerTextField();
    statusCb = new JFXComboBox<>(FXCollections.observableArrayList(UserStoryStatusEnum.values()));
  }


  public void setDataModel(DataModelUserStory dataModel) {
    if (this.model != null) {
      this.model.currentUserStoryProperty().removeListener(userStoryChangeListener);
    }
    this.model = dataModel;
    this.model.currentUserStoryProperty().addListener(userStoryChangeListener);
  }
}

