package com.java.data;

import com.java.utility.IconFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.Stage;
import javafx.util.Pair;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DataController {

  private static final DataController INSTANCE = new DataController();
  private String activeUser;
  private Stage primaryStage;

  public static DataController getINSTANCE() {
    return INSTANCE;
  }

  private List<TeamMitgliedDTO> teamMitgliederList = new ArrayList<>(Arrays.asList(
      new TeamMitgliedDTO(IconFactory.getImage(ImagesEnum.LINH), "Leopold Thor", 28, 4, "Data Analyst", "GLS Bank", "Implementer", "Was mich besonders an diesem Projekt interessiert, ist die Möglichkeit etwas zu entwickeln, das langfristig für alle Studierende relevant sein kann.", Arrays.asList("Zielorientiert", "Zeitmanagement"), Arrays.asList("Geduld bei Aufgabenabarbeitung bewahren"), Arrays.asList("Schildkröte", "Fight Club", "Fliegen")),
      new TeamMitgliedDTO(IconFactory.getImage(ImagesEnum.LISA), "Leila Schmidt", 29, 6, "Kundenkontaktmanagement", "Stromnetz Berlin GmbH", "Implementer", "Ich freue mich darauf, etwas zu programmieren, was auch in der Praxis genutzt wird.", Arrays.asList("HTML", "Programmierung"), Arrays.asList("Angst vor Konflikten"), Arrays.asList("Hund", "Avatar", "Unsichtbar sein")),
      new TeamMitgliedDTO(IconFactory.getImage(ImagesEnum.MIMOSA), "Maria Löwe", 29, 6, "Content Managerin", "HWR Berlin", "Teamworker", "Ich erhoffe mir neuen Input im Hinblick auf das Thema Projektmanagement.", Arrays.asList("Selbständigkeit", "Projektmanagement", "HTML"), Arrays.asList("Fehlende Erfahrung im Projektmanagement"), Arrays.asList("Delfin", "Planet der Affen", "Glück")),
      new TeamMitgliedDTO(IconFactory.getImage(ImagesEnum.LINH), "Jean Pierre", 40, 4, "Support", "ITZBund", "Resource Investigator", "Ich habe bisher noch keine konkreten Vorstellung, freue mich auf die Zusammenarbeit.", Arrays.asList("Struturierung", "Aufgabenverteilung", "Recherche"), Arrays.asList("Zeitmanagement"), Arrays.asList("Katze", "Titanic", "Fliegen")),
      new TeamMitgliedDTO(IconFactory.getImage(ImagesEnum.LINH), "Max Mustermann", 27, 4, "Softwareengineer", "ADVA", "Shaper", "Ich glaube, dass das Projekt meiine Erfahrung im Programmieren voran bringen wird.", Arrays.asList("Kommunikation", "Planung", "HTML"), Arrays.asList("Programmierung"), Arrays.asList("Falke", "Spider Man", "Teleportieren"))
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
      new MeilensteinDTO("Schwerpunkt festlegen", "Entscheidung zwischen Marketing und Eingangslogistik", LocalDate.of(2022, 4, 20), AbgabeArtEnum.FREITEXT, BewertungsArtEnum.OHNE_BEWERTUNG),
      new MeilensteinDTO("User Stories", "25 User Stories definieren", LocalDate.of(2022, 4, 28), AbgabeArtEnum.UPLOAD, BewertungsArtEnum.GRUPPENLEISTUNG),
      new MeilensteinDTO("ESA 1", "", LocalDate.of(2022, 5, 1), AbgabeArtEnum.UPLOAD, BewertungsArtEnum.EINZELLEISTUNG),
      new MeilensteinDTO("ESA 2", "", LocalDate.of(2022, 5, 10), AbgabeArtEnum.LINK, BewertungsArtEnum.EINZELLEISTUNG)
  );

  private ObservableList<TeamDTO> teamList = FXCollections.observableArrayList(
      new TeamDTO("WINF1", Arrays.asList("Birgitta Hertrampf", "Danny Fechner", "Gunda Siering", "Hans-Gerhard Matthäi", "Liliane Stolze")),
      new TeamDTO("WINF2", Arrays.asList("Mimosa Luong", "Linh Phung", "Lisa Spendel", "Marcel Koschau", "Jörg Seelenbinder")),
      new TeamDTO("MINF1", Arrays.asList("Filiz Eberth", "Kamil Misicher", "Veronique Kranz", "Peter Schwital", "Arne Gorlitz"))
  );

  private ObservableList<List<String>> exampleFortschrittWINF1 = FXCollections.observableArrayList(
      Arrays.asList("15. Apr", "24. Apr", "", "", "50%"),
      Arrays.asList("12. Apr", "21. Apr", "26. Apr", "", "75%"),
      Arrays.asList("14. Apr", "21. Apr", "", "", "50%"),
      Arrays.asList("14. Apr", "18. Apr", "26. Apr", "", "75%"),
      Arrays.asList("14. Apr", "19. Apr", "", "", "50%")
  );

  private ObservableList<List<Pair<String, String>>> exampleAbgabeWINF1 = FXCollections.observableArrayList(
      Arrays.asList(new Pair("15.04.2022", "m1.pdf"), new Pair("24.04.2022", "m2.pdf"), new Pair("", ""), new Pair("", "")),
      Arrays.asList(new Pair("12.04.2022", "m1.docx"), new Pair("21.04.2022", "m2.docx"), new Pair("26.04.2022", "m3.docx"), new Pair("", "")),
      Arrays.asList(new Pair("14.04.2022", "m1_siering.pdf"), new Pair("21.04.2022", "m2_siering.pdf"), new Pair("", ""), new Pair("", "")),
      Arrays.asList(new Pair("14.04.2022", "m1.pdf"), new Pair("18.04.2022", "m2.pdf"), new Pair("26.04.2022", "m3.pdf"), new Pair("", "")),
      Arrays.asList(new Pair("14.04.2022", "m1_stolze.pdf"), new Pair("19.04.2022", "m2_stolze.pdf"), new Pair("", ""), new Pair("", ""))
  );

  private String exampleGesamtFortschrittWINF1 = "60%";

  private ObservableList<List<String>> exampleFortschrittWINF2 = FXCollections.observableArrayList(
      Arrays.asList("19. Apr", "22. Apr", "23. Apr", "", "75%"),
      Arrays.asList("19. Apr", "22. Apr", "", "", "50%"),
      Arrays.asList("19. Apr", "22. Apr", "25. Apr", "", "75%"),
      Arrays.asList("19. Apr", "22. Apr", "27. Apr", "", "75%"),
      Arrays.asList("19. Apr", "22. Apr", "29. Apr", "", "75%")
  );

  private ObservableList<List<Pair<String, String>>> exampleAbgabeWINF2 = FXCollections.observableArrayList(
      Arrays.asList(new Pair("19.04.2022", "m1_luong.pdf"), new Pair("22.04.2022", "m2_luong.pdf"), new Pair("23.04.2022", "m3_luong.pdf"), new Pair("", "")),
      Arrays.asList(new Pair("19.04.2022", "m1_phung.pdf"), new Pair("22.04.2022", "m2_phung.pdf"), new Pair("", ""), new Pair("", "")),
      Arrays.asList(new Pair("19.04.2022", "m1_spendel.pdf"), new Pair("22.04.2022", "m2_spendel.pdf"), new Pair("25.04.2022", "m3_spendel.pdf"), new Pair("", "")),
      Arrays.asList(new Pair("19.04.2022", "m1_koschau.pdf"), new Pair("22.04.2022", "m2_koschau.pdf"), new Pair("27.04.2022", "m3_koschau.pdf"), new Pair("", "")),
      Arrays.asList(new Pair("19.04.2022", "m1_seelenbinder.pdf"), new Pair("22.04.2022", "m2_seelenbinder.pdf"), new Pair("29.04.2022", "m3_seelenbinder.pdf"), new Pair("", ""))
  );

  private String exampleGesamtFortschrittWINF2 = "70%";

  private ObservableList<List<String>> exampleFortschrittMINF1 = FXCollections.observableArrayList(
      Arrays.asList("19. Apr", "24. Apr", "", "", "50%"),
      Arrays.asList("17. Apr", "21. Apr", "", "", "50%"),
      Arrays.asList("16. Apr", "21. Apr", "", "", "50%"),
      Arrays.asList("14. Apr", "18. Apr", "", "", "50%"),
      Arrays.asList("14. Apr", "18. Apr", "", "", "50%")
  );

  private ObservableList<List<Pair<String, String>>> exampleAbgabeMINF1 = FXCollections.observableArrayList(
      Arrays.asList(new Pair("19.04.2022", "m1_eberth.pdf"), new Pair("24.04.2022", "m2_eberth.pdf"), new Pair("", ""), new Pair("", "")),
      Arrays.asList(new Pair("17.04.2022", "m1_misicher.pdf"), new Pair("21.04.2022", "m2_misicher.pdf"), new Pair("", ""), new Pair("", "")),
      Arrays.asList(new Pair("16.04.2022", "m1_kranz.pdf"), new Pair("21.04.2022", "m2_kranz.pdf"), new Pair("", ""), new Pair("", "")),
      Arrays.asList(new Pair("14.04.2022", "m1_schwital.pdf"), new Pair("18.04.2022", "m2_schwital.pdf"), new Pair("", ""), new Pair("", "")),
      Arrays.asList(new Pair("14.04.2022", "m1_gorlitz.pdf"), new Pair("18.04.2022", "m2_gorlitz.pdf"), new Pair("", ""), new Pair("", ""))
  );

  private String exampleGesamtFortschrittMINF1 = "50%";

  private PersonaEnum activePersona = PersonaEnum.DOZENT;
  private TeamDTO activeTeam;

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

  public void addMeilenstein(String name) {
    meilensteinList.add(new MeilensteinDTO(name, "", LocalDate.now(), AbgabeArtEnum.FREITEXT, BewertungsArtEnum.OHNE_BEWERTUNG));
  }

  public ObservableList<TeamDTO> getTeamList() {
    return teamList;
  }

  public ObservableList<List<String>> getExampleFortschrittWINF1() {
    return exampleFortschrittWINF1;
  }

  public String getExampleGesamtFortschrittWINF1() {
    return exampleGesamtFortschrittWINF1;
  }

  public ObservableList<List<String>> getExampleFortschrittWINF2() {
    return exampleFortschrittWINF2;
  }

  public String getExampleGesamtFortschrittWINF2() {
    return exampleGesamtFortschrittWINF2;
  }

  public ObservableList<List<String>> getExampleFortschrittMINF1() {
    return exampleFortschrittMINF1;
  }

  public String getExampleGesamtFortschrittMINF1() {
    return exampleGesamtFortschrittMINF1;
  }

  public ObservableList<List<Pair<String, String>>> getExampleAbgabeWINF1() {
    return exampleAbgabeWINF1;
  }

  public ObservableList<List<Pair<String, String>>> getExampleAbgabeWINF2() {
    return exampleAbgabeWINF2;
  }

  public ObservableList<List<Pair<String, String>>> getExampleAbgabeMINF1() {
    return exampleAbgabeMINF1;
  }

  public void setActivePersona(PersonaEnum newValue) {
    this.activePersona = newValue;
  }

  public boolean isDozent() {
    return activePersona == PersonaEnum.DOZENT;
  }

  public TeamDTO getActiveTeam() {
    return activeTeam;
  }

  public void setActiveTeam(TeamDTO activeTeam) {
    this.activeTeam = activeTeam;
  }

  public void setActiveUser(String newUserName) {
    this.activeUser = newUserName;
  }

  public String getActiveUser() {
    return activeUser;
  }

  public void setPrimaryStage(Stage primaryStage) {
    this.primaryStage = primaryStage;
  }

  public Stage getPrimaryStage() {
    return primaryStage;
  }
}
