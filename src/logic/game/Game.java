package logic.game;

import logic.objects.Box;
import logic.objects.Space;

import java.util.Random;

public class Game {
    private Space gameSpace;

    public void createSpace(int spaceX, int spaceY){
        gameSpace = new Space(spaceX, spaceY);
    }

    public void count(int count){
        gameSpace.setStartCountBox(count);
    }

    public void randomPlacement(){
        Random random = new Random();
        int x = random.nextInt();
        int y = random.nextInt();
        Box place = new Box(x,y);
    }

    public void start(){
        while (true){
        }
    }
}
