package com.java.page;

import com.java.components.TeamMemberWidget;
import com.java.controller.DataController;
import com.java.data.dto.TeamMitgliedDTO;
import com.java.data.enums.ImagesEnum;
import com.java.utility.IconFactory;
import com.java.utility.PropertyFactory;
import com.java.utility.UIFactory;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

public class TeamPage implements TabPages {

  private int row = 0;
  private int col = 0;
  private ScrollPane scrollPane;
  private GridPane gridPane;

  public TeamPage() {
    gridPane = new GridPane();
    gridPane.setVgap(12);

    ColumnConstraints col1 = new ColumnConstraints();
    col1.setPercentWidth(33.33);
    ColumnConstraints col2 = new ColumnConstraints();
    col2.setPercentWidth(33.33);
    ColumnConstraints col3 = new ColumnConstraints();
    col3.setPercentWidth(33.33);
    gridPane.getColumnConstraints().addAll(col1, col2, col3);

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

    VBox formularVBox = UIFactory.createFormularVBox(12, gridPane, new ImageView(IconFactory.getImage(ImagesEnum.RADARCHART)));
    formularVBox.setAlignment(Pos.CENTER);

    this.scrollPane = UIFactory.createScrollPane(formularVBox);

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

  @Override
  public void update() {
    gridPane.getChildren().clear();
    row = 0;
    col = 0;

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
  }
}
