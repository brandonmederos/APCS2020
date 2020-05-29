
package Images;

import java.net.URL;
import javax.swing.ImageIcon;

/*
 * This Class is used as a custom image class which stores where the 
 * image is located an a string attached to the image
 */
@SuppressWarnings("serial")
public class CustImage extends ImageIcon
{
    private String _s;
    private URL _f;
    
    public CustImage(String s, URL f) {
    	_s = s;
        _f = f;
    }
    
    public String getName() {
        return _s;
    }
    
    public URL getURL() {
        return _f;
    }
}
