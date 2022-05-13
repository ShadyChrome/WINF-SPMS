package com.java.actions;

public class ActionItem {

  private String name;
  private Runnable runnable;

  public ActionItem(String name, Runnable runnable) {
    this.name = name;
    this.runnable = runnable;
  }

  public String getName() {
    return name;
  }

  public Runnable getRunnable() {
    return runnable;
  }
}
