package com.java.data;

import com.java.utility.IconFactory;
import javafx.collections.FXCollections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DataController {

  private static final DataController INSTANCE = new DataController();

  public static DataController getINSTANCE() {
    return INSTANCE;
  }

  private List<TeamMitgliedDTO> teamMitgliederList = new ArrayList<>(Arrays.asList(
      new TeamMitgliedDTO(IconFactory.getImage(ImagesEnum.LINH), "Linh Phung", 28, 4, "Data Analyst", "GLS Bank", "Implementer", "Was mich besonders an diesem Projekt interessiert, ist die Möglichkeit etwas zu entwickeln, das langfristig für alle Studierende relevant sein kann.", Arrays.asList("Zielorientiert", "Aufgabenverteilung", "HTML"), Arrays.asList("Geduld bei Aufgabenabarbeitung bewahren"), Arrays.asList("Katze", "Titanic", "Fliegen")),
      new TeamMitgliedDTO(IconFactory.getImage(ImagesEnum.LISA), "Lisa Spendel", 29, 6, "Kundenkontaktmanagement", "Stromnetz Berlin GmbH", "Implementer", "Was mich besonders an diesem Projekt interessiert, ist die Möglichkeit etwas zu entwickeln, das langfristig für alle Studierende relevant sein kann.", Arrays.asList("Zielorientiert", "Aufgabenverteilung", "HTML"), Arrays.asList("Geduld bei Aufgabenabarbeitung bewahren"), Arrays.asList("Hund", "Avatar", "Unsichtbar sein")),
      new TeamMitgliedDTO(IconFactory.getImage(ImagesEnum.MIMOSA), "Mimosa Luong", 29, 6, "Content Managerin", "HWR Berlin", "Teamworker", "Was mich besonders an diesem Projekt interessiert, ist die Möglichkeit etwas zu entwickeln, das langfristig für alle Studierende relevant sein kann.", Arrays.asList("Zielorientiert", "Aufgabenverteilung", "HTML"), Arrays.asList("Geduld bei Aufgabenabarbeitung bewahren"), Arrays.asList("Delfin", "Planet der Affen", "Glück")),
      new TeamMitgliedDTO(IconFactory.getImage(ImagesEnum.LINH), "Jörg Seelbinder", 40, 4, "Support", "ITZBund", "Resource Investigator", "Was mich besonders an diesem Projekt interessiert, ist die Möglichkeit etwas zu entwickeln, das langfristig für alle Studierende relevant sein kann.", Arrays.asList("Zielorientiert", "Aufgabenverteilung", "HTML"), Arrays.asList("Geduld bei Aufgabenabarbeitung bewahren"), Arrays.asList("Katze", "Titanic", "Fliegen")),
      new TeamMitgliedDTO(IconFactory.getImage(ImagesEnum.LINH), "Marcel Koschau", 27, 4, "Softwareengineer", "ADVA", "Shaper", "Was mich besonders an diesem Projekt interessiert, ist die Möglichkeit etwas zu entwickeln, das langfristig für alle Studierende relevant sein kann.", Arrays.asList("Zielorientiert", "Aufgabenverteilung", "HTML"), Arrays.asList("Geduld bei Aufgabenabarbeitung bewahren"), Arrays.asList("Falke", "Spider Man", "Teleportieren"))
  ));

  private List<NachrichtDTO> nachrichtenList = FXCollections.observableArrayList(
      new NachrichtDTO("Marcel Koschau", "Jörg Seelenbinder", "FAQ", FragenStyleEnum.FREI_TEXT, "Wo finde ich die FAQ Seite?", null),
      new NachrichtDTO("Jörg Seelenbinder", "Marcel Koschau", "FAQ", FragenStyleEnum.CHECK_BOX, "Wo finde ich die FAQ Seite?", Arrays.asList("Test 1", "Test 2", "Test 3")),
      new NachrichtDTO("Thuy Linh Phung", "Lisa Spendel", "FAQ", FragenStyleEnum.RADIUS_BUTTON, "Wo finde ich die FAQ Seite?", Arrays.asList("Test 1", "Test 2", "Test 3")),
      new NachrichtDTO("Mimosa Luong", "Thuy Linh Phung", "FAQ", FragenStyleEnum.FREI_TEXT, "Wo finde ich die FAQ Seite?", null)
  );

  public List<TeamMitgliedDTO> getTeamMitglieder() {
    return teamMitgliederList;
  }

  public List<NachrichtDTO> getNachrichten() {
    return nachrichtenList;
  }

}
