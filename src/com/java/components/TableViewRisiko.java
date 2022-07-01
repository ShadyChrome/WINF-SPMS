package com.java.components;

import com.java.data.dto.RisikoDTO;
import com.jfoenix.controls.JFXComboBox;
import javafx.beans.binding.Bindings;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;

public class TableViewRisiko extends TableView<RisikoDTO> {
  private TableColumn id;
  private TableColumn<RisikoDTO, String> risikoBeschreibung;
  private TableColumn<RisikoDTO, SimpleStringProperty> eintrittsWahrscheinlichkeit;
  private TableColumn<RisikoDTO, String> auswirkung;
  private TableColumn<RisikoDTO, String> userStory;
  private TableColumn<RisikoDTO, String> massnahmen;

  public TableViewRisiko(ObservableList<RisikoDTO> items) {
    super(items);
    setPlaceholder(new Label());

    setEditable(true);
    getColumns().addAll(createTableColumns());

    setFixedCellSize(36);
    prefHeightProperty().bind(this.fixedCellSizeProperty().multiply(Bindings.size(this.getItems()).add(2.5)));
    minHeightProperty().bind(this.prefHeightProperty());
    maxHeightProperty().bind(this.prefHeightProperty());
  }

  private TableColumn[] createTableColumns() {
    id = new TableColumn("Nr.");
    id.setMinWidth(50);
    id.setCellValueFactory(new Callback<TableColumn.CellDataFeatures, ObservableValue>() {
      @Override
      public ObservableValue call(TableColumn.CellDataFeatures p) {
        return new ReadOnlyObjectWrapper(p.getValue());
      }
    });

    id.setCellFactory(new Callback<TableColumn, TableCell>() {
      @Override
      public TableCell call(TableColumn param) {
        return new TableCell() {
          @Override
          protected void updateItem(Object item, boolean empty) {
            super.updateItem(item, empty);

            if (this.getTableRow() != null && item != null) {
              setText(this.getTableRow().getIndex() + "");
            } else {
              setText("");
            }
          }
        };
      }
    });
    id.setSortable(false);

    risikoBeschreibung = new TableColumn("Risikobeschreibung");
    risikoBeschreibung.setMinWidth(200);
    risikoBeschreibung.setCellValueFactory(new PropertyValueFactory("risikoBeschreibung"));
    risikoBeschreibung.setCellFactory(col -> EditCell.createStringEditCell());
    risikoBeschreibung.setSortable(false);
    risikoBeschreibung.setOnEditCommit(event -> event.getTableView().getItems().get(event.getTablePosition().getRow()).setRisikoBeschreibung(event.getNewValue()));

    eintrittsWahrscheinlichkeit = new TableColumn("Eintrittswahrscheinlichkeit");
    eintrittsWahrscheinlichkeit.setMinWidth(200);
    eintrittsWahrscheinlichkeit.setSortable(false);
    eintrittsWahrscheinlichkeit.setCellValueFactory(i -> {
      final SimpleStringProperty value = i.getValue().eintrittsWahrscheinlichkeitProperty();
      // binding to constant value
      return Bindings.createObjectBinding(() -> value);
    });

    eintrittsWahrscheinlichkeit.setCellFactory(col -> {
      TableCell<RisikoDTO, SimpleStringProperty> c = new TableCell<>();
      ObservableList list = FXCollections.observableArrayList();
      list.addAll("Gering", "Mittel", "Hoch");
      final JFXComboBox comboBox = new JFXComboBox(list);
      comboBox.getStyleClass().add("table-combo-box");
      c.itemProperty().addListener((observable, oldValue, newValue) -> {
        if (oldValue != null) {
          comboBox.valueProperty().unbindBidirectional(oldValue);
        }
        if (newValue != null) {
          comboBox.valueProperty().bindBidirectional(newValue);
        }
      });
      c.graphicProperty().bind(Bindings.when(c.emptyProperty()).then((Node) null).otherwise(comboBox));
      return c;
    });

    auswirkung = new TableColumn("Auswirkung");
    auswirkung.setMinWidth(200);
    auswirkung.setCellValueFactory(new PropertyValueFactory("auswirkung"));
    auswirkung.setCellFactory(col -> EditCell.createStringEditCell());
    auswirkung.setSortable(false);
    auswirkung.setOnEditCommit(event -> event.getTableView().getItems().get(event.getTablePosition().getRow()).setAuswirkung(event.getNewValue()));

    userStory = new TableColumn("User Story");
    userStory.setMinWidth(200);
    userStory.setCellValueFactory(new PropertyValueFactory("userStory"));
    userStory.setCellFactory(col -> EditCell.createStringEditCell());
    userStory.setSortable(false);
    userStory.setOnEditCommit(event -> event.getTableView().getItems().get(event.getTablePosition().getRow()).setUserStory(event.getNewValue()));

    massnahmen = new TableColumn("Maßnamen");
    massnahmen.setMinWidth(200);
    massnahmen.setCellValueFactory(new PropertyValueFactory("massnahmen"));
    massnahmen.setCellFactory(col -> EditCell.createStringEditCell());
    massnahmen.setSortable(false);
    massnahmen.setOnEditCommit(event -> event.getTableView().getItems().get(event.getTablePosition().getRow()).setMassnahmen(event.getNewValue()));

    TableColumn[] columns = {id, risikoBeschreibung, eintrittsWahrscheinlichkeit, auswirkung, userStory, massnahmen};
    return columns;
  }
}
