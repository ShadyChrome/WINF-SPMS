package com.java.page;

import com.java.components.IntegerTextField;
import com.java.controller.DataController;
import com.java.data.dto.TeamMitgliedDTO;
import com.java.data.enums.BelbinRollenEnum;
import com.java.data.enums.ImagesEnum;
import com.java.utility.IconFactory;
import com.java.utility.PropertyFactory;
import com.java.utility.UIFactory;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.embed.swing.SwingFXUtils;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.java.utility.UIFactory.createFormularHilfeLabel;
import static com.java.utility.UIFactory.createFormularLabel;
import static com.java.utility.UIFactory.createFormularSubtitle;
import static com.java.utility.UIFactory.createFormularTextArea;
import static com.java.utility.UIFactory.createFormularTextField;
import static com.java.utility.UIFactory.createFormularVBox;
import static com.java.utility.UIFactory.createHBoxContainer;


public class TeamMitgliedPage implements TabPages {
  @Override
  public Node getLeftNode() {
    return null;
  }

  @Override
  public Node getCenterNode() {
    VBox container = new VBox();
    container.setSpacing(24);
    container.setPadding(new Insets(12));

    Label title = new Label("Teamvorstellung");
    title.getStyleClass().add("title-formular");
    Label titleDesc = new Label("Stelle dich hier deinen Teammitgliedern vor und helfe Ihnen dabei, dich besser kennenzulernen.");
    titleDesc.getStyleClass().add("titledesc");

    JFXButton button = new JFXButton("Absenden");
    button.getStyleClass().add("form-button");
    HBox absendenContainer = createHBoxContainer(12, 0, button);
    absendenContainer.setAlignment(Pos.CENTER);

    JFXTextField nameTf = new JFXTextField();
    IntegerTextField semesterTf = new IntegerTextField();
    JFXTextField berufTf = new JFXTextField();
    JFXTextField berufFirma = new JFXTextField();
    JFXComboBox<BelbinRollenEnum> belbinCb = new JFXComboBox(FXCollections.observableArrayList(BelbinRollenEnum.values()));
    belbinCb.getSelectionModel().selectFirst();
    JFXTextArea projectTa = createFormularTextArea("Hier ausfüllen...");
    JFXTextArea stärkeTa = createFormularTextArea("Hier ausfüllen...");
    JFXTextArea schwächeTa = createFormularTextArea("Hier ausfüllen...");
    JFXTextField eisbrecherTierTf = createFormularTextField();
    JFXTextField eisbrecherFilmTf = createFormularTextField();
    JFXTextField eisbrecherSuperkraftTf = createFormularTextField();
    JFXButton imageBtn = new JFXButton("Load");
    ImageView imageView = new ImageView();
    imageView.setPreserveRatio(true);
    imageView.setFitHeight(210);
    imageView.setFitWidth(210);

    imageBtn.setOnAction(event -> {
      FileChooser fileChooser = new FileChooser();

      //Set extension filter
      FileChooser.ExtensionFilter extFilterJPG = new FileChooser.ExtensionFilter("JPG files (*.jpg)", "*.JPG");
      FileChooser.ExtensionFilter extFilterPNG = new FileChooser.ExtensionFilter("PNG files (*.png)", "*.PNG");
      fileChooser.getExtensionFilters().addAll(extFilterJPG, extFilterPNG);

      //Show open file dialog
      File file = fileChooser.showOpenDialog(null);

      try {
        BufferedImage bufferedImage = ImageIO.read(file);
        Image image = SwingFXUtils.toFXImage(bufferedImage, null);
        imageView.setImage(image);
      } catch (IOException ex) {

      }
    });

    GridPane potentialGrid = new GridPane();

    ColumnConstraints col1 = new ColumnConstraints();
    col1.setPercentWidth(25);
    ColumnConstraints col2 = new ColumnConstraints();
    col2.setPercentWidth(10);
    ColumnConstraints col3 = new ColumnConstraints();
    col3.setPercentWidth(10);
    ColumnConstraints col4 = new ColumnConstraints();
    col4.setPercentWidth(10);
    ColumnConstraints col5 = new ColumnConstraints();
    col5.setPercentWidth(10);
    ColumnConstraints col6 = new ColumnConstraints();
    col6.setPercentWidth(10);
    potentialGrid.getColumnConstraints().addAll(col1, col2, col3, col4, col5, col6);

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
    potentialGrid.getRowConstraints().addAll(row1, row2, row3, row4, row5, row6, row7);

    Label motivation = createFormularLabel("Motivation");
    Label belastbarkeit = createFormularLabel("Belastbarkeit");
    Label reflexionsfähigkeit = createFormularLabel("Reflexionsfähigkeit");
    Label fachkompetenz = createFormularLabel("Fachkompetenz");
    Label flexibilität = createFormularLabel("Flexibilität");
    Label pünktlichkeit = createFormularLabel("Pünktlichkeit");

    motivation.getStyleClass().add("grid-item-left");
    belastbarkeit.getStyleClass().add("grid-item-left");
    reflexionsfähigkeit.getStyleClass().add("grid-item-left");
    fachkompetenz.getStyleClass().add("grid-item-left");
    flexibilität.getStyleClass().add("grid-item-left");
    pünktlichkeit.getStyleClass().add("grid-item-left");

    potentialGrid.add(motivation, 0, 1);
    potentialGrid.add(belastbarkeit, 0, 2);
    potentialGrid.add(reflexionsfähigkeit, 0, 3);
    potentialGrid.add(fachkompetenz, 0, 4);
    potentialGrid.add(flexibilität, 0, 5);
    potentialGrid.add(pünktlichkeit, 0, 6);

    Label sehrGering = createFormularLabel("sehr gering");
    Label gering = createFormularLabel("gering");
    Label mittel = createFormularLabel("mittel");
    Label stark = createFormularLabel("stark");
    Label sehrStark = createFormularLabel("sehr stark");

    sehrGering.getStyleClass().add("grid-item-top");
    gering.getStyleClass().add("grid-item-top");
    mittel.getStyleClass().add("grid-item-top");
    stark.getStyleClass().add("grid-item-top");
    sehrStark.getStyleClass().add("grid-item-top-right");

    potentialGrid.add(sehrGering, 1, 0);
    potentialGrid.add(gering, 2, 0);
    potentialGrid.add(mittel, 3, 0);
    potentialGrid.add(stark, 4, 0);
    potentialGrid.add(sehrStark, 5, 0);

    JFXRadioButton motivationRb1 = new JFXRadioButton();
    JFXRadioButton motivationRb2 = new JFXRadioButton();
    JFXRadioButton motivationRb3 = new JFXRadioButton();
    JFXRadioButton motivationRb4 = new JFXRadioButton();
    JFXRadioButton motivationRb5 = new JFXRadioButton();

    motivationRb5.getStyleClass().add("grid-item-right");

    ToggleGroup motivationTg = new ToggleGroup();
    motivationRb1.setToggleGroup(motivationTg);
    motivationRb2.setToggleGroup(motivationTg);
    motivationRb3.setToggleGroup(motivationTg);
    motivationRb4.setToggleGroup(motivationTg);
    motivationRb5.setToggleGroup(motivationTg);

    potentialGrid.add(motivationRb1, 1, 1);
    potentialGrid.add(motivationRb2, 2, 1);
    potentialGrid.add(motivationRb3, 3, 1);
    potentialGrid.add(motivationRb4, 4, 1);
    potentialGrid.add(motivationRb5, 5, 1);

    JFXRadioButton belastRb1 = new JFXRadioButton();
    JFXRadioButton belastRb2 = new JFXRadioButton();
    JFXRadioButton belastRb3 = new JFXRadioButton();
    JFXRadioButton belastRb4 = new JFXRadioButton();
    JFXRadioButton belastRb5 = new JFXRadioButton();

    belastRb5.getStyleClass().add("grid-item-right");

    ToggleGroup belastTg = new ToggleGroup();
    belastRb1.setToggleGroup(belastTg);
    belastRb2.setToggleGroup(belastTg);
    belastRb3.setToggleGroup(belastTg);
    belastRb4.setToggleGroup(belastTg);
    belastRb5.setToggleGroup(belastTg);

    potentialGrid.add(belastRb1, 1, 2);
    potentialGrid.add(belastRb2, 2, 2);
    potentialGrid.add(belastRb3, 3, 2);
    potentialGrid.add(belastRb4, 4, 2);
    potentialGrid.add(belastRb5, 5, 2);

    JFXRadioButton reflexRb1 = new JFXRadioButton();
    JFXRadioButton reflexRb2 = new JFXRadioButton();
    JFXRadioButton reflexRb3 = new JFXRadioButton();
    JFXRadioButton reflexRb4 = new JFXRadioButton();
    JFXRadioButton reflexRb5 = new JFXRadioButton();

    reflexRb5.getStyleClass().add("grid-item-right");

    ToggleGroup reflexTg = new ToggleGroup();
    reflexRb1.setToggleGroup(reflexTg);
    reflexRb2.setToggleGroup(reflexTg);
    reflexRb3.setToggleGroup(reflexTg);
    reflexRb4.setToggleGroup(reflexTg);
    reflexRb5.setToggleGroup(reflexTg);

    potentialGrid.add(reflexRb1, 1, 3);
    potentialGrid.add(reflexRb2, 2, 3);
    potentialGrid.add(reflexRb3, 3, 3);
    potentialGrid.add(reflexRb4, 4, 3);
    potentialGrid.add(reflexRb5, 5, 3);

    JFXRadioButton fachRb1 = new JFXRadioButton();
    JFXRadioButton fachRb2 = new JFXRadioButton();
    JFXRadioButton fachRb3 = new JFXRadioButton();
    JFXRadioButton fachRb4 = new JFXRadioButton();
    JFXRadioButton fachRb5 = new JFXRadioButton();

    fachRb5.getStyleClass().add("grid-item-right");

    ToggleGroup fachTg = new ToggleGroup();
    fachRb1.setToggleGroup(fachTg);
    fachRb2.setToggleGroup(fachTg);
    fachRb3.setToggleGroup(fachTg);
    fachRb4.setToggleGroup(fachTg);
    fachRb5.setToggleGroup(fachTg);

    potentialGrid.add(fachRb1, 1, 4);
    potentialGrid.add(fachRb2, 2, 4);
    potentialGrid.add(fachRb3, 3, 4);
    potentialGrid.add(fachRb4, 4, 4);
    potentialGrid.add(fachRb5, 5, 4);

    JFXRadioButton flexRb1 = new JFXRadioButton();
    JFXRadioButton flexRb2 = new JFXRadioButton();
    JFXRadioButton flexRb3 = new JFXRadioButton();
    JFXRadioButton flexRb4 = new JFXRadioButton();
    JFXRadioButton flexRb5 = new JFXRadioButton();

    flexRb5.getStyleClass().add("grid-item-right");

    ToggleGroup flexTg = new ToggleGroup();
    flexRb1.setToggleGroup(flexTg);
    flexRb2.setToggleGroup(flexTg);
    flexRb3.setToggleGroup(flexTg);
    flexRb4.setToggleGroup(flexTg);
    flexRb5.setToggleGroup(flexTg);

    potentialGrid.add(flexRb1, 1, 5);
    potentialGrid.add(flexRb2, 2, 5);
    potentialGrid.add(flexRb3, 3, 5);
    potentialGrid.add(flexRb4, 4, 5);
    potentialGrid.add(flexRb5, 5, 5);

    JFXRadioButton pünktRb1 = new JFXRadioButton();
    JFXRadioButton pünktRb2 = new JFXRadioButton();
    JFXRadioButton pünktRb3 = new JFXRadioButton();
    JFXRadioButton pünktRb4 = new JFXRadioButton();
    JFXRadioButton pünktRb5 = new JFXRadioButton();

    pünktRb5.getStyleClass().add("grid-item-right");

    ToggleGroup pünktTg = new ToggleGroup();
    pünktRb1.setToggleGroup(pünktTg);
    pünktRb2.setToggleGroup(pünktTg);
    pünktRb3.setToggleGroup(pünktTg);
    pünktRb4.setToggleGroup(pünktTg);
    pünktRb5.setToggleGroup(pünktTg);

    potentialGrid.add(pünktRb1, 1, 6);
    potentialGrid.add(pünktRb2, 2, 6);
    potentialGrid.add(pünktRb3, 3, 6);
    potentialGrid.add(pünktRb4, 4, 6);
    potentialGrid.add(pünktRb5, 5, 6);

    for (Node n : potentialGrid.getChildren()) {
      if (n instanceof Control) {
        Control control = (Control) n;
        control.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        control.setStyle("-fx-border-color: transparent transparent rgb(195, 202, 216) rgb(195, 202, 216); -fx-alignment: center");
      }
      if (n instanceof Pane) {
        Pane pane = (Pane) n;
        pane.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        pane.setStyle("-fx-border-color: transparent transparent rgb(195, 202, 216) rgb(195, 202, 216); -fx-alignment: center");
      }
    }

    container.getChildren().addAll(title, titleDesc, new Separator(),
        createFormularSubtitle("Allgemein"), createFormularLabel("Ein paar allgemeine Infos zum Start:"),
        createFormularVBox(0, createHBoxContainer(12, 0, createFormularLabel("1) Mein Name ist "), nameTf, createFormularLabel(".")),
            createHBoxContainer(12, 0, createFormularLabel("2) Ich studiere im "), semesterTf, createFormularLabel(" Semester.")),
            createHBoxContainer(12, 0, createFormularLabel("3) Neben dem Studium arbeite ich als "), berufTf, createFormularLabel(" bei "), berufFirma, createFormularLabel("."))),
        createFormularSubtitle("Foto"),
        createFormularLabel("Lade hier gern ein Foto von dir hoch. So wird die Kommunikation zwischen deinen Teammitgliedern noch persönlicher. Du hast gerade keins zur Hand? Dann erstelle dir doch ein individuelles Icon auf BitMoji.", true),
        createFormularLabel("Beachte bitte, dass es sich bei BitMoji um eine externe Plattform handelt, auf der du dich separat anmelden muss.", true),
        imageBtn,
        imageView,
        createFormularVBox(0, createFormularLabel("Meine Teamrolle nach Belbin Test:"), belbinCb),
        createFormularLabel("Falls du deine Rolle nicht kennst, kannst du dir auf dieser Website die Rollen durchlesen und dir die aussuchen, die nach deiner Einschätzung passt. Leider kann kein direkter Test bereit gestellt werden, da das gegen das Copyright verstoßen würde.", true),
        createFormularSubtitle("Potentialanalyse"),
        createFormularLabel("Mit dieser Tabelle könnt ihr euch im Team direkt im Hinblick auf bestimmte Kompetenzen einschätzen. Seid unbedingt ehrlich, nur so könnt ihr gemeinsam entscheiden, wie ihr damit umgeht. Eure Ergebnisse werden in einem Netzdiagramm übereinander gelegt, sodass ihr potentielle Risiken auf einen Blick erkennen könnt.", true),
        createFormularVBox(0, createFormularLabel(" Wie schätzt du deine Kompetenzen in Gruppenarbeiten ein? "), potentialGrid),
        new Separator(),
        createFormularSubtitle("Eisbrecherfragen"),
        createFormularLabel("Jetzt noch ein paar Fragen, die vollkommen optional sind. Keine Sorge, auch dein Dozent kann diese Antworten nicht sehen. Sie sind ausschließlich für dich und dein Team und bieten noch mehr Chancen, um sich kennenzulernen.", true),
        createFormularVBox(0, createFormularLabel("Wenn ich ein Tier wäre, wäre ich..."), eisbrecherTierTf),
        createFormularVBox(0, createFormularLabel("Der letzte Film, den ich gesehen habe, ist..."), eisbrecherFilmTf),
        createFormularVBox(0, createFormularLabel("Wenn ich mir eine Superkraft aussuchen könnte, wäre es..."), eisbrecherSuperkraftTf),
        new Separator(),
        createFormularSubtitle("Projekt"),
        createFormularLabel("Jetzt noch ein paar Fragen im Hinblick auf euer gemeinsames Team-Projekt."),
        createFormularVBox(0, createFormularLabel("Was mich besonders an diesem Projekt interessiert:"), projectTa),
        createFormularVBox(0, createFormularLabel("Diese Stärken (Fähigkeiten o. Eigenschaften) kann ich bei diesem Projekt einbringen:"), stärkeTa, createFormularHilfeLabel("Bitte nutze für jede Stärke eine neue Zeile.")),
        createFormularVBox(0, createFormularLabel("Das sind meine Schwächen im Hinblick auf die Projektarbeit:\n"), schwächeTa, createFormularHilfeLabel("Bitte nutze für jede Schwäche eine neue Zeile.")),
        new Separator(), absendenContainer
    );

    button.setOnAction(event -> {
      List<String> stärkeList = new ArrayList<>();
      for (String line : stärkeTa.getText().split("\\n")) {
        stärkeList.add(line);
      }

      List<String> schwächeList = new ArrayList<>();
      for (String line : schwächeTa.getText().split("\\n")) {
        schwächeList.add(line);
      }
      TeamMitgliedDTO teamMitgliedDTO = new TeamMitgliedDTO(imageView.getImage() != null ? imageView.getImage() : IconFactory.getImage(ImagesEnum.DEFAULT), nameTf.getText(), semesterTf.getNumberInt(),
          berufTf.getText(), berufFirma.getText(), belbinCb.getSelectionModel().getSelectedItem().toString(),
          projectTa.getText(), stärkeList, schwächeList,
          new ArrayList<>(Arrays.asList(eisbrecherTierTf.getText(), eisbrecherFilmTf.getText(), eisbrecherSuperkraftTf.getText())));
      DataController.getINSTANCE().addNewTeamMitglied(teamMitgliedDTO);
      PropertyFactory.firePropertyChange(NEW_TEAM_MEMBER_PROPERTY, null,
          teamMitgliedDTO);
    });
    return UIFactory.createScrollPane(container);
  }
}
