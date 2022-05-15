package com.java.components;

import com.java.data.TeamMitglied;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class TeamMemberWidget {

  private VBox content;
  private TeamMitglied teamMitglied;

  public TeamMemberWidget(TeamMitglied teamMitglied) {
    this.content = new VBox();
    this.content.setAlignment(Pos.CENTER);
    this.content.setSpacing(12);
    this.teamMitglied = teamMitglied;

    Label name = new Label(teamMitglied.getName());
    name.getStyleClass().add("team-mitglied-name");
    Label belbin = new Label(teamMitglied.getBelbin());
    belbin.getStyleClass().add("team-mitglied-belbin");
    Label spacer = new Label("");
    Label alter = new Label(teamMitglied.getAlter() + " Jahre");
    alter.getStyleClass().add("team-mitglied-allgemein");
    Label semester = new Label(teamMitglied.getSemester() + ". Semester");
    semester.getStyleClass().add("team-mitglied-allgemein");
    Label beruf = new Label(teamMitglied.getBeruf());
    beruf.setWrapText(true);
    beruf.getStyleClass().add("team-mitglied-allgemein");
    Label firma = new Label("@" + teamMitglied.getFirma());
    firma.getStyleClass().add("team-mitglied-allgemein");

    ImageView imageView = new ImageView(teamMitglied.getImage());
    StackPane stackPane = new StackPane(imageView);
    stackPane.getStyleClass().add("stack-pane");
    VBox allgemeinContainer = new VBox(stackPane, name, belbin, spacer, alter, semester, beruf, firma);
    allgemeinContainer.getStyleClass().add("team-mitglied-container-allgemein");
    allgemeinContainer.setAlignment(Pos.CENTER);

    this.content.getChildren().add(allgemeinContainer);
  }

  public Node getContent() {
    return this.content;
  }
}
