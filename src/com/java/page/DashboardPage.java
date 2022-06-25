package com.java.page;

import com.java.utility.UIFactory;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Side;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.util.StringConverter;

public class DashboardPage implements TabPages {
  @Override
  public Node getLeftNode() {
    return null;
  }

  @Override
  public Node getCenterNode() {
    Label gesamtTitle = new Label("Gesamt");
    Label einzelTitle = new Label("Einzelansicht");
    gesamtTitle.getStyleClass().add("dashboard-title");
    einzelTitle.getStyleClass().add("dashboard-title");
    gesamtTitle.setMinWidth(300);
    einzelTitle.setMinWidth(300);
    HBox gesamtTitleContainer = UIFactory.createCenteredHBoxContainer(gesamtTitle);
    HBox einzelTitleContainer = UIFactory.createCenteredHBoxContainer(einzelTitle);

    // x-axis and y-axis  for both charts:
    final CategoryAxis xAxis = new CategoryAxis();
    xAxis.tickLabelFontProperty().set(Font.font(null, FontWeight.BOLD, 12));

    final NumberAxis yAxis1 = new NumberAxis(0, 100, 25);
    yAxis1.setMinorTickVisible(false);
    yAxis1.setTickLabelFormatter(new StringConverter<Number>() {
      @Override
      public String toString(Number object) {
        return object.intValue() + "%";
      }

      @Override
      public Number fromString(String string) {
        return null;
      }
    });

    // first chart:
    final BarChart<Number, String> barChart1 = new BarChart<>(yAxis1, xAxis);
    barChart1.getStyleClass().add("underlay-bar-chart");
    barChart1.setLegendSide(Side.TOP);
    barChart1.setLegendVisible(true);
    barChart1.setAnimated(false);
    barChart1.setAlternativeRowFillVisible(false);
    barChart1.setAlternativeColumnFillVisible(false);
    barChart1.setHorizontalGridLinesVisible(false);
    barChart1.setVerticalGridLinesVisible(false);
    barChart1.getXAxis().setVisible(false);
    barChart1.getYAxis().setVisible(false);
    XYChart.Series series1 = new XYChart.Series();
    series1.setName("Ist");
    series1.getData().add(createData(50, "MINF 1"));
    series1.getData().add(createData(75, "WINF 2"));
    series1.getData().add(createData(50, "WINF 1"));

    // first chart:
    final BarChart<Number, String> barChart2 = new BarChart<>(yAxis1, xAxis);
    barChart2.getStyleClass().add("overlay-bar-chart");
    barChart2.setLegendVisible(true);
    barChart2.setAnimated(false);
    barChart2.setLegendSide(Side.TOP);
    XYChart.Series series2 = new XYChart.Series();
    series2.setName("Soll");
    series2.getData().add(new XYChart.Data(100, "MINF 1"));
    series2.getData().add(new XYChart.Data(100, "WINF 2"));
    series2.getData().add(new XYChart.Data(100, "WINF 1"));

    barChart1.getData().addAll(series1);
    barChart2.getData().addAll(series2);
    StackPane root = new StackPane();
    root.getChildren().addAll(barChart2, barChart1);

    HBox hBoxContainer = UIFactory.createHBoxContainer(12, 0, UIFactory.createFormularVBox(48, gesamtTitleContainer, root), einzelTitleContainer);
    hBoxContainer.setPadding(new Insets(12));
    return hBoxContainer;
  }

  private XYChart.Data createData(double value, String team) {
    XYChart.Data data = new XYChart.Data(value, team);

    String text = value == 25 ? "M1" : value == 50 ? "M2" : value == 75 ? "M3" : "M4";

    StackPane node = new StackPane();
    Label label = new Label(text);
    label.getStyleClass().add("bar-chart-inside-label");
    Group group = new Group(label);
    StackPane.setAlignment(group, Pos.CENTER_RIGHT);
    StackPane.setMargin(group, new Insets(0, 0, 5, 0));
    node.getChildren().add(group);
    data.setNode(node);

    return data;
  }
}
