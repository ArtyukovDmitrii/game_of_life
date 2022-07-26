package logic.objects;

public class Box {
    private boolean life;

    public Box() {
        this.life = false;
    }

    public void isLife (){
        life = true;
    }

    public boolean isLifeNow(){
        return life;
    }
}
