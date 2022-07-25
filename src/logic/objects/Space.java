package logic.objects;

import java.util.ArrayList;
import java.util.List;

public class Space {
    private int sizeX;
    private int sizeY;
    private List<List<Box>> size;
    private int startCountBox;

    public void setStartCountBox(int startCountBox) {
        this.startCountBox = startCountBox;
    }

    public void setSizeX(int sizeX) {
        this.sizeX = sizeX;
    }

    public Space(int sizeX, int sizeY) {
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        this.size = new ArrayList<>(sizeX);
        for (int i = 0; i < sizeX; i++) {
            size.set(i, new ArrayList<>(sizeY));
        }
    }

    public void setSizeY(int sizeY) {
        this.sizeY = sizeY;
    }

    private void lifeBox() {
    }
}


