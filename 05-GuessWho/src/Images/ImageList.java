
package Images;

import javax.swing.ImageIcon;
import resources.EmptyClass;

public class ImageList {
    private static ImageIcon Alex = new ImageIcon(EmptyClass.class.getResource("Alex.png"));
    private static ImageIcon Alfred = new ImageIcon(EmptyClass.class.getResource("Alfred.png"));
    private static ImageIcon Anita = new ImageIcon(EmptyClass.class.getResource("Anita.png"));
    private static ImageIcon Anne = new ImageIcon(EmptyClass.class.getResource("Anne.png"));
    private static ImageIcon Bernard = new ImageIcon(EmptyClass.class.getResource("Bernard.png"));
    private static ImageIcon Bill = new ImageIcon(EmptyClass.class.getResource("Bill.png"));
    private static ImageIcon Charles = new ImageIcon(EmptyClass.class.getResource("Charles.png"));
    private static ImageIcon Claire = new ImageIcon(EmptyClass.class.getResource("Claire.png"));
    private static ImageIcon David = new ImageIcon(EmptyClass.class.getResource("David.png"));
    private static ImageIcon Eric = new ImageIcon(EmptyClass.class.getResource("Eric.png"));
    private static ImageIcon Frans = new ImageIcon(EmptyClass.class.getResource("Frans.png"));
    private static ImageIcon George = new ImageIcon(EmptyClass.class.getResource("George.png"));
    private static ImageIcon Herman = new ImageIcon(EmptyClass.class.getResource("Herman.png"));
    private static ImageIcon Joe = new ImageIcon(EmptyClass.class.getResource("Joe.png"));
    private static ImageIcon Maria = new ImageIcon(EmptyClass.class.getResource("Maria.png"));
    private static ImageIcon Max = new ImageIcon(EmptyClass.class.getResource("Max.png"));
    private static ImageIcon Paul = new ImageIcon(EmptyClass.class.getResource("Paul.png"));
    private static ImageIcon Peter = new ImageIcon(EmptyClass.class.getResource("Peter.png"));
    private static ImageIcon Philip = new ImageIcon(EmptyClass.class.getResource("Philip.png"));
    private static ImageIcon Richard = new ImageIcon(EmptyClass.class.getResource("Richard.png"));
    private static ImageIcon Robert = new ImageIcon(EmptyClass.class.getResource("Robert.png"));
    private static ImageIcon Sam = new ImageIcon(EmptyClass.class.getResource("Sam.png"));
    private static ImageIcon Susan = new ImageIcon(EmptyClass.class.getResource("Susan.png"));
    private static ImageIcon Tom = new ImageIcon(EmptyClass.class.getResource("Tom.png"));
    public ImageIcon[] imageList = new ImageIcon[]{Alex, Alfred, Anita, Anne, Bernard, Bill, Charles, Claire, David, Eric, Frans, George, Herman, Joe, Maria, Max, Paul, Peter, Philip, Richard, Robert, Sam, Susan, Tom};

    public ImageIcon[] getImageList() {
        return this.imageList;
    }
}

