package com.java.page;

import com.java.components.TeamMemberWidget;
import com.java.data.DataController;
import com.java.data.TeamMitgliedDTO;
import com.java.utility.PropertyFactory;
import com.java.utility.UIFactory;
import javafx.scene.Node;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;

public class TeamPage implements TabPages {

  private int row = 0;
  private int col = 0;
  private ScrollPane scrollPane;

  public TeamPage() {
    GridPane gridPane = new GridPane();
    gridPane.setVgap(12);

    for (TeamMitgliedDTO teamMitgliedDTO : DataController.getINSTANCE().getTeamMitglieder()) {
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
