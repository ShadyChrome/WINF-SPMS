package com.java.data;

public enum BewertungsArtEnum {
  OHNE_BEWERTUNG("Ohne Bewertung"),
  EINZELLEISTUNG("Einzelleistung"),
  GRUPPENLEISTUNG("Gruppenleistung"),
  ;

  private String name;

  BewertungsArtEnum(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return name;
  }
}
