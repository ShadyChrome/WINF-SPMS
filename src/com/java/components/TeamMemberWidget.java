package com.java.components;

import com.java.controller.DataController;
import com.java.data.enums.ImagesEnum;
import com.java.data.dto.TeamMitgliedDTO;
import com.java.page.TabPages;
import com.java.utility.IconFactory;
import com.java.utility.PropertyFactory;
import com.java.utility.UIFactory;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TeamMemberWidget {

  private VBox content;
  private List<ImagesEnum> images = new ArrayList<>(Arrays.asList(ImagesEnum.PFOTE, ImagesEnum.FILM, ImagesEnum.SUPERKRAFT));

  public TeamMemberWidget(TeamMitgliedDTO teamMitgliedDTO) {
    Label name = new Label(teamMitgliedDTO.getName());
    name.getStyleClass().add("team-mitglied-name");
    Label belbin = new Label(teamMitgliedDTO.getBelbin());
    belbin.getStyleClass().add("team-mitglied-belbin");
    Label spacer = new Label("");
    Label semester = new Label(teamMitgliedDTO.getSemester() + ". Semester");
    semester.getStyleClass().add("team-mitglied-allgemein");
    Label beruf = new Label(teamMitgliedDTO.getBeruf());
    beruf.setWrapText(true);
    beruf.getStyleClass().add("team-mitglied-allgemein");
    Label firma = new Label("@" + teamMitgliedDTO.getFirma());
    firma.getStyleClass().add("team-mitglied-allgemein");

    ImageView imageView = new ImageView(teamMitgliedDTO.getImage());
    imageView.setFitWidth(212);
    imageView.setFitHeight(208);

    StackPane stackPane = new StackPane(imageView);
    stackPane.getStyleClass().add("stack-pane");
    VBox allgemeinContainer = new VBox(stackPane, name, belbin, spacer, semester, beruf, firma);
    allgemeinContainer.getStyleClass().add("team-mitglied-container-allgemein");
    allgemeinContainer.setAlignment(Pos.CENTER);

    Label projekt = new Label("„" + teamMitgliedDTO.getProjekt() + "“");
    projekt.setWrapText(true);
    projekt.getStyleClass().add("team-mitglied-zitat");
    projekt.setAlignment(Pos.CENTER);

    VBox stärkeSchwächeContainer = new VBox(IconFactory.ImageTransformAction.COLOR_MAIN.transform(new ImageView(IconFactory.getImage(ImagesEnum.PLUS))));
    stärkeSchwächeContainer.getStyleClass().add("team-mitglied-container");
    stärkeSchwächeContainer.setPadding(new Insets(12));
    stärkeSchwächeContainer.setAlignment(Pos.CENTER);

    for (String string : teamMitgliedDTO.getStärke()) {
      Label bullet = new Label("\u2022");
      bullet.getStyleClass().add("team-mitglied-stärke-schwäche");
      Label label = new Label(string);
      label.getStyleClass().add("team-mitglied-stärke-schwäche");
      label.setWrapText(true);

      HBox container = UIFactory.createHBoxContainer(24, 0, bullet, label);
      stärkeSchwächeContainer.getChildren().add(container);
      VBox.setMargin(container, new Insets(0, 12, 0, 12));
    }

    stärkeSchwächeContainer.getChildren().add(IconFactory.ImageTransformAction.COLOR_MAIN.transform(new ImageView(IconFactory.getImage(ImagesEnum.MINUS))));

    for (String string : teamMitgliedDTO.getSchwäche()) {
      Label bullet = new Label("\u2022");
      bullet.getStyleClass().add("team-mitglied-stärke-schwäche");
      Label label = new Label(string);
      label.getStyleClass().add("team-mitglied-stärke-schwäche");
      label.setWrapText(true);

      HBox container = UIFactory.createHBoxContainer(24, 0, bullet, label);
      stärkeSchwächeContainer.getChildren().add(container);
      VBox.setMargin(container, new Insets(0, 12, 0, 12));
    }

    HBox eisbrecherContainer = new HBox();
    eisbrecherContainer.setSpacing(24);
    eisbrecherContainer.setAlignment(Pos.CENTER);
    eisbrecherContainer.managedProperty().bind(eisbrecherContainer.visibleProperty());
    eisbrecherContainer.setVisible(!DataController.getINSTANCE().isDozent());
    PropertyFactory.addPropertyChangeListener(new PropertyChangeListener() {
      @Override
      public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals(TabPages.PERSONA_CHANGE_PROPERTY)) {
          eisbrecherContainer.setVisible(!DataController.getINSTANCE().isDozent());
        }
      }
    });

    for (int i = 0; i < 3; i++) {
      Label label = new Label(teamMitgliedDTO.getEisbrecher().get(i));
      label.setGraphic(new ImageView(IconFactory.getImage(images.get(i))));
      label.setContentDisplay(ContentDisplay.TOP);
      label.setWrapText(true);
      label.getStyleClass().add("team-mitglied-eisbrecher");
      eisbrecherContainer.getChildren().add(label);
    }

    this.content = UIFactory.createFormularVBox(12, allgemeinContainer, projekt, stärkeSchwächeContainer, eisbrecherContainer);
    this.content.setAlignment(Pos.TOP_CENTER);
    VBox.setMargin(projekt, new Insets(12));
    VBox.setMargin(stärkeSchwächeContainer, new Insets(24));
  }

  public Node getContent() {
    return this.content;
  }
}
