package com.java.data;

import java.util.List;

public class FrageDTO {

  private String empfänger;
  private FragenStyleEnum style;
  private String frage;
  private List<String> options;

  public FrageDTO(String empfänger, FragenStyleEnum style, String frage, List<String> options) {
    this.empfänger = empfänger;
    this.style = style;
    this.frage = frage;
    this.options = options;
  }

  public String getEmpfänger() {
    return empfänger;
  }

  public FragenStyleEnum getStyle() {
    return style;
  }

  public String getFrage() {
    return frage;
  }

  public List<String> getOptions() {
    return options;
  }
}
