package com.java.utility;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Properties;

public class PropertyFactory {
  private final Properties DEFAULT_PROPERTIES;
  private final Properties PROPERTIES;

  private final PropertyChangeSupport PROPERTY_CHANGE_SUPPORT;

  private static PropertyFactory INSTANCE = new PropertyFactory();

  protected PropertyFactory() {
    PROPERTY_CHANGE_SUPPORT = new PropertyChangeSupport(this);
  }

  {
    DEFAULT_PROPERTIES = new Properties();
    PROPERTIES = new Properties();
  }

  public static PropertyFactory getINSTANCE() {
    return INSTANCE;
  }

  public static void firePropertyChange(String propertyName, Object oldValue, Object newValue) {
    getINSTANCE().firePropertyChangeOnInstance(propertyName, oldValue, newValue);
  }

  private void firePropertyChangeOnInstance(String propertyName, Object oldValue, Object newValue) {
    PROPERTY_CHANGE_SUPPORT.firePropertyChange(propertyName, oldValue, newValue);
  }

  public static final void addPropertyChangeListener(PropertyChangeListener l) {
    getINSTANCE().addPropertyChangeListenerToInstance(l);
  }

  private void addPropertyChangeListenerToInstance(PropertyChangeListener l) {
    PROPERTY_CHANGE_SUPPORT.addPropertyChangeListener(l);
  }

  public static final void removePropertyChangeListener(PropertyChangeListener l) {
    getINSTANCE().removePropertyChangeListenerToInstance(l);
  }

  private void removePropertyChangeListenerToInstance(PropertyChangeListener l) {
    PROPERTY_CHANGE_SUPPORT.removePropertyChangeListener(l);
  }


}
