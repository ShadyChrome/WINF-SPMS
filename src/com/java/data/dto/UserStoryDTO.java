package com.java.data.dto;

import com.java.data.enums.SchweregradEnum;

public class UserStoryDTO {
  private int id;
  private String name;
  private String beschreibung;
  private double priorität = 50.0;
  private SchweregradEnum severity = SchweregradEnum.SHOULD_AHVE;
  private String assignee;
  private String team;
  private String author;
  private String plannedIn;
  private int estimation;

  public UserStoryDTO(String name) {
    this.name = name;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getBeschreibung() {
    return beschreibung;
  }

  public void setBeschreibung(String beschreibung) {
    this.beschreibung = beschreibung;
  }

  public double getPriorität() {
    return priorität;
  }

  public void setPriorität(double priorität) {
    this.priorität = priorität;
  }

  public SchweregradEnum getSeverity() {
    return severity;
  }

  public void setSeverity(SchweregradEnum severity) {
    this.severity = severity;
  }

  public String getAssignee() {
    return assignee;
  }

  public void setAssignee(String assignee) {
    this.assignee = assignee;
  }

  public String getTeam() {
    return team;
  }

  public void setTeam(String team) {
    this.team = team;
  }

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public String getPlannedIn() {
    return plannedIn;
  }

  public void setPlannedIn(String plannedIn) {
    this.plannedIn = plannedIn;
  }

  public int getEstimation() {
    return estimation;
  }

  public void setEstimation(int estimation) {
    this.estimation = estimation;
  }
}
