package logic.objects;

public class Box {
    private int x;
    private int y;
    private boolean life;
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setLife(boolean life) {
        this.life = life;
    }

    public Box(int x, int y) {
        this.x = x;
        this.y = y;
        this.life = false;
    }

    public void isLife (){
        life = true;
    }

    public boolean isLifeNow(){
        return life;
    }
}
