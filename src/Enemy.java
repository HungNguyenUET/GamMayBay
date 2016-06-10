import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 * Created by Thu Trang on 07/06/16.
 */
public class Enemy extends Plane implements IFighter,IRocket{
    int j = 0;
    public static ArrayList<DanEnemy> listDan = new ArrayList<>();
    int danNumber = 0;

    public Enemy(int positionX, int positionY, String strFileImage, int j) {
        super(positionX, positionY, strFileImage);
        this.healthPoint = 69;
        this.speedX = 3;
        this.j = j;
    }

    @Override
    public void dropBoom() {

    }

    @Override
    public void dinhDan(ArrayList<Plane> listPlane) {
        Rectangle rectDan;
        Rectangle myPlane = new Rectangle(this.positionX, this.positionY
                , this.image.getWidth(), this.image.getHeight());
        for(Plane currentEnemy : listPlane){
            for(Dan currentDan : ((IFighter)currentEnemy).listDan){
                rectDan = new Rectangle(currentDan.positionX,currentDan.positionY,
                        currentDan.image.getWidth(), currentDan.image.getHeight());
                if (myPlane.intersects(rectDan)){
                    this.healthPoint -= 5;
                    currentDan.positionY -= 300;
                }
            }
        }
    }

    @Override
    public void banDan() {
        listDan.add(danNumber, new DanEnemy(this.positionX + 24, this.positionY + 20));
        listDan.get(danNumber).speedY = 3;
        danNumber++;
    }

    @Override
    public void tangMau() {

    }

    @Override
    public void drawPlane(BufferedImage bufferedImage) {
        Graphics bufferGraphics = bufferedImage.getGraphics();
        bufferGraphics.drawImage(image, positionX, positionY, null);
        bufferGraphics.drawImage(thanhMau, this.positionX, this.positionY - 12, this.healthPoint, 6, null);
        for(Dan currentDan :listDan) {
            bufferGraphics.drawImage(currentDan.image, currentDan.positionX, currentDan.positionY, null);
        }
    }

    public void move(){
        if(this.positionX <= 5){
            this.speedX = 3;
        }else{
            if(this.positionX >= 250){
                this.speedX = -3;
            }
        }
        this.positionX += speedX;
    }
    @Override
    public void update() {
        super.update();
        move();
        if(j == 60){
            banDan();
            j = 0;
        }
        j++;
        for(DanEnemy danEnemyCurrent : listDan){
                danEnemyCurrent.update();
        }
    }

    @Override
    public void update(ArrayList<Plane> listPlane) {
        super.update();
        move();
        if(j == 60){
            banDan();
            j = 0;
        }
        j++;
        for(DanEnemy danEnemyCurrent : listDan){
            danEnemyCurrent.update();
        }
        dinhDan(listPlane);
    }

    @Override
    public void planeDropBoom() {
        this.healthPoint = this.healthPoint/2;
    }
}
