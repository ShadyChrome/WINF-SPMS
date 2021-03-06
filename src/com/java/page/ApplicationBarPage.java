package com.java.page;

import com.java.actions.ActionItem;
import com.java.data.enums.ImagesEnum;
import com.java.utility.IconFactory;
import com.java.utility.PropertyFactory;
import com.jfoenix.controls.JFXToggleNode;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;

import java.util.Arrays;

import static com.java.page.TabPages.AS_IS_PAGE_PROPERTY;
import static com.java.page.TabPages.DASHBOARD_PAGE_PROPERTY;
import static com.java.page.TabPages.INNOVATION_PAGE_PROPERTY;
import static com.java.page.TabPages.NEUES_DASHBOARD_PAGE_PROPERTY;
import static com.java.page.TabPages.PLAN_BOARD_PAGE_PROPERTY;
import static com.java.page.TabPages.RISOKO_ANALYSE_PAGE_PROPERTY;
import static com.java.page.TabPages.SWOT_ANALYSE_PAGE_PROPERTY;
import static com.java.page.TabPages.SWOT_PAGE_PROPERTY;
import static com.java.page.TabPages.TEAM_MITGLIED_PAGE_PROPERTY;
import static com.java.page.TabPages.TEAM_PAGE_PROPERTY;
import static com.java.page.TabPages.TO_BE_PAGE_PROPERTY;
import static com.java.page.TabPages.TRENDS_PAGE_PROPERTY;
import static com.java.page.TabPages.USER_STORY_PAGE_PROPERTY;
import static com.java.utility.UIFactory.createMenuButton;
import static com.java.utility.UIFactory.createToggleButton;

public class ApplicationBarPage {

  private HBox content;
  private JFXToggleNode firstToggleButton;

  public ApplicationBarPage() {
    this.content = new HBox();
    content.getStyleClass().add("app-bar-container");

    Pane spacer = new Pane();
    HBox.setHgrow(spacer, Priority.ALWAYS);

    ImageView logo = new ImageView(IconFactory.getImage(ImagesEnum.LOGO));
    logo.getStyleClass().add("logo");

    Label titleSpacer = new Label("-");
    titleSpacer.getStyleClass().add("title");

    Label titleSpacer2 = new Label("-");
    titleSpacer2.getStyleClass().add("title");

    ToggleGroup toggleGroup = new ToggleGroup();
    toggleGroup.selectedToggleProperty().addListener((obsVal, oldVal, newVal) -> {
      if (newVal == null)
        oldVal.setSelected(true);
    });

    firstToggleButton = createToggleButton(toggleGroup, "1. INNOVATION", INNOVATION_PAGE_PROPERTY);
    content.getChildren().addAll(logo, createMenuButton("PROJECT", Arrays.asList(
        new ActionItem("Team", () -> PropertyFactory.firePropertyChange(TEAM_PAGE_PROPERTY, null, null)),
        new ActionItem("SWOT", () -> PropertyFactory.firePropertyChange(SWOT_PAGE_PROPERTY, null, null)),
        new ActionItem("Risikoanalyse", () -> PropertyFactory.firePropertyChange(RISOKO_ANALYSE_PAGE_PROPERTY, null, null)),
        new ActionItem("Dashboard", () -> PropertyFactory.firePropertyChange(DASHBOARD_PAGE_PROPERTY, null, null)),
        new ActionItem("Plan Board", () -> PropertyFactory.firePropertyChange(PLAN_BOARD_PAGE_PROPERTY, null, null))
        )), titleSpacer, firstToggleButton,
        createToggleButton(toggleGroup, "2. AS-IS", AS_IS_PAGE_PROPERTY),
        createToggleButton(toggleGroup, "3. TO-BE", TO_BE_PAGE_PROPERTY),
        createToggleButton(toggleGroup, "4. TRENDS", TRENDS_PAGE_PROPERTY),
        titleSpacer2, createMenuButton("INPUT PM", Arrays.asList(
            new ActionItem("Neues Teammitglied", () -> PropertyFactory.firePropertyChange(TEAM_MITGLIED_PAGE_PROPERTY, null, null)),
            new ActionItem("Neue SWOT Analyse", () -> PropertyFactory.firePropertyChange(SWOT_ANALYSE_PAGE_PROPERTY, null, null)),
            new ActionItem("Neues Dashboard", () -> PropertyFactory.firePropertyChange(NEUES_DASHBOARD_PAGE_PROPERTY, null, null)),
            new ActionItem("User Stories", () -> PropertyFactory.firePropertyChange(USER_STORY_PAGE_PROPERTY, null, null))
        )));

    content.setAlignment(Pos.CENTER_LEFT);
    content.setSpacing(12);
    HBox.setMargin(logo, new Insets(0, 12, 0, 0));
  }

  public void init() {
    firstToggleButton.setSelected(true);
    firstToggleButton.requestFocus();
    firstToggleButton.fire();
  }

  public Node getContent() {
    return content;
  }
}
