import java.awt.*;

/**
 * Created by Hung Nguyen on 29/05/16.
 */
//Lop này dinh nghia kieu Máy bay di chuyen bang Mouse
public class PlaneMouse extends Plane implements IFighter{
    public PlaneMouse(int positionX, int positionY, String strFileImage) {
        super(positionX, positionY, strFileImage);
        speedY = 100;
        speedX = 200;
    }

    @Override
    public void update() {
        positionX = speedX;
        positionY = speedY;
        Rectangle myPlane = new Rectangle(this.positionX, this.positionY
                , this.image.getWidth(), this.image.getHeight());
        for(DanEnemy b : Enemy.listDan){
            Rectangle rectCurrentBullet = new Rectangle(b.positionX, b.positionY,
                    b.image.getWidth(), b.image.getHeight());

            if (myPlane.intersects(rectCurrentBullet)){
                this.healthPoint -= 5;
                Enemy.listDan.remove(b);
            }
        }
    }

    @Override
    public void dropBoom() {

    }
}
