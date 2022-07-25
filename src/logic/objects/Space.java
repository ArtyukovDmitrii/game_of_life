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
            size.set(i, new ArrayList<>(sizeY));
            for (int j = 0; j < sizeY; j++) {
                size.get(i).add(new Box(i,j));
            }
        }
    }

    public void burnBox(int startCountBox){
        for (int i = 0; i < startCountBox; i++) {
            Random random = new Random();
            size.get(random.nextInt() % sizeX).get(random.nextInt()%sizeY).isLife();
        }
    }

    private void boxMustDeath(){
        List<List<Box>> sizeRemove = new ArrayList<>(sizeX);
        for (int i = 0; i < sizeX; i++) {
            sizeRemove.set(i, new ArrayList<>(sizeY));
            for (int j = 0; j < sizeY; j++) {
                sizeRemove.get(i).add(new Box(i,j));
            }
        }
        for (int i = 0; i < sizeX; i++) {
            for (int j = 0; j < sizeY; j++) {
                if(size.get(i).get(j).isLifeNow()){
                    int t = 0;
                    if(size.get(i-1).get(j).isLifeNow()) t++;
                    if(size.get(i-1).get(j-1).isLifeNow()) t++;
                    if(size.get(i-1).get(j+1).isLifeNow()) t++;
                    if(size.get(i+1).get(j).isLifeNow()) t++;
                    if(size.get(i+1).get(j-1).isLifeNow()) t++;
                    if(size.get(i+1).get(j+1).isLifeNow()) t++;
                    if(size.get(i).get(j-1).isLifeNow()) t++;
                    if(size.get(i).get(j+1).isLifeNow()) t++;
                    if(t!=3){
                        sizeRemove.get(i).get(j).isLife();
                    }
                }
            }
        }
        for (int i = 0; i < sizeX; i++) {
            for (int j = 0; j < sizeY; j++) {
                if(sizeRemove.get(i).get(j).isLifeNow()){
                    if(size.get(i).get(j).isLifeNow()){
                        size.get(i).add(new Box(i,j));
                    }
                }
            }
        }
    }

    private void boxMustLife(){
        List<List<Box>> sizeRemove = new ArrayList<>(sizeX);
        for (int i = 0; i < sizeX; i++) {
            sizeRemove.set(i, new ArrayList<>(sizeY));
            for (int j = 0; j < sizeY; j++) {
                sizeRemove.get(i).add(new Box(i,j));
            }
        }
        for (int i = 0; i < sizeX; i++) {
            for (int j = 0; j < sizeY; j++) {
                if(!size.get(i).get(j).isLifeNow()){
                    int t = 0;
                    if(size.get(i-1).get(j).isLifeNow()) t++;
                    if(size.get(i-1).get(j-1).isLifeNow()) t++;
                    if(size.get(i-1).get(j+1).isLifeNow()) t++;
                    if(size.get(i+1).get(j).isLifeNow()) t++;
                    if(size.get(i+1).get(j-1).isLifeNow()) t++;
                    if(size.get(i+1).get(j+1).isLifeNow()) t++;
                    if(size.get(i).get(j-1).isLifeNow()) t++;
                    if(size.get(i).get(j+1).isLifeNow()) t++;
                    if(t==3){
                        sizeRemove.get(i).get(j).isLife();
                    }
                }
            }
        }
        for (int i = 0; i < sizeX; i++) {
            for (int j = 0; j < sizeY; j++) {
                if(sizeRemove.get(i).get(j).isLifeNow()){
                    if(!size.get(i).get(j).isLifeNow()){
                        size.get(i).get(j).isLife();
                    }
                }
            }
        }
    }
}


