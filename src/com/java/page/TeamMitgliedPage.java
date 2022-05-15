package com.java.page;

import com.java.components.IntegerTextField;
import com.java.data.BelbinRollenEnum;
import com.java.data.TeamMitglied;
import com.java.utility.PropertyFactory;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.embed.swing.SwingFXUtils;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Separator;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
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
    ScrollPane scrollPane = new ScrollPane();
    VBox container = new VBox();
    container.setSpacing(24);
    container.setPadding(new Insets(12));

    Label title = new Label("Teamvorstellung");
    title.getStyleClass().add("title-formular");
    Label titleDesc = new Label("Stelle dich hier deinen Teammitgliedern vor und helfe Ihnen dabei, dich besser kennenzulernen.");
    titleDesc.getStyleClass().add("titledesc");

    JFXButton button = new JFXButton("Absenden");
    HBox absendenContainer = createHBoxContainer(button);
    absendenContainer.setAlignment(Pos.CENTER);

    JFXTextField nameTf = new JFXTextField();
    IntegerTextField alterTf = new IntegerTextField();
    IntegerTextField semesterTf = new IntegerTextField();
    JFXTextField berufTf = new JFXTextField();
    JFXTextField berufFirma = new JFXTextField();
    JFXComboBox<BelbinRollenEnum> belbinCb = new JFXComboBox(FXCollections.observableArrayList(BelbinRollenEnum.values()));
    belbinCb.getSelectionModel().selectFirst();
    JFXTextArea projectTa = createFormularTextArea();
    JFXTextArea stärkeTa = createFormularTextArea();
    JFXTextArea schwächeTa = createFormularTextArea();
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
    container.getChildren().addAll(title, titleDesc, new Separator(),
        createFormularSubtitle("Allgemein"), createFormularLabel("Ein paar allgemeine Infos zum Start:"),
        createFormularVBox(createHBoxContainer(createFormularLabel("1) Mein Name ist "), nameTf, createFormularLabel(".")),
            createHBoxContainer(createFormularLabel("2) Ich bin "), alterTf, createFormularLabel(" Jahre alt.")),
            createHBoxContainer(createFormularLabel("3) Ich studiere im "), semesterTf, createFormularLabel(" Semester.")),
            createHBoxContainer(createFormularLabel("4) Neben dem Studium arbeite ich als "), berufTf, createFormularLabel(" bei "), berufFirma, createFormularLabel("."))),
        createFormularSubtitle("Foto"),
        createFormularLabel("Lade hier gern ein Foto von dir hoch. So wird die Kommunikation zwischen deinen Teammitgliedern noch persönlicher. Du hast gerade keins zur Hand? Dann erstelle dir doch ein individuelles Icon auf BitMoji.", true),
        imageBtn,
        imageView,
        createFormularSubtitle("Projekt"),
        createFormularLabel("Jetzt noch ein paar Fragen im Hinblick auf euer gemeinsames Team-Projekt."),
        createFormularVBox(createFormularLabel("Was mich besonders an diesem Projekt interessiert:"), projectTa),
        createFormularVBox(createFormularLabel("Meine Teamrolle nach Belbin Test:"), belbinCb),
        createFormularVBox(createFormularLabel("Diese Stärken (Fähigkeiten o. Eigenschaften) kann ich bei diesem Projekt einbringen:"), stärkeTa, createFormularHilfeLabel("Bitte nutze für jede Stärke eine neue Zeile.")),
        createFormularVBox(createFormularLabel("Das sind meine Schwächen im Hinblick auf die Projektarbeit:\n"), schwächeTa, createFormularHilfeLabel("Bitte nutze für jede Schwäche eine neue Zeile.")),
        new Separator(),
        createFormularSubtitle("Eisbrecherfragen"),
        createFormularLabel("Jetzt noch ein paar Fragen, die vollkommen optional sind. Keine Sorge, auch dein Prof kann diese Antworten nicht sehen. Sie sind ausschließlich für dich und dein Team und bieten noch mehr Chancen, um sich kennenzulernen.", true),
        createFormularVBox(createFormularLabel("Wenn ich ein Tier wäre, wäre ich..."), eisbrecherTierTf),
        createFormularVBox(createFormularLabel("Der letzte Film, den ich gesehen habe, ist..."), eisbrecherFilmTf),
        createFormularVBox(createFormularLabel("Wenn ich mir eine Superkraft aussuchen könnte, wäre es..."), eisbrecherSuperkraftTf),
        new Separator(), absendenContainer
    );

    List<String> stärkeList = new ArrayList<>();
    for (String line : stärkeTa.getText().split("\\n")) {
      stärkeList.add(line);
    }

    List<String> schwächeList = new ArrayList<>();
    for (String line : schwächeTa.getText().split("\\n")) {
      schwächeList.add(line);
    }

    button.setOnAction(event -> PropertyFactory.firePropertyChange(NEW_TEAM_MEMBER_PROPERTY, null,
        new TeamMitglied(null, nameTf.getText(), alterTf.getNumberInt(), semesterTf.getNumberInt(),
            berufTf.getText(), berufFirma.getText(), belbinCb.getSelectionModel().getSelectedItem().toString(),
            projectTa.getText(), stärkeList, schwächeList,
            new ArrayList<>(Arrays.asList(eisbrecherTierTf.getText(), eisbrecherFilmTf.getText(), eisbrecherSuperkraftTf.getText())))));

    scrollPane.setContent(container);
    scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
    scrollPane.setFitToWidth(true);
    return scrollPane;
  }
}
