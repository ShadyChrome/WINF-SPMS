package com.java.components;

import com.jfoenix.controls.JFXDatePicker;
import javafx.application.Platform;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class DatePickerCell extends TableCell<Object, LocalDate> {

  private JFXDatePicker datePicker;
  private TableColumn column;

  public DatePickerCell(TableColumn column) { //
    super();

    this.column = column;
    this.datePicker = new JFXDatePicker(getDate());

  }

  @Override
  public void startEdit() {
    if (!isEmpty()) {
      super.startEdit();
      createDatePicker();
      setText(null);
      setGraphic(datePicker);

      Platform.runLater(() -> datePicker.requestFocus());
    }
  }

  @Override
  public void updateItem(LocalDate item, boolean empty) {
    super.updateItem(item, empty);

    if (empty) {
      setText(null);
      setGraphic(null);
    } else {

      if (isEditing()) {
        if (datePicker != null) {
          datePicker.setValue(getItem());
        }
        setText(null);
        setGraphic(datePicker);

      } else {
        setText(getItem().format(DateTimeFormatter.ofPattern("dd.MM.yyyy")));
        setGraphic(null);
      }
    }
  }

  private LocalDate getDate() {
    return getItem() == null ? LocalDate.now() : getItem();
  }

  private void createDatePicker() {
    this.datePicker = new JFXDatePicker(getDate());
    datePicker.setMinWidth(this.getWidth() - this.getGraphicTextGap() * 2);

    this.datePicker.editableProperty().bind(column.editableProperty());
    this.datePicker.disableProperty().bind(column.editableProperty().not());

    this.datePicker.setOnShowing(event -> {

      final TableView tableView = getTableView();
      tableView.getSelectionModel().select(getTableRow().getIndex());
      tableView.edit(tableView.getSelectionModel().getSelectedIndex(), column);


    });

    datePicker.setOnAction((e) -> {
      commitEdit(datePicker.getValue());

      TableColumn nextColumn = getNextColumn(true);

      if (nextColumn != null) {
        getTableView().edit(getTableRow().getIndex(),
            nextColumn);
      }

    });


    datePicker.focusedProperty().addListener(
        (arg0, arg1, arg2) -> {
          if (!arg2) {
            commitEdit(datePicker.getValue());
          }
        });
  }

  @Override
  public void cancelEdit() {
    super.cancelEdit();

    setText(getItem().toString());
    setGraphic(null);
  }

  private String getString() {
    return getItem() == null ? "" : getItem().toString();
  }

  private TableColumn<Object, ?> getNextColumn(boolean forward) {
    List<TableColumn<Object, ?>> columns = new ArrayList<>();
    for (TableColumn<Object, ?> column : getTableView().getColumns()) {
      columns.addAll(getLeaves(column));
    }
    // There is no other column that supports editing.
    if (columns.size() < 2) {
      return null;
    }
    int currentIndex = columns.indexOf(getTableColumn());
    int nextIndex = currentIndex;
    if (forward) {
      nextIndex++;
      if (nextIndex > columns.size() - 1) {
        nextIndex = 0;
      }
    } else {
      nextIndex--;
      if (nextIndex < 0) {
        nextIndex = columns.size() - 1;
      }
    }
    return columns.get(nextIndex);
  }

  private List<TableColumn<Object, ?>> getLeaves(
      TableColumn<Object, ?> root) {
    List<TableColumn<Object, ?>> columns = new ArrayList<>();
    if (root.getColumns().isEmpty()) {
      // We only want the leaves that are editable.
      if (root.isEditable()) {
        columns.add(root);
      }
      return columns;
    } else {
      for (TableColumn<Object, ?> column : root.getColumns()) {
        columns.addAll(getLeaves(column));
      }
      return columns;
    }
  }

}
