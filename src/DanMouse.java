/**
 * Created by Hung on 29/05/16.
 */

//L?p ??nh ngh?a ki?u ??n c?a Máy bay di chuy?n b?ng chu?t
public class DanMouse extends Dan {
    int fireSpeed;  //T?c ?? c?a ??n

    public DanMouse(int positionX, int positionY) {
        super(positionX, positionY);
        speedY = 100;
        speedX = 200;
    }

    @Override
    public void update() {
        super.update();
        if(fire == true){ //Khi ??n ?ang ? tr?ng thái b?n
            positionX = speedX + 29;
            this.positionY -= fireSpeed;
        }else{
            this.positionY = speedY + 10;
            this.positionX = speedX + 29;
        }
    }
}
