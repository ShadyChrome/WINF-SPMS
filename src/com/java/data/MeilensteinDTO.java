package com.java.data;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;

import java.time.LocalDate;

public class MeilensteinDTO {
  private SimpleStringProperty name;
  private String shortName = "";
  private SimpleStringProperty beschreibung;
  private ObjectProperty<LocalDate> deadline;
  private ObjectProperty<AbgabeArtEnum> abgabe;
  private ObjectProperty<BewertungsArtEnum> bewertung;
  private String projekt = "";

  public MeilensteinDTO(String name, String beschreibung, LocalDate deadline, AbgabeArtEnum abgabe, BewertungsArtEnum bewertung) {
    this.name = new SimpleStringProperty(name);
    this.beschreibung = new SimpleStringProperty(beschreibung);
    this.deadline = new SimpleObjectProperty(deadline);
    this.abgabe = new SimpleObjectProperty(abgabe);
    this.bewertung = new SimpleObjectProperty(bewertung);
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

  public LocalDate getDeadline() {
    return deadline.get();
  }

  public ObjectProperty<LocalDate> deadlineProperty() {
    return deadline;
  }

  public void setDeadline(LocalDate deadline) {
    this.deadline.set(deadline);
  }

  public AbgabeArtEnum getAbgabe() {
    return abgabe.get();
  }

  public ObjectProperty<AbgabeArtEnum> abgabeProperty() {
    return abgabe;
  }

  public void setAbgabe(AbgabeArtEnum abgabe) {
    this.abgabe.set(abgabe);
  }

  public BewertungsArtEnum getBewertung() {
    return bewertung.get();
  }

  public ObjectProperty<BewertungsArtEnum> bewertungProperty() {
    return bewertung;
  }

  public void setBewertung(BewertungsArtEnum bewertung) {
    this.bewertung.set(bewertung);
  }

  public String getProjekt() {
    return projekt;
  }

  public void setProjekt(String projekt) {
    this.projekt = projekt;
  }

  public String getShortName() {
    return shortName;
  }

  public void setShortName(String shortName) {
    this.shortName = shortName;
  }

  @Override
  public String toString() {
    return shortName + " - " + getName();
  }
}
