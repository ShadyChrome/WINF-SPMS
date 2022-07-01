package com.java.data.dto;

import com.java.data.enums.FragenStyleEnum;

import java.util.ArrayList;
import java.util.List;

public class NachrichtDTO {

  private String absender;
  private String empfänger;
  private String betreff;
  private FragenStyleEnum style;
  private String nachricht;
  private List<String> options;

  public NachrichtDTO(String absender, String empfänger, String betreff, FragenStyleEnum style, String nachricht, List<String> options) {
    this.absender = absender;
    this.empfänger = empfänger;
    this.betreff = betreff;
    this.style = style;
    this.nachricht = nachricht;
    this.options = options == null ? new ArrayList<>() : options;
  }

  public String getAbsender() {
    return absender;
  }

  public String getEmpfänger() {
    return empfänger;
  }

  public String getBetreff() {
    return betreff;
  }

  public FragenStyleEnum getStyle() {
    return style;
  }

  public String getNachricht() {
    return nachricht;
  }

  public List<String> getOptions() {
    return options;
  }
}
