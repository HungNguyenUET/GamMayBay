/**
 * Created by Hung Nguyen on 29/05/16.
 */
//Lop này dinh nghia kieu Máy bay di chuyen bang Mouse
public class PlaneMouse extends Plane {
    public PlaneMouse(int positionX, int positionY, String strFileImage) {
        super(positionX, positionY, strFileImage);
        speedY = 100;
        speedX = 200;
    }

    @Override
    public void update() {
        positionX = speedX;
        positionY = speedY;
    }
}
