package com.java.components;

import com.java.data.dto.UserStoryDTO;
import com.java.model.DataModelUserStory;
import javafx.beans.binding.Bindings;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class TableViewUserStory extends TableView<UserStoryDTO> {
  private TableColumn id;
  private TableColumn<UserStoryDTO, String> name;
  private TableColumn<UserStoryDTO, String> priorität;
  private TableColumn<UserStoryDTO, String> severity;
  private TableColumn<UserStoryDTO, String> assignee;
  private TableColumn<UserStoryDTO, String> team;
  private TableColumn<UserStoryDTO, String> status;
  private TableColumn<UserStoryDTO, String> estimation;

  private DataModelUserStory model;

  public TableViewUserStory() {
    setPlaceholder(new Label());

    setEditable(false);
    getColumns().addAll(createTableColumns());

    setFixedCellSize(36);
    prefHeightProperty().bind(this.fixedCellSizeProperty().multiply(Bindings.size(this.getItems()).add(10)));
    minHeightProperty().bind(this.prefHeightProperty());
    maxHeightProperty().bind(this.prefHeightProperty());
  }

  private TableColumn[] createTableColumns() {
    id = new TableColumn("Id");
    id.setMinWidth(50);
    id.setCellValueFactory(new PropertyValueFactory("id"));

    name = new TableColumn("Name");
    name.setMinWidth(200);
    name.setCellValueFactory(new PropertyValueFactory("name"));

    priorität = new TableColumn("Priorität");
    priorität.setMinWidth(100);
    priorität.setCellValueFactory(new PropertyValueFactory("priorität"));

    severity = new TableColumn("Schweregrad");
    severity.setMinWidth(150);
    severity.setCellValueFactory(new PropertyValueFactory("severity"));

    assignee = new TableColumn("Verantwortlicher");
    assignee.setMinWidth(150);
    assignee.setCellValueFactory(new PropertyValueFactory("assignee"));

    team = new TableColumn("Team");
    team.setMinWidth(100);
    team.setCellValueFactory(new PropertyValueFactory("team"));

    status = new TableColumn("Status");
    status.setMinWidth(150);
    status.setCellValueFactory(new PropertyValueFactory("status"));

    estimation = new TableColumn("Abschätzung");
    estimation.setMinWidth(50);
    estimation.setCellValueFactory(new PropertyValueFactory("estimation"));

    TableColumn[] tableColumns = {id, name, status, assignee, team, priorität, severity, estimation};

    return tableColumns;
  }

  public void setDataModel(DataModelUserStory dataModel) {
    if (model != null) {
      model.currentUserStoryProperty().unbind();
    }

    this.model = dataModel;
    dataModel.currentUserStoryProperty().bind(this.getSelectionModel().selectedItemProperty());
    this.setItems(model.getUserStories());
  }
}
