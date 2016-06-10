import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by Thu Trang on 10/06/16.
 */
public class Gift {
    int positionX, positionY;
    BufferedImage giftImage;
    boolean live = true;

    public Gift(int positionX, int positionY) {
        this.positionX = positionX;
        this.positionY = positionY;
        this.live = true;
        try {
            giftImage = ImageIO.read(new File("Resources/gift2.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void draw(BufferedImage bufferedImage){
        Graphics g = bufferedImage.getGraphics();
        g.drawImage(giftImage, positionX, positionY, null);
    }
}
