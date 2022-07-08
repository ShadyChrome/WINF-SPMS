package com.java.data.dto;

import com.java.data.enums.SchweregradEnum;
import com.java.data.enums.UserStoryStatusEnum;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;

public class UserStoryDTO {
  private SimpleStringProperty id;
  private SimpleStringProperty name;
  private SimpleStringProperty beschreibung;
  private SimpleStringProperty priorität = new SimpleStringProperty("" + 50.0);
  private SimpleObjectProperty<SchweregradEnum> severity = new SimpleObjectProperty<>(SchweregradEnum.SHOULD_AHVE);
  private SimpleStringProperty assignee;
  private SimpleStringProperty team;
  private SimpleStringProperty author;
  private SimpleStringProperty plannedIn;
  private SimpleStringProperty estimation;
  private SimpleObjectProperty<UserStoryStatusEnum> status = new SimpleObjectProperty<>(UserStoryStatusEnum.DRAFT);

  public UserStoryDTO(String name) {
    setName(name);
  }

  public String getId() {
    return id.get();
  }

  public SimpleStringProperty idProperty() {
    return id;
  }

  public void setId(String id) {
    this.id.set(id);
  }

  public String getName() {
    return name.get();
  }

  public SimpleStringProperty nameProperty() {
    return name;
  }

  public void setName(String name) {
    this.name.set(name);
  }

  public String getBeschreibung() {
    return beschreibung.get();
  }

  public SimpleStringProperty beschreibungProperty() {
    return beschreibung;
  }

  public void setBeschreibung(String beschreibung) {
    this.beschreibung.set(beschreibung);
  }

  public SchweregradEnum getSeverity() {
    return severity.get();
  }

  public SimpleObjectProperty<SchweregradEnum> severityProperty() {
    return severity;
  }

  public void setSeverity(SchweregradEnum severity) {
    this.severity.set(severity);
  }

  public String getAssignee() {
    return assignee.get();
  }

  public SimpleStringProperty assigneeProperty() {
    return assignee;
  }

  public void setAssignee(String assignee) {
    this.assignee.set(assignee);
  }

  public String getTeam() {
    return team.get();
  }

  public SimpleStringProperty teamProperty() {
    return team;
  }

  public void setTeam(String team) {
    this.team.set(team);
  }

  public String getAuthor() {
    return author.get();
  }

  public SimpleStringProperty authorProperty() {
    return author;
  }

  public void setAuthor(String author) {
    this.author.set(author);
  }

  public String getPlannedIn() {
    return plannedIn.get();
  }

  public SimpleStringProperty plannedInProperty() {
    return plannedIn;
  }

  public void setPlannedIn(String plannedIn) {
    this.plannedIn.set(plannedIn);
  }

  public UserStoryStatusEnum getStatus() {
    return status.get();
  }

  public SimpleObjectProperty<UserStoryStatusEnum> statusProperty() {
    return status;
  }

  public void setStatus(UserStoryStatusEnum status) {
    this.status.set(status);
  }

  public String getPriorität() {
    return priorität.get();
  }

  public SimpleStringProperty prioritätProperty() {
    return priorität;
  }

  public void setPriorität(String priorität) {
    this.priorität.set(priorität);
  }

  public String getEstimation() {
    return estimation.get();
  }

  public SimpleStringProperty estimationProperty() {
    return estimation;
  }

  public void setEstimation(String estimation) {
    this.estimation.set(estimation);
  }
}
