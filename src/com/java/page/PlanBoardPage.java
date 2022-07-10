package com.java.page;

import com.java.components.TableViewUserStory;
import com.java.controller.DataController;
import com.java.data.dto.TeamDTO;
import com.java.data.dto.UserStoryDTO;
import com.java.data.enums.IterationEnum;
import com.java.utility.UIFactory;
import com.jfoenix.controls.JFXComboBox;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class PlanBoardPage implements TabPages {
  @Override
  public Node getLeftNode() {
    return null;
  }

  @Override
  public Node getCenterNode() {
    if (DataController.getINSTANCE().isDozent()) {
      return getDozentNode();
    } else {
      return getStudentNode();
    }
  }

  private Node getStudentNode() {
    Label title = new Label("Planboard von Team " + DataController.getINSTANCE().getActiveTeam());
    title.getStyleClass().add("title-formular");

    Label ansichtTitle = new Label("Ansicht");
    ansichtTitle.setAlignment(Pos.CENTER);
    ansichtTitle.getStyleClass().add("dashboard-title");
    ansichtTitle.setMinWidth(300);

    ObservableList iterationList = FXCollections.observableArrayList();
    iterationList.add("Alle");
    iterationList.addAll(IterationEnum.values());
    JFXComboBox iterationCb = new JFXComboBox(iterationList);
    iterationCb.setPromptText("Iteration...");
    iterationCb.getStyleClass().add("table-combo-box");

    TableViewUserStory userStoryTable = new TableViewUserStory();
    ObservableList<XYChart.Series<String, Number>> series = FXCollections.observableArrayList();
    ObservableList<XYChart.Data<String, Number>> series1Data = FXCollections.observableArrayList();
    ObservableList<XYChart.Data<String, Number>> series2Data = FXCollections.observableArrayList();
    series.add(new XYChart.Series<>("Ideal Work to Do", series1Data));
    series.add(new XYChart.Series<>("Work to Do", series2Data));

    NumberAxis numberAxis = new NumberAxis("User Story Points", 0, 25, 5);
    ObservableList<String> categories = FXCollections.observableArrayList();

    CategoryAxis dateAxis = new CategoryAxis(categories);
    LineChart lineChart = new LineChart(dateAxis, numberAxis, series);
    lineChart.setTitle("Iteration Burn-down Chart");

    iterationCb.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
      @Override
      public void changed(ObservableValue observable, Object oldValue, Object newValue) {
        if (newValue != oldValue) {
          if (newValue instanceof IterationEnum) {
            ObservableList<UserStoryDTO> filteredUserStoryList = DataController.getINSTANCE().getFilteredUserStoryList(DataController.getINSTANCE().getActiveTeam(), (IterationEnum) newValue);
            userStoryTable.setItems(filteredUserStoryList);
            series1Data.clear();
            series2Data.clear();
            int totalEstimation = 0;

            for (UserStoryDTO userStoryDTO : filteredUserStoryList) {
              totalEstimation = totalEstimation + Integer.parseInt(userStoryDTO.getEstimation());
            }

            if (iterationCb.getValue() == IterationEnum.ITERATION_1) {
              series1Data.add(new XYChart.Data<String, Number>("04.07.22", totalEstimation));
              series1Data.add(new XYChart.Data<String, Number>("05.07.22", totalEstimation));
              series1Data.add(new XYChart.Data<String, Number>("06.07.22", totalEstimation * 0.85));
              series1Data.add(new XYChart.Data<String, Number>("07.07.22", totalEstimation * 0.85));
              series1Data.add(new XYChart.Data<String, Number>("08.07.22", totalEstimation * 0.70));
              series1Data.add(new XYChart.Data<String, Number>("09.07.22", totalEstimation * 0.70));
              series1Data.add(new XYChart.Data<String, Number>("10.07.22", totalEstimation * 0.5));
              series1Data.add(new XYChart.Data<String, Number>("11.07.22", totalEstimation * 0.5));
              series1Data.add(new XYChart.Data<String, Number>("12.07.22", totalEstimation * 0.25));
              series1Data.add(new XYChart.Data<String, Number>("13.07.22", totalEstimation * 0.25));
              series1Data.add(new XYChart.Data<String, Number>("14.07.22", 0));
              series1Data.add(new XYChart.Data<String, Number>("15.07.22", 0));

              series2Data.add(new XYChart.Data<String, Number>("04.07.22", totalEstimation));
              series2Data.add(new XYChart.Data<String, Number>("05.07.22", totalEstimation));
              series2Data.add(new XYChart.Data<String, Number>("06.07.22", totalEstimation));
              series2Data.add(new XYChart.Data<String, Number>("07.07.22", totalEstimation * 0.75));
              series2Data.add(new XYChart.Data<String, Number>("08.07.22", totalEstimation * 0.75));
              series2Data.add(new XYChart.Data<String, Number>("09.07.22", totalEstimation * 0.75));
              series2Data.add(new XYChart.Data<String, Number>("10.07.22", totalEstimation * 0.5));
            } else {
              series1Data.add(new XYChart.Data<String, Number>("18.07.22", totalEstimation));
              series1Data.add(new XYChart.Data<String, Number>("19.07.22", totalEstimation));
              series1Data.add(new XYChart.Data<String, Number>("20.07.22", totalEstimation * 0.85));
              series1Data.add(new XYChart.Data<String, Number>("21.07.22", totalEstimation * 0.85));
              series1Data.add(new XYChart.Data<String, Number>("22.07.22", totalEstimation * 0.70));
              series1Data.add(new XYChart.Data<String, Number>("23.07.22", totalEstimation * 0.70));
              series1Data.add(new XYChart.Data<String, Number>("24.07.22", totalEstimation * 0.5));
              series1Data.add(new XYChart.Data<String, Number>("25.07.22", totalEstimation * 0.5));
              series1Data.add(new XYChart.Data<String, Number>("26.07.22", totalEstimation * 0.25));
              series1Data.add(new XYChart.Data<String, Number>("27.07.22", totalEstimation * 0.25));
              series1Data.add(new XYChart.Data<String, Number>("28.07.22", 0));
              series1Data.add(new XYChart.Data<String, Number>("29.07.22", 0));

              series2Data.add(new XYChart.Data<String, Number>("18.07.22", totalEstimation));

            }
            categories.clear();
            for (XYChart.Data<String, Number> date : series1Data) {
              categories.add(date.getXValue());
            }

            lineChart.setVisible(true);
            lineChart.setManaged(true);
          } else {
            userStoryTable.setItems(DataController.getINSTANCE().getUserStoryList(DataController.getINSTANCE().getActiveTeam()));
            lineChart.setVisible(false);
            lineChart.setManaged(false);
          }
        }
      }
    });

    iterationCb.getSelectionModel().selectFirst();

    VBox formularVBox = UIFactory.createFormularVBox(12, title, UIFactory.createCenteredHBoxContainer(ansichtTitle), UIFactory.createCenteredHBoxContainer(iterationCb), userStoryTable, lineChart);
    return UIFactory.createScrollPane(formularVBox);
  }

  private Node getDozentNode() {
    Label title = new Label("Planboard");
    title.getStyleClass().add("title-formular");

    Label ansichtTitle = new Label("Ansicht");
    ansichtTitle.setAlignment(Pos.CENTER);
    ansichtTitle.getStyleClass().add("dashboard-title");
    ansichtTitle.setMinWidth(300);

    JFXComboBox<TeamDTO> teamCb = new JFXComboBox(DataController.getINSTANCE().getTeamList());
    teamCb.setPromptText("Teams...");
    teamCb.getStyleClass().add("table-combo-box");

    ObservableList iterationList = FXCollections.observableArrayList();
    iterationList.add("Alle");
    iterationList.addAll(IterationEnum.values());
    JFXComboBox iterationCb = new JFXComboBox(iterationList);
    iterationCb.setPromptText("Iteration...");
    iterationCb.getStyleClass().add("table-combo-box");

    TableViewUserStory userStoryTable = new TableViewUserStory();

    ObservableList<XYChart.Series<String, Number>> series = FXCollections.observableArrayList();
    ObservableList<XYChart.Data<String, Number>> series1Data = FXCollections.observableArrayList();
    ObservableList<XYChart.Data<String, Number>> series2Data = FXCollections.observableArrayList();
    series.add(new XYChart.Series<>("Ideal Work to Do", series1Data));
    series.add(new XYChart.Series<>("Work to Do", series2Data));

    NumberAxis numberAxis = new NumberAxis("User Story Points", 0, 25, 5);
    ObservableList<String> categories = FXCollections.observableArrayList();

    CategoryAxis dateAxis = new CategoryAxis(categories);
    LineChart lineChart = new LineChart(dateAxis, numberAxis, series);
    lineChart.setTitle("Iteration Burn-down Chart");

    teamCb.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<TeamDTO>() {
      @Override
      public void changed(ObservableValue<? extends TeamDTO> observable, TeamDTO oldValue, TeamDTO newValue) {
        if (iterationCb.getSelectionModel().isEmpty()) {
          return;
        }

        if (newValue != oldValue) {
          if (iterationCb.getValue() instanceof IterationEnum) {
            ObservableList<UserStoryDTO> filteredUserStoryList = DataController.getINSTANCE().getFilteredUserStoryList(newValue, (IterationEnum) iterationCb.getValue());
            userStoryTable.setItems(filteredUserStoryList);

            series1Data.clear();
            series2Data.clear();
            int totalEstimation = 0;

            for (UserStoryDTO userStoryDTO : filteredUserStoryList) {
              totalEstimation = totalEstimation + Integer.parseInt(userStoryDTO.getEstimation());
            }

            if (iterationCb.getValue() == IterationEnum.ITERATION_1) {
              series1Data.add(new XYChart.Data<String, Number>("04.07.22", totalEstimation));
              series1Data.add(new XYChart.Data<String, Number>("05.07.22", totalEstimation));
              series1Data.add(new XYChart.Data<String, Number>("06.07.22", totalEstimation * 0.85));
              series1Data.add(new XYChart.Data<String, Number>("07.07.22", totalEstimation * 0.85));
              series1Data.add(new XYChart.Data<String, Number>("08.07.22", totalEstimation * 0.70));
              series1Data.add(new XYChart.Data<String, Number>("09.07.22", totalEstimation * 0.70));
              series1Data.add(new XYChart.Data<String, Number>("10.07.22", totalEstimation * 0.5));
              series1Data.add(new XYChart.Data<String, Number>("11.07.22", totalEstimation * 0.5));
              series1Data.add(new XYChart.Data<String, Number>("12.07.22", totalEstimation * 0.25));
              series1Data.add(new XYChart.Data<String, Number>("13.07.22", totalEstimation * 0.25));
              series1Data.add(new XYChart.Data<String, Number>("14.07.22", 0));
              series1Data.add(new XYChart.Data<String, Number>("15.07.22", 0));

              series2Data.add(new XYChart.Data<String, Number>("04.07.22", totalEstimation));
              series2Data.add(new XYChart.Data<String, Number>("05.07.22", totalEstimation));
              series2Data.add(new XYChart.Data<String, Number>("06.07.22", totalEstimation));
              series2Data.add(new XYChart.Data<String, Number>("07.07.22", totalEstimation * 0.75));
              series2Data.add(new XYChart.Data<String, Number>("08.07.22", totalEstimation * 0.75));
              series2Data.add(new XYChart.Data<String, Number>("09.07.22", totalEstimation * 0.75));
              series2Data.add(new XYChart.Data<String, Number>("10.07.22", totalEstimation * 0.5));
            } else {
              series1Data.add(new XYChart.Data<String, Number>("18.07.22", totalEstimation));
              series1Data.add(new XYChart.Data<String, Number>("19.07.22", totalEstimation));
              series1Data.add(new XYChart.Data<String, Number>("20.07.22", totalEstimation * 0.85));
              series1Data.add(new XYChart.Data<String, Number>("21.07.22", totalEstimation * 0.85));
              series1Data.add(new XYChart.Data<String, Number>("22.07.22", totalEstimation * 0.70));
              series1Data.add(new XYChart.Data<String, Number>("23.07.22", totalEstimation * 0.70));
              series1Data.add(new XYChart.Data<String, Number>("24.07.22", totalEstimation * 0.5));
              series1Data.add(new XYChart.Data<String, Number>("25.07.22", totalEstimation * 0.5));
              series1Data.add(new XYChart.Data<String, Number>("26.07.22", totalEstimation * 0.25));
              series1Data.add(new XYChart.Data<String, Number>("27.07.22", totalEstimation * 0.25));
              series1Data.add(new XYChart.Data<String, Number>("28.07.22", 0));
              series1Data.add(new XYChart.Data<String, Number>("29.07.22", 0));

              series2Data.add(new XYChart.Data<String, Number>("18.07.22", totalEstimation));

            }
            categories.clear();
            for (XYChart.Data<String, Number> date : series1Data) {
              categories.add(date.getXValue());
            }

            lineChart.setVisible(true);
            lineChart.setManaged(true);
          } else {
            userStoryTable.setItems(DataController.getINSTANCE().getUserStoryList(teamCb.getValue()));
            lineChart.setVisible(false);
            lineChart.setManaged(false);
          }
        }
      }
    });

    iterationCb.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
      @Override
      public void changed(ObservableValue observable, Object oldValue, Object newValue) {
        if (teamCb.getSelectionModel().isEmpty()) {
          return;
        }
        if (newValue != oldValue) {
          if (newValue instanceof IterationEnum) {
            ObservableList<UserStoryDTO> filteredUserStoryList = DataController.getINSTANCE().getFilteredUserStoryList(teamCb.getValue(), (IterationEnum) newValue);
            userStoryTable.setItems(filteredUserStoryList);

            series1Data.clear();
            series2Data.clear();
            int totalEstimation = 0;

            for (UserStoryDTO userStoryDTO : filteredUserStoryList) {
              totalEstimation = totalEstimation + Integer.parseInt(userStoryDTO.getEstimation());
            }

            if (iterationCb.getValue() == IterationEnum.ITERATION_1) {
              series1Data.add(new XYChart.Data<String, Number>("04.07.22", totalEstimation));
              series1Data.add(new XYChart.Data<String, Number>("05.07.22", totalEstimation));
              series1Data.add(new XYChart.Data<String, Number>("06.07.22", totalEstimation * 0.85));
              series1Data.add(new XYChart.Data<String, Number>("07.07.22", totalEstimation * 0.85));
              series1Data.add(new XYChart.Data<String, Number>("08.07.22", totalEstimation * 0.70));
              series1Data.add(new XYChart.Data<String, Number>("09.07.22", totalEstimation * 0.70));
              series1Data.add(new XYChart.Data<String, Number>("10.07.22", totalEstimation * 0.5));
              series1Data.add(new XYChart.Data<String, Number>("11.07.22", totalEstimation * 0.5));
              series1Data.add(new XYChart.Data<String, Number>("12.07.22", totalEstimation * 0.25));
              series1Data.add(new XYChart.Data<String, Number>("13.07.22", totalEstimation * 0.25));
              series1Data.add(new XYChart.Data<String, Number>("14.07.22", 0));
              series1Data.add(new XYChart.Data<String, Number>("15.07.22", 0));

              series2Data.add(new XYChart.Data<String, Number>("04.07.22", totalEstimation));
              series2Data.add(new XYChart.Data<String, Number>("05.07.22", totalEstimation));
              series2Data.add(new XYChart.Data<String, Number>("06.07.22", totalEstimation));
              series2Data.add(new XYChart.Data<String, Number>("07.07.22", totalEstimation * 0.75));
              series2Data.add(new XYChart.Data<String, Number>("08.07.22", totalEstimation * 0.75));
              series2Data.add(new XYChart.Data<String, Number>("09.07.22", totalEstimation * 0.75));
              series2Data.add(new XYChart.Data<String, Number>("10.07.22", totalEstimation * 0.5));
            } else {
              series1Data.add(new XYChart.Data<String, Number>("18.07.22", totalEstimation));
              series1Data.add(new XYChart.Data<String, Number>("19.07.22", totalEstimation));
              series1Data.add(new XYChart.Data<String, Number>("20.07.22", totalEstimation * 0.85));
              series1Data.add(new XYChart.Data<String, Number>("21.07.22", totalEstimation * 0.85));
              series1Data.add(new XYChart.Data<String, Number>("22.07.22", totalEstimation * 0.70));
              series1Data.add(new XYChart.Data<String, Number>("23.07.22", totalEstimation * 0.70));
              series1Data.add(new XYChart.Data<String, Number>("24.07.22", totalEstimation * 0.5));
              series1Data.add(new XYChart.Data<String, Number>("25.07.22", totalEstimation * 0.5));
              series1Data.add(new XYChart.Data<String, Number>("26.07.22", totalEstimation * 0.25));
              series1Data.add(new XYChart.Data<String, Number>("27.07.22", totalEstimation * 0.25));
              series1Data.add(new XYChart.Data<String, Number>("28.07.22", 0));
              series1Data.add(new XYChart.Data<String, Number>("29.07.22", 0));

              series2Data.add(new XYChart.Data<String, Number>("18.07.22", totalEstimation));
            }
            categories.clear();
            for (XYChart.Data<String, Number> date : series1Data) {
              categories.add(date.getXValue());
            }

            lineChart.setData(series);
            lineChart.setVisible(true);
            lineChart.setManaged(true);
          } else {
            userStoryTable.setItems(DataController.getINSTANCE().getUserStoryList(teamCb.getValue()));
            lineChart.setVisible(false);
            lineChart.setManaged(false);
          }
        }
      }
    });

    teamCb.getSelectionModel().selectFirst();
    iterationCb.getSelectionModel().selectFirst();

    VBox formularVBox = UIFactory.createFormularVBox(12, title, UIFactory.createCenteredHBoxContainer(ansichtTitle), UIFactory.createCenteredHBoxContainer(teamCb, iterationCb), userStoryTable, lineChart);
    return UIFactory.createScrollPane(formularVBox);
  }
}
