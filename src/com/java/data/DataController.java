package com.java.data;

import com.java.utility.IconFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
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

  private ObservableList<RisikoDTO> risikoList = FXCollections.observableArrayList();
  private ObservableList<ChanceDTO> chanceList = FXCollections.observableArrayList();
  private ObservableList<MeilensteinDTO> meilensteinList = FXCollections.observableArrayList(
      new MeilensteinDTO("Schwerpunkt festlegen", "Entscheidung zwischen Marketing und Eingangslogistik", LocalDate.of(2022, 4, 20) , AbgabeArtEnum.FREITEXT, BewertungsArtEnum.OHNE_BEWERTUNG),
      new MeilensteinDTO("User Stories", "25 User Stories definieren", LocalDate.of(2022, 4, 28), AbgabeArtEnum.UPLOAD, BewertungsArtEnum.GRUPPENLEISTUNG),
      new MeilensteinDTO("ESA 1", "", LocalDate.of(2022, 5, 1), AbgabeArtEnum.LINK, BewertungsArtEnum.EINZELLEISTUNG),
      new MeilensteinDTO("ESA 2", "", LocalDate.of(2022, 5, 10), AbgabeArtEnum.CHECKBOX, BewertungsArtEnum.EINZELLEISTUNG)
  );

  public List<TeamMitgliedDTO> getTeamMitglieder() {
    return teamMitgliederList;
  }

  public void addNewTeamMitglied(TeamMitgliedDTO dto) {
    teamMitgliederList.add(dto);
  }

  public List<NachrichtDTO> getNachrichten() {
    return nachrichtenList;
  }


  public ObservableList<RisikoDTO> getRisikoList() {
    return risikoList;
  }

  public ObservableList<ChanceDTO> getChanceList() {
    return chanceList;
  }

  public void addAllChancen(List<String> dtos) {
    for (String dto : dtos) {
      chanceList.add(new ChanceDTO(dto));
    }
  }

  public void addAllRisiken(List<String> dtos) {
    for (String dto : dtos) {
      risikoList.add(new RisikoDTO(dto, "Mittel", "", "", ""));
    }
  }

  public void addRisiko(String beschreibung) {
    risikoList.add(new RisikoDTO(beschreibung, "Mittel", "", "", ""));
  }

  public ObservableList<MeilensteinDTO> getMeilensteinList() {
    return meilensteinList;
  }
}
