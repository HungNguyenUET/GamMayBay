import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Hung Nguyen on 29/05/16.
 */
//L?p superclass cho các ki?u Máy bay
public class Plane {
    public int positionX, positionY;
    public BufferedImage image;
    public int healthPoint = 10;
    public int speedX, speedY;
    int maxHP;
    Image thanhMau;
    int danNumber = 0;
    int boomNumver = 0;

    public Plane(int positionX, int positionY, String strFileImage){
        this.positionX = positionX;
        this.positionY = positionY;
        healthPoint = 69;
        maxHP = 69;
        try {
            this.image = ImageIO.read(new File(strFileImage));
            this.thanhMau = ImageIO.read(new File("Resources/thanhMau.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void drawPlane(BufferedImage bufferedImage){
        Graphics bufferGraphics = bufferedImage.getGraphics();
        bufferGraphics.drawImage(image, positionX, positionY, null);
        bufferGraphics.drawImage(thanhMau, this.positionX, this.positionY +65, this.healthPoint, 6, null);

    }

    public void dinhDan(ArrayList<Plane> listPlane){

    }

    public void update(){

    }

    public void anQua(Gift gift){

    }

    public void anQua(Gift gift, ArrayList<Plane> listFighter){

    }

    public void update(ArrayList<Plane> listPlane){}

}
