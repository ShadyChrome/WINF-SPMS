package com.java.page;

import com.java.components.TableViewMeilensteine;
import com.java.data.DataController;
import javafx.scene.Node;

public class NeuesDashboardPage implements TabPages {

  @Override
  public Node getLeftNode() {
    return null;
  }

  @Override
  public Node getCenterNode() {
    return new TableViewMeilensteine(DataController.getINSTANCE().getMeilensteinList());
  }
}
