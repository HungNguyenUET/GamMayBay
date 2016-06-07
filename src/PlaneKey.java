import java.util.List;

/**
 * Created by Hung Nguyen on 29/05/16.
 */
//Lop dinh nghia kieu Máy bay dieu khien bang Key
public class PlaneKey extends Plane implements ISupport{
    public PlaneKey(int positionX, int positionY, String strFileImage) {
        super(positionX, positionY, strFileImage);
    }

    @Override
    public void update() {
        //super.update();
        this.positionX += this.speedX;
        this.positionY += this.speedY;
    }

    @Override
    public void bonusHP(List<Plane> listPlane) {
        for(Plane plane : listPlane){
            plane.healthPoint += 10;
        }
    }

    @Override
    public void bunusHp(Plane plane) {
           plane.healthPoint += 10;
    }
}
