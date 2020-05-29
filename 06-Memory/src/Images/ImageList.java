
package Images;

import resources.EmptyClass;
import javax.swing.ImageIcon;

/*
 * This Class instantiates all the Images used in the images used in the game
 */
public class ImageList {
	public static final ImageIcon BALLOON = new ImageIcon(EmptyClass.class.getResource("balloon.png"));
	public static final ImageIcon BANANA = new ImageIcon(EmptyClass.class.getResource("banana.png"));
	public static final ImageIcon GENIE = new ImageIcon(EmptyClass.class.getResource("genie.png"));
	public static final ImageIcon HAMSTER = new ImageIcon(EmptyClass.class.getResource("hamster.png"));
	public static final ImageIcon HEART = new ImageIcon(EmptyClass.class.getResource("heart.png"));
	public static final ImageIcon LION = new ImageIcon(EmptyClass.class.getResource("lion.png"));
	public static final ImageIcon MONEY = new ImageIcon(EmptyClass.class.getResource("money.png"));
	public static final ImageIcon SMOOTHIE = new ImageIcon(EmptyClass.class.getResource("smoothie.png"));
	public static final ImageIcon TREE = new ImageIcon(EmptyClass.class.getResource("tree.png"));
	public static final ImageIcon TRUCK = new ImageIcon(EmptyClass.class.getResource("truck.png"));
	public ImageIcon[] imageList;

	//Constructor Creates the imageList
	public ImageList() {
		imageList = new ImageIcon[] { ImageList.BALLOON, ImageList.BANANA, ImageList.GENIE, ImageList.HAMSTER,
				ImageList.HEART, ImageList.LION, ImageList.MONEY, ImageList.SMOOTHIE, ImageList.TREE, ImageList.TRUCK };
	}
	
	//This method is a getter for the Array of images 
	public ImageIcon[] getImages() {
		return imageList;
	}
}
