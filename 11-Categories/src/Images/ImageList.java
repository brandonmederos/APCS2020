package Images;

import resources.EmptyClass;
import javax.swing.ImageIcon;

/*
 * This class instantiates all the images for the project
 */
public class ImageList{

    public static ImageIcon sword = new ImageIcon(EmptyClass.class.getResource("sword.png"));
    public static ImageIcon pen = new ImageIcon(EmptyClass.class.getResource("pen.png"));
    public static ImageIcon shield = new ImageIcon(EmptyClass.class.getResource("shield.png"));
    public static ImageIcon scroll = new ImageIcon(EmptyClass.class.getResource("scroll.png"));
    public static ImageIcon mace = new ImageIcon(EmptyClass.class.getResource("mace.png"));
    public static ImageIcon exit = new ImageIcon(EmptyClass.class.getResource("exit.png"));
    public static ImageIcon ai = new ImageIcon(EmptyClass.class.getResource("ai.gif"));
    public static ImageIcon beatai = new ImageIcon(EmptyClass.class.getResource("beatai.gif"));
    public static ImageIcon loss = new ImageIcon(EmptyClass.class.getResource("lost.gif"));
    public static ImageIcon win = new ImageIcon(EmptyClass.class.getResource("win.gif"));
    public static ImageIcon tie = new ImageIcon(EmptyClass.class.getResource("tie.gif"));

}
