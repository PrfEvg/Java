package lesson1;

public class Wall implements Obstacles{
    int height;
    public Wall(int height){
        this.height = height;
    }

    @Override
    public boolean toJump(int maxHeight) {

        return (maxHeight >= height);
    }

    @Override
    public boolean toRun(int maxLength) {

        return false;
    }

    @Override
    public String toString() {
        return "стену";
    }
}

