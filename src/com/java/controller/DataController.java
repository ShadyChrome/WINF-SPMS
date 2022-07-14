package com.java.controller;

import com.java.data.dto.ChanceDTO;
import com.java.data.dto.MeilensteinDTO;
import com.java.data.dto.NachrichtDTO;
import com.java.data.dto.RisikoDTO;
import com.java.data.dto.TeamDTO;
import com.java.data.dto.TeamMitgliedDTO;
import com.java.data.dto.UserStoryDTO;
import com.java.data.enums.AbgabeArtEnum;
import com.java.data.enums.BewertungsArtEnum;
import com.java.data.enums.FragenStyleEnum;
import com.java.data.enums.ImagesEnum;
import com.java.data.enums.IterationEnum;
import com.java.data.enums.PersonaEnum;
import com.java.data.enums.SchweregradEnum;
import com.java.data.enums.UserStoryStatusEnum;
import com.java.utility.IconFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.Stage;
import javafx.util.Pair;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DataController {

  private static final DataController INSTANCE = new DataController();
  private String activeUser;
  private Stage primaryStage;

  public static DataController getINSTANCE() {
    return INSTANCE;
  }

  private ObservableList<ObservableList<TeamMitgliedDTO>> teamMitgliederList = FXCollections.observableArrayList(
      FXCollections.observableArrayList(
          new TeamMitgliedDTO(IconFactory.getImage(ImagesEnum.LINH), "Leopold Thor", 4, "Data Analyst", "GLS Bank", "Implementer", "Was mich besonders an diesem Projekt interessiert, ist die Möglichkeit etwas zu entwickeln, das langfristig für alle Studierende relevant sein kann.", Arrays.asList("Zielorientiert", "Zeitmanagement"), Arrays.asList("Geduld bei Aufgabenabarbeitung bewahren"), Arrays.asList("Schildkröte", "Fight Club", "Fliegen")),
          new TeamMitgliedDTO(IconFactory.getImage(ImagesEnum.LISA), "Leila Schmidt", 6, "Kundenkontaktmanagement", "Stromnetz Berlin GmbH", "Implementer", "Ich freue mich darauf, etwas zu programmieren, was auch in der Praxis genutzt wird.", Arrays.asList("HTML", "Programmierung"), Arrays.asList("Angst vor Konflikten"), Arrays.asList("Hund", "Avatar", "Unsichtbar sein")),
          new TeamMitgliedDTO(IconFactory.getImage(ImagesEnum.MIMOSA), "Maria Löwe", 6, "Content Managerin", "HWR Berlin", "Teamworker", "Ich erhoffe mir neuen Input im Hinblick auf das Thema Projektmanagement.", Arrays.asList("Selbständigkeit", "Projektmanagement", "HTML"), Arrays.asList("Fehlende Erfahrung im Projektmanagement"), Arrays.asList("Delfin", "Planet der Affen", "Glück")),
          new TeamMitgliedDTO(IconFactory.getImage(ImagesEnum.LINH), "Jean Pierre", 4, "Support", "ITZBund", "Resource Investigator", "Ich habe bisher noch keine konkreten Vorstellung, freue mich auf die Zusammenarbeit.", Arrays.asList("Struturierung", "Aufgabenverteilung", "Recherche"), Arrays.asList("Zeitmanagement"), Arrays.asList("Katze", "Titanic", "Fliegen")),
          new TeamMitgliedDTO(IconFactory.getImage(ImagesEnum.LINH), "Max Mustermann", 4, "Softwareengineer", "ADVA", "Shaper", "Ich glaube, dass das Projekt meine Erfahrung im Programmieren voran bringen wird.", Arrays.asList("Kommunikation", "Planung", "HTML"), Arrays.asList("Programmierung"), Arrays.asList("Falke", "Spider Man", "Teleportieren"))
      ),
      FXCollections.observableArrayList(
          new TeamMitgliedDTO(IconFactory.getImage(ImagesEnum.LINH), "Greta Thunberg", 6, "IT-Support", "DKB", "Finisher", "Ich hoffe, dass ich meine Kenntnisse im Kurs vertiefen kann.", Arrays.asList("Zielorientiert", "Zeitmanagement"), Arrays.asList("Geduld bei Aufgabenabarbeitung bewahren"), Arrays.asList("Schildkröte", "Interstellar", "Fliegen")),
          new TeamMitgliedDTO(IconFactory.getImage(ImagesEnum.LISA), "Elon Musk", 6, "Softwareengineer", "Firm GmbH", "Implementer", "Ich habe eigentlich noch keine Ahnung, was mich erwartet.", Arrays.asList("HTML", "Programmierung"), Arrays.asList("Angst vor Konflikten"), Arrays.asList("Hund", "Kill Bill", "Schnelligkeit")),
          new TeamMitgliedDTO(IconFactory.getImage(ImagesEnum.MIMOSA), "Olaf Scholz", 6, "SHK IT", "HTW Berlin", "Teamworker", "Ich glaube, dass diese Projektarbeit auch in Zukunft noch viel nutzen hat.", Arrays.asList("Selbständigkeit", "Projektmanagement", "HTML"), Arrays.asList("Fehlende Erfahrung im Projektmanagement"), Arrays.asList("Delfin", "Planet der Affen", "Gedankenkontrolle")),
          new TeamMitgliedDTO(IconFactory.getImage(ImagesEnum.LINH), "Nico Zimmermann", 4, "Software-Entwickler", "ITZBund", "Resource Investigator", "Projektarbeit sollte Spaß machen.", Arrays.asList("Struturierung", "Aufgabenverteilung", "Recherche"), Arrays.asList("Zeitmanagement"), Arrays.asList("Katze", "Titanic", "Fliegen")),
          new TeamMitgliedDTO(IconFactory.getImage(ImagesEnum.LINH), "Lina Lochner", 4, "Softwareengineer", "ADVA", "Shaper", "Ich glaube, dass das Projekt meiine Erfahrung im Programmieren voran bringen wird.", Arrays.asList("Kommunikation", "Planung", "HTML"), Arrays.asList("Programmierung"), Arrays.asList("Falke", "Superman", "Teleportieren"))
      ),
      FXCollections.observableArrayList(
          new TeamMitgliedDTO(IconFactory.getImage(ImagesEnum.LINH), "Filiz Eberth", 4, "Support", "ITZBund", "Resource Investigator", "Ich habe bisher noch keine konkreten Vorstellung, freue mich auf die Zusammenarbeit.", Arrays.asList("Struturierung", "Aufgabenverteilung", "Recherche"), Arrays.asList("Zeitmanagement"), Arrays.asList("Katze", "Titanic", "Fliegen")),
          new TeamMitgliedDTO(IconFactory.getImage(ImagesEnum.LINH), "Kamil Misicher", 4, "Softwareengineer", "ADVA", "Shaper", "Ich glaube, dass das Projekt meine Erfahrung im Programmieren voran bringen wird.", Arrays.asList("Kommunikation", "Planung", "HTML"), Arrays.asList("Programmierung"), Arrays.asList("Falke", "Spider Man", "Teleportieren")),
          new TeamMitgliedDTO(IconFactory.getImage(ImagesEnum.LINH), "Veronique Kranz", 6, "IT-Support", "DKB", "Finisher", "Ich hoffe, dass ich meine Kenntnisse im Kurs vertiefen kann.", Arrays.asList("Zielorientiert", "Zeitmanagement"), Arrays.asList("Geduld bei Aufgabenabarbeitung bewahren"), Arrays.asList("Schildkröte", "Interstellar", "Fliegen")),
          new TeamMitgliedDTO(IconFactory.getImage(ImagesEnum.LISA), "Peter Schwital", 6, "Softwareengineer", "Firm GmbH", "Implementer", "Ich habe eigentlich noch keine Ahnung, was mich erwartet.", Arrays.asList("HTML", "Programmierung"), Arrays.asList("Angst vor Konflikten"), Arrays.asList("Hund", "Kill Bill", "Schnelligkeit")),
          new TeamMitgliedDTO(IconFactory.getImage(ImagesEnum.MIMOSA), "Arne Gorlitz", 6, "Content Manager", "HWR Berlin", "Teamworker", "Ich erhoffe mir neuen Input im Hinblick auf das Thema Projektmanagement.", Arrays.asList("Selbständigkeit", "Projektmanagement", "HTML"), Arrays.asList("Fehlende Erfahrung im Projektmanagement"), Arrays.asList("Delfin", "Planet der Affen", "Glück"))
      )
  );

  private List<NachrichtDTO> nachrichtenList = FXCollections.observableArrayList(
      new NachrichtDTO("Leopold Thor", "Max Mustermann", "FAQ", FragenStyleEnum.FREI_TEXT, "Wo finde ich die FAQ Seite?", null),
      new NachrichtDTO("Jean Pierre", "Leila Schmidt", "FAQ", FragenStyleEnum.CHECK_BOX, "Welche Themen soll ich für die Risikoanalyse bearbeiten?", Arrays.asList("Risiken", "Schwächen", "Stärken", "Schwächen")),
      new NachrichtDTO("Max Mustermann", "Jean Pierre", "FAQ", FragenStyleEnum.RADIUS_BUTTON, "Wäre es in Ordnung, wenn ich die Einsendeaufgabe 1 einen Tag später abgebe?", Arrays.asList("Ja", "Nein")),
      new NachrichtDTO("Leila Schmidt", "Maria Löwe", "FAQ", FragenStyleEnum.FREI_TEXT, "Wo finde ich die FAQ Seite?", null)
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
      new TeamDTO("WINF1", Arrays.asList("Leopold Thor", "Leila Schmidt", "Maria Löwe", "Jean Pierre", "Max Mustermann")),
      new TeamDTO("WINF2", Arrays.asList("Greta Thunberg", "Elon Musk", "Olaf Scholz", "Nico Zimmermann", "Lina Lochner")),
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
      Arrays.asList(new Pair("14.04.2022", "m1_löwe.pdf"), new Pair("21.04.2022", "m2_löwe.pdf"), new Pair("", ""), new Pair("", "")),
      Arrays.asList(new Pair("14.04.2022", "m1.pdf"), new Pair("18.04.2022", "m2.pdf"), new Pair("26.04.2022", "m3.pdf"), new Pair("", "")),
      Arrays.asList(new Pair("14.04.2022", "m1_mustermann.pdf"), new Pair("19.04.2022", "m2_mustermann.pdf"), new Pair("", ""), new Pair("", ""))
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

  private ObservableList<ObservableList<UserStoryDTO>> userStoryList = FXCollections.observableArrayList(
      FXCollections.observableArrayList(
          new UserStoryDTO("0001", "Projektstruktur definieren", "", "50.0", SchweregradEnum.COULD_HAVE, "Leopold Thor", "WINF1", "Max Mustermann", IterationEnum.ITERATION_1, "3", UserStoryStatusEnum.COMPLETED),
          new UserStoryDTO("0002", "Risikoanalyse durchführen", "", "75.0", SchweregradEnum.SHOULD_HAVE, "Leila Schmidt", "WINF1", "Max Mustermann", IterationEnum.ITERATION_1, "8", UserStoryStatusEnum.STARTED),
          new UserStoryDTO("0003", "User Stories definieren", "", "100.0", SchweregradEnum.MUST_HAVE, "Maria Löwe", "WINF1", "Max Mustermann", IterationEnum.ITERATION_1, "5", UserStoryStatusEnum.ACCEPTED),
          new UserStoryDTO("0005", "Einsendeaufgabe 1", "", "100.0", SchweregradEnum.MUST_HAVE, "", "WINF1", "Jean Pierre", IterationEnum.ITERATION_1, "5", UserStoryStatusEnum.DRAFT),
          new UserStoryDTO("0006", "Einsendeaufgabe 2", "", "75.0", SchweregradEnum.MUST_HAVE, "", "WINF1", "Jean Pierre", IterationEnum.ITERATION_2, "5", UserStoryStatusEnum.DRAFT),
          new UserStoryDTO("0007", "Einsendeaufgabe 3", "", "50.0", SchweregradEnum.MUST_HAVE, "", "WINF1", "Jean Pierre", IterationEnum.ITERATION_2, "5", UserStoryStatusEnum.DRAFT)
      ),
      FXCollections.observableArrayList(
          new UserStoryDTO("0101", "Aufgabenübersicht definieren", "", "50.0", SchweregradEnum.COULD_HAVE, "Greta Thunbergr", "WINF2", "Nico Zimmermann", IterationEnum.ITERATION_1, "3", UserStoryStatusEnum.COMPLETED),
          new UserStoryDTO("0102", "Risikoanalyse durchführen", "", "25.0", SchweregradEnum.COULD_HAVE, "Elon Musk", "WINF2", "Nico Zimmermann", IterationEnum.ITERATION_1, "2", UserStoryStatusEnum.STARTED),
          new UserStoryDTO("0103", "User Stories definieren", "", "75.0", SchweregradEnum.MUST_HAVE, "Olaf Scholz", "WINF2", "Nico Zimmermann", IterationEnum.ITERATION_1, "5", UserStoryStatusEnum.ACCEPTED),
          new UserStoryDTO("0105", "Einsendeaufgabe 1", "", "100.0", SchweregradEnum.MUST_HAVE, "", "WINF2", "Lina Lochner", IterationEnum.ITERATION_2, "5", UserStoryStatusEnum.DRAFT),
          new UserStoryDTO("0106", "Einsendeaufgabe 2", "", "75.0", SchweregradEnum.MUST_HAVE, "", "WINF2", "Lina Lochner", IterationEnum.ITERATION_2, "5", UserStoryStatusEnum.DRAFT),
          new UserStoryDTO("0107", "Einsendeaufgabe 3", "", "50.0", SchweregradEnum.MUST_HAVE, "", "WINF2", "Lina Lochner", IterationEnum.ITERATION_2, "5", UserStoryStatusEnum.DRAFT)
      ),
      FXCollections.observableArrayList(
          new UserStoryDTO("0201", "Aufgabenübersicht definieren", "", "100.0", SchweregradEnum.MUST_HAVE, "Kamil Misicher", "MINF1", "Filiz Eberth", IterationEnum.ITERATION_1, "2", UserStoryStatusEnum.COMPLETED),
          new UserStoryDTO("0202", "Risikoanalyse durchführen", "", "50.0", SchweregradEnum.COULD_HAVE, "Veronique Kranz", "MINF1", "Filiz Eberth", IterationEnum.ITERATION_1, "2", UserStoryStatusEnum.STARTED),
          new UserStoryDTO("0203", "User Stories definieren", "", "75.0", SchweregradEnum.SHOULD_HAVE, "Peter Schwital", "MINF1", "Filiz Eberth", IterationEnum.ITERATION_1, "2", UserStoryStatusEnum.ACCEPTED),
          new UserStoryDTO("0205", "Einsendeaufgabe 1", "", "100.0", SchweregradEnum.MUST_HAVE, "", "MINF1", "Arne Gorlitz", IterationEnum.ITERATION_1, "8", UserStoryStatusEnum.DRAFT),
          new UserStoryDTO("0206", "Einsendeaufgabe 2", "", "75.0", SchweregradEnum.MUST_HAVE, "", "MINF1", "Arne Gorlitz", IterationEnum.ITERATION_2, "8", UserStoryStatusEnum.DRAFT),
          new UserStoryDTO("0207", "Einsendeaufgabe 3", "", "50.0", SchweregradEnum.MUST_HAVE, "", "MINF1", "Arne Gorlitz", IterationEnum.ITERATION_2, "8", UserStoryStatusEnum.DRAFT)
      )
  );

  private Map<TeamDTO, ObservableList<UserStoryDTO>> teamUserStoryMap = IntStream.range(0, teamList.size()).boxed()
      .collect(Collectors.toMap(teamList::get, userStoryList::get));

  private Map<TeamDTO, ObservableList<TeamMitgliedDTO>> teamTeammitgliederMap = IntStream.range(0, teamList.size()).boxed()
      .collect(Collectors.toMap(teamList::get, teamMitgliederList::get));

  private String exampleGesamtFortschrittMINF1 = "50%";

  private PersonaEnum activePersona = PersonaEnum.DOZENT;
  private TeamDTO activeTeam;

  public List<TeamMitgliedDTO> getTeamMitglieder() {
    return getTeamTeammitgliederMap().get(DataController.getINSTANCE().getActiveTeam());
  }

  public void addNewTeamMitglied(TeamMitgliedDTO dto) {
    getTeamMitglieder().add(dto);
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

  public ObservableList<UserStoryDTO> getUserStoryList() {
    if (DataController.getINSTANCE().isDozent()) {
      ObservableList<UserStoryDTO> list = FXCollections.observableArrayList();
      for (ObservableList<UserStoryDTO> value : getTeamUserStoryMap().values()) {
        list.addAll(value);
      }
      return list;
    } else {
      return getTeamUserStoryMap().get(getActiveTeam());
    }
  }

  public ObservableList<UserStoryDTO> getUserStoryList(TeamDTO teamDTO) {
    return getTeamUserStoryMap().get(teamDTO);
  }

  public ObservableList<UserStoryDTO> getFilteredUserStoryList(TeamDTO teamDTO, IterationEnum iteration) {
    ObservableList<UserStoryDTO> userStoryDTOS = getTeamUserStoryMap().get(teamDTO);
    ObservableList<UserStoryDTO> filteredList = FXCollections.observableArrayList();

    for (UserStoryDTO userStoryDTO : userStoryDTOS) {
      if (userStoryDTO.getPlannedIn() == iteration) {
        filteredList.add(userStoryDTO);
      }
    }
    return filteredList;
  }

  public void addUserStory(String name) {
    UserStoryDTO dto = new UserStoryDTO(name);
    dto.setAuthor(DataController.getINSTANCE().getActiveUser());
    dto.setTeam(DataController.getINSTANCE().getActiveTeam().toString());
    List<UserStoryDTO> userStoryDTOS = getTeamUserStoryMap().get(getActiveTeam());
    userStoryDTOS.add(dto);
  }

  public Map<TeamDTO, ObservableList<UserStoryDTO>> getTeamUserStoryMap() {
    return teamUserStoryMap;
  }

  public Map<TeamDTO, ObservableList<TeamMitgliedDTO>> getTeamTeammitgliederMap() {
    return teamTeammitgliederMap;
  }
}
