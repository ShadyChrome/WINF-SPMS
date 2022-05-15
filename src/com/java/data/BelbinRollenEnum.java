package com.java.data;

public enum BelbinRollenEnum {
  RESOURCE_INVESTIGATOR("Resource Investigator"),
  TEAMWORKER("Teamworker"),
  CO_ORDINATOR("Co-ordinator"),
  PLANT("Plant"),
  MONITOR_EVALUATOR("Monitor-Evaluator"),
  SPECIALIST("Specialist"),
  IMPLEMENTER("Implementer"),
  FINISHER("Finisher"),
  SHAPER("Shaper"),
  ;

  private String name;

  BelbinRollenEnum(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return name;
  }
}
