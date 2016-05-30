/**
 * Created by Hung Nguyen on 29/05/16.
 */

//L?p ??nh ngh?a ??n c?a Máy bay di chuy?n b?ng Key
public class DanKey extends Dan {
    public DanKey(int positionX, int positionY) {
        super(positionX, positionY);
    }

    @Override
    public void update() {
        super.update();
        positionX += speedX;
        positionY += speedY;
    }
}
