import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hung Nguyen on 29/05/16.
 */
//Lop dinh nghia kieu May bay dieu khien bang Key
public class PlaneKey extends Plane implements IFighter, ISubject{
    ArrayList<IRocket> listRocket = new ArrayList<>();
    public PlaneKey(int positionX, int positionY, String strFileImage) {
        super(positionX, positionY, strFileImage);
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
        this.speedY = 0;}

    public  void stop(){
        this.speedY = 0;
        this.speedX = 0;
    }

    @Override
    public void addRocket(IRocket iRocketListener) {
        listRocket.add(iRocketListener);
    }

    @Override
    public void deleteRocket(IRocket iRocketListener) {
        listRocket.remove(iRocketListener);
    }

    @Override
    public void dropBoom2s() {
        for(IRocket curentRocket : listRocket){
            curentRocket.planeDropBoom();
        }
    }

    @Override
    public void dropBoom() {
        listBom.add(boomNumver, new Bom(this.positionX, this.positionY));
        listBom.get(boomNumver).speedY = 1;
        boomNumver++;
        if(boomNumver >= 60){
            boomNumver = boomNumver%60;
        }

    }

    @Override
    public void banDan() {
        listDan.add(danNumber, new Dan(this.positionX, this.positionY));
        listDan.get(danNumber).speedY = -3;
        danNumber++;
        if(danNumber >= 60){
            danNumber = danNumber % 60;
        }
    }

    @Override
    public void drawPlane(BufferedImage bufferedImage) {
        super.drawPlane(bufferedImage);
        for(Dan curretnDan : listDan){
            curretnDan.draw(bufferedImage);
        }
        for(Bom bomCurrent : listBom){
            bomCurrent.drawBom(bufferedImage);
        }
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
    public void anQua(Gift gift) {
        Rectangle recGift = new Rectangle(gift.positionX, gift.positionY, gift.giftImage.getWidth(), gift.giftImage.getHeight());
        Rectangle recPlane = new Rectangle(this.positionX, this.positionY, this.image.getWidth(), this.image.getHeight());
        if(recPlane.intersects(recGift)){
            gift.live = false;
            gift.positionY = 500;
            if(this.healthPoint < this.maxHP){
                this.healthPoint += 50;
                this.healthPoint = this.healthPoint - (this.healthPoint%this.maxHP);
            }
        }
    }
}
