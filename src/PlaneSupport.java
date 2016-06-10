import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Thu Trang on 08/06/16.
 */
public class PlaneSupport extends Plane implements ISupport {
    int count = 0;
    public PlaneSupport(int positionX, int positionY, String strFileImage) {
        super(positionX, positionY, strFileImage);
    }



    @Override
    public void bonusHP(List<Plane> listPlane) {
        if(this.count == 60){
            count = 0;
            for(Plane currentPlane : listPlane){
                if(kc(((Plane)currentPlane).positionX, ((Plane)currentPlane).positionY, this.positionX, this.positionY) <= 100){
                    if(((Plane) currentPlane).healthPoint < ((Plane) currentPlane).maxHP){
                        ((Plane)currentPlane).healthPoint += 10;
                    }
                }
            }
        }
        count++;
    }

    public double kc(int x1, int y1, int x2, int y2){
        return Math.sqrt((x1 - x2)*(x1 - x2) + (y1 - y2)*(y1 - y2));
    }

    @Override
    public void bunusHp(Plane plane) {
        plane.healthPoint += 10;
    }

    public void up(){
        this.speedY = -3;
        this.speedX = 0;
    }

    public void down(){
        this.speedY = 3;
        this.speedX = 0;
    }

    public void right(){
        this.speedX = 3;
        this.speedY = 0;
    }

    public void left(){
        this.speedX = -3;
        this.speedY = 0;
    }

    public  void stop(){
        this.speedY = 0;
        this.speedX = 0;
    }

    @Override
    public void update() {
        this.positionX += this.speedX;
        this.positionY += this.speedY;
    }

    public void update(ArrayList<Plane> listEnemy){
        this.positionX += this.speedX;
        this.positionY += this.speedY;
        dinhDan(listEnemy);
    }

    @Override
    public void dinhDan(ArrayList<Plane> listPlane) {
        Rectangle rectDan;
        Rectangle myPlane = new Rectangle(this.positionX, this.positionY
                , this.image.getWidth(), this.image.getHeight());
        for(Plane currentEnemy : listPlane){
            for(Dan currentDan : ((Enemy)currentEnemy).listDan){
                rectDan = new Rectangle(currentDan.positionX,currentDan.positionY,
                        currentDan.image.getWidth(), currentDan.image.getHeight());
                if (myPlane.intersects(rectDan)){
                    this.healthPoint -= 5;
                    currentDan.positionY += 300;
                }
            }
        }
    }

    @Override
    public void anQua(Gift gift, ArrayList<Plane> listFighter) {
        //super.anQua(gift);
        Rectangle recGift = new Rectangle(gift.positionX, gift.positionY, gift.giftImage.getWidth(), gift.giftImage.getHeight());
        Rectangle recPlane = new Rectangle(this.positionX, this.positionY, this.image.getWidth(), this.image.getHeight());
        if(recPlane.intersects(recGift)){
            gift.live = false;
            gift.positionY = 500;
            for(Plane currentPlane : listFighter){
                if(currentPlane.healthPoint < currentPlane.maxHP){
                    currentPlane.healthPoint += 30;
                    currentPlane.healthPoint = currentPlane.healthPoint - (currentPlane.healthPoint%currentPlane.maxHP);
                }
            }
        }
    }
}
