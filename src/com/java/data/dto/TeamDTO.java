package com.java.data.dto;

import java.util.ArrayList;
import java.util.List;

public class TeamDTO {

  private String teamName;
  private List<String> mitglieder;
  private List<MeilensteinDTO> meilensteine = new ArrayList<>();

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

  public void addMeilenstein(MeilensteinDTO dto) {
    meilensteine.add(dto);
  }

  public List<MeilensteinDTO> getMeilensteine() {
    return meilensteine;
  }
}
