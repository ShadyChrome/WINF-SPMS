package com.java.test;

import com.java.components.IntegerTextFieldFX;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotSame;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CompontentTest {

  @Rule
  public final ExpectedException exception = ExpectedException.none();

  @Test
  public void testIntegerTextField() {
    IntegerTextFieldFX tfClassic = new IntegerTextFieldFX("45ads");
    assertFalse(tfClassic.validate(tfClassic.getText()));
    exception.expect(NumberFormatException.class);
    tfClassic.getNumberInt();

    IntegerTextFieldFX tfMock = mock(IntegerTextFieldFX.class);
    when(tfMock.getText()).thenReturn("45ads");
    when(tfMock.getNumberInt()).thenReturn(Integer.parseInt(tfMock.getText()));

    assertFalse(tfMock.validate(tfMock.getText()));
    assertEquals(tfClassic.getText(), tfMock.getText());
    assertEquals(tfClassic.getText(), tfMock.getText());

    tfClassic.setText("100");
    when(tfMock.getText()).thenReturn("100");

    assertEquals(tfClassic.getNumberInt(), tfMock.getNumberInt());
  }
}
