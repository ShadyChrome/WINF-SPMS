package com.java.page;

import com.java.utility.UIFactory;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.layout.VBox;

import static com.java.utility.UIFactory.createFormularLabel;
import static com.java.utility.UIFactory.createFormularSubSubtitle;
import static com.java.utility.UIFactory.createFormularSubtitle;
import static com.java.utility.UIFactory.createFormularVBox;
import static com.java.utility.UIFactory.createHBoxContainer;

public class InnovationPage implements TabPages {

  public Node getLeftNode() {
    Label title = new Label("Innovation");
    title.getStyleClass().add("title");

    Hyperlink link1 = new Hyperlink("Überschrift 1");
    Hyperlink subLink1 = new Hyperlink("    Unterüberschrift 1");
    Hyperlink subLink2 = new Hyperlink("    Unterüberschrift 2");
    Hyperlink subLink3 = new Hyperlink("    Unterüberschrift 3");
    Hyperlink link2 = new Hyperlink("Überschrift 2");
    Hyperlink subLink4 = new Hyperlink("    Unterüberschrift 4");
    Hyperlink subLink5 = new Hyperlink("    Unterüberschrift 5");
    Hyperlink subLink6 = new Hyperlink("    Unterüberschrift 6");
    Hyperlink link3 = new Hyperlink("Überschrift 3");
    Hyperlink subLink7 = new Hyperlink("    Unterüberschrift 7");
    Hyperlink subLink8 = new Hyperlink("    Unterüberschrift 8");
    Hyperlink subLink9 = new Hyperlink("    Unterüberschrift 9");

    VBox vBox = UIFactory.createFormularVBox(12, title, UIFactory.createFormularVBox(6, link1, subLink1, subLink2, subLink3),
        UIFactory.createFormularVBox(6, link2, subLink4, subLink5, subLink6),
        UIFactory.createFormularVBox(6, link3, subLink7, subLink8, subLink9));
    vBox.setAlignment(Pos.TOP_LEFT);
    return vBox;
  }

  public Node getCenterNode() {
    VBox container = new VBox();
    container.setSpacing(24);
    container.setPadding(new Insets(12));

    Label title = new Label("Innovation");
    title.getStyleClass().add("title-formular");
    Label titleDesc = new Label("Das ist ein Beispieltext.");
    titleDesc.getStyleClass().add("titledesc");
    titleDesc.setWrapText(true);

    container.getChildren().addAll(title, titleDesc, new Separator(),
        createFormularSubtitle("Überschrift 1"), createFormularLabel("Ein paar Random Texte zum Start:"),
        createFormularSubSubtitle("Unterüberschrift 1"), createFormularLabel("Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua.", true),
        createFormularSubSubtitle("Unterüberschrift 2"), createFormularLabel("Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet.", true),
        createFormularSubSubtitle("Unterüberschrift 3"), createFormularLabel("At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet.", true),
        new Separator(),
        createFormularSubtitle("Überschrift 2"), createFormularLabel("Ein paar weitere Random Texte:"),
        createFormularSubSubtitle("Unterüberschrift 4"), createFormularLabel("Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua.", true),
        createFormularSubSubtitle("Unterüberschrift 5"), createFormularLabel("Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet.", true),
        createFormularSubSubtitle("Unterüberschrift 6"), createFormularLabel("At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet.", true),
        new Separator(),
        createFormularSubtitle("Überschrift 3"), createFormularLabel("Ein paar Random Texte fürs Ende:"),
        createFormularSubSubtitle("Unterüberschrift 7"), createFormularLabel("Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua.", true),
        createFormularSubSubtitle("Unterüberschrift 8"), createFormularLabel("Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet.", true),
        createFormularSubSubtitle("Unterüberschrift 9"), createFormularLabel("At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet.", true)

    );

    return UIFactory.createScrollPane(container);
  }
}