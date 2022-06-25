package com.java.data;

import java.util.List;

public class TeamDTO {

  private String teamName;
  private List<String> mitglieder;

  public TeamDTO(String teamName, List<String> mitglieder) {
    this.teamName = teamName;
    this.mitglieder = mitglieder;
  }

  @Override
  public String toString() {
    return teamName;
  }

  public List<String> getMitglieder() {
    return mitglieder;
  }
}
