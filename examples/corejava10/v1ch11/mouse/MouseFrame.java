package examples.corejava10.v1ch11.mouse;

import javax.swing.*;

/**
 * A frame containing a panel for testing mouse operations
 */
public class MouseFrame extends JFrame
{
   /**
    *
    */
   private static final long serialVersionUID = 7642670425233151449L;

   public MouseFrame()
   {
      add(new MouseComponent());
      pack();
   }
}