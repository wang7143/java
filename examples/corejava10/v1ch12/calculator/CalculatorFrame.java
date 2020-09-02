package examples.corejava10.v1ch12.calculator;

import javax.swing.*;

/**
 * A frame with a calculator panel.
 */
public class CalculatorFrame extends JFrame
{
   /**
    *
    */
   private static final long serialVersionUID = 6020872685017339002L;

   public CalculatorFrame()
   {
      add(new CalculatorPanel());
      pack();
   }
}
