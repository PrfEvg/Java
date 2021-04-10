package lesson1;

public class Robot implements JumpAndRun{
    private int maxHeight;
    private int maxLength;
    private String name;
    public Robot(int maxHeight, int maxLength, String name){
        this.maxHeight = maxHeight;
        this.maxLength = maxLength;
        this.name = name;
    }

    @Override
    public int goMaxHeight() {
        return maxHeight;
    }

    @Override
    public void jump() {
        System.out.println("Робот прыгает.");
    }

    @Override
    public int goMaxLength() {
        return maxLength;
    }

    @Override
    public void run() {
        System.out.println("Робот бежит.");
    }

    @Override
    public String toString() {
        return name;
    }
}
