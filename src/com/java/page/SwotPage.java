package com.java.page;

import com.java.utility.UIFactory;
import com.jfoenix.controls.JFXTextArea;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;

public class SwotPage implements TabPages {

  private GridPane root;

  @Override
  public Node getLeftNode() {
    return null;
  }

  @Override
  public Node getCenterNode() {
    if (root == null) {
      root = new GridPane();
      root.setStyle("-fx-background-color: white");
      root.setVgap(12);
      root.setHgap(12);
      root.setPadding(new Insets(12));

      ColumnConstraints col1 = new ColumnConstraints();
      col1.setPercentWidth(33.33);
      ColumnConstraints col2 = new ColumnConstraints();
      col2.setPercentWidth(33.33);
      ColumnConstraints col3 = new ColumnConstraints();
      col3.setPercentWidth(33.33);
      root.getColumnConstraints().addAll(col1, col2, col3);

      RowConstraints row1 = new RowConstraints();
      row1.setPercentHeight(33.33);
      RowConstraints row2 = new RowConstraints();
      row2.setPercentHeight(33.33);
      RowConstraints row3 = new RowConstraints();
      row3.setPercentHeight(33.33);
      root.getRowConstraints().addAll(row1, row2, row3);

      Label swotLbl = new Label("SWOT");
      VBox swot = new VBox(swotLbl);
      swot.setAlignment(Pos.CENTER);
      swot.setStyle("-fx-background-color: rgb(189, 215, 238)");
      VBox stärke = new VBox();
      stärke.setStyle("-fx-background-color: rgb(169, 209, 142)");
      VBox schwäche = new VBox();
      schwäche.setStyle("-fx-background-color: rgb(244, 177, 131)");
      VBox chance = new VBox();
      chance.setStyle("-fx-background-color: rgb(169, 209, 142)");
      VBox risiko = new VBox();
      risiko.setStyle("-fx-background-color: rgb(244, 177, 131)");

      JFXTextArea stärkeChanceTa = UIFactory.createFormularTextArea("Aus welchen Stärken ergeben sich neue Chance? Wie kann ich die Stärken nutzen?");
      JFXTextArea stärkeRisikoTa = UIFactory.createFormularTextArea("Welche Stärken minimieren mögliche Herausforderungen? Was sind Strategien?");
      JFXTextArea schwächeChanceTa = UIFactory.createFormularTextArea("An welchen Schwächen sollten wir arbeiten, um die Chancen nutzen zu können? Was können wir dafür tun?");
      JFXTextArea schwächeRisikoTa = UIFactory.createFormularTextArea("Was könnt ihr tun, um Schwächen zu minimieren und so Risiken entgegenzuwirken?");

      root.add(swot, 0, 0);
      root.add(stärke, 1, 0);
      root.add(schwäche, 2, 0);
      root.add(chance, 0, 1);
      root.add(stärkeChanceTa, 1, 1);
      root.add(schwächeChanceTa, 2, 1);
      root.add(risiko, 0, 2);
      root.add(stärkeRisikoTa, 1, 2);
      root.add(schwächeRisikoTa, 2, 2);

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
    }

    return root;
  }
}
