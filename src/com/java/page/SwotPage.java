package com.java.page;

import com.java.controller.DataController;
import com.java.data.dto.ChanceDTO;
import com.java.data.dto.RisikoDTO;
import com.java.data.dto.TeamMitgliedDTO;
import com.java.utility.UIFactory;
import com.jfoenix.controls.JFXTextArea;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;

public class SwotPage implements TabPages {

  private ScrollPane root;
  private VBox stärke;
  private VBox schwäche;
  private VBox chance;
  private VBox risiko;

  @Override
  public Node getLeftNode() {
    return null;
  }

  @Override
  public Node getCenterNode() {
    if (root == null) {
      GridPane grid = new GridPane();
      grid.setStyle("-fx-background-color: white");
      grid.setVgap(12);
      grid.setHgap(12);
      grid.setPadding(new Insets(12));

      ColumnConstraints col1 = new ColumnConstraints();
      col1.setPercentWidth(33.33);
      ColumnConstraints col2 = new ColumnConstraints();
      col2.setPercentWidth(33.33);
      ColumnConstraints col3 = new ColumnConstraints();
      col3.setPercentWidth(33.33);
      grid.getColumnConstraints().addAll(col1, col2, col3);

      RowConstraints row1 = new RowConstraints();
      row1.setPercentHeight(33.33);
      RowConstraints row2 = new RowConstraints();
      row2.setPercentHeight(33.33);
      RowConstraints row3 = new RowConstraints();
      row3.setPercentHeight(33.33);
      grid.getRowConstraints().addAll(row1, row2, row3);

      Label swotLbl = new Label("SWOT");
      swotLbl.getStyleClass().add("title-formular");
      VBox swot = new VBox(swotLbl);
      swot.setAlignment(Pos.CENTER);
      swot.setStyle("-fx-background-color: rgb(189, 215, 238)");
      stärke = new VBox();
      stärke.setStyle("-fx-background-color: rgb(169, 209, 142)");
      schwäche = new VBox();
      schwäche.setStyle("-fx-background-color: rgb(244, 177, 131)");
      chance = new VBox();
      chance.setStyle("-fx-background-color: rgb(169, 209, 142)");
      risiko = new VBox();
      risiko.setStyle("-fx-background-color: rgb(244, 177, 131)");

      JFXTextArea stärkeChanceTa = UIFactory.createFormularTextArea("Aus welchen Stärken ergeben sich neue Chance? Wie kann ich die Stärken nutzen?");
      JFXTextArea stärkeRisikoTa = UIFactory.createFormularTextArea("Welche Stärken minimieren mögliche Herausforderungen? Was sind Strategien?");
      JFXTextArea schwächeChanceTa = UIFactory.createFormularTextArea("An welchen Schwächen sollten wir arbeiten, um die Chancen nutzen zu können? Was können wir dafür tun?");
      JFXTextArea schwächeRisikoTa = UIFactory.createFormularTextArea("Was könnt ihr tun, um Schwächen zu minimieren und so Risiken entgegenzuwirken?");

      grid.add(swot, 0, 0);
      grid.add(stärke, 1, 0);
      grid.add(schwäche, 2, 0);
      grid.add(chance, 0, 1);
      grid.add(stärkeChanceTa, 1, 1);
      grid.add(schwächeChanceTa, 2, 1);
      grid.add(risiko, 0, 2);
      grid.add(stärkeRisikoTa, 1, 2);
      grid.add(schwächeRisikoTa, 2, 2);

      GridPane.setHgrow(swot, Priority.ALWAYS);
      GridPane.setHgrow(stärke, Priority.ALWAYS);
      GridPane.setHgrow(schwäche, Priority.ALWAYS);
      GridPane.setHgrow(chance, Priority.ALWAYS);
      GridPane.setHgrow(stärkeChanceTa, Priority.ALWAYS);
      GridPane.setHgrow(schwächeChanceTa, Priority.ALWAYS);
      GridPane.setHgrow(risiko, Priority.ALWAYS);
      GridPane.setHgrow(stärkeRisikoTa, Priority.ALWAYS);
      GridPane.setHgrow(schwächeRisikoTa, Priority.ALWAYS);

      GridPane.setVgrow(swot, Priority.ALWAYS);
      GridPane.setVgrow(stärke, Priority.ALWAYS);
      GridPane.setVgrow(schwäche, Priority.ALWAYS);
      GridPane.setVgrow(chance, Priority.ALWAYS);
      GridPane.setVgrow(stärkeChanceTa, Priority.ALWAYS);
      GridPane.setVgrow(schwächeChanceTa, Priority.ALWAYS);
      GridPane.setVgrow(risiko, Priority.ALWAYS);
      GridPane.setVgrow(stärkeRisikoTa, Priority.ALWAYS);
      GridPane.setVgrow(schwächeRisikoTa, Priority.ALWAYS);

      root = UIFactory.createScrollPane(grid);
    }

    return root;
  }

  @Override
  public void update() {
    risiko.getChildren().clear();
    chance.getChildren().clear();
    stärke.getChildren().clear();
    schwäche.getChildren().clear();
    Label risiken = new Label("Risiken");
    risiken.getStyleClass().add("titledesc");
    risiko.getChildren().add(risiken);
    for (RisikoDTO risikoDTO : DataController.getINSTANCE().getRisikoList()) {
      Label bullet = new Label("\u2022");
      bullet.getStyleClass().add("team-mitglied-stärke-schwäche");
      Label label = new Label(risikoDTO.getRisikoBeschreibung());
      label.setWrapText(true);

      HBox container = UIFactory.createHBoxContainer(24, 0, bullet, label);
      risiko.getChildren().add(container);
    }

    Label chancen = new Label("Chancen");
    chancen.getStyleClass().add("titledesc");
    chance.getChildren().add(chancen);
    for (ChanceDTO chanceDTO : DataController.getINSTANCE().getChanceList()) {
      Label bullet = new Label("\u2022");
      bullet.getStyleClass().add("team-mitglied-stärke-schwäche");
      Label label = new Label(chanceDTO.getBeschreibung());
      label.setWrapText(true);

      HBox container = UIFactory.createHBoxContainer(24, 0, bullet, label);
      chance.getChildren().add(container);
    }

    Label stärken = new Label("Stärken");
    stärken.getStyleClass().add("titledesc");
    stärke.getChildren().add(stärken);
    Label schwächen = new Label("Schwächen");
    schwächen.getStyleClass().add("titledesc");
    schwäche.getChildren().add(schwächen);
    for (TeamMitgliedDTO teamMitgliedDTO : DataController.getINSTANCE().getTeamMitglieder()) {
      for (String string : teamMitgliedDTO.getStärke()) {
        Label bullet = new Label("\u2022");
        bullet.getStyleClass().add("team-mitglied-stärke-schwäche");
        Label label = new Label(string);
        label.setWrapText(true);

        HBox container = UIFactory.createHBoxContainer(24, 0, bullet, label);
        stärke.getChildren().add(container);
      }
      for (String string : teamMitgliedDTO.getSchwäche()) {
        Label bullet = new Label("\u2022");
        bullet.getStyleClass().add("team-mitglied-stärke-schwäche");
        Label label = new Label(string);
        label.setWrapText(true);

        HBox container = UIFactory.createHBoxContainer(24, 0, bullet, label);
        schwäche.getChildren().add(container);
      }
    }
  }
}
