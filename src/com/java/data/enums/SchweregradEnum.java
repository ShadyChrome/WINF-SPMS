package com.java.data.enums;

public enum SchweregradEnum {
  MUST_HAVE("Must-have"),
  SHOULD_AHVE("Should-have"),
  COULD_HAVE("Could-have")
  ;

  private String name;

  SchweregradEnum(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return name;
  }
}
