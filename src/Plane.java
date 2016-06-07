import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
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
    public int healthPoint = 10;
    public int speedX, speedY;
    boolean mouse;
    int maxHP, curentHP;
    Image thanhMau;

    public Plane(int positionX, int positionY, String strFileImage){
        this.positionX = positionX;
        this.positionY = positionY;
        healthPoint = 10;
        maxHP = 100;
        try {
            this.image = ImageIO.read(new File(strFileImage));
            this.thanhMau = ImageIO.read(new File("Resources/thanhMau.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void update(){

    }

}
