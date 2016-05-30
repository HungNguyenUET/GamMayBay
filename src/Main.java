/**
 * Created by Thu Trang on 28/05/16.
 */
public class Main {
    public static void main(String[] args){
        GameWindow gameWindow = new GameWindow();
        Thread thread = new Thread(gameWindow);
        thread.start();
    }
}
