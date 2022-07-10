package com.java.data.enums;

public enum IterationEnum {
  ITERATION_1("Iteration #1 (04.07.22 - 15.07.22)"),
  ITERATION_2("Iteration #2 (18.07.22 - 29.07.22)"),
  ;

  private String name;

  IterationEnum(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return name;
  }
}
