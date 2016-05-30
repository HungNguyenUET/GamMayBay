import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by Thu Trang on 28/05/16.
 */
public class GameWindow extends Frame implements Runnable{
    Image background;
    BufferedImage bufferedImage;
    PlaneKey player1;
    PlaneMouse player2;
    DanKey[] dan1 = new DanKey[100];
    DanMouse[] dan2 = new DanMouse[100];
    int i = 0;
    int turnKey = 0; //Xac dinh l??t b?n c?a ??i t??ng ??n nào
    int j = 0;
    int turnMouse = 0;//Xác ??nh l??t b?n c?a ??i t??ng ??n nào

    public GameWindow(){
        this.setSize(300, 400);
        this.setTitle("1932");
        this.setVisible(true);
        player1 = new PlaneKey(100, 300, "Resources/PLANE2.png");
        player2 = new PlaneMouse(200, 100, "Resources/PLANE3.png");
        //Kh?i t?o 100 ??i t??ng ??n cho Máy bay di chuy?n b?ng Key
        for(i = 0; i < 100; i++){
            dan1[i] = new DanKey(player1.positionX + 30, player1.positionY + 10);
        }
        //Kh?i t?o 100 d?i t??ng ??n cho máy bay di chuy?n b?ng Mouse
        for(j = 0; j < 100; j++) {
            dan2[j] = new DanMouse(player2.positionX + 30, player2.positionY + 10);
        }
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
                    player2.speedX = e.getX();
                    player2.speedY = e.getY();
                for(j = 0; j < 100; j++) {
                    if (dan2[j].fire == false) {
                        dan2[j].speedX = e.getX();
                        dan2[j].speedY = e.getY();

                    }else {
                        dan2[j].speedY = e.getY();
                        dan2[j].fireSpeed = 3;
                    }
                }
            }
        });
        this.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
                dan2[turnMouse].fire = true;
                dan2[turnMouse].fireSpeed = 3;
                //Dùng ?? b?n liên ti?p
                turnMouse++;
                turnMouse = turnMouse % 100;
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
                switch (e.getKeyCode()){
                    case  KeyEvent.VK_W:
                        player1.speedY = -3;
                        for(i = 0; i < 100; i++){
                            if(dan1[i].fire == false) {
                                dan1[i].speedY = -3;
                            }
                        }
                        break;
                    case  KeyEvent.VK_A:
                        player1.speedX = -3;
                        for(i = 0; i < 100; i++){
                            if(dan1[i].fire == false) {
                                dan1[i].speedX = -3;
                            }
                            else{
                                dan1[i].speedX = 0;
                            }
                        }
                        break;
                    //Make by Nguyen Van Hung UET
                    case KeyEvent.VK_S:
                        player1.speedY = 3;
                        for(i = 0; i < 100; i++) {
                            if(dan1[i].fire == false) {
                                dan1[i].speedY = 3;
                            }
                        }
                        break;
                    case KeyEvent.VK_D:
                        player1.speedX = 3;
                        for(i = 0; i < 100; i++) {
                            if(dan1[i].fire == false) {
                                dan1[i].speedX = 3;
                            }else{
                                dan1[i].speedX = 0;
                            }
                        }

                        break;
                    //Nh?n phím cách ?? b?n
                    case (KeyEvent.VK_SPACE):
                        dan1[turnKey].speedY = -3;
                        dan1[turnKey].fire = true;
                        turnKey++;
                        turnKey = turnKey % 100;
                        break;
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                player1.speedX = 0;
                player1.speedY = 0;
                for(i = 0; i < 100; i++) {
                    dan1[i].speedX = 0;
                    if (dan1[i].fire == true) {
                        dan1[i].speedY = -3;
                    } else {
                        dan1[i].speedY = 0;
                    }
                }

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
        for (i = 0; i < 100; i++) {
            buffGraphics.drawImage(dan1[i].image, dan1[i].positionX, dan1[i].positionY, null);
        }
        for(j = 0; j < 100; j++) {
            buffGraphics.drawImage(dan2[j].image, dan2[j].positionX, dan2[j].positionY, null);
        }
        buffGraphics.drawImage(player1.image, player1.positionX, player1.positionY, null);
        buffGraphics.drawImage(player2.image, player2.positionX, player2.positionY, null);
        g.drawImage(bufferedImage, 0, 0, null);
    }
    public void updateGame(){
        player1.update();
        player2.update();
        for(j = 0; j < 100; j++) {
            dan2[j].update();
            //Khi ??i t??ng ??n bay ra kh?i màn hình
            if (dan2[j].positionY < -10) {
                dan2[j].fire = false;
                dan2[j].fireSpeed = 0;
                dan2[j].speedX = player2.positionX;
            }
        }
        //Make by Nguyen Van Hung UET
        for(i = 0; i < 100; i++) {
            dan1[i].update();
            //Khi ??i t??ng ??n bay ra kh?i màn hình
            if (dan1[i].positionY < -10) {
                dan1[i].speedY = 0;
                dan1[i].fire = false;
            }
        }
    }

    @Override
    public void run() {
        while(true){
            try {
                Thread.sleep(17);
                updateGame();
                //Cai nay de ??i t??ng ??n bay ra ngoài khung hình tr? v? ?n d??i con Máy bay
                for(i = 0; i < 100; i++) {
                    if (dan1[i].fire == false && (dan1[i].positionX != player1.positionX || dan1[i].positionY != player1.positionY)) {
                        dan1[i].positionY = player1.positionY + 10;
                        dan1[i].positionX = player1.positionX + 30;
                    }
                }
                repaint();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
