package logic.game;

import logic.objects.Box;
import logic.objects.Space;

import java.util.Random;

public class Game {
    private Space gameSpace;

    private void createSpace(int spaceX, int spaceY) {
        gameSpace = new Space(spaceX, spaceY);
    }

    private void count(int count) {
        gameSpace.setStartCountBox(count);
    }

    public Game(int sizeX, int sizeY, int count) {
        createSpace(sizeX, sizeY);
        count(count);
    }

    public void start() {
        gameSpace.burnBox(gameSpace.startCountBox);
        while (!gameSpace.GameOver()) {
            gameSpace.boxMustDeathOrLife();
        }
    }
}
