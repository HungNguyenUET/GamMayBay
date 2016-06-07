/**
 * Created by Thu Trang on 07/06/16.
 */
public class DanEnemy extends Dan {
    public DanEnemy(int positionX, int positionY) {
        super(positionX, positionY);
    }

    public void move(){
        positionY += speedY;
    }

    @Override
    public void update() {
        super.update();
        move();
    }
}
