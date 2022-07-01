package com.java.page;

import com.java.controller.DataController;
import com.java.data.dto.MeilensteinDTO;
import com.java.data.dto.TeamDTO;
import com.java.utility.UIFactory;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXComboBox;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Side;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Control;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.FileChooser;
import javafx.util.Pair;
import javafx.util.StringConverter;

import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DashboardPage implements TabPages {

  private Map<String, Integer> teamMap = new HashMap();

  {
    teamMap.put("WINF1", 50);
    teamMap.put("WINF2", 70);
    teamMap.put("MINF1", 60);
  }

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
    Label gesamtTitle = new Label("Gesamt");
    gesamtTitle.getStyleClass().add("dashboard-title");
    gesamtTitle.setMinWidth(300);

    Label aktionTitle = new Label("Aktion " + DataController.getINSTANCE().getActiveUser());
    aktionTitle.getStyleClass().add("dashboard-title");
    aktionTitle.setMinWidth(300);

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
    barChart1.setMaxHeight(150);
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
    String team = DataController.getINSTANCE().getActiveTeam().toString();
    series1.getData().add(createData(teamMap.get(team), team));

    // first chart:
    final BarChart<Number, String> barChart2 = new BarChart<>(yAxis1, xAxis);
    barChart2.setMaxHeight(150);
    barChart2.getStyleClass().add("overlay-bar-chart");
    barChart2.setLegendVisible(true);
    barChart2.setAnimated(false);
    barChart2.setLegendSide(Side.TOP);
    XYChart.Series series2 = new XYChart.Series();
    series2.setName("Soll");
    series2.getData().add(new XYChart.Data(100, team));

    barChart1.getData().addAll(series1);
    barChart2.getData().addAll(series2);

    StackPane root = new StackPane();
    root.getChildren().addAll(barChart2, barChart1);

    GridPane gridEinzel = new GridPane();

    ColumnConstraints col1 = new ColumnConstraints();
    col1.setPercentWidth(35);
    ColumnConstraints col2 = new ColumnConstraints();
    col2.setPercentWidth(10);
    ColumnConstraints col3 = new ColumnConstraints();
    col3.setPercentWidth(10);
    ColumnConstraints col4 = new ColumnConstraints();
    col4.setPercentWidth(10);
    ColumnConstraints col5 = new ColumnConstraints();
    col5.setPercentWidth(10);
    ColumnConstraints col6 = new ColumnConstraints();
    col6.setPercentWidth(25);
    gridEinzel.getColumnConstraints().addAll(col1, col2, col3, col4, col5, col6);

    RowConstraints row1 = new RowConstraints();
    row1.setPrefHeight(48);
    RowConstraints row2 = new RowConstraints();
    row2.setPrefHeight(48);
    RowConstraints row3 = new RowConstraints();
    row3.setPrefHeight(48);
    RowConstraints row4 = new RowConstraints();
    row4.setPrefHeight(48);
    RowConstraints row5 = new RowConstraints();
    row5.setPrefHeight(48);
    RowConstraints row6 = new RowConstraints();
    row6.setPrefHeight(48);
    RowConstraints row7 = new RowConstraints();
    row7.setPrefHeight(48);
    gridEinzel.getRowConstraints().addAll(row1, row2, row3, row4, row5, row6, row7);

    Label placeHolder = new Label();
    Label m1 = new Label("M1");
    Label m2 = new Label("M2");
    Label m3 = new Label("M3");
    Label m4 = new Label("M4");
    Label fortschritt = new Label("Fortschritt");

    placeHolder.getStyleClass().add("grid-top-left-item");
    m1.getStyleClass().add("grid-top-item");
    m2.getStyleClass().add("grid-top-item");
    m3.getStyleClass().add("grid-top-item");
    m4.getStyleClass().add("grid-top-item");
    fortschritt.getStyleClass().add("grid-top-right-item");

    gridEinzel.add(placeHolder, 0, 0);
    gridEinzel.add(m1, 1, 0);
    gridEinzel.add(m2, 2, 0);
    gridEinzel.add(m3, 3, 0);
    gridEinzel.add(m4, 4, 0);
    gridEinzel.add(fortschritt, 5, 0);

    Label mitgliedLabel1 = new Label();
    Label mitgliedLabel2 = new Label();
    Label mitgliedLabel3 = new Label();
    Label mitgliedLabel4 = new Label();
    Label mitgliedLabel5 = new Label();

    mitgliedLabel1.setPrefWidth(200);
    mitgliedLabel1.setMaxWidth(200);
    mitgliedLabel2.setPrefWidth(200);
    mitgliedLabel2.setMaxWidth(200);
    mitgliedLabel3.setPrefWidth(200);
    mitgliedLabel3.setMaxWidth(200);
    mitgliedLabel4.setPrefWidth(200);
    mitgliedLabel4.setMaxWidth(200);
    mitgliedLabel5.setPrefWidth(200);
    mitgliedLabel5.setMaxWidth(200);

    mitgliedLabel1.setWrapText(true);
    mitgliedLabel2.setWrapText(true);
    mitgliedLabel3.setWrapText(true);
    mitgliedLabel4.setWrapText(true);
    mitgliedLabel5.setWrapText(true);

    mitgliedLabel1.getStyleClass().add("grid-left-item");
    mitgliedLabel2.getStyleClass().add("grid-left-item");
    mitgliedLabel3.getStyleClass().add("grid-left-item");
    mitgliedLabel4.getStyleClass().add("grid-left-item");
    mitgliedLabel5.getStyleClass().add("grid-bottom-left-item");

    gridEinzel.add(mitgliedLabel1, 0, 1);
    gridEinzel.add(mitgliedLabel2, 0, 2);
    gridEinzel.add(mitgliedLabel3, 0, 3);
    gridEinzel.add(mitgliedLabel4, 0, 4);
    gridEinzel.add(mitgliedLabel5, 0, 5);

    Label m1Label1 = new Label();
    Label m1Label2 = new Label();
    Label m1Label3 = new Label();
    Label m1Label4 = new Label();
    Label m1Label5 = new Label();
    m1Label5.getStyleClass().add("grid-bottom-item");

    gridEinzel.add(m1Label1, 1, 1);
    gridEinzel.add(m1Label2, 1, 2);
    gridEinzel.add(m1Label3, 1, 3);
    gridEinzel.add(m1Label4, 1, 4);
    gridEinzel.add(m1Label5, 1, 5);

    Label m2Label1 = new Label();
    Label m2Label2 = new Label();
    Label m2Label3 = new Label();
    Label m2Label4 = new Label();
    Label m2Label5 = new Label();
    m2Label5.getStyleClass().add("grid-bottom-item");

    gridEinzel.add(m2Label1, 2, 1);
    gridEinzel.add(m2Label2, 2, 2);
    gridEinzel.add(m2Label3, 2, 3);
    gridEinzel.add(m2Label4, 2, 4);
    gridEinzel.add(m2Label5, 2, 5);

    Label m3Label1 = new Label();
    Label m3Label2 = new Label();
    Label m3Label3 = new Label();
    Label m3Label4 = new Label();
    Label m3Label5 = new Label();
    m3Label5.getStyleClass().add("grid-bottom-item");

    gridEinzel.add(m3Label1, 3, 1);
    gridEinzel.add(m3Label2, 3, 2);
    gridEinzel.add(m3Label3, 3, 3);
    gridEinzel.add(m3Label4, 3, 4);
    gridEinzel.add(m3Label5, 3, 5);

    Label m4Label1 = new Label();
    Label m4Label2 = new Label();
    Label m4Label3 = new Label();
    Label m4Label4 = new Label();
    Label m4Label5 = new Label();
    m4Label5.getStyleClass().add("grid-bottom-item");

    gridEinzel.add(m4Label1, 4, 1);
    gridEinzel.add(m4Label2, 4, 2);
    gridEinzel.add(m4Label3, 4, 3);
    gridEinzel.add(m4Label4, 4, 4);
    gridEinzel.add(m4Label5, 4, 5);

    Label fortschritt1 = new Label();
    Label fortschritt2 = new Label();
    Label fortschritt3 = new Label();
    Label fortschritt4 = new Label();
    Label fortschritt5 = new Label();
    fortschritt1.getStyleClass().add("grid-right-item");
    fortschritt2.getStyleClass().add("grid-right-item");
    fortschritt3.getStyleClass().add("grid-right-item");
    fortschritt4.getStyleClass().add("grid-right-item");
    fortschritt5.getStyleClass().add("grid-bottom-right-item");

    gridEinzel.add(fortschritt1, 5, 1);
    gridEinzel.add(fortschritt2, 5, 2);
    gridEinzel.add(fortschritt3, 5, 3);
    gridEinzel.add(fortschritt4, 5, 4);
    gridEinzel.add(fortschritt5, 5, 5);

    Label teamleistung = new Label("Teamleistung");
    teamleistung.getStyleClass().add("grid-left-item");
    gridEinzel.add(teamleistung, 0, 6);
    Label fortschrittGesamt = new Label();
    fortschrittGesamt.getStyleClass().add("grid-right-item");
    gridEinzel.add(fortschrittGesamt, 5, 6);

    for (Node n : gridEinzel.getChildren()) {
      if (n instanceof Control) {
        Control control = (Control) n;
        control.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
      }
      if (n instanceof Pane) {
        Pane pane = (Pane) n;
        pane.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
      }
    }
    TeamDTO newValue = DataController.getINSTANCE().getActiveTeam();
    mitgliedLabel1.setText(newValue.getMitglieder().get(0));
    mitgliedLabel2.setText(newValue.getMitglieder().get(1));
    mitgliedLabel3.setText(newValue.getMitglieder().get(2));
    mitgliedLabel4.setText(newValue.getMitglieder().get(3));
    mitgliedLabel5.setText(newValue.getMitglieder().get(4));

    ObservableList<List<String>> exampleFortschritt = newValue.toString().contains("MINF") ? DataController.getINSTANCE().getExampleFortschrittMINF1() :
        newValue.toString().contains("2") ? DataController.getINSTANCE().getExampleFortschrittWINF2() : DataController.getINSTANCE().getExampleFortschrittWINF1();
    String gesamtFortschritt = newValue.toString().contains("MINF") ? DataController.getINSTANCE().getExampleGesamtFortschrittMINF1() :
        newValue.toString().contains("2") ? DataController.getINSTANCE().getExampleGesamtFortschrittWINF2() : DataController.getINSTANCE().getExampleGesamtFortschrittWINF1();

    m1Label1.setText(exampleFortschritt.get(0).get(0));
    m2Label1.setText(exampleFortschritt.get(0).get(1));
    m3Label1.setText(exampleFortschritt.get(0).get(2));
    m4Label1.setText(exampleFortschritt.get(0).get(3));
    fortschritt1.setText(exampleFortschritt.get(0).get(4));

    m1Label2.setText(exampleFortschritt.get(1).get(0));
    m2Label2.setText(exampleFortschritt.get(1).get(1));
    m3Label2.setText(exampleFortschritt.get(1).get(2));
    m4Label2.setText(exampleFortschritt.get(1).get(3));
    fortschritt2.setText(exampleFortschritt.get(1).get(4));

    m1Label3.setText(exampleFortschritt.get(2).get(0));
    m2Label3.setText(exampleFortschritt.get(2).get(1));
    m3Label3.setText(exampleFortschritt.get(2).get(2));
    m4Label3.setText(exampleFortschritt.get(2).get(3));
    fortschritt3.setText(exampleFortschritt.get(2).get(4));

    m1Label4.setText(exampleFortschritt.get(3).get(0));
    m2Label4.setText(exampleFortschritt.get(3).get(1));
    m3Label4.setText(exampleFortschritt.get(3).get(2));
    m4Label4.setText(exampleFortschritt.get(3).get(3));
    fortschritt4.setText(exampleFortschritt.get(3).get(4));

    m1Label5.setText(exampleFortschritt.get(4).get(0));
    m2Label5.setText(exampleFortschritt.get(4).get(1));
    m3Label5.setText(exampleFortschritt.get(4).get(2));
    m4Label5.setText(exampleFortschritt.get(4).get(3));
    fortschritt5.setText(exampleFortschritt.get(4).get(4));
    fortschrittGesamt.setText(gesamtFortschritt);

    GridPane gridAktion = new GridPane();

    ColumnConstraints colAbgabe1 = new ColumnConstraints();
    colAbgabe1.setPercentWidth(5);
    ColumnConstraints colAbgabe2 = new ColumnConstraints();
    colAbgabe2.setPercentWidth(20);
    ColumnConstraints colAbgabe3 = new ColumnConstraints();
    colAbgabe3.setPercentWidth(20);
    ColumnConstraints colAbgabe4 = new ColumnConstraints();
    colAbgabe4.setPercentWidth(10);
    ColumnConstraints colAbgabe5 = new ColumnConstraints();
    colAbgabe5.setPercentWidth(15);
    ColumnConstraints colAbgabe6 = new ColumnConstraints();
    colAbgabe6.setPercentWidth(20);
    ColumnConstraints colAbgabe7 = new ColumnConstraints();
    colAbgabe7.setPercentWidth(10);
    gridAktion.getColumnConstraints().addAll(colAbgabe1, colAbgabe2, colAbgabe3, colAbgabe4, colAbgabe5, colAbgabe6, colAbgabe7);

    RowConstraints rowAbgabe1 = new RowConstraints();
    rowAbgabe1.setPrefHeight(48);
    RowConstraints rowAbgabe2 = new RowConstraints();
    rowAbgabe2.setPrefHeight(48);
    RowConstraints rowAbgabe3 = new RowConstraints();
    rowAbgabe3.setPrefHeight(48);
    RowConstraints rowAbgabe4 = new RowConstraints();
    rowAbgabe4.setPrefHeight(48);
    RowConstraints rowAbgabe5 = new RowConstraints();
    rowAbgabe5.setPrefHeight(48);
    gridAktion.getRowConstraints().addAll(rowAbgabe1, rowAbgabe2, rowAbgabe3, rowAbgabe4, rowAbgabe5);

    Label placeHolderAktion = new Label("");
    Label meilenstein = new Label("Meilenstein");
    Label beschreibung = new Label("Beschreibung");
    Label deadline = new Label("Deadline");
    Label aktion = new Label("Aktion");
    Label abgabe = new Label("Abgabe");
    Label datumAbgabe = new Label("Datum\nhochgeladen");

    placeHolderAktion.getStyleClass().add("grid-top-left-item");
    meilenstein.getStyleClass().add("grid-top-item");
    beschreibung.getStyleClass().add("grid-top-item");
    deadline.getStyleClass().add("grid-top-item");
    aktion.getStyleClass().add("grid-top-item");
    abgabe.getStyleClass().add("grid-top-item");
    datumAbgabe.getStyleClass().add("grid-top-right-item");

    Label m1Aktion = new Label(DataController.getINSTANCE().getMeilensteinList().get(0).getShortName());
    Label m2Aktion = new Label(DataController.getINSTANCE().getMeilensteinList().get(1).getShortName());
    Label m3Aktion = new Label(DataController.getINSTANCE().getMeilensteinList().get(2).getShortName());
    Label m4Aktion = new Label(DataController.getINSTANCE().getMeilensteinList().get(3).getShortName());

    m1Aktion.getStyleClass().add("grid-left-item");
    m2Aktion.getStyleClass().add("grid-left-item");
    m3Aktion.getStyleClass().add("grid-left-item");
    m4Aktion.getStyleClass().add("grid-bottom-left-item");

    Label meilenstein1 = new Label(DataController.getINSTANCE().getMeilensteinList().get(0).getName());
    Label meilenstein2 = new Label(DataController.getINSTANCE().getMeilensteinList().get(1).getName());
    Label meilenstein3 = new Label(DataController.getINSTANCE().getMeilensteinList().get(2).getName());
    Label meilenstein4 = new Label(DataController.getINSTANCE().getMeilensteinList().get(3).getName());
    meilenstein4.getStyleClass().add("grid-bottom-item");

    Label beschreibung1 = new Label(DataController.getINSTANCE().getMeilensteinList().get(0).getBeschreibung());
    Label beschreibung2 = new Label(DataController.getINSTANCE().getMeilensteinList().get(1).getBeschreibung());
    Label beschreibung3 = new Label(DataController.getINSTANCE().getMeilensteinList().get(2).getBeschreibung());
    Label beschreibung4 = new Label(DataController.getINSTANCE().getMeilensteinList().get(3).getBeschreibung());
    beschreibung4.getStyleClass().add("grid-bottom-item");

    Label deadline1 = new Label(DataController.getINSTANCE().getMeilensteinList().get(0).getDeadline().format(DateTimeFormatter.ofPattern("dd.MM.yyyy")));
    Label deadline2 = new Label(DataController.getINSTANCE().getMeilensteinList().get(1).getDeadline().format(DateTimeFormatter.ofPattern("dd.MM.yyyy")));
    Label deadline3 = new Label(DataController.getINSTANCE().getMeilensteinList().get(2).getDeadline().format(DateTimeFormatter.ofPattern("dd.MM.yyyy")));
    Label deadline4 = new Label(DataController.getINSTANCE().getMeilensteinList().get(3).getDeadline().format(DateTimeFormatter.ofPattern("dd.MM.yyyy")));
    deadline4.getStyleClass().add("grid-bottom-item");

    Label abgabe1 = new Label();
    Label abgabe2 = new Label();
    Label abgabe3 = new Label();
    Label abgabe4 = new Label();
    abgabe4.getStyleClass().add("grid-bottom-item");

    Label datumAbgabe1 = new Label();
    Label datumAbgabe2 = new Label();
    Label datumAbgabe3 = new Label();
    Label datumAbgabe4 = new Label();
    datumAbgabe1.getStyleClass().add("grid-right-item");
    datumAbgabe2.getStyleClass().add("grid-right-item");
    datumAbgabe3.getStyleClass().add("grid-right-item");
    datumAbgabe4.getStyleClass().add("grid-bottom-right-item");

    gridAktion.add(placeHolderAktion, 0, 0);
    gridAktion.add(meilenstein, 1, 0);
    gridAktion.add(beschreibung, 2, 0);
    gridAktion.add(deadline, 3, 0);
    gridAktion.add(aktion, 4, 0);
    gridAktion.add(abgabe, 5, 0);
    gridAktion.add(datumAbgabe, 6, 0);

    gridAktion.add(m1Aktion, 0, 1);
    gridAktion.add(m2Aktion, 0, 2);
    gridAktion.add(m3Aktion, 0, 3);
    gridAktion.add(m4Aktion, 0, 4);

    gridAktion.add(meilenstein1, 1, 1);
    gridAktion.add(meilenstein2, 1, 2);
    gridAktion.add(meilenstein3, 1, 3);
    gridAktion.add(meilenstein4, 1, 4);

    gridAktion.add(beschreibung1, 2, 1);
    gridAktion.add(beschreibung2, 2, 2);
    gridAktion.add(beschreibung3, 2, 3);
    gridAktion.add(beschreibung4, 2, 4);

    gridAktion.add(deadline1, 3, 1);
    gridAktion.add(deadline2, 3, 2);
    gridAktion.add(deadline3, 3, 3);
    gridAktion.add(deadline4, 3, 4);

    gridAktion.add(abgabe1, 5, 1);
    gridAktion.add(abgabe2, 5, 2);
    gridAktion.add(abgabe3, 5, 3);
    gridAktion.add(abgabe4, 5, 4);

    gridAktion.add(datumAbgabe1, 6, 1);
    gridAktion.add(datumAbgabe2, 6, 2);
    gridAktion.add(datumAbgabe3, 6, 3);
    gridAktion.add(datumAbgabe4, 6, 4);

    Label placeHolderBottomLeft = new Label();
    placeHolderBottomLeft.getStyleClass().add("grid-left-item");
    Label placeHolderBottomRight = new Label();
    placeHolderBottomRight.getStyleClass().add("grid-right-item");
    gridAktion.add(placeHolderBottomLeft, 0, 5);
    gridAktion.add(placeHolderBottomRight, 6, 5);

    for (int i = 0; i < DataController.getINSTANCE().getMeilensteinList().size(); i++) {
      final int index = i;
      switch (DataController.getINSTANCE().getMeilensteinList().get(i).getAbgabe()) {
        case FREITEXT:
        case LINK:
          JFXButton button = new JFXButton("Antworten...");
          gridAktion.add(button, 4, i + 1);
          if (i == 3) {
            button.getStyleClass().add("grid-bottom-item");
          }

          button.setOnAction(event -> {
            String antwort = UIFactory.showInputDialog("Abgabe als Freitext/Link", "Antwort:", "");
            if (antwort != null && !antwort.isEmpty()) {
              if (index == 0) {
                abgabe1.setText(antwort);
                datumAbgabe1.setText(LocalDate.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy")));
              } else if (index == 1) {
                abgabe2.setText(antwort);
                datumAbgabe2.setText(LocalDate.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy")));
              } else if (index == 2) {
                abgabe3.setText(antwort);
                datumAbgabe3.setText(LocalDate.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy")));
              } else if (index == 3) {
                abgabe4.setText(antwort);
                datumAbgabe4.setText(LocalDate.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy")));
              }
            }
          });
          break;
        case UPLOAD:
          JFXButton buttonDatei = new JFXButton("Datei hochladen...");
          gridAktion.add(buttonDatei, 4, i + 1);
          if (i == 3) {
            buttonDatei.getStyleClass().add("grid-bottom-item");
          }
          buttonDatei.setOnAction(event -> {
            FileChooser fileChooser = new FileChooser();
            File file = fileChooser.showOpenDialog(DataController.getINSTANCE().getPrimaryStage().getOwner());
            if (file != null) {
              if (index == 0) {
                abgabe1.setText(file.getName());
                datumAbgabe1.setText(LocalDate.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy")));
              } else if (index == 1) {
                abgabe2.setText(file.getName());
                datumAbgabe2.setText(LocalDate.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy")));
              } else if (index == 2) {
                abgabe3.setText(file.getName());
                datumAbgabe3.setText(LocalDate.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy")));
              } else if (index == 3) {
                abgabe4.setText(file.getName());
                datumAbgabe4.setText(LocalDate.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy")));
              }
            }
          });
          break;
      }
    }

    for (Node n : gridAktion.getChildren()) {
      if (n instanceof Control) {
        Control control = (Control) n;
        control.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
      }
      if (n instanceof Pane) {
        Pane pane = (Pane) n;
        pane.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
      }
    }

    VBox gesamtContainer = UIFactory.createFormularVBox(48, gesamtTitle, root, gridEinzel, aktionTitle, gridAktion);
    gesamtContainer.setAlignment(Pos.TOP_CENTER);
    return UIFactory.createScrollPane(gesamtContainer);
  }

  private Node getDozentNode() {
    Label gesamtTitle = new Label("Gesamt");
    Label einzelTitle = new Label("Einzelansicht");
    gesamtTitle.getStyleClass().add("dashboard-title");
    einzelTitle.getStyleClass().add("dashboard-title");
    gesamtTitle.setMinWidth(300);
    einzelTitle.setMinWidth(300);

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
    series1.getData().add(createData(60, "MINF 1"));
    series1.getData().add(createData(70, "WINF 2"));
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

    GridPane gridEinzel = new GridPane();

    ColumnConstraints col1 = new ColumnConstraints();
    col1.setPercentWidth(35);
    ColumnConstraints col2 = new ColumnConstraints();
    col2.setPercentWidth(10);
    ColumnConstraints col3 = new ColumnConstraints();
    col3.setPercentWidth(10);
    ColumnConstraints col4 = new ColumnConstraints();
    col4.setPercentWidth(10);
    ColumnConstraints col5 = new ColumnConstraints();
    col5.setPercentWidth(10);
    ColumnConstraints col6 = new ColumnConstraints();
    col6.setPercentWidth(25);
    gridEinzel.getColumnConstraints().addAll(col1, col2, col3, col4, col5, col6);

    RowConstraints row1 = new RowConstraints();
    row1.setPrefHeight(48);
    RowConstraints row2 = new RowConstraints();
    row2.setPrefHeight(48);
    RowConstraints row3 = new RowConstraints();
    row3.setPrefHeight(48);
    RowConstraints row4 = new RowConstraints();
    row4.setPrefHeight(48);
    RowConstraints row5 = new RowConstraints();
    row5.setPrefHeight(48);
    RowConstraints row6 = new RowConstraints();
    row6.setPrefHeight(48);
    RowConstraints row7 = new RowConstraints();
    row7.setPrefHeight(48);
    gridEinzel.getRowConstraints().addAll(row1, row2, row3, row4, row5, row6, row7);

    Label placeHolder = new Label();
    Label m1 = new Label("M1");
    Label m2 = new Label("M2");
    Label m3 = new Label("M3");
    Label m4 = new Label("M4");
    Label fortschritt = new Label("Fortschritt");

    placeHolder.getStyleClass().add("grid-top-left-item");
    m1.getStyleClass().add("grid-top-item");
    m2.getStyleClass().add("grid-top-item");
    m3.getStyleClass().add("grid-top-item");
    m4.getStyleClass().add("grid-top-item");
    fortschritt.getStyleClass().add("grid-top-right-item");

    gridEinzel.add(placeHolder, 0, 0);
    gridEinzel.add(m1, 1, 0);
    gridEinzel.add(m2, 2, 0);
    gridEinzel.add(m3, 3, 0);
    gridEinzel.add(m4, 4, 0);
    gridEinzel.add(fortschritt, 5, 0);

    Label mitgliedLabel1 = new Label();
    Label mitgliedLabel2 = new Label();
    Label mitgliedLabel3 = new Label();
    Label mitgliedLabel4 = new Label();
    Label mitgliedLabel5 = new Label();

    mitgliedLabel1.setPrefWidth(200);
    mitgliedLabel1.setMaxWidth(200);
    mitgliedLabel2.setPrefWidth(200);
    mitgliedLabel2.setMaxWidth(200);
    mitgliedLabel3.setPrefWidth(200);
    mitgliedLabel3.setMaxWidth(200);
    mitgliedLabel4.setPrefWidth(200);
    mitgliedLabel4.setMaxWidth(200);
    mitgliedLabel5.setPrefWidth(200);
    mitgliedLabel5.setMaxWidth(200);

    mitgliedLabel1.setWrapText(true);
    mitgliedLabel2.setWrapText(true);
    mitgliedLabel3.setWrapText(true);
    mitgliedLabel4.setWrapText(true);
    mitgliedLabel5.setWrapText(true);

    mitgliedLabel1.getStyleClass().add("grid-left-item");
    mitgliedLabel2.getStyleClass().add("grid-left-item");
    mitgliedLabel3.getStyleClass().add("grid-left-item");
    mitgliedLabel4.getStyleClass().add("grid-left-item");
    mitgliedLabel5.getStyleClass().add("grid-bottom-left-item");

    gridEinzel.add(mitgliedLabel1, 0, 1);
    gridEinzel.add(mitgliedLabel2, 0, 2);
    gridEinzel.add(mitgliedLabel3, 0, 3);
    gridEinzel.add(mitgliedLabel4, 0, 4);
    gridEinzel.add(mitgliedLabel5, 0, 5);

    Label m1Label1 = new Label();
    Label m1Label2 = new Label();
    Label m1Label3 = new Label();
    Label m1Label4 = new Label();
    Label m1Label5 = new Label();
    m1Label5.getStyleClass().add("grid-bottom-item");

    gridEinzel.add(m1Label1, 1, 1);
    gridEinzel.add(m1Label2, 1, 2);
    gridEinzel.add(m1Label3, 1, 3);
    gridEinzel.add(m1Label4, 1, 4);
    gridEinzel.add(m1Label5, 1, 5);

    Label m2Label1 = new Label();
    Label m2Label2 = new Label();
    Label m2Label3 = new Label();
    Label m2Label4 = new Label();
    Label m2Label5 = new Label();
    m2Label5.getStyleClass().add("grid-bottom-item");

    gridEinzel.add(m2Label1, 2, 1);
    gridEinzel.add(m2Label2, 2, 2);
    gridEinzel.add(m2Label3, 2, 3);
    gridEinzel.add(m2Label4, 2, 4);
    gridEinzel.add(m2Label5, 2, 5);

    Label m3Label1 = new Label();
    Label m3Label2 = new Label();
    Label m3Label3 = new Label();
    Label m3Label4 = new Label();
    Label m3Label5 = new Label();
    m3Label5.getStyleClass().add("grid-bottom-item");

    gridEinzel.add(m3Label1, 3, 1);
    gridEinzel.add(m3Label2, 3, 2);
    gridEinzel.add(m3Label3, 3, 3);
    gridEinzel.add(m3Label4, 3, 4);
    gridEinzel.add(m3Label5, 3, 5);

    Label m4Label1 = new Label();
    Label m4Label2 = new Label();
    Label m4Label3 = new Label();
    Label m4Label4 = new Label();
    Label m4Label5 = new Label();
    m4Label5.getStyleClass().add("grid-bottom-item");

    gridEinzel.add(m4Label1, 4, 1);
    gridEinzel.add(m4Label2, 4, 2);
    gridEinzel.add(m4Label3, 4, 3);
    gridEinzel.add(m4Label4, 4, 4);
    gridEinzel.add(m4Label5, 4, 5);

    Label fortschritt1 = new Label();
    Label fortschritt2 = new Label();
    Label fortschritt3 = new Label();
    Label fortschritt4 = new Label();
    Label fortschritt5 = new Label();
    fortschritt1.getStyleClass().add("grid-right-item");
    fortschritt2.getStyleClass().add("grid-right-item");
    fortschritt3.getStyleClass().add("grid-right-item");
    fortschritt4.getStyleClass().add("grid-right-item");
    fortschritt5.getStyleClass().add("grid-bottom-right-item");

    gridEinzel.add(fortschritt1, 5, 1);
    gridEinzel.add(fortschritt2, 5, 2);
    gridEinzel.add(fortschritt3, 5, 3);
    gridEinzel.add(fortschritt4, 5, 4);
    gridEinzel.add(fortschritt5, 5, 5);

    Label teamleistung = new Label("Teamleistung");
    teamleistung.getStyleClass().add("grid-left-item");
    gridEinzel.add(teamleistung, 0, 6);
    Label fortschrittGesamt = new Label();
    fortschrittGesamt.getStyleClass().add("grid-right-item");
    gridEinzel.add(fortschrittGesamt, 5, 6);

    for (Node n : gridEinzel.getChildren()) {
      if (n instanceof Control) {
        Control control = (Control) n;
        control.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
      }
      if (n instanceof Pane) {
        Pane pane = (Pane) n;
        pane.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
      }
    }

    JFXComboBox<TeamDTO> teamCb = new JFXComboBox(DataController.getINSTANCE().getTeamList());
    teamCb.setPromptText("Teams...");
    teamCb.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<TeamDTO>() {
      @Override
      public void changed(ObservableValue<? extends TeamDTO> observable, TeamDTO oldValue, TeamDTO newValue) {
        if (newValue != oldValue) {
          mitgliedLabel1.setText(newValue.getMitglieder().get(0));
          mitgliedLabel2.setText(newValue.getMitglieder().get(1));
          mitgliedLabel3.setText(newValue.getMitglieder().get(2));
          mitgliedLabel4.setText(newValue.getMitglieder().get(3));
          mitgliedLabel5.setText(newValue.getMitglieder().get(4));

          ObservableList<List<String>> exampleFortschritt = newValue.toString().contains("MINF") ? DataController.getINSTANCE().getExampleFortschrittMINF1() :
              newValue.toString().contains("2") ? DataController.getINSTANCE().getExampleFortschrittWINF2() : DataController.getINSTANCE().getExampleFortschrittWINF1();
          String gesamtFortschritt = newValue.toString().contains("MINF") ? DataController.getINSTANCE().getExampleGesamtFortschrittMINF1() :
              newValue.toString().contains("2") ? DataController.getINSTANCE().getExampleGesamtFortschrittWINF2() : DataController.getINSTANCE().getExampleGesamtFortschrittWINF1();

          m1Label1.setText(exampleFortschritt.get(0).get(0));
          m2Label1.setText(exampleFortschritt.get(0).get(1));
          m3Label1.setText(exampleFortschritt.get(0).get(2));
          m4Label1.setText(exampleFortschritt.get(0).get(3));
          fortschritt1.setText(exampleFortschritt.get(0).get(4));

          m1Label2.setText(exampleFortschritt.get(1).get(0));
          m2Label2.setText(exampleFortschritt.get(1).get(1));
          m3Label2.setText(exampleFortschritt.get(1).get(2));
          m4Label2.setText(exampleFortschritt.get(1).get(3));
          fortschritt2.setText(exampleFortschritt.get(1).get(4));

          m1Label3.setText(exampleFortschritt.get(2).get(0));
          m2Label3.setText(exampleFortschritt.get(2).get(1));
          m3Label3.setText(exampleFortschritt.get(2).get(2));
          m4Label3.setText(exampleFortschritt.get(2).get(3));
          fortschritt3.setText(exampleFortschritt.get(2).get(4));

          m1Label4.setText(exampleFortschritt.get(3).get(0));
          m2Label4.setText(exampleFortschritt.get(3).get(1));
          m3Label4.setText(exampleFortschritt.get(3).get(2));
          m4Label4.setText(exampleFortschritt.get(3).get(3));
          fortschritt4.setText(exampleFortschritt.get(3).get(4));

          m1Label5.setText(exampleFortschritt.get(4).get(0));
          m2Label5.setText(exampleFortschritt.get(4).get(1));
          m3Label5.setText(exampleFortschritt.get(4).get(2));
          m4Label5.setText(exampleFortschritt.get(4).get(3));
          fortschritt5.setText(exampleFortschritt.get(4).get(4));

          fortschrittGesamt.setText(gesamtFortschritt);
        }
      }
    });
    teamCb.getStyleClass().add("table-combo-box");

    VBox gesamtContainer = UIFactory.createFormularVBox(48, gesamtTitle, root);
    gesamtContainer.setAlignment(Pos.TOP_CENTER);
    VBox einzelContainer = UIFactory.createFormularVBox(12, einzelTitle, teamCb, gridEinzel);
    einzelContainer.setAlignment(Pos.TOP_CENTER);
    HBox hBoxContainer = UIFactory.createHBoxContainer(12, 0, gesamtContainer, einzelContainer);
    hBoxContainer.setPadding(new Insets(12));
    hBoxContainer.setAlignment(Pos.CENTER);
    HBox.setHgrow(gesamtContainer, Priority.ALWAYS);
    HBox.setHgrow(einzelContainer, Priority.ALWAYS);

    Label abgabeTitle = new Label("Abgaben");
    abgabeTitle.getStyleClass().add("dashboard-title");
    abgabeTitle.setMinWidth(300);

    Label filter = new Label("Filtern nach:");
    JFXComboBox<TeamDTO> teamAbgabe = new JFXComboBox(DataController.getINSTANCE().getTeamList());
    teamAbgabe.setPromptText("Teams...");
    teamAbgabe.getStyleClass().add("table-combo-box");

    JFXComboBox<MeilensteinDTO> meilensteinAbgabe = new JFXComboBox(DataController.getINSTANCE().getMeilensteinList());
    meilensteinAbgabe.setPromptText("Meilensteine...");
    meilensteinAbgabe.getStyleClass().add("table-combo-box");

    GridPane gridAbgabe = new GridPane();

    ColumnConstraints colAbgabe1 = new ColumnConstraints();
    colAbgabe1.setPercentWidth(30);
    ColumnConstraints colAbgabe2 = new ColumnConstraints();
    colAbgabe2.setPercentWidth(20);
    ColumnConstraints colAbgabe3 = new ColumnConstraints();
    colAbgabe3.setPercentWidth(20);
    ColumnConstraints colAbgabe4 = new ColumnConstraints();
    colAbgabe4.setPercentWidth(20);
    ColumnConstraints colAbgabe5 = new ColumnConstraints();
    colAbgabe5.setPercentWidth(10);
    gridAbgabe.getColumnConstraints().addAll(colAbgabe1, colAbgabe2, colAbgabe3, colAbgabe4, colAbgabe5);

    RowConstraints rowAbgabe1 = new RowConstraints();
    rowAbgabe1.setPrefHeight(48);
    RowConstraints rowAbgabe2 = new RowConstraints();
    rowAbgabe2.setPrefHeight(48);
    RowConstraints rowAbgabe3 = new RowConstraints();
    rowAbgabe3.setPrefHeight(48);
    RowConstraints rowAbgabe4 = new RowConstraints();
    rowAbgabe4.setPrefHeight(48);
    RowConstraints rowAbgabe5 = new RowConstraints();
    rowAbgabe5.setPrefHeight(48);
    RowConstraints rowAbgabe6 = new RowConstraints();
    rowAbgabe6.setPrefHeight(48);
    RowConstraints rowAbgabe7 = new RowConstraints();
    rowAbgabe7.setPrefHeight(48);
    gridAbgabe.getRowConstraints().addAll(rowAbgabe1, rowAbgabe2, rowAbgabe3, rowAbgabe4, rowAbgabe5, rowAbgabe6, rowAbgabe7);

    Label name = new Label("Name");
    Label deadline = new Label("Deadline");
    Label datumAbgabe = new Label("Datum Abgabe");
    Label upload = new Label("Upload");
    Label aktion = new Label("Aktion");

    name.getStyleClass().add("grid-top-left-item");
    deadline.getStyleClass().add("grid-top-item");
    datumAbgabe.getStyleClass().add("grid-top-item");
    upload.getStyleClass().add("grid-top-item");
    aktion.getStyleClass().add("grid-top-right-item");

    Label name1 = new Label();
    Label name2 = new Label();
    Label name3 = new Label();
    Label name4 = new Label();
    Label name5 = new Label();
    name1.getStyleClass().add("grid-left-item");
    name2.getStyleClass().add("grid-left-item");
    name3.getStyleClass().add("grid-left-item");
    name4.getStyleClass().add("grid-left-item");
    name5.getStyleClass().add("grid-bottom-left-item");

    Label deadline1 = new Label();
    Label deadline2 = new Label();
    Label deadline3 = new Label();
    Label deadline4 = new Label();
    Label deadline5 = new Label();
    deadline5.getStyleClass().add("grid-bottom-item");

    Label datumAbgabe1 = new Label();
    Label datumAbgabe2 = new Label();
    Label datumAbgabe3 = new Label();
    Label datumAbgabe4 = new Label();
    Label datumAbgabe5 = new Label();
    datumAbgabe5.getStyleClass().add("grid-bottom-item");

    Hyperlink upload1 = new Hyperlink();
    Hyperlink upload2 = new Hyperlink();
    Hyperlink upload3 = new Hyperlink();
    Hyperlink upload4 = new Hyperlink();
    Hyperlink upload5 = new Hyperlink();
    upload5.getStyleClass().add("grid-bottom-item");

    JFXCheckBox checkBox1 = new JFXCheckBox();
    JFXCheckBox checkBox2 = new JFXCheckBox();
    JFXCheckBox checkBox3 = new JFXCheckBox();
    JFXCheckBox checkBox4 = new JFXCheckBox();
    JFXCheckBox checkBox5 = new JFXCheckBox();
    checkBox1.getStyleClass().add("grid-right-item");
    checkBox2.getStyleClass().add("grid-right-item");
    checkBox3.getStyleClass().add("grid-right-item");
    checkBox4.getStyleClass().add("grid-right-item");
    checkBox5.getStyleClass().add("grid-bottom-right-item");

    Label bottomPlaceHolder = new Label();
    bottomPlaceHolder.getStyleClass().add("grid-left-item");
    JFXButton download = new JFXButton("Download");
    download.getStyleClass().add("grid-right-item");

    gridAbgabe.add(name, 0, 0);
    gridAbgabe.add(deadline, 1, 0);
    gridAbgabe.add(datumAbgabe, 2, 0);
    gridAbgabe.add(upload, 3, 0);
    gridAbgabe.add(aktion, 4, 0);

    gridAbgabe.add(name1, 0, 1);
    gridAbgabe.add(name2, 0, 2);
    gridAbgabe.add(name3, 0, 3);
    gridAbgabe.add(name4, 0, 4);
    gridAbgabe.add(name5, 0, 5);

    gridAbgabe.add(deadline1, 1, 1);
    gridAbgabe.add(deadline2, 1, 2);
    gridAbgabe.add(deadline3, 1, 3);
    gridAbgabe.add(deadline4, 1, 4);
    gridAbgabe.add(deadline5, 1, 5);

    gridAbgabe.add(datumAbgabe1, 2, 1);
    gridAbgabe.add(datumAbgabe2, 2, 2);
    gridAbgabe.add(datumAbgabe3, 2, 3);
    gridAbgabe.add(datumAbgabe4, 2, 4);
    gridAbgabe.add(datumAbgabe5, 2, 5);

    gridAbgabe.add(upload1, 3, 1);
    gridAbgabe.add(upload2, 3, 2);
    gridAbgabe.add(upload3, 3, 3);
    gridAbgabe.add(upload4, 3, 4);
    gridAbgabe.add(upload5, 3, 5);

    gridAbgabe.add(checkBox1, 4, 1);
    gridAbgabe.add(checkBox2, 4, 2);
    gridAbgabe.add(checkBox3, 4, 3);
    gridAbgabe.add(checkBox4, 4, 4);
    gridAbgabe.add(checkBox5, 4, 5);

    gridAbgabe.add(bottomPlaceHolder, 0, 6);
    gridAbgabe.add(download, 4, 6);

    for (Node n : gridAbgabe.getChildren()) {
      if (n instanceof Control) {
        Control control = (Control) n;
        control.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
      }
      if (n instanceof Pane) {
        Pane pane = (Pane) n;
        pane.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
      }
    }
    meilensteinAbgabe.getSelectionModel().selectFirst();
    teamAbgabe.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<TeamDTO>() {
      @Override
      public void changed(ObservableValue<? extends TeamDTO> observable, TeamDTO oldValue, TeamDTO newValue) {
        if (newValue != oldValue) {
          name1.setText(newValue.getMitglieder().get(0));
          name2.setText(newValue.getMitglieder().get(1));
          name3.setText(newValue.getMitglieder().get(2));
          name4.setText(newValue.getMitglieder().get(3));
          name5.setText(newValue.getMitglieder().get(4));

          MeilensteinDTO meilenstein = meilensteinAbgabe.getSelectionModel().getSelectedItem();
          int meilensteinIndex = meilensteinAbgabe.getSelectionModel().getSelectedIndex();

          deadline1.setText(meilenstein.getDeadline().format(DateTimeFormatter.ofPattern("dd.MM.yyyy")));
          deadline2.setText(meilenstein.getDeadline().format(DateTimeFormatter.ofPattern("dd.MM.yyyy")));
          deadline3.setText(meilenstein.getDeadline().format(DateTimeFormatter.ofPattern("dd.MM.yyyy")));
          deadline4.setText(meilenstein.getDeadline().format(DateTimeFormatter.ofPattern("dd.MM.yyyy")));
          deadline5.setText(meilenstein.getDeadline().format(DateTimeFormatter.ofPattern("dd.MM.yyyy")));

          ObservableList<List<Pair<String, String>>> exampleAbgabe = newValue.toString().contains("MINF") ? DataController.getINSTANCE().getExampleAbgabeMINF1() :
              newValue.toString().contains("2") ? DataController.getINSTANCE().getExampleAbgabeWINF2() : DataController.getINSTANCE().getExampleAbgabeWINF1();
          datumAbgabe1.setText(exampleAbgabe.get(0).get(meilensteinIndex).getKey());
          datumAbgabe2.setText(exampleAbgabe.get(1).get(meilensteinIndex).getKey());
          datumAbgabe3.setText(exampleAbgabe.get(2).get(meilensteinIndex).getKey());
          datumAbgabe4.setText(exampleAbgabe.get(3).get(meilensteinIndex).getKey());
          datumAbgabe5.setText(exampleAbgabe.get(4).get(meilensteinIndex).getKey());

          upload1.setText(exampleAbgabe.get(0).get(meilensteinIndex).getValue());
          upload2.setText(exampleAbgabe.get(1).get(meilensteinIndex).getValue());
          upload3.setText(exampleAbgabe.get(2).get(meilensteinIndex).getValue());
          upload4.setText(exampleAbgabe.get(3).get(meilensteinIndex).getValue());
          upload5.setText(exampleAbgabe.get(4).get(meilensteinIndex).getValue());

        }
      }
    });

    meilensteinAbgabe.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<MeilensteinDTO>() {
      @Override
      public void changed(ObservableValue<? extends MeilensteinDTO> observable, MeilensteinDTO oldValue, MeilensteinDTO newValue) {
        if (newValue != oldValue) {
          TeamDTO teamDTO = teamAbgabe.getSelectionModel().getSelectedItem();
          name1.setText(teamDTO.getMitglieder().get(0));
          name2.setText(teamDTO.getMitglieder().get(1));
          name3.setText(teamDTO.getMitglieder().get(2));
          name4.setText(teamDTO.getMitglieder().get(3));
          name5.setText(teamDTO.getMitglieder().get(4));

          MeilensteinDTO meilenstein = meilensteinAbgabe.getSelectionModel().getSelectedItem();
          int meilensteinIndex = meilensteinAbgabe.getSelectionModel().getSelectedIndex();

          deadline1.setText(meilenstein.getDeadline().format(DateTimeFormatter.ofPattern("dd.MM.yyyy")));
          deadline2.setText(meilenstein.getDeadline().format(DateTimeFormatter.ofPattern("dd.MM.yyyy")));
          deadline3.setText(meilenstein.getDeadline().format(DateTimeFormatter.ofPattern("dd.MM.yyyy")));
          deadline4.setText(meilenstein.getDeadline().format(DateTimeFormatter.ofPattern("dd.MM.yyyy")));
          deadline5.setText(meilenstein.getDeadline().format(DateTimeFormatter.ofPattern("dd.MM.yyyy")));

          ObservableList<List<Pair<String, String>>> exampleAbgabe = newValue.toString().contains("MINF") ? DataController.getINSTANCE().getExampleAbgabeMINF1() :
              newValue.toString().contains("2") ? DataController.getINSTANCE().getExampleAbgabeWINF2() : DataController.getINSTANCE().getExampleAbgabeWINF1();
          datumAbgabe1.setText(exampleAbgabe.get(0).get(meilensteinIndex).getKey());
          datumAbgabe2.setText(exampleAbgabe.get(1).get(meilensteinIndex).getKey());
          datumAbgabe3.setText(exampleAbgabe.get(2).get(meilensteinIndex).getKey());
          datumAbgabe4.setText(exampleAbgabe.get(3).get(meilensteinIndex).getKey());
          datumAbgabe5.setText(exampleAbgabe.get(4).get(meilensteinIndex).getKey());

          upload1.setText(exampleAbgabe.get(0).get(meilensteinIndex).getValue());
          upload2.setText(exampleAbgabe.get(1).get(meilensteinIndex).getValue());
          upload3.setText(exampleAbgabe.get(2).get(meilensteinIndex).getValue());
          upload4.setText(exampleAbgabe.get(3).get(meilensteinIndex).getValue());
          upload5.setText(exampleAbgabe.get(4).get(meilensteinIndex).getValue());

        }
      }
    });

    teamAbgabe.getSelectionModel().selectFirst();

    VBox abgabeContainer = UIFactory.createFormularVBox(12, abgabeTitle, UIFactory.createCenteredHBoxContainer(filter, teamAbgabe, meilensteinAbgabe), gridAbgabe);
    abgabeContainer.setAlignment(Pos.TOP_CENTER);

    VBox formularVBox = UIFactory.createFormularVBox(12, hBoxContainer, abgabeContainer);
    return UIFactory.createScrollPane(formularVBox);
  }

  private XYChart.Data createData(double value, String team) {
    XYChart.Data data = new XYChart.Data(value, team);

    String text = value <= 25 ? "M1" : value <= 50 ? "M2" : value <= 75 ? "M3" : "M4";

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
