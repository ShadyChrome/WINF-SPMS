package com.java.page;

import com.java.components.TeamMemberWidget;
import com.java.data.ImagesEnum;
import com.java.data.TeamMitgliedDTO;
import com.java.utility.IconFactory;
import com.java.utility.PropertyFactory;
import com.java.utility.UIFactory;
import javafx.scene.Node;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TeamPage implements TabPages {

  private int row = 0;
  private int col = 0;
  private ScrollPane scrollPane;

  private List<TeamMitgliedDTO> list = new ArrayList<>(Arrays.asList(
      new TeamMitgliedDTO(IconFactory.getImage(ImagesEnum.LINH), "Linh Phung", 28, 4, "Data Analyst", "GLS Bank", "Implementer", "Was mich besonders an diesem Projekt interessiert, ist die Möglichkeit etwas zu entwickeln, das langfristig für alle Studierende relevant sein kann.", Arrays.asList("Zielorientiert", "Aufgabenverteilung", "HTML"), Arrays.asList("Geduld bei Aufgabenabarbeitung bewahren"), Arrays.asList("Katze", "Titanic", "Fliegen")),
      new TeamMitgliedDTO(IconFactory.getImage(ImagesEnum.LISA), "Lisa Spendel", 29, 6, "Kundenkontaktmanagement", "Stromnetz Berlin GmbH", "Implementer", "Was mich besonders an diesem Projekt interessiert, ist die Möglichkeit etwas zu entwickeln, das langfristig für alle Studierende relevant sein kann.", Arrays.asList("Zielorientiert", "Aufgabenverteilung", "HTML"), Arrays.asList("Geduld bei Aufgabenabarbeitung bewahren"), Arrays.asList("Hund", "Avatar", "Unsichtbar sein")),
      new TeamMitgliedDTO(IconFactory.getImage(ImagesEnum.MIMOSA), "Mimosa Luong", 29, 6, "Content Managerin", "HWR Berlin", "Teamworker", "Was mich besonders an diesem Projekt interessiert, ist die Möglichkeit etwas zu entwickeln, das langfristig für alle Studierende relevant sein kann.", Arrays.asList("Zielorientiert", "Aufgabenverteilung", "HTML"), Arrays.asList("Geduld bei Aufgabenabarbeitung bewahren"), Arrays.asList("Delfin", "Planet der Affen", "Glück")),
      new TeamMitgliedDTO(IconFactory.getImage(ImagesEnum.LINH), "Jörg Seelbinder", 40, 4, "Support", "ITZBund", "Resource Investigator", "Was mich besonders an diesem Projekt interessiert, ist die Möglichkeit etwas zu entwickeln, das langfristig für alle Studierende relevant sein kann.", Arrays.asList("Zielorientiert", "Aufgabenverteilung", "HTML"), Arrays.asList("Geduld bei Aufgabenabarbeitung bewahren"), Arrays.asList("Katze", "Titanic", "Fliegen")),
      new TeamMitgliedDTO(IconFactory.getImage(ImagesEnum.LINH), "Marcel Koschau", 27, 4, "Softwareengineer", "ADVA", "Shaper", "Was mich besonders an diesem Projekt interessiert, ist die Möglichkeit etwas zu entwickeln, das langfristig für alle Studierende relevant sein kann.", Arrays.asList("Zielorientiert", "Aufgabenverteilung", "HTML"), Arrays.asList("Geduld bei Aufgabenabarbeitung bewahren"), Arrays.asList("Falke", "Spider Man", "Teleportieren"))
  ));

  public TeamPage() {
    GridPane gridPane = new GridPane();
    gridPane.setVgap(12);

    for (TeamMitgliedDTO teamMitgliedDTO : list) {
      if (col > 2) {
        col = 0;
        row++;
      }
      Node content = new TeamMemberWidget(teamMitgliedDTO).getContent();
      gridPane.add(content, col, row);
      GridPane.setHgrow(content, Priority.ALWAYS);
      col++;
    }

    this.scrollPane = UIFactory.createScrollPane(gridPane);

    PropertyFactory.addPropertyChangeListener(evt -> {
      if (evt.getPropertyName().equals(NEW_TEAM_MEMBER_PROPERTY)) {
        if (col > 2) {
          col = 0;
          row++;
        }
        Node content = new TeamMemberWidget((TeamMitgliedDTO) evt.getNewValue()).getContent();
        gridPane.add(content, col, row);
        GridPane.setHgrow(content, Priority.ALWAYS);
        col++;
      }
    });
  }

  @Override
  public Node getLeftNode() {
    return null;
  }

  @Override
  public Node getCenterNode() {
    return this.scrollPane;
  }
}
