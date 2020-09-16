package examples.corejava10.v1ch13.applet;

import java.awt.*;
import javax.swing.*;

/**
 * @version 1.24 2015-06-12
 * @author Cay Horstmann
 */
public class NotHelloWorld extends JApplet
{
   /**
    *
    */
   private static final long serialVersionUID = 1L;

   public void init()
   {
      EventQueue.invokeLater(() -> {
         JLabel label = new JLabel("Not a Hello, World applet",
               SwingConstants.CENTER);
         add(label);
      });
   }
}