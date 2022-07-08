package com.java.components;

import com.java.data.dto.MeilensteinDTO;
import com.java.data.enums.AbgabeArtEnum;
import com.java.data.enums.BewertungsArtEnum;
import com.jfoenix.controls.JFXComboBox;
import javafx.beans.binding.Bindings;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.ReadOnlyObjectWrapper;
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

import java.util.Date;

public class TableViewMeilensteine extends TableView<MeilensteinDTO> {
  private TableColumn id;
  private TableColumn<MeilensteinDTO, String> name;
  private TableColumn<MeilensteinDTO, String> beschreibung;
  private TableColumn<MeilensteinDTO, Date> deadline;
  private TableColumn<MeilensteinDTO, ObjectProperty> abgabe;
  private TableColumn<MeilensteinDTO, ObjectProperty> bewertung;

  public TableViewMeilensteine(ObservableList<MeilensteinDTO> items) {
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
    id = new TableColumn("");
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
              setText("M" + (this.getTableRow().getIndex() + 1));
              ((MeilensteinDTO) getTableView().getItems().get(getTableRow().getIndex())).setShortName("M" + this.getTableRow().getIndex());
            } else {
              setText("");
            }
          }
        };
      }
    });
    id.setSortable(false);

    name = new TableColumn("Meilenstein");
    name.setMinWidth(200);
    name.setCellValueFactory(new PropertyValueFactory("name"));
    name.setCellFactory(col -> EditCell.createStringEditCell());
    name.setSortable(false);
    name.setOnEditCommit(event -> event.getTableView().getItems().get(event.getTablePosition().getRow()).setName(event.getNewValue()));

    beschreibung = new TableColumn("Beschreibung");
    beschreibung.setMinWidth(200);
    beschreibung.setCellValueFactory(new PropertyValueFactory("beschreibung"));
    beschreibung.setCellFactory(col -> EditCell.createStringEditCell());
    beschreibung.setSortable(false);
    beschreibung.setOnEditCommit(event -> event.getTableView().getItems().get(event.getTablePosition().getRow()).setBeschreibung(event.getNewValue()));

    deadline = new TableColumn("Deadline");
    deadline.setMinWidth(100);
    deadline.setCellValueFactory(new PropertyValueFactory<>("deadline"));
    Callback cellFactoryDate = (Callback<TableColumn, TableCell>) p -> new DatePickerCell(p);
    deadline.setCellFactory(cellFactoryDate);

    abgabe = new TableColumn("Art der Abgabe");
    abgabe.setMinWidth(200);
    abgabe.setSortable(false);
    abgabe.setCellValueFactory(i -> {
      final ObjectProperty<AbgabeArtEnum> value = i.getValue().abgabeProperty();
      // binding to constant value
      return Bindings.createObjectBinding(() -> value);
    });

    abgabe.setCellFactory(col -> {
      TableCell<MeilensteinDTO, ObjectProperty> c = new TableCell<>();
      ObservableList list = FXCollections.observableArrayList();
      list.addAll(AbgabeArtEnum.values());
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

    bewertung = new TableColumn("Art der Bewertung");
    bewertung.setMinWidth(200);
    bewertung.setSortable(false);
    bewertung.setCellValueFactory(i -> {
      final ObjectProperty<BewertungsArtEnum> value = i.getValue().bewertungProperty();
      // binding to constant value
      return Bindings.createObjectBinding(() -> value);
    });

    bewertung.setCellFactory(col -> {
      TableCell<MeilensteinDTO, ObjectProperty> c = new TableCell<>();
      ObservableList list = FXCollections.observableArrayList();
      list.addAll(BewertungsArtEnum.values());
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

    TableColumn[] columns = {id, name, beschreibung, deadline, abgabe, bewertung};
    return columns;
  }
}
