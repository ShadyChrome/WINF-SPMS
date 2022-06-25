package com.java.data;

import java.util.List;

public class TeamDTO {

  private String teamName;
  private List<String> mitglieder;

  public TeamDTO(String teamName, List<String> mitglieder) {
    this.teamName = teamName;
    this.mitglieder = mitglieder;
  }
}
