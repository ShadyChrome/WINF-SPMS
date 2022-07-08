package com.java.components;

import com.java.data.dto.UserStoryDTO;
import javafx.beans.binding.Bindings;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class TableViewUserStory extends TableView<UserStoryDTO> {
  private TableColumn<UserStoryDTO, String> id;
  private TableColumn<UserStoryDTO, String> name;
  private TableColumn<UserStoryDTO, String> priorität;
  private TableColumn<UserStoryDTO, String> severity;
  private TableColumn<UserStoryDTO, String> assignee;
  private TableColumn<UserStoryDTO, String> team;
  private TableColumn<UserStoryDTO, String> status;

  public TableViewUserStory(ObservableList<UserStoryDTO> items) {
    super(items);
    setPlaceholder(new Label());

    setEditable(false);
    getColumns().addAll(createTableColumns());

    setFixedCellSize(36);
    prefHeightProperty().bind(this.fixedCellSizeProperty().multiply(Bindings.size(this.getItems()).add(2.5)));
    minHeightProperty().bind(this.prefHeightProperty());
    maxHeightProperty().bind(this.prefHeightProperty());
  }

  private TableColumn[] createTableColumns() {
    id = new TableColumn("Id");
    id.setMinWidth(40);
    id.setCellValueFactory(new PropertyValueFactory("id"));

    name = new TableColumn("Name");
    name.setMinWidth(150);
    name.setCellValueFactory(new PropertyValueFactory("name"));

    priorität = new TableColumn("Priorität");
    priorität.setMinWidth(40);
    priorität.setCellValueFactory(new PropertyValueFactory("priorität"));

    severity = new TableColumn("Schweregrad");
    severity.setMinWidth(40);
    severity.setCellValueFactory(new PropertyValueFactory("severity"));

    assignee = new TableColumn("Verantwortlicher");
    assignee.setMinWidth(40);
    assignee.setCellValueFactory(new PropertyValueFactory("assignee"));

    team = new TableColumn("Team");
    team.setMinWidth(40);
    team.setCellValueFactory(new PropertyValueFactory("team"));

    status = new TableColumn("Status");
    status.setMinWidth(40);
    status.setCellValueFactory(new PropertyValueFactory("status"));

    TableColumn[] tableColumns = {id, name, status, assignee, team, priorität, severity};

    return tableColumns;
  }
}
