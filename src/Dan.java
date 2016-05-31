import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * Created by Hung Nguyen on 29/05/16.
 */
//Superclass cho các kieu Dan
public class Dan {
    Image image;
    int positionX;
    int positionY;
    int speedY = 0;
    int speedX = 0;
    boolean fire = false; //Gia tri xác dinh Dan có dang ban hay không

    public Dan(int positionX, int positionY){
        this.positionX = positionX;
        this.positionY = positionY;
        try {
            image = ImageIO.read(new File("Resources/DAN.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void update(){
    }
}
