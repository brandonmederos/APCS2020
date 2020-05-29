// 
// Decompiled by Procyon v0.5.36
// 

package Images;

import resources.EmptyClass;
import javax.swing.ImageIcon;

public class ImageList
{
    public static ImageIcon hilo;
    public static ImageIcon emh;
    
    static {
        ImageList.hilo = new ImageIcon(EmptyClass.class.getResource("hilo.gif"));
        ImageList.emh = new ImageIcon(EmptyClass.class.getResource("emh.png"));
    }
}
