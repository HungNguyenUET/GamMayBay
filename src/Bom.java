import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * Created by Thu Trang on 05/06/16.
 */
public class Bom {
    int speedX, speedY;
    public Image bomImg;
    int positionX, positionY;
    public Bom(int positionX, int positionY, String strBomImg) {
        this.positionX = positionX;
        this.positionY = positionY;
        try {
            this.bomImg = ImageIO.read(new File(strBomImg));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void update(){
        positionY += speedY;
    }
}
