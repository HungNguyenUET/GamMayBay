import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

/**
 * Created by Thu Trang on 07/06/16.
 */
public class DanEnemy extends Dan {
    public DanEnemy(int positionX, int positionY) {
        super(positionX, positionY);
        try {
            image = ImageIO.read(new File("Resources/danEnemy.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    @Override
    public void update() {
        super.update();
        move();
    }
}
