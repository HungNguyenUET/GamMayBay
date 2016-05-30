import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by Hung Nguyen on 29/05/16.
 */
//L?p superclass cho các ki?u Máy bay
public class Plane {
    public int positionX, positionY;
    public BufferedImage image;
    public int damage;
    public int healthPoint;
    public int speedX, speedY;
    boolean mouse;

    public Plane(int positionX, int positionY, String strFileImage){
        this.positionX = positionX;
        this.positionY = positionY;
        try {
            this.image = ImageIO.read(new File(strFileImage));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void update(){

    }

}
