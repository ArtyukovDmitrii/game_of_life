package logic.objects;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Space {
    private int sizeX;
    private int sizeY;
    private final List<List<Box>> size;
    public int startCountBox;

    public void setStartCountBox(int startCountBox) {
        this.startCountBox = startCountBox;
    }

    public void setSizeX(int sizeX) {
        this.sizeX = sizeX;
    }

    public void setSizeY(int sizeY) {
        this.sizeY = sizeY;
    }

    public Space(int sizeX, int sizeY) {
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        this.size = new ArrayList<>(sizeX);
        for (int i = 0; i < sizeX; i++) {
            size.add(new ArrayList<>(sizeY));
            for (int j = 0; j < sizeY; j++) {
                size.get(i).add(new Box(i, j));
            }
        }
    }

    public void burnBox(int startCountBox) {
        for (int i = 0; i < startCountBox; i++) {
            Random random = new Random();
            size.get(random.nextInt(sizeX)).get(random.nextInt(sizeY)).isLife();
        }
    }

    public boolean countLifeNeighbor(int x, int y) {
        int counter = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if ((0 <= x + i && x + i < sizeX) && (0 <= y + j && y + j < sizeY)) {
                    if (size.get(x + i).get(y + j).isLifeNow() && !(i == 0 && j == 0)) {
                        counter++;
                    }
                }
            }
        }
        return counter == 3;
    }

    public void boxMustDeathOrLife() {
        List<List<Box>> sizeChange = new ArrayList<>(sizeX);
        for (int i = 0; i < sizeX; i++) {
            sizeChange.add(new ArrayList<>(sizeY));
            for (int j = 0; j < sizeY; j++) {
                sizeChange.get(i).add(new Box(i, j));
            }
        }
        for (int i = 0; i < sizeX; i++) {
            for (int j = 0; j < sizeY; j++) {
                if (size.get(i).get(j).isLifeNow()) {
                    if (!countLifeNeighbor(i, j)) {
                        sizeChange.get(i).get(j).isLife();
                    }
                } else {
                    if (countLifeNeighbor(i, j)) {
                        sizeChange.get(i).get(j).isLife();
                    }
                }
            }
        }
        for (int i = 0; i < sizeX; i++) {
            for (int j = 0; j < sizeY; j++) {
                if (sizeChange.get(i).get(j).isLifeNow()) {
                    if (size.get(i).get(j).isLifeNow()) {
                        size.get(i).set(j, new Box(i, j));
                    }else {
                        size.get(i).get(j).isLife();
                    }
                }
            }
        }
    }

}


