package com.java.model;

import com.java.controller.DataController;
import com.java.data.dto.UserStoryDTO;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.ObservableList;

public class DataModelUserStory {
  private final ObjectProperty<UserStoryDTO> currentUserStory = new SimpleObjectProperty<>();

  public final ObjectProperty<UserStoryDTO> currentUserStoryProperty() {
    return this.currentUserStory;
  }

  public UserStoryDTO getCurrentUserStory() {
    return currentUserStory.get();
  }

  public void setCurrentUserStory(UserStoryDTO currentUserStory) {
    this.currentUserStory.set(currentUserStory);
  }

  public ObservableList<UserStoryDTO> getUserStories() {
    return DataController.getINSTANCE().getUserStoryList();
  }
}
