import java.util.ArrayList;

/**
 * Created by Thu Trang on 07/06/16.
 */
public class Enemy extends Plane implements IFighter{
    int speed = 3;
    int j = 0;
    public static ArrayList<DanEnemy> listDan = new ArrayList<>();
    int danNumber = 0;

    public Enemy(int positionX, int positionY, String strFileImage) {
        super(positionX, positionY, strFileImage);
    }

    @Override
    public void dropBoom() {

    }

    public void move(){
        if(this.positionX == 5){
            this.speed = 3;
        }else{
            if(this.positionX > 250){
                this.speed = -3;
            }
        }
        this.positionX += speed;
    }

    public void banDan(){
        listDan.add(danNumber, new DanEnemy(this.positionX + 24, this.positionY + 20));
        listDan.get(danNumber).speedY = 3;
        System.out.println(listDan.get(danNumber).positionY + " " + listDan.get(danNumber).speedY);
        danNumber++;
        System.out.println("dinh cong manh" + danNumber + " " + listDan.size());
    }

    public void xoaDan(){
        if(danNumber >= 10){
            danNumber = danNumber % 10;
        }
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
        xoaDan();
    }
}
