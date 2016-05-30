/**
 * Created by Thu Trang on 29/05/16.
 */
//L?p ??nh ngh?a ki?u Máy bay ?i?u khi?n b?ng Key
public class PlaneKey extends Plane {
    public PlaneKey(int positionX, int positionY, String strFileImage) {
        super(positionX, positionY, strFileImage);
    }

    @Override
    public void update() {
        //super.update();
        this.positionX += this.speedX;
        this.positionY += this.speedY;
    }
}
