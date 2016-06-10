import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 * Created by Hung Nguyen on 29/05/16.
 */
//Lop này dinh nghia kieu Máy bay di chuyen bang Mouse
public class PlaneMouse extends Plane implements  IFighter{
    ArrayList<IRocket> listRocket = new ArrayList<>();
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

    public void update(ArrayList<Plane> listEnemy){
        this.positionX = this.speedX;
        this.positionY = this.speedY;
        dinhDan(listEnemy);
    }

    public void move(MouseEvent e){
        this.speedX = e.getX();
        this.speedY = e.getY();
    }

    @Override
    public void dropBoom() {
        listBom.add(boomNumver, new Bom(this.positionX, this.positionY));
        listBom.get(boomNumver).speedY = 3;
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
    public void tangMau() {
        this.healthPoint += 30;
        this.healthPoint = this.healthPoint - (this.healthPoint%this.maxHP);
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
}
