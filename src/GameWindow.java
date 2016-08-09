import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Hung Nguyen on 28/05/16.
 */
public class GameWindow extends Frame implements Runnable{
    Image background;
    BufferedImage bufferedImage;
    PlaneKey player1;
    PlaneMouse player2;
    PlaneSupport player3;
    Gift gift;
    ArrayList<Plane> listFighter;
    ArrayList<Plane> listEnemy;
    ArrayList<IFighter> listTangMau;
    int count = 0;


    public GameWindow(){
        this.setSize(300, 400);
        this.setTitle("1932");
        this.setVisible(true);
        gift = new Gift(20, 200);
        count = 0;
        player3 = new PlaneSupport(150, 200, "Resources/PLANE2.png");
        player1 = new PlaneKey(100, 300, "Resources/PLANE4.png");
        player2 = new PlaneMouse(200, 100, "Resources/PLANE3.png");
        //Mang nay chua cac may bay chien dau duoc bonus mau khi o gan may bay support
        listFighter = new ArrayList<>();
        listFighter.add(0, player1);
        listFighter.add(1, player2);
        listEnemy = new ArrayList<>();
        listEnemy.add(0, new Enemy(5, 50, "Resources/PLANE1.png", 0));
        listEnemy.add(1, new Enemy(100, 60, "Resources/PLANE1.png", 20));
        listEnemy.add(2, new Enemy(200, 70, "Resources/PLANE1.png", 40));
        for(Plane curentEnemy: listEnemy){
            player1.addRocket((Enemy)curentEnemy);
        }
        listTangMau = new ArrayList<>();
        listTangMau.add(0, player1);
        listTangMau.add(1, player2);
        this.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {

            }

            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }

            @Override
            public void windowClosed(WindowEvent e) {

            }

            @Override
            public void windowIconified(WindowEvent e) {

            }

            @Override
            public void windowDeiconified(WindowEvent e) {

            }

            @Override
            public void windowActivated(WindowEvent e) {

            }

            @Override
            public void windowDeactivated(WindowEvent e) {

            }
        });
        this.addMouseMotionListener(new MouseMotionListener() {

            @Override
            public void mouseDragged(MouseEvent e) {
            }

            @Override
            public void mouseMoved(MouseEvent e) {
                player2.move(e);
            }
        });
        this.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON1) {
                    player2.banDan();
                }
                if(e.getButton() == MouseEvent.BUTTON3){
                    player2.dropBoom();
                }
            }

            //Make by Nguyen Van Hung UET
            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });
        this.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_D:
                        player1.right();
                        break;
                    case KeyEvent.VK_W:
                        player1.up();
                        break;
                    case KeyEvent.VK_A:
                        player1.left();
                        break;
                    //Make by Nguyen Van Hung UET
                    case KeyEvent.VK_S:
                        player1.down();
                        break;
                    //Nhan phim c�ch de ban
                    case (KeyEvent.VK_SPACE):
                        player1.banDan();
                        break;
                    case (KeyEvent.VK_F):
                        player1.dropBoom();
                        break;
                    case  (KeyEvent.VK_UP):
                        player3.up();
                        break;
                    case (KeyEvent.VK_DOWN):
                        player3.down();
                        break;
                    case  (KeyEvent.VK_RIGHT):
                        player3.right();
                        break;
                    case (KeyEvent.VK_LEFT):
                        player3.left();
                        break;
                }

            }

            @Override
            public void keyReleased(KeyEvent e) {
                player1.stop();
                player3.stop();

            }
        });
        try {
            background = ImageIO.read(new File("Resources/Background.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void update(Graphics g) {
        //Make by Nguyen Van Hung UET
        if(bufferedImage == null){
            bufferedImage = new BufferedImage(300, 400, 1);
        }
        Graphics buffGraphics = bufferedImage.getGraphics();
        buffGraphics.drawImage(background, 0, 0, null);
        if(player1.healthPoint > 0) {
            player1.drawPlane(bufferedImage);
        }
        if(player2.healthPoint > 0) {
            player2.drawPlane(bufferedImage);
        }
        if(player3.healthPoint > 0) {
            player3.drawPlane(bufferedImage);
        }
        for(Plane currentEnemy : listEnemy){
            if(currentEnemy.healthPoint > 0) {
                currentEnemy.drawPlane(bufferedImage);
            }else{
                if(count < 30){
                    currentEnemy.drawPlane(bufferedImage);
                }
            }
        }
        gift.draw(bufferedImage);
        g.drawImage(bufferedImage, 0, 0, null);
    }
    public void updateGame(){
        if(player1.healthPoint > 0) {
            player1.update(listEnemy);
        }else{
            player1.positionX = - 100;
        }

        if(player2.healthPoint > 0) {
            player2.update(listEnemy);
        }else{
            player2.positionX = -100;
        }

        if(player3.healthPoint > 0) {
            player3.update(listEnemy);
        }else{
            player3.positionY = -100;
        }

        for(Plane currentEnemy : listEnemy){
            if(currentEnemy.healthPoint > 0) {
                currentEnemy.update(listFighter);
            }else{
                count++;
                if(count > 30){
                    currentEnemy.positionX = -100;
                    System.out.println("no");
                }
            }
        }

        //Make by Nguyen Van Hung UET
        player3.bonusHP(listFighter);

        if(player1.listBom != null){
            for(Bom currentBom : player1.listBom){
                currentBom.update();
            }
        }
        if(player2.listBom != null){
            for(Bom currentBom : player2.listBom){
                currentBom.update();
            }
        }
        for(Dan currentDan : player1.listDan){
            currentDan.move();
        }
        for(Dan currentDan : player2.listDan){
            currentDan.move();
        }

        for(Bom currentBom : player1.listBom){
            if(currentBom.boomTime == 60){
                player1.dropBoom2s();
            }
            currentBom.boomTime++;
        }
        if(gift.live == true){
            player1.anQua(gift, listEnemy);
            player3.anQua(gift, listTangMau);
        }
    }

    public double kc(int x1, int y1, int x2, int y2){
        return Math.sqrt((x1 - x2)*(x1 - x2) + (y1 - y2)*(y1 - y2));
    }

    @Override
    public void run() {
        while(true){
            try {
                Thread.sleep(17);
                updateGame();
                repaint();
                System.out.println(count);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
