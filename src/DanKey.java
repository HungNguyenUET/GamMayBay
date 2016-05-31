/**
 * Created by Hung Nguyen on 29/05/16.
 */

//Lop dinh nghia Dan cua Máy bay di chuyen bang Key
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
