import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by Thu Trang on 05/06/16.
 */
public class Bom {
    int speedX, speedY;
    public Image bomImg;
    int positionX, positionY;
    int boomTime = 0;

    public Bom(int positionX, int positionY) {
        this.positionX = positionX;
        this.positionY = positionY;
        try {
            this.bomImg = ImageIO.read(new File("Resources/bomb.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void drawBom(BufferedImage bufferedImage){
        Graphics g = bufferedImage.getGraphics();
        g.drawImage(bomImg, positionX, positionY, null);
    }


    public void update(){
        positionY += speedY;
    }
}
