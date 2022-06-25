package com.java.data;

public enum AbgabeArtEnum {
  CHECKBOX("Checkbox"),
  UPLOAD("Upload"),
  LINK("Link"),
  FREITEXT("Freitext"),
  ;

  private String name;

  AbgabeArtEnum(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return name;
  }
}
