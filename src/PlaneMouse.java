/**
 * Created by Hung Nguyen on 29/05/16.
 */
//L?p n�y ??nh ngh?a ki?u M�y bay di chuy?n b?ng Mouse
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
