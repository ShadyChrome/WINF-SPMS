package com.java.data;

import javafx.scene.image.Image;

import java.util.List;

public class TeamMitgliedDTO {

  private Image image;
  private String name;
  private final int alter;
  private final int semester;
  private final String beruf;
  private final String firma;
  private final String belbin;
  private final String projekt;
  private final List<String> stärke;
  private final List<String> schwäche;
  private final List<String> eisbrecher;

  public TeamMitgliedDTO(Image image, String name, int alter, int semester, String beruf, String firma, String belbin, String projekt, List<String> stärke, List<String> schwäche, List<String> eisbrecher) {
    this.image = image;
    this.name = name;
    this.alter = alter;
    this.semester = semester;
    this.beruf = beruf;
    this.firma = firma;
    this.belbin = belbin;
    this.projekt = projekt;
    this.stärke = stärke;
    this.schwäche = schwäche;
    this.eisbrecher = eisbrecher;
  }

  public Image getImage() {
    return image;
  }

  public String getName() {
    return name;
  }

  public int getAlter() {
    return alter;
  }

  public int getSemester() {
    return semester;
  }

  public String getBeruf() {
    return beruf;
  }

  public String getFirma() {
    return firma;
  }

  public String getBelbin() {
    return belbin;
  }

  public String getProjekt() {
    return projekt;
  }

  public List<String> getStärke() {
    return stärke;
  }

  public List<String> getSchwäche() {
    return schwäche;
  }

  public List<String> getEisbrecher() {
    return eisbrecher;
  }
}
