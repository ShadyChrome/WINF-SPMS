package com.java.data;

import javafx.beans.property.SimpleStringProperty;

public class RisikoDTO {
  private SimpleStringProperty risikoBeschreibung;
  private SimpleStringProperty eintrittsWahrscheinlichkeit;
  private SimpleStringProperty auswirkung;
  private SimpleStringProperty userStory;
  private SimpleStringProperty massnahmen;

  public RisikoDTO(String risikoBeschreibung, String eintrittsWahrscheinlichkeit, String auswirkung, String userStory, String massnahmen) {
    this.risikoBeschreibung = new SimpleStringProperty(risikoBeschreibung);
    this.eintrittsWahrscheinlichkeit = new SimpleStringProperty(eintrittsWahrscheinlichkeit);
    this.auswirkung = new SimpleStringProperty(auswirkung);
    this.userStory = new SimpleStringProperty(userStory);
    this.massnahmen = new SimpleStringProperty(massnahmen);
  }

  public String getRisikoBeschreibung() {
    return risikoBeschreibung.get();
  }

  public SimpleStringProperty risikoBeschreibungProperty() {
    return risikoBeschreibung;
  }

  public void setRisikoBeschreibung(String risikoBeschreibung) {
    this.risikoBeschreibung.set(risikoBeschreibung);
  }

  public String getEintrittsWahrscheinlichkeit() {
    return eintrittsWahrscheinlichkeit.get();
  }

  public SimpleStringProperty eintrittsWahrscheinlichkeitProperty() {
    return eintrittsWahrscheinlichkeit;
  }

  public void setEintrittsWahrscheinlichkeit(String eintrittsWahrscheinlichkeit) {
    this.eintrittsWahrscheinlichkeit.set(eintrittsWahrscheinlichkeit);
  }

  public String getAuswirkung() {
    return auswirkung.get();
  }

  public SimpleStringProperty auswirkungProperty() {
    return auswirkung;
  }

  public void setAuswirkung(String auswirkung) {
    this.auswirkung.set(auswirkung);
  }

  public String getUserStory() {
    return userStory.get();
  }

  public SimpleStringProperty userStoryProperty() {
    return userStory;
  }

  public void setUserStory(String userStory) {
    this.userStory.set(userStory);
  }

  public String getMassnahmen() {
    return massnahmen.get();
  }

  public SimpleStringProperty massnahmenProperty() {
    return massnahmen;
  }

  public void setMassnahmen(String massnahmen) {
    this.massnahmen.set(massnahmen);
  }
}
